/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geral;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class CustomDataSource {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://200.98.113.164:3306/crm";
   
   //  Database credentials
   static final String USER = "usercrm";
   static final String PASS = "kayros33";
   private static DataSource datasource;
   private static final BasicDataSource basicDataSource;

   static {
      basicDataSource = new BasicDataSource();
      basicDataSource.setDriverClassName(JDBC_DRIVER);
      basicDataSource.setUsername(USER);
      basicDataSource.setPassword(PASS);
      basicDataSource.setUrl(DB_URL);
   }

   public static DataSource getInstance() {
      return basicDataSource;
   }
}

