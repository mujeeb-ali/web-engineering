package ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdrawl(String pin){
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

        JLabel text = new JLabel("Enter Amount You Want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190,300,400,20);
        image.add(text);

        amount =new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,330,320,20);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdraw){
            String paisy = amount.getText();
            Date date = new Date();
            if (paisy.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the Amount you want to withdraw");
            }else {
                try{
                    int withdrawal = Integer.parseInt(paisy);
                    Connect con = new Connect();
                    ResultSet rs = con.s.executeQuery("select sum(case when type = 'Deposit' then amount else -amount end) as balance from data where pin = '"+pinnumber+"'");
                    if (rs.next()) {
                        int balance = rs.getInt("balance");
                        if (withdrawal > balance) {
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        } else {
                            String query2 = "insert into data values('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + paisy + "')";
                            con.s.executeUpdate(query2);
                            JOptionPane.showMessageDialog(null, "Rs " + paisy + " Withdraw Successfully");
                            setVisible(false);
                            new Transactions(pinnumber).setVisible(true);
                        }
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }

    }



    public static void main(String[] args) {
        Withdrawl d = new Withdrawl("");
    }
}
