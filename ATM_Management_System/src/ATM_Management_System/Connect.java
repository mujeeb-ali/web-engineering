package ATM_Management_System;

import java.sql.*;
public class Connect {
    Connection con;
    Statement s;
    public Connect(){
        try {

            con = DriverManager.getConnection("jdbc:mysql:///atmmanagementsystem","root","sqlforme1");
            s = con.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
