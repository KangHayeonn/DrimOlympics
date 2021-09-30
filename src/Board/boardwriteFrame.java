package Board;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class boardwriteFrame extends JPanel {
   private JFrame frame;
   private boardwritePanel BoardWritePanel;
   

   public boardwriteFrame(JFrame frame) {
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
      BoardWritePanel = new boardwritePanel(frame);

      BoardWritePanel.setBounds(80, 200, 1100, 600);
      BoardWritePanel.setBackground(new Color(242, 242, 242));
      BoardWritePanel.setBorder(null); 

      this.add(BoardWritePanel);
   }
}