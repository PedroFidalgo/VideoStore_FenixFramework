package org.videostore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GeneralTest extends RollbackTestAbstractClass {

	private Customer customer1;
	private Customer customer2;
	private Customer customer3;
	private Customer customer4;
	private Movie newRelease;
	private Movie children;
	private Movie regular;
	private Rental rental1;
	private Rental rental2;
	private Rental rental3;
	
	@Override
	public void populate4Test() {
		newRelease = new Movie("Jaws", 1);
		children = new Movie("Snow White", 2);
		regular = new Movie("The Matrix", 0);
		rental1 = new Rental(newRelease, 3);
		rental2 = new Rental(children, 3);
		rental3 = new Rental(regular, 3);
		customer1 = new Customer("Mary");
		customer2 = new Customer("Ann");
		customer3 = new Customer("Joe");
		customer4 = new Customer("Tony");
		
	}
	
	@Test
	public void nameTest () {
		assertEquals("Mary", customer1.getName());
	}
	
	@Test
	public void daysrentedTest () {
		assertEquals(3, rental1.getDaysRented());
	}
	
	@Test
	public void frequentRenterPointsTest () {
		assertEquals(2, rental1.getFrequentRenterPoints());
	}
	
	@Test
	public void success1 () {
		customer1.addRental(rental1);
		assertEquals("Rental Record for Mary\n\tJaws\t9.0\nAmount owed is 9.0\nYou earned 2 frequent renter points", customer1.statement());
	}
	@Test
	public void success2 () {
		customer2.addRental(rental2);
		assertEquals("Rental Record for Ann\n\tSnow White\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points", customer2.statement());
	}
	
	@Test
	public void success3 () {
		customer3.addRental(rental3);
		assertEquals("Rental Record for Joe\n\tThe Matrix\t3.5\nAmount owed is 3.5\nYou earned 1 frequent renter points", customer3.statement());
	}
	@Test
	public void success4 () {
		customer4.addRental(rental1);
		customer4.addRental(rental2);
		customer4.addRental(rental3);
		assertEquals("Rental Record for Tony\n\tJaws\t9.0\n\tSnow White\t1.5\n\tThe Matrix\t3.5\nAmount owed is 14.0\nYou earned 4 frequent renter points", customer4.statement());
	}
}
