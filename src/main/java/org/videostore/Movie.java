package org.videostore;

public class Movie extends Movie_Base {
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDREN = 2;
	private Price price;
	public Movie(String title, int priceCode) {
		setTitle(title);
		setPriceCode(priceCode);
	}
	
	public void delete () {
		setRental(null);
		deleteDomainObject();
	}
	
	@Override
	public void setPriceCode(int arg) {
		super.setPriceCode(arg);
		switch (arg) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDREN:
			price = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code.");
		}
	}
	public double getCharge (int daysRented) {
		return price.getCharge(daysRented);
	}
	public int getFrequentRenterPoints (int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
}
