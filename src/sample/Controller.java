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
    private Button SearchButton;

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
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {

        List <String> Args = new ArrayList<String>();
        Args.add(IDText.getText());
        Args.add(FNameText.getText());
        Args.add(LNameText.getText());
        Args.add(NumberText.getText());
        String query = "select * from Person.Customer ";

        int flag = 0;
        int k=0;
        for (int i=0; i< Args.size(); i++)
        {
            if (!Args.get(i).isEmpty())
            {
                if (flag == 0) {
                    query = query + " Where ";
                    flag = 1;
                }

                if (i == 0) {
                    if (k != 0)
                        query += " and ";
                    query += " CustomerId = ? ";
                }
                else if (i == 1) {
                    if (k != 0)
                        query += " and ";
                    query += " FirstName = ? ";
                }
                else if (i == 2) {
                    if (k != 0)
                        query += " and ";
                    query += " LastName = ? ";
                }
                else if (i ==3){
                    if (k != 0)
                        query += " and ";
                    query += " PhoneNumber = ? ";
                }
                k++;
            }
        }


        statement = connection.prepareStatement(query);

        int j=0;
        for (int i=0; i< Args.size(); i++)
        {
            if (!Args.get(i).isEmpty())
                statement.setString(++j, Args.get(i));
        }

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

       // System.out.println(data);

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

        TableColumn Dept = new TableColumn("Dept");
        Dept.setCellValueFactory(new PropertyValueFactory<>("Debt"));



        Table.setItems(data);
        Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Table.getColumns().addAll(ID, FName, LName, Gender, BirthDay, PhoneNumber, Dept);

        }
    }

