package au.edu.uts.project.service;

import au.edu.uts.project.domain.Account;

import java.sql.SQLException;

public interface AccountService {

    Integer login(Account account);

}
