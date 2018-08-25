/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import geral.CustomDataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import modelos.Usuarios;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;




/**
 *
 * @author Flavio
 */

@ManagedBean 
@SessionScoped





public class usuarioManagedBean {

private Usuarios usuario = new Usuarios();

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    

  private List<Usuarios> listaUsuarios;
    
    
    public void verificaUsuario() throws IOException, SQLException{
     
       
        
        String sql = "SELECT * FROM crm.usuarios where senha='" + usuario.getSenha() + "'  AND nome='" + usuario.getNome() + "';";

        ResultSetHandler<List<Usuarios>> h = new BeanListHandler<Usuarios>(Usuarios.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        listaUsuarios = run.query(sql, h);

        if (listaUsuarios.isEmpty()) {
            
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("USUARIO NAO LOGADO", "Favor Conferir a Digitação"));
        
        usuario = new Usuarios();
        
         
           

        } else {

          
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("BOAS VENDAS",  "Seja Bem Vindo Corretor : " + usuario.getNome()) );
            FacesContext.getCurrentInstance().getExternalContext().redirect("dashboardcrm.jsf");
            
            
            FacesContext context2 = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
            session.setAttribute("user", usuario.getNome());
            session.setAttribute("mostra","true");
            //end of new lines
            
            
        }
          
        //RequestContext context = RequestContext.getCurrentInstance();
        //context.update("listagem");
      
    
}
    
    
    public void sairSistema() throws IOException{
            
            FacesContext context2 = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
            session.setAttribute("user",null);
            session.setAttribute("mostra","false");
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("abrir_atendimento.jsf");
        
    }
    
    
    
    
       
         
            
}
