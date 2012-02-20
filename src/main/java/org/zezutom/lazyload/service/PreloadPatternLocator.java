package org.zezutom.lazyload.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import org.zezutom.lazyload.model.Person;

@Service("preloadPatternLocator")
public class PreloadPatternLocator implements Locator {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Person find(Long id) {
        return (Person) em.createQuery("select distinct p from Person p left join fetch p.addresses where p.id = :id").setParameter("id", id).getSingleResult();
    }
}
