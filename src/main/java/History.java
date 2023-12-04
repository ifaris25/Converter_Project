/**
 *
 * @author MUSTAFA
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class History extends JFrame{
    JLabel title;
    JTextArea textArea;
    JButton back;
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    
    public History (Home homepage){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(200,300);
        this.setTitle("History");
                
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.setBackground(Color.decode("#36454F"));
               
        back = new JButton ("Back");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#B6BBC4"));
        back.setForeground(Color.decode("#31304D"));
        back.setBorderPainted(false);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                homepage.setVisible(true);
            }
        });
        
        p1.add(back);
        
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        title = new JLabel("History");
        title.setFont(labelFont);
        title.setForeground(Color.decode("#fafeff"));
        pLabel.add(title);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.setBackground(Color.decode("#36454F"));
        
        textArea = new JTextArea(10, 30);
        textArea.setBackground(Color.decode("#B6BBC4"));
        textArea.setForeground(Color.decode("#31304D"));
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        
        try (BufferedReader reader = new BufferedReader(new FileReader("History.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        p2.add(scroll);
        
        JPanel p = (JPanel)this.getContentPane();
        p.setLayout(new GridLayout(3,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(p2);
        
        this.setVisible(true);
    }
}
