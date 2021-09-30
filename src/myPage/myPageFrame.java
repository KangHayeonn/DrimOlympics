package myPage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Database.WithdrawalDB;
import Database.myPageDB;
import Login.LoginCheck;
import Main.funcBtn;
import Main.funcBtnEffect;

public class myPageFrame extends JFrame {
   private JFrame frame;
   private myPagePanel myPagePanel;

   public myPageFrame(JFrame frame) {
      super();
      FrameInit(frame);
      PanelInit();
   }
   private void FrameInit(JFrame frame) {
        this.getContentPane().setLayout(null);
            
        ImageIcon img = new ImageIcon("./img/drim_img.png");
        this.setIconImage(img.getImage());
            
         this.setBackground(new Color(255, 255, 255));
         this.setBounds(500, 200, 1000, 700);
         this.setLayout(null);
         
         funcBtn funcBtn = new funcBtn();
         funcBtnEffect btnEffect = new funcBtnEffect();
         //마이페이지    
  
         JButton mypgQuitbtn = new JButton("자기소개 내용 지우기");
         JTextArea introInput = new JTextArea("");
         JButton introBtn = new JButton("완료");
         JButton WithdrawalBtn = new JButton("회원탈퇴");
         
         funcBtn.funcbtn(mypgQuitbtn, 750, 400, 170, 40, true);
         funcBtn.funcbtn(introBtn, 650, 400, 80, 40, true);
         funcBtn.funcbtn(WithdrawalBtn, 800, 460, 120, 40, true);

         funcBtn.funcTextArea(introInput, 330, 170, 605, 200);

           this.add(introInput);
           this.add(mypgQuitbtn); 
           this.add(introBtn);
           this.add(WithdrawalBtn);

       //마이페이지
         //mypage 취소 버튼
           btnEffect.btnMouseEffect(mypgQuitbtn);   
           mypgQuitbtn.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {       
                   introInput.setText("");
//                   dispose();
             }
           });
           myPageDB myPageDB = new myPageDB();
         //mypage 자기소개 완료 버튼
           btnEffect.btnMouseEffect(introBtn);   
           introBtn.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                   String inIntro = introInput.getText();
                   myPageDB.insertIntro(inIntro);
                   System.out.println(inIntro);
                   JOptionPane.showMessageDialog
                    (null, "등록되었습니다.", "Success!", JOptionPane.INFORMATION_MESSAGE); 
                 }
           });
           
           btnEffect.btnMouseEffect(WithdrawalBtn); 
         //회원탈퇴 버튼
           btnEffect.btnMouseEffect(WithdrawalBtn);   
           WithdrawalBtn.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                	 LoginCheck LoginChk = new LoginCheck();
                	 WithdrawalDB WithdrawalDB = new WithdrawalDB();
                	 //회원탈퇴 함수
                	 String ID = LoginChk.isLogin_chk();
                	 WithdrawalDB.deleteMember(ID);
                     dispose();
                 }
           });
   }

   private void PanelInit() {
      myPagePanel = new myPagePanel(frame);

      myPagePanel.setBounds(0, 0, 1000, 700);
      myPagePanel.setBackground(new Color(242, 242, 242));
      myPagePanel.setBorder(null); 

      this.add(myPagePanel);
   }
}