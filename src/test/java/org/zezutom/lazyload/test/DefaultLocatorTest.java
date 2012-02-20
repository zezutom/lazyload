package org.zezutom.lazyload.test;

import javax.annotation.Resource;

import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.zezutom.lazyload.service.Locator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:hibernate-context.xml")
public class DefaultLocatorTest {

	@Resource(name="defaultLocator")
	private Locator locator;
		
	@Test(expected=LazyInitializationException.class)
	public void noAddressShouldBeLoadedByDefault() {
		// Hibernate will complain that no address was loaded by throwing the LazyInitializationException
		TestUtil.assertPersonalDetails(locator.find(1l));
	}
}
