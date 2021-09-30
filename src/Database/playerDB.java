package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Login.LoginCheck;

public class playerDB {
	ConnectionDB ConnectionDB = null;
	Connection connection = null;

	private ResultSet rs=null;
    private String query=null;
    private Statement sta;
    private PreparedStatement ps;
    
	public playerDB() {
		ConnectionDB = new ConnectionDB();
		connection = ConnectionDB.getConnection();
	}
	
	//db search값 등록
    public boolean insertSearch(String playerName, String event, String country){
        try {
             query = "INSERT INTO playerSearch values('"+playerName+"','"+event+"','"+country+"');";
             Statement sta = connection.createStatement();
             sta.executeUpdate(query);
             System.out.println(query);
             System.out.println("DB mypage 글등록 완료");
             return true;
          } catch (SQLException e){
             e.printStackTrace();
             System.out.println("DB mypage 글등록 실패!! 사유 : " + e.getMessage());
          }
        return false;
     }
    
    public void deleteSearch() {
    	 try {
    	query = "TRUNCATE playerSearch;";
        Statement sta = connection.createStatement();
        sta.executeUpdate(query);
        System.out.println(query);
        System.out.println("DB mypage 글등록 완료");
    	 }catch (SQLException e){
             e.printStackTrace();
             System.out.println("DB 회원탈퇴 실패!! 사유 : " + e.getMessage());
          } 
    }
    
    public String getPlayerName() {
    	try {
              query = "SELECT playerName FROM playerSearch;";
              Statement sta = connection.createStatement();
              rs = sta.executeQuery(query);
              System.out.println(query);
              if(rs.next()){
            	   return rs.getString("playerName");
            	   }
           }
            catch (SQLException e){
              e.printStackTrace();
              System.out.println("DB playerName가져오기 실패!! 사유 : " + e.getMessage());
           }
            return null;
      }
    
    public String getEvent() {
    	try {
              query = "SELECT eventName FROM playerSearch;";
              Statement sta = connection.createStatement();
              rs = sta.executeQuery(query);
              System.out.println(query);
              if(rs.next()){
            	   return rs.getString("eventName");
            	   }
           }
            catch (SQLException e){
              e.printStackTrace();
              System.out.println("DB event 가져오기 실패!! 사유 : " + e.getMessage());
           }
            return null;
      }
    public String getCountry() {
    	try {
              query = "SELECT country FROM playerSearch;";
              Statement sta = connection.createStatement();
              rs = sta.executeQuery(query);
              System.out.println(query);
              if(rs.next()){
            	   return rs.getString("country");
            	   }
           }
            catch (SQLException e){
              e.printStackTrace();
              System.out.println("DB country s가져오기 실패!! 사유 : " + e.getMessage());
           }
            return null;
      }
    }

