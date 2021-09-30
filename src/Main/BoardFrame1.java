package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BoardFrame1 extends JPanel {

	private JFrame frame;
	private BoardPanel1 boardPanel1;

	public BoardFrame1(JFrame frame) {
		super();
		FrameInit(frame);
		PanelInit();
	}

	private void FrameInit(JFrame frame) {

		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 1280, 340);

		frame.getContentPane().add(this);
		this.setLayout(null);
	}

	private void PanelInit() {

		boardPanel1 = new BoardPanel1(frame);

		boardPanel1.setBounds(30, 200, 1200, 400);
		boardPanel1.setBackground(new Color(242, 242, 242));
		boardPanel1.setBorder(null); // 테두리 없애기

		this.add(boardPanel1);
	}
}
