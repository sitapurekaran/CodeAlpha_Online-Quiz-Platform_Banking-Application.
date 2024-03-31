package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeLogin {

	public void login() {
		ConnectionTest test = new ConnectionTest();
		Connection connection = null;
		BankAccount bankAccount = new BankAccount();
		Scanner sc = new Scanner(System.in);
		System.out.println("please inter your employee_name");
		String employee_name = sc.next();
		System.out.println("please inter your user_name");
		String user_name = sc.next();
		System.out.println("please inter your password");
		String password = sc.next();
		try {
			connection = test.getCon();
			PreparedStatement p = connection.prepareStatement(
					"insert into employee_details(employee_name,user_name,password) " + "values (?,?,?)");
			p.setString(1, employee_name);
			p.setString(2, user_name);
			p.setString(3, password);
			
			int k = p.executeUpdate();
			System.out.println("**********REGISTRATION SUCSSEFULL*********");
			System.out.println("Do you want to accses your account");
			Scanner scan = new Scanner(System.in);
			System.out.println("please select yes or no");
			String ans = scan.next();

			if (ans.equalsIgnoreCase("yes")) {
				bankAccount.menu(user_name);
				}
	 else if (ans.equalsIgnoreCase("no")) {
				System.out.println("you select no option visit again");
			} else {
				System.out.println("you select wrong option please select right option");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
