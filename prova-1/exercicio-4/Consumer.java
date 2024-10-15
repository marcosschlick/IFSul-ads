import java.text.DecimalFormat;

public class Consumer {

	private String name;
	private String birthDate;
	private String adress;
	private String sex;
	private double balance;
	private double bill;
	private int buyedAmount = 0;
	private StringBuilder buyes = new StringBuilder();

	public Consumer() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getBalance() {
		return balance;
	}

	public double getBill() {
		return bill;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBuyes() {
		return this.buyes.toString();
	}

	public void buy(Product product) {
		DecimalFormat decimal = new DecimalFormat("#.##");



		if (product.getPrice() <= getBalance() && buyedAmount > 0) {
			this.balance -= product.getPrice();
			this.bill += product.getPrice();
			buyes.append(product.getName() + " R$ " + decimal.format(product.getPrice()) + " à vista  |  ");

		} else if (product.getPrice() > getBalance() || buyedAmount == 1){
			this.bill += (product.getPrice() * 1.25);
			product.applyInterest();
			buyes.append(product.getName() + " R$ " + decimal.format(product.getPrice()) + " à credito  |  ");
		}
		this.buyedAmount++;

	}

}
