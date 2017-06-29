package org.videostore;

public class Rental extends Rental_Base {
	private Movie movie;
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		setDaysRented(daysRented);
	}
	
	public void delete() {
		this.setCustomer(null);
		// TODO: delete movie when persistent
		this.deleteDomainObject();
	}
	
	public Movie getMovie() {
		return movie;
	}
	public double getCharge () {
		return movie.getCharge(getDaysRented());
	}
	public int getFrequentRenterPoints () {
		return movie.getFrequentRenterPoints(getDaysRented());
	}
}