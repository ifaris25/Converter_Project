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
public class Length extends JFrame{
    
    JComboBox list1, list2;
    JTextField text1, text2;
    JButton convert, clr, back;
    JLabel l;
    String measurments[]={"km","m","cm","mm"};
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    
    public Length(Home homepage){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 this.setSize(500,600);
                 this.setLocation(200,300);
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
        back = new JButton ("back");
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
        l = new JLabel("Length");
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
       
       clr = new JButton("clr");
       clr.setFont(bFonts);
       clr.setBackground(Color.decode("#36454F"));
       clr.setForeground(Color.decode("#fafeff"));
       clr.setFocusable(false);
       clr.setBorderPainted(false);
       
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
                 //converting from kilometer to other units
                 if (s1.equals("km")){
                     switch(s2){
                         case "km":
                             result = num1;
                             text2.setText(result+"");
                             break;
                         case "m":
                             result = num1*1000;
                             text2.setText(result+"");
                             break;
                         case "cm":
                             result = num1*100000;
                             text2.setText(result+"");
                             break;
                         case "mm":
                               result = num1 * 1000000 ;
                               text2.setText(result+"");
                               break;
                     }
                 }
                 //converting from meter to other units
                 if(s1.equals("m")){
                     switch (s2){
                         case "km":
                             result = num1/1000;
                             text2.setText(result+"");
                             break;
                         case "m":
                             result = num1;
                             text2.setText(result+"");
                             break;
                         case "cm":
                             result = num1 * 100;
                             text2.setText(result+"");
                             break;
                         case "mm":
                             result = num1 * 1000;
                             text2.setText(result+"");
                             break;
                             
                     }
                 }
                 //converting from centimeter to other units
                 if(s1.equals("cm")){
                     switch(s2){
                         case "km":
                             result = num1 / 100000;
                             text2.setText(result+"");
                             break;
                         case "m":
                             result = num1 / 100;
                             text2.setText(result+"");
                             break;
                         case "cm":
                             result = num1;
                             text2.setText(result+"");
                             break;
                         case "mm":
                             result = num1 * 10;
                             text2.setText(result+"");
                             break;
                     }
                 }
                 //converting from millimeter to other units
                 if(s1.equals("mm")){
                     switch(s2){
                         case "km":
                             result = num1 / 1000000 ;
                             text2.setText(result+"");
                             break;
                         case "m":
                             result = num1 / 1000;
                             text2.setText(result+"");
                             break;
                         case "cm":
                             result = num1/10;
                             text2.setText(result+"");
                             break;
                         case "mm":
                             result = num1;
                             text2.setText(result+"");
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
