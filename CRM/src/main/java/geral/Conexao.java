/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geral;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Flavio
 */
public class Conexao {

   private String user = "root";
	private String banco="crm";
	private String password = "kayros33";
	private String url = "jdbc:mysql://localhost:3306/"+banco;
	private String erro="";
	
	Connection connection;
	
	public Conexao()
	{
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           	connection = DriverManager.getConnection(url,user,password);
        
         }
         catch (Exception e )
         {
         	System.out.println("NÃO FOI POSSÕVEL SE CONECTAR AO BANCO" + e.getMessage());
       
         	this.setErro(e.getMessage());
         
         
         }     
		
	}
	
	public String getErro()
	{
		return	erro;
		
	}
	
	public void setErro(String er)
	{
		erro=er;
	}
	
	
	
	
	
	
	public Connection getDatabaseConnection() throws SQLException
    {
    	return connection;
    }


}