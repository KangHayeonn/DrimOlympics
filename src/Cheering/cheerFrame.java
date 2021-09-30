package Cheering;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class cheerFrame extends JPanel {
	private JFrame frame;
	private CheerPanel CheerPanel;

	public cheerFrame(JFrame frame) {
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
		CheerPanel = new CheerPanel(frame);

		CheerPanel.setBounds(80, 200, 1100, 600);
		CheerPanel.setBackground(new Color(242, 242, 242));
		CheerPanel.setBorder(null); 

		this.add(CheerPanel);
		
		JScrollPane scroll = new JScrollPane(CheerPanel);
		scroll.setBounds(80,  200, 1100, 600);
		this.add(scroll);
		//JScrollPane scroll = new JScrollPane(CheerPanel);
        //scroll.setLocation(80, 200);
        //scroll.setSize(1100, 1000);
		//this.add(scroll);
	}
}