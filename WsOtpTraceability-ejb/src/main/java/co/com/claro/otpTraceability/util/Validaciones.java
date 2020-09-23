/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpTraceability.util;

import co.com.claro.otpTraceability.entity.HistoryNotes;

/**
 *
 * @author vargascarr
 */
public class Validaciones {

    public HistoryNotes validarNulos(HistoryNotes request, HistoryNotes objetoActualizar) {

        if (campoLleno(request.getIdNotes() + "")) {
            objetoActualizar.setIdNotes(request.getIdNotes());
        }
        if (campoLleno(request.getIdCase())) {
            objetoActualizar.setIdCase(request.getIdCase());
        }
        if (campoLleno(request.getNotes())) {
            objetoActualizar.setNotes(request.getNotes());
        }
        if (campoLleno(request.getUserCreate())) {
            objetoActualizar.setUserCreate(request.getUserCreate());
        }
        if (campoLleno(request.getDateCreate() + "")) {
            objetoActualizar.setDateCreate(request.getDateCreate());
        }
        if (campoLleno(request.getIdState() + "")) {
            objetoActualizar.setIdState(request.getIdState());
        }        

        return objetoActualizar;
    }

    public boolean campoLleno(String campo) {
        if (campo == null || campo.equals("") || campo.equals("null")) {
            return false;
        } else {
            return true;
        }
    }

}
