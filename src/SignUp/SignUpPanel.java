package SignUp;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.funcBtn;

public class SignUpPanel extends JPanel{
   public SignUpPanel(JFrame frame) {
      super();
      panelInit(frame);
   }

   public void panelInit(JFrame frame) {
      
      funcBtn label = new funcBtn();
      // 로그인 화면 패널
      this.setBackground(new Color(255, 255, 255));
      this.setBounds(0,0,1000,700);
      this.setLayout(null);

      //회원가입 글자
      JLabel regtitle = new JLabel("회원가입");
      label.funcMainLabel(regtitle, 110, 50, 800, 35,24, 23, 23);
      this.add(regtitle);
      
      //이름 글자
      JLabel nameTxt = new JLabel("이름");
      label.funcLabel(nameTxt, 250, 200, 100, 40, 166, 166, 166);
      this.add(nameTxt);


      //id 글자
      JLabel idTxt = new JLabel("ID");
      label.funcLabel(idTxt, 250, 250, 100, 40, 166, 166, 166);
      this.add(idTxt);
      
      //pw 글자
      JLabel pwTxt = new JLabel("PW");
      label.funcLabel(pwTxt, 250, 300, 100, 40, 166, 166, 166);
      this.add(pwTxt);
      
      //pw2 글자
      JLabel pw2Txt = new JLabel("PW 확인");
      label.funcLabel(pw2Txt, 250, 350, 100, 40, 166, 166, 166);
      this.add(pw2Txt);

      //이메일 글자
      JLabel emailTxt = new JLabel("이메일");
      label.funcLabel(emailTxt, 250, 400, 100, 40, 166, 166, 166);
      this.add(emailTxt);
      
      //닉네임 글자
      JLabel nicTxt = new JLabel("닉네임");
      label.funcLabel(nicTxt, 250, 450, 100, 40, 166, 166, 166);
      this.add(nicTxt);
   }
}