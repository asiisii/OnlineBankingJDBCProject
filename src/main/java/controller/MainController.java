package controller;

import java.util.List;

import javax.swing.JOptionPane;
import model.Account;
import model.AccountInfo;
import model.Transaction;
import service.AccountService;
import service.AccountServiceImpl;
import service.TransactionService;
import service.TransactionServiceImpl;

public class MainController {

	public static void main(String[] args) {
		
		AccountService accountService = new AccountServiceImpl();
		TransactionService transactionService = new TransactionServiceImpl();
		String decision = "";
		
		do {
			String choice = JOptionPane.showInputDialog("Enter choice for an account : create | deposit | withdraw | check");
			
			switch (choice) {
			case "create":
				Account account = getAccount();
				int created = accountService.createAccount(account);
				if(created >=1 ) {
					JOptionPane.showMessageDialog(null,  "Customer account created successfully in db");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db");
				}
				break;
			case "deposit":
				Transaction deposited = getTransaction();
				int transID = Integer.parseInt(JOptionPane.showInputDialog("Enter transaction id: "));
				deposited.setTransID(transID);
				long deposit = transactionService.depositAmount(deposited);
				if(deposit >= 1) {
					JOptionPane.showMessageDialog(null,  "Amount deposited successfully in db");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db");
				}
				break;
			case "withdraw":
				Transaction withdraw = getTransaction();
				transID = Integer.parseInt(JOptionPane.showInputDialog("Enter transaction id: "));
				withdraw.setTransID(transID);
				long withdrawl = transactionService.withdrawAmount(withdraw);
				if(withdrawl >= 1) {
					JOptionPane.showMessageDialog(null,  "Amount withdrawl successfully in db");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db");
				}
				break;
			case "check":	
				List<AccountInfo> checkBalance = accountService.getAllAccountsInfo();
				for(AccountInfo cb: checkBalance) {
					System.out.println("Account number is: "+cb.getAccNo());
					System.out.println("Account type is: "+cb.getAccType());
					System.out.println("Customer name: "+cb.getFullName());
					System.out.println("Balance is: "+cb.getBalance());
					System.out.println("Date opened on: "+cb.getDateOpened());
					System.out.println("+=============+");
				}							
				break;
			default:
				JOptionPane.showMessageDialog(null, "Wrong Choice");
				break;
			}
			decision = JOptionPane.showInputDialog("Do you want to perform next operation? Enter yes | no");
		} while (decision.equalsIgnoreCase("yes"));
		JOptionPane.showMessageDialog(null, "The end");
	}
	public static Transaction getTransaction() {
		Transaction transaction = new Transaction();


		long withdraw = Long.parseLong(JOptionPane.showInputDialog("Enter withdrawl amount: "));
		long deposit = Long.parseLong(JOptionPane.showInputDialog("Enter deposit amount: "));
		String transDate = JOptionPane.showInputDialog("Enter transaction date (MM-dd-yyyy): ");

		transaction.setWithdraw(withdraw);
		transaction.setDeposit(deposit);
		transaction.setTransDate(transDate);
		
		return transaction;
	}

	public static Account getAccount() {
		Account account = new Account();
		
		int accNo = Integer.parseInt(JOptionPane.showInputDialog("Enter account number: "));
		String accType = JOptionPane.showInputDialog("Enter account type: ");
		String dateOpened = JOptionPane.showInputDialog("Insert Date in Form MM/dd/yyyy");
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("is the account active?"));
		int custID = Integer.parseInt(JOptionPane.showInputDialog("Enter customer id: "));
		
		account.setAccNo(accNo);
		account.setAccType(accType);
		account.setDateOpened(dateOpened);
		account.setIsActive(isActive);
		account.setCustID(custID);

		return account;
	}
}
