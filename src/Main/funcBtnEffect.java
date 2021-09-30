package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class funcBtnEffect {
   public funcBtnEffect() {
      
   }
   public void homeMouseEffect(JButton btn) {
      btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
               btn.setBackground(new Color(255, 240, 240));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
               btn.setBackground(new Color(217, 217, 217));
            }
         });
   }
   public void btnMouseEffect(JButton btn) {
      btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
               btn.setBackground(Color.black);
               btn.setForeground(Color.white);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
               btn.setBackground(new Color(217, 217, 217));
               btn.setForeground(Color.black);
            }
        });
   }
   public void menubtnEffect(JButton btn, int x, int y,int w,int l) {
      btn.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(255, 240, 240));
                //player_Btn.setBorderPainted(true);
             }
             public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(231, 230, 230));
             }
          });
      btn.setFont(new Font("°íµñ", Font.BOLD, 20));
      btn.setBackground(new Color(231, 230, 230));
      btn.setBounds(x, y, w, l);
      btn.setBorderPainted(false);
      btn.setFocusPainted(false);
   }
}