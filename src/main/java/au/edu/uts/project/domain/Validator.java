/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.domain;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author weichen
 */
public class Validator implements Serializable {
   private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
   private String namePattern = "^[a-zA-Z '-]*$";       
   private String passwordPattern = "[a-z0-9]{4,}";       
              
   public Validator(){    }       

   // Check whether an input matches the given RegEx pattern
   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       

      return match.matches(); 

   }       

 
  // Check whether user inputs an email and password 
   public boolean checkEmpty(String email, String password){       

      return  email.isEmpty() || password.isEmpty();   

   }

   // Check if the inputted email follow the correct format
   public boolean validateEmail(String email){                       

      return validate(emailPattern,email);   

   }

   // Check if the inputted name follow the correct format  
   public boolean validateName(String name){

      return validate(namePattern,name); 

   }       
   
   // Check if the inputted password follow the correct format
   public boolean validatePassword(String password){

      return validate(passwordPattern,password); 

   } 
   // Reset validation messages after every submission
   public void clear(HttpSession session) {
       session.setAttribute("emailErr", "Enter email");
       session.setAttribute("passErr", "Enter password");
       session.setAttribute("nameErr", "Enter name");
       session.setAttribute("existErr", "");
  }
    
}
