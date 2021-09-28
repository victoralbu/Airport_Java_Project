package service;

import dao.AccountsDao;
import model.AccountsEntity;

import javax.persistence.Persistence;
import java.util.List;

public class AccountsService<T> {
    private AccountsDao accountsDao;
    private Class<T> entityClass;

    public AccountsService() {
        try {
            accountsDao = new AccountsDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addAccount(AccountsEntity newAccount) {
        if (accountsDao != null) {
            accountsDao.create(newAccount);
        } else System.out.println("...Dao e NULL");
    }

    public void updateAccount(AccountsEntity updatedAccount) {
        if (accountsDao != null) {
            accountsDao.update(updatedAccount);
        } else System.out.println("...Dao e NULL");
    }

    public List<AccountsEntity> getAllAccounts() {
        if (accountsDao != null) {
            return accountsDao.findAll();
        } else return null;
    }

    public void removeAccount(AccountsEntity removeAccount, int accountId) {
        if (accountsDao != null) {
            accountsDao.remove(removeAccount, removeAccount.getIdUser());
        } else System.out.println("...Dao e NULL");
    }

    public T find(int id) {
        if (accountsDao != null) {
            T x = (T) accountsDao.find(id);
            return x;
        } else return null;
    }
}
