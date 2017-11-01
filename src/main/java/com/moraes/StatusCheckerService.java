package com.moraes;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class StatusCheckerService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void checkNow (StatusCheck.Status status) {
        em.persist(StatusCheck.now(status));
    }

}
