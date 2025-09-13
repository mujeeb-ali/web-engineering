package ATM_Management_System;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class Signup1 extends JFrame implements ActionListener{

    Random rand  = new Random();
    JTextField namTextField,fnamTextField,emailTextField,addTextField,cityTextField,stateTextField,pincodeTextField,dob;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser jdate;

    long randonno = Math.abs(rand.nextLong() % 9000L + 1000L);

    Signup1(){

        setLayout(null);

        JLabel formno = new JLabel("APPLICATION FORM NO. "+randonno);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        namTextField = new JTextField();
        namTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        namTextField.setBounds(300, 140, 400, 30);
        add(namTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnamTextField = new JTextField();
        fnamTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnamTextField.setBounds(300, 190, 400, 30);
        add(fnamTextField);
         
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob); 

        jdate = new JDateChooser();
        jdate.setBounds(300,240,400,30);
        jdate.setForeground(new Color(105,105,105));
        add(jdate);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);


        female = new JRadioButton("Female");
        female.setBounds(450,290,160,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bgrp = new ButtonGroup();
        bgrp.add(male);
        bgrp.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email); 
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);


        JLabel status = new JLabel("Marital Status:");
        status.setFont(new Font("Raleway",Font.BOLD,20));
        status.setBounds(100,390,200,30);
        add(status);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);


        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);


        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup Ggrp = new ButtonGroup();
        Ggrp.add(married);
        Ggrp.add(unmarried);
        Ggrp.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addTextField = new JTextField();
        addTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addTextField.setBounds(300, 440, 400, 30);
        add(addTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);        
        
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("PIN Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField); 

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Relway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + randonno;
        String name = namTextField.getText();
        String fname = fnamTextField.getText();
        String Date = ((JTextField) jdate.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }

        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        }
        else if (unmarried.isSelected()){
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String address = addTextField.getText();
        String mail = emailTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();

        try{
        if (name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is required");
        }else if (fname.equals("")){
            JOptionPane.showMessageDialog(null,"Father's Name is required");
        }else if (Date.equals("")){
            JOptionPane.showMessageDialog(null,"Date Of Birth is Required");
        }else if (gender.equals("")){
            JOptionPane.showMessageDialog(null,"Gender Selection is Required");
        }else if (mail.equals("")){
            JOptionPane.showMessageDialog(null,"Email Address  is Required");
        }
        /*else if (!mail.endsWith("m")){
            JOptionPane.showMessageDialog(null," Invalid Email Address");
        }else if (!mail.endsWith("m")){
            JOptionPane.showMessageDialog(null," Invalid Email Address");
        }*/
        else {
            Connect c = new Connect();
            String querry = "insert into signup1 values('"+formno+"', '"+name+"','"+fname+"', '"+Date+"', '"+gender+"', '"+mail+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
            c.s.executeUpdate(querry);
            setVisible(false);
            new Signup2(formno).setVisible(true);
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
       new Signup1();
    }
    
}
