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
public class Help extends JFrame{
    String msg = "This Java application provides a versatile unit converter\nthat allows users to convert various units\nacross different categories including length, mass, speed,\ndiscount, data, date, temperature, time, and more.";
    String msg2 = "1- Select Category: Choose the category for conversion (e.g., length, mass, speed).\n"
    + "2- Choose Units: Select the units you want to convert from and to.\n"
    + "3- Input Value: Enter the value you want to convert.\n"
    + "4- Get Conversion: Click the \"Convert\" button to get the converted value.\n"
    + "5-  View Result: The converted value will be displayed on the interface.\n";
    JButton back;
    JLabel l,usage;
    JTextArea text, text2;
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    Font tFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 14);
    Font lFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 23);
    public Help (Home homepage, String s){
        super(s);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(200,300);
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
        back = new JButton ("Back");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#B6BBC4"));
        back.setForeground(Color.decode("#023020"));
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
        l = new JLabel("Help");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        
        pLabel.add(l);
        
        JPanel tPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tPanel.setBackground(Color.decode("#36454F"));
        text = new JTextArea(msg);
        text.setBackground(Color.decode("#36454F"));
        text.setFont(tFonts);
        text.setForeground(Color.decode("#fafeff"));
        text.setEditable(false);
        tPanel.add(text);
        
        JPanel uPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        uPanel.setBackground(Color.decode("#36454F"));
        usage = new JLabel("Usage");
        usage.setFont(lFonts);
        usage.setForeground(Color.decode("#fafeff"));
        uPanel.add(usage);
        
        JPanel t2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        t2.setBackground(Color.decode("#36454F"));
        
        text2 = new JTextArea(msg2);
        text2.setBackground(Color.decode("#36454F"));
        text2.setFont(tFonts);
        text2.setForeground(Color.decode("#fafeff"));
        text2.setEditable(false);
        
        t2.add(text2);
        JPanel p = (JPanel)this.getContentPane();
        p.setLayout(new GridLayout(6,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(tPanel);
        p.add(uPanel);
        p.add(t2);
        
        this.setVisible(true);
    }
}



    
    
    
    
   
