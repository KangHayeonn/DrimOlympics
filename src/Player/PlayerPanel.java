package Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.funVisible;
import Main.funcBtn;

public class PlayerPanel extends JPanel {
	String name, event, country, medalCount;
	PlayerContent playerContent;
	// private PlayerParser playerParser;

	public PlayerPanel(JFrame frame) {
		super();
		PanelInit(frame);
		InputBox();
		OutputBox();

		NewsPrint();
	}

	private void PanelInit(JFrame frame) {

		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 1280, 960);
		this.setLayout(null);

		funcBtn funcbtn = new funcBtn();

		// Title
		JLabel tilteLabel = new JLabel("선수소개");
		funcbtn.funcMainLabel(tilteLabel, 100, 20, 900, 60, 0, 0, 0);
		this.add(tilteLabel);

		// Name(이름)
		JLabel Name = new JLabel("이름");
		funcbtn.funcLabel(Name, 350, 100, 135, 40, 166, 166, 166);
		this.add(Name);

		// event(종목)
		JLabel event = new JLabel("종목");
		funcbtn.funcLabel(event, 350, 210, 135, 40, 166, 166, 166);
		this.add(event);

		// country(국가)
		JLabel country = new JLabel("국가");
		funcbtn.funcLabel(country, 350, 310, 135, 40, 166, 166, 166);
		this.add(country);

	}

	private void InputBox() {

		// 이름 입력
		JTextField nameInput = new JTextField("An San");
		nameInput.setBounds(515, 100, 240, 40);
		funVisible funVisible = new funVisible();
		funVisible.clickIniti(nameInput);
		
		this.add(nameInput);

		
		// 종목 입력
		String eventList[] = {"양궁", "배구", "태권도"};

//		String eventList[] = { "3X3 농구", "7인제 럭비", "가라테", "골프", "근대5종경기", "기계체조", "농구", "다이빙", "레슬링", "리듬체조", "마라톤 수영",
//				"배구", "배드민턴", "복싱", "비치발리볼", "사격", "사이클 BMX 레이싱", "사이클 BMX 프리스타일", "사이클 도로", "사이클 산악 자전거", "사이클 트랙",
//				"서핑", "수구", "수영", "스케이트보드", "스포츠클라이밍", "승마", "아티스틱 수영", "야구/소프트볼", "양궁", "역도", "요트", "유도", "육상", "조정",
//				"축구", "카누 스프린트", "카누 슬라럼", "탁구", "태권도", "테니스", "트라이애슬론", "트램폴린 체조", "펜싱", "하키", "핸드볼" };
		
		JComboBox eventBox = new JComboBox<Object>(eventList);
		eventBox.setBounds(515, 205, 235, 40);

		this.add(eventBox);

		// 국가입력
		String countryList[] = { "대한민국", "중국", "미국" };

		JComboBox countryBox = new JComboBox<Object>(countryList);
		countryBox.setBounds(515, 310, 235, 40);
		this.add(countryBox);

		// input 결과물 출력
		JButton btnCompareSet = new JButton("적용");
		btnCompareSet.setBounds(870, 310, 130, 40);
		this.add(btnCompareSet);

		// 적용버튼 리스너
		btnCompareSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				name = (String) nameInput.getText();
				event = (String) eventBox.getSelectedItem();
				country = (String) countryBox.getSelectedItem();

				ArrayList<PlayerVO> SL = new ArrayList<PlayerVO>();
				// 임시 출력
				System.out.println(name + " / " + event + " / " + country);

				PlayerParser.PlayerSearch(name, event, country, SL);

				for(int i = 0; i < SL.size(); i++) {
					playerContent.setContent(SL.get(i).getCarrier());
					playerContent.setRank(SL.get(i).getRank());
					
					
					System.out.println(SL.get(i).getCarrier() + SL.get(i).getRank());
				};
				
				playerContent.setVisible(true);
				playerContent.repaint();
			}
		});
	}

	private void OutputBox() {
		// picture (선수 사진)
		ImageIcon icon = new ImageIcon("./img/player_test.jpg");

		Image playerImg = icon.getImage();
		Image changeImg = playerImg.getScaledInstance(230, 250, Image.SCALE_SMOOTH);

		ImageIcon changeIcon = new ImageIcon(changeImg);

		JLabel playerLabel = new JLabel(changeIcon);

		playerLabel.setBounds(100, 100, 230, 250);
		add(playerLabel);

	}

	private void NewsPrint() {
		playerContent = new PlayerContent();
		playerContent.setBounds(100, 370, 900, 200);

		playerContent.setForeground(Color.black); // Color
		playerContent.setBackground(Color.WHITE);
		playerContent.setOpaque(true);

		this.add(playerContent);
	}
}
