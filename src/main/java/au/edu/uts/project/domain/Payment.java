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

    private String paymentMethod;
    private String cardNumber;
    private String expiryDate;
    private String securityCode;
    private String nameOnCard;
    private String datePaid;  
    
    
    @Override
    public String toString() {
        return "Payment{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", datePaid='" + datePaid + '\'' +
                '}';
    }

   
}
