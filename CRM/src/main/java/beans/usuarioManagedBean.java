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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelos.Atendimento;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
            
            
            
            FacesContext context2 = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
            
            
            if ((listaUsuarios.get(0).getTipo().equals("ADMIN")))
            {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dashboardadm.jsf");
                    session.setAttribute("configura","true");
                    session.setAttribute("user", listaUsuarios.get(0).getNome());
                    session.setAttribute("mostra","false");
                    session.setAttribute("fotouser", listaUsuarios.get(0).getFoto());
                    session.setAttribute("permission",listaUsuarios.get(0).getTipo());
                    session.setAttribute("unidade", listaUsuarios.get(0).getUnidade());
                    session.setAttribute("mostramenuentrarcrm", "false");
                    session.setAttribute("mostralogin","false");
                    
                   
                  
            }else {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("dashboardcrm.jsf");
                
                
                    session.setAttribute("configura","false");
                    session.setAttribute("user", listaUsuarios.get(0).getNome());
                    session.setAttribute("mostra","true");
                    session.setAttribute("mostralogin","false");
                    session.setAttribute("fotouser", listaUsuarios.get(0).getFoto());
                    session.setAttribute("permission",listaUsuarios.get(0).getTipo());
                    session.setAttribute("unidade", listaUsuarios.get(0).getUnidade());
                    session.setAttribute("mostramenuentrarcrm", "false");
                    
                    
                    if(listaUsuarios.get(0).getNome().equals("qualidade")){
                        System.out.println("****** Usuário Qualidade Acionado********");
                         session.setAttribute("userqualidade","true");
                    }
                    
                  
            }
                 
            
        }
          
        //RequestContext context = RequestContext.getCurrentInstance();
        //context.update("listagem");
    
}
    
    
    public void sairSistema() throws IOException{
            
            FacesContext context2 = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
            session.setAttribute("user",null);
            session.setAttribute("mostra","false");
            session.setAttribute("configura","false");
            session.setAttribute("mostralogin","true");
            session.setAttribute("fotouser",null);
            session.setAttribute("mostramenuentrarcrm", "true");
            
            
            String page1="maincrm.jsf";
           
            //redireciona independente do caminho!!
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" + page1);
            
            
         
           
          
           session.invalidate();
           
           
            
            
           
            
            
        
    }
    
    
    
    
       
         
            
}
