package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginDB {
     private Connection connection;
      private ConnectionDB DB_Connection;
      
      private ResultSet rs=null;
      private String query=null;
      private Statement sta;
      private PreparedStatement ps;//보안때문에 이걸로 바꿀예정
      
      public LoginDB() {
         ConnectionDB DB_Connection = new ConnectionDB();
          connection = DB_Connection.getConnection();
      }

      //로그인 전 회원조회
      public boolean getLoginSelect(String myID, String myPW){
         try {
            query = "SELECT * FROM account WHERE ID = '"+ myID+ "' AND PW = '" + myPW + "';";
            Statement sta = connection.createStatement();
            rs = sta.executeQuery(query);
            System.out.println(query);
            if(rs.next()){
               if(myPW.equals(rs.getString("PW")) && myID.equals(rs.getString("ID"))){
                    System.out.println("로그인 완료!!!\n");
                    JOptionPane.showMessageDialog(null, "환영!", "login", JOptionPane.INFORMATION_MESSAGE);
                    return true;
               }
               else {
                  System.out.println("로그인 실패!!! 회원정보없음\n");
               }
            }
         }
          catch (SQLException e){
            e.printStackTrace();
            System.out.println("DB 로그인 실패!! 사유 : " + e.getMessage());
         } 
         return false;
      }
}