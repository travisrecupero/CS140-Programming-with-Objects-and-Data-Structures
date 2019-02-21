package lab07;

public abstract class Herbivore extends Animal {

	private String foliage;
	private int aggressionLevel;

	abstract void graze();

	public Herbivore(String foliage, int aggressionLevel) {
		this.foliage = foliage;
		this.aggressionLevel = aggressionLevel;
	}

	public String getFoliage() {
		return foliage;
	}

	public int getAggressionLevel() {
		return aggressionLevel;
	}

	@Override
	public String toString() {
		return "A herbivore only eats plants. It can additionally perform the action graze, and has a foliage it eats.";
	}

}
