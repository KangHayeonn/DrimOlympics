package Cheering;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.cheermsgDB;
import Main.funcBtn;

public class cheermsgPanel extends JPanel {

	
	int count =0;
	String color = null;
	JTextField content;
	JButton redbtn, yellowbtn, orangebtn, greenbtn, skybluebtn, whitebtn;
	
	public cheermsgPanel(JFrame frame) {
		super();
		panelInit(frame);
	}
	
	public void panelInit(JFrame frame) {
		
		// 메인 화면 패널
		this.setBackground(new Color(255, 255, 255));
	    this.setBounds(0, 0, 1280, 960);
	    this.setLayout(null);
	   
	    
	    // Title
 		JLabel tilteLabel = new JLabel("응원 메시지 남기기");
 		tilteLabel.setBounds(300, 40, 480, 40);

 		tilteLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24)); // Font

 		tilteLabel.setForeground(Color.white); // Color
 		tilteLabel.setBackground(Color.black);
 		tilteLabel.setOpaque(true);

 		tilteLabel.setHorizontalAlignment(JLabel.CENTER); // Position

 		this.add(tilteLabel);
 		
 		
 	    // 내용작성
 		
 		content = new JTextField("내용작성");
		content.setBounds(330, 110, 420, 420);
		content.setFont(new Font("맑은 고딕", Font.BOLD, 15)); // Font

		content.setForeground(Color.black); // Color
		content.setBackground(new Color(166, 166, 166));
		content.setOpaque(true);
		content.setHorizontalAlignment(JLabel.CENTER); // Position -> TextField 쓸경우 중간 정렬 가능

		this.add(content);
		
		content.addMouseListener(new MouseAdapter(){
	          @Override
	          public void mouseClicked(MouseEvent e){
	             content.setText("");
	          }
	    });
		

		// 배경색 변경 버튼
		JButton btnChangeColor = new JButton("배경색 선택");
		btnChangeColor.setBounds(110, 150, 100, 30);
		btnChangeColor.setFont(new Font("맑은 고딕", Font.BOLD, 12)); // Font
		btnChangeColor.setBackground(new Color(242,242,242));
		btnChangeColor.setForeground(Color.black);
		btnChangeColor.setBorderPainted(false);
	    btnChangeColor.setFocusPainted(false);
	    btnChangeColor.setBorderPainted(true);
		
		this.add(btnChangeColor);
		
		redbtn = new JButton("");
		yellowbtn = new JButton("");
		orangebtn = new JButton("");
		skybluebtn = new JButton("");
		greenbtn = new JButton("");
		whitebtn = new JButton("");
		
		funcBtn funcbtn = new funcBtn();
		funcbtn.colorbtn(redbtn,148, 200, 20, 28,247,146,129);
		funcbtn.colorbtn(yellowbtn,148, 240, 20, 28,255,255,0);
		funcbtn.colorbtn(orangebtn,148, 280, 20, 28,255,192,0);
		funcbtn.colorbtn(skybluebtn,148, 320, 20, 28,105,216,255);
		funcbtn.colorbtn(greenbtn,148, 360, 20, 28,85,241,59);
		funcbtn.colorbtn(whitebtn,148, 400, 20, 28,255,255,255);
		
		this.add(redbtn);
		this.add(yellowbtn);
		this.add(orangebtn);
		this.add(skybluebtn);
		this.add(greenbtn);
		this.add(whitebtn);
		

		
		redbtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 content.setBackground(new Color(247,146,129));
	        	 color = "RED";
	         }
	    });
		
		yellowbtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 content.setBackground(new Color(255,255,0));
	        	 color = "YELLOW";
	         }
	    });
		
		orangebtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 content.setBackground(new Color(255,192,0));
	        	 color = "ORANGE";
	         }
	    });
		
		skybluebtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 content.setBackground(new Color(105,216,255));
	        	 color = "SKYBLUE";
	         }
	    });
		
		greenbtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 content.setBackground(new Color(85,241,59));
	        	 color = "GREEN";
	         }
	    });
		
		whitebtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 content.setBackground(new Color(166, 166, 166));
	        	 color = "WHITE";
	         }
	    });
		
		btnChangeColor.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if(count==0) {
	        		redbtn.setVisible(true);
	 	            yellowbtn.setVisible(true);
	 	            orangebtn.setVisible(true);
	 	            skybluebtn.setVisible(true);
	 	            greenbtn.setVisible(true);
	 	            whitebtn.setVisible(true);
	 	            count=1;
	        	 }
	        	 else if(count==1) {
	        		 redbtn.setVisible(false);
	 	             yellowbtn.setVisible(false);
	 	             orangebtn.setVisible(false);
	 	             skybluebtn.setVisible(false);
	 	             greenbtn.setVisible(false);
	 	             whitebtn.setVisible(false);
	 	             count=0;
	        	 }
	         }
	      });
		
		
        btnChangeColor.addMouseListener(new java.awt.event.MouseAdapter() {
          public void mouseEntered(java.awt.event.MouseEvent evt) {
             btnChangeColor.setBackground(Color.black);
             btnChangeColor.setForeground(Color.white);
             //player_Btn.setBorderPainted(true);
          }
          public void mouseExited(java.awt.event.MouseEvent evt) {
         	 btnChangeColor.setBackground(new Color(242,242,242));
             btnChangeColor.setForeground(Color.black);
         }
        });
                
        
        
        // input 결과물 출력 (응원메시지 작성)
 		// 등록버튼
 		JButton btnPostcheer = new JButton("등록");
 		//funcBtn funcbtn = new funcBtn();
 		funcbtn.funcbtn(btnPostcheer,690, 540, 90, 34, true);
 	    btnPostcheer.setBorderPainted(true);	
 		this.add(btnPostcheer);
 				
 				
 		// 적용버튼 리스너
 		 btnPostcheer.addActionListener(new ActionListener() {
 			 public void actionPerformed(ActionEvent e) {
 				
 			 	//connectDB cDB = new connectDB();
 			 	String postCheer;
 			 	postCheer = (String) content.getText();
 			 	
 			 	//MsgVO data = new MsgVO();
 			 	//data.setColor(color);
 			 	ArrayList<cheermsgVO> list = new ArrayList<cheermsgVO>(); // 게터세터를 받아줄 배열을 먼저 만들어줌
 			 	cheermsgVO data = new cheermsgVO(); // 해당 클래스를 호출
 			 	
 			 	data.setColor(color); // 해당 클래스에 데이터를 SET
 			 	data.setCheertext(postCheer); // 해당 클래스에 데이터를 SET
 			 	
 			 	list.add(data); // data를 list에 저장시켜줌
 			 	
 			 	cheermsgDB s = new cheermsgDB(); // DB함수를 호출
 			 	s.sendDB(data); // 해당 함수에 data를 보내줌
 			 	
 				// 임시 출력
 			 	System.out.println(data.getColor() + data.getCheertext());
 			 	BtnInit();
 			 	//CheerPanel CheerPanel=new CheerPanel();
 			 	//포스트잇 색상, 텍스트 변경 함수 호출
 			 	//s.callCheerMsg();
 	      }
 		 });
	}
	
	// 등록버튼 클릭시 초기화 함수
	private void BtnInit() {
		content.setText("내용작성");
		content.setBackground(new Color(166, 166, 166));
		redbtn.setVisible(false);
        yellowbtn.setVisible(false);
        orangebtn.setVisible(false);
        skybluebtn.setVisible(false);
        greenbtn.setVisible(false);
        whitebtn.setVisible(false);
	}
			 	
}
