package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Board.boardwritePanel;
import Board.boardwriteVO;

public class boardwriteDB {
   
	ConnectionDB cDB;
	Connection con;
	
   public boardwriteDB() {
	   cDB = new ConnectionDB();
	   con = cDB.getConnection();
   }

   //게시물 작성
   public void uploadDB(boardwriteVO s) {
		
		try {
	
			String query = "INSERT INTO boardwrite(UserID, writer, wridate, pw, title, content, file) VALUES('" + s.getUserID() + "','" + s.getwriter() + "','" + s.getwridate() + "','" + s.getpw() + "','" + s.gettitle() + "','" + s.getcontent() + "','" + s.getfile() + "')";
			
			JOptionPane.showMessageDialog
			(null, "등록되었습니다!", "BOARD MESSAGE", JOptionPane.INFORMATION_MESSAGE);
			
			System.out.println("작성자: " + s.getUserID() + " / 작성자 표시: " + s.getwriter() + " / 작성 기간: " + s.getwridate() + " / 비밀번호: " + s.getpw() + " / 제목: " + s.gettitle() + " / 내용: " + s.getcontent() + "/ 첨부파일: " + s.getfile() + " 가 " + "DB로 전송되었습니다!");
			Statement state = con.createStatement();
			
			int x = state.executeUpdate(query);
			System.out.println("보내진 query문 : " + x);
			
			query= "SELECT * from boardwrite";
			ResultSet rs = state.executeQuery(query);
			
			try {
				rs.close();
				state.close();
				con.close();
			 } catch (SQLException e1) { }
			
		} catch(Exception e) {
			System.out.println("ERROR : query문 DB로 전송 실패");
		    e.printStackTrace();
		}
   }
}