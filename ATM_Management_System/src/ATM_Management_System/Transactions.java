package ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,cashWithdrawel,fastCash,minis,pinChange,BalanceEnquery,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
       setLayout(null);
       ImageIcon i1  =  new ImageIcon(ClassLoader.getSystemResource("ATM_Management_System/icons/OIP1.jpeg"));
       Image i2 = i1.getImage().getScaledInstance(850,800,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image =  new JLabel(i3);
       image.setBounds(0,0,850,800);
       add(image);

       setUndecorated(true);
       setVisible(true);
       setBackground(Color.WHITE);
       setSize(850,800);
       setLocation(300,0);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JLabel text = new JLabel("Please Select your Transaction ");
        text.setBounds(240,215,700,35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(225,465,100,20);
        deposit.addActionListener(this);
        image.add(deposit);

        cashWithdrawel = new JButton("Cash Withdrawal");
        cashWithdrawel.setBounds(330,465,160,20);
        cashWithdrawel.addActionListener(this);
        image.add(cashWithdrawel);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(225,485,100,20);
        fastCash.addActionListener(this);
        image.add(fastCash);

        minis = new JButton("Mini Statement");
        minis.setBounds(330,485,160,20);
        minis.addActionListener(this);
        image.add(minis);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(225,505,100,20);
        pinChange.setBackground(Color.WHITE);
        pinChange.addActionListener(this);
        image.add(pinChange);

        BalanceEnquery = new JButton("Balance Enquiry");
        BalanceEnquery.setBounds(330,505,160,20);
        BalanceEnquery.addActionListener(this);
        image.add(BalanceEnquery);

        exit = new JButton("Exit");
        exit.setBounds(300,535,100,20);
        exit.addActionListener(this);
        image.add(exit);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == cashWithdrawel) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == BalanceEnquery) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == minis) {
            new MiniStetement(pinnumber).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
