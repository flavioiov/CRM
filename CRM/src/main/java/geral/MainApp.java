/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geral;

import static geral.CustomDataSource.JDBC_DRIVER;
import java.sql.SQLException;
import java.util.List;
import modelos.Formularios;
import org.apache.commons.dbutils.DbUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class MainApp {
   public static void main(String[] args) throws SQLException {    
      
     
       
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());


       // ResultSetHandler<List<Formularios>> h = new BeanListHandler<Formularios>(Formularios.class);
        //List<Formularios> persons = run.query("SELECT * FROM freebits_13.formularios", h);
        //System.out.print(persons);
      
        
       
      ResultSetHandler<Formularios> resultHandler = new BeanHandler<Formularios>(Formularios.class);
      Formularios emp = run.query("SELECT * FROM formularios WHERE idformulario=?",
      resultHandler, 130);
 
      
      System.out.println(emp.getNome());
    
     
   }
}
      
   
