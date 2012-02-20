package org.zezutom.lazyload.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.zezutom.lazyload.service.Locator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:hibernate-context.xml")
public class HibernateCriteriaLocatorTest {
	
	@Resource(name="hibernateCriteriaLocator")
	private Locator hibernateLocator;
				
	@Test
	public void preLoadedAddressesViaHibernateCriteriaShouldBeAvailable() {
		TestUtil.assertPersonalDetails(hibernateLocator.find(1l));
	}
	
}
