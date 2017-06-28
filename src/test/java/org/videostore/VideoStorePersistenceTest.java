package org.videostore;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.Atomic.TxMode;
import pt.ist.fenixframework.FenixFramework;

public class VideoStorePersistenceTest {
	private static final String CUSTOMER_NAME = "Alice";
	@Test
	public void success () {
		atomicProcess();
		atomicAssert();
	}
	
	@SuppressWarnings("unused")
	@Atomic(mode = TxMode.WRITE)
	public void atomicProcess () {
		Customer customer = new Customer(CUSTOMER_NAME);
	}
	
	
	@Atomic(mode = TxMode.READ)
	public void atomicAssert () {
		assertEquals(1, FenixFramework.getDomainRoot().getCustomerSet().size());
	}
	
	@After
	@Atomic(mode = TxMode.WRITE)
	public void tearDown () {
		for (Customer customer : FenixFramework.getDomainRoot().getCustomerSet()) {
			customer.delete();
		}
	}
}
