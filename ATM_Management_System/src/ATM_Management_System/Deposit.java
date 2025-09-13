package ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit,back;
    String pinnumber;

    Deposit(String pin){
        pinnumber = pin;

        setLayout(null);
        setVisible(true);
        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ATM_Management_System/icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter Amount You Want to Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,330,320,20);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
    }

    public void actionPerformed(ActionEvent ae){
        try {
            String paisy = amount.getText();
            Date date = new Date();
            if (ae.getSource() == deposit) {
                if (amount.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to deposit");
                } else {
                    Connect con = new Connect();
                    String query2 = "insert into data values('" + pinnumber + "', '" + date + "', 'Deposit', '" + paisy + "')";
                    con.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Rs " + paisy + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Deposit d = new Deposit("");
    }
}
