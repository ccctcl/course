package dao.impl;

import dao.AccountDao;
import domain.Account;
import org.apache.commons.dbutils.QueryRunner;

import javax.management.Query;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById() {
        return null;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer accountId) {

    }
}
