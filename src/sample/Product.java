package sample;
import javafx.beans.property.SimpleStringProperty;

public class Product {

    SimpleStringProperty ID;
    SimpleStringProperty Name;
    SimpleStringProperty Barcode;
    SimpleStringProperty Brand;
    SimpleStringProperty Unit;
    SimpleStringProperty Fee;
    SimpleStringProperty Inventory;
    SimpleStringProperty Supplier;
    SimpleStringProperty BuyFee;
    SimpleStringProperty Discount;
    SimpleStringProperty TypeName;


    public Product(String id, String name, String barcode, String brand, String unit, String fee, String inventory, String supplier, String buyfee, String discount, String typename)
    {
        this.ID = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.Barcode = new SimpleStringProperty(barcode);
        this.Brand = new SimpleStringProperty(brand);
        this.Unit = new SimpleStringProperty(unit);
        this.Fee = new SimpleStringProperty(fee);
        this.Inventory = new SimpleStringProperty(inventory);
        this.Supplier = new SimpleStringProperty(supplier);
        this.BuyFee = new SimpleStringProperty(buyfee);
        this.Discount = new SimpleStringProperty(discount);
        this.TypeName = new SimpleStringProperty(typename);
    }

    public Product(String id, String name, String barcode, String brand, String unit, String fee, String inventory)
    {
        this.ID = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.Barcode = new SimpleStringProperty(barcode);
        this.Brand = new SimpleStringProperty(brand);
        this.Unit = new SimpleStringProperty(unit);
        this.Fee = new SimpleStringProperty(fee);
        this.Inventory = new SimpleStringProperty(inventory);
    }

    public Product(String barcode, String name, String brand, String fee, String date)
    {
        this.ID = new SimpleStringProperty(barcode);
        this.Name = new SimpleStringProperty(name);
        this.Barcode = new SimpleStringProperty(brand);
        this.Brand = new SimpleStringProperty(fee);
        this.Unit = new SimpleStringProperty(date);
    }

    public Product (String year, String month, String day, String total)
    {
        this.ID = new SimpleStringProperty(year);
        this.Name = new SimpleStringProperty(month);
        this.Barcode = new SimpleStringProperty(day);
        this.Brand = new SimpleStringProperty(total);
    }

    public Product(String typename, String name, String fee)
    {
        this.TypeName = new SimpleStringProperty(typename);
        this.Name = new SimpleStringProperty(name);
        this.Fee = new SimpleStringProperty(fee);
    }

    public String getID(){
        return ID.get();
    }
    public void setID(String fname){
        ID.set(fname);
    }

    public String getName(){
        return Name.get();
    }
    public void setName(String fname){
        Name.set(fname);
    }

    public String getBarcode(){
        return Barcode.get();
    }
    public void setBarcode(String fname){
        Barcode.set(fname);
    }

    public String getBrand(){
        return Brand.get();
    }
    public void setBrand(String fname){
        Brand.set(fname);
    }

    public String getUnit(){
        return Unit.get();
    }
    public void setUnit(String fname){
        Unit.set(fname);
    }

    public String getFee(){
        return Fee.get();
    }
    public void setFee(String fname){
        Fee.set(fname);
    }

    public String getInventory(){
        return Inventory.get();
    }
    public void setInventory(String fname){
        Inventory.set(fname);
    }

    public String getSupplier(){
        return Supplier.get();
    }
    public void setSupplier(String fname){
        Supplier.set(fname);
    }

    public String getBuyFee(){
        return BuyFee.get();
    }
    public void setBuyFee(String fname){
        BuyFee.set(fname);
    }

    public String getDiscount(){
        return Discount.get();
    }
    public void setDiscount(String fname){
        Discount.set(fname);
    }

    public String getTypeName(){
        return TypeName.get();
    }
    public void setTypeName(String fname){
        TypeName.set(fname);
    }

}
