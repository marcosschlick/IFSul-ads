public enum Rules {

	PEDRA("LAGARTO, TESOURA"), PAPEL("PEDRA, SPOCK"), TESOURA("PAPEL, LAGARTO"), LAGARTO("SPOCK, PAPEL"),
	SPOCK("TESOURA, PEDRA");

	private String description;

	Rules(String description) {
		this.description = description;
	}

	private String getDescription() {
		return this.description;
	}

	public int play(Rules oponent) {
		if (this.name() == oponent.name()) {
			return 0;
		} else if (this.getDescription().contains(oponent.name())) {
			return 1;
		} else if (oponent.getDescription().contains(this.name())) {
			return 2;
		} else {
			return 0;
		}
	}

}
