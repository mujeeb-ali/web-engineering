package ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login1 extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardtext;
    JPasswordField pintext;

    Login1(){
        setTitle("ATM Management System");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ATM_Management_System/icons/atmlogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        getContentPane().setBackground(Color.WHITE );
        add(label);

        JLabel text = new JLabel("Welcome to My ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setBounds(120,150,400,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);

        cardtext = new JTextField();
        cardtext.setBounds(300,150,230,30);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardtext);

        JLabel Pin = new JLabel("PIN:");
        Pin.setBounds(120,220,250,30);
        Pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(Pin);

        pintext = new JPasswordField();
        pintext.setBounds(300,220,230,30);
        pintext.setFont(new Font("Times new Roman", Font.ROMAN_BASELINE, 14));
        add(pintext);


        login = new JButton("SIGN IN");
        login.setBounds(300, 300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);



    }
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == login) {
            Connect con = new Connect();
            String cardnumber = cardtext.getText();
            String pinnumber = pintext.getText();
            String query = "select * from login where Card_number = '"+cardnumber+"' and Pin_number= '"+pinnumber+"'";
            try {
              ResultSet rs = con.s.executeQuery(query);
              if (rs.next()){
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
              }else {
                  JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
              }

            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == clear) {
            pintext.setText("");
            cardtext.setText("");
        }
        else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup1().setVisible(true);

        }
    }
    public static void main(String[] args)   {
        new Login1();
    }

}