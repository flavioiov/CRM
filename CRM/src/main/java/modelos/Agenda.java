/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Flavio
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findById", query = "SELECT a FROM Agenda a WHERE a.id = :id")
    , @NamedQuery(name = "Agenda.findByIdatendimento", query = "SELECT a FROM Agenda a WHERE a.idatendimento = :idatendimento")
    , @NamedQuery(name = "Agenda.findByEvento", query = "SELECT a FROM Agenda a WHERE a.evento = :evento")
    , @NamedQuery(name = "Agenda.findByData", query = "SELECT a FROM Agenda a WHERE a.data = :data")
    , @NamedQuery(name = "Agenda.findByObs", query = "SELECT a FROM Agenda a WHERE a.obs = :obs")
    , @NamedQuery(name = "Agenda.findByAgendacol", query = "SELECT a FROM Agenda a WHERE a.agendacol = :agendacol")
    , @NamedQuery(name = "Agenda.findByStatus", query = "SELECT a FROM Agenda a WHERE a.status = :status")
    , @NamedQuery(name = "Agenda.findByDatainserido", query = "SELECT a FROM Agenda a WHERE a.datainserido = :datainserido")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idatendimento")
    private Integer idatendimento;
    @Size(max = 45)
    @Column(name = "evento")
    private String evento;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 500)
    @Column(name = "obs")
    private String obs;
    @Size(max = 45)
    @Column(name = "agendacol")
    private String agendacol;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Column(name = "datainserido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainserido;
    @Size(max = 45)
    @Column(name = "corretor")
    private String corretor;
    @Size(max = 45)
    @Column(name = "cliente")
    private String cliente;
    
           @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;
    
       @Size(max = 45)
    @Column(name = "horaagendada")
    private String horaagendada;

    public Agenda() {
    }

    public String getHoraagendada() {
        return horaagendada;
    }

    public void setHoraagendada(String horaagendada) {
        this.horaagendada = horaagendada;
    }

    
    
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
    
    public String getCorretor() {
        return corretor;
    }

    public void setCorretor(String corretor) {
        this.corretor = corretor;
    }
    
    

    public Agenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdatendimento() {
        return idatendimento;
    }

    public void setIdatendimento(Integer idatendimento) {
        this.idatendimento = idatendimento;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getAgendacol() {
        return agendacol;
    }

    public void setAgendacol(String agendacol) {
        this.agendacol = agendacol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatainserido() {
        return datainserido;
    }

    public void setDatainserido(Date datainserido) {
        this.datainserido = datainserido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Agenda[ id=" + id + " ]";
    }
    
}
