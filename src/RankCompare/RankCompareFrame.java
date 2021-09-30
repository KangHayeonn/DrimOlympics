package RankCompare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RankCompareFrame extends JPanel {
	private JFrame frame;
	private RankComparePanel RankComparePanel;

	public RankCompareFrame(JFrame frame) {
		super();
		FrameInit(frame);
		PanelInit();
	}
	private void FrameInit(JFrame frame) {

		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 1280, 960);

		frame.getContentPane().add(this);
		this.setLayout(null);
	}

	private void PanelInit() {
		RankComparePanel = new RankComparePanel(frame);

		RankComparePanel.setBounds(80, 200, 1100, 600);
		RankComparePanel.setBackground(new Color(242, 242, 242));
		RankComparePanel.setBorder(null); 

		this.add(RankComparePanel);
	}
}