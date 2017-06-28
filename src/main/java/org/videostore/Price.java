package org.videostore;

public interface Price {
	public abstract int getPriceCode();
	public abstract double getCharge (int daysRented);
	public default int getFrequentRenterPoints (int daysRented) {
		return 1;
	}
}
