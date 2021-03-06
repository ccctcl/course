package spring.dao.impl;

import spring.dao.AccountDao;
import spring.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {

        try {
            return  runner.query("select * from bank",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Account findAccountById(Integer nameId) {

        try {
            return runner.query("select * from bank where nameId =?",new BeanHandler<Account>(Account.class),nameId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveAccount(Account account) {

        try {
            runner.update("insert into bank(name,nameId,money) values(?,?,?)",account.getName(),account.getNameId(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateAccount(Account account) {

        try {
            runner.update("update bank set name=?,nameId=?,money=? where id=?",account.getName(),account.getNameId(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAccount(Integer accountId) {

        try {
            runner.update("delete from bank where id=?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
