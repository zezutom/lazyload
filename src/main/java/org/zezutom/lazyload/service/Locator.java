package org.zezutom.lazyload.service;

import org.zezutom.lazyload.model.Person;


/**
 * Provides personal address details.
 * 
 * @author tomasz
 *
 */
public interface Locator {


	/**
	 * Finds a person by id
	 * 	 
	 * @param id
	 * @return	found Person or null
	 */
	Person find(Long id);	
}
