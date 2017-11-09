package maripas.drug.store;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnection {
    Connection conn = null;
    public static Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maripas_drug_store", "root", "");
            //JOptionPane.showMessageDialog(null, "Database Connected", "Database Connection", 0);
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Connection", 0);
            return null;
        }
    }
}
