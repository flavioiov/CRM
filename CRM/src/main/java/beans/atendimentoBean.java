/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import geral.Classe_Geral;
import geral.CustomDataSource;
import java.io.IOException;

import java.util.List;
import java.sql.SQLException;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;




/**
 *
 * @author Flavio
 */

import modelos.Atendimento;
import modelos.Detalheatendimento;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.primefaces.context.RequestContext;

@ManagedBean 
@SessionScoped

public class atendimentoBean {

    public List<Atendimento> getListaAtendimentos() {
        return listaAtendimentos;
    }

    public void setListaAtendimentos(List<Atendimento> listaAtendimentos) {
        this.listaAtendimentos = listaAtendimentos;
    }
    
    
    
    public List<Atendimento> listaAtendimentos;
    public List<Atendimento> listaAtendimentoDetalhe;

    public List<Atendimento> getListaAtendimentoDetalhe() {
        return listaAtendimentoDetalhe;
    }

    public void setListaAtendimentoDetalhe(List<Atendimento> listaAtendimentoDetalhe) {
        this.listaAtendimentoDetalhe = listaAtendimentoDetalhe;
    }
    
    
    
    
    //abre um objeto com um novo atendimento
    private Atendimento atd = new Atendimento();

    public Atendimento getAtd() {
        return atd;
    }

    public void setAtd(Atendimento atd) {
        this.atd = atd;
       
    }
    
    
    
    //abre um objeto com um detalhe de Atendimento
    private Detalheatendimento dtla = new Detalheatendimento();

    public Detalheatendimento getDtla() {
        return dtla;
    }

    public void setDtla(Detalheatendimento dtla) {
        this.dtla = dtla;
    }
    
    private String[] myArray;

    public String[] getMyArray() {
        return myArray;
    }

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }
    
    /*inserir os arrays no modelo detalheAtendimento
    
    
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

   */
     
    
    
    public void cadastrarAtendimento() throws SQLException, ParseException, IOException {
       
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String remoteIp = request.getRemoteAddr(); //pega o ip remoto

        java.util.Date d = new java.util.Date(); //quando trabalhar com data é necessário coverter de UTIL PARA SQL
        java.sql.Date dt = new java.sql.Date(d.getTime()); // quando trabalhar com DATA é necessário converter

        LocalTime tempo = java.time.LocalTime.now();   //pega a hora local
        atd.setHoraatendimento(tempo.toString()); //converte a hora local  e guarda no objeto a ser inserido

        atd.setDataatendimento(dt); //seta data do atendimento no objeto
       
        atd.setIp(remoteIp); //seta ip do cliente no objeto

        if (atd.getEuquero().equals("Falar com a Mariana")) {

            atd.setCorretor("Mariana");

        }
        if (atd.getEuquero().equals("Falar com a Sheyla")) {

            atd.setCorretor("Sheyla");

        }
        if (atd.getEuquero().equals("Falar com a Andrea")) {

            atd.setCorretor("Andrea");

        }
        if (atd.getEuquero().equals("Falar com a Administração")) {

            atd.setCorretor("Adm");

        }
        if (atd.getEuquero().equals("Falar com o João")) {

            atd.setCorretor("João");

        }
        
        Classe_Geral cg = new Classe_Geral("atendimento");
       
        int inserido=cg.inserirDadosTabela("atendimento",atd); //PEGA VALOR CHAVE INSERIDO NA TABELA ATENDIMENTO
        atd = new Atendimento(); //limpaAtendimentos
   
        cadastraDetalheAtendimento(inserido);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("detalhe_atendimento.jsf");
     
        
}
    
   
    public void cadastraDetalheAtendimento(int cadastro) throws SQLException{
        
        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        listaAtendimentoDetalhe = run.query("SELECT * FROM crm.atendimento where id="+cadastro, h);

        
       

        
         dtla.setOrigematendimento(cadastro);
      
        
    }
    
    public void GravaDetalheAtendimento() throws SQLException{
        
    
       

       
         dtla.setNegocio(Arrays.toString(dtla.getNegocioArray()));
         dtla.setBairros(Arrays.toString(dtla.getBairrosArray()));
         dtla.setCaracteristicas(Arrays.toString(dtla.getCaracteristicasArray()));
         dtla.setTipoimovel(Arrays.toString(dtla.getImovelArray()));
         
         Classe_Geral cg = new Classe_Geral("detalheatendimento");
      
        
         int inserido=cg.inserirDadosTabela("detalheatendimento",dtla); //INSERE REGISTOR NA TABELA E RETORNA ID
        
         
      
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    public void listar() throws SQLException {

        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        listaAtendimentos = run.query("SELECT dataatendimento,nome,telefone FROM crm.atendimento order by dataatendimento", h);

        RequestContext context = RequestContext.getCurrentInstance();
        context.update("listagem");
    }

}
    
    
       
         
            
   