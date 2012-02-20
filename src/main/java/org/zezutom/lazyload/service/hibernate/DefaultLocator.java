package org.zezutom.lazyload.service.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import org.zezutom.lazyload.model.Person;
import org.zezutom.lazyload.service.Locator;

@Service("defaultLocator")
public class DefaultLocator implements Locator {

	@PersistenceContext
	private EntityManager em;
	
	public Person find(Long id) {
		return em.find(Person.class, id);
	}
}
