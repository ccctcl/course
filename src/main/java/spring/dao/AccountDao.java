package spring.dao;

import spring.domain.Account;

import java.util.List;

public interface AccountDao {


    List<Account> findAllAccount();

    Account findAccountById(Integer nameId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);



}
