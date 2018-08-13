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
public class formularioBean {
    
    private List<Formularios> listaforms;

    public List<Formularios> getListaforms() {
        return listaforms;
    }

    public void setListaforms(List<Formularios> listaforms) {
        this.listaforms = listaforms;
    }

   
    private List<Formularios> formularios;

    public List<Formularios> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formularios> formularios) {
        this.formularios = formularios;
    }
 
    
    
    public void listaFormularios() throws SQLException {
       
     
     ResultSetHandler<List<Formularios>> h = new BeanListHandler<Formularios>(Formularios.class);
     QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
     formularios=run.query("SELECT * FROM freebits_13.formularios order by data", h);
  
      RequestContext context = RequestContext.getCurrentInstance();
         context.update("listagem");
     }
    
     
   
}
       
         
            
   
     
    


