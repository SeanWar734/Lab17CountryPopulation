package population.main.com;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {
	
	private static FileHelper<Country> fileHelper = new FileHelper<>("src/countries.txt", new CountryLineConverter());
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		List<Country> countries = fileHelper.readAll();
		
		fileHelper.rewrite(Arrays.asList(new Country("China", "1,439,000,000")));
		fileHelper.append(new Country("India", "1,380,000,000"));
		fileHelper.append(new Country("United States", "327,000,000"));
		fileHelper.append(new Country("Indonesia", "273,000,000"));
		
		System.out.println("==============================================================");
		System.out.println("Welcome to the Countries Maintenance Application!");
		
		boolean keepGoing = true;
		
		while (keepGoing) {
			System.out.println("==============================================================");
			countries = fileHelper.readAll();
			
			System.out.println("What would you like to do?");
			printMenu();
			int menuOption = scnr.nextInt();
			
			switch (menuOption) {
			
			case 1:
				System.out.println("==============================================================");
				printList(countries);
				break;
			
			case 2:
				fileHelper.append(addCountry());
				System.out.println("==============================================================");
				System.out.println("Country added!");
				break;
			
			case 3:
				keepGoing = false;
				break;
			}
		}
		System.out.println("Have a nice day!");
		System.out.println("==============================================================");
	}

	public static void printList(List<Country> list) {

		int j = 1;

		for (Country c : list) {
			System.out.printf(j + ") %-20s | %-20s", c.getName(), c.getPopulation());
			System.out.println();
			j++;
		}
	}

	public static void printMenu() {
		System.out.println("1 - List Countries");
		System.out.println("2 - Add a Country");
		System.out.println("3 - Exit");
	}

	public static Country addCountry() {

		Scanner scnr = new Scanner(System.in);

		String country = Validator.getString(scnr, "Please enter the country name");
		String population = Validator.getString(scnr, "Please enter the population of the country");

		Country newCountry = new Country(country, population);

		return newCountry;
	}

}
