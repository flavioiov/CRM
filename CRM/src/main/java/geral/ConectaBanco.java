/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geral;


import geral.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import modelos.Formularios;


/**
 *
 * @author Flavio
 */
public class ConectaBanco {
    
    public static void main(String[] args) throws SQLException {
     
        Connection connection;
        Conexao conf = new Conexao();
        String query = "";
        Statement st;
        ResultSet rs;

        List<Formularios> listatudo;

        connection = conf.getDatabaseConnection();

        PreparedStatement pstst;
        query = "SELECT * FROM crm.atendimento";
        pstst = connection.prepareStatement(query);

        //pstst.execute(query);
        ResultSet res = pstst.executeQuery(query);


        String assunto, nome;

        while (res.next()) {
            assunto = res.getString("id");
            nome = res.getString("nome");
            
            System.out.println("ROW = " + nome + ": " + assunto);
        }
      
       
        
    }
    
    public void listar() throws SQLException {

      
    }

}
        
        
        
    
    
    
    
    
    
    
