/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faris-AlMuqayyad
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Length extends JFrame{
    
    JComboBox list1, list2;
    JTextField text1, text2;
    JButton convert, clr, back ,save;
    JLabel l;
    String measurments[]={"Kilometers | km","Meters | m","Centimeters | cm","Millimeter | mm"};
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    
    public Length(Home homepage){
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
       
       //save bar
       JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
       p6.setBackground(Color.decode("#36454F"));
       save = new JButton("save");
       save.setFont(bFonts);
       save.setBackground(Color.decode("#36454F"));
       save.setForeground(Color.decode("#fafeff"));
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
        save.addActionListener(new SaveButton());
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
             try{                                                           
             if(e.getSource()==convert){
                 num1 = Double.parseDouble(text1.getText());
                String s1 = String.valueOf(list1.getSelectedItem());
                String s2 = String.valueOf(list2.getSelectedItem());
                 //converting from kilometer to other units
                 if (s1.equals("Kilometers | km")){
                     switch(s2){
                         case "Kilometers | km":
                             result = num1;
                             text2.setText(result+"");
                             break;
                         case "Meters | m":
                             result = num1*1000;
                             text2.setText(result+"");
                             break;
                         case "Centimeters | cm":
                             result = num1*100000;
                             text2.setText(result+"");
                             break;
                         case "Millimeter | mm":
                               result = num1 * 1000000 ;
                               text2.setText(result+"");
                               break;
                     }
                 }
                 //converting from meter to other units
                 if(s1.equals("Meters | m")){
                     switch (s2){
                         case "Kilometers | km":
                             result = num1/1000;
                             text2.setText(result+"");
                             break;
                         case "Meters | m":
                             result = num1;
                             text2.setText(result+"");
                             break;
                         case "Centimeters | cm":
                             result = num1 * 100;
                             text2.setText(result+"");
                             break;
                         case "Millimeter | mm":
                             result = num1 * 1000;
                             text2.setText(result+"");
                             break;
                             
                     }
                 }
                 //converting from centimeter to other units
                 if(s1.equals("Centimeters | cm")){
                     switch(s2){
                         case "Kilometers | km":
                             result = num1 / 100000;
                             text2.setText(result+"");
                             break;
                         case "Meters | m":
                             result = num1 / 100;
                             text2.setText(result+"");
                             break;
                         case "Centimeters | cm":
                             result = num1;
                             text2.setText(result+"");
                             break;
                         case "Millimeter | mm":
                             result = num1 * 10;
                             text2.setText(result+"");
                             break;
                     }
                 }
                 //converting from millimeter to other units
                 if(s1.equals("Millimeter | mm")){
                     switch(s2){
                         case "Kilometers | km":
                             result = num1 / 1000000 ;
                             text2.setText(result+"");
                             break;
                         case "Meters | m":
                             result = num1 / 1000;
                             text2.setText(result+"");
                             break;
                         case "Centimeters | cm":
                             result = num1/10;
                             text2.setText(result+"");
                             break;
                         case "Millimeter | mm":
                             result = num1;
                             text2.setText(result+"");
                             break;
                     }
                 }
                 //end of converting
             }
            }
             catch(NumberFormatException ee){
                 JOptionPane.showMessageDialog(null, "Enter a number!","Error",JOptionPane.ERROR_MESSAGE);
             }
         }
    }
    private class SaveButton implements ActionListener{
        public void actionPerformed (ActionEvent e){
            try{
                if(text1.getText().equals("")&&text2.getText().equals(""))
                    throw new InputException("Missing inputs");
                String s = text1.getText()+" "+String.valueOf(list1.getSelectedItem())+" = "+ text2.getText()+" "+String.valueOf(list2.getSelectedItem());
                BufferedWriter his = new BufferedWriter(new FileWriter("History.txt",true));
                his.write(s+"\n\n");
                his.close();
            }
            catch(IOException e1){
                JOptionPane.showMessageDialog(null, "I/O Error","Save failed",JOptionPane.ERROR_MESSAGE);
            }
            catch(InputException e2){
                JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
