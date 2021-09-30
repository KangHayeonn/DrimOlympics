package Cheering;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Database.cheermsgDB;

public class CheerPanel extends JPanel {

	private cheermsgFrame cheermsgFrame;
	
	public CheerPanel(JFrame frame) {
		super();
		//cheermsgPanel과 연결하기
		panelInit(frame);
	}	
	private void panelInit(JFrame frame) {
		
	
       //   ArrayList<JLabel> labelList;
        //  ArrayList<String> stringArray;
          //labelList = new <JLabel>ArrayList();
         // int count = 0;
//
//          JLabel /label = new JLabel ("postIT" + count);
//          //System.out.print(label); 
//          stringArray = new ArrayList();
//          for (int i = 0; i < labelList.size(); i++) {
//                          stringArray.add(labelList.get(i).getText());
//                          //System.out.print("cheerpanel labeling : "+ stringArray.add(labelList.get(i).getText()));      
//          }
//          
		  //this.setBackground(new Color(20, 255, 255));
	      this.setBounds(0, 0, 1280, 960);
	      this.setLayout(null);
	      cheermsgDB cheermsgDB = new cheermsgDB();
	      //String[] color = null;
	      //String color2 = cheermsgDB.getColor(2);
	      int page = 320;
//	      //cheermsgDB.callCountcheermsg()+1
//	      String[] inputText = new String[6];
//	      for (int i =0; i<7; i++) {
//	    	  //String labelName = "Post"+Integer.toString(i);
//	    	  inputText[i] = cheermsgDB.getText(i+1);
////	    	  color[i] = cheermsgDB.getColor(i);
//	      }
//		int[] xBound = new int[7];
//		for (int i =0; i<7; i++) {
//			xBound[i+1] = 30+(page*(i+1));
//			if((i+1)%3 == 2) {
//				i = 0;
//				}
//			}
 
	      JLabel postIT1 = new JLabel(cheermsgDB.getText(1), JLabel.CENTER);
	      JLabel postIT2 = new JLabel(cheermsgDB.getText(2), JLabel.CENTER);
	      JLabel postIT3 = new JLabel(cheermsgDB.getText(3), JLabel.CENTER);
	      JLabel postIT4 = new JLabel(cheermsgDB.getText(4), JLabel.CENTER);
	      JLabel postIT5 = new JLabel(cheermsgDB.getText(5), JLabel.CENTER);
	      JLabel postIT6 = new JLabel(cheermsgDB.getText(6), JLabel.CENTER);
	      
	      lableFunction(postIT1);
	      lableFunction(postIT2);
	      lableFunction(postIT3);
	      lableFunction(postIT4);
	      lableFunction(postIT5);
	      lableFunction(postIT6);
	      
	      postIT1.setBounds(30+(page*0), 30+(page*0), 300, 300);
	      postIT2.setBounds(30+(page*1), 30+(page*0), 300, 300); //랜덤값으로 변경하기 - 추가필요
	      postIT3.setBounds(30+(page*2), 30+(page*0), 300, 300); //랜덤값으로 변경하기 - 추가필요
	      postIT4.setBounds(30+(page*0), 30+(page*1), 300, 300);
	      postIT5.setBounds(30+(page*1), 30+(page*1), 300, 300);
	      postIT6.setBounds(30+(page*2), 30+(page*1), 300, 300);
	      
	      cheermsgDB.callCheerMsgColor(postIT1,1);
	      cheermsgDB.callCheerMsgColor(postIT2,2);
	      cheermsgDB.callCheerMsgColor(postIT3,3);
	      cheermsgDB.callCheerMsgColor(postIT4,4);
	      cheermsgDB.callCheerMsgColor(postIT5,5);
	      cheermsgDB.callCheerMsgColor(postIT6,6);
	      
	      this.add(postIT1);
	      this.add(postIT2);
	      this.add(postIT3);
	      this.add(postIT4);
	      this.add(postIT5);
	      this.add(postIT6);
	      
	        
	}
	
	public void lableFunction(JLabel postIT1) {
			postIT1.setFont(new Font("고딕", Font.BOLD, 30)); // Font
			postIT1.setOpaque(true);
    }
}
