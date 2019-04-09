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

public class estatisticaBean {
 
    public List<Atendimento> listaatendimentostotal;
    public List<Atendimento> listaatendimentostotalcorretor;
    
    public List<Atendimento> listatotalporano;

     public List<Atendimento> listaatendimentosfechados;
    
    public List<Atendimento> listatotalnegocios;
    
    public List<Atendimento> listaatendimentosmes;
    
    public List<Atendimento> listadetalhada;
    
    public List<Atendimento> listadetalhadafechamento;
    
     public List<Atendimento> listatotalcomochegou;

    public List<Atendimento> getListatotalcomochegou() {
        return listatotalcomochegou;
    }

    public List<Atendimento> getListaatendimentosfechados() {
        return listaatendimentosfechados;
    }

    public void setListaatendimentosfechados(List<Atendimento> listaatendimentosfechados) {
        this.listaatendimentosfechados = listaatendimentosfechados;
    }

    public List<Atendimento> getListadetalhadafechamento() {
        return listadetalhadafechamento;
    }

    public void setListadetalhadafechamento(List<Atendimento> listadetalhadafechamento) {
        this.listadetalhadafechamento = listadetalhadafechamento;
    }

    
    public void setListatotalcomochegou(List<Atendimento> listatotalcomochegou) {
        this.listatotalcomochegou = listatotalcomochegou;
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
         
        String sql6 = "SELECT negocio,monthname(dataatendimento) as nome,count(*) as total,"
                + "FORMAT(avg(valormaxvenda),2,'de_DE') as msg,"
                + "FORMAT(avg(valormaxaluguel),2,'de_DE') as corretor FROM crm.atendimento where euquero not like 'Falar%'\n"
                + "group by 1,2 order by 2,1";
        ResultSetHandler<List<Atendimento>> h6 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR6 = new QueryRunner(CustomDataSource.getInstance());
        listatotalnegocios = QR6.query(sql6, h6);
        
        
        System.out.println("sql listatotalnegocios "+sql6);
         
         String sql7 = "SELECT count(*) as total,comochegou from crm.atendimento group by 2";

        ResultSetHandler<List<Atendimento>> h7 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR7 = new QueryRunner(CustomDataSource.getInstance());
        listatotalcomochegou = QR7.query(sql7, h7);
          
               String sql8 = "SELECT monthname(dataatendimento) as nome, "
                       + "year(dataatendimento) as tipoimovel,status,motivofinalizou,count(*) as total,"
                       + "SUM(valormaxaluguel) as valormaxaluguel,SUM(valormaxvenda) valormaxvenda\n"
                + "FROM crm.atendimento\n"
                + "where motivofinalizou like '%realizada%'\n"
                + "group by 1,2,3,4\n"
                + "order by 1 desc";

        ResultSetHandler<List<Atendimento>> h8 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR8 = new QueryRunner(CustomDataSource.getInstance());
        listaatendimentosfechados = QR8.query(sql8, h8);
        
       
        
    }

    

    public void detalhar(String mes, String negocio,String tipoImovel) throws SQLException, IOException {
        
        System.out.println("entrou no detalhar estatisticasBean, chamado na pagina estatisticas.xhtml");

        String sql9 = "SELECT id,nome,corretor,concat(ddd,' - ',telefone) as telefone,"
                + "negocio,monthname(dataatendimento),tipoimovel,FORMAT((valormaxvenda),2,'de_DE') as msg,FORMAT((valormaxaluguel),2,'de_DE') as interesse,"
                + "status,dataatendimento,motivofinalizou \n"
                + "FROM crm.atendimento where monthname(dataatendimento)='" + mes + "' and negocio='" + negocio + "' and tipoimovel LIKE'%" + tipoImovel + "%'";
        ResultSetHandler<List<Atendimento>> h9 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR9 = new QueryRunner(CustomDataSource.getInstance());
        listadetalhada = QR9.query(sql9, h9);

        System.out.println(sql9);
        
        String url = "estatistica_detalhada.jsf";
        //FacesContext.getCurrentInstance().getExternalContext().redirect("estatistica_detalhada.jsf");

        RequestContext.getCurrentInstance().execute("window.open('" + url + "')");
    }
    
    
     public void detalharfechamento(String mes, String ano,String corretor,String motivofinalizou) throws SQLException, IOException {
        
         System.out.println("Detalhou fechamento");
         
       
         String sql10 = "select * from crm.atendimento where monthname(dataatendimento)='"+mes+"' \n" +
"and year(dataatendimento)='"+ano+"'  and motivofinalizou like '"+motivofinalizou+"'";
        ResultSetHandler<List<Atendimento>> h10 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR10 = new QueryRunner(CustomDataSource.getInstance());
        listadetalhadafechamento = QR10.query(sql10, h10);
        
        String url="estatistica_fechamento.jsf";
         //FacesContext.getCurrentInstance().getExternalContext().redirect("estatistica_detalhada.jsf");
        
        RequestContext.getCurrentInstance().execute("window.open('"+url+"')");
    }
    
    
    
    
}
