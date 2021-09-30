//기록/랭킹비교 - 민지

package RankCompare;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;

public class RankComparePanel extends JPanel {

	public RankComparePanel(JFrame frame) {
		super();
		panelInit(frame);
	}

	private void panelInit(JFrame frame) {
		
		// 메인 화면 패널
		this.setBackground(new Color(242, 242, 242));
		this.setBounds(0, 0, 1280, 960);
		frame.getContentPane().add(this);
		this.setLayout(null);
		
		//리스트로 바꾸기
		RankParser getrankparser = new RankParser();
		getrankparser.addList();
		
		ArrayList<String> gameList = getrankparser.getListGame();
		Iterator<String> itrGame = gameList.iterator();
		ArrayList<String> m_player_List = getrankparser.getListMP();
		Iterator<String> itrMP = m_player_List.iterator();
		ArrayList<String> m_rank_List = getrankparser.getListMR();
		Iterator<String> itrMR = m_rank_List.iterator();
		ArrayList<String> f_player_List = getrankparser.getListFP();
		Iterator<String> itrFP = f_player_List.iterator();
		ArrayList<String> f_rank_List = getrankparser.getListFR();
		Iterator<String> itrFR = f_rank_List.iterator();

		
        //테이블
	    String []header = {"종목", "남자선수명" , "남자기록", "여자선수명", "여자기록"};
	    String [][]contents = new String[36][header.length];
	   
		   for(int j = 0; j < 36; j++) {
			   int size = 0;
			   contents[j][size] = itrGame.next();
			   size++;
			   contents[j][size] = itrMP.next();
			   size++;
			   contents[j][size] = itrMR.next();
			   size++;
			   contents[j][size] = itrFP.next();
			   size++;
			   contents[j][size] = itrFR.next();
			   size++;
		   }
		   
		
		JTable table = new JTable(contents, header);
		//테이블 행, 열 크기 조절
		table.setRowHeight(50);
		table.getColumn(header[0]).setPreferredWidth(150);
		table.getColumn(header[1]).setPreferredWidth(250);
		table.getColumn(header[2]).setPreferredWidth(100);
		table.getColumn(header[3]).setPreferredWidth(250);
		table.getColumn(header[4]).setPreferredWidth(100);
		
		//테이블 크기 
		table.setRowHeight(49);
		table.setFont(new Font("맑은고딕", Font.PLAIN, 18));
		JTableHeader THeader = table.getTableHeader();
		//헤더 배경 색 
		THeader.setBackground(Color.BLACK);
		
		//헤더 글자 색 및 배경 색 + 글자 크기
		THeader.setForeground(Color.WHITE);
		THeader.setBackground(Color.BLACK);
		THeader.setFont(new Font("맑은고딕", Font.BOLD, 18));
		
		//테이블 내용 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); //디폴트테이블셀렌더러 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); //렌더러의 가로정렬 CENTER
		TableColumnModel tcm = table.getColumnModel(); //정렬할 테이블의 컬럼모델 가져오기
		
		for(int i = 0;i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr); // 각각의 셀렌더러를 dtcr에 set
		}

		JScrollPane jscp1 = new JScrollPane(table);//테이블 볼 수 있게 해줌
		jscp1.setLocation(200, 200);
		jscp1.setSize(900, 572);
		
		this.add(jscp1);
	}
}
