package org.zezutom.lazyload.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.zezutom.lazyload.model.Address;
import org.zezutom.lazyload.model.Person;

public class TestUtil {

	private TestUtil() {}
	
	public static void assertPersonalDetails(Person person) {	
		assertNotNull(person);				
		
		Collection<Address> addresses = person.getAddresses();		
		
		assertNotNull(addresses);
		assertThat(addresses.size(), is(3));		
	}	
}
