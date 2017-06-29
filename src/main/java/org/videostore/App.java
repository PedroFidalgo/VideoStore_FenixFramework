package org.videostore;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.Atomic.TxMode;

public class App {
	@Atomic(mode = TxMode.WRITE)
	public static void main(String[] args) {
		Movie newRelease = new Movie("Jaws", 1);
		Rental rental1 = new Rental(newRelease, 3);
		Customer customer = new Customer("Mary");
		customer.addRental(rental1);
		System.out.println(customer.statement());
	}
}
