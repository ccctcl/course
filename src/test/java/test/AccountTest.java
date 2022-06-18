package test;

import domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

import java.util.List;

public class AccountTest {

    @Test
    public void testFindAll(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService=applicationContext.getBean("accountService", AccountService.class);
        List<Account> allAccount=accountService.findAllAccount();
        for (Account account:allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService=applicationContext.getBean("accountService", AccountService.class);
        Account account=accountService.findAccountById(177);
        System.out.println(account);

    }

    @Test
    public void testAdd(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService=applicationContext.getBean("accountService", AccountService.class);
        Account account = new Account();
        account.setName("李达");
        account.setNameId(2019);
        account.setMoney(666.66f);
        accountService.saveAccount(account);
        System.out.println(account);

    }

    @Test
    public void testUpdate(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService=applicationContext.getBean("accountService", AccountService.class);
        Account account = accountService.findAccountById(181);
        account.setName("可达鸭");
        account.setNameId(17718);
        account.setMoney(888.88f);
        accountService.updateAccount(account);
        System.out.println(account);


    }

    @Test
    public void testDelete(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService=applicationContext.getBean("accountService", AccountService.class);
        accountService.deleteAccount(181);
        System.out.println();
    }




}
