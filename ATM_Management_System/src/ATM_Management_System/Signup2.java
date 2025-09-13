package ATM_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Signup2 extends JFrame implements ActionListener{


    JTextField phoneNumber,cnicNumber;
    JButton next;
    JRadioButton eNo,eYes,sYes,sNo;

    JComboBox religion,income,education,occupation,category;
    String formno;
    Signup2(String form){
        this.formno = form;
        setLayout(null);
        setTitle("NEW ACCOOUNT APPLICATION FORM - PAGE 2" );

        JLabel aditionDetails = new JLabel("Page 2: Additional  Details");
        aditionDetails.setFont(new Font("Raleway",Font.BOLD,22));
        aditionDetails.setBounds(290,80,400,30);
        add(aditionDetails);

        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);

        String valReligion[] = {"Muslim","Chirstian","Hindu" ,"Other"};

        religion = new JComboBox(valReligion );
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,200,30);
        add(cat);

        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel inco = new JLabel("Income:");
        inco.setFont(new Font("Raleway",Font.BOLD,20));
        inco.setBounds(100,240,200,30);
        add(inco);

        String incomeCategory[] = {"Null","<150,000","<200,000","<300,000","<400,0000",">400,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);

        JLabel qul = new JLabel("Qualification:");
        qul.setFont(new Font("Raleway",Font.BOLD,20));
        qul.setBounds(100,315,200,30);
        add(qul);

        String educationValues[] = {"Intermediate","Graduate","Post Graduate","Master's","M.phill","PHD"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occu = new JLabel("Occupation:");
        occu.setFont(new Font("Raleway",Font.BOLD,20));
        occu.setBounds(100,390,200,30);
        add(occu);

        String occupqtionValues[] = {"Employed","Retired","Businessman","Student","Other",};
        occupation = new JComboBox(occupqtionValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel phone = new JLabel("Phone Number:");
        phone.setFont(new Font("Raleway",Font.BOLD,20));
        phone.setBounds(100,440,200,30);
        add(phone);

        phoneNumber = new JTextField();
        phoneNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        phoneNumber.setBounds(300, 440, 400, 30);
        add(phoneNumber);

        JLabel cnic = new JLabel("CNIC NO:");
        cnic.setFont(new Font("Raleway",Font.BOLD,20));
        cnic.setBounds(100,490,200,30);
        add(cnic);

        cnicNumber = new JTextField();
        cnicNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        cnicNumber.setBounds(300, 490, 400, 30);
        add(cnicNumber);

        JLabel citizan = new JLabel("Senior Citizen:");
        citizan.setFont(new Font("Raleway",Font.BOLD,20));
        citizan.setBounds(100,540,200,30);
        add(citizan);

        sYes = new JRadioButton("Yes");
        sYes.setBounds(300,540,100,30);
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("No");
        sNo.setBounds(400,540,100,30);
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup Sgrp = new ButtonGroup();
        Sgrp.add(sYes);
        Sgrp.add(sNo);

        JLabel acc = new JLabel("Existing Account:");
        acc.setFont(new Font("Raleway",Font.BOLD,20));
        acc.setBounds(100,590,200,30);
        add(acc);

        eYes = new JRadioButton("Yes");
        eYes.setBounds(300,590,100,30);
        eYes.setBackground(Color.WHITE);
        add(eYes);

        eNo = new JRadioButton("No");
        eNo.setBounds(400,590,100,30);
        eNo.setBackground(Color.WHITE);
        add(eNo);

        ButtonGroup eGrp = new ButtonGroup();
        eGrp.add(eYes);
        eGrp.add(eNo);

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

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();



        String scitizen = null;
        if (sYes.isSelected()){
            scitizen = "Yes";
        }
        else if (sNo.isSelected()){
            scitizen = "No";
        }

        String eaccount = null;
        if (eYes.isSelected()){
            eaccount = "Yes";
        }
        else if (eNo.isSelected()){
            eaccount = "No";
        }
        String phonenum = phoneNumber.getText();
        String nic = cnicNumber.getText();

        try{
            if (nic.equals("")){
                JOptionPane.showMessageDialog(null,"NIC is Required");
            }
                Connect c = new Connect();
                String querry = "insert into signup2 value('"+formno+"','"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+phonenum+"', '"+nic+"', '"+scitizen+"', '"+eaccount+"')";
                c.s.executeUpdate(querry);


                setVisible(false);
                new Signup3(formno).setVisible(true);


        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        new Signup2("");
    }

}
