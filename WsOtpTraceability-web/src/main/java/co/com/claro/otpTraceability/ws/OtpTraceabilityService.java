/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpTraceability.ws;

import co.com.claro.otpTraceability.Facade.TraceabilityOtpFacade;
import co.com.claro.otpTraceability.entity.TraceabilityOtp;
import co.com.claro.otpTraceability.entity.responseActualizar;
import co.com.claro.otpTraceability.util.Validaciones;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ws.rs.POST;

/**
 *
 * @author vargasCarr
 */
@Path("OtpTraceability")
@Stateless
@TransactionManagement
public class OtpTraceabilityService {
    
    public OtpTraceabilityService() {
    }
    
    @EJB
    private TraceabilityOtpFacade pqrFacade;
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("create")
    public responseActualizar create(TraceabilityOtp request) {
        responseActualizar response = new responseActualizar();
        try {
            Validaciones val = new Validaciones();
            request.setDateCreate(new Date());
            if (val.campoLleno(request.getDocumentTraza()) && val.campoLleno(request.getMinTraza()) && val.campoLleno(request.getCvcTraza()) && val.campoLleno(request.getUserCreate())) {
                request.setIdTraza((pqrFacade.findAll().size() + 1));
                pqrFacade.create(request);
                response.isValid = true;
                response.description = "Transaction Complete";
            } else {
                response.isValid = false;
                response.description = "Debe ir el número de documento, min, código CVC y usuario de creación.";
            }
        } catch (Exception e) {
            response.isValid = false;
            response.description = "Falla del servicio de registro de trazabilidad. Descripción: " + e.getMessage();
        }
        return response;
    }
}
