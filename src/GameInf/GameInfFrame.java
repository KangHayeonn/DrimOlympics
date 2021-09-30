package GameInf;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameInfFrame extends JPanel {
	
	private JFrame frame;
	private GameInfPanel gameInfPanel;

	public GameInfFrame(JFrame frame) {
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

		gameInfPanel = new GameInfPanel(frame);

		gameInfPanel.setBounds(80, 200, 1100, 600);
		gameInfPanel.setBackground(new Color(242, 242, 242));
		gameInfPanel.setBorder(null); // 테두리 없애기

		this.add(gameInfPanel);
	}
}
