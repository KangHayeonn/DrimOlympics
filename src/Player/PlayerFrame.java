package Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PlayerFrame extends JPanel {

	private JFrame frame;
	private PlayerPanel playerPanel;

	public PlayerFrame(JFrame frame) {
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

		playerPanel = new PlayerPanel(frame);

		playerPanel.setBounds(80, 200, 1100, 600);
		playerPanel.setBackground(new Color(242, 242, 242));
		playerPanel.setBorder(null);
		this.add(playerPanel);
	}
}