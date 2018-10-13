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
import java.time.LocalTime;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelos.Agenda;

/**
 *
 * @author Flavio
 */
import modelos.Atendimento;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.primefaces.context.RequestContext;
import org.apache.commons.dbutils.handlers.BeanHandler;

@ManagedBean
@SessionScoped

public class estatisticaBean {

    public List<Atendimento> getListaAtendimentos() {
        return listaAtendimentos;
    }

    public void setListaAtendimentos(List<Atendimento> listaAtendimentos) {
        this.listaAtendimentos = listaAtendimentos;
    }
    
    public List<Atendimento> listaatendimentostotal;
    public List<Atendimento> listaatendimentostotalcorretor;
    
    public List<Atendimento> listatotalporano;
    
    public List<Atendimento> listatotalnegocios;
    
    public List<Atendimento> listaatendimentosmes;
    
    public List<Agenda> listatodasatividades;
    public List<Agenda> listaAtividades;
    
    public List<Atendimento> listaMeusAtendimentos;

    public List<Atendimento> listaAtendimentoSelecionado;

    public List<Atendimento> getListaAtendimentoSelecionado() {
        return listaAtendimentoSelecionado;
    }

    public void setListaAtendimentoSelecionado(List<Atendimento> listaAtendimentoSelecionado) {
        this.listaAtendimentoSelecionado = listaAtendimentoSelecionado;
    }

    public List<Atendimento> getListaatendimentostotalcorretor() {
        return listaatendimentostotalcorretor;
    }

    public void setListaatendimentostotalcorretor(List<Atendimento> listaatendimentostotalcorretor) {
        this.listaatendimentostotalcorretor = listaatendimentostotalcorretor;
    }

    
    private List<Atendimento> listaatendimentosrevisar;
    public List<Atendimento> listaAtendimentos;

    public List<Atendimento> listaAtendimentoDetalhe;
    public List<Atendimento> listarminhasligacoes;
    public List<Atendimento> listaAbertos;
    public List<Atendimento> qtdatendimentoscorretor;

    public List<Atendimento> getListaAbertos() {
        return listaAbertos;
    }

    public void setListaAbertos(List<Atendimento> listaAbertos) {
        this.listaAbertos = listaAbertos;
    }

    public List<Atendimento> getQtdatendimentoscorretor() {
        return qtdatendimentoscorretor;
    }

    public void setQtdatendimentoscorretor(List<Atendimento> qtdatendimentoscorretor) {
        this.qtdatendimentoscorretor = qtdatendimentoscorretor;
    }

    public List<Agenda> getListatodasatividades() {
        return listatodasatividades;
    }

    public void setListatodasatividades(List<Agenda> listatodasatividades) {
        this.listatodasatividades = listatodasatividades;
    }

    public List<Atendimento> getListaatendimentosrevisar() {
        return listaatendimentosrevisar;
    }

    public void setListaatendimentosrevisar(List<Atendimento> listaatendimentosrevisar) {
        this.listaatendimentosrevisar = listaatendimentosrevisar;
    }

    public List<Atendimento> getListaatendimentostotal() {
        return listaatendimentostotal;
    }

    public void setListaatendimentostotal(List<Atendimento> listaatendimentostotal) {
        this.listaatendimentostotal = listaatendimentostotal;
    }

    public List<Atendimento> getListaatendimentosmes() {
        return listaatendimentosmes;
    }

    public void setListaatendimentosmes(List<Atendimento> listaatendimentosmes) {
        this.listaatendimentosmes = listaatendimentosmes;
    }

    public List<Atendimento> getListatotalporano() {
        return listatotalporano;
    }

    public void setListatotalporano(List<Atendimento> listatotalporano) {
        this.listatotalporano = listatotalporano;
    }

    public List<Atendimento> getListatotalnegocios() {
        return listatotalnegocios;
    }

    public void setListatotalnegocios(List<Atendimento> listatotalnegocios) {
        this.listatotalnegocios = listatotalnegocios;
    }

    
    
    
    
    private String[] strArray;

    public String[] getStrArray() {
        return strArray;
    }

    public void setStrArray(String[] strArray) {
        this.strArray = strArray;
    }

    public List<Atendimento> getListaMeusAtendimentos() {
        return listaMeusAtendimentos;
    }

    public void setListaMeusAtendimentos(List<Atendimento> listaMeusAtendimentos) {
        this.listaMeusAtendimentos = listaMeusAtendimentos;
    }

    public List<Atendimento> getListarminhasligacoes() {
        return listarminhasligacoes;
    }

    public void setListarminhasligacoes(List<Atendimento> listarminhasligacoes) {
        this.listarminhasligacoes = listarminhasligacoes;
    }

    public List<Atendimento> listaAtendimentosMesmoCliente;

    public List<Atendimento> getListaAtendimentosMesmoCliente() {
        return listaAtendimentosMesmoCliente;
    }

    public void setListaAtendimentosMesmoCliente(List<Atendimento> listaAtendimentosMesmoCliente) {
        this.listaAtendimentosMesmoCliente = listaAtendimentosMesmoCliente;
    }

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
    
    private Atendimento atdEscolhido = new Atendimento();

    public Atendimento getAtdEscolhido() {
        return atdEscolhido;
    }

    public void setAtdEscolhido(Atendimento atdEscolhido) {
        this.atdEscolhido = atdEscolhido;
    }
    

    private String[] myArray;

    public String[] getMyArray() {
        return myArray;
    }

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    
    public void listarEstatisticas() throws SQLException {
        String sql = "SELECT  status,upper(corretor) as corretor,count(*) as total FROM crm.atendimento where euquero not like 'Falar%' group by 1,2 order by 2";
        ResultSetHandler<List<Atendimento>> h2 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR2 = new QueryRunner(CustomDataSource.getInstance());
        listaatendimentostotal = QR2.query(sql, h2);
    
        
         String sql3 = "SELECT  upper(corretor) as corretor,count(*) as total FROM crm.atendimento where euquero not like 'Falar%' group by 1 order by 2";
        ResultSetHandler<List<Atendimento>> h3 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR3 = new QueryRunner(CustomDataSource.getInstance());
        listaatendimentostotalcorretor = QR2.query(sql3, h3);
        
        
        String sql4 = "SELECT      monthname(dataatendimento) as nome,substr(dataatendimento,1,4) as corretor,status,count(*) as total FROM crm.atendimento where euquero not like 'Falar%' group by 1,2,3 order by 1";
        ResultSetHandler<List<Atendimento>> h4 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR4 = new QueryRunner(CustomDataSource.getInstance());
        listaatendimentosmes = QR2.query(sql4, h4);
        
         String sql5 = "SELECT      monthname(dataatendimento) as nome,substr(dataatendimento,1,4) as corretor,count(*) as total FROM crm.atendimento where euquero not like 'Falar%' group by 1,2 order by 1";
        ResultSetHandler<List<Atendimento>> h5 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR5 = new QueryRunner(CustomDataSource.getInstance());
        listatotalporano = QR2.query(sql5, h5);
         
         String sql6 = "SELECT negocio,monthname(dataatendimento) as nome,count(*) as total,FORMAT(avg(valormaxvenda),2,'de_DE') as msg,FORMAT(avg(valormaxaluguel),2,'de_DE') as corretor FROM crm.atendimento where euquero not like 'Falar%'\n" +
"group by 1,2 order by 2,1";
        ResultSetHandler<List<Atendimento>> h6 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR6 = new QueryRunner(CustomDataSource.getInstance());
        listatotalnegocios = QR2.query(sql6, h6);
         
        
        
        
        
        

        
        
        
        
        
        
    }

    

    
    
    
}
