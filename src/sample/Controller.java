package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private CheckBox RankSort;

    @FXML
    private TableView <Person> Table;

    @FXML
    private TextField PIDText;

    @FXML
    private TextField PNameText;

    @FXML
    private TextField BarcodeText;

    @FXML
    private TextField BrandText;

    @FXML
    private TextField SupplierText;

    @FXML
    private TextField ClassTypeText;

    @FXML
    private TextField UnitText;

    @FXML
    private Label PIDLabel;

    @FXML
    private Label PNameLabel;

    @FXML
    private Label BarcoedLabel;

    @FXML
    private Label BrandLabel;

    @FXML
    private Label SupplierLabel;

    @FXML
    private Label ClassTypeLabel;

    @FXML
    private Label UnitLabel;

    @FXML
    private Button PSearchButton;

    @FXML
    private TableView <Product> ProductTable;


    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;


    public Controller () throws SQLException, ClassNotFoundException {
        connection = DB_Connection.get_connection();
    }

    @FXML
    public void initialize()
    {
        CompText.setDisable(true);
        STText.setDisable(true);

        MenuItem item1 = new MenuItem("Staff");
        item1.setOnAction(event -> {TypeText.setText("Staff");
            CompText.setDisable(true);
            STText.setDisable(false);
        });
        MenuItem item2 = new MenuItem("Supplier");
        item2.setOnAction(event -> {TypeText.setText("Supplier");
            CompText.setDisable(false);
        });
        MenuItem item3 = new MenuItem("Customer");
        item3.setOnAction(event -> {TypeText.setText("Customer");
            CompText.setDisable(true);
            STText.setDisable(true);
        });
        TypeMenu.getItems().addAll(item1, item2, item3);
    }


    @FXML
    private void handleProductSearch(ActionEvent event) throws SQLException {
        List <String> Args = new ArrayList<String>();
        Args.add(PIDText.getText());
        Args.add(PNameText.getText());
        Args.add(BarcodeText.getText());
        Args.add(BrandText.getText());
        Args.add(ClassTypeText.getText());
        Args.add(UnitText.getText());
        Args.add(SupplierText.getText());

        String query = "select * from Production.Product as P, Production.ProductDetail as D, Production.ProductionSubClass as S, Production.Inventory as I, Person.Supplier as SU    where  P.ProductId = I.ProductId and P.productId = D.ProductId and P.SubClassId = S.ProductionSubClassId and D.SupplierId = SU.SupplierId";


        for (int i = 0; i < Args.size(); i++) {
            if (!Args.get(i).isEmpty()) {
                if (i == 0)
                    query += " and P.ProductId = ? ";
                 else if (i == 1)
                    query += " and ProductName = ? ";
                 else if (i == 2)
                    query += " and Barcode = ? ";
                 else if (i == 3)
                    query += " and Brand = ? ";
                else if (i == 4)
                    query += " and TypeName = ? ";
                else if (i == 5)
                    query += " and MeasureUnit = ? ";
                else if (i == 6)
                    query += " and LastName = ? ";
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


        if (resultSet.next() != false) {

            resultSet = statement.executeQuery();
            ObservableList<Product> data = FXCollections.observableArrayList();
            while (resultSet.next()) {
                List<String> list = new ArrayList<String>();
                list.add(resultSet.getString("ProductId"));
                list.add(resultSet.getString("ProductName"));
                list.add(resultSet.getString("Barcode"));
                list.add(resultSet.getString("Brand"));
                list.add(resultSet.getString("MeasureUnit"));
                list.add(resultSet.getString("ProductFee"));
                list.add(resultSet.getString("Inventory"));
                list.add(resultSet.getString("LastName"));
                list.add(resultSet.getString("BuyFee"));
                list.add(resultSet.getString("Discount"));
                list.add(resultSet.getString("TypeName"));

                data.add(new Product(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8), list.get(9), list.get(10)));
            }


            TableColumn ProductId = new TableColumn("Product ID");
            ProductId.setCellValueFactory(new PropertyValueFactory<>("ID"));

            TableColumn FName = new TableColumn("Product Name");
            FName.setCellValueFactory(new PropertyValueFactory<>("Name"));

            TableColumn Barcode = new TableColumn("Barcode");
            Barcode.setCellValueFactory(new PropertyValueFactory<>("Barcode"));

            TableColumn Brand = new TableColumn("Brand");
            Brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));

            TableColumn Unit = new TableColumn("Unit");
            Unit.setCellValueFactory(new PropertyValueFactory<>("Unit"));

            TableColumn Fee = new TableColumn("Fee");
            Fee.setCellValueFactory(new PropertyValueFactory<>("Fee"));

            TableColumn Inventory = new TableColumn("Inventory");
            Inventory.setCellValueFactory(new PropertyValueFactory<>("Inventory"));

            TableColumn Supplier = new TableColumn("Supplier");
            Supplier.setCellValueFactory(new PropertyValueFactory<>("Supplier"));

            TableColumn BuyFee = new TableColumn("BuyFee");
            BuyFee.setCellValueFactory(new PropertyValueFactory<>("BuyFee"));

            TableColumn Discount = new TableColumn("Discount");
            Discount.setCellValueFactory(new PropertyValueFactory<>("Discount"));

            TableColumn TypeName = new TableColumn("TypeName");
            TypeName.setCellValueFactory(new PropertyValueFactory<>("TypeName"));


            ProductTable.setItems(data);
            ProductTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            ProductTable.getColumns().setAll(ProductId, FName, Barcode, Brand, Unit, Fee, Inventory, Supplier, BuyFee, Discount, TypeName);
        }
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


        if (TypeText.getText().equals("Customer") || TypeText.getText().isEmpty()) {
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

            if (resultSet.next() != false) {

                ObservableList<Person> data = FXCollections.observableArrayList();
                while (resultSet.next()) {
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


                TableColumn ID = new TableColumn("Customer ID");
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
                Table.getColumns().setAll(ID, FName, LName, Gender, BirthDay, PhoneNumber, Dept);
            }
        }

        else if (TypeText.getText().equals("Staff")) {
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
                    } else if (i == 4) {
                        if (k != 0)
                            query += " and ";
                        query += " StaffTypeName = ? ";
                    }

                    k++;
                }
            }

            if (RankSort.isSelected())
                query += " order by Score";

            statement = connection.prepareStatement(query);

            int j = 0;
            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty())
                    statement.setString(++j, Args.get(i));
            }
            System.out.println(query);


            resultSet = statement.executeQuery();

            if (resultSet.next() != false)
            {
                ObservableList<Person> data = FXCollections.observableArrayList();
                 while (resultSet.next()) {
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


                TableColumn ID = new TableColumn("Staff ID");
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
                Table.getColumns().setAll(ID, FName, LName, Gender, PhoneNumber, BirthDay, Salary, Score, Type);
            }
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

            if (RankSort.isSelected())
                query += " order by Score";

            statement = connection.prepareStatement(query);

            int j = 0;
            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty())
                    statement.setString(++j, Args.get(i));
            }
            System.out.println(query);


            resultSet = statement.executeQuery();

            if (resultSet.next() != false) {
                ObservableList<Person> data = FXCollections.observableArrayList();
                while (resultSet.next()) {
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


                TableColumn ID = new TableColumn("Customer ID");
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
                Table.getColumns().setAll(ID, FName, LName, Gender, PhoneNumber, Company, Score);
            }

        }

        }
    }


