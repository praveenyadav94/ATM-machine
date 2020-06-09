package project;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
		Scanner input = new Scanner(System.in);
		DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

		
		
		public int setCustomerNumber(int customerNumber) {
			this.customerNumber = customerNumber;
			return customerNumber;
		}
		
		
		public int getCustomerNumber() {
			return customerNumber;
		}
		
		
		public int setPinNumber(int pinNumber) {
			this.pinNumber = pinNumber;
			return pinNumber;
		}
		
		public int getPinNumber() {
			return pinNumber;
		}
		
		
		
		public double getCheckingBalance() {
			return checkingBalance;
		}
		
		
		public double getSavingBalance() {
			return savingBalance;
		}
		
		
		public double calacCheckingWithdraw(double amount) {
			checkingBalance = (checkingBalance - amount);
			return checkingBalance;
		}

		
		public double calacSavingWithdraw(double amount) {
			savingBalance = (savingBalance - amount);
			return savingBalance;
		}
		
		
		public double calacCheckingDeposit(double amount) {
			checkingBalance = (checkingBalance + amount);
			return checkingBalance;
		}
		
		
		public double calacSavingDeposit(double amount) {
			savingBalance = (savingBalance + amount);
			return savingBalance;
		}
		
		public void getCheckingWithdrawInput() {
			System.out.println("checking account Balance: " + moneyFormat.format(checkingBalance));
			System.out.println("Amount you want to withdraw from checking Account");
			double amount = input.nextDouble();
			
			if((checkingBalance - amount) >= 0) {
				calacCheckingWithdraw(amount);
				System.out.println("NEW Checking account Balance: " + moneyFormat.format(checkingBalance));	
			} else {
				System.out.println("Balance cannot be negative : " + "\n");
			}
		}

		
		public void getSavingWithdrawInput() {
			System.out.println("saving account Balance: " + moneyFormat.format(savingBalance));
			System.out.println("Amount you want to withdraw from saving Account");
			double amount = input.nextDouble();
			
			if((savingBalance - amount) >= 0) {
				calacSavingWithdraw(amount);
				System.out.println("NEW saving account Balance: " + savingBalance + "\n");	
			} else {
				System.out.println("Balance cannot be negative : " + "\n");
			}
		}
		
		
		public void getCheckingDepositInput() {
			System.out.println("saving account Balance: " + moneyFormat.format(checkingBalance));
			System.out.println("Amount you want to deposit from checking Account");
			double amount = input.nextDouble();
			
			if((checkingBalance + amount) >= 0) {
				calacCheckingDeposit(amount);
				System.out.println("NEW checking account Balance: " + moneyFormat.format(checkingBalance)+ "\n");	
			} else {
				System.out.println("Balance cannot be negative : " + "\n");
			}
		}
		
		
		public void getSavingDepositInput() {
			System.out.println("saving account Balance: " + moneyFormat.format(savingBalance));
			System.out.println("Amount you want to deposit from saving Account");
			double amount = input.nextDouble();
			
			if((savingBalance + amount) >= 0) {
				calacSavingDeposit(amount);
				System.out.println("NEW saving account Balance: " +  moneyFormat.format(savingBalance)+ "\n");	
			} else {
				System.out.println("Balance cannot be negative : " + "\n");
			}
		}
		
		private int customerNumber;
		private int pinNumber;
		private double checkingBalance = 0;
		private double savingBalance = 0;
		

}

