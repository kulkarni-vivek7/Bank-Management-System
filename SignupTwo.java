package bank.management.system;


import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panNo,aadhar;
    JButton next;
    JRadioButton SYes,SNo,EYes,ENo;
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT REGISTRATION FORM - PAGE 2");
 
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 60, 400, 30);
        add(additionalDetails);

        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100, 130, 100, 30);
        add(Religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 130, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        
        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100, 180, 200, 30);
        add(Category);

        String valCategory[] = {"General","OBC","SE","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 180, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100, 230, 200, 30);
        add(Income);
        
        String incomeCategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 230, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel Education = new JLabel("Educational");
        Education.setFont(new Font("Raleway",Font.BOLD,20));
        Education.setBounds(100, 280, 200, 30);
        add(Education);
        
        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway",Font.BOLD,20));
        Qualification.setBounds(100, 305, 200, 30);
        add(Qualification);
        
        String educationValues[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 305, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(100, 380, 200, 30);
        add(Occupation);
        
        String occupationValues[] = {"Salaried Employee","Self-Employed","Business","Student","Retired","Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 380, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        

        JLabel panno = new JLabel("PAN Number:");
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(100, 430, 200, 30);
        add(panno);

        panNo = new JTextField();
        panNo.setFont(new Font("Raleway",Font.BOLD,14));
        panNo.setBounds(300, 430, 400, 30);
        add(panNo);

        JLabel aadharno = new JLabel("Aadhar Number:");
        aadharno.setFont(new Font("Raleway",Font.BOLD,20));
        aadharno.setBounds(100, 480, 200, 30);
        add(aadharno);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300, 480, 400, 30);
        add(aadhar);

        JLabel SCitizen = new JLabel("Senior Citizen:");
        SCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        SCitizen.setBounds(100, 530, 200, 30);
        add(SCitizen);

        SYes = new JRadioButton("Yes");
        SYes.setBounds(300, 530, 100, 30);
        SYes.setBackground(Color.white);
        add(SYes);
        
        SNo = new JRadioButton("No");
        SNo.setBounds(450, 530, 100, 30);
        SNo.setBackground(Color.white);
        add(SNo);
        
        ButtonGroup Senior_Citizen  = new ButtonGroup();
        Senior_Citizen.add(SYes);
        Senior_Citizen.add(SNo);

        JLabel EAccount = new JLabel("Exisiting Account:");
        EAccount.setFont(new Font("Raleway",Font.BOLD,20));
        EAccount.setBounds(100, 580, 200, 30);
        add(EAccount);
        
        EYes = new JRadioButton("Yes");
        EYes.setBounds(300, 580, 100, 30);
        EYes.setBackground(Color.white);
        add(EYes);
        
        ENo = new JRadioButton("No");
        ENo.setBounds(450, 580, 100, 30);
        ENo.setBackground(Color.white);
        add(ENo);
        
        ButtonGroup Exisiting_Account  = new ButtonGroup();
        Exisiting_Account.add(EYes);
        Exisiting_Account.add(ENo);

        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 625, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,730);
        setLocation(300,4);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String s_religion = (String)religion.getSelectedItem();
        String s_category = (String)category.getSelectedItem();
        String s_income = (String)income.getSelectedItem();
        String s_education = (String)education.getSelectedItem();
        String s_occupation = (String)occupation.getSelectedItem();
        String s_panNo = panNo.getText();
        String s_aadhar = aadhar.getText();
        
        String seniorcitizen = null; 
        if (SYes.isSelected()){
            seniorcitizen = "Yes";
        }else if(SNo.isSelected()){
            seniorcitizen = "No";
        }
        
        String exisitingaccount = null;
        if(EYes.isSelected()){
            exisitingaccount = "Yes";
        }else if(ENo.isSelected()){
            exisitingaccount = "No";
        }

        try{
            
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+this.formno+"','"+s_religion+"','"+s_category+"','"+s_income+"','"+s_education+"','"+s_occupation+"','"+s_panNo+"','"+s_aadhar+"','"+seniorcitizen+"','"+exisitingaccount+"')";
            c.s.executeUpdate(query);
            
//            Signup3 Object
            setVisible(false);
            new SignupThree(this.formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
        
    
    }    
    public static void main(String[] args) {
        new SignupTwo("");
    }
    
}
