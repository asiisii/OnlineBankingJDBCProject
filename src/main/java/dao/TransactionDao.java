package dao;

import java.util.List;

import model.Transaction;

public interface TransactionDao {
	long depositAmount (Transaction transaction);
	long withdrawAmount (Transaction transaction);

	
	List<Transaction> getAllAccountsInfo();
}
