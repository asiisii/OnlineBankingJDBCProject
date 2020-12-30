package model;

public class Account {
	//Customer table
	private int custID;
	private String fname;
	private String lname;
	private String custEmail;
	private String username;
	private String password;
	//Account table
	private int accID;
	private int accNo;
	private String accType;
	private String dateOpened;
	private Boolean isActive;
//	//Transaction table
//	private int transID;
//	private Date transDate;
//	private long initialBalance;
//	private long withdraw;
//	private long deposit;
//	private long endingBalance;
	
	//getters and setters 
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
//	public int getTransID() {
//		return transID;
//	}
//	public void setTransID(int transID) {
//		this.transID = transID;
//	}
//	public Date getTransDate() {
//		return transDate;
//	}
//	public void setTransDate(Date transDate) {
//		this.transDate = transDate;
//	}
//	public long getInitialBalance() {
//		return initialBalance;
//	}
//	public void setInitialBalance(long initialBalance) {
//		this.initialBalance = initialBalance;
//	}
//	public long getWithdraw() {
//		return withdraw;
//	}
//	public void setWithdraw(long withdraw) {
//		this.withdraw = withdraw;
//	}
//	public long getDeposit() {
//		return deposit;
//	}
//	public void setDeposit(long deposit) {
//		this.deposit = deposit;
//	}
//	public long getEndingBalance() {
//		return endingBalance;
//	}
//	public void setEndingBalance(long endingBalance) {
//		this.endingBalance = endingBalance;
//	}
	
	
}
