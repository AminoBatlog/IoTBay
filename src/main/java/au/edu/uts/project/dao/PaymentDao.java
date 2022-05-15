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
import java.util.List;

public class PaymentDao{

    private Connection connection;
    private Statement stmt;

    public PaymentDao(Connection conn) throws SQLException {       
       stmt = conn.createStatement();
       this.connection = conn;
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

    public List<Payment> findByIDandDATE(Integer id, String date, String email) throws SQLException {
        String sql = "";
        PreparedStatement pst;
        if(id == 0){
            sql = "SELECT * FROM Payment WHERE CAST(payment_date AS VARCHAR(100)) LIKE ? AND cust_email=?";
            pst = this.connection.prepareStatement(sql);
            pst.setString(1, "%" + date + "%");
            pst.setString(2, email);
        } else {
            sql = "SELECT * FROM Payment WHERE payment_id=? AND cust_email=?";
            pst = this.connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, email);
        }
        ResultSet res = pst.executeQuery();
        List<Payment> list = new ArrayList<>();
        if(res.next()) {
            Payment payment = new Payment();
            payment.setPaymentId(res.getInt("payment_id"));
            payment.setEmail(res.getString("cust_email"));
            payment.setPaymentMethod(res.getString("payment_method"));
            payment.setPaymentDate(res.getString("payment_date"));
            payment.setCardNumber(Long.parseLong(res.getString("card_number")));
            payment.setSecurityCode(res.getString("securitycode"));
            payment.setExpiryDate(res.getString("expirydate"));
            payment.setNameOnCard(res.getString("nameoncard"));
            list.add(payment);
        }
        return list;
    }

    public Payment findByID(Integer Payment_ID) throws SQLException {       
        ResultSet res = stmt.executeQuery("SELECT * FROM PAYMENT WHERE PAYMENT_ID = "+ Payment_ID);
        if(res.next()){
            Payment payment = new Payment();
            payment.setPaymentId(res.getInt("payment_id"));
            payment.setEmail(res.getString("cust_email"));
            payment.setPaymentMethod(res.getString("payment_method"));
            payment.setPaymentDate(res.getString("payment_date"));
            payment.setCardNumber(Long.parseLong(res.getString("card_number")));
            payment.setSecurityCode(res.getString("securitycode"));
            payment.setExpiryDate(res.getString("expirydate"));
            payment.setNameOnCard(res.getString("nameoncard"));
            return payment;
        }
        return null;   
    }

    public void deletePayment (Integer Payment_ID) throws SQLException {
        stmt.executeUpdate("DELETE FROM PAYMENT WHERE PAYMENT_ID = " + Payment_ID);
    }

    public void addPayment(Payment payment) throws SQLException {
        String sql="INSERT INTO payment (payment_id, cust_email, payment_method, payment_date, card_number, securitycode, expirydate, nameoncard) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = this.connection.prepareStatement(sql);
        pst.setInt(1, payment.getPaymentId());
        pst.setString(2, payment.getEmail());
        pst.setString(3, payment.getPaymentMethod());
        pst.setString(4, payment.getPaymentDate());
        pst.setLong(5, payment.getCardNumber());
        pst.setString(6, payment.getSecurityCode());
        pst.setString(7, payment.getExpiryDate());
        pst.setString(8, payment.getNameOnCard());
        pst.executeUpdate();
    }

    public void updatePayment(Payment payment) throws SQLException {
        String sql="UPDATE payment SET cust_email=?, payment_method=?, payment_date=?, card_number=?, securitycode=?, expirydate=?, nameoncard=? WHERE payment_id=?";
        PreparedStatement pst = this.connection.prepareStatement(sql);
        pst.setString(1, payment.getEmail());
        pst.setString(2, payment.getPaymentMethod());
        pst.setString(3, payment.getPaymentDate());
        pst.setLong(4, payment.getCardNumber());
        pst.setString(5, payment.getSecurityCode());
        pst.setString(6, payment.getExpiryDate());
        pst.setString(7, payment.getNameOnCard());
        pst.setInt(8, payment.getPaymentId());
        pst.executeUpdate();
    }

    public int getOrderID(String email) throws SQLException {
       ResultSet res = stmt.executeQuery("SELECT ORDER_ID FROM ORDERS WHERE Cust_email=" + email);
        if (res.next()) {
            return res.getInt(1);
        } else {
            return 0;
        }
    }

    public ArrayList<Payment> getPayments(String email) throws SQLException {
        String sql = "SELECT * FROM Payment WHERE cust_email=?";
        PreparedStatement pst = this.connection.prepareStatement(sql);
        pst.setString(1, email);
        ResultSet res = pst.executeQuery();
        ArrayList<Payment> temp2 = new ArrayList();
        while(res.next()) {
            Payment payment = new Payment();
            payment.setPaymentId(res.getInt("payment_id"));
            payment.setEmail(res.getString("cust_email"));
            payment.setPaymentMethod(res.getString("payment_method"));
            payment.setPaymentDate(res.getString("payment_date"));
            payment.setCardNumber(Long.parseLong(res.getString("card_number")));
            payment.setSecurityCode(res.getString("securitycode"));
            payment.setExpiryDate(res.getString("expirydate"));
            payment.setNameOnCard(res.getString("nameoncard"));
            temp2.add(payment);
        }
        return temp2;
    }
    public Payment getPayment(int id) throws SQLException {
        ResultSet res = stmt.executeQuery("SELECT * FROM Payment WHERE payment_id=" + String.valueOf(id));
        if(res.next()) {
            Payment payment = new Payment();
            payment.setPaymentId(res.getInt("payment_id"));
            payment.setEmail(res.getString("cust_email"));
            payment.setPaymentMethod(res.getString("payment_method"));
            payment.setPaymentDate(res.getString("payment_date"));
            payment.setCardNumber(Long.parseLong(res.getString("card_number")));
            payment.setSecurityCode(res.getString("securitycode"));
            payment.setExpiryDate(res.getString("expirydate"));
            payment.setNameOnCard(res.getString("nameoncard"));
            return payment;
        }
        return null;
    }

}

