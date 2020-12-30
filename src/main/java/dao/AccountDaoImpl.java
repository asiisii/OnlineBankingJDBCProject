package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.AccountInfo;
import util.DbUtil;

public class AccountDaoImpl implements AccountDao {
	
	public static final String CREATE_ACCOUNT_SQL ="insert into account (acc_no, acc_type, date_opened, is_active, cust_id) values(?,?,?,?,?)";
	public static final String CHECK_BALANCE_SQL = "SELECT a.acc_no , concat(c.fname,' ',c.lname) Fullname, t.balance Balance, a.acc_type,  a.date_opened "
			+ "FROM customer c, transaction t, account a "
			+ "WHERE c.cust_id = t.cust_id && c.cust_id = a.cust_id ";
	
	@Override
	public int createAccount(Account account) {
		int created = 0;
		try {
			PreparedStatement ps = DbUtil.getConnection().prepareStatement(CREATE_ACCOUNT_SQL);
			
			ps.setInt(1, account.getAccNo());
			ps.setString(2, account.getAccType());
			ps.setString(3, account.getDateOpened());
			ps.setBoolean(4, account.getIsActive());
			ps.setInt(5, account.getCustID());
			created = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return created;
	}


	@Override
	public List<AccountInfo> getAllAccountsInfo() {
		List<AccountInfo> checkBalance = new ArrayList<>();
		
		try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(CHECK_BALANCE_SQL);){
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountInfo account = new AccountInfo();
				account.setAccType(rs.getString("acc_type"));
				account.setDateOpened(rs.getString("date_opened"));
				account.setAccNo(rs.getInt("acc_no"));
				account.setAccType(rs.getString("acc_type"));
				account.setBalance(rs.getFloat("balance"));
				account.setFullName(rs.getString("Fullname"));
				checkBalance.add(account); 
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return checkBalance;
	}




}
