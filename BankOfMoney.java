import java.util.Scanner;

public class BankOfMoney {
	public static void main(String[] args) {

		String account1Name = "Khalid";
		double account1Balance = 22;
		String account2Name = "Anas";
		double account2Balance = 15.00;
		String account3Name = "Abdulaziz";
		double account3Balance = 8.00;
		double bankProfit = 0.0;
		double TransferMoney = 0.0;
		double Charges = 0.0;
		int Transfers = 0, deposits = 0, withdrawals = 0;
		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("*******************************");
			System.out.println("Welcome to our bank");
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
				System.out.printf("Total Profit from funds and Charges: $%.2f%n", bankProfit);

				if (deposits == withdrawals & deposits == Transfers & Transfers == withdrawals) {
					System.out.println(" all operations are equal");
				} else if (deposits >= withdrawals & deposits >= Transfers) {
					if (deposits == withdrawals)
						System.out.println("withdrawals and deposits are most used operations");
					else if (deposits == Transfers)
						System.out.println("Transfers and deposits are most used operations");
					else
						System.out.println("deposits is most used operation");
				} else if (withdrawals >= deposits & withdrawals >= Transfers) {
					if (withdrawals == deposits)
						System.out.println("withdrawals and deposits are most used operations");
					else if (withdrawals == Transfers)
						System.out.println("withdrawals and Transfers are most used operations");
					else
						System.out.println("withdrawals is most used operation");
				} else {
					if (Transfers == deposits)
						System.out.println(" deposits and Transfers are most used operations");
					else if (Transfers == withdrawals)
						System.out.println("withdrawals and Transfers are most used operations");
					else
						System.out.println("Transfers is most used operation");
				}

				continue;
			}
			String accountName;
			double accountBalance = 0;
			if (choice == 1 || choice == 101) {
				accountName = account1Name;
				accountBalance = account1Balance;
			} else if (choice == 2 || choice == 102) {
				accountName = account2Name;
				accountBalance = account2Balance;
			} else if (choice == 3 || choice == 103) {
				accountName = account3Name;
				accountBalance = account3Balance;
			} else {
				System.out.println("Invalid option. Please try again.");
				continue;
			}
			double totalDeposited = 0, totalWithdrawn = 0;
			while (true) {
				System.out.println("\nAccount Operations for " + accountName);
				System.out.println("1. View Balance");
				System.out.println("2. Deposit Money");
				System.out.println("3. Withdraw Money");
				System.out.println("4. Transfer Money");
				System.out.println("5. Exit");
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
					System.out.println("Enter The Account that you want to transfer to :");
					System.out.println("choose from:");
					System.out.println("1. Khalid (Account 101), 2. Anas (Account 102), 3. Abdulaziz (Account 103).");
					int SelectedAccount = scanner.nextInt();
					if (SelectedAccount == choice) {
						System.out.println("You can't transfer to the same account");
						continue;
					} else if (SelectedAccount != 1 && SelectedAccount != 2 && SelectedAccount != 3)
						System.out.println("incorrect Account");
					else {
						System.out.println("Choose The Amount of money to transfer:(2.5% Charges will apply) ");
						TransferMoney = scanner.nextDouble();
						Charges = TransferMoney * 0.025;

						if (TransferMoney > 0 && accountBalance >= (TransferMoney + Charges)) {
							accountBalance -= (TransferMoney + Charges);
							bankProfit += Charges;
							Transfers++;

							if (SelectedAccount == 1 || SelectedAccount == 101) {
								account1Balance += TransferMoney;
								System.out
										.println("You have successfully completed a money transfer to " + account1Name);
								System.out.println("And His New Balance is = " + account1Balance);
							} else if (SelectedAccount == 2 || SelectedAccount == 102) {
								account2Balance += TransferMoney;
								System.out
										.println("You have successfully completed a money transfer to " + account2Name);
								System.out.println("And His New Balance is = " + account2Balance);
							} else if (SelectedAccount == 3 || SelectedAccount == 103) {
								account3Balance += TransferMoney;
								System.out
										.println("You have successfully completed a money transfer to " + account3Name);
								System.out.println("And His New Balance is = " + account3Balance);
							}
						} else {
							System.out.println("You don't have enough funds.");
						}
					}
				}

				else if (option == 5) {
					System.out.println("Transaction Summary:");
					System.out.printf("Total Deposited: $%.2f%n", totalDeposited);
					System.out.printf("Total Withdrawn: $%.2f%n", totalWithdrawn);
					System.out.printf("Total Transfer: $%.2f%n", TransferMoney);
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
