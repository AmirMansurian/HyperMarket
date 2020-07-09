package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
    private TableView table;

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

        TableColumn ID = new TableColumn("Customer ID");
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn FName = new TableColumn("First Name");
        TableColumn LName = new TableColumn("Last Name");
        TableColumn Gender = new TableColumn("Gender");
        TableColumn BirthDay = new TableColumn("Birth Day");
        TableColumn PhoneNumber = new TableColumn("Phone Number");
        TableColumn Dept = new TableColumn("Dept");


        table.getColumns().addAll(ID, FName, LName, Gender, BirthDay, PhoneNumber, Dept);

        while(resultSet.next())
        {

//             ID = new TableColumn(resultSet.getString("CustomerId"));
//             FName = new TableColumn(resultSet.getString("FirstName"));
//             LName = new TableColumn(resultSet.getString("LastName"));
//             Gender = new TableColumn(resultSet.getString("Gender"));
//             BirthDay = new TableColumn(resultSet.getString("BirthDay"));
//             PhoneNumber = new TableColumn(resultSet.getString("PhoneNumber"));
//             Dept = new TableColumn(resultSet.getString("Debt"));


            List<String> list = new ArrayList<String>();
            list.add(resultSet.getString("CustomerId"));
            list.add(resultSet.getString("FirstName"));
            list.add(resultSet.getString("LastName"));
            list.add(resultSet.getString("Gender"));
            list.add(resultSet.getString("BirthDay"));
            list.add(resultSet.getString("PhoneNumber"));
            list.add(resultSet.getString("Debt"));

           // System.out.println(list);
            ObservableList<String> observlist = FXCollections.observableList(list);

            System.out.println(observlist);

             table.setItems(observlist);
        }



        }
    }

