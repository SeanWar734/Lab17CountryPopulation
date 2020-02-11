package population.main.com;

public class Country {
	String name;
	String population;

	public String getName() {
		return name;
	}

	public Country(String name, String population) {
		super();
		this.name = name;
		this.population = population;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + "]";
	}

}
