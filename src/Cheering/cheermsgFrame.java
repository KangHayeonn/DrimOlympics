package Cheering;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class cheermsgFrame extends JPanel {
	private JFrame frame;
	private cheermsgPanel cheermsgPanel;

	public cheermsgFrame(JFrame frame) {
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
		cheermsgPanel = new cheermsgPanel(frame);

		cheermsgPanel.setBounds(80, 200, 1100, 600);
		cheermsgPanel.setBackground(new Color(242, 242, 242));
		cheermsgPanel.setBorder(null); 

		this.add(cheermsgPanel);
	}
}