package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Login.LoginCheck;

public class WithdrawalDB {
    private Connection connection;
    private ConnectionDB DB_Connection;
    
    private ResultSet rs=null;
    private String query=null;
    private Statement sta;
    private PreparedStatement ps;
    LoginCheck LoginChk = new LoginCheck();
    
    public WithdrawalDB() {
    	ConnectionDB DB_Connection = new ConnectionDB();
        connection = DB_Connection.getConnection();
    }

    //È¸¿øÅ»Åð
    public boolean deleteMember(String myID){
       try {
          query = "DELETE FROM account WHERE ID = '"+ myID+ "';";
          Statement sta = connection.createStatement();
          sta.executeUpdate(query);
          System.out.println(query);
          query = "DELETE FROM account_chk WHERE ID = '"+ myID+ "';";
          Statement sta1 = connection.createStatement();
          sta1.executeUpdate(query);
          System.out.println(query);

          System.out.println("È¸¿øÅ»Åð ¿Ï·á!!!\n");
          JOptionPane.showMessageDialog(null, "Good BYE!", "È¸¿øÅ»Åð", JOptionPane.INFORMATION_MESSAGE);
          return true;

       }
        catch (SQLException e){
          e.printStackTrace();
          System.out.println("DB È¸¿øÅ»Åð ½ÇÆÐ!! »çÀ¯ : " + e.getMessage());
       } 
       return false;
    }
}
