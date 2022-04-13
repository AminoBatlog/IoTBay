package au.edu.uts.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/zmqp_test?serverTimezone=GMT%2b8&autoReconnect=true&useSSL=false";
    private static final String DBUSER = "usertest";
    private static final String DBPASSWORD = "usertest";
    private Connection connection = null;


    // connect to database by using constructor
    public DatabaseConnection(){
        try{
            // Loading driver
            Class.forName(DBDRIVER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // getter
    public Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    // close the connection
    public void close(){
        if(this.connection != null) {
            try{
                this.connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
