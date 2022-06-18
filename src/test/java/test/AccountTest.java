package test;

import spring.config.SpringConfiguration;
import spring.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.service.AccountService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {

    @Autowired
    private AccountService accountService;


    @Test
    public void testFindAll(){
        List<Account> allAccount=accountService.findAllAccount();
        for (Account account:allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById(){
        Account account=accountService.findAccountById(177);
        System.out.println(account);

    }

    @Test
    public void testAdd(){
        Account account = new Account();
        account.setName("李达");
        account.setNameId(2019);
        account.setMoney(666.66f);
        accountService.saveAccount(account);
        System.out.println(account);

    }

    @Test
    public void testUpdate(){
        Account account = accountService.findAccountById(2019);
        account.setName("可达鸭");
        account.setNameId(17718);
        account.setMoney(888.88f);
        accountService.updateAccount(account);
        System.out.println(account);


    }

    @Test
    public void testDelete(){
        accountService.deleteAccount(183);
        System.out.println();
    }




}
