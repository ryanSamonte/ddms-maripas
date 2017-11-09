package maripas.drug.store;

import java.awt.*;
import com.sun.glass.events.KeyEvent;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.filechooser.*;
import java.io.*;
import javax.imageio.*;

public class updateImage extends javax.swing.JFrame {
    Connection conn = DBConnection.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int xMouse, yMouse;
    String s;
    public updateImage() {
        initComponents();
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

        update = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        attachImg = new javax.swing.JButton();
        close = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        help = new javax.swing.JButton();
        profilePicture = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(515, 250));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(350, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(350, 300));
        getContentPane().setLayout(null);

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updatePicButton.jpg"))); // NOI18N
        update.setAlignmentY(0.0F);
        update.setBorder(null);
        update.setPreferredSize(new java.awt.Dimension(50, 50));
        update.setRolloverEnabled(true);
        update.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/updatePicButtonHover.jpg"))); // NOI18N
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(240, 110, 90, 100);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setPreferredSize(new java.awt.Dimension(5, 50));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(210, 50, 10, 230);

        attachImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attachButton.jpg"))); // NOI18N
        attachImg.setBorder(null);
        attachImg.setRolloverEnabled(true);
        attachImg.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/attachButtonHover.jpg"))); // NOI18N
        attachImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachImgActionPerformed(evt);
            }
        });
        getContentPane().add(attachImg);
        attachImg.setBounds(40, 220, 130, 25);

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xButton.jpg"))); // NOI18N
        close.setRolloverEnabled(true);
        close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/xButtonHover.jpg"))); // NOI18N
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(300, 0, 50, 42);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButton.jpg"))); // NOI18N
        minimize.setRolloverEnabled(true);
        minimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButtonHover.jpg"))); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        getContentPane().add(minimize);
        minimize.setBounds(250, 0, 50, 42);

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButton.jpg"))); // NOI18N
        help.setRolloverEnabled(true);
        help.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButtonHover.jpg"))); // NOI18N
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        getContentPane().add(help);
        help.setBounds(200, 0, 50, 42);

        profilePicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(profilePicture);
        profilePicture.setBounds(30, 60, 145, 145);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updatePicture.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 300));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 350, 300);

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
        FrameDragger.setBounds(0, 0, 200, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attachImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachImgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            profilePicture.setIcon(ResizeImage(path));
            s = path;
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No Data");
        }
    }//GEN-LAST:event_attachImgActionPerformed

    private void FrameDraggerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_FrameDraggerMouseDragged

    private void FrameDraggerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FrameDraggerMousePressed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        close();
    }//GEN-LAST:event_closeActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        if(evt.getSource() == help){
            JOptionPane.showMessageDialog(null, "This form is for updating of admin's profile picture.", "PROFILE PICTURE [HELP]", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_helpActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(evt.getSource() == update){
            String acctLog = "SELECT `tempID` FROM `tempadmin`";
            String logged = "";
            String updatePicture = "UPDATE `admin` SET `image` = (?) WHERE adminID = (?)";
        
            
            try{
                    ps = conn.prepareStatement(acctLog);
                    rs = ps.executeQuery();
                    while(rs.next()){
                        logged = rs.getString(1);
                    }
            }
        
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
            }
            
            try{
                    InputStream is = new FileInputStream(new File(s));
                    ps = conn.prepareStatement(updatePicture);
                    ps.setBlob(1, is);
                    ps.setString(2, logged);
                    ps.execute();
                        JOptionPane.showMessageDialog(null, "Profile Picture Successfully Updated!","Administrator Account", JOptionPane.INFORMATION_MESSAGE);
                    }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No Image attached", "Update Profile Picture", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(profilePicture.getWidth(), profilePicture.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(updateImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateImage().setVisible(true);
            }
        });
    }

    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JButton attachImg;
    private javax.swing.JButton close;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton minimize;
    private javax.swing.JLabel profilePicture;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
