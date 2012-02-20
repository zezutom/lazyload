package org.zezutom.lazyload.service.hibernate;

import javax.annotation.Resource;

import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zezutom.lazyload.model.Person;
import org.zezutom.lazyload.service.Locator;

@Service("hibernateCriteriaLocator")
@Transactional
public class HibernateCriteriaLocator implements Locator {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public Person find(Long id) {
		return (Person) sessionFactory
				.getCurrentSession()
				.createCriteria(Person.class)
				.setFetchMode("addresses", FetchMode.JOIN)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
