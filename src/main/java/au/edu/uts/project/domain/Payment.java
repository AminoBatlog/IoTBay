/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 *
 * @author Christie
 */


public class Payment implements Serializable {

    private String Payment_method;
    private String Card_number;
    private String ExpiryDate;
    private String SecurityCode;
    private String NameOnCard;
    private String Payment_date;  
    
    
    @Override
    public String toString() {
        return "Payment{" +
                "Payment_method='" + Payment_method + '\'' +
                ", Card_number='" + Card_number + '\'' +
                ", ExpiryDate='" + ExpiryDate + '\'' +
                ", SecurityCode='" + SecurityCode + '\'' +
                ", NameOnCard='" + NameOnCard + '\'' +
                ", Payment_date='" + Payment_date + '\'' +
                '}';
    }

   
}

