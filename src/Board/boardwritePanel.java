package Board;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.boardwriteDB;


public class boardwritePanel extends JPanel {

	int count = 0;
	JTextField UserID, writer, wridate, pw, title, content, file;
	/*JComboBox<String> writer;*/
	
	public boardwritePanel(JFrame frame) {
		super();
		panelInit(frame);
	}
	
	private void panelInit(JFrame frame) {
		// 게시물 작성 화면 패널
		this.setBackground(new Color(255, 255, 255));
	    this.setBounds(0, 0, 1280, 960);
	    this.setLayout(null);
	    
	    // 게시물 작성 글자
	    JLabel writetitle = new JLabel("게시물 작성");
	    writetitle.setBounds(130, 30, 800, 35);
	    writetitle.setFont(new Font("고딕", Font.BOLD, 30)); // Font
	    writetitle.setForeground(Color.white); // Color
	    writetitle.setBackground(new Color(24, 23, 23));
	    writetitle.setOpaque(true);
	    writetitle.setHorizontalAlignment(JLabel.CENTER);
	    this.add(writetitle);
	    
	    // 작성자 글자
	    JLabel UserIDTxt = new JLabel("작성자");
	    UserIDTxt.setBounds(130, 100, 100, 40);
	    UserIDTxt.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    UserIDTxt.setForeground(Color.black); // Color
	    UserIDTxt.setBackground(new Color(166, 166, 166));
	    UserIDTxt.setOpaque(true);
	    UserIDTxt.setHorizontalAlignment(JLabel.CENTER);
	    this.add(UserIDTxt);
	    
	    // 작성자 입력
	    UserID = new JTextField("");
	    UserID.setBounds(250, 100, 200, 40);
	    UserID.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    UserID.setForeground(Color.black); // Color
	    UserID.setBackground(new Color(255,255,255));
	    UserID.setOpaque(true);
	    UserID.setHorizontalAlignment(JLabel.CENTER);
	    this.add(UserID);
	    
	    UserID.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		UserID.setText("");
	    	}
	    });
	    
	    //작성자 표시 글자
	    JLabel writerTxt = new JLabel("작성자 표시");
	    writerTxt.setBounds(500, 100, 120, 40);
	    writerTxt.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    writerTxt.setForeground(Color.black); // Color
	    writerTxt.setBackground(new Color(166, 166, 166));
	    writerTxt.setOpaque(true);
	    writerTxt.setHorizontalAlignment(JLabel.CENTER);
	    this.add(writerTxt);
	    
	    writer = new JTextField("");
	    writer.setBounds(650, 100, 200, 40);
	    writer.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    writer.setForeground(Color.black); // Color
	    writer.setBackground(new Color(255,255,255));
	    writer.setOpaque(true);
	    writer.setHorizontalAlignment(JLabel.CENTER);
	    this.add(writer);
	    
	    writer.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		writer.setText("");
	    	}
	    });
	    
	    //작성자 표시 종류 선택(드롭박스)
	    /*
	    String[] optionsToChoose = {"이름", "닉네임", "익명"};
	    JComboBox<String> writer = new JComboBox<>(optionsToChoose);
	    writer.setBounds(650, 100, 200, 40);
	    JLabel jLabel = new JLabel();
	    jLabel.setBounds(90, 100, 400, 100);
	    this.add(writer);
	    */
	    
	    //작성 기간 글자
	    JLabel wridateTxt = new JLabel("작성 기간");
	    wridateTxt.setBounds(130, 150, 100, 40);
	    wridateTxt.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    wridateTxt.setForeground(Color.black); // Color
	    wridateTxt.setBackground(new Color(166, 166, 166));
	    wridateTxt.setOpaque(true);
	    wridateTxt.setHorizontalAlignment(JLabel.CENTER);
	    this.add(wridateTxt);
		
	  //작성 기간 입력
	    wridate = new JTextField("");
	    wridate.setBounds(250, 150, 200, 40);
	    wridate.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    wridate.setForeground(Color.black); // Color
	    wridate.setBackground(new Color(255,255,255));
	    wridate.setOpaque(true);
	    wridate.setHorizontalAlignment(JLabel.CENTER);
	    this.add(wridate);
	    
	    wridate.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		wridate.setText("");
	    	}
	    });
	    
	    //비밀번호 글자
	    JLabel pwTxt = new JLabel("비밀번호");
	    pwTxt.setBounds(500, 150, 100, 40);
	    pwTxt.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    pwTxt.setForeground(Color.black); // Color
	    pwTxt.setBackground(new Color(166, 166, 166));
	    pwTxt.setOpaque(true);
	    pwTxt.setHorizontalAlignment(JLabel.CENTER);
	    this.add(pwTxt);
	    
	    //비밀번호 입력
	    pw = new JTextField("");
	    pw.setBounds(650, 150, 200, 40);
	    pw.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    pw.setForeground(Color.black); // Color
	    pw.setBackground(new Color(255,255,255));
	    pw.setOpaque(true);
	    pw.setHorizontalAlignment(JLabel.CENTER);
	    this.add(pw);
	    
	    pw.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		pw.setText("");
	    	}
	    });
	    
	    //제목 글자
	    JLabel titleTxt = new JLabel("제목");
	    titleTxt.setBounds(130, 200, 100, 40);
	    titleTxt.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    titleTxt.setForeground(Color.black); // Color
	    titleTxt.setBackground(new Color(166, 166, 166));
	    titleTxt.setOpaque(true);
	    titleTxt.setHorizontalAlignment(JLabel.CENTER);
	    this.add(titleTxt);
	    
	    //제목 입력
	    title = new JTextField("");
	    title.setBounds(250, 200, 600, 40);
	    title.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    title.setForeground(Color.black); // Color
	    title.setBackground(new Color(255,255,255));
	    title.setOpaque(true);
	    title.setHorizontalAlignment(JLabel.CENTER);
	    this.add(title);
	    
	    title.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		title.setText("");
	    	}
	    });
	    
	    //내용 글자
	    JLabel contentTxt = new JLabel("내용");
	    contentTxt.setBounds(130, 250, 100, 40);
	    contentTxt.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    contentTxt.setForeground(Color.black); // Color
	    contentTxt.setBackground(new Color(166, 166, 166));
	    contentTxt.setOpaque(true);
	    contentTxt.setHorizontalAlignment(JLabel.CENTER);
	    this.add(contentTxt);
	    
	    //내용 입력
	    content = new JTextField("");
	    content.setBounds(250, 250, 600, 225);
	    content.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    content.setForeground(Color.black); // Color
	    content.setBackground(new Color(255,255,255));
	    content.setOpaque(true);
	    content.setHorizontalAlignment(JLabel.CENTER);
	    this.add(content);
	    
	    content.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		content.setText("");
	    	}
	    });
	    
	    //첨부파일 글자
	    JLabel fileTxt = new JLabel("첨부파일");
	    fileTxt.setBounds(130, 500, 100, 40);
	    fileTxt.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    fileTxt.setForeground(Color.black); // Color
	    fileTxt.setBackground(new Color(166, 166, 166));
	    fileTxt.setOpaque(true);
	    fileTxt.setHorizontalAlignment(JLabel.CENTER);
	    this.add(fileTxt);
	    
	    //첨부파일 업로드
	    JButton fileBtn = new JButton("업로드");
	    fileBtn.setFont(new Font("고딕", Font.BOLD, 14));
	    fileBtn.setBackground(new Color(217, 217, 217));
	    fileBtn.setBounds(250, 510, 80, 30);
	    fileBtn.setBorderPainted(false);
	    fileBtn.setFocusPainted(false);
	    this.add(fileBtn);
	    
	    //첨부파일 내용표시 (기능 삽입하면서 일부 수정 예정)
	    file = new JTextField("");
	    file.setBounds(340, 510, 500, 30);
	    file.setFont(new Font("고딕", Font.BOLD, 20)); // Font
	    file.setForeground(Color.black); // Color
	    file.setBackground(new Color(255,255,255));
	    file.setOpaque(true);
	    file.setHorizontalAlignment(JLabel.CENTER);
	    this.add(file);
	    
	    file.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		file.setText("");
	    	}
	    });
	    
	    //등록 버튼
	    JButton regisBtn = new JButton("등록");
	    regisBtn.setFont(new Font("고딕", Font.BOLD, 14));
	    regisBtn.setBackground(new Color(217, 217, 217));
	    regisBtn.setBounds(870, 550, 80, 40);
	    regisBtn.setBorderPainted(false);
	    regisBtn.setFocusPainted(false);
	    this.add(regisBtn);
	    
	 // input 결과물 출력 (게시물 작성)
	 // 적용버튼 리스너
		 regisBtn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				
				//connectDB cDB = new connectDB();
			 	String regis;
			 	regis = (String) UserID.getText();
			 	regis = (String) writer.getText();
			 	regis = (String) wridate.getText();
			 	regis = (String) pw.getText();
			 	regis = (String) title.getText();
				regis = (String) content.getText();
				regis = (String) file.getText();
				
			 	
			 	ArrayList<boardwriteVO> list = new ArrayList<boardwriteVO>(); // 게터세터를 받아줄 배열을 먼저 만들어줌
			 	boardwriteVO data = new boardwriteVO(); // 해당 클래스를 호출
 			 	
			 	data.setUserID(UserID.getText());
			 	data.setwriter(writer.getText());
			 	data.setwridate(wridate.getText());
			 	data.setpw(pw.getText());
			 	data.settitle(title.getText());
			 	data.setcontent(content.getText());
			 	data.setfile(file.getText());
			 	
			 	list.add(data); // data를 list에 저장시켜줌
			 	
			 	boardwriteDB s = new boardwriteDB(); // DB함수를 호출
			 	s.uploadDB(data); // 해당 함수에 data를 보내줌
			 	
			 // 임시 출력
 			 	System.out.println(data.getUserID() + data.getwriter() + data.getwridate() + data.getpw() + data.gettitle() + data.getcontent() + data.getfile());
 			 	BtnInit();
			 	
			 }
	      });
	}
	
	private void BtnInit() {
		UserID.setText("");
		UserID.setBackground(new Color(255,255,255));
		writer.setText("");
		writer.setBackground(new Color(255,255,255));
		wridate.setText("");
		wridate.setBackground(new Color(255,255,255));
		pw.setText("");
		pw.setBackground(new Color(255,255,255));
		title.setText("");
		title.setBackground(new Color(255,255,255));
		content.setText("");
		content.setBackground(new Color(255,255,255));
		file.setText("");
		file.setBackground(new Color(255,255,255));
	}
}