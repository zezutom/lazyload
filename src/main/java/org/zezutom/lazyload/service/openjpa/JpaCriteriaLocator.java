package org.zezutom.lazyload.service.openjpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import org.zezutom.lazyload.model.Person;
import org.zezutom.lazyload.service.Locator;

@Service("jpaCriteriaLocator")
public class JpaCriteriaLocator implements Locator {

	@PersistenceContext
	private EntityManager em;

	public Person find(Long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Person> query = cb.createQuery(Person.class);
		
		Root<Person> person = query.from(Person.class);
		person.fetch("addresses");
		
		Predicate condition = cb.equal(person.get("id"), id);
		query.where(condition);
				
		return em.createQuery(query.select(person)).getSingleResult();
	}
}
