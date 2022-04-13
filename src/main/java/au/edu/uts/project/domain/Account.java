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
private String username;
private String password;
private String gender;
private String addressCountry;
private String addressState;
private String addressCity;
private String dob;

    @Override
    public String toString() {
        return "Account{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", address_country='" + addressCountry + '\'' +
                ", address_state='" + addressState + '\'' +
                ", address_street='" + addressCity + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
