/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import geral.CustomDataSource;
import java.io.IOException;
import java.util.List;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Flavio
 */
import modelos.Atendimento;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.primefaces.context.RequestContext;


@ManagedBean
@SessionScoped

public class relatoriosBean {
 
    public List<Atendimento> listaatendimentostotal;
    public List<Atendimento> listaatendimentostotalcorretor;
    
    public List<Atendimento> listatotalporano;
    
    public List<Atendimento> listatotalnegocios;
    
    public List<Atendimento> listaatendimentosmes;
    
    public List<Atendimento> listaatendimentoscorretor;
    
    public List<Atendimento> listaatendimentoscorretorEvora;
    
    public List<Atendimento> listaatendimentoscorretorLocacao;

    public List<Atendimento> getListaatendimentoscorretorLocacao() {
        return listaatendimentoscorretorLocacao;
    }

    public void setListaatendimentoscorretorLocacao(List<Atendimento> listaatendimentoscorretorLocacao) {
        this.listaatendimentoscorretorLocacao = listaatendimentoscorretorLocacao;
    }
    
    
    

    public List<Atendimento> getListaatendimentoscorretorEvora() {
        return listaatendimentoscorretorEvora;
    }

    public void setListaatendimentoscorretorEvora(List<Atendimento> listaatendimentoscorretorEvora) {
        this.listaatendimentoscorretorEvora = listaatendimentoscorretorEvora;
    }
    
    
    
    
    public List<Atendimento> listadetalhada;
    
     public List<Atendimento> listatotalcomochegou;

    public List<Atendimento> getListatotalcomochegou() {
        return listatotalcomochegou;
    }

    public void setListatotalcomochegou(List<Atendimento> listatotalcomochegou) {
        this.listatotalcomochegou = listatotalcomochegou;
    }

    public List<Atendimento> getListaatendimentoscorretor() {
        return listaatendimentoscorretor;
    }

    public void setListaatendimentoscorretor(List<Atendimento> listaatendimentoscorretor) {
        this.listaatendimentoscorretor = listaatendimentoscorretor;
    }
    
    
    public List<Atendimento> getListaatendimentostotalcorretor() {
        return listaatendimentostotalcorretor;
    }

    public void setListaatendimentostotalcorretor(List<Atendimento> listaatendimentostotalcorretor) {
        this.listaatendimentostotalcorretor = listaatendimentostotalcorretor;
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

    public List<Atendimento> getListadetalhada() {
        return listadetalhada;
    }

    public void setListadetalhada(List<Atendimento> listadetalhada) {
        this.listadetalhada = listadetalhada;
    }

    
    
    public void carregaRelariosBean() throws SQLException{
        
        this.listar_todasCompras();
        this.listarEstatisticas();
        this.listar_meusAtendimentos();
        this.lista_meusAtendimentosLocacao();
        this.lista_meusAtendimentosEvora();
       
    }
       
    
     public void listar_todasCompras() throws SQLException {

       

        String sql = "SELECT * FROM crm.atendimento  where euquero not like '%falar%' and euquero not like 'Evora' and negocio like '%comprar%'\n" +
"order by id desc ";

        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        listadetalhada = run.query(sql, h);
        
        
    }

   
    public void listarEstatisticas() throws SQLException {
        String sql = "SELECT  status,upper(corretor) as corretor,count(*) as total FROM crm.atendimento where euquero not like 'Falar%' group by 1,2 order by 2";
        ResultSetHandler<List<Atendimento>> h2 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR2 = new QueryRunner(CustomDataSource.getInstance());
        listaatendimentostotal = QR2.query(sql, h2);
    
        
         String sql3 = "SELECT  upper(corretor) as corretor,count(*) as total FROM crm.atendimento where euquero not like 'Falar%' group by 1 order by 2";
        ResultSetHandler<List<Atendimento>> h3 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR3 = new QueryRunner(CustomDataSource.getInstance());
        listaatendimentostotalcorretor = QR3.query(sql3, h3);
        
        
        String sql4 = "SELECT      monthname(dataatendimento) as nome,substr(dataatendimento,1,4) as corretor,status,count(*) as total FROM crm.atendimento where euquero not like 'Falar%' group by 1,2,3 order by 1";
        ResultSetHandler<List<Atendimento>> h4 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR4 = new QueryRunner(CustomDataSource.getInstance());
        listaatendimentosmes = QR4.query(sql4, h4);
        
         String sql5 = "SELECT      monthname(dataatendimento) as nome,substr(dataatendimento,1,4) as corretor,count(*) as total FROM crm.atendimento where euquero not like 'Falar%' group by 1,2 order by 1";
        ResultSetHandler<List<Atendimento>> h5 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR5 = new QueryRunner(CustomDataSource.getInstance());
        listatotalporano = QR5.query(sql5, h5);
         
         String sql6 = "SELECT negocio,monthname(dataatendimento) as nome,tipoimovel,count(*) as total,FORMAT(avg(valormaxvenda),2,'de_DE') as msg,FORMAT(avg(valormaxaluguel),2,'de_DE') as corretor FROM crm.atendimento where euquero not like 'Falar%'\n" +
"group by 1,2 order by 2,1";
        ResultSetHandler<List<Atendimento>> h6 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR6 = new QueryRunner(CustomDataSource.getInstance());
        listatotalnegocios = QR6.query(sql6, h6);
         
         String sql7 = "SELECT count(*) as total,comochegou from crm.atendimento group by 2";

        ResultSetHandler<List<Atendimento>> h7 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR7 = new QueryRunner(CustomDataSource.getInstance());
        listatotalcomochegou = QR7.query(sql7, h7);
           
        
        
    }

    

    public void detalhar(String mes, String negocio) throws SQLException, IOException {
        
        
         String sql9 = "SELECT id,nome,corretor,concat(ddd,' - ',telefone) as telefone,negocio,monthname(dataatendimento),tipoimovel,FORMAT((valormaxvenda),2,'de_DE') as msg,FORMAT((valormaxaluguel),2,'de_DE') as interesse,status,dataatendimento,motivofinalizou \n" +
"FROM crm.atendimento where monthname(dataatendimento)='"+mes+"' and negocio='"+negocio+"' order by dataatendimento asc";
        ResultSetHandler<List<Atendimento>> h9 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR9 = new QueryRunner(CustomDataSource.getInstance());
        listadetalhada = QR9.query(sql9, h9);
        
        String url="estatistica_detalhada.jsf";
         //FacesContext.getCurrentInstance().getExternalContext().redirect("estatistica_detalhada.jsf");
        
        RequestContext.getCurrentInstance().execute("window.open('"+url+"')");
    }
    
    
  
    
    
    public void listar_meusAtendimentos() throws SQLException {

      String  usuarioLogado = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
     
            String sql = "SELECT * FROM crm.atendimento where euquero NOT LIKE '%falar%' AND corretor='" + usuarioLogado + "' and negocio like '%comprar%' and euquero not like '%evora%'"; 
         
        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
         listaatendimentoscorretor = run.query(sql, h);
         
    
         
    }
    
    public void lista_meusAtendimentosEvora() throws SQLException {

      String  usuarioLogado = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
     
            String sql = "SELECT * FROM crm.atendimento where euquero NOT LIKE '%falar%' AND corretor='" + usuarioLogado + "' and negocio like '%comprar%' and euquero like '%evora%'"; 
         
        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
         listaatendimentoscorretorEvora = run.query(sql, h);
         
    
         
    }
    
    public void lista_meusAtendimentosLocacao() throws SQLException {

      String  usuarioLogado = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
     
            String sql = "SELECT * FROM crm.atendimento where euquero NOT LIKE '%falar%' AND corretor='" + usuarioLogado + "' and negocio like '%Alugar%' and euquero not like '%evora%'"; 
         
        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
         listaatendimentoscorretorLocacao = run.query(sql, h);
         
    
         
    }
    
    
    
    
    
}
