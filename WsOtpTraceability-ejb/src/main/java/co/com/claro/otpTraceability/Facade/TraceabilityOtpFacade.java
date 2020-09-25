/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpTraceability.Facade;

import co.com.claro.otpTraceability.entity.TraceabilityOtp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ECM0210H
 */
@Stateless
public class TraceabilityOtpFacade extends AbstractFacade<TraceabilityOtp> {

    @PersistenceContext(unitName = "UpdateCase")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraceabilityOtpFacade() {
        super(TraceabilityOtp.class);
    }

    public List<TraceabilityOtp> prueba() {
        List<TraceabilityOtp> lista = (List<TraceabilityOtp>) em.createQuery("SELECT t FROM TraceabilityOtp t").getResultList();
        return lista;
    }
}
