package maripas.drug.store;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.imageio.*;
import javax.swing.*;

public class viewAdminProfile extends javax.swing.JFrame {
    Connection conn = DBConnection.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int xMouse, yMouse;
    public viewAdminProfile() {
        initComponents();
        inputs();
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/maripasIcon.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePicture = new javax.swing.JLabel();
        minimize = new javax.swing.JButton();
        close = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        name.setEditable(false);
        gender = new javax.swing.JTextField();
        gender.setEditable(false);
        age = new javax.swing.JTextField();
        age.setEditable(false);
        contact = new javax.swing.JTextField();
        contact.setEditable(false);
        address = new javax.swing.JTextField();
        address.setEditable(false);
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 150));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 470));
        setSize(new java.awt.Dimension(750, 470));
        getContentPane().setLayout(null);

        profilePicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(profilePicture);
        profilePicture.setBounds(130, 50, 135, 135);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButton.jpg"))); // NOI18N
        minimize.setRolloverEnabled(true);
        minimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButtonHover.jpg"))); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        getContentPane().add(minimize);
        minimize.setBounds(300, 0, 50, 42);

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xButton.jpg"))); // NOI18N
        close.setRolloverEnabled(true);
        close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/xButtonHover.jpg"))); // NOI18N
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(350, 0, 50, 42);
        getContentPane().add(name);
        name.setBounds(110, 225, 250, 30);
        getContentPane().add(gender);
        gender.setBounds(110, 270, 120, 30);
        getContentPane().add(age);
        age.setBounds(110, 310, 120, 30);
        getContentPane().add(contact);
        contact.setBounds(110, 350, 250, 30);
        getContentPane().add(address);
        address.setBounds(110, 390, 250, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewAdminFLAT.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 470);

        FrameDragger.setText("jLabel3");
        FrameDragger.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FrameDraggerMouseDragged(evt);
            }
        });
        FrameDragger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FrameDraggerMousePressed(evt);
            }
        });
        getContentPane().add(FrameDragger);
        FrameDragger.setBounds(0, 0, 300, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        close();
    }//GEN-LAST:event_closeActionPerformed

    private void FrameDraggerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_FrameDraggerMouseDragged

    private void FrameDraggerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FrameDraggerMousePressed

    void inputs(){
        String selTemp = "SELECT `tempID` FROM `tempadmin`";
        String adminName = "SELECT * FROM `admin` WHERE `adminID` = ?";
        
            String loggedAdmin = "";
            int ID = 0;
            String fName = "", lName = "", mName = "", gend = "", edad = "", cont = "", num = "", sName = "", brgy = "", city = "";
                try{
                    ps = conn.prepareStatement(selTemp);
                    rs = ps.executeQuery();
                    while(rs.next()){
                        loggedAdmin = rs.getString(1);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
                }
               
                
                try{
                    ps = conn.prepareStatement(adminName);
                    ps.setString(1, loggedAdmin);
                    rs = ps.executeQuery();
                    while(rs.next()){
                        fName = rs.getString(5);
                        lName = rs.getString(4);
                        mName = rs.getString(6);
                        gend = rs.getString(7);
                        edad = rs.getString(8);
                        cont = rs.getString(9);
                        num = rs.getString(10);
                        sName = rs.getString(11);
                        brgy = rs.getString(12);
                        city = rs.getString(13);
                        byte[] img = rs.getBytes("Image");



                    //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(profilePicture.getWidth(), profilePicture.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    profilePicture.setIcon(newImage);
                    name.setText(fName+" "+mName+" "+lName);
                    gender.setText(gend);
                    age.setText(edad);
                    contact.setText(cont);
                    address.setText(num+" "+sName+" "+brgy+" "+city);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
                }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewAdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewAdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewAdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewAdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewAdminProfile().setVisible(true);
            }
        });
    }
    
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JButton close;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton minimize;
    private javax.swing.JTextField name;
    private javax.swing.JLabel profilePicture;
    // End of variables declaration//GEN-END:variables
}
