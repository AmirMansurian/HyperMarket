package sample;
import javafx.beans.property.SimpleStringProperty;

public class Person {

    SimpleStringProperty ID;
    SimpleStringProperty FirstName;
    SimpleStringProperty LastName;
    SimpleStringProperty Gender;
    SimpleStringProperty PhoneNumber;
    SimpleStringProperty CompanyName;
    SimpleStringProperty StaffTypeName;
    SimpleStringProperty Score;
    SimpleStringProperty BirthDay;
    SimpleStringProperty Salary;
    SimpleStringProperty Debt;

    public Person(String id, String firstname, String lastname, String gender, String birthday , String phonenumber, String debt)
    {
        this.ID = new SimpleStringProperty(id);
        this.FirstName = new SimpleStringProperty(firstname);
        this.LastName = new SimpleStringProperty(lastname);
        this.Gender = new SimpleStringProperty(gender);
        this.BirthDay = new SimpleStringProperty(birthday);
        this.PhoneNumber = new SimpleStringProperty(phonenumber);
        this.Debt = new SimpleStringProperty(debt);
    }

    public Person(String id, String firstname, String lastname, String gender, String phonenumber, String birthday, String salary, String score, String type)
    {
        this.ID = new SimpleStringProperty(id);
        this.FirstName = new SimpleStringProperty(firstname);
        this.LastName = new SimpleStringProperty(lastname);
        this.Gender = new SimpleStringProperty(gender);
        this.PhoneNumber = new SimpleStringProperty(phonenumber);
        this.StaffTypeName = new SimpleStringProperty(type);
        this.Score = new SimpleStringProperty(score);
        this.Salary = new SimpleStringProperty(salary);
        this.BirthDay = new SimpleStringProperty(birthday);
    }

    public Person (String id, String firstname, String lastname, String gender, String phonenumber, String company, String score, String type)
    {
        this.ID = new SimpleStringProperty(id);
        this.FirstName = new SimpleStringProperty(firstname);
        this.LastName = new SimpleStringProperty(lastname);
        this.Gender = new SimpleStringProperty(gender);
        this.PhoneNumber = new SimpleStringProperty(phonenumber);
        this.StaffTypeName = new SimpleStringProperty(type);
        this.Score = new SimpleStringProperty(score);
        this.CompanyName = new SimpleStringProperty(company);
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

    public String getStaffTypeName(){
        return StaffTypeName.get();
    }
    public void setStaffTypeName(String fname){
        StaffTypeName.set(fname);
    }

    public String getScore(){
        return Score.get();
    }
    public void setScore(String fname){
        Score.set(fname);
    }

    public String getSalary(){
        return Salary.get();
    }
    public void setSalary(String fname){
        Salary.set(fname);
    }

    public String getCompanyName(){
        return CompanyName.get();
    }
    public void setCompanyName(String fname){
        CompanyName.set(fname);
    }
}
