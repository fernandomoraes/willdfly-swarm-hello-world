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
    public StatusCheck checkNow (StatusCheck.Status status) {
        final StatusCheck check = StatusCheck.now(status);
        em.persist(check);
        return check;
    }

}
