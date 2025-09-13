package ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStetement extends JFrame {
    String pinnumber;
    MiniStetement(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel name = new JLabel("My Bank");
        name.setBounds(150,20,100,20);
        add(name);


        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);


        try {
            Connect con = new Connect();
           ResultSet rs = con.s.executeQuery("select * from login where Pin_number = '"+pinnumber+"'");
           while (rs.next()){
               card.setText("Card Number : "+ rs.getString("Card_number").substring(0,4)+"********"+rs.getString("Card_number").substring(12));
           }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            int bal = 0;

            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("select * from data where Pin = '"+pinnumber+"'");
            while (rs.next()){

                mini.setText(mini.getText() +"<html>"+ rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");


            if (rs.getString("type").equals("Deposit")){
                bal += Integer.parseInt(rs.getString("amount"));
            }else {
                bal -= Integer.parseInt(rs.getString("amount"));
            }
            }

            balance.setText("Your Current Balance is "+bal);

        }catch (Exception e1){
            System.out.println(e1);
        }


    }

    public static void main(String[] args) {
        new MiniStetement("");
    }
}
