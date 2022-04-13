package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.AccountDao;
import au.edu.uts.project.dao.daoImpl.AccountDaoImpl;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.service.AccountService;
import au.edu.uts.project.utils.DatabaseConnection;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {


    /**
     * check if the password correct
     * @param account
     * @return              true or false
     * @throws SQLException
     */
    @Override
    public Integer login(Account account){
        AccountDao dao = null;
        try{
            dao = new AccountDaoImpl(new DatabaseConnection().getConnection());
        }catch (Exception e){
            return 400;
        }
        Account accountExist = null;
        try {
            accountExist = dao.findByUsername(account.getUsername());
        } catch (SQLException e) {
            return 401;
        }
        if(accountExist == null){
            return 402;
        }
        if(account.getPassword().equals(accountExist.getPassword())){
            return 100;
        }
        return 403;
    }
}

