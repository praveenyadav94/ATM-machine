package project;
import java.util.*;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.text.DecimalFormat;


public class OptionMenu extends Account {
		Scanner menu = new Scanner(System.in);
		DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
		
		
		HashMap<Integer, Integer> data = new HashMap<Integer,Integer>();
		
		
		public void getLogin() throws IOException {
			int x = 1;
			
			do {
				try {
					
					data.put(1234567, 1234);
					data.put(7654321, 4321);
					
				 	System.out.println("Welcome to Atm project");
				 	
				 	System.out.println("Enter your Customer Number:");
					setCustomerNumber(menu.nextInt());
					
					System.out.println("Enter your PIN Number");
					setPinNumber(menu.nextInt());
				} catch (Exception e) {
					System.out.println("\n" + "Invalid character.only numbers"  + "\n");
					x = 2;
				}
				for (java.util.Map.Entry<Integer, Integer> entry : data.entrySet()) {
					if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
						getAccountType();
					}
				} 
				System.out.println("/n" + "Wrong customer number or PIN number" + "\n");
			} while (x==1);	
		}
		
		

		public void getAccountType() {
			System.out.println("Select teh account you want to access :");
			System.out.println("Type 1 - checking Account");
			System.out.println("Type 2 - saving account");
			System.out.println("Type 3 - exit");
			System.out.println("Choice :");
			
			selection = menu.nextInt();
			
			switch(selection) {
			case 1:
				getChecking();
				break;
				
			case 2:
				getSaving();
				break;
				
			case 3:
				System.out.println("Thanks for using Atm Bye");
				break;
				
			default:
				System.out.println("\n" + "Invalid Choice" + "\n");
				getAccountType();
			}
		}
		
		public void getChecking() {
			System.out.println("Checking Account: ");
			System.out.println("Type 1 - View Balance");
			System.out.println("Type 2 - Withdraw Funds");
			System.out.println("Type 3 - Deposit funds");
			System.out.println("Type 4 - exit");
			System.out.println("Choice :");
			
			selection = menu.nextInt();
			
			switch(selection) {
			case 1:
				System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
				getAccountType();
				break;
				
			case 2:
				getCheckingWithdrawInput();
				getAccountType();
				break;
				
			case 3:
				getCheckingDepositInput();
				getAccountType();
				break;
				
			case 4:
				System.out.println("Thanks for using Atm Bye");
				break;
				
			default:
				System.out.println("\n" + "Invalid Choice" + "\n");
				getChecking(); 
	}

}
		public void getSaving() {
			System.out.println("Saving Account: ");
			System.out.println("Type 1 - View Balance");
			System.out.println("Type 2 - Withdraw Funds");
			System.out.println("Type 3 - Deposit funds");
			System.out.println("Type 4 - exit");
			System.out.println("Choice :");
			
			selection = menu.nextInt();
			
			switch(selection) {
			case 1:
				System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
				getAccountType();
				break;
				
			case 2:
				getSavingWithdrawInput();
				getAccountType();
				break;
				
			case 3:
				getSavingDepositInput();
				getAccountType();
				break;
				
			case 4:
				System.out.println("Thanks for using Atm Bye");
				break;
				
			default:
				System.out.println("\n" + "Invalid Choice" + "\n");
				getChecking(); 
				
			}
		}
		
		int selection;
	}
