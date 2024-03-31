package Bank;

public class UserData {
	private int employee_id;
	private String employee_name;
	private String user_name;
	private String password;
	private double Bank_Balance;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBank_Balance() {
		return Bank_Balance;
	}
	public void setBank_Balance(double bank_Balance) {
		Bank_Balance = bank_Balance;
	}
	public UserData(int employee_id, String employee_name, String user_name, String password, double Bank_Balance) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.user_name = user_name;
		this.password = password;
		Bank_Balance = Bank_Balance;
	}
	public UserData() {
		super();
	
		
	}
	@Override
	public String toString() {
		return "UserData [employee_id=" + employee_id + ", employee_name=" + employee_name + ", user_name=" + user_name
				+ ", password=" + password + ", Bank_Balance=" + Bank_Balance + "]";
	}
	
	
}