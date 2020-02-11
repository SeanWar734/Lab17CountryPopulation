package population.main.com;

public class CountryLineConverter implements LineConverter<Country> {

	@Override
	public String toLine(Country object) {
		return String.format("%s\t%s", object.getName(), object.getPopulation());
	}

	@Override
	public Country fromLine(String line) {
		String[] parts = line.split("\t");
		String name = parts[0];
		String team = parts[1];
		return new Country(name, team);
	}

}
