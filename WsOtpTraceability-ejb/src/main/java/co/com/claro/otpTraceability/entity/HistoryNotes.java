/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpTraceability.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vargascarr
 */
@Entity
@Table(name = "HISTORY_NOTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryNotes.findAll", query = "SELECT p FROM HistoryNotes p")
})
public class HistoryNotes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_NOTES")
    @Getter
    @Setter
    private Integer idNotes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ID_CASE")
    @Getter
    @Setter
    private String idCase;
    @Size(max = 200)
    @Column(name = "NOTES")
    @Getter
    @Setter
    private String notes;
    @Size(max = 100)
    @Column(name = "USER_CREATE")
    @Getter
    @Setter
    private String userCreate;
    @Column(name = "DATE_CREATE")
    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Column(name = "ID_STATE")
    @Getter
    @Setter
    private Integer idState;

    public HistoryNotes() {
    }

}
