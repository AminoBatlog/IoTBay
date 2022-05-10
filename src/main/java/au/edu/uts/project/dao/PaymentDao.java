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
     * query payment by paymentID and date paid
     * @param paymentID
     * @param datePaid
     * @return
     */


    private Statement stmt;

    public PaymentDao(Connection conn) throws SQLException {       
       stmt = conn.createStatement();   
    }

    public int getLastPaymentID() throws SQLException {
       String temp = "SELECT MAX(PAYMENTID) FROM PAYMENT" ;
       ResultSet res = stmt.executeQuery(temp);
       if (res.next()) {
            return res.getInt(1);
       } else {
           return 0;
       }
    }

    public Payment findByIDandDATE(Integer paymentID, String datePaid) throws SQLException {
        String temp = "SELECT * FROM PAYMENT WHERE PAYMENTID= " + paymentID + " AND DATEPAID= " + datePaid;
        ResultSet res = stmt.executeQuery(temp);

        while(res.next()) {
            Integer payment_id = res.getInt(1);
            String date_paid = res.getString(8);
            if (payment_id.equals(paymentID) && date_paid.equals(datePaid)) {
                Integer orderID = res.getInt(2);
                String paymentMethod = res.getString(3);
                String cardNumber = res.getString(4);
                String expiryDate = res.getString(5);
                String securityCode = res.getString(6);
                String nameOnCard = res.getString(7);
                return new Payment(paymentMethod, cardNumber, expiryDate, securityCode, nameOnCard, datePaid);

            }
        }
        return null;
    }

    public Payment findByID(Integer paymentID) throws SQLException {       
        ResultSet res = stmt.executeQuery("SELECT * FROM PAYMENT WHERE PAYMENTID = "+ paymentID);
       
        while(res.next()){
            Integer payment_id = res.getInt(1);
            if(payment_id.equals(paymentID)){
                String paymentMethod = res.getString(3);
                String cardNumber = res.getString(4);
                String expiryDate = res.getString(5);
                String securityCode = res.getString(6);
                String nameOnCard = res.getString(7);
                String datePaid = res.getString(8);
                return new Payment(paymentMethod, cardNumber, expiryDate, securityCode, nameOnCard, datePaid);
            }
        }
        return null;   
    }

    public void deletePayment (Integer paymentID) throws SQLException {
        stmt.executeUpdate("DELETE FROM PAYMENT WHERE PAYMENTID = " + paymentID);
    }

    public void addPayment(Integer orderID, String paymentMethod, String cardNumber, String expiryDate, String securityCode, String nameOnCard, String datePaid) throws SQLException {
        stmt.executeUpdate("INSERT INTO PAYMENT VALUES (DEFAULT , " + orderID + ",'" + paymentMethod + "', " + cardNumber + ", " + expiryDate + ",'" + securityCode + "', '" + nameOnCard + "', '" + datePaid + "') ");
    }

    public void updatePayment(Integer paymentID, String paymentMethod, String cardNumber, String expiryDate, String securityCode, String nameOnCard, String datePaid) throws SQLException {
        stmt.executeUpdate("UPDATE PAYMENT SET paymentMethod='" + paymentMethod + "', cardNumber=" + cardNumber + ", expiryDate =" + expiryDate + ",  securityCode='" + securityCode + "', nameOnCard='" + nameOnCard + "',  datePaid='" + datePaid + "' WHERE paymentID = " + paymentID +" ");
    }

    public int getOrderID() throws SQLException {
       ResultSet res = stmt.executeQuery("SELECT ORDERID FROM ORDERS");
       if (res.next()) {
            return res.getInt(1);
       } else {
           return 0;
       }
    }

    public ArrayList<String> getPayments(Integer customerID) throws SQLException {
        ResultSet res = stmt.executeQuery("SELECT * FROM PAYMENT P JOIN ORDERS O on O.ORDERS = P.PAYMENT WHERE O.ORDERS = "+ customerID);
        ArrayList<String> temp2 = new ArrayList();
        while(res.next()) {
            temp2.add(Integer.toString(res.getInt(1)));
            temp2.add(Integer.toString(res.getInt(2)));
            temp2.add(res.getString(3));
            temp2.add(Integer.toString(res.getInt(4)));
            temp2.add(Integer.toString(res.getInt(5)));
            temp2.add(res.getString(6));
            temp2.add(res.getString(7));
            temp2.add(res.getString(8));
        }
        return temp2;
    }


}
