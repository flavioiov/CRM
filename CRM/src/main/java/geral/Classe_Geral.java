package geral;
import java.lang.reflect.Field;
import java.sql.*;
import util.Conexao;



public class Classe_Geral {
		
	
		private int qtd_parametros=60;
		private int qtd_campos;
		private String nome_tabela;
		private String campo_chave;
                private String schema;
                private int objeto_inserido;
                
                private int retorno;
	
		private String erro;
		private int inteiro;
	
		
		private String campos[] = new String[qtd_parametros];
		private String valores[] = new String[qtd_parametros];
		private int posicao[] = new int[qtd_parametros];
		
		private	String query = "";
		private	Statement st;
		private	ResultSet rs;
		private ResultSet rs1;
		
		
			public Classe_Geral(String tabela,int campos){
                                        
                           this.schema = "crm";
                            nome_tabela = tabela;
                           qtd_campos = campos;

                        }
                        
                        public Classe_Geral(String tabela){
                           
                           this.schema = "crm";
                           nome_tabela = tabela;
                        }
                        
						
			public Classe_Geral()
                        {
                            this.schema = "crm";
                        }
		
			public void setCampos(String s_campo,String s_valor,int s_posicao)
		{
			 campos[s_posicao]=s_campo;
			valores[s_posicao]=s_valor;
			posicao[s_posicao]=s_posicao;
		}
		
			public String getValores(int s_posicao)
		{
			return valores[s_posicao];
		}

			public String getCampos(int s_posicao)
			{
				return campos[s_posicao];
			}
		
			public void setErro(String a)
			{
					erro=a;
			}
				
			public String getErro()
			{
				return erro;
			}
		
		
	
//RETORNA OS TIPOS DOS CAMPOS EXISTENTES NA TABELA
		
		public ResultSet Get_Campos_Tabela()	
				throws SQLException
		{
			try {
				
					Conexao conf = new Conexao();
					Connection connection;
					connection =  conf.getDatabaseConnection();
	
		 			PreparedStatement prepared_statement;
	
	      	       	     
                                        String SQL;
	     			
                                        SQL ="SELECT COLUMN_NAME,COLUMN_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '"+schema+"' AND TABLE_NAME ='"+nome_tabela+"'";
                    	
					st = connection.createStatement();
					rs = st.executeQuery(SQL);     
			
					return rs;           
	    	
       		}
        		catch (Exception e1)
      			{
           			 e1.printStackTrace();
      			}
			return rs;
    }	
								
	

//METODO ALTERAR
	public void alterar(String campo,String valor)
		throws SQLException { 

		try {

				String SQL="";
	     		String VALORES="";
	     	
				Conexao conf = new Conexao();
				Connection connection;
				connection =  conf.getDatabaseConnection();
	
				PreparedStatement prepared_statement;
  	       	     

	     	
	     	int cont=1;
			while (cont<=qtd_campos)
	     	{
	     		if (cont==1)
	     		{
	     			SQL="set "+campos[cont]+"=?";
	     		}
	     		else
	     		{
	     			SQL=SQL+","+campos[cont]+"=?";
	     		}
	     			
	     	     	
	     			cont++;
	       	}
	     		     	
	     	   	   		
	   		query = "update "+nome_tabela+" "+SQL+" where "+campo+"= "+valor;
				
			
		
						
			prepared_statement = connection.prepareStatement(query);
			prepared_statement.setQueryTimeout(60);
			
			
			int contador=1;
			while(contador<=qtd_campos)
			{			 	
			 	    ResultSet rs1;  
			  		rs1=this.Get_Campos_Tabela();
	  				
	  				while (rs1.next())
					{
						String nome=rs1.getString("attname");
						String tipo=rs1.getString("TYPE");
						
						tipo=tipo.substring(0,4);
										
					 	if (nome.equals(this.getCampos(contador)))
					 	{
					 	
					 		if(tipo.equals("char"))
					 		{
					 			prepared_statement.setString(contador,(this.getValores(contador)).toUpperCase());
					 		}
 		
		 		
					 		
					 		if(tipo.equals("inte"))
					 		{
								
								prepared_statement.setInt(contador,Integer.parseInt(this.getValores(contador)));
					 		}
					 		
					 							 		
								if(tipo.equals("date"))
					 		{
					 			prepared_statement.setString(contador, this.getValores(contador));
					 		}
					 		
					 		if(tipo.equals("mone"))
					 		{
					 			prepared_statement.setDouble(contador, Double.parseDouble(this.getValores(contador)));
					 							 		
					 		}
					 						
 
 							if(tipo.equals("doub"))
					 		{
					 			prepared_statement.setDouble(contador, Double.parseDouble(this.getValores(contador)));
					 		}
								 		
			 		
					 						 	
					 	}
						
					
					}
				contador++;
				}
				 		
	
			prepared_statement.execute();
			prepared_statement.close();
			connection.commit();
			connection.close();
			
	  }
	  
	  catch (Exception e)
	  {
	 
	  	System.out.println(e.getMessage());
	  	this.setErro(e.getMessage() );
	 		  
	  }
}

//EXCLUIR CAMPO DE UMA TABELA
public void excluir(String campo,String cod)
throws SQLException
{

	 	  Conexao conf = new Conexao();
	       Connection connection;
		   connection =  conf.getDatabaseConnection();
                            
           PreparedStatement prepared_statement;
		   String sql;
        
        try {       
        
            
            sql = "delete from "+nome_tabela+" where "+campo+"="+cod;
     		st = connection.createStatement();
    		rs1 = st.executeQuery(sql);     
			
		    	
       }
        catch (Exception e2)
      {
            
       	System.out.println(e2.getMessage());
	  	this.setErro(e2.getMessage() );
	    e2.printStackTrace();
      }	
	
}




//RETONAR HORA E DATA DO BANCO DE DADOS
        
public ResultSet hora_data()
		throws SQLException
    {
            
      try
        {
    		
    
          Conexao conf = new Conexao();
	       Connection connection;
		   connection =  conf.getDatabaseConnection();
                            
           PreparedStatement prepared_statement;
		   String sql;
            sql = "select current_time as hora,current_date as data";
     		st = connection.createStatement();
			rs = st.executeQuery(sql);     
							         
	    	
    	   }
        	catch (Exception e1)
      		{
      		      e1.printStackTrace();
      		}
		return rs;
	}		

//RETORNA O ULTIMO VALOR ID INSERIDO EM UMA TABELA - sendo necessário nessa configuracao que o campo
//chama-se sempre ID 
public Integer proximo_valor(String campo,String tabela) // fechado funcionando 11/08/2018 
		throws SQLException
    {
          
      try
        {
    
            
            Conexao conf = new Conexao();
            Connection connection;
            connection = conf.getDatabaseConnection();
          
            PreparedStatement prepared_statement1;
            String sql;
            sql = "select max(" + campo + ") as ultimo from " + nome_tabela;
            st = connection.createStatement();
            rs1 = st.executeQuery(sql);

            while (rs1.next()) {

                retorno = rs1.getInt(1);

            }
            connection.close();
   		    	
       }
        catch (Exception e2)
      {
            e2.printStackTrace();
      }
		
		return retorno;
    }		

//RETORNA UMA BUSCA 
public ResultSet buscar(String campo,String busca)
		throws SQLException
    {
          
      try
        {
    
           Conexao conf = new Conexao(); 
	       Connection connection;
		   connection =  conf.getDatabaseConnection();
                            
           PreparedStatement prepared_statement;
		   String sql;
            sql = "select * from "+nome_tabela+" where "+campo+"='"+busca+"'"+"order by 2";
     		st = connection.createStatement();
    		rs1 = st.executeQuery(sql);     
			
		    	
       }
        catch (Exception e2)
      {
            e2.printStackTrace();
      }
		
		return rs1;
    }		


//RETORNA UMA BUSCA 
public ResultSet buscar2(String campo,String busca,String campo1,String busca1)
		throws SQLException
    {
          
      try
        {
    
           Conexao conf = new Conexao();
	       Connection connection;
		   connection =  conf.getDatabaseConnection();
                            
           PreparedStatement prepared_statement;
		   String sql;
            sql = "select * from "+nome_tabela+" where "+campo+"='"+busca+"'"+" and "+campo1+"='"+busca1+"'"+"order by 2";
     		st = connection.createStatement();
    		rs1 = st.executeQuery(sql);     
			
		    	
       }
        catch (Exception e2)
      {
            e2.printStackTrace();
      }
		
		return rs1;
    }		

//METODO REESCRITO EM JULHO 2018
public ResultSet listar_tabela(String tabela)
		throws SQLException
    {
    	String envia="";
          
      try
        {
    		
    
         Conexao conf = new Conexao(); 
	       Connection connection;
		   connection =  conf.getDatabaseConnection();
                            
           PreparedStatement prepared_statement;
		   String sql;
            sql = "select * from "+tabela+" order by 2";
     		st = connection.createStatement();
			rs = st.executeQuery(sql);     
							         
	    	
    	   }
        	catch (Exception e1)
      		{
      		      e1.printStackTrace();
      		}
		return rs;
	}		


//METODO ESCRITO PARA RETORNAR A QUANTIDADE DE CAMPOS E FACILITAR A EXIBIÇÀO DO RESULTSET
public ResultSet quantosCampos(String tabela)
		throws SQLException
    {
    	String envia="";
          
      try
        {
    		
    
         Conexao conf = new Conexao(); 
	       Connection connection;
		   connection =  conf.getDatabaseConnection();
                            
           PreparedStatement prepared_statement;
		   String sql;
            sql = "SELECT count(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '"+schema+"' AND TABLE_NAME ='"+tabela+"';";
     		st = connection.createStatement();
			rs = st.executeQuery(sql);     
							         
	    	
    	   }
        	catch (Exception e1)
      		{
      		      e1.printStackTrace();
      		}
		return rs;
	}		



public Integer inserirDadosTabela(String Tabela,Object obj) //fechado funcionando 10 de Agosto de 2018
		throws SQLException { 

		try {

                     
                      
        String SQL = "";
        String VALORES = "";
        

        Conexao conf = new Conexao();
        Connection connection;
        connection = conf.getDatabaseConnection();

        PreparedStatement prepared_statement;
     
        //buscas os campos na tabela e armazena em um resultset
        ResultSet rs10;
        rs10 = Get_Campos_Tabela();

        int contador = 1;

        //Este método pega o Objeto passado no metodo inserir(Tabela,obj) da classe geral e o le 
        //pegando seus campos e paremtros passados determinando seus tipos e valores.
        for (Field field : obj.getClass().getDeclaredFields()) {

            String campo = field.getName();//pegao o nome do campo do objeto previamente mapeado
            String nomeTipo = field.getType().toString(); //pega o tipo dos atributos do objeto

            Field fields = obj.getClass().getDeclaredField(campo);
            fields.setAccessible(true);
            Object value = fields.get(obj); //pega o valor dos atributos armazenados no objeto passdo.

                        //Percorre os campos da tabela montando o SQL nomedos campos com o respectivos valores
                        while (rs10.next()) {
                            if (rs10.getString("COLUMN_NAME").equals(campo)) {

                                    if (SQL.isEmpty()) {

                                        SQL = SQL + campo;

                                    } else {
                                        SQL = SQL + "," + campo;

                                    }

                                    if (VALORES.isEmpty()) {
                                            VALORES = VALORES + "'" + value + "'";
                                       } else {
                                     
                                           VALORES = VALORES + "," + "'" + value + "'";
                                      }
                                    
                                    
                               }
                        }

                        rs10.first();
                        contador++;
                    }
        
        String Valores=VALORES.replace("'null'","null"); //substitiu as aspas quando os campos são null, assim evita probleas de compatibilidade com o banco

        query = "insert into " + nome_tabela + " (" + SQL + ") VALUES (" + Valores + ")";

        System.out.println(query);
        
        
        prepared_statement = connection.prepareStatement(query);
        prepared_statement.setQueryTimeout(60);
        prepared_statement.execute();
        prepared_statement.close();
        connection.commit();
        connection.close();
          
         
        

    } catch (Exception e) {

        System.out.println(e.getMessage());
        this.setErro("Campo Chave Duplicado " + e.getMessage());

    }
	
        objeto_inserido=this.proximo_valor("id", nome_tabela);
        
                 
	return this.objeto_inserido;
	
}





public Integer updateDadosTabela(String Tabela,Object obj) //A fazer neste objeto será necessário 
        // caso o objeto já exista ou ainda esteja vivo o sistema deverá identificar seu ID
        // e a partir de então atualizar os objetos 
    
          
		throws SQLException { 

		try {

                     
                      
        String SQL = "";
        String VALORES = "";
        

        Conexao conf = new Conexao();
        Connection connection;
        connection = conf.getDatabaseConnection();

        PreparedStatement prepared_statement;
     
        //buscas os campos na tabela e armazena em um resultset
        ResultSet rs10;
        rs10 = Get_Campos_Tabela();

        int contador = 1;

        //Este método pega o Objeto passado no metodo inserir(Tabela,obj) da classe geral e o le 
        //pegando seus campos e paremtros passados determinando seus tipos e valores.
        for (Field field : obj.getClass().getDeclaredFields()) {

            String campo = field.getName();//pegao o nome do campo do objeto previamente mapeado
            String nomeTipo = field.getType().toString(); //pega o tipo dos atributos do objeto

            Field fields = obj.getClass().getDeclaredField(campo);
            fields.setAccessible(true);
            Object value = fields.get(obj); //pega o valor dos atributos armazenados no objeto passdo.

                        //Percorre os campos da tabela montando o SQL nomedos campos com o respectivos valores
                        while (rs10.next()) {
                            if (rs10.getString("COLUMN_NAME").equals(campo)) {

                                    if (SQL.isEmpty()) {

                                        SQL = SQL + campo;

                                    } else {
                                        SQL = SQL + "," + campo;

                                    }

                                    if (VALORES.isEmpty()) {
                                            VALORES = VALORES + "'" + value + "'";
                                       } else {
                                     
                                           VALORES = VALORES + "," + "'" + value + "'";
                                      }
                                    
                                    
                               }
                        }

                        rs10.first();
                        contador++;
                    }
        
        String Valores=VALORES.replace("'null'","null"); //substitiu as aspas quando os campos são null, assim evita probleas de compatibilidade com o banco

        //query = "update " + nome_tabela + " (" + SQL + ") VALUES (" + Valores + ")";

        System.out.println(query);
        
        
        prepared_statement = connection.prepareStatement(query);
        prepared_statement.setQueryTimeout(60);
        prepared_statement.execute();
        prepared_statement.close();
        connection.commit();
        connection.close();
          
         
        

    } catch (Exception e) {

        System.out.println(e.getMessage());
        this.setErro("Campo Chave Duplicado " + e.getMessage());

    }
	
        objeto_inserido=this.proximo_valor("id", nome_tabela);
        
                 
	return this.objeto_inserido;
	
}



}  


 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
