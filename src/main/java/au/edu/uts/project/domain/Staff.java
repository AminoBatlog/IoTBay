package au.edu.uts.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private String staffFname;
    private String staffLname;
    private String email;
    private String password;
    private String dob;
    private String gender;
    private int staffStreetno;
    private String staffStreetname;
    private String staffCity;
    private int staffZipcode;
    private String staffCountry;
    private String roles;

    @Override
    public String toString() {
        return "Staff{" +
                ", staffFname='" + staffFname + '\'' +
                ", staffLname='" + staffLname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", staffStreetno='" + staffStreetno + '\'' +
                ", staffStreetname='" + staffStreetname + '\'' +
                ", staffCity='" + staffCity + '\'' +
                ", staffZipcode='" + staffZipcode + '\'' +
                ", staffCountry='" + staffCountry + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
