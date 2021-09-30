/*
package Board;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalendarPanel extends JPanel {
	private JPanel calPanel;
	CalendarPanel() {
		InitCal(LocalDate.now().getMonth(), LocalDate.now().getYear());
		this.setVisible(true);
	}
	private void InitCal(Month month, int year) {
		LocalDate date = LocalDate.of(year, ConvertMonthToInt(month), 1);
		DayOfWeek dayOfWeek;
		int dayOfMonth;
		GridBagConstraints c = new GridBagConstraints();
        calPanel = new JPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        JButton previous = new JButton("<");
        previous.setBorderPainted(false);
        previous.setFocusPainted(false);
        previous.setBackground(Color.WHITE);
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                LocalDate prevDate = date.minusMonths(1);
                InitCal(prevDate.getMonth(), prevDate.getYear());
            }
        });
        calPanel.add(previous, c);
        c.gridx++;
        c.gridwidth = 3;
        calPanel.add(new JButton(month.toString()), c);
        c.gridwidth = 2;
        c.gridx += 3;
        calPanel.add(new JButton(Integer.toString(year)), c);
        c.gridwidth = 1;
        c.gridx += 2;
        calPanel.add(new JButton(">"), c);
        c.gridx = 0;
        c.gridy++;
        JLabel sunday = new JLabel("Sun");
        sunday.setHorizontalAlignment(JLabel.CENTER);
        calPanel.add(sunday, c);
        c.gridx++;
        JLabel monday = new JLabel("Mon");
        monday.setHorizontalAlignment(JLabel.CENTER);
        calPanel.add(monday, c);
        c.gridx++;
        JLabel tuesday = new JLabel("Tue");
        tuesday.setHorizontalAlignment(JLabel.CENTER);
        calPanel.add(tuesday, c);
        c.gridx++;
        JLabel wednesday = new JLabel("Wed");
        wednesday.setHorizontalAlignment(JLabel.CENTER);
        calPanel.add(wednesday, c);
        c.gridx++;
        JLabel thursday = new JLabel("Thu");
        thursday.setHorizontalAlignment(JLabel.CENTER);
        calPanel.add(thursday, c);
        c.gridx++;
        JLabel friday = new JLabel("Fri");
        friday.setHorizontalAlignment(JLabel.CENTER);
        calPanel.add(friday, c);
        c.gridx++;
        JLabel saturday = new JLabel("Sat");
        saturday.setHorizontalAlignment(JLabel.CENTER);
        calPanel.add(saturday, c);
        c.gridx = 0;
        c.gridy++;
        int fillBeginning = ConvertDayOfWeekToInt(date.getDayOfWeek());
        int count = fillBeginning;
        if (fillBeginning > 0) {
            LocalDate prev = date.minusMonths(1);
            int prevDays = GetDaysInMonth(ConvertMonthToInt(prev.getMonth()), prev.getYear());
            prevDays -= (fillBeginning - 1);
            while (fillBeginning > 0) {
                JButton b = new JButton(Integer.toString(prevDays));
                b.setBorderPainted(false);
                b.setFocusPainted(false);
                b.setBackground(new Color(100,150,200));
                calPanel.add(b, c);
                c.gridx++;
                fillBeginning--;
                prevDays++;
            }
        }
        int day = 1;
        int daysInMonth = GetDaysInMonth(ConvertMonthToInt(month), year);
        while(day <= daysInMonth) {
            if (count >= 7) {
                c.gridy++;
                c.gridx = 0;
                count = 0;
            }
            JButton b = new JButton(Integer.toString(day));
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setBackground(Color.WHITE);
            calPanel.add(b, c);
            count++;
            day++;
            c.gridx++;
        }
        int nextDays = 1;
        while (7 - count > 0) {
            JButton b = new JButton(Integer.toString(nextDays));
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setBackground(new Color(100,150,200));
            calPanel.add(b, c);
            c.gridx++;
            count++;
            nextDays++;
        }
        this.add(calPanel);
    }
    private int ConvertMonthToInt(Month m) {
        switch(m.toString()) {
        case "JANUARY" : return 1;
        case "FEBRUARY" : return 2;
        case "MARCH" : return 3;
        case "APRIL" : return 4;
        case "MAY" : return 5;
        case "JUNE" : return 6;
        case "JULY" : return 7;
        case "AUGUST" : return 8;
        case "SEPTEMBER" : return 9;
        case "OCTOBER" : return 10;
        case "NOVEMBER" : return 11;
        case "DECEMBER" : return 12;
        default: return 0;
        }
    }
    private int ConvertDayOfWeekToInt(DayOfWeek dow) {
        switch(dow.toString()) {
        case "SUNDAY" : return 0;
        case "MONDAY" : return 1;
        case "TUESDAY" : return 2;
        case "WEDNESDAY" : return 3;
        case "THURSDAY" : return 4;
        case "FRIDAY" : return 5;
        case "SATURDAY" : return 6;
        default : return 0;
        }
    }
    private int GetDaysInMonth(int m, int y) {
        switch(m) {
        case 4 : case 6 : case 9 : case 11 : return 30;
        case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : return 31;
        case 2 :
            if (IsLeapYear(y)) {
                return 29;
            } else {
                return 28;
            }
        default : return 0;
        }
    }
    private boolean IsLeapYear(int y) {
        if (y % 4 == 0) {
            return true;
        } else if (y % 100 == 0) {
            return false;
        }
        return false;
    }
    
	private JFrame frame;
	protected AbstractButton content;

	public CalendarPanel(JFrame frame) {
		super();
		panelInit(frame);
		
	}

	private void panelInit(JFrame frame) {
			    
			    // 일정 선택 글자
			    JLabel writetitle = new JLabel("일정 선택");
			    writetitle.setBounds(130, 30, 800, 35);
			    writetitle.setFont(new Font("고딕", Font.BOLD, 30)); // Font
			    writetitle.setForeground(Color.white); // Color
			    writetitle.setBackground(new Color(24, 23, 23));
			    writetitle.setOpaque(true);
			    writetitle.setHorizontalAlignment(JLabel.CENTER);
			    this.add(writetitle);
			    
			    
			    
			 // 선택버튼
				JButton DateSelBtn = new JButton("선택");
				DateSelBtn.setBounds(870, 500, 80, 40);
				DateSelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16)); // Font
				DateSelBtn.setBackground(new Color(230,230,230));
				DateSelBtn.setForeground(Color.black);
				DateSelBtn.setBorderPainted(false);
				DateSelBtn.setFocusPainted(false);
				DateSelBtn.setBorderPainted(true);
				
				this.add(DateSelBtn);
						
				DateSelBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String DateSel;

						DateSel = (String) content.getText();
						
						System.out.println(DateSel);
						
					}
				});
			    
			  //취소 버튼
			    JButton CalQuitBtn = new JButton("취소");
			    CalQuitBtn.setFont(new Font("고딕", Font.BOLD, 14));
			    CalQuitBtn.setBackground(new Color(217, 217, 217));
			    CalQuitBtn.setBounds(870, 550, 80, 40);
			    CalQuitBtn.setBorderPainted(false);
			    CalQuitBtn.setFocusPainted(false);
			    this.add(CalQuitBtn);
			    
	}
	


}
*/