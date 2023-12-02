/**
 *
 * @author MUSTAFA
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Temperature extends JFrame {
    
    JComboBox list1, list2;
    JTextField text1, text2;
    JButton convert, clr, back, save;
    JLabel l;
    String measurments[]={"Celsius | °C","Fehrenheit | °F","Kelvin | K"};
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    
    public Temperature(Home homepage){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(200,300);
        this.setTitle("Temperatura");
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
        back = new JButton ("Back");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#B6BBC4"));
        back.setForeground(Color.decode("#31304D"));
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
        l = new JLabel("Temperature");
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
        convert = new JButton("Convert");
        convert.setFont(bFonts);
        convert.setBackground(Color.decode("#B6BBC4"));
        convert.setForeground(Color.decode("#31304D"));
        convert.setFocusable(false);
        convert.setBorderPainted(false);
       
        clr = new JButton("Clear");
        clr.setFont(bFonts);
        clr.setBackground(Color.decode("#B6BBC4"));
        clr.setForeground(Color.decode("#31304D"));
        clr.setFocusable(false);
        clr.setBorderPainted(false);
       
        p5.add(convert);
        p5.add(clr);
        
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
       p6.setBackground(Color.decode("#36454F"));
       save = new JButton("Save");
       save.setFont(bFonts);
       save.setBackground(Color.decode("#B6BBC4"));
       save.setForeground(Color.decode("#31304D"));
       save.setFocusable(false);
       save.setBorderPainted(false);
       p6.add(save);
       
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
        clr.addActionListener(new ClearText());
        convert.addActionListener(new Calculate());
    }
    private class ClearText implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource()==clr){
                text1.setText("");
                text2.setText("");
                
            }
        }
    }
    private class Calculate implements ActionListener{
        public void actionPerformed (ActionEvent e){
            double num1,result;
            num1 = Double.parseDouble(text1.getText());
            String s1 = String.valueOf(list1.getSelectedItem());
            String s2 = String.valueOf(list2.getSelectedItem());
            try{
            if(e.getSource()==convert){
                //converting from Celsius °C to other units
                if (s1.equals("Celsius | °C")){
                    switch(s2){
                        case "Celsius | °C":
                            result = num1;
                            text2.setText(String.format("%.4f", result));
                            break;
                        case "Fehrenheit | °F":
                            result = (num1*9/5) +32;
                            text2.setText(String.format("%.4f", result));
                            break;
                        case "Kelvin | K":
                            result = num1+273.15;
                            text2.setText(String.format("%.4f", result));
                            break;
                    }
                }
                //converting from Fehrenheit °F to other units
                if(s1.equals("Fehrenheit | °F")){
                    switch (s2){
                        case "Celsius | °C":
                            result = (num1-32)*5/9;
                            text2.setText(String.format("%.4f", result));
                            break;
                        case "Fehrenheit | °F":
                            result = num1;
                            text2.setText(String.format("%.4f", result));
                            break; 
                        case "Kelvin | K":
                            result = ((num1-32)*5/9)+273.15;
                            text2.setText(String.format("%.4f", result));
                            break; 
                    }
                }
                //converting from Kelvin K to other units
                if(s1.equals("Kelvin | K")){
                    switch(s2){
                        case "Celsius | °C":

                            result = num1 - 273.15;
                            text2.setText(String.format("%.4f", result));
                            break;
                        case "Fehrenheit | °F":
                            result = ((num1-273.15)*9/5)+32;
                            text2.setText(String.format("%.4f", result));
                            break;
                        case "Kelvin | K":
                            result = num1;
                            text2.setText(String.format("%.4f", result));
                            break;
                    }
                }
                //end of converting
            }
            }
            catch(NumberFormatException ee){
                JOptionPane.showMessageDialog(null, "Enter a number ya bro!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
