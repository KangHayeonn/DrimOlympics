package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
   public Connection getConnection(){
   Connection connection=null;
   //192.168.123.57
   final String URL = "jdbc:mysql://192.168.123.57/drimDB";
   final String USER = "test1";
   final String PW = "drim1234";
   
   try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(URL, USER, PW);
      System.out.println("DB연결 성공");
   } catch (ClassNotFoundException e){
      e.printStackTrace();
   } catch (SQLException e1){
      e1.printStackTrace();
   }
   return connection;
   }
}