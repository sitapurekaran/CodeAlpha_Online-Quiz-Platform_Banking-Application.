package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

class BankAccount {
	static double Bank_Balance;
	String employee_Name;
	double user_name;
	int employee_id;
	ConnectionTest test = new ConnectionTest();
	Connection connection = null;

	BankAccount() {
		this.employee_Name = employee_Name;
		this.employee_id = employee_id;
	}

	public void deposit(double amount) {
		if (amount != 0) {
			Bank_Balance += amount;

			try {
				connection = test.getCon();
				PreparedStatement p = connection.prepareStatement

				("UPDATE  employee_details SET Bank_Balance =?");
				p.setDouble(1, amount);

				int i = p.executeUpdate();
				System.out.println("Record is inserted." + i);

			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public void withdraw(double amt) {
		if (amt != 0 && Bank_Balance >= amt) {
			Bank_Balance -= amt;
		} else if (Bank_Balance < amt) {
			System.out.println("Bank balance insufficient");
		}
	}

	public void menu(String username) {
		try {

			connection = test.getCon();
			PreparedStatement p = connection.prepareStatement("select * from employee_details");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				if (rs.getString(2).equals(username)) {
					char option;
					do {
						Scanner sc = new Scanner(System.in);
						System.out.println("Welcome " + rs.getString(2));
						System.out.println("Your ID:" + rs.getInt(1));

						System.out.println("a) Check Balance");
						System.out.println("b) Deposit Amount");
						System.out.println("c) Withdraw Amount");

						System.out.println("e) Exit");

						System.out.println("********************************************");
						System.out.println("Choose an option");
						option = sc.next().charAt(0);
						System.out.println("\n");

						switch (option) {
						case 'a':
							System.out.println("......................");
							System.out.println("Balance =" + Bank_Balance);
							System.out.println("......................");
							System.out.println("\n");
							break;
						case 'b':
							System.out.println("......................");
							System.out.println("Enter a amount to deposit :");
							System.out.println("......................");
							double amt = sc.nextDouble();
							deposit(amt);
							System.out.println("\n");
							break;
						case 'c':
							System.out.println("......................");
							System.out.println("Enter a amount to Withdraw :");
							System.out.println("......................");
							double amtW = sc.nextDouble();
							withdraw(amtW);
							System.out.println("\n");
							break;

						case 'e':
							System.out.println("......................");
							break;
						default:
							System.out.println("Choose a correct option to proceed");
							break;
						}

					} while (option != 'e');

				}

			}
			p.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		char option;
		System.out.println("Thank you for using our banking services");
	}
}
