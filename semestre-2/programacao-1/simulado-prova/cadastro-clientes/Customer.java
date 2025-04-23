import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	private String name;
	private String surname;
	private String user;
	private String institution;

	public Customer(String message) {
		setCostumer(message);
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getUser() {
		return user;
	}

	public String getInstitution() {
		return institution;
	}

	public void setCostumer(String message) {
		String regex = "^(\\w+)\\s+(?:\\w+\\s+)*(\\w+),\\s+(\\w+\\.?\\w+)@(\\w+)\\.\\w+";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(message);

		if (matcher.find()) {
			this.name = matcher.group(1);
			this.surname = matcher.group(2);
			this.user = matcher.group(3);
			this.institution = matcher.group(4);
		}

	}

}
