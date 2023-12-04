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
public class Discount extends JFrame{
    
    JButton back ,calc, clr;
    JLabel l;
    JLabel oPrice,dis,fPrice, perc,saved;
    JTextField op,d,res,sa;
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    Font b1Fonts = new Font(Font.SANS_SERIF,  Font.BOLD, 20);
    public Discount(Home homepage, String s){
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
        l = new JLabel("Discount");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        
        pLabel.add(l);
        
        //first bar
        JPanel fBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fBar.setBackground(Color.decode("#36454F"));
        oPrice = new JLabel(" Original price   ");
        oPrice.setFont(b1Fonts);
        oPrice.setForeground(Color.decode("#fafeff"));

        op = new JTextField(10);
        op.setBackground(Color.decode("#fafeff"));
        op.setForeground(Color.decode("#36454F"));
        op.setFont(bFonts);
        
        fBar.add(oPrice);
        fBar.add(op);
        
        //second bar
        JPanel sBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sBar.setBackground(Color.decode("#36454F"));

        dis = new JLabel(" Discount (%off)   ");
        dis.setFont(b1Fonts);
        dis.setForeground(Color.decode("#fafeff"));
        
        d = new JTextField(10);
        d.setBackground(Color.decode("#fafeff"));
        d.setForeground(Color.decode("#36454F"));
        d.setFont(bFonts);
        
        perc = new JLabel("%");
        perc.setForeground(Color.decode("#fafeff"));
        perc.setFont(bFonts);
        
        sBar.add(dis);
        sBar.add(d);
        sBar.add(perc);
        
        //third bar
        JPanel tBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tBar.setBackground(Color.decode("#36454F"));
        fPrice = new JLabel(" Final price   ");
        fPrice.setFont(b1Fonts);
        fPrice.setForeground(Color.decode("#fafeff"));

        res = new JTextField(10);
        res.setBackground(Color.decode("#B6BBC4"));
        res.setForeground(Color.decode("#36454F"));
        res.setFont(bFonts);
        res.setEditable(false);
        
        tBar.add(fPrice);
        tBar.add(res);
        
        //saved bar
        JPanel saveBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        saveBar.setBackground(Color.decode("#36454F"));
        saved = new JLabel(" You saved   ");
        saved.setFont(b1Fonts);
        saved.setForeground(Color.decode("#fafeff"));

        sa = new JTextField(10);
        sa.setBackground(Color.decode("#B6BBC4"));
        sa.setForeground(Color.decode("#36454F"));
        sa.setFont(bFonts);
        sa.setEditable(false);
        
        saveBar.add(saved);
        saveBar.add(sa);
        //forth bar
        JPanel foBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        foBar.setBackground(Color.decode("#36454F"));
        calc = new JButton("Calculate");
        calc.setFocusable(false);
        calc.setFont(b1Fonts);
        calc.setBackground(Color.decode("#B6BBC4"));
        calc.setForeground(Color.decode("#023020"));
        calc.setBorderPainted(false);
        
        clr = new JButton("Clear");
        clr.setFocusable(false);
        clr.setFont(b1Fonts);
        clr.setBackground(Color.decode("#B6BBC4"));
        clr.setForeground(Color.decode("#023020"));
        clr.setBorderPainted(false);
       
        foBar.add(calc);
        foBar.add(clr);
        
        JPanel p = (JPanel)this.getContentPane();
        p.setLayout(new GridLayout(7,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(fBar);
        p.add(sBar);
        p.add(tBar);
        p.add(saveBar);
        p.add(foBar);
        
        
        clr.addActionListener(new Clr());
        calc.addActionListener(new Calculate());
        this.setVisible(true);//
    }
    
    private class Clr implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==clr){
                op.setText("");
                d.setText("");
                res.setText("");
                sa.setText("");
            }
        }
    }
    
    private class Calculate implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (e.getSource()==calc){
                double num1, num2,ress;
                try{
                num1 = Double.parseDouble(op.getText());
                num2 = Double.parseDouble(d.getText());
                if(num2 < num1 && num1 != 0){
                    ress = (num2/num1)*100;
                    sa.setText(String.valueOf(ress));
                    res.setText(String.valueOf(num1-ress));
                }
                else{
                    JOptionPane.showMessageDialog(null,"Really!","Failed",JOptionPane.ERROR_MESSAGE);
                }
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,"Are you kidding?","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
