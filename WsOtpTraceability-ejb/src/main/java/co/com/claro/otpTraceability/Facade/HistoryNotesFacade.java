/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpTraceability.Facade;

import co.com.claro.otpTraceability.entity.HistoryNotes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ECM0210H
 */
@Stateless
public class HistoryNotesFacade extends AbstractFacade<HistoryNotes> {

    @PersistenceContext(unitName = "UpdateCase")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoryNotesFacade() {
        super(HistoryNotes.class);
    }

    public HistoryNotes buscarPorCuenta(HistoryNotes request) {
        String validarIdNotas = "";
        if (request.getIdNotes() != null) {
            validarIdNotas = "q.accountNumber = '" + request.getIdNotes() + "'";
        }
        String validarIdCaso = "";
        if (request.getIdCase() != null) {
            validarIdCaso = "q.idCase = '" + request.getIdCase() + "'";
        }
        String validarNotas = "";
        if (request.getNotes() != null) {
            validarNotas = "q.notes = '" + request.getNotes() + "'";
        }
        String validarUsuario = "";
        if (request.getUserCreate() != null) {
            validarUsuario = "q.userCreate = '" + request.getUserCreate() + "'";
        }
        String validarFecha = "";
        if (request.getDateCreate() != null) {
            validarFecha = "q.dateCreate = '" + request.getDateCreate() + "'";
        }
        String validarEstado = "";
        if (request.getIdState() != null) {
            validarEstado = "q.idState = '" + request.getIdState() + "'";
        }

        if (validarIdNotas.length() > 1) {
            if (validarIdCaso.length() > 1) {
                validarIdCaso = " AND " + validarIdCaso;
            }
            if (validarNotas.length() > 1) {
                validarNotas = " AND " + validarNotas;
            }
            if (validarUsuario.length() > 1) {
                validarUsuario = " AND " + validarUsuario;
            }
            if (validarFecha.length() > 1) {
                validarFecha = " AND " + validarFecha;
            }
            if (validarEstado.length() > 1) {
                validarEstado = " AND " + validarEstado;
            }
        }

        List<HistoryNotes> lista = (List<HistoryNotes>) em.createQuery("SELECT q FROM HistoryNotes q WHERE " + validarIdNotas + validarIdCaso + validarNotas + validarUsuario + validarFecha + validarEstado).getResultList();
        if (lista.size() > 0) {
            HistoryNotes obj = lista.get(0);
            return obj;
        } else {
            return null;
        }
    }
}
