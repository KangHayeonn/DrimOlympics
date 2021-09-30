package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class maintableDB {

	ConnectionDB cDB;
	Connection con;
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
    public maintableDB() {
	    cDB = new ConnectionDB();
	    con = cDB.getConnection();
    }
    
    public void select(DefaultTableModel model) {
		String query = "select title, content, writer, wridate from boardwrite Limit 0,10;";
		
		try {
			con = cDB.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery(); // 리턴받아와서 데이터를 사용할 객체생성
			
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String wridate = rs.getString("wridate");
				
				Object data[] = {title, content, writer, wridate};
				
				model.addRow(data);
				//System.out.println(title +", "+ content+ ", "+ writer+", "+wridate);
				
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e2) {}
		}
	}
    
    // 내식대로 pagination.. (구글 코드 포기)
 	public void btn_active(DefaultTableModel model, int count) {
 		model.setNumRows(0); // 테이블 초기화
 		
 		String query2 = "select * from boardwrite Limit "+0+(count-1)*10+","+10+";";
 		
 		try {
 			con = cDB.getConnection();
 			pstmt = con.prepareStatement(query2);
 			rs = pstmt.executeQuery(); // 리턴받아와서 데이터를 사용할 객체생성
 			
 			while(rs.next()) {
 				String title = rs.getString("title");
 				String content = rs.getString("content");
 				String writer = rs.getString("writer");
 				String wridate = rs.getString("wridate");
 				
 				Object data[] = {title, content, writer, wridate};
 				
 				model.addRow(data);
 				//System.out.println(title +", "+ content+ ", "+ writer+", "+wridate);
 				
 			}
 		} catch(Exception e1) {
 			System.out.println(e1.getMessage());
 		} finally {
 			try {
 				rs.close();
 				pstmt.close();
 				con.close();
 			} catch(Exception e2) {}
 		}
 	}
 	
    public void search(DefaultTableModel model, String search, JTextField s1) {
    	String query2 = "SELECT * FROM boardwrite WHERE content LIKE '%"+search+"%';";
		
		try {
			con = cDB.getConnection();
			pstmt = con.prepareStatement(query2);
			rs = pstmt.executeQuery(); // 리턴받아와서 데이터를 사용할 객체생성
			
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String wridate = rs.getString("wridate");
				
				Object data[] = {title, content, writer, wridate};
				
				model.addRow(data);
				//System.out.println(title +", "+ content+ ", "+ writer+", "+wridate);
			}
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				s1.setText("   검색어를 입력하시오.");
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e2) {}
		}
    }
}
