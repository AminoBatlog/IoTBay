package au.edu.uts.project.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

private String fname;
private String lname;
private String email;
private String password;
private String gender;
private int addressStreetNo;
private String addressStreetName;
private String addressCountry;
private int addressZipcode;
private String addressCity;
private String dob;
private boolean status;

    @Override
    public String toString() {
        return "Account{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", address_streetNo='" + addressStreetNo + '\'' +
                ", address_streetName='" + addressStreetName + '\'' +
                ", address_city='" + addressCity + '\'' +
                ", address_zipcode='" + addressZipcode + '\'' +
                ", address_country='" + addressCountry + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
