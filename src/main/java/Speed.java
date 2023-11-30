
import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class Speed extends JFrame{
     JComboBox list1, list2;
    JTextField text1, text2;
    JButton convert, clr, back;
    JLabel l;
    String measurments[]={"meter/second","kilometer/hour","mile/hour","meter/hour", "meter/minute"};
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    
    public Speed(Home homepage){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(500,600);
                this.setLocation(200,300);
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
        back = new JButton ("BACK");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#36454F"));
        back.setForeground(Color.decode("#fafeff"));
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
                homepage.setVisible(true);
            }
        });
        
        p1.add(back);
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        l = new JLabel("Speed");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        
        pLabel.add(l);
        
        //First bar
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.setBackground(Color.decode("#36454F"));
        list1 = new JComboBox(measurments);
        list1.setBackground(Color.decode("#fafeff"));
        list1.setForeground(Color.decode("#36454F"));
        list1.setFont(bFonts);
        list1.setFocusable(false);
        
        text1 = new JTextField(10);
        text1.setBackground(Color.decode("#fafeff"));
        text1.setForeground(Color.decode("#36454F"));
        text1.setFont(bFonts);
        p2.add(list1);
        p2.add(text1);
        
        
        //second bar
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3.setBackground(Color.decode("#36454F"));
        list2 = new JComboBox(measurments);
        list2.setBackground(Color.decode("#fafeff"));
        list2.setForeground(Color.decode("#36454F"));
        list2.setFont(bFonts);
        list2.setFocusable(false);
        
        text2 = new JTextField(10);
        text2.setEditable(false);
        text2.setBackground(Color.decode("#fafeff"));
        text2.setForeground(Color.decode("#36454F"));
        text2.setFont(bFonts);
        p3.add(list2);
        p3.add(text2);
        
       
        //functions bar
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5.setBackground(Color.decode("#36454F"));
        convert = new JButton("convert");
        convert.setFont(bFonts);
        convert.setBackground(Color.decode("#36454F"));
        convert.setForeground(Color.decode("#fafeff"));
        convert.setFocusable(false);
        convert.setBorderPainted(false);
        convert.addActionListener(new Action());
       
        clr = new JButton("clr");
        clr.setFont(bFonts);
        clr.setBackground(Color.decode("#36454F"));
        clr.setForeground(Color.decode("#fafeff"));
        clr.setFocusable(false);
        clr.setBorderPainted(false);
        clr.addActionListener(new Action());
       
        p5.add(convert);
        p5.add(clr);
        //main bar
        JPanel p = (JPanel)this.getContentPane();
        p.setLayout(new GridLayout(5,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(p2);
        p.add(p3);
        p.add(p5);
        this.setVisible(true);//
        
        //action listeners call
        
    }
    private class Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource()==clr){
                text1.setText("");
                text2.setText("");
                
            }
            if(e.getSource()==convert){
//            String measurments[]={"meter/second","kilometer/hour","mile/hour","meter/hour", "meter/minute"};
                double num1,result=0;
                num1 = Double.parseDouble(text1.getText());
                String s1 = String.valueOf(list1.getSelectedItem());
                String s2 = String.valueOf(list2.getSelectedItem());
                
               switch (s1) {
                    case "meter/second":
                        switch (s2) {
                            case "meter/second": result = num1; break;
                            case "kilometer/hour": result = num1 * 3.6; break;
                            case "mile/hour": result = num1 / 1.60934; break;
                            case "meter/hour": result = num1 * 3600; break;
                            case "meter/minute": result = num1 * 60; break;
                        }
                        break;

                    case "kilometer/hour":
                        switch (s2) {
                            case "meter/second": result = num1 / 3.6; break;
                            case "kilometer/hour": result = num1; break;
                            case "mile/hour": result = num1 / 1.60934; break;
                            case "meter/hour": result = num1 * 1000; break;
                            case "meter/minute": result = num1 * 16.6667; break;
                        }
                        break;

                    case "mile/hour":
                        switch (s2) {
                            case "meter/second": result = num1 * 1.60934 / 3.6; break;
                            case "kilometer/hour": result = num1 * 1.60934; break;
                            case "mile/hour": result = num1; break;
                            case "meter/hour": result = num1 * 1609.34; break;
                            case "meter/minute": result = num1 * 26.8224; break;
                        }
                        break;

                    case "meter/hour":
                        switch (s2) {
                            case "meter/second": result = num1 / 3600; break;
                            case "kilometer/hour": result = num1 / 1000; break;
                            case "mile/hour": result = num1 / 1609.34; break;
                            case "meter/hour": result = num1; break;
                            case "meter/minute": result = num1 / 60; break;
                        }
                        break;

                    case "meter/minute":
                        switch (s2) {
                            case "meter/second": result = num1 / 60; break;
                            case "kilometer/hour": result = num1 / 16.6667; break;
                            case "mile/hour": result = num1 / 26.8224; break;
                            case "meter/hour": result = num1 * 60; break;
                            case "meter/minute": result = num1; break;
                        }
                        break;
                }

                text2.setText(result+"");

                
            }
            
        }
    }
  
}
