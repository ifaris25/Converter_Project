/**
 *
 * @author MUSTAFA
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Data extends JFrame {
    
    JComboBox list1, list2;
    JTextField text1, text2;
    JButton convert, clr, back, save;
    JLabel l;
    String measurments[]={"Terabyte | TB","Gigabyte | GB","Megabyte | MB","Kilobyte | KB", "Byte | B", "Bit"};
    
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    boolean isSaved = false;
    
    public Data(Home homepage){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(200,300);
        this.setTitle("Data");
        
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
        l = new JLabel("Data");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        pLabel.add(l);
        
        //First Bar
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
        
        
        //Second Bar
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
                //converting from Terabyte TB to other units
                if (s1.equals("Terabyte | TB")){
                    switch(s2){
                        case "Terabyte | TB":
                            result = num1;
                            text2.setText(result+"");
                            break;
                        case "Gigabyte | GB":
                            result = num1*1000;
                            text2.setText(result+"");
                            break;
                        case "Megabyte | MB":
                            result = num1*1000000;
                            text2.setText(result+"");
                            break;
                        case "Kilobyte | KB":
                            result = num1 * 1000000000;
                            text2.setText(result+"");
                            break;
                        case "Byte | B":
                            result = num1 * 1000000000000L;
                            text2.setText(result+"");
                            break;
                        case "Bit":
                            result = num1 * 8000000000000L;
                            text2.setText(result+"");
                            break;
                    }
                }
                //converting from Gigabyte GB to other units
                if(s1.equals("Gigabyte | GB")){
                    switch (s2){
                        case "Terabyte | TB":
                            result = num1/1000;
                            text2.setText(result+"");
                            break;
                        case "Gigabyte | GB":
                            result = num1;
                            text2.setText(result+"");
                            break;
                        case "Megabyte | MB":
                            result = num1 * 1000;
                            text2.setText(result+"");
                            break;
                        case "Kilobyte | KB":
                            result = num1 * 1000000;
                            text2.setText(result+"");
                            break;
                        case "Byte | B":
                            result = num1 * 1000000000;
                            text2.setText(result+"");
                            break; 
                        case "Bit":
                            result = num1 * 8000000000L;
                            text2.setText(result+"");
                            break;
                    }
                }
                //converting from Megabyte MB to other units
                if(s1.equals("Megabyte | MB")){
                    switch(s2){
                        case "Terabyte | TB":
                            result = num1 / 1000000;
                            text2.setText(result+"");
                            break;
                        case "Gigabyte | GB":
                            result = num1 / 1000;
                            text2.setText(result+"");
                            break;
                        case "Megabyte | MB":
                            result = num1;
                            text2.setText(result+"");
                            break;
                        case "Kilobyte | KB":
                            result = num1 * 1000;
                            text2.setText(result+"");
                            break;
                        case "Byte | B":
                            result = num1 * 1000000;
                            text2.setText(result+"");
                            break; 
                        case "Bit":
                            result = num1 * 8000000;
                            text2.setText(result+"");
                            break;
                    }
                }
                //converting from Kilobyte KB to other units
                if(s1.equals("Kilobyte | KB")){
                    switch(s2){
                        case "Terabyte | TB":
                            result = num1 / 1000000000 ;
                            text2.setText(result+"");
                            break;
                        case "Gigabyte | GB":
                            result = num1 / 1000000;
                            text2.setText(result+"");
                            break;
                        case "Megabyte | MB":
                            result = num1 / 1000;
                            text2.setText(result+"");
                            break;
                        case "Kilobyte | KB":
                            result = num1;
                            text2.setText(result+"");
                            break;
                        case "Byte | B":
                            result = num1 * 1000;
                            text2.setText(result+"");
                            break; 
                        case "Bit":
                            result = num1 * 8000;
                            text2.setText(result+"");
                            break;
                    }
                }
                //converting from Byte B to other units
                if(s1.equals("Byte | B")){
                    switch(s2){
                        case "Terabyte | TB":
                            result = num1 / 1000000000000L;
                            text2.setText(result+"");
                            break;
                        case "Gigabyte | GB":
                            result = num1 / 1000000000;
                            text2.setText(result+"");
                            break;
                        case "Megabyte | MB":
                            result = num1 / 1000000;
                            text2.setText(result+"");
                            break;
                        case "Kilobyte | KB":
                            result = num1 / 1000;
                            text2.setText(result+"");
                            break;
                        case "Byte | B":
                            result = num1;
                            text2.setText(result+"");
                            break; 
                        case "Bit":
                            result = num1 * 8;
                            text2.setText(result+"");
                            break;    
                    }
                }
                //converting from Bit to other units
                if(s1.equals("Bit")){
                    switch(s2){
                        case "Terabyte | TB":
                            result = num1 / 8000000000000L;
                            text2.setText(result+"");
                            break;
                        case "Gigabyte | GB":
                            result = num1 / 8000000000L;
                            text2.setText(result+"");
                            break;
                        case "Megabyte | MB":
                            result = num1 / 8000000;
                            text2.setText(result+"");
                            break;
                        case "Kilobyte | KB":
                            result = num1 / 8000;
                            text2.setText(result+"");
                            break;
                        case "Byte | B":
                            result = num1 / 8;
                            text2.setText(result+"");
                            break; 
                        case "Bit":
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
    private class SaveButton implements ActionListener{
        public void actionPerformed (ActionEvent e){
            try{
                if(text1.getText().equals("") || text2.getText().equals(""))
                    throw new InputException("Missing inputs");
                if(isSaved == false){
                isSaved = false;
                    String s = text1.getText()+" "+String.valueOf(list1.getSelectedItem())+" = "+ text2.getText()+" "+String.valueOf(list2.getSelectedItem());
                    BufferedWriter his = new BufferedWriter(new FileWriter("History.txt",true));
                    his.write(s+"\n\n");
                    his.close();
                    JOptionPane.showMessageDialog(null,"Successful save!","Done",JOptionPane.PLAIN_MESSAGE);
                }
            } catch (IOException e1) {
                
            } catch(InputException e2) {
                    
            }
        }
    }
}
