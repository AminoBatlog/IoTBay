package au.edu.uts.project.dao.daoImpl;

import au.edu.uts.project.dao.AccountDao;
import au.edu.uts.project.domain.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {

    // connection object
    private Connection connection = null;
    // database operation object
    private PreparedStatement pst = null;

    /**
     * constructor to get the connection
     * @param connection
     */
    public AccountDaoImpl(Connection connection){
        this.connection = connection;
    }

    /**
     * implementation of query account by username
     * @param username
     * @return
     */
    @Override
    public Account findByUsername(String username) throws SQLException {
        // create a empty object to get ready to receive the data
        Account account = null;
        // create a sql query, ? is a placeholder
        String sql = "SELECT * FROM user WHERE username = ?";
        // link the sql query with the operation object
        this.pst = this.connection.prepareStatement(sql);
        // put the data into the placeholder by index
        this.pst.setString(1, username);
        // get the result after execute the query
        ResultSet result = this.pst.executeQuery();
        // if the result is not finished(normally we only have one result here)
        while(result.next()){
            account = new Account();
            account.setUsername(result.getString(1));
            account.setPassword(result.getString(2));
        }
        // close the connection
        this.pst.close();
        // return the result
        return account;
    }

}
