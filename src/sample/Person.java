package sample;
import javafx.beans.property.SimpleStringProperty;

public class Person {

    SimpleStringProperty ID;
    SimpleStringProperty FirstName;
    SimpleStringProperty LastName;
    SimpleStringProperty Gender;
    SimpleStringProperty BirthDay;
    SimpleStringProperty PhoneNumber;
    SimpleStringProperty Debt;

    public Person(String id, String firstname, String lastname, String gender, String birthday, String phonenumber, String debt)
    {
        this.ID = new SimpleStringProperty(id);
        this.FirstName = new SimpleStringProperty(firstname);
        this.LastName = new SimpleStringProperty(lastname);
        this.Gender = new SimpleStringProperty(gender);
        this.BirthDay = new SimpleStringProperty(birthday);
        this.PhoneNumber = new SimpleStringProperty(phonenumber);
        this.Debt = new SimpleStringProperty(debt);
    }

    public String getID(){
        return ID.get();
    }
    public void setID(String fname){
        ID.set(fname);
    }

    public String getFirstName(){
        return FirstName.get();
    }
    public void setFirstName(String fname){
        FirstName.set(fname);
    }

    public String getLastName(){
        return LastName.get();
    }
    public void setLastName(String fname){
        LastName.set(fname);
    }

    public String getGender(){
        return Gender.get();
    }
    public void setGender(String fname){
        Gender.set(fname);
    }

    public String getBirthDay(){
        return BirthDay.get();
    }
    public void setBirthDay(String fname){
        BirthDay.set(fname);
    }

    public String getPhoneNumber(){
        return PhoneNumber.get();
    }
    public void setPhoneNumber(String fname){
        PhoneNumber.set(fname);
    }

    public String getDebt(){
        return Debt.get();
    }
    public void setDebt(String fname){
        Debt.set(fname);
    }

}
