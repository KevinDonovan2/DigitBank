package hei.school.digitbank.test;

import hei.school.digitbank.dao.AccountDAO;
import hei.school.digitbank.entity.Account;
import hei.school.digitbank.service.AccountService;

import java.sql.Date;
import java.util.List;

public class AccountDAOTest {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        // findAll
        System.out.println("your all accounts :");
        List<Account> accounts = accountDAO.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        //  findById
        Integer accountNumberToFind = 2;
        System.out.println("\n Account find by ID:");
        Account account = accountDAO.findById(accountNumberToFind);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("No account found with the number " + accountNumberToFind);
        }
        // save
        Account newAccount = new Account(3, "user test", new Date(System.currentTimeMillis()), 3000.0, 5000.0, 0.0, 0.0, true, 5.0);
        System.out.println("\n New account registration :");
        accountDAO.save(newAccount);
        System.out.println("New account successfully registered.");

        // delete
        Integer accountNumberToDelete = 2;
        System.out.println("\nDeleting an account :");
        accountDAO.delete(accountNumberToDelete);
        System.out.println("Account successfully deleted.");

        // withdraw
        Integer accountNumber = 1;
        Double amount = 200.0;
        System.out.println("\n Testing the withdraw method:");
        boolean success = AccountService.withdrawMoney(accountNumber, amount);

        if (success) {
            System.out.println("Cash withdrawal successfully completed.");
        } else {
            System.out.println("Unable to withdraw money. The balance or authorized credit is insufficient.");
        }
    }
}

