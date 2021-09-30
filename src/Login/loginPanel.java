package Login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.funcBtn;

public class loginPanel extends JPanel {

   public loginPanel(JFrame frame) {
      super();
      panelInit(frame);
   }

   private void panelInit(JFrame frame) {
      // 로그인 화면 패널
      this.setBackground(new Color(255, 255, 255));
      this.setBounds(0, 0, 1280, 960);
      this.setLayout(null);
      funcBtn funcBtn =new funcBtn();
      //로그인 글자
      JLabel IDtitle = new JLabel("로그인");
      funcBtn.funcMainLabel(IDtitle, 130, 100, 800, 35,24, 23, 23);
      this.add(IDtitle);

      //pw 글자
      JLabel pwTxt = new JLabel("PW");
      funcBtn.funcLabel(pwTxt, 250, 320, 100, 40,166, 166, 166);
      this.add(pwTxt);
      
      //id 글자
      JLabel idTxt = new JLabel("ID");
      idTxt.setBounds(250, 230, 100, 40);
      funcBtn.funcLabel(idTxt, 250, 230, 100, 40,166, 166, 166);
      this.add(idTxt);
   }
}