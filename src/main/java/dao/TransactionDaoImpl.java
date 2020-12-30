package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Transaction;
import model.Transaction;
import util.DbUtil;

public class TransactionDaoImpl implements TransactionDao {
	
	public static final String DEPOSIT_AMMOUNT_SQL ="update transaction set balance = balance + ?, withdraw =?, deposit =?, transaction_date=? where trans_id = ? ";
	public static final String WITHDRAW_AMMOUNT_SQL ="update transaction set balance = balance - ?, withdraw =?, deposit =?, transaction_date=? where trans_id = ? ";
	public static final String CHECK_BALANCE_SQL = "SELECT acc_no AccountNumber, concat(fname,' ',lname) Fullname, balance Balance, acc_type AccountType,  date_opened DateOpened \r\n"
			+ "FROM bank_db.customer, bank_db.transaction, bank_db.account \r\n"
			+ "WHERE bank_db.customer.cust_id = bank_db.transaction.cust_id && bank_db.account.cust_id = bank_db.customer.cust_id ";


	@Override
	public long depositAmount(Transaction transaction) {
		long deposited = 0;
		
		try {
			PreparedStatement ps = DbUtil.getConnection().prepareStatement(DEPOSIT_AMMOUNT_SQL);
				
			ps.setLong(1, transaction.getDeposit());
			ps.setLong(2, transaction.getWithdraw());
			ps.setLong(3, transaction.getDeposit());
			ps.setString(4, transaction.getTransDate());
			ps.setLong(5, transaction.getTransID());
			deposited = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return deposited;
	}

	@Override
	public long withdrawAmount(Transaction transaction) {
		long withdrawn = 0;
		
		try {
			PreparedStatement ps = DbUtil.getConnection().prepareStatement(WITHDRAW_AMMOUNT_SQL);
			
			ps.setLong(1, transaction.getWithdraw());
			ps.setLong(2, transaction.getWithdraw());
			ps.setLong(3, transaction.getDeposit());
			ps.setString(4, transaction.getTransDate());
			ps.setLong(5, transaction.getTransID());
			withdrawn = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return withdrawn;
	}

	@Override
	public List<Transaction> getAllAccountsInfo() {
		List<Transaction> checkBalance = new ArrayList<>();
		
		try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(CHECK_BALANCE_SQL);){
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setBalance(rs.getLong("balance"));

				checkBalance.add(transaction); 
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return checkBalance;
	}

	

}
