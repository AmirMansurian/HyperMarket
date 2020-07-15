package sample;
import javafx.beans.property.SimpleStringProperty;

public class Order {

    SimpleStringProperty ID;
    SimpleStringProperty SupplierID;
    SimpleStringProperty Customer;
    SimpleStringProperty Cashier;
    SimpleStringProperty TransfreeID;
    SimpleStringProperty SaleStatus;
    SimpleStringProperty PayType;
    SimpleStringProperty Discount;
    SimpleStringProperty Date;
    SimpleStringProperty FinalCost;
    SimpleStringProperty ProductName;
    SimpleStringProperty ProductBarcode;
    SimpleStringProperty ProductBrand;
    SimpleStringProperty ProductQty;
    SimpleStringProperty TotalDiscount;
    SimpleStringProperty UnitPrice;
    SimpleStringProperty BuyPrice;


    public Order(String id, String cashierid, String Customerid, String salestatus, String paytyper, String date, String barcode, String pname, String brand, String qty, String unit, String totaldiscount, String finalcost)
    {
        this.ID = new SimpleStringProperty(id);
        this.Cashier = new SimpleStringProperty(cashierid);
        this.Customer = new SimpleStringProperty(Customerid);
        this.SaleStatus = new SimpleStringProperty(salestatus);
        this.PayType = new SimpleStringProperty(paytyper);
        this.Date = new SimpleStringProperty(date);
        this.ProductBarcode = new SimpleStringProperty(barcode);
        this.ProductName = new SimpleStringProperty(pname);
        this.ProductBrand = new SimpleStringProperty(brand);
        this.ProductQty = new SimpleStringProperty(qty);
        this.UnitPrice = new SimpleStringProperty(unit);
        this.TotalDiscount = new SimpleStringProperty(totaldiscount);
        this.FinalCost = new SimpleStringProperty(finalcost);

        this.SupplierID = new SimpleStringProperty(cashierid);
        this.TransfreeID = new SimpleStringProperty(Customerid);
        this.BuyPrice = new SimpleStringProperty(salestatus);
    }


    public String getID(){
        return ID.get();
    }
    public void setID(String fname){
        ID.set(fname);
    }

    public String getSupplierID(){
        return SupplierID.get();
    }
    public void setSupplierID(String fname){
        SupplierID.set(fname);
    }

    public String getCustomerID(){
        return Customer.get();
    }
    public void setCustomerID(String fname){
        Customer.set(fname);
    }

    public String getCashierID(){
        return Cashier.get();
    }
    public void setCashierID(String fname){
        Cashier.set(fname);
    }

    public String getTransfreeID(){
        return TransfreeID.get();
    }
    public void setTransfreeID(String fname){
        TransfreeID.set(fname);
    }

    public String getSaleStatus(){
        return SaleStatus.get();
    }
    public void setSaleStatus(String fname){
        SaleStatus.set(fname);
    }

    public String getPayType(){
        return PayType.get();
    }
    public void setPayType(String fname){
        PayType.set(fname);
    }

    public String getDiscount(){
        return Discount.get();
    }
    public void setDiscount(String fname){
        Discount.set(fname);
    }

    public String getDate(){
        return Date.get();
    }
    public void setDate(String fname){
        Date.set(fname);
    }

    public String getFinalCost(){
        return FinalCost.get();
    }
    public void setFinalCost(String fname){
        FinalCost.set(fname);
    }

    public String getProductName(){
        return ProductName.get();
    }
    public void setProductName(String fname){
        ProductName.set(fname);
    }

    public String getProductBarcode(){
        return ProductBarcode.get();
    }
    public void setProductBarcode(String fname){
        ProductBarcode.set(fname);
    }

    public String getProductBrand(){
        return ProductBrand.get();
    }
    public void setProductBrand(String fname){
        ProductBrand.set(fname);
    }

    public String getProductQty(){
        return ProductQty.get();
    }
    public void setProductQty(String fname){
        ProductQty.set(fname);
    }

    public String getTotalDiscount(){
        return TotalDiscount.get();
    }
    public void setTotalDiscount(String fname){
        TotalDiscount.set(fname);
    }

    public String getUnitPrice(){
        return UnitPrice.get();
    }
    public void setUnitPrice(String fname){
        UnitPrice.set(fname);
    }

    public String getBuyPrice(){
        return BuyPrice.get();
    }
    public void setBuyPrice(String fname){
        BuyPrice.set(fname);
    }
}



















