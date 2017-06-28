package org.videostore;

import pt.ist.fenixframework.FenixFramework;

public class Customer extends Customer_Base {
	
	public Customer (String name){
		this.setName(name);
		FenixFramework.getDomainRoot().addCustomer(this);
	}
	
	public void delete() {
		setRoot(null);
		
		for (Rental rental : this.getRentalSet()) {
			rental.delete();
		}
		
		deleteDomainObject();
	}
	
	public String statement() {
		String result = "Rental Record for " + getName() + "\n";
		for (Rental rental : this.getRentalSet()) {
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
		for (Rental rental : this.getRentalSet()) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}
	
	private int getTotalFrequentRenterPoints () {
		int frequentRenterPoints = 0;
		for (Rental rental : this.getRentalSet()) {
			frequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}
}
