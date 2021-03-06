package org.videostore;

public class RegularPrice implements Price {

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}
	@Override
	public double getCharge(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2)
			thisAmount += (daysRented - 2) * 1.5;
		return thisAmount;
	}

}
