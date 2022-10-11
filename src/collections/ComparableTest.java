package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

class A {
	private void disp() {

	}
}

public class ComparableTest extends A {

	private void disp() {

	}

	public static void main(String[] args) {

		Country indiaCountry = new Country(1, "India");
		Country russiaCountry = new Country(4, "Russia");
		Country englandCountry = new Country(3, "England");
		Country germanyCountry = new Country(2, "Germany");

		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(russiaCountry);
		listOfCountries.add(englandCountry);
		listOfCountries.add(germanyCountry);

		Collections.sort(listOfCountries);

		// listOfCountries.stream().forEach();
		listOfCountries.forEach(country -> System.out.println(country.countryId));

		listOfCountries.stream().filter(country -> !country.getCountryName().equals("England")).forEach(
				country -> System.out.println(country.countryId + " Country Name " + country.getCountryName()));
	}

}

class Country implements Comparable<Country> {
	int countryId;
	String countryName;

	public Country(int countryId, String countryName) {
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public int compareTo(Country country) {
		return (this.countryId < country.countryId) ? -1 : this.countryId > country.countryId ? 1 : 0;
	}
}
