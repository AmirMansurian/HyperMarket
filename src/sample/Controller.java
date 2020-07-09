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
    private TextField inputtext;

    @FXML
    private TextArea outputtext;

    @FXML
    private Label outputlabel;

    @FXML
    private Label intputlabel;

    @FXML
    private Button button;

    @FXML
    private TableView <Person> table;

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

        String name = inputtext.getText();
        String query = "select * from Person.Customer";

        statement = connection.prepareStatement(query);
        //statement.setString(1, name);
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

        System.out.println(data);

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



        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(ID, FName, LName, Gender, BirthDay, PhoneNumber, Dept);

        }
    }

