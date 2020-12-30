package service;

import java.util.List;

import model.Account;
import model.AccountInfo;

public interface AccountService {
	int createAccount (Account account);
	
	List<AccountInfo> getAllAccountsInfo();
}
