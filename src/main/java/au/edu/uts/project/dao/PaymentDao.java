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

    /**
     * query payment by Payment_ID and Payment_date
     * @param payment_ID
     * @param payment_date
     * @return
     */


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

    public Payment findByIDandDATE(Integer payment_ID, String Payment_date) throws SQLException {
        String temp = "SELECT * FROM PAYMENT WHERE PAYMENT_ID= " + Payment_ID + " AND PAYMENT_DATE= " + Payment_date;
        ResultSet res = stmt.executeQuery(temp);

        while(res.next()) {
            Integer payment_id = res.getInt(1);
            String payment_date = res.getString(8);
            if (payment_id.equals(Payment_ID) && payment_date.equals(Payment_date)) {
                Integer order_ID = res.getInt(2);
                String paymentMethod = res.getString(3);
                String cardNumber = res.getString(4);
                String expiryDate = res.getString(5);
                String securityCode = res.getString(6);
                String nameOnCard = res.getString(7);
                return new Payment(payment_method, cardNumber, expiryDate, securityCode, nameOnCard, payment_date);

            }
        }
        return null;
    }

    public Payment findByID(Integer payment_ID) throws SQLException {       
        ResultSet res = stmt.executeQuery("SELECT * FROM PAYMENT WHERE PAYMENT_ID = "+ payment_ID);
       
        while(res.next()){
            Integer payment_id = res.getInt(1);
            if(payment_id.equals(payment_ID)){
                String payment_Method = res.getString(3);
                String cardNumber = res.getString(4);
                String expiryDate = res.getString(5);
                String securityCode = res.getString(6);
                String nameOnCard = res.getString(7);
                String payment_date = res.getString(8);
                return new Payment(payment_Method, cardNumber, expiryDate, securityCode, nameOnCard, payment_date);
            }
        }
        return null;   
    }

    public void deletePayment (Integer payment_ID) throws SQLException {
        stmt.executeUpdate("DELETE FROM PAYMENT WHERE PAYMENT_ID = " + payment_ID);
    }

    public void addPayment(Integer order_ID, String payment_Method, String cardNumber, String expiryDate, String securityCode, String nameOnCard, String payment_date) throws SQLException {
        stmt.executeUpdate("INSERT INTO PAYMENT VALUES (DEFAULT , " + order_ID + "," + payment_Method + ", " + cardNumber + ", " + expiryDate + ", " + securityCode + ", " + nameOnCard + ", " + payment_date + ") ");
    }

    public void updatePayment(Integer payment_ID, String payment_Method, String cardNumber, String expiryDate, String securityCode, String nameOnCard, String payment_date) throws SQLException {
        stmt.executeUpdate("UPDATE PAYMENT SET payment_Method='" + payment_Method + "', cardNumber=" + cardNumber + ", expiryDate =" + expiryDate + ",  securityCode='" + securityCode + "', nameOnCard='" + nameOnCard + "',  payment_Date='" + payment_date + "' WHERE payment_ID = " + payment_ID +" ");
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
            temp2.add(Integer.toString(res.getInt(2)));
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
