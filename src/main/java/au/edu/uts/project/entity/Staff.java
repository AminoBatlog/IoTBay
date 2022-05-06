/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.entity;

/**
 *
 * @author kevin
 */
public class Staff {

    private int staff_ID;
    private String Staff_FName;
    private String Staff_LName;
    private String Email;
    private String Password;
    private String DOB;
    private String GENDER;
    private String Staff_StreetNo;
    private String Staff_City;
    private String Staff_Zipcode;
    private String Staff_Country;
    private String Roles;

    public Staff() {
        
    }

    public Staff(String Staff_FName, String Staff_LName, String Email, String Password, String DOB, String GENDER, String Staff_StreetNo, String Staff_City, String Staff_Zipcode, String Staff_Country, String Roles) {
        this.Staff_FName = Staff_FName;
        this.Staff_LName = Staff_LName;
        this.Email = Email;
        this.Password = Password;
        this.DOB = DOB;
        this.GENDER = GENDER;
        this.Staff_StreetNo = Staff_StreetNo;
        this.Staff_City = Staff_City;
        this.Staff_Zipcode = Staff_Zipcode;
        this.Staff_Country = Staff_Country;
        this.Roles = Roles;
    }

    public int getStaff_ID() {
        return staff_ID;
    }

    public void setStaff_ID(int staff_ID) {
        this.staff_ID = staff_ID;
    }

    public String getStaff_FName() {
        return Staff_FName;
    }

    public void setStaff_FName(String Staff_FName) {
        this.Staff_FName = Staff_FName;
    }

    public String getStaff_LName() {
        return Staff_LName;
    }

    public void setStaff_LName(String Staff_LName) {
        this.Staff_LName = Staff_LName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getStaff_StreetNo() {
        return Staff_StreetNo;
    }

    public void setStaff_StreetNo(String Staff_StreetNo) {
        this.Staff_StreetNo = Staff_StreetNo;
    }

    public String getStaff_City() {
        return Staff_City;
    }

    public void setStaff_City(String Staff_City) {
        this.Staff_City = Staff_City;
    }

    public String getStaff_Zipcode() {
        return Staff_Zipcode;
    }

    public void setStaff_Zipcode(String Staff_Zipcode) {
        this.Staff_Zipcode = Staff_Zipcode;
    }

    public String getStaff_Country() {
        return Staff_Country;
    }

    public void setStaff_Country(String Staff_Country) {
        this.Staff_Country = Staff_Country;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String Roles) {
        this.Roles = Roles;
    }

}
