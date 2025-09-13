package ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton qm1,qm2,qm3,qm4,qm5,qm6,back;
    String pinnumber;
    Date date;
    FastCash(String pinnumber){
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



        JLabel text = new JLabel(" Select Withdrawl amount  ");
        text.setBounds(310,215,700,35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        qm1 = new JButton("Rs 1000");
        qm1.setBounds(230,465,100,20);
        qm1.addActionListener(this);
        image.add(qm1);

        qm2 = new JButton("Rs 3000");
        qm2.setBounds(340,465,160,20);
        qm2.addActionListener(this);
        image.add(qm2);

        qm3 = new JButton("Rs 5000");
        qm3.setBounds(230,485,100,20);
        qm3.addActionListener(this);
        image.add(qm3);

        qm4 = new JButton("Rs 7000");
        qm4.setBounds(340,485,160,20);
        qm4.addActionListener(this);
        image.add(qm4);

        qm5 = new JButton("Rs 9000");
        qm5.setBounds(230,505,100,20);
        qm5.addActionListener(this);
        image.add(qm5);

        qm6 = new JButton("Rs 10000");
        qm6.setBounds(340,505,160,20);
        qm6.addActionListener(this);
        image.add(qm6);

        back = new JButton("BACK");
        back.setBounds(300,535,100,20);
        back.addActionListener(this);
        image.add(back);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);

        } else  {
           String amount = ((JButton)ae.getSource()).getText().substring(3);
           Connect con = new Connect();
           try {
               ResultSet rs = con.s.executeQuery("select * from data where Pin = '"+pinnumber+"'");
               int balance = 0;
               while (rs.next()){
                   if (rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }

               }

               if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");

                   return;
               }
              Date date1;
               date = new Date();
               String query2 = "insert into data values('"+pinnumber+"', '"+date+"', ' Withdrawl', '"+amount+"')";
               con.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null,"Rs "+amount+"Debited Successfully");

                setVisible(false);
            new Transactions(pinnumber).setVisible(true);


           }catch (Exception e){
               System.out.println(e);
           }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
