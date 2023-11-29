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
public class Length extends JFrame {
    JComboBox list1, list2;
    JTextField text1, text2, result;
    JButton convert, save, clr, back;
    JLabel l;
    String measurments[]={"km","m","cm","mm"};
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 28);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    public Length(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 this.setSize(500,600);
                 this.setLocation(200,300);
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEADING,5,5));
//        p1.setLayout(new GridLayout(1,3,10,0));
        p1.setBackground(Color.decode("#36454F"));
        l = new JLabel("Length");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
       
        back = new JButton ("back");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#36454F"));
        back.setForeground(Color.decode("#fafeff"));
        back.setBorderPainted(false);
        
        p1.add(back,BorderLayout.WEST);
        p1.add(l,BorderLayout.NORTH);
        
        
        
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
        text2.setBackground(Color.decode("#fafeff"));
        text2.setForeground(Color.decode("#36454F"));
        text2.setFont(bFonts);
        p3.add(list2);
        p3.add(text2);
        
        //result bar
        
       JPanel p4 = new JPanel (new FlowLayout(FlowLayout.CENTER));
       p4.setBackground(Color.decode("#36454F"));
       result = new JTextField(10);
       result.setEditable(false);
       result.setBackground(Color.decode("#fafeff"));
       result.setForeground(Color.decode("#36454F"));
       result.setFont(bFonts);
       p4.add(result);
       
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
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        this.setVisible(true);//
    }

}
