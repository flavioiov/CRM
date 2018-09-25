/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import static com.sun.glass.ui.Application.run;
import geral.Classe_Geral;
import static java.lang.System.out;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelos.Formularios;

import org.primefaces.context.RequestContext;
import org.json.JSONArray;
import org.json.JSONObject;
import conversores.Convertor;
import geral.CustomDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



/**
 *
 * @author Flavio
 */


@ManagedBean 
@SessionScoped
public class beanSQL {
    
    
   
    private ResultSet resultado;

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    public List<Object[]> getListaformularios() {
        return listaformularios;
    }

    public void setListaformularios(List<Object[]> listaformularios) {
        this.listaformularios = listaformularios;
    }


   
     
    
    private List<Object[]> listaformularios = new ArrayList<>();
    
    
    private List<Formularios> listaforms;

    public List<Formularios> getListaforms() {
        return listaforms;
    }

    public void setListaforms(List<Formularios> listaforms) {
        this.listaforms = listaforms;
    }

   
/*
     public ResultSet buscarDados() throws SQLException {
         
         System.out.println("testa conexao");
       
        String Tabela = "formularios";
        Classe_Geral formularios = new Classe_Geral();

        //o primeiro ResultSet pega os campos, o Segundo a Quantidade de Camppos
        ResultSet rs, quantosCampos;
        rs = formularios.listar_tabela(Tabela);
        quantosCampos = formularios.quantosCampos(Tabela);

         List<Object[]> records = new ArrayList<Object[]>();
         while (rs.next()) {
             int cols = rs.getMetaData().getColumnCount();
             Object[] arr = new Object[cols];
             for (int i = 0; i < cols; i++) {
                 arr[i] = rs.getObject(i + 1);
             }
             records.add(arr);
         }

         this.listaformularios=records;

         RequestContext context = RequestContext.getCurrentInstance();
         context.update("listagem");
        
        
         
         return rs;

    }



    public void testa() throws SQLException{
        
        
        List<String> records = new ArrayList<String>();
        String Tabela = "formularios";
        Classe_Geral formularios = new Classe_Geral();
  
        //o primeiro ResultSet pega os campos, o Segundo a Quantidade de Camppos
        ResultSet rs, quantosCampos;
        rs = formularios.listar_tabela(Tabela);
        quantosCampos = formularios.quantosCampos(Tabela);

        String cpo = "";
        while (quantosCampos.next()) {
            cpo = quantosCampos.getString(1);
        }

         while (rs.next()) {
                for (int i = 1; i <= Integer.parseInt(cpo); i++) {
                
                    records.add(rs.getString(i));
          
                }
          }
          
       //  this.setListaformularios(records);
         
         System.out.println(records.get(0));
         
         RequestContext context = RequestContext.getCurrentInstance();
         context.update("listagem");
         
         
         
      
    }
      
    
    
    private List<Formularios> persons;
    public List<Formularios> getPersons() {
        return persons;
    }

    public void setPersons(List<Formularios> persons) {
        this.persons = persons;
    }
          
    
    public void testa3() throws SQLException {
       
     QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
     ResultSetHandler<List<Formularios>> h = new BeanListHandler<Formularios>(Formularios.class);
    
     persons=run.query("SELECT * FROM freebits_13.formularios", h);
  
      RequestContext context = RequestContext.getCurrentInstance();
         context.update("listagem");
     }
    
    
    
    
    
    
    public void testa2() throws SQLException{
       String Tabela = "formularios";
       Classe_Geral formularios = new Classe_Geral();
       ResultSet rs;
       
       rs = formularios.listar_tabela(Tabela);
     
         while (rs.next()) {
               
             Formularios dadosform = new Formularios();
             
          
             //String nome=rs.getString("nome");
             dadosform.setNome(rs.getString("nome"));
             dadosform.setAssunto(rs.getString("assunto"));
             dadosform.setIdformulario(rs.getInt("idformulario"));
             
            
          //   this.listaResultados.add(dadosform);
             
           
         }
       
         
           RequestContext context = RequestContext.getCurrentInstance();
         context.update("listagem");
         
      
    }
    
    
    
    public void saidaJSON() throws SQLException, Exception {
        String Tabela = "formularios";
        Classe_Geral formularios = new Classe_Geral();
        ResultSet rs, quantosCampos;
        rs = formularios.listar_tabela(Tabela);
        quantosCampos = formularios.quantosCampos(Tabela);
        Convertor conv=new Convertor();
        out.println(conv.convertToJSON(rs));
    }
        
        
        
   
    */   

    
    
    
    
    
    
}
       
         
            
   
     
    


