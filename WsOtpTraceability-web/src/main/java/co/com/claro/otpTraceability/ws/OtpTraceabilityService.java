/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpTraceability.ws;

import co.com.claro.otpTraceability.Facade.HistoryNotesFacade;
import co.com.claro.otpTraceability.entity.HistoryNotes;
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
 * @author omarMad
 */
@Path("OtpTraceability")
@Stateless
@TransactionManagement
public class OtpTraceabilityService {
    
    public OtpTraceabilityService() {
    }
    
    @EJB
    private HistoryNotesFacade pqrFacade;
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("create")
    public responseActualizar create(HistoryNotes request) {
        responseActualizar response = new responseActualizar();
        try {
            Validaciones val = new Validaciones();
            request.setDateCreate(new Date());
            request.setIdState(1);
            if (val.campoLleno(request.getIdCase()) && val.campoLleno(request.getNotes()) && val.campoLleno(request.getUserCreate())) {
                request.setIdNotes((pqrFacade.findAll().size() + 1));
                pqrFacade.create(request);
                response.isValid = true;
                response.description = "Transaction Complete";
            } else {
                response.isValid = false;
                response.description = "Debe ir el ID del caso, la nota y usuario de creación.";
            }
        } catch (Exception e) {
            response.isValid = false;
            response.description = "Falla del servicio de actualizacion de notas. Descripción: " + e.getMessage();
        }
        return response;
    }
}
