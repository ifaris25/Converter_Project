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

public class Home extends JFrame {
    JButton length, speed, discount, mass, data, date, temp, time, numSys, history, help;
    JLabel conv;
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 28);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    
     public Home(String s){
         super(s);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(500,600);
         this.setLocation(200,300);
         
         //App name
         JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
         p1.setBackground(Color.decode("#36454F"));
         conv = new JLabel("Converter app");
         conv.setFont(labelFont);
         conv.setForeground(Color.decode("#fafeff"));
         p1.add(conv);
        
         //App buttons
         JPanel p2 = new JPanel(new GridLayout(3,3));
         length = new JButton("Length");
         length.setBackground(Color.decode("#a5b0b3"));
         length.setForeground(Color.decode("#36454F"));
         length.setFont(bFonts);
         length.setFocusable(false);
         
         speed = new JButton("Speed");
         speed.setBackground(Color.decode("#a5b0b3"));
         speed.setForeground(Color.decode("#36454F"));
         speed.setFont(bFonts);
         speed.setFocusable(false);
         
         discount = new JButton("Discount");
         discount.setBackground(Color.decode("#a5b0b3"));
         discount.setForeground(Color.decode("#36454F"));
         discount.setFont(bFonts);
         discount.setFocusable(false);
         
         mass = new JButton("Mass");
         mass.setBackground(Color.decode("#a5b0b3"));
         mass.setForeground(Color.decode("#36454F"));
         mass.setFont(bFonts);
         mass.setFocusable(false);
         
         data = new JButton("Data");
         data.setBackground(Color.decode("#a5b0b3"));
         data.setForeground(Color.decode("#36454F"));
         data.setFont(bFonts);
         data.setFocusable(false);
         
         time = new JButton("Time");
         time.setBackground(Color.decode("#a5b0b3"));
         time.setForeground(Color.decode("#36454F"));
         time.setFont(bFonts);
         time.setFocusable(false);
         
         date = new JButton("Date");
         date.setBackground(Color.decode("#a5b0b3"));
         date.setForeground(Color.decode("#36454F"));
         date.setFont(bFonts);
         date.setFocusable(false);
         
        
         temp = new JButton("Temperature");
         temp.setBackground(Color.decode("#a5b0b3"));
         temp.setForeground(Color.decode("#36454F"));
         temp.setFont(bFonts);
         temp.setFocusable(false);
         
         
         numSys = new JButton("Numerical system");
         numSys.setBackground(Color.decode("#a5b0b3"));
         numSys.setForeground(Color.decode("#36454F"));
         numSys.setFont(bFonts);
         numSys.setFocusable(false);
         
         
         
         p2.add(length);
         p2.add(speed);
         p2.add(discount);
         p2.add(mass);
         p2.add(data);
         p2.add(date);
         p2.add(temp);
         p2.add(time);
         p2.add(numSys);
         
        // last panel contains help and history
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3.setBackground(Color.decode("#36454F"));
        
        help = new JButton ("help");
        help.setFocusable(false);
        help.setFont(bFonts);
        help.setBackground(Color.decode("#36454F"));
        help.setForeground(Color.decode("#fafeff"));
        help.setBorderPainted(false);
        
        history = new JButton("history");
        history.setFocusable(false);
        history.setFont(bFonts);
        history.setBackground(Color.decode("#36454F"));
        history.setForeground(Color.decode("#fafeff"));
        history.setBorderPainted(false);
        
        p3.add(help);
        p3.add(history);
        // Main pane that contain every Panel
        JPanel mainPanel = (JPanel)this.getContentPane();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.decode("#36454F"));
        
        mainPanel.add((p1),BorderLayout.NORTH);
        mainPanel.add((p2),BorderLayout.CENTER);
        mainPanel.add((p3),BorderLayout.SOUTH);
        //this.pack();
        this.setVisible(true);
        length.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
                Length l = new Length(); 

            }
        });
     }
    public static void main(String[] args){
        Home f1 = new Home("Home");//
     }
}

