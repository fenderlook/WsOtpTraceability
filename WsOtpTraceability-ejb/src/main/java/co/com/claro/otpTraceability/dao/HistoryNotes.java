package co.com.claro.otpTraceability.dao;

import co.com.claro.otpTraceability.entity.*;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@NoArgsConstructor
public class HistoryNotes extends AbstractDao<HistoryNotes> {

    private EntityManager entityManager;

    public HistoryNotes(EntityManager entityManager){
        super(HistoryNotes.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public EntityManager setEntityManager(){
        return this.entityManager;
    }
}
