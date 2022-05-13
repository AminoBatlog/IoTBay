/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.dao;


import au.edu.uts.project.domain.Payment;
import java.util.ArrayList;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentDao{

    private Statement stmt;

    public PaymentDao(Connection conn) throws SQLException {       
       stmt = conn.createStatement();   
    }

    public int getLastPaymentID() throws SQLException {
       String temp = "SELECT MAX(PAYMENT_ID) FROM PAYMENT" ;
       ResultSet res = stmt.executeQuery(temp);
       if (res.next()) {
            return res.getInt(1);
       } else {
           return 0;
       }
    }

    public Payment findByIDandDATE(Integer Payment_ID, String Payment_date) throws SQLException {
        String temp = "SELECT * FROM PAYMENT WHERE PAYMENT_ID= " + Payment_ID + " AND PAYMENT_DATE= " + Payment_date;
        ResultSet res = stmt.executeQuery(temp);

        while(res.next()) {
            Payment_ID = res.getInt(1);
            Payment_date = res.getString(8);
            if (Payment_ID.equals(Payment_ID) && Payment_date.equals(Payment_date)) {
                String Payment_method = res.getString(3);
                String Card_number = res.getString(4);
                String ExpiryDate = res.getString(6);
                String SecurityCode = res.getString(5);
                String NameOnCard = res.getString(7);
                return new Payment(Payment_method, Card_number, ExpiryDate, SecurityCode, NameOnCard, Payment_date);

            }
        }
        return null;
    }

    public Payment findByID(Integer Payment_ID) throws SQLException {       
        ResultSet res = stmt.executeQuery("SELECT * FROM PAYMENT WHERE PAYMENT_ID = "+ Payment_ID);
       
        while(res.next()){
            Payment_ID = res.getInt(1);
            if(Payment_ID.equals(Payment_ID)){
                String Payment_method = res.getString(3);
                String Card_number = res.getString(4);
                String ExpiryDate = res.getString(6);
                String SecurityCode = res.getString(5);
                String NameOnCard = res.getString(7);
                String Payment_date = res.getString(8);
                return new Payment(Payment_method, Card_number, ExpiryDate, SecurityCode, NameOnCard, Payment_date);
            }
        }
        return null;   
    }

    public void deletePayment (Integer Payment_ID) throws SQLException {
        stmt.executeUpdate("DELETE FROM PAYMENT WHERE PAYMENT_ID = " + Payment_ID);
    }

    public void addPayment(Integer Order_ID, String Payment_method, String Card_number, String ExpiryDate, String SecurityCode, String NameOnCard, String Payment_date) throws SQLException {
        stmt.executeUpdate("INSERT INTO PAYMENT VALUES (DEFAULT , '" + Order_ID + "', '" + Payment_method + "', '" + Card_number + "', '" + ExpiryDate + "', '" + SecurityCode + "', '" + NameOnCard + "', '" + Payment_date + "') ");
    }

    public void updatePayment(Integer Order_ID, String Payment_method, String Card_number, String ExpiryDate, String SecurityCode, String NameOnCard, String Payment_date) throws SQLException {
        stmt.executeUpdate("UPDATE PAYMENT SET Payment_method='" + Payment_method + "', Card_number=" + Card_number + ", ExpiryDate =" + ExpiryDate + ",  SecurityCode='" + SecurityCode + "', NameOnCard='" + NameOnCard + "',  Payment_date='" + Payment_date + "' WHERE Payment_ID = " + Order_ID +" ");
    }

    public int getOrderID() throws SQLException {
       ResultSet res = stmt.executeQuery("SELECT ORDER_ID FROM ORDERS");
       if (res.next()) {
            return res.getInt(1);
       } else {
           return 0;
       }
    }

    public ArrayList<String> getPayments(Integer cust_ID) throws SQLException {
        ResultSet res = stmt.executeQuery("SELECT * FROM PAYMENT P JOIN ORDERS O on O.ORDERS = P.PAYMENT WHERE O.ORDERS = "+ cust_ID);
        ArrayList<String> temp2 = new ArrayList();
        while(res.next()) {
            temp2.add(Integer.toString(res.getInt(1)));
            temp2.add(res.getString(2));
            temp2.add(res.getString(3));
            temp2.add(res.getString(4));
            temp2.add(res.getString(5));
            temp2.add(res.getString(6));
            temp2.add(res.getString(7));
            temp2.add(res.getString(8));
        }
        return temp2;
    }

}

