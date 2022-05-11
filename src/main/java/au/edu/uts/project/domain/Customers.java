package au.edu.uts.project.domain;

public class Customers {
    private String customerFname;
    private String customerLname;
    private String email;
    private String password;
    private String dob;
    private String gender;
    private int customerStreetno;
    private String customerStreetname;
    private String customerCity;
    private int customerZipcode;
    private String customerCountry;
    private String type;
    //
    public Customers(String customerFname, String customerLname, String email, String password, String dob, String gender, int customerStreetno, String customerStreetname, String customerCity, int customerZipcode, String customerCountry, String type){
        this.customerFname = customerFname;
        this.customerLname = customerLname;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.customerStreetno = customerStreetno;
        this.customerStreetname = customerStreetname;
        this.customerCity = customerCity;
        this.customerZipcode = customerZipcode;
        this.customerCountry = customerCountry;
        this.type = type;
}
    public String getCustomerFname(){
        return customerFname;
    }
    public void setCustomerFname(String customerFname){
        this.customerFname = customerFname;
    }
    
    public String getCustomerLname(){
        return customerLname;
    }
    public void setCustomerLname(String customerLname){
        this.customerLname = customerLname;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getDob(){
        return dob;
    }
    public void Dob(String dob){
        this.dob = dob;
    }
    
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public int getCustomerStreetno(){
        return customerStreetno;
    }
    public void setCustomerStreetno(int customerStreetno){
        this.customerStreetno = customerStreetno;
    }
    
    public String getCustomerStreetname(){
        return customerStreetname;
    }
    public void setCustomerStreetname(String customerStreetname){
        this.customerStreetname = customerStreetname;
    }
    
    public String getCustomerCity(){
        return customerCity;
    }
    public void setCustomerCity(String customerCity){
        this.customerCity = customerCity;
    }
    
        public int getCustomerZipcode(){
        return customerZipcode;
    }
    public void setCustomerZipcode(int customerZipcode){
        this.customerZipcode = customerZipcode;
    }
    
    public String getCustomerCountry(){
        return customerCountry;
    }
    public void setCustomerCountry(String customerCountry){
        this.customerCountry = customerCountry;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
}