package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RegisterDB {
   private Connection connection;
   private ConnectionDB DB_Connection;
   
   private ResultSet rs=null;
   private String query=null;
   private Statement sta;
   private PreparedStatement ps;
   String a =null;
   
   public RegisterDB() {
      ConnectionDB DB_Connection = new ConnectionDB();
      connection = DB_Connection.getConnection();
   }

   //회원가입
   public ResultSet getRegisterInsert(String inputName, String inID, 
         String inPW, String inputEmail, String inputNic) {
      try {
         query = "INSERT INTO account values('" + inputName + "','" + inID + "','" + inPW + "','" +
               inputEmail + "','" + inputNic + "')";
         Statement sta = connection.createStatement();
         sta.executeUpdate(query);
         System.out.println(query);
         System.out.println("DB register 회원등록 완료");
      } catch (SQLException e){
         e.printStackTrace();
         System.out.println("DB 회원등록 실패!! 사유 : " + e.getMessage());
      }
      return rs;
   }
   
   //회원가입 전 회원조회
   public boolean getRegisterSelect(String dbIN, String in){
      try {
         query = "SELECT * FROM account WHERE "+ dbIN+ " = '" + in + "';";
         Statement sta = connection.createStatement();
         rs = sta.executeQuery(query);
         System.out.println(query);

         while(rs.next()) {
            if(rs.getString(dbIN).equals(in)) {
               System.out.println("DB 회원조회 중복발생!!!!\n");
               return false;
            }
            else {
               System.out.println("DB 회원조회완료\n");
            }
         }
      } catch (SQLException e){
         e.printStackTrace();
         System.out.println("DB 회원조회 실패!! 사유 : " + e.getMessage());
      } 
      return true;
   }
}