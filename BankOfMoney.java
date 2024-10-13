import java.util.Scanner;

public class BankOfMoney {
	public static void main(String[] args) {

		String account1Name = "Khalid";
		double account1Balance = 180000;
		String account2Name = "Anas";
		double account2Balance = 130000.00;
		String account3Name = "Abdulaziz";
		double account3Balance = 150000.00;
		double bankProfit = 0.0;
		Scanner scanner = new Scanner(System.in);
		while (true) {
	
			System.out.println("*******************************");
			System.out.println("Please select an option:");
			System.out.println("1. Khalid (Account 101)");
			System.out.println("2. Anas (Account 102)");
			System.out.println("3. Abdulaziz (Account 103)");
			System.out.println("4. Administrator");
			System.out.println("5. Exit");
			System.out.println("*******************************");
			int choice = scanner.nextInt();

			if (choice == 5) {
				System.out.println("Thank you for using Simple Bank ATM. Goodbye!");
				break;
			}

			if (choice == 4) {
				System.out.println("\nAdministrator Menu:");
				System.out.printf("Total Profit from spending: $%.2f%n", bankProfit);
				System.out.println("Press any key to return to the main menu.");
				scanner.next();
			}
			String accountName;
			double accountBalance = 0;
			if (choice == 1 ||choice == 101 ) {
				accountName = account1Name;
				accountBalance = account1Balance;
			} else if (choice == 2|| choice == 102 ) {
				accountName = account2Name;
				accountBalance = account2Balance;
			} else if (choice == 3|| choice == 103 ) {
				accountName = account3Name;
				accountBalance = account3Balance;
			} else {
				System.out.println("Invalid option. Please try again.");
				continue;
			}
			double totalDeposited = 0, totalWithdrawn = 0;
			int deposits = 0, withdrawals = 0;
			while (true) {
				System.out.println("\nAccount Operations for " + accountName);
				System.out.println("1. View Balance");
				System.out.println("2. Deposit Money");
				System.out.println("3. Withdraw Money");
				System.out.println("4. Exit");
				int option = scanner.nextInt();

				if (option == 1) {
					System.out.printf("Current Balance: $%.2f%n", accountBalance);
				} else if (option == 2) {
					System.out.print("Enter deposit amount: ");
					double depositAmount = scanner.nextDouble();
					if (depositAmount > 0) {
						accountBalance += depositAmount;
						deposits++;
						totalDeposited += depositAmount;
						System.out.printf("Deposited $%.2f successfully.%n", depositAmount);
					} else {
						System.out.println("Invalid amount. Please try again.");
					}
				} else if (option == 3) {
					System.out.print("Enter withdrawal amount: ");
					double withdrawAmount = scanner.nextDouble();
					double spending = withdrawAmount * 0.01;
					if (withdrawAmount > 0 && accountBalance >= (withdrawAmount + spending)) {
						accountBalance -= (withdrawAmount + spending);
						withdrawals++;
						totalWithdrawn += withdrawAmount;
						bankProfit += spending;
						System.out.printf("Withdrew $%.2f (1%% spending applied).%n", withdrawAmount);
					} else {
						System.out.println("Insufficient funds or invalid amount.");
					}
				} else if (option == 4) {
					System.out.println("Transaction Summary:");
					System.out.printf("Total Deposited: $%.2f%n", totalDeposited);
					System.out.printf("Total Withdrawn: $%.2f%n", totalWithdrawn);
					break;
				} else {
					System.out.println("Invalid option. Please try again.");
				}
			}
			// Update account balances
			if (choice == 1) {
				account1Balance = accountBalance;
			} else if (choice == 2) {
				account2Balance = accountBalance;
			} else if (choice == 3) {
				account3Balance = accountBalance;
			}
		}
		scanner.close();
	}
}
