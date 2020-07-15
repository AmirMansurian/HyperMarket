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
    private TableView <Product> ProductTable;

    @FXML
    private CheckBox CheckBox1;

    @FXML
    private CheckBox CheckBox2;

    @FXML
    private CheckBox CheckBox3;

    @FXML
    private CheckBox CheckBox4;

    @FXML
    private CheckBox CheckBox5;

    @FXML
    private TextField Barcode2Text;

    @FXML
    private TextField PName2Text;

    @FXML
    private TextField ClassText;

    @FXML
    private TextField Brand2Text;

    @FXML
    private TextField SDateText;

    @FXML
    private TextField EDateText;

    @FXML
    private TableView <Product> ProductReports;

    @FXML
    private TextField OrderText;

    @FXML
    private TextField CustomerText;

    @FXML
    private TextField CashierText;

    @FXML
    private TextField Supplier2Text;

    @FXML
    private TextField TransfreeText;

    @FXML
    private TextField SDText;

    @FXML
    private TextField EDText;

    @FXML
    private TextField PayText;

    @FXML
    private TableView <Order> OrderTable;

    @FXML
    private CheckBox SaleCheck;

    @FXML
    private CheckBox BuyCheck;



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
        Barcode2Text.setDisable(true);
        PName2Text.setDisable(true);
        Brand2Text.setDisable(true);
        ClassText.setDisable(true);
        SDateText.setDisable(true);
        EDateText.setDisable(true);
        CheckBox1.setSelected(true);

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

        CheckBox4.setOnAction(event -> {
            if (CheckBox4.isSelected()) {
                Barcode2Text.setDisable(false);
                PName2Text.setDisable(false);
                Brand2Text.setDisable(false);
                ClassText.setDisable(false);
                SDateText.setDisable(true);
                EDateText.setDisable(true);

                CheckBox1.setSelected(false);
                CheckBox2.setSelected(false);
                CheckBox3.setSelected(false);
                CheckBox5.setSelected(false);
            }
            else{
                CheckBox4.setSelected(true);
            }
        });

        CheckBox5.setOnAction(event -> {
            if (CheckBox5.isSelected()) {
                Barcode2Text.setDisable(false);
                PName2Text.setDisable(false);
                Brand2Text.setDisable(false);
                ClassText.setDisable(false);
                SDateText.setDisable(false);
                EDateText.setDisable(false);
                CheckBox1.setSelected(false);
                CheckBox2.setSelected(false);
                CheckBox3.setSelected(false);
                CheckBox4.setSelected(false);
            }
            else
                CheckBox5.setSelected(true);
        });

        CheckBox1.setOnAction(event -> {
            if (!CheckBox1.isSelected())
                CheckBox1.setSelected(true);
            Barcode2Text.setDisable(true);
            PName2Text.setDisable(true);
            Brand2Text.setDisable(true);
            ClassText.setDisable(true);
            SDateText.setDisable(true);
            EDateText.setDisable(true);
            CheckBox4.setSelected(false);
            CheckBox2.setSelected(false);
            CheckBox3.setSelected(false);
            CheckBox5.setSelected(false);
        });

        CheckBox2.setOnAction(event -> {
            if (!CheckBox2.isSelected())
                CheckBox2.setSelected(true);
            Barcode2Text.setDisable(true);
            PName2Text.setDisable(true);
            Brand2Text.setDisable(true);
            ClassText.setDisable(true);
            SDateText.setDisable(true);
            EDateText.setDisable(true);
            CheckBox1.setSelected(false);
            CheckBox4.setSelected(false);
            CheckBox3.setSelected(false);
            CheckBox5.setSelected(false);
        });

        CheckBox3.setOnAction(event -> {
            if (!CheckBox3.isSelected())
                CheckBox3.setSelected(true);
            Barcode2Text.setDisable(true);
            PName2Text.setDisable(true);
            Brand2Text.setDisable(true);
            ClassText.setDisable(true);
            SDateText.setDisable(true);
            EDateText.setDisable(true);
            CheckBox1.setSelected(false);
            CheckBox2.setSelected(false);
            CheckBox4.setSelected(false);
            CheckBox5.setSelected(false);
        });

        SaleCheck.setSelected(true);
        Supplier2Text.setDisable(true);
        TransfreeText.setDisable(true);

        SaleCheck.setOnAction(event -> {
            if (!SaleCheck.isSelected())
                SaleCheck.setSelected(true);
            else
            {
                BuyCheck.setSelected(false);
                Supplier2Text.setDisable(true);
                TransfreeText.setDisable(true);
                CustomerText.setDisable(false);
                CashierText.setDisable(false);
            }
        });

        BuyCheck.setOnAction(event -> {
            if (!BuyCheck.isSelected())
                BuyCheck.setSelected(true);
            else
            {
                SaleCheck.setSelected(false);
                Supplier2Text.setDisable(false);
                TransfreeText.setDisable(false);
                CustomerText.setDisable(true);
                CashierText.setDisable(true);
            }
        });
    }

    @FXML
    private void OrderHandler (ActionEvent event) throws  SQLException {
        if (SaleCheck.isSelected()) {
            List<String> Args = new ArrayList<String>();
            Args.add(OrderText.getText());
            Args.add(CashierText.getText());
            Args.add(CustomerText.getText());
            Args.add(PayText.getText());
            Args.add(SDText.getText());
            Args.add(EDText.getText());

            String query = "select  H.SaleId, H.CashierId, H.CustomerId, H.SaleStatus, H.PayType, H.Date, P.Barcode, P.ProductName, P.Brand, D.ProductQty, D.UnitPrice, H.Discount, H.FinalCost from Transactions.SaleHeader as H, Transactions.SaleDetail as D, Production.Product as P where H.SaleId = D.SaleId and P.ProductId = D.ProductId";

            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty()) {
                    if (i == 0)
                        query += " and H.SaleId = ? ";
                    else if (i == 1)
                        query += " and H.CashierId = ? ";
                    else if (i == 2)
                        query += " and H.CustomerId = ? ";
                    else if (i == 3)
                        query += " and H.PayType = ? ";
                    else if (i == 4)
                        query += " and H.Date >= ? ";
                    else if (i == 5)
                        query += " and H.Date <= ? ";
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
                ObservableList<Order> data = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    List<String> list = new ArrayList<String>();
                    list.add(resultSet.getString("SaleId"));
                    list.add(resultSet.getString("CashierId"));
                    list.add(resultSet.getString("CustomerId"));
                    list.add(resultSet.getString("SaleStatus"));
                    list.add(resultSet.getString("PayType"));
                    list.add(resultSet.getString("Date"));
                    list.add(resultSet.getString("Barcode"));
                    list.add(resultSet.getString("ProductName"));
                    list.add(resultSet.getString("Brand"));
                    list.add(resultSet.getString("ProductQty"));
                    list.add(resultSet.getString("UnitPrice"));
                    list.add(resultSet.getString("Discount"));
                    list.add(resultSet.getString("FinalCost"));

                    data.add(new Order(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12)));
                }

                TableColumn ID = new TableColumn("OrderID");
                ID.setCellValueFactory(new PropertyValueFactory<>("ID"));

                TableColumn Cashier = new TableColumn("CashierID");
                Cashier.setCellValueFactory(new PropertyValueFactory<>("Cashier"));

                TableColumn CustomerID = new TableColumn("CustomerID");
                CustomerID.setCellValueFactory(new PropertyValueFactory<>("Customer"));

                TableColumn SaleStatus = new TableColumn("SaleStatus");
                SaleStatus.setCellValueFactory(new PropertyValueFactory<>("SaleStatus"));

                TableColumn PayType = new TableColumn("PayType");
                PayType.setCellValueFactory(new PropertyValueFactory<>("PayType"));

                TableColumn Date = new TableColumn("Date");
                Date.setCellValueFactory(new PropertyValueFactory<>("Date"));

                TableColumn ProductBarcode = new TableColumn("Barcode");
                ProductBarcode.setCellValueFactory(new PropertyValueFactory<>("ProductBarcode"));

                TableColumn ProductName = new TableColumn("ProductName");
                ProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));

                TableColumn ProductBrand = new TableColumn("Brand");
                ProductBrand.setCellValueFactory(new PropertyValueFactory<>("ProductBrand"));

                TableColumn ProductQty = new TableColumn("Qty");
                ProductQty.setCellValueFactory(new PropertyValueFactory<>("ProductQty"));

                TableColumn UnitPrice = new TableColumn("UnitPrice");
                UnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));

                TableColumn TotalDiscount = new TableColumn("TotalDiscount");
                TotalDiscount.setCellValueFactory(new PropertyValueFactory<>("TotalDiscount"));

                TableColumn FinalCost = new TableColumn("FinalCost");
                FinalCost.setCellValueFactory(new PropertyValueFactory<>("FinalCost"));

                OrderTable.setItems(data);
                OrderTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                OrderTable.getColumns().setAll(ID, Cashier, CustomerID, SaleStatus, PayType, Date, ProductBarcode, ProductName, ProductBrand, ProductQty, UnitPrice, TotalDiscount, FinalCost);
            } else {
                OrderTable.getItems().setAll();
                OrderTable.getColumns().setAll();
            }
        } else if (BuyCheck.isSelected()) {
                List<String> Args = new ArrayList<String>();
                Args.add(OrderText.getText());
                Args.add(Supplier2Text.getText());
                Args.add(TransfreeText.getText());
                Args.add(PayText.getText());
                Args.add(SDText.getText());
                Args.add(EDText.getText());

                String query = "select  H.BuyId, H.SupplierId, H.TransfereeId, D.BuyPrice, H.PayType, H.Date, P.Barcode, P.ProductName, P.Brand, D.ProductQty, D.UnitPrice, H.Discount, H.FinalCost from Transactions.BuyHeader as H, Transactions.BuyDetail as D, Production.Product as P where H.BuyId = D.BuyId and P.ProductId = D.ProductId";

                for (int i = 0; i < Args.size(); i++) {
                    if (!Args.get(i).isEmpty()) {
                        if (i == 0)
                            query += " and H.BuyId = ? ";
                        else if (i == 1)
                            query += " and H.SupplierId = ? ";
                        else if (i == 2)
                            query += " and H.TransfereeId = ? ";
                        else if (i == 3)
                            query += " and H.PayType = ? ";
                        else if (i == 4)
                            query += " and H.Date >= ? ";
                        else if (i == 5)
                            query += " and H.Date <= ? ";
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
                    ObservableList<Order> data = FXCollections.observableArrayList();
                    while (resultSet.next()) {
                        List<String> list = new ArrayList<String>();
                        list.add(resultSet.getString("BuyId"));
                        list.add(resultSet.getString("SupplierId"));
                        list.add(resultSet.getString("TransfereeId"));
                        list.add(resultSet.getString("BuyPrice"));
                        list.add(resultSet.getString("PayType"));
                        list.add(resultSet.getString("Date"));
                        list.add(resultSet.getString("Barcode"));
                        list.add(resultSet.getString("ProductName"));
                        list.add(resultSet.getString("Brand"));
                        list.add(resultSet.getString("ProductQty"));
                        list.add(resultSet.getString("UnitPrice"));
                        list.add(resultSet.getString("Discount"));
                        list.add(resultSet.getString("FinalCost"));

                        data.add(new Order(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12)));
                    }

                    TableColumn ID = new TableColumn("OrderID");
                    ID.setCellValueFactory(new PropertyValueFactory<>("ID"));

                    TableColumn Cashier = new TableColumn("SupplierID");
                    Cashier.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));

                    TableColumn CustomerID = new TableColumn("CustomerID");
                    CustomerID.setCellValueFactory(new PropertyValueFactory<>("TransfreeID"));

                    TableColumn SaleStatus = new TableColumn("BuyPrice");
                    SaleStatus.setCellValueFactory(new PropertyValueFactory<>("BuyPrice"));

                    TableColumn PayType = new TableColumn("PayType");
                    PayType.setCellValueFactory(new PropertyValueFactory<>("PayType"));

                    TableColumn Date = new TableColumn("Date");
                    Date.setCellValueFactory(new PropertyValueFactory<>("Date"));

                    TableColumn ProductBarcode = new TableColumn("Barcode");
                    ProductBarcode.setCellValueFactory(new PropertyValueFactory<>("ProductBarcode"));

                    TableColumn ProductName = new TableColumn("ProductName");
                    ProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));

                    TableColumn ProductBrand = new TableColumn("Brand");
                    ProductBrand.setCellValueFactory(new PropertyValueFactory<>("ProductBrand"));

                    TableColumn ProductQty = new TableColumn("Qty");
                    ProductQty.setCellValueFactory(new PropertyValueFactory<>("ProductQty"));

                    TableColumn UnitPrice = new TableColumn("UnitPrice");
                    UnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));

                    TableColumn TotalDiscount = new TableColumn("TotalDiscount");
                    TotalDiscount.setCellValueFactory(new PropertyValueFactory<>("TotalDiscount"));

                    TableColumn FinalCost = new TableColumn("FinalCost");
                    FinalCost.setCellValueFactory(new PropertyValueFactory<>("FinalCost"));

                    OrderTable.setItems(data);
                    OrderTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    OrderTable.getColumns().setAll(ID, Cashier, CustomerID, PayType, Date, ProductBarcode, ProductName, ProductBrand, ProductQty, UnitPrice, SaleStatus, TotalDiscount, FinalCost);
                } else {
                    OrderTable.getItems().setAll();
                    OrderTable.getColumns().setAll();
                }
        }
    }

    @FXML
    private void ReportHandler (ActionEvent event) throws  SQLException
    {
        if (CheckBox1.isSelected())
        {
            String query = "select * from Transactions.SubSales";
            statement = connection.prepareStatement(query);
            resultSet=statement.executeQuery();

            if (resultSet.next() != false) {
                resultSet = statement.executeQuery();
                ObservableList<Product> data = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    List<String> list = new ArrayList<String>();
                    list.add(resultSet.getString("Category"));
                    list.add(resultSet.getString("Sub Class"));
                    list.add(resultSet.getString("SaleTotal"));

                    data.add(new Product(list.get(0), list.get(1), list.get(2)));
                }

                TableColumn Fee = new TableColumn("Fee");
                Fee.setCellValueFactory(new PropertyValueFactory<>("Fee"));

                TableColumn FName = new TableColumn("Product Name");
                FName.setCellValueFactory(new PropertyValueFactory<>("Name"));

                TableColumn TypeName = new TableColumn("TypeName");
                TypeName.setCellValueFactory(new PropertyValueFactory<>("TypeName"));

                ProductReports.setItems(data);
                ProductReports.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                ProductReports.getColumns().setAll(TypeName, FName, Fee);
            }
            else{
                ProductReports.getItems().setAll();
                ProductReports.getColumns().setAll();
            }
        }

        else if (CheckBox2.isSelected())
        {
            String query = "select * from Transactions.CashiersSubSale";
            statement = connection.prepareStatement(query);
            resultSet=statement.executeQuery();

            if (resultSet.next() != false) {
                resultSet = statement.executeQuery();
                ObservableList<Product> data = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    List<String> list = new ArrayList<String>();
                    list.add(resultSet.getString("Cashier ID"));
                    list.add(resultSet.getString("Foodstaff"));
                    list.add(resultSet.getString("Sanitary"));
                    list.add(resultSet.getString("Stationery"));
                    list.add(resultSet.getString("Cosmetic"));
                    list.add(resultSet.getString("Home Appliances"));
                    list.add(resultSet.getString("Clothing"));

                    data.add(new Product(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6)));
                }

                TableColumn ProductId = new TableColumn("Cashier ID");
                ProductId.setCellValueFactory(new PropertyValueFactory<>("ID"));

                TableColumn FName = new TableColumn("Foodstaff");
                FName.setCellValueFactory(new PropertyValueFactory<>("Name"));

                TableColumn Barcode = new TableColumn("Sanitary");
                Barcode.setCellValueFactory(new PropertyValueFactory<>("Barcode"));

                TableColumn Brand = new TableColumn("Stationery");
                Brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));

                TableColumn Unit = new TableColumn("Cosmetic");
                Unit.setCellValueFactory(new PropertyValueFactory<>("Unit"));

                TableColumn Fee = new TableColumn("Home Appliances");
                Fee.setCellValueFactory(new PropertyValueFactory<>("Fee"));

                TableColumn Inventory = new TableColumn("Inventory");
                Inventory.setCellValueFactory(new PropertyValueFactory<>("Clothing"));

                ProductReports.setItems(data);
                ProductReports.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                ProductReports.getColumns().setAll(ProductId, FName, Barcode, Brand, Unit, Fee, Inventory);
            }
            else{
                ProductReports.getItems().setAll();
                ProductReports.getColumns().setAll();
            }
        }

        else if (CheckBox3.isSelected())
        {
            String query = "select * from Transactions.SaleHistory";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            if (resultSet.next() != false) {
                resultSet = statement.executeQuery();
                ObservableList<Product> data = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    List<String> list = new ArrayList<String>();
                    list.add(resultSet.getString("Year"));
                    list.add(resultSet.getString("Month"));
                    list.add(resultSet.getString("Day"));
                    list.add(resultSet.getString("Sale Total"));

                    data.add(new Product(list.get(0), list.get(1), list.get(2), list.get(3)));
                }

                TableColumn ProductId = new TableColumn("Year");
                ProductId.setCellValueFactory(new PropertyValueFactory<>("ID"));

                TableColumn FName = new TableColumn("Month");
                FName.setCellValueFactory(new PropertyValueFactory<>("Name"));

                TableColumn Barcode = new TableColumn("Day");
                Barcode.setCellValueFactory(new PropertyValueFactory<>("Barcode"));

                TableColumn Brand = new TableColumn("Total Sale");
                Brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));

                ProductReports.setItems(data);
                ProductReports.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                ProductReports.getColumns().setAll(ProductId, FName, Barcode, Brand);
            }
            else{
                ProductReports.getItems().setAll();
                ProductReports.getColumns().setAll();
            }
        }

        else if (CheckBox4.isSelected())
        {
            List <String> Args = new ArrayList<String>();
            Args.add(Barcode2Text.getText());
            Args.add(PName2Text.getText());
            Args.add(ClassText.getText());
            Args.add(Brand2Text.getText());
            String query = "select * from Production.Product as P, Production.Inventory as I, Production.ProductDetail as D, Production.ProductionType as C where I.ProductId = P.ProductId and D.ProductId = P.ProductId and C.ProductiontypeId = P.SubClassId ";

            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty()) {
                    if (i == 0) {
                        query += " and Barcode = ? ";
                    } else if (i == 1) {
                        query += " and ProductName = ? ";
                    } else if (i == 2) {
                        query += " and TypeName = ? ";
                    } else if (i == 3) {
                        query += " and Brand = ? ";
                    }
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
                    list.add(resultSet.getString("Barcode"));
                    list.add(resultSet.getString("ProductName"));
                    list.add(resultSet.getString("Brand"));
                    list.add(resultSet.getString("Inventory"));

                    data.add(new Product(list.get(0), list.get(1), list.get(2), list.get(3)));
                }

                TableColumn ProductId = new TableColumn("Barcode");
                ProductId.setCellValueFactory(new PropertyValueFactory<>("ID"));

                TableColumn FName = new TableColumn("ProductName");
                FName.setCellValueFactory(new PropertyValueFactory<>("Name"));

                TableColumn Barcode = new TableColumn("Brand");
                Barcode.setCellValueFactory(new PropertyValueFactory<>("Barcode"));

                TableColumn Brand = new TableColumn("Inventory");
                Brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));


                ProductReports.setItems(data);
                ProductReports.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                ProductReports.getColumns().setAll(ProductId, FName, Barcode, Brand);
            }
            else{
                ProductReports.getItems().setAll();
                ProductReports.getColumns().setAll();
            }
        }

        else if (CheckBox5.isSelected())
        {
            List <String> Args = new ArrayList<String>();
            Args.add(Barcode2Text.getText());
            Args.add(PName2Text.getText());
            Args.add(Brand2Text.getText());
            Args.add(SDateText.getText());
            Args.add(EDateText.getText());
            Args.add(ClassText.getText());
            String query = "select P.Barcode, P.ProductName, P.Brand, C.ProductFee, C.ModifiedDate from Production.CostChanges as C, Production.Product as P, Production.ProductDetail as D, Production.ProductionType as A where D.ProductId = P.ProductId and C.ProductId = P.ProductId and A.ProductiontypeId = P.SubClassId";

            for (int i = 0; i < Args.size(); i++) {
                if (!Args.get(i).isEmpty()) {
                    if (i == 0) {
                        query += " and Barcode = ? ";
                    } else if (i == 1) {
                        query += " and ProductName = ? ";
                    } else if (i == 2) {
                        query += " and Brand = ? ";
                    } else if (i == 3) {
                        query += " and C.ModifiedDate >= ? ";
                    } else if (i == 4) {
                        query += " and C.ModifiedDate <= ? ";
                    } else if (i == 5)
                        query += " and TypeName = ?";
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
                    list.add(resultSet.getString("Barcode"));
                    list.add(resultSet.getString("ProductName"));
                    list.add(resultSet.getString("Brand"));
                    list.add(resultSet.getString("ModifiedDate"));
                    list.add(resultSet.getString("ProductFee"));

                    data.add(new Product(list.get(0), list.get(1), list.get(2), list.get(4), list.get(3)));
                }

                TableColumn ProductId = new TableColumn("Barcode");
                ProductId.setCellValueFactory(new PropertyValueFactory<>("ID"));

                TableColumn FName = new TableColumn("ProductName");
                FName.setCellValueFactory(new PropertyValueFactory<>("Name"));

                TableColumn Barcode = new TableColumn("Brand");
                Barcode.setCellValueFactory(new PropertyValueFactory<>("Barcode"));

                TableColumn Brand = new TableColumn("Product Fee");
                Brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));

                TableColumn Unit = new TableColumn("Modified Date");
                Unit.setCellValueFactory(new PropertyValueFactory<>("Unit"));


                ProductReports.setItems(data);
                ProductReports.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                ProductReports.getColumns().setAll(ProductId, FName, Barcode, Unit, Brand);
            }
            else{
                ProductReports.getItems().setAll();
                ProductReports.getColumns().setAll();
            }
        }


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


