package SignUp;

import java.sql.Connection;

import javax.swing.JOptionPane;

import Database.ConnectionDB;
import Database.RegisterDB;
import Login.LoginCheck;

public class SignUpCheck {
   private Connection connection;
   private ConnectionDB DB_Connection;
   
   public SignUpCheck() {
         ConnectionDB DB_Connection = new ConnectionDB();
         connection = DB_Connection.getConnection();
         RegisterDB registerDB = new RegisterDB();
      }
   //회원가입 조회
   public boolean ChkRegister(String myName, String myID, String myPW, String myPW2,
         String myEmail, String myNic, String DBCol, String myRecord) {
      RegisterDB registerDB = new RegisterDB();
      LoginCheck LoginChk = new LoginCheck();
      registerDB.getRegisterSelect(DBCol, myRecord);
      boolean DBbool;
      
        if(myPW.equals(myPW2) && !myPW.equals("")){
        //중복조회할 목록
        String[] arrCol = {"ID", "email", "nicName"};
        String[] arrMY = {myID, myEmail, myNic};
        //DB 연결
        int i = 0;
        //중복조회 시작
       DBbool = registerDB.getRegisterSelect(arrCol[i], arrMY[i]); 
         System.out.println("DB ID : " + arrCol[i]+", "+arrMY[i]);
       //ID중복 조회
       if (DBbool) {  
          i = 1;
          DBbool = registerDB.getRegisterSelect(arrCol[i], arrMY[i]);
          System.out.println("DB email : " +", "+ arrCol[i]+arrMY[i]);
        //email 중복 조회
          if(DBbool) {
             i = 2;
             DBbool = registerDB.getRegisterSelect(arrCol[i], arrMY[i]);
              System.out.println("DB nic : " +", "+ arrCol[i]+arrMY[i]);
           //nic 중복 조회
             if(DBbool) {
                 //회원가입시도
                registerDB.getRegisterInsert(myName, myID, myPW, myEmail, myNic);
                LoginChk.Chk_Login(myID);
                  JOptionPane.showMessageDialog
                    (null, "아이디 : "+myID+ "\n이 름 : "+myName+"\n이메일 : "+myEmail+
                    "\n닉 네 임 : "+myNic, "회원가입 완료", JOptionPane.INFORMATION_MESSAGE); 
                 return true;
          } else JOptionPane.showMessageDialog(null, "닉네임 중복!!","회원가입 실패", JOptionPane.ERROR_MESSAGE);
          } else JOptionPane.showMessageDialog(null, "email 중복!!","회원가입 실패", JOptionPane.ERROR_MESSAGE);
       } else JOptionPane.showMessageDialog(null, "ID 중복!!","회원가입 실패", JOptionPane.ERROR_MESSAGE);
        }
     //회원가입 실패 : PW가 비어져 있거나 PW!=PW2이면
        else if (myPW.equals("")) {
           JOptionPane.showMessageDialog
            (null, "비밀번호를 입력하세요.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
        }
        else { //비밀번호 틀림
              JOptionPane.showMessageDialog
               (null, "비밀번호가 틀립니다.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
           }
        return false;
   }
}