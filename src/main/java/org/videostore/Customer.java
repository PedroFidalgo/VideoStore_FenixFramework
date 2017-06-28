package org.videostore;

import java.util.Vector;

import pt.ist.fenixframework.FenixFramework;

public class Customer extends Customer_Base {
	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();
	
	public Customer (String name){
		this.name = name;
		FenixFramework.getDomainRoot().addCustomer(this);
	}
	
	public void delete() {
		setRoot(null);

		deleteDomainObject();
	}
	
	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}
	
	public String getName (){
		return name;
	}
	
	public String statement() {
		String result = "Rental Record for " + getName() + "\n";
		for (Rental rental : rentals) {
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle()+ "\t"
					+ String.valueOf(rental.getCharge()) + "\n";
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
		+ " frequent renter points";
		return result;
	}
	
	private double getTotalAmount () {
		double totalAmount = 0;
		for (Rental rental : rentals) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}
	
	private int getTotalFrequentRenterPoints () {
		int frequentRenterPoints = 0;
		for (Rental rental : rentals) {
			frequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}
}
