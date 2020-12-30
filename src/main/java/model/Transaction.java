package model;

public class Transaction {
	//Transaction table
		private int transID;
		private String transDate;
		private long balance;
		private long withdraw;
		private long deposit;

		
		public int getTransID() {
			return transID;
		}
		public void setTransID(int transID) {
			this.transID = transID;
		}
		public String getTransDate() {
			return transDate;
		}
		public void setTransDate(String transDate) {
			this.transDate = transDate;
		}
		public long getBalance() {
			return balance;
		}
		public void setBalance(long balance) {
			this.balance = balance;
		}
		public long getWithdraw() {
			return withdraw;
		}
		public void setWithdraw(long withdraw) {
			this.withdraw = withdraw;
		}
		public long getDeposit() {
			return deposit;
		}
		public void setDeposit(long deposit) {
			this.deposit = deposit;
		}

		
		
}
