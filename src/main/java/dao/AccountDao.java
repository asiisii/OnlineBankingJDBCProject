package dao;

import java.util.List;

import model.Account;
import model.AccountInfo;


public interface AccountDao {
	int createAccount (Account account);
	
	List<AccountInfo> getAllAccountsInfo();
	
	

}
