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

public class BoardFrame2 extends JPanel {

	private JFrame frame;
	private BoardPanel2 boardPanel2;

	public BoardFrame2(JFrame frame) {
		super();
		FrameInit(frame);
		PanelInit();
	}

	private void FrameInit(JFrame frame) {

		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 340, 1280, 600);

		frame.getContentPane().add(this);
		this.setLayout(null);
	}

	private void PanelInit() {

		boardPanel2 = new BoardPanel2(frame);

		boardPanel2.setBounds(30, 40, 1200, 430);
		boardPanel2.setBackground(new Color(255, 255, 255));
		boardPanel2.setBorder(null); // 테두리 없애기

		this.add(boardPanel2);
	}
}
