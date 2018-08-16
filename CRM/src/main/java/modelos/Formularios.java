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
@Table(name = "formularios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formularios.findAll", query = "SELECT f FROM Formularios f")
    , @NamedQuery(name = "Formularios.findByIdformulario", query = "SELECT f FROM Formularios f WHERE f.idformulario = :idformulario")
    , @NamedQuery(name = "Formularios.findByData", query = "SELECT f FROM Formularios f WHERE f.data = :data")
    , @NamedQuery(name = "Formularios.findByAssunto", query = "SELECT f FROM Formularios f WHERE f.assunto = :assunto")
    , @NamedQuery(name = "Formularios.findByFormulario", query = "SELECT f FROM Formularios f WHERE f.formulario = :formulario")
    , @NamedQuery(name = "Formularios.findByNome", query = "SELECT f FROM Formularios f WHERE f.nome = :nome")
    , @NamedQuery(name = "Formularios.findByLocal", query = "SELECT f FROM Formularios f WHERE f.local = :local")
    , @NamedQuery(name = "Formularios.findByMensagem", query = "SELECT f FROM Formularios f WHERE f.mensagem = :mensagem")
    , @NamedQuery(name = "Formularios.findByIp", query = "SELECT f FROM Formularios f WHERE f.ip = :ip")
    , @NamedQuery(name = "Formularios.findByTelefone", query = "SELECT f FROM Formularios f WHERE f.telefone = :telefone")
    , @NamedQuery(name = "Formularios.findByEmail", query = "SELECT f FROM Formularios f WHERE f.email = :email")})
public class Formularios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformulario")
    private Integer idformulario;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 75)
    @Column(name = "assunto")
    private String assunto;
    @Size(max = 100)
    @Column(name = "formulario")
    private String formulario;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 200)
    @Column(name = "local")
    private String local;
    @Size(max = 300)
    @Column(name = "mensagem")
    private String mensagem;
    @Size(max = 45)
    @Column(name = "ip")
    private String ip;
    @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    public Formularios() {
    }

    public Formularios(Integer idformulario) {
        this.idformulario = idformulario;
    }

    public Integer getIdformulario() {
        return idformulario;
    }

    public void setIdformulario(Integer idformulario) {
        this.idformulario = idformulario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformulario != null ? idformulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formularios)) {
            return false;
        }
        Formularios other = (Formularios) object;
        if ((this.idformulario == null && other.idformulario != null) || (this.idformulario != null && !this.idformulario.equals(other.idformulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Formularios[ idformulario=" + idformulario + " ]";
    }
    
}
