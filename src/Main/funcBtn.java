package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class funcBtn {
   public funcBtn() {
      
   }
   public void funcbtn(JButton btn, int x, int y,int w,int l, boolean i) {
      btn.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
      btn.setBackground(new Color(217, 217, 217));
      btn.setBounds(x, y, w, l);
      btn.setBorderPainted(false);
      btn.setFocusPainted(false);
      btn.setVisible(i);
   }
   
   public void colorbtn(JButton btn, int x, int y, int w, int l, int r, int g, int b) {
	   btn.setBounds(x, y, w, l);
	   btn.setBackground(new Color(r,g,b));
	   btn.setFocusPainted(false);
	   btn.setBorderPainted(false);
	   btn.setVisible(false);
   }
   
   public void funcTextField (JTextField inputText, int x, int y,int w,int l) {
      inputText.setBounds(x, y, w, l);
      inputText.setFont(new Font("°íµñ", Font.BOLD, 20)); // Font
      inputText.setForeground(Color.black); // Color
      inputText.setBackground(new Color(255,255,255));
      inputText.requestFocusInWindow();
      inputText.setColumns(10);
   }
   public void funcTextArea (JTextArea inputText, int x, int y,int w,int l) {
      inputText.setBounds(x, y, w, l);
      inputText.setFont(new Font("°íµñ", Font.BOLD, 20)); // Font
      inputText.setForeground(Color.black); // Color
      inputText.setOpaque(true);
      inputText.setLineWrap(true);
      inputText.setEditable(true);
   }
   public void funcPW (JPasswordField inputText, int x, int y,int w,int l) {
      inputText.setBounds(x, y, w, l);
      inputText.setFont(new Font("°íµñ", Font.BOLD, 20)); // Font
      inputText.setForeground(Color.black); // 9Color
      inputText.setBackground(new Color(255,255,255));
   }
   
   public void funcTiTleLabel(JLabel label, int x, int y,int w,int l,int r, int g, int b ) {
      label.setBounds(x, y, w, l);
      label.setFont(new Font("Arial", Font.BOLD, 35)); // Font
      label.setForeground(Color.white); // Color
      label.setBackground(new Color(r, g, b));
      label.setOpaque(true);
      label.setHorizontalAlignment(JLabel.CENTER); // Position
      }
   
   public void funcFooterLabel(JLabel label, int x, int y,int w,int l,int r, int g, int b ) {
      label.setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 13));
      label.setForeground(Color.black);
      label.setBackground(new Color(r, g, b));
      label.setOpaque(true);
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setBounds(x, y, w, l);
      }
   
   public void funcMainLabel(JLabel label, int x, int y,int w,int l,int r, int g, int b ) {
         label.setBounds(x, y, w, l);
         label.setFont(new Font("°íµñ", Font.BOLD, 30)); // Font
         label.setForeground(Color.white); // Color
         label.setBackground(new Color(r, g, b));
         label.setOpaque(true);
         label.setHorizontalAlignment(JLabel.CENTER);
      }

   public void funcLabel(JLabel label, int x, int y,int w,int l,int r, int g, int b ) {
         label.setBounds(x, y, w, l);
         label.setFont(new Font("°íµñ", Font.BOLD, 18)); // Font
         label.setForeground(Color.black); // Color
         label.setBackground(new Color(r, g, b));
         label.setOpaque(true);
         label.setHorizontalAlignment(JLabel.CENTER);
      }

}