package org.zezutom.lazyload.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.zezutom.lazyload.service.Locator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:hibernate-context.xml")
public class PreloadPatternLocatorTest {
	
	@Resource(name="preloadPatternLocator")
	private Locator locator;
			
	@Test
	public void preLoadedAddressesShouldBeAvailable() {
		// Addresses should be loaded up-front and therefore available
		TestUtil.assertPersonalDetails(locator.find(1l));		
	}
}
