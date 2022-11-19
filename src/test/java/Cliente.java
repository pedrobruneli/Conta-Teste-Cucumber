

public class Cliente {

	private boolean isSpecial;
	private double balance;

	public Cliente() {
		this.balance = 0;
		this.isSpecial = false;
	}

	public Cliente(int balance) {
		this.balance = balance;
	}

	public Cliente(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public Cliente(int balance, boolean isSpecial) {
		this.balance = balance;
		this.isSpecial = isSpecial;
	}

	public boolean isSpecialCustomer() {
		return this.isSpecial;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setToSpecialCustomer() {
		this.isSpecial = true;
	}

	public void setToNormalCustomer() {
		this.isSpecial = false;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean withdraw(double balance) throws Exception {
		if (this.balance < balance) {
			if (this.isSpecialCustomer()) {
				this.removeBalance(balance);
				return true;
			}
			throw new Exception("Saldo insuficiente");
		}
		this.removeBalance(balance);
		return true;
	}

	public void removeBalance(double balance) {
		this.balance -= balance;
	}

}
