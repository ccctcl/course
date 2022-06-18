package dao;

import domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {


    List<Account> findAllAccount();

    Account findAccountById(Integer nameId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);



}
