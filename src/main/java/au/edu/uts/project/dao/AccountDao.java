package au.edu.uts.project.dao;

import au.edu.uts.project.domain.Account;

import java.sql.SQLException;

public interface AccountDao{

    /**
     * query account by username
     * @param username
     * @return
     */
    public Account findByUsername(String username) throws SQLException;

}
