package ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton b1,b2,b3,b4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setBackground(Color.WHITE);
        setSize(850,870);
        setLocation(320,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Relaway",Font.BOLD,22));
        l1.setBounds(280,40,400,40 );
        add(l1);

        JLabel acctype = new JLabel("Account Type:");
        acctype.setFont(new Font("Relaway",Font.BOLD,22));
        acctype.setBounds(100,140,200,30 );
        add(acctype);

        b1 = new JRadioButton("Saving Account");
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBackground(Color.WHITE);
        b1.setBounds(100,180,150,30);
        add(b1);

        b2 = new JRadioButton("Fixed Deposit Account");
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.WHITE);
        b2.setBounds(350,180,250,30);
        add(b2);

        b3 = new JRadioButton("Current Account");
        b3.setFont(new Font("Raleway",Font.BOLD,16));
        b3.setBackground(Color.WHITE);
        b3.setBounds(100,220,152,30);
        add(b3);

        b4 = new JRadioButton("Recurring Deposit Account");
        b4.setFont(new Font("Raleway",Font.BOLD,16));
        b4.setBackground(Color.WHITE);
        b4.setBounds(350,220,250,30);
        add(b4);

        ButtonGroup grp = new ButtonGroup();
        grp.add(b1);
        grp.add(b2);
        grp.add(b3);
        grp.add(b4);

        JLabel cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Relaway",Font.BOLD,22));
        cardNo.setBounds(100,280,200,30 );
        add(cardNo);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4321");
        number.setFont(new Font("Relaway",Font.BOLD,22));
        number.setBounds(350,280,250,30 );
        add(number);

        JLabel info = new JLabel("This is your 16 digit card number");
        info.setFont(new Font("Relaway",Font.BOLD,12));
        info.setBounds(100,310,250,20 );
        add(info);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Relaway",Font.BOLD,22));
        pin.setBounds(100,350,200,30 );
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Relaway",Font.BOLD,22));
        pnumber.setBounds(350,350,250,30 );
        add(pnumber);

        JLabel pinfo = new JLabel("This is your 4 digit pin number");
        pinfo.setFont(new Font("Relaway",Font.BOLD,12));
        pinfo.setBounds(100,380,250,20 );
        add(pinfo);


        JLabel service = new JLabel("Services Required :");
        service.setFont(new Font("Relaway",Font.BOLD,22));
        service.setBounds(100,430,200,30 );
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont( new Font("Raleway",Font.BOLD,22));
        c1.setBounds(100,480,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont( new Font("Raleway",Font.BOLD,22));
        c2.setBounds(350,480,200,30);
        add(c2);


        c3 = new JCheckBox("Email Alerts");
        c3.setBackground(Color.WHITE);
        c3.setFont( new Font("Raleway",Font.BOLD,22));
        c3.setBounds(100,530,200,30);
        add(c3);


        c4 = new JCheckBox("I here by declared that all of provided information is correct according to my knowledge");
        c4.setBackground(Color.WHITE);
        c4.setFont( new Font("Raleway",Font.BOLD,12));
        c4.setBounds(100,580,600,30);
        add(c4);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,630,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,630,100,30);
        cancel.addActionListener(this);
        add(cancel);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String accountType = null;
            if (b1.isSelected()){
                accountType = "Saving Account";
            } else if (b2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (b3.isSelected()) {
                accountType = "Current Account";
            } else if (b4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }


            Random rand  = new Random();
            String cardnumber = ""+ (Math.abs((rand.nextLong() % 9000000l)+01234567000000000l));

            String pinnumber = ""+ Math.abs((rand.nextLong() % 9000l) + 1000l);

            String facility = "";
            if (c1.isSelected()){
                facility = "ATM Card";
            }
            else if (c2.isSelected()){
                facility += "Internet Banking";
            }
            else if(c3.isSelected()){
                facility += "Email Alerts";
            }


            try {
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is Needed");
                }
                else {
                    Connect con = new Connect();
                    String querry1 = "insert into signup3 value('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String querry2 = "insert into login value('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    con.s.executeUpdate(querry1);
                    con.s.executeUpdate(querry2); 
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n\n Pin: "+pinnumber);

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                }


            }catch (Exception e1){
                System.out.println(e1);
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login1().setVisible(true);

        }

    }


    public static void main(String[] args) {
        new Signup3("");
    }


}
