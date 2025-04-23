public class ex27_car {

	private int year;
	private String brand;
	private String model;
	private String color;

	public ex27_car(String brand, String model) {
		this.brand = brand;
		this.model = model;

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
