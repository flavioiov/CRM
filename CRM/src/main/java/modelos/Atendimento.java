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
@Table(name = "atendimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atendimento.findAll", query = "SELECT a FROM Atendimento a")
    , @NamedQuery(name = "Atendimento.findById", query = "SELECT a FROM Atendimento a WHERE a.id = :id")
    , @NamedQuery(name = "Atendimento.findByAtendente", query = "SELECT a FROM Atendimento a WHERE a.atendente = :atendente")
    , @NamedQuery(name = "Atendimento.findByComochegou", query = "SELECT a FROM Atendimento a WHERE a.comochegou = :comochegou")
    , @NamedQuery(name = "Atendimento.findByNome", query = "SELECT a FROM Atendimento a WHERE a.nome = :nome")
    , @NamedQuery(name = "Atendimento.findByTelefone", query = "SELECT a FROM Atendimento a WHERE a.telefone = :telefone")
    , @NamedQuery(name = "Atendimento.findByEmail", query = "SELECT a FROM Atendimento a WHERE a.email = :email")
    , @NamedQuery(name = "Atendimento.findByMsg", query = "SELECT a FROM Atendimento a WHERE a.msg = :msg")
    , @NamedQuery(name = "Atendimento.findByDataatendimento", query = "SELECT a FROM Atendimento a WHERE a.dataatendimento = :dataatendimento")
    , @NamedQuery(name = "Atendimento.findByIp", query = "SELECT a FROM Atendimento a WHERE a.ip = :ip")
    , @NamedQuery(name = "Atendimento.findByCorretor", query = "SELECT a FROM Atendimento a WHERE a.corretor = :corretor")
    , @NamedQuery(name = "Atendimento.findByEuquero", query = "SELECT a FROM Atendimento a WHERE a.euquero = :euquero")
    , @NamedQuery(name = "Atendimento.findByHoraatendimento", query = "SELECT a FROM Atendimento a WHERE a.horaatendimento = :horaatendimento")})
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "atendente")
    private String atendente;
    @Size(max = 45)
    @Column(name = "comochegou")
    private String comochegou;
    @Size(max = 245)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 145)
    @Column(name = "email")
    private String email;
    @Size(max = 500)
    @Column(name = "msg")
    private String msg;
    @Column(name = "dataatendimento")
    @Temporal(TemporalType.DATE)
    private Date dataatendimento;
    @Size(max = 45)
    @Column(name = "ip")
    private String ip;
    @Size(max = 45)
    @Column(name = "corretor")
    private String corretor;
    @Size(max = 45)
    @Column(name = "euquero")
    private String euquero;
    @Size(max = 45)
    @Column(name = "horaatendimento")
    private String horaatendimento;

    @Size(max = 45)
    @Column(name = "status")
    private String status;
    
    @Size(max = 5)
    @Column(name = "ddd")
    private String ddd;
    
    public Atendimento() {
    }

    public Atendimento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public String getComochegou() {
        return comochegou;
    }

    public void setComochegou(String comochegou) {
        this.comochegou = comochegou;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDataatendimento() {
        return dataatendimento;
    }

    public void setDataatendimento(Date dataatendimento) {
        this.dataatendimento = dataatendimento;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCorretor() {
        return corretor;
    }

    public void setCorretor(String corretor) {
        this.corretor = corretor;
    }

    public String getEuquero() {
        return euquero;
    }

    public void setEuquero(String euquero) {
        this.euquero = euquero;
    }

    public String getHoraatendimento() {
        return horaatendimento;
    }

    public void setHoraatendimento(String horaatendimento) {
        this.horaatendimento = horaatendimento;
    }

     public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
     public String getDDD() {
        return ddd;
    }

    public void setDDD(String ddd) {
        this.ddd = ddd;
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
        if (!(object instanceof Atendimento)) {
            return false;
        }
        Atendimento other = (Atendimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Atendimento[ id=" + id + " ]";
    }
    
}
