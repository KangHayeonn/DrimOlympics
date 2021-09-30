package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Database.ConnectionDB;
import Database.LoginDB;
import Login.loginVO;

public class LoginCheck {
   loginVO loginVO = new loginVO();
   private Connection connection;
   private ConnectionDB DB_Connection;
   private ResultSet rs=null;
   private String query=null;
   private Statement sta;
   private PreparedStatement ps;
   
   public LoginCheck() {
         ConnectionDB DB_Connection = new ConnectionDB();
         connection = DB_Connection.getConnection();
         LoginDB loginDB = new LoginDB();
      }
   loginVO login = new loginVO();
   
   //로그인 DB 등록
   public ResultSet Chk_Login(String myID) {
      try {
            query = "INSERT INTO account_chk values('" + myID +"', '"+null+"');";
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
   
   //로그인
   public boolean isLogin(String ID) {
      try {
           query = "UPDATE account_chk SET ischeck = 'true' WHERE ID = '"+ID+"';";
           Statement sta = connection.createStatement();
           sta.executeUpdate(query);
           System.out.println(query);
           System.out.println("DB 로그인 완료");
           return true;
        }
         catch (SQLException e){
           e.printStackTrace();
           System.out.println("DB islogin 실패!! 사유 : " + e.getMessage());
        }
         return false;
   }
   
 //로그아웃
   public boolean isLogOut(String ID) {
      try {
           query = "UPDATE account_chk SET ischeck = '' WHERE ID = '"+ID+"';";
           Statement sta = connection.createStatement();
           sta.executeUpdate(query);
           System.out.println(query);
           System.out.println("DB 로그아웃 완료");
           return true;
        }
         catch (SQLException e){
           e.printStackTrace();
           System.out.println("DB islogin 실패!! 사유 : " + e.getMessage());
        }
         return false;
   }
   
   public String isLogin_chk() {
      try {
           query = "SELECT EXISTS (SELECT * FROM account_chk WHERE ischeck = 'true' limit 1) AS SUCCESS;";
           Statement sta = connection.createStatement();
           rs = sta.executeQuery(query);
           System.out.println(query);
           if(rs.next()){
              int i=1;
               if(i == rs.getInt("SUCCESS")){
                    System.out.println("로그인 되어있음!!!\n");
                    query = "SELECT * FROM account_chk Order BY ID DESC LIMIT 1;";
                    Statement sta1 = connection.createStatement();
                    rs = sta1.executeQuery(query);
                    System.out.println(query);
                    if(rs.next()){
                       return rs.getString("ID");
                    }
               }
               else {
                  System.out.println("로그아웃중!!!!\n");
               }
            }
           System.out.println("DB 로그인 완료");
        }
         catch (SQLException e){
           e.printStackTrace();
           System.out.println("DB islogin 실패!! 사유 : " + e.getMessage());
        }
         return null;
   }
}