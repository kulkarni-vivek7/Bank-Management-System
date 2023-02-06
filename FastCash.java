package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton b_100,b_500,b_1000,b_2000,b_5000,b_10000,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 805, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 805);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(205, 270, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        b_100 = new JButton("Rs 100");
        b_100.setBounds(155, 375, 150, 25);
        b_100.addActionListener(this);
        image.add(b_100);
        
        b_500 = new JButton("Rs 500");
        b_500.setBounds(330, 375, 150, 25);
        b_500.addActionListener(this);
        image.add(b_500);
        
        b_1000 = new JButton("Rs 1000");
        b_1000.setBounds(155, 405, 150, 25);
        image.add(b_1000);
        
        b_2000 = new JButton("Rs 2000");
        b_2000.setBounds(330, 405, 150, 25);
        b_2000.addActionListener(this);
        image.add(b_2000);
        
        b_5000 = new JButton("Rs 5000");
        b_5000.setBounds(155, 435, 150, 25);
        b_5000.addActionListener(this);
        image.add(b_5000);
        
        b_10000 = new JButton("Rs 10000");
        b_10000.setBounds(330, 435, 150, 25);
        b_10000.addActionListener(this);
        image.add(b_10000);
        
        back = new JButton("Back");
        back.setBounds(330, 465, 150, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(850,735);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3); //Rs 500
            Conn c = new Conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
                
    }
    
    public static void main(String[] args){
        new FastCash("");
    }  
}
