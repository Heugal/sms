package studentmanagementsystem.beans;

import java.sql.Blob;

public class ItemBean {
    private int studentID;
    private String firstName, lastName, dob, address, phone, email;
    private Blob picture;
    
    public int getStudentID(){
        return studentID;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getDOB(){
        return dob;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public String getEmail(){
        return email;
    }
    
    public Blob getPicture(){
        return picture;
    }
    
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setDOB(String dob){
        this.dob = dob;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPicture(Blob picture){
        this.picture = picture;
    }
}
