/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faris-Almokayad
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Date extends JFrame{
    JButton back,find_Dif;
    JLabel l , fDate, sDate;
    JComboBox fdays, fmonths, sdays, smonths;      
    JTextField year_1, year_2,result;
    //String days[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",""};
    String days[];
    String months[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
    int d=1;
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    Font b1Fonts = new Font(Font.SANS_SERIF,  Font.BOLD, 24);
    public Date(Home homepage){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(200,300);
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
        //Back bar
        back = new JButton ("Back");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#a5b0b3"));
        back.setForeground(Color.decode("#023020"));
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
                homepage.setVisible(true);
            }
        });
        p1.add(back);
        
        //Label bar
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        l = new JLabel("Date");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        pLabel.add(l);
        
        //First date label panel
        JPanel fD = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fD.setBackground(Color.decode("#36454F"));
        fDate = new JLabel("First date");
        fDate.setFont(b1Fonts);
        fDate.setForeground(Color.decode("#fafeff"));
        fD.add(fDate);
        
        //first days/months/year panel
        JPanel fLists = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fLists.setBackground(Color.decode("#36454F"));
        
        days = new String[30];
        for(int i =0;i<30;i++){
            days[i]=String.valueOf(d);
            d++;
        }
      
        fdays = new JComboBox(days);
        fdays.setBackground(Color.decode("#fafeff"));
        fdays.setForeground(Color.decode("#36454F"));
        fdays.setFont(bFonts);
        fdays.setFocusable(false);
        
        fmonths = new JComboBox(months);
        fmonths.setBackground(Color.decode("#fafeff"));
        fmonths.setForeground(Color.decode("#36454F"));
        fmonths.setFont(bFonts);
        fmonths.setFocusable(false);
       
        year_1 = new JTextField(5);
        year_1.setBackground(Color.decode("#fafeff"));
        year_1.setForeground(Color.decode("#36454F"));
        year_1.setFont(bFonts);
        
        
        fLists.add(fdays);
        fLists.add(fmonths);
        fLists.add(year_1);
        
        //First date components
        JPanel pfd = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pfd.setBackground(Color.decode("#36454F"));
        
        pfd.add(fD);
        pfd.add(fLists);
        
        //second date label bar
        JPanel sD = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sD.setBackground(Color.decode("#36454F"));
        sDate = new JLabel("Second date");
        sDate.setFont(b1Fonts);
        sDate.setForeground(Color.decode("#fafeff"));
        sD.add(sDate);
        
        //second days/months/year panel a5b0b3
        JPanel sLists = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sLists.setBackground(Color.decode("#36454F"));
        sdays = new JComboBox(days);
        sdays.setBackground(Color.decode("#fafeff"));
        sdays.setForeground(Color.decode("#36454F"));
        sdays.setFont(bFonts);
        sdays.setFocusable(false);
        
        smonths = new JComboBox(months);
        smonths.setBackground(Color.decode("#fafeff"));
        smonths.setForeground(Color.decode("#36454F"));
        smonths.setFont(bFonts);
        smonths.setFocusable(false);
        
        year_2 = new JTextField(5);
        year_2.setBackground(Color.decode("#fafeff"));
        year_2.setForeground(Color.decode("#36454F"));
        year_2.setFont(bFonts);
        
        sLists.add(sdays);
        sLists.add(smonths);
        sLists.add(year_2);
        //second date components
        JPanel psd = new JPanel(new FlowLayout(FlowLayout.LEFT));
        psd.setBackground(Color.decode("#36454F"));
        
        psd.add(sD);
        psd.add(sLists);
        
        //Find difference button
        JPanel fDif = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fDif.setBackground(Color.decode("#36454F"));
        find_Dif = new JButton("Find difference");
        find_Dif.setFont(b1Fonts);
        find_Dif.setBackground(Color.decode("#a5b0b3"));
        find_Dif.setForeground(Color.decode("#023020"));
        find_Dif.setFocusable(false);
        find_Dif.setBorderPainted(true);
        
        fDif.add(find_Dif);
        //main bar
        JPanel p = (JPanel)this.getContentPane();
        p.setLayout(new GridLayout(6,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(pfd);
        p.add(psd);
        p.add(fDif);
        
        this.setVisible(true);
    }
    
}
