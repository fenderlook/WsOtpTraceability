/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpTraceability.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import lombok.NoArgsConstructor;

/**
 *
 * @author ECM0210H
 */
@Stateless
@NoArgsConstructor
public class TraceabilityOtp extends AbstractDao<TraceabilityOtp> {

    private EntityManager entityManager;

    public TraceabilityOtp(EntityManager entityManager) {
        super(TraceabilityOtp.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public EntityManager setEntityManager() {
        return this.entityManager;
    }
}
