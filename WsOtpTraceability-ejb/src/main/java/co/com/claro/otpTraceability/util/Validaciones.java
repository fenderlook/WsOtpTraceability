/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpTraceability.util;

import co.com.claro.otpTraceability.entity.TraceabilityOtp;

/**
 *
 * @author vargascarr
 */
public class Validaciones {

    public TraceabilityOtp validarNulos(TraceabilityOtp request, TraceabilityOtp objetoActualizar) {

        if (campoLleno(request.getIdTraza() + "")) {
            objetoActualizar.setIdTraza(request.getIdTraza());
        }
        if (campoLleno(request.getDocumentTraza())) {
            objetoActualizar.setDocumentTraza(request.getDocumentTraza());
        }
        if (campoLleno(request.getMinTraza())) {
            objetoActualizar.setMinTraza(request.getMinTraza());
        }
        if (campoLleno(request.getCvcTraza())) {
            objetoActualizar.setCvcTraza(request.getCvcTraza());
        }
        if (campoLleno(request.getDescriptionTraza() + "")) {
            objetoActualizar.setDescriptionTraza(request.getDescriptionTraza());
        }
        if (campoLleno(request.getFlowTraza() + "")) {
            objetoActualizar.setFlowTraza(request.getFlowTraza());
        }
        if (campoLleno(request.getApplicationTraza() + "")) {
            objetoActualizar.setApplicationTraza(request.getApplicationTraza());
        }
        if (campoLleno(request.getDataTraza() + "")) {
            objetoActualizar.setDataTraza(request.getDataTraza());
        }
        if (campoLleno(request.getValueTraza() + "")) {
            objetoActualizar.setValueTraza(request.getValueTraza());
        }
        if (campoLleno(request.getUserCreate() + "")) {
            objetoActualizar.setUserCreate(request.getUserCreate());
        }
        if (campoLleno(request.getDateCreate()+ "")) {
            objetoActualizar.setDateCreate(request.getDateCreate());
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
