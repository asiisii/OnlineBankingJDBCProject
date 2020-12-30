package service;

import java.util.List;

import model.Transaction;

public interface TransactionService {

	long depositAmount (Transaction transaction);
	long withdrawAmount (Transaction transaction);
	List<Transaction> getAllAccountsInfo();}
