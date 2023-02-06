package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 815, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 815);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(240, 260, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(160, 320, 180, 25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(330, 320, 140, 25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-enter New PIN:");
        repintext.setBounds(160, 360, 180, 25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,15));
        repin.setBounds(330, 360, 140, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(325, 443, 150, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(325, 473, 150, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(850,735);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try {
                String newpin = pin.getText();
                String re_enterpin = repin.getText();

                if (!newpin.equals(re_enterpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesnot match");
                    return;
                }
                
                if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if(re_enterpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+re_enterpin+"' where pin='"+this.pinnumber+"'";
                String query2 = "update login set pinnumber = '"+re_enterpin+"' where pinnumber='"+this.pinnumber+"'";
                String query3 = "update signupthree set pinnumber = '"+re_enterpin+"' where pinnumber='"+this.pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(re_enterpin).setVisible(true);
            }catch (Exception e) {
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new PinChange("");
    }
}
