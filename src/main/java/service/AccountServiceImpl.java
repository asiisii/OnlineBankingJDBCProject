package service;

import java.util.List;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.Account;
import model.AccountInfo;

public class AccountServiceImpl implements AccountService {
	
	AccountDao accountDao = new AccountDaoImpl();
	
	@Override
	public int createAccount(Account account) {
		return accountDao.createAccount(account);
	}

	@Override
	public List<AccountInfo> getAllAccountsInfo() {
		return accountDao.getAllAccountsInfo();
	}


}
