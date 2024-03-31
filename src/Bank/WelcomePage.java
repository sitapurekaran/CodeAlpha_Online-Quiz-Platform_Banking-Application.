package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class WelcomePage {
	public void welcome() {
		System.out.println("Welcome to Bank Application");
		System.out.println("***********************************************");
		System.out.println("Press 1.>>> ALREADY USER" + "   " + "  " + "Press 2.>>> NEW HERE");
		System.out.println("Please ans in (1) & (2)");
		char option;
		EmployeeLogin log = new EmployeeLogin();
		ConnectionTest test = new ConnectionTest();
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		option = sc.next().charAt(0);
		switch (option) {
		case '1':
			System.out.println("please enter your user_name");
			String user_name = sc.next();
			System.out.println("please enter your password");
			String password = sc.next();
			try {
				connection = test.getCon();
				PreparedStatement p = connection
						.prepareStatement("Select password, user_name from employee_details where user_name=? ");
				p.setString(1, user_name);
				ResultSet rs = p.executeQuery();
				while (rs.next()) {
					if (password.equals(rs.getString(1))) {
						System.out.println("****** LOGIN SUCESSFULL ****** ");
						System.out.println("Do you want to accses your account yes or no");
						String s = sc.next();
						if (s.equalsIgnoreCase("yes")) {
							BankAccount app = new BankAccount();
							app.menu(user_name);
						} else if (s.equalsIgnoreCase("no")) {
							System.out.println("thanks for using bank application visit again");
						} else {
							System.out.println("you select wrong option visit again");
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		case '2':
			log.login();
		}
	}

}

