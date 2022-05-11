package au.edu.uts.project.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
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
   
    
    @Override
    public String toString() {
        return "Customer{" +
                "customerFname='" + customerFname + '\'' +
                ", customerLname='" + customerLname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", customerStreetno=" + customerStreetno +
                ", customerStreetname='" + customerStreetname + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerZipcode=" + customerZipcode +
                ", customerCountry='" + customerCountry + '\'' +
                ", Type='" + type + '\'' +
                '}';
    }
}
