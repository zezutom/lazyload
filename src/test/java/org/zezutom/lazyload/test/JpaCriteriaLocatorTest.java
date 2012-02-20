package org.zezutom.lazyload.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.zezutom.lazyload.service.Locator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:openjpa-context.xml")
public class JpaCriteriaLocatorTest {
	
	@Resource(name="jpaCriteriaLocator")
	private Locator locator;
		
	@Test
	public void preLoadedAddressesViaJpaCriteriaShouldBeAvailable() {
		TestUtil.assertPersonalDetails(locator.find(1l));
	}
	
}
