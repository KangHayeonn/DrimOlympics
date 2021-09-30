package Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Board.boardwriteFrame;
import Cheering.cheerFrame;
import Cheering.cheermsgFrame;
import GameInf.GameInfFrame;
import Player.PlayerFrame;
import RankCompare.RankComparePanel;

public class funVisible {
   
   public void panelVisible(String label, BoardFrame1 boardPanel1, BoardFrame2 boardPanel2, cheerFrame CheerPanel,
		   boardwriteFrame BoardWritePanel, cheermsgFrame cheermsgPanel, GameInfFrame gameInfPanel,
         PlayerFrame playerPanel, RankComparePanel rankComparePanel, JButton c_writebtn) {
      switch(label) {
     //home 화면 출력
      case "main": boardPanel1.setVisible(true);
                  boardPanel2.setVisible(true);
       
                  BoardWritePanel.setVisible(false);
                  CheerPanel.setVisible(false);
                  cheermsgPanel.setVisible(false);
                  gameInfPanel.setVisible(false);
                  playerPanel.setVisible(false);
                  rankComparePanel.setVisible(false);
                  c_writebtn.setVisible(false);
                  break;
      //home에 있는 글작성패널
      case "BoardWrite" : BoardWritePanel.setVisible(true);   
           
                          boardPanel1.setVisible(false);
                          boardPanel2.setVisible(false);
                          CheerPanel.setVisible(false);
                          cheermsgPanel.setVisible(false);
                          gameInfPanel.setVisible(false);
                          playerPanel.setVisible(false);
                          rankComparePanel.setVisible(false);
                          c_writebtn.setVisible(false);
                          break;
        //응원게시판 글작성패널            
      case "cheermsg" :   boardPanel1.setVisible(false);
                         boardPanel2.setVisible(false);
                         BoardWritePanel.setVisible(false);
                         CheerPanel.setVisible(false);
                         
                         cheermsgPanel.setVisible(true);
                         gameInfPanel.setVisible(false);
                         playerPanel.setVisible(false);
                         rankComparePanel.setVisible(false);
                         c_writebtn.setVisible(false);

                         break;
          //선수게시판            
      case "player" :  BoardWritePanel.setVisible(false);   
                      boardPanel1.setVisible(false);
                      boardPanel2.setVisible(false);
                      CheerPanel.setVisible(false);
                      cheermsgPanel.setVisible(false);
                      gameInfPanel.setVisible(false);
                      playerPanel.setVisible(true);
                      rankComparePanel.setVisible(false);
                      c_writebtn.setVisible(false);

                       break;
       //rank 게시판            
      case "rank" :  BoardWritePanel.setVisible(false);   
                      boardPanel1.setVisible(false);
                      boardPanel2.setVisible(false);
                      CheerPanel.setVisible(false);
                      cheermsgPanel.setVisible(false);
                      gameInfPanel.setVisible(false);
                      playerPanel.setVisible(false);
                      rankComparePanel.setVisible(true);
                      c_writebtn.setVisible(false);

                       break;
       //응원게시판            
      case "cheering" :  BoardWritePanel.setVisible(false);   
                      boardPanel1.setVisible(false);
                      boardPanel2.setVisible(false);
                      CheerPanel.setVisible(true);
                      cheermsgPanel.setVisible(false);
                      gameInfPanel.setVisible(false);
                      playerPanel.setVisible(false);
                      rankComparePanel.setVisible(false);
                      c_writebtn.setVisible(true);

                       break;
          //실시간 게시판            
      case "gameInf" :  BoardWritePanel.setVisible(false);   
                      boardPanel1.setVisible(false);
                      boardPanel2.setVisible(false);
                      CheerPanel.setVisible(false);
                      cheermsgPanel.setVisible(false);
                      gameInfPanel.setVisible(true);
                      playerPanel.setVisible(false);
                      rankComparePanel.setVisible(false);
                      c_writebtn.setVisible(false);

                       break;
      }
   }
   
   //menu 버튼 보이기와 menu 버튼에 효과없음 함수
   public void btnShow(JButton player_Btn, JButton cheering_Btn, 
          JButton gameInf_Btn, JButton rank_Btn) {
        player_Btn.setVisible(true);
        cheering_Btn.setVisible(true);
        gameInf_Btn.setVisible(true);
        rank_Btn.setVisible(true);
        
        player_Btn.setBorderPainted(false);
        player_Btn.setFocusPainted(false);
        cheering_Btn.setBorderPainted(false);
        cheering_Btn.setFocusPainted(false);
        gameInf_Btn.setBorderPainted(false);
        gameInf_Btn.setFocusPainted(false);
        rank_Btn.setBorderPainted(false);
        rank_Btn.setFocusPainted(false);
   }
   
   public void menuBtnShow(String label, JButton player_Btn, JButton cheering_Btn, 
          JButton gameInf_Btn, JButton rank_Btn) {
      switch(label) {
    //선수게시판            
      case "player" :  player_Btn.setBorderPainted(true);
                     cheering_Btn.setBorderPainted(false);
                     cheering_Btn.setFocusPainted(false);
                     gameInf_Btn.setBorderPainted(false);
                     gameInf_Btn.setFocusPainted(false);
                     rank_Btn.setBorderPainted(false);
                     rank_Btn.setFocusPainted(false);
                       break;
       //rank 게시판            
      case "rank" : rank_Btn.setBorderPainted(true);
                  player_Btn.setBorderPainted(false);
                  player_Btn.setFocusPainted(false);
                  cheering_Btn.setBorderPainted(false);
                  cheering_Btn.setFocusPainted(false);
                  gameInf_Btn.setBorderPainted(false);
                  gameInf_Btn.setFocusPainted(false);
                       break;
       //응원게시판            
      case "cheering" :  cheering_Btn.setBorderPainted(true);
                        player_Btn.setBorderPainted(false);
                        player_Btn.setFocusPainted(false);
                        gameInf_Btn.setBorderPainted(false);
                        gameInf_Btn.setFocusPainted(false);
                        rank_Btn.setBorderPainted(false);
                        rank_Btn.setFocusPainted(false);
                       break;
          //실시간 게시판            
      case "gameInf" : gameInf_Btn.setBorderPainted(true);
                     player_Btn.setBorderPainted(false);
                     player_Btn.setFocusPainted(false);
                     cheering_Btn.setBorderPainted(false);
                     cheering_Btn.setFocusPainted(false);
                     rank_Btn.setBorderPainted(false);
                     rank_Btn.setFocusPainted(false);
                       break;
      }
   }
   
   //login 했을때 버튼
   public void loginModeBtn(String label, JButton loginbtn, JButton logOutbtn, JButton myPage_Btn,
            JButton regMembtn, JButton writebtn) {
       switch(label) {
      //main          
     case "main" :
                  loginbtn.setVisible(false);
                  logOutbtn.setVisible(true);
                  myPage_Btn.setVisible(true);
                  regMembtn.setVisible(false);
         
                  //메인패널
                  writebtn.setVisible(true);
//                  c_writebtn.setVisible(false);
                    break;
     //main          
     case "cheering" :
                  loginbtn.setVisible(false);
                  logOutbtn.setVisible(true);
                  myPage_Btn.setVisible(true);
                  regMembtn.setVisible(false);
         
                  //메인패널
                  writebtn.setVisible(false);
//                  c_writebtn.setVisible(true);
                    break;
         default :
                     loginbtn.setVisible(false);
                  logOutbtn.setVisible(true);
                  myPage_Btn.setVisible(true);
                  regMembtn.setVisible(false);

                  //메인패널
                  writebtn.setVisible(false);
//                  c_writebtn.setVisible(false);
                  break;
       }
   }

   //login 안했을때 버튼
   public void freeModeBtn( JButton loginbtn, JButton logOutbtn, JButton myPage_Btn,
         JButton regMembtn, JButton writebtn) {
      //header버튼
        loginbtn.setVisible(true);
        logOutbtn.setVisible(false);
        myPage_Btn.setVisible(false);
        regMembtn.setVisible(true);
        
        //메인패널
        writebtn.setVisible(false);
//        c_writebtn.setVisible(false);
   }

   //취소버튼 누르면 패널txt 초기화
   public void initiText(JTextField inputName,JTextField inputEmail,JTextField inputNic,
         JTextField inID, JPasswordField inPW2, JPasswordField inPW, JPasswordField inputPW,JTextField inputID) {
        inputName.setText("이름을 입력하세요.");
          inputEmail.setText("이메일을 입력하세요.");
         inputNic.setText("닉네임을 입력하세요.");
         inID.setText("ID를 입력하세요.");
         inPW2.setText("");
         inPW.setText("");
       
         inputPW.setText("");
        inputID.setText("ID를 입력하세요.");
   }
   
   //회원가입 입력창 초기화
   public void clickIniti(JTextField text) {
      text.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
               text.setText("");
            }
        });
   }
}