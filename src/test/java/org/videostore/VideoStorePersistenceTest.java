package org.videostore;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.Atomic.TxMode;
import pt.ist.fenixframework.FenixFramework;

public class VideoStorePersistenceTest {
	private static final String CUSTOMER_NAME = "Alice";
	private static final String MOVIE_TITLE = "Jaws";
	private static final int PRICE_CODE = 1;
	private static final int DAYS_RENTED = 3;
	
	@Test
	public void success () {
		atomicProcess();
		atomicAssert();
	}
	
	@SuppressWarnings("unused")
	@Atomic(mode = TxMode.WRITE)
	public void atomicProcess () {
		Customer customer = new Customer(CUSTOMER_NAME);
//		Movie movie = new Movie(MOVIE_TITLE, PRICE_CODE);
//		Rental rental = new Rental(movie, DAYS_RENTED);
//		customer.addRental(rental);
	}
	
	
	@Atomic(mode = TxMode.READ)
	public void atomicAssert () {
		assertEquals(1, FenixFramework.getDomainRoot().getCustomerSet().size());
		
		List<Customer> customers = new ArrayList<Customer>(FenixFramework.getDomainRoot().getCustomerSet());
		Customer customer = customers.get(0);
		
		assertEquals(CUSTOMER_NAME, customer.getName());
		
	}
	
	@After
	@Atomic(mode = TxMode.WRITE)
	public void tearDown () {
		for (Customer customer : FenixFramework.getDomainRoot().getCustomerSet()) {
			customer.delete();
		}
	}
}
