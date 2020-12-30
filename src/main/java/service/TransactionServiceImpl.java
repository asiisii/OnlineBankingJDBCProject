package service;


import java.util.List;

import dao.TransactionDao;
import dao.TransactionDaoImpl;
import model.Transaction;

public class TransactionServiceImpl implements TransactionService {
	
	TransactionDao transactionDao = new TransactionDaoImpl();
	
	@Override
	public long depositAmount(Transaction transaction) {
		return transactionDao.depositAmount(transaction);
	}

	@Override
	public long withdrawAmount(Transaction transaction) {
		return transactionDao.withdrawAmount(transaction);
	}

	@Override
	public List<Transaction> getAllAccountsInfo() {
		return transactionDao.getAllAccountsInfo();
	}

	

}
