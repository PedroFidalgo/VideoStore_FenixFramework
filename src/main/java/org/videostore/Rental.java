package org.videostore;

public class Rental extends Rental_Base {
	public Rental(Movie movie, int daysRented) {
		setMovie(movie);
		setDaysRented(daysRented);
	}
	
	public void delete() {
		this.setCustomer(null);
		this.getMovie().delete();
		this.deleteDomainObject();
	}

	public double getCharge () {
		return getMovie().getCharge(getDaysRented());
	}
	public int getFrequentRenterPoints () {
		return getMovie().getFrequentRenterPoints(getDaysRented());
	}
}