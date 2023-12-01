/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */

import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;

/*
 */

/**
 *
 * @author hp
 */
public class Time extends JFrame{
     JComboBox list1, list2;
    JTextField text1, text2;
    JButton convert, clr, back,save;
    JLabel l;
    String measurments[]={"Minute","Houre","Second"};
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    
    public Time(Home homepage){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(500,600);
                this.setLocation(200,300);
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
        back = new JButton ("Back");
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
        
        
    JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
       p6.setBackground(Color.decode("#36454F"));
       save = new JButton("save");
       save.setFont(bFonts);
       save.setBackground(Color.decode("#36454F"));
       save.setForeground(Color.decode("#fafeff"));
       save.setFocusable(false);
       save.setBorderPainted(false);
       save.addActionListener(new Action());
       p6.add(save);
        
        p1.add(back);
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        l = new JLabel("Time");
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
        p.setLayout(new GridLayout(6,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(p2);
        p.add(p3);
        p.add(p5);
        p.add(p6);

        this.setVisible(true);//
        
        //action listeners call
        
    }
    private class Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource()==clr){
                text1.setText("");
                text2.setText("");
                
            }
                        if(e.getSource()==save){
                try{
                if(text1.getText().equals("") || text2.getText().equals(""))
                    throw new InputException("Missing inputs");
                    String s = text1.getText()+" "+String.valueOf(list1.getSelectedItem())+" = "+ text2.getText()+" "+String.valueOf(list2.getSelectedItem());
                    BufferedWriter his = new BufferedWriter(new FileWriter("History.txt",true));
                    his.write(s+"\n\n");
                    his.close();
                    JOptionPane.showMessageDialog(null, "Saving is done", "Save", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(IOException e1){
                JOptionPane.showMessageDialog(null, "I/O Error","Save failed",JOptionPane.ERROR_MESSAGE);
            }
            catch(InputException e2){
                JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
            }
            if(e.getSource()==convert){
                double num1,result=0;
                try{
                num1 = Double.parseDouble(text1.getText());
                String s1 = String.valueOf(list1.getSelectedItem());
                String s2 = String.valueOf(list2.getSelectedItem());
                   

                switch (s1) {
                    case "Minute":
                        switch (s2) {
                            case "Minute": result=num1;  break;
                            case "Houre": result=num1/60; break;
                            case "Second": result=num1*60;
                        }
                        break;

                    case "Houre":
                        switch (s2) {
                            case "Minute": result=num1*60;  break;
                            case "Houre":result=num1; break;
                            case "Second": result=num1*60*60; break;
                        }
                        break;

                    case "Second":
                        switch (s2) {
                            case "Minute":result=num1/60;  break;
                            case "Houre": result=num1/3600; break;
                            case "Second": result=num1;  break;
                        }
                        break;
                }
                
                text2.setText(result+"");

                
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
    }
    
    
}
