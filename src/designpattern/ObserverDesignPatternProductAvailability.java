package designpattern;

import java.util.ArrayList;
import java.util.Iterator;

//https://www.youtube.com/watch?v=Ocqj4vyzeQQ
//https://www.youtube.com/watch?v=hBVlL64AEEs

//it maintains one-to-many relationship
interface Observer {
	public void update(String availability);
}

interface Observable {
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();
}

class Person implements Observer {

	private String personName;
	Person(String personName, Observable sub) {
		this.personName = personName;
		sub.registerObserver(this);
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Override
	public void update(String availability) {
		System.out.println("Person Name " + getPersonName() + " Product is " + availability);
	}
}

class Product implements Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String productName;
	private String productType;
	private String productPrice;
	private String availability;

	public Product(String productName, String productType, String productPrice, String availability) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.availability = availability;
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
		System.out.println("Availability changed from Not available to Available");
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		System.out.println("Product Name :" + this.getProductName() + ", Product Type : " + this.productType
				+ ", product Price : " + this.productPrice + " is available now.So notifying all the users ");
		System.out.println();
		for (Observer observer : observers) {
			observer.update(this.availability);
		}
	}
}

public class ObserverDesignPatternProductAvailability {

	public static void main(String[] args) {

		Product samsungLEDTV = new Product("Samsung LED TV", "LED TV", "60000Rs", "Not available");
		// Person david object will be created and person david object will be
		// registered to the Observable
		Person david = new Person("David", samsungLEDTV);
		// Person john object will be created and person john object will be
		// registered to the Observable
		Person john = new Person("John", samsungLEDTV);

		ArrayList<Observer> subscribers = samsungLEDTV.getObservers();
		System.out.println("subscribers List : " + subscribers);
		for (Iterator<Observer> iterator = subscribers.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			System.out.println("This person has subscribed : " + person.getPersonName());
		}
		System.out.println();
		System.out.println("SamsungLED TV current state : " + samsungLEDTV.getAvailability());
		System.out.println();
		// Now product is available
		samsungLEDTV.setAvailability("Available");
	}
}
