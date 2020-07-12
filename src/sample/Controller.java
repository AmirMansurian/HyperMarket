package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.security.auth.callback.Callback;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class Controller {

    @FXML
    private TextField IDText;

    @FXML
    private TextField FNameText;

    @FXML
    private TextField LNameText;

    @FXML
    private TextField NumberText;

    @FXML
    private TextField TypeText;

    @FXML
    private TextField CompText;

    @FXML
    private TextField STText;

    @FXML
    private Label IDLabel;

    @FXML
    private Label FNameLabel;

    @FXML
    private Label LNameLabel;

    @FXML
    private Label NumberLabel;

    @FXML
    private Label TypeLabel;

    @FXML
    private Label STLabel;

    @FXML
    private Label CompLabel;

    @FXML
    private Button SearchButton;

    @FXML
    private MenuButton TypeMenu;

    @FXML
    private MenuButton STMenu;

    @FXML
    private CheckBox RankSort;

    @FXML
    private TableView <Person> Table;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;


    public Controller () throws SQLException, ClassNotFoundException {
        connection = DB_Connection.get_connection();
    }

    @FXML
    public void initialize()
    {
        MenuItem item1 = new MenuItem("Staff");
        item1.setOnAction(event -> {TypeText.setText("Staff");});
        MenuItem item2 = new MenuItem("Supplier");
        item2.setOnAction(event -> {TypeText.setText("Supplier");});
        MenuItem item3 = new MenuItem("Customer");
        item3.setOnAction(event -> {TypeText.setText("Customer");});
        TypeMenu.getItems().addAll(item1, item2, item3);
    }


    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {

        List <String> Args = new ArrayList<String>();
        Args.add(IDText.getText());
        Args.add(FNameText.getText());
        Args.add(LNameText.getText());
        Args.add(NumberText.getText());
        String query = "select * from  ";

        if (TypeText.getText().isEmpty())
            query += "Person.Customer";
        else
            query += new String("Person." + TypeText.getText());

        if (TypeText.getText().equals("Staff"))
            query += " inner join Person.StaffType on (TypeId = StaffTypeId) ";
        else if (TypeText.getText().equals("Supplier"))
            query += " as S inner join Existence.Company as C on (S.CompanyId = C.CompanyId) ";


        if (TypeText.getText().equals("Customer")) {
            int flag = 0;
            int k = 0;
            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty()) {
                    if (flag == 0) {
                        query = query + " Where ";
                        flag = 1;
                    }

                    if (i == 0) {
                        if (k != 0)
                            query += " and ";
                        query += " CustomerId = ? ";
                    } else if (i == 1) {
                        if (k != 0)
                            query += " and ";
                        query += " FirstName = ? ";
                    } else if (i == 2) {
                        if (k != 0)
                            query += " and ";
                        query += " LastName = ? ";
                    } else if (i == 3) {
                        if (k != 0)
                            query += " and ";
                        query += " PhoneNumber = ? ";
                    }
                    k++;
                }
            }


            statement = connection.prepareStatement(query);

            int j = 0;
            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty())
                    statement.setString(++j, Args.get(i));
            }
            System.out.println(query);


            resultSet = statement.executeQuery();

            ObservableList <Person> data = FXCollections.observableArrayList();

            while(resultSet.next())
            {
                List<String> list = new ArrayList<String>();
                list.add(resultSet.getString("CustomerId"));
                list.add(resultSet.getString("FirstName"));
                list.add(resultSet.getString("LastName"));
                list.add(resultSet.getString("Gender"));
                list.add(resultSet.getString("BirthDay"));
                list.add(resultSet.getString("PhoneNumber"));
                list.add(resultSet.getString("Debt"));

                data.add(new Person(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6)));
            }


            TableColumn  ID = new TableColumn("Customer ID");
            ID.setCellValueFactory(new PropertyValueFactory<>("ID"));

            TableColumn FName = new TableColumn("First Name");
            FName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));

            TableColumn LName = new TableColumn("Last Name");
            LName.setCellValueFactory(new PropertyValueFactory<>("LastName"));

            TableColumn Gender = new TableColumn("Gender");
            Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));

            TableColumn BirthDay = new TableColumn("Birth Day");
            BirthDay.setCellValueFactory(new PropertyValueFactory<>("BirthDay"));

            TableColumn PhoneNumber = new TableColumn("Phone Number");
            PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

            TableColumn Dept = new TableColumn("Debt");
            Dept.setCellValueFactory(new PropertyValueFactory<>("Debt"));


            Table.setItems(data);
            Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            Table.getColumns().addAll(ID, FName, LName, Gender, BirthDay, PhoneNumber, Dept);
        }

        else if (TypeText.getText().equals("Staff"))
        {
            int flag = 0;
            int k = 0;
            Args.add(STText.getText());
            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty()) {
                    if (flag == 0) {
                        query = query + " Where ";
                        flag = 1;
                    }

                    if (i == 0) {
                        if (k != 0)
                            query += " and ";
                        query += " CustomerId = ? ";
                    } else if (i == 1) {
                        if (k != 0)
                            query += " and ";
                        query += " FirstName = ? ";
                    } else if (i == 2) {
                        if (k != 0)
                            query += " and ";
                        query += " LastName = ? ";
                    } else if (i == 3) {
                        if (k != 0)
                            query += " and ";
                        query += " PhoneNumber = ? ";
                    }

                    else if (i == 4)
                    {
                        if (k != 0)
                            query += " and ";
                        query += " StaffTypeName = ? ";
                    }

                    k++;
                }
            }


            statement = connection.prepareStatement(query);

            int j = 0;
            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty())
                    statement.setString(++j, Args.get(i));
            }
            System.out.println(query);


            resultSet = statement.executeQuery();

            ObservableList <Person> data = FXCollections.observableArrayList();

            while(resultSet.next())
            {
                List<String> list = new ArrayList<String>();
                list.add(resultSet.getString("StaffId"));
                list.add(resultSet.getString("FirstName"));
                list.add(resultSet.getString("LastName"));
                list.add(resultSet.getString("Gender"));
                list.add(resultSet.getString("PhoneNumber"));
                list.add(resultSet.getString("Salary"));
                list.add(resultSet.getString("Score"));
                list.add(resultSet.getString("StaffTypeName"));
                list.add(resultSet.getString("BithDay"));

                data.add(new Person(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(8), list.get(5), list.get(6), list.get(7)));
            }


            TableColumn  ID = new TableColumn("Staff ID");
            ID.setCellValueFactory(new PropertyValueFactory<>("ID"));

            TableColumn FName = new TableColumn("First Name");
            FName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));

            TableColumn LName = new TableColumn("Last Name");
            LName.setCellValueFactory(new PropertyValueFactory<>("LastName"));

            TableColumn Gender = new TableColumn("Gender");
            Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));

            TableColumn PhoneNumber = new TableColumn("Phone Number");
            PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

            TableColumn BirthDay = new TableColumn("Birth Day");
            BirthDay.setCellValueFactory(new PropertyValueFactory<>("BirthDay"));

            TableColumn Salary = new TableColumn("Salary");
            Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

            TableColumn Score = new TableColumn("Score");
            Score.setCellValueFactory(new PropertyValueFactory<>("Score"));

            TableColumn Type = new TableColumn("Type");
            Type.setCellValueFactory(new PropertyValueFactory<>("StaffTypeName"));


            Table.setItems(data);
            Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            Table.getColumns().addAll(ID, FName, LName, Gender, PhoneNumber, BirthDay, Salary, Score, Type);
        }

        else
        {
            int flag = 0;
            int k = 0;
            Args.add(CompText.getText());
            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty()) {
                    if (flag == 0) {
                        query = query + " Where ";
                        flag = 1;
                    }

                    if (i == 0) {
                        if (k != 0)
                            query += " and ";
                        query += " CustomerId = ? ";
                    } else if (i == 1) {
                        if (k != 0)
                            query += " and ";
                        query += " FirstName = ? ";
                    } else if (i == 2) {
                        if (k != 0)
                            query += " and ";
                        query += " LastName = ? ";
                    } else if (i == 3) {
                        if (k != 0)
                            query += " and ";
                        query += " PhoneNumber = ? ";
                    }

                    else if (i == 4)
                    {
                        if (k != 0)
                            query += " and ";
                        query += " CompanyName = ? ";
                    }

                    k++;
                }
            }


            statement = connection.prepareStatement(query);

            int j = 0;
            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty())
                    statement.setString(++j, Args.get(i));
            }
            System.out.println(query);


            resultSet = statement.executeQuery();

            ObservableList <Person> data = FXCollections.observableArrayList();

            while(resultSet.next())
            {
                List<String> list = new ArrayList<String>();
                list.add(resultSet.getString("SupplierId"));
                list.add(resultSet.getString("FirstName"));
                list.add(resultSet.getString("LastName"));
                list.add(resultSet.getString("Gender"));
                list.add(resultSet.getString("PhoneNumber"));
                list.add(resultSet.getString("CompanyName"));
                list.add(resultSet.getString("Score"));

                data.add(new Person(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), ""));
            }


            TableColumn  ID = new TableColumn("Customer ID");
            ID.setCellValueFactory(new PropertyValueFactory<>("ID"));

            TableColumn FName = new TableColumn("First Name");
            FName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));

            TableColumn LName = new TableColumn("Last Name");
            LName.setCellValueFactory(new PropertyValueFactory<>("LastName"));

            TableColumn Gender = new TableColumn("Gender");
            Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));

            TableColumn Company = new TableColumn("Company");
            Company.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));

            TableColumn PhoneNumber = new TableColumn("Phone Number");
            PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

            TableColumn Score = new TableColumn("Score");
            Score.setCellValueFactory(new PropertyValueFactory<>("Score"));


            Table.setItems(data);
            Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            Table.getColumns().addAll(ID, FName, LName, Gender, PhoneNumber, Company, Score);

        }







        }
    }

