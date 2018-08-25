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
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;




/**
 *
 * @author Flavio
 */

import modelos.Atendimento;
import modelos.Usuarios;
import modelos.Detalheatendimento;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import static org.primefaces.behavior.confirm.ConfirmBehavior.PropertyKeys.message;
import org.primefaces.context.RequestContext;

import beans.usuarioManagedBean;
import java.util.Map;

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
    
    
    private String usuarioLogado;

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
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
     
    
    
    public void cadastrarAtendimento() throws SQLException, IOException {
       
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
        
        
        String corretor = atd.getCorretor();

        Classe_Geral cg = new Classe_Geral("atendimento");

        int inserido = cg.inserirDadosTabela("atendimento", atd); //PEGA VALOR CHAVE INSERIDO NA TABELA ATENDIMENTO

        atd = new Atendimento(); //limpaAtendimentos

        cadastraDetalheAtendimento(inserido);

        if (corretor == null) {
            
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("detalhar_atendimento.jsf");
            
            
            
        } else {
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("abrir_atendimento.jsf");
            
            // RequestContext context2 = RequestContext.getCurrentInstance();
            // context2.update("growl");
            
        }

        
}
   
    public void alterar() throws SQLException, IOException{
        
         Classe_Geral cg = new Classe_Geral("atendimento");
         cg.alteraDadosTabela("atendimento", atd,dtla.getOrigematendimento());
         
    }
     
    public void cadastraDetalheAtendimento(int cadastro) throws SQLException{
        
        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        listaAtendimentoDetalhe = run.query("SELECT * FROM crm.atendimento where id=" + cadastro, h);

        dtla.setOrigematendimento(cadastro);
      
        
    }
    
    public void GravaDetalheAtendimento() throws SQLException, IOException, NoSuchFieldException{
        
      
        dtla.setNegocio(Arrays.toString(dtla.getNegocioArray()));
        dtla.setBairros(Arrays.toString(dtla.getBairrosArray()));
        dtla.setCaracteristicas(Arrays.toString(dtla.getCaracteristicasArray()));
        dtla.setTipoimovel(Arrays.toString(dtla.getImovelArray()));

        Classe_Geral cg = new Classe_Geral("detalheatendimento");

        int inserido = cg.inserirDadosTabela("detalheatendimento", dtla); //INSERE REGISTOR NA TABELA E RETORNA ID

        
        usuarioLogado=(String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        
        if (usuarioLogado==null){
            
             dtla = new Detalheatendimento();
            
             FacesContext.getCurrentInstance().getExternalContext().redirect("abrir_atendimento.jsf");
        }else
            
        {
             
             FacesContext.getCurrentInstance().getExternalContext().redirect("triagem.jsf");
        }
     
        
        
     }               
                 
    public void selecionaAtendimento(int select) throws IOException{
        
        System.out.print("id Selecionado"+select);
          FacesContext.getCurrentInstance().getExternalContext().redirect("triagem.jsf");
        
        
    }
    
    public void listar() throws SQLException {

        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        listaAtendimentos = run.query("SELECT * FROM crm.atendimento where corretor is null order by dataatendimento", h);

        RequestContext context = RequestContext.getCurrentInstance();
        context.update("listagem");
    }
   
    public void listar_meusAtendimentos() throws SQLException {

        usuarioLogado = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        System.out.println(usuarioLogado);

        String sql = "SELECT * FROM crm.atendimento where corretor='" + usuarioLogado + "'OR corretor is null order by corretor";

        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        listaAtendimentos = run.query(sql, h);

        RequestContext context = RequestContext.getCurrentInstance();
        context.update("listagem");

    }

}

    
       
         
            
   