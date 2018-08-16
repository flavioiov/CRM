/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Flavio
 */
@Entity
@Table(name = "detalheatendimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalheatendimento.findAll", query = "SELECT d FROM Detalheatendimento d")
    , @NamedQuery(name = "Detalheatendimento.findById", query = "SELECT d FROM Detalheatendimento d WHERE d.id = :id")
    , @NamedQuery(name = "Detalheatendimento.findByValorminvenda", query = "SELECT d FROM Detalheatendimento d WHERE d.valorminvenda = :valorminvenda")
    , @NamedQuery(name = "Detalheatendimento.findByValormaxvenda", query = "SELECT d FROM Detalheatendimento d WHERE d.valormaxvenda = :valormaxvenda")
    , @NamedQuery(name = "Detalheatendimento.findByValorminaluguel", query = "SELECT d FROM Detalheatendimento d WHERE d.valorminaluguel = :valorminaluguel")
    , @NamedQuery(name = "Detalheatendimento.findByValormaxaluguel", query = "SELECT d FROM Detalheatendimento d WHERE d.valormaxaluguel = :valormaxaluguel")
    , @NamedQuery(name = "Detalheatendimento.findByOrigematendimento", query = "SELECT d FROM Detalheatendimento d WHERE d.origematendimento = :origematendimento")
    , @NamedQuery(name = "Detalheatendimento.findByTamanho", query = "SELECT d FROM Detalheatendimento d WHERE d.tamanho = :tamanho")})
public class Detalheatendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "negocio")
    private String negocio;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "tipoimovel")
    private String tipoimovel;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "bairros")
    private String bairros;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "caracteristicas")
    private String caracteristicas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorminvenda")
    private BigDecimal valorminvenda;
    @Column(name = "valormaxvenda")
    private BigDecimal valormaxvenda;
    @Column(name = "valorminaluguel")
    private BigDecimal valorminaluguel;
    @Column(name = "valormaxaluguel")
    private BigDecimal valormaxaluguel;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "detalhemsg")
    private String detalhemsg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "origematendimento")
    private int origematendimento;
    @Column(name = "tamanho")
    private Integer tamanho;

     private String[] bairrosArray;
     private String[] imovelArray;
     private String[] caracteristicasArray;
     private String[] negocioArray;

    public String[] getBairrosArray() {
        return bairrosArray;
    }

    public void setBairrosArray(String[] bairrosArray) {
        this.bairrosArray = bairrosArray;
    }

    public String[] getImovelArray() {
        return imovelArray;
    }

    public void setImovelArray(String[] imovelArray) {
        this.imovelArray = imovelArray;
    }

    public String[] getCaracteristicasArray() {
        return caracteristicasArray;
    }

    public void setCaracteristicasArray(String[] caracteristicasArray) {
        this.caracteristicasArray = caracteristicasArray;
    }

    public String[] getNegocioArray() {
        return negocioArray;
    }

    public void setNegocioArray(String[] negocioArray) {
        this.negocioArray = negocioArray;
    }
    
    public Detalheatendimento() {
    }

    public Detalheatendimento(Integer id) {
        this.id = id;
    }

    public Detalheatendimento(Integer id, int origematendimento) {
        this.id = id;
        this.origematendimento = origematendimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public String getTipoimovel() {
        return tipoimovel;
    }

    public void setTipoimovel(String tipoimovel) {
        this.tipoimovel = tipoimovel;
    }

    public String getBairros() {
        return bairros;
    }

    public void setBairros(String bairros) {
        this.bairros = bairros;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public BigDecimal getValorminvenda() {
        return valorminvenda;
    }

    public void setValorminvenda(BigDecimal valorminvenda) {
        this.valorminvenda = valorminvenda;
    }

    public BigDecimal getValormaxvenda() {
        return valormaxvenda;
    }

    public void setValormaxvenda(BigDecimal valormaxvenda) {
        this.valormaxvenda = valormaxvenda;
    }

    public BigDecimal getValorminaluguel() {
        return valorminaluguel;
    }

    public void setValorminaluguel(BigDecimal valorminaluguel) {
        this.valorminaluguel = valorminaluguel;
    }

    public BigDecimal getValormaxaluguel() {
        return valormaxaluguel;
    }

    public void setValormaxaluguel(BigDecimal valormaxaluguel) {
        this.valormaxaluguel = valormaxaluguel;
    }

    public String getDetalhemsg() {
        return detalhemsg;
    }

    public void setDetalhemsg(String detalhemsg) {
        this.detalhemsg = detalhemsg;
    }

    public int getOrigematendimento() {
        return origematendimento;
    }

    public void setOrigematendimento(int origematendimento) {
        this.origematendimento = origematendimento;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
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
        if (!(object instanceof Detalheatendimento)) {
            return false;
        }
        Detalheatendimento other = (Detalheatendimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Detalheatendimento[ id=" + id + " ]";
    }
    
}
