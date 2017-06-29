package org.videostore;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.fenixframework.core.WriteOnReadError;

public class App {
	public static void main(String[] args) {
		try {
			FenixFramework.getTransactionManager().begin(false);
			Movie newRelease = new Movie("Jaws", 1);
			Rental rental1 = new Rental(newRelease, 3);
			Customer customer = new Customer("Mary");
			customer.addRental(rental1);
			System.out.println(customer.statement());
			FenixFramework.getTransactionManager().rollback();
			FenixFramework.shutdown();
		} catch (WriteOnReadError | NotSupportedException | SystemException e) {
			e.printStackTrace();
		}

	}
}
