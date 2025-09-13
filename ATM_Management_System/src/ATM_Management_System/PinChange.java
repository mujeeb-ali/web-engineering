package ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String pinnumber;
    JPasswordField pinfeild,repinfeild;
    JLabel pintext,repintext,text;
    JButton change,back;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        setVisible(true);
        setLocation(300,0);
        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("ATM_Management_System/icons/atm1.jpg"));
        Image i2 = image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0,0,900,900);
        add(image1);


        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image1.add(text);

        pintext = new JLabel("NEW PIN ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image1.add(pintext);

        pinfeild = new JPasswordField();
        pinfeild.setFont(new Font("Raleway",Font.BOLD,25));
        pinfeild.setBounds(330,320,180,25);
        image1.add(pinfeild);


        repintext = new JLabel("RE-ENTER PIN ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image1.add(repintext);


        repinfeild = new JPasswordField();
        repinfeild.setFont(new Font("Raleway",Font.BOLD,25));
        repinfeild.setBounds(330,360,180,25);
        image1.add(repinfeild);


        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image1.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image1.add(back);





    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == change) {
            try {
                String npin = pinfeild.getText();
                String repin = repinfeild.getText();

                if (!npin.equals(repin)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                    return;
                }

                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter New Pin");
                    return;
                }
                if (repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin");
                    return;
                }

                Connect con = new Connect();
                String query1 = "update data set Pin = '"+repin+"' where Pin ='"+pinnumber+"'";
                String query2 = "update login set Pin_number = '"+repin+"' where Pin_number ='"+pinnumber+"'";
                String query3 = "update signup3 set Pin_number = '"+repin+"' where Pin_number ='"+pinnumber+"'";
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully!");

                setVisible(false);
                new Transactions(repin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
