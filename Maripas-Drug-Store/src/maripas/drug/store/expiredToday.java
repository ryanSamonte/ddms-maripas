package maripas.drug.store;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class expiredToday extends javax.swing.JFrame {
    Connection conn = DBConnection.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int xMouse, yMouse;

    public expiredToday() {
        initComponents();
        expiration();
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/maripasIcon.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    
    public void expiration(){
        
      java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = (f.format(d));
            String expDisplay = "SELECT p.product_id AS 'PRODUCT ID', p.product_desc AS 'PRODUCT NAME', i.quantity AS 'QUANTITY', i.expiration_date AS 'EXPIRATION DATE' FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE (i.expiration_date BETWEEN ? AND ?)";
            try{
                
                ps = conn.prepareStatement(expDisplay);
                ps.setString(1,"0001-01-01");
                ps.setString(2, dateToday);
                rs = ps.executeQuery();
                expiredProducts.setModel(DbUtils.resultSetToTableModel(rs));
                expiredProducts.getColumnModel().getColumn(2).setPreferredWidth(20);
                System.out.println(dateToday);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
            }     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        expiredProducts = new javax.swing.JTable();
        delButton = new javax.swing.JButton();
        help = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(440, 200));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(515, 345));
        setResizable(false);
        getContentPane().setLayout(null);

        expiredProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(expiredProducts);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 480, 140);

        delButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/removeProdButton.jpg"))); // NOI18N
        delButton.setRolloverEnabled(true);
        delButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/removeProdButtonHOVER.jpg"))); // NOI18N
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });
        getContentPane().add(delButton);
        delButton.setBounds(140, 285, 230, 40);

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButton.jpg"))); // NOI18N
        help.setToolTipText("Help");
        help.setRolloverEnabled(true);
        help.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButtonHover.jpg"))); // NOI18N
        getContentPane().add(help);
        help.setBounds(415, 0, 50, 42);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButton.jpg"))); // NOI18N
        minimize.setToolTipText("Minimize");
        minimize.setRolloverEnabled(true);
        minimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButtonHover.jpg"))); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        getContentPane().add(minimize);
        minimize.setBounds(465, 0, 50, 42);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("THE MEDICINE LIST BELOW ARE EXPIRED AND \nSHALL NOT APPEAR IN THE SALES SECTION");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 60, 440, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expProdFLAT.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(515, 234));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 515, 345);

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
        FrameDragger.setBounds(0, 0, 415, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        if(evt.getSource() == delButton){
            
        
        java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = (f.format(d));
        String deleteExpired = "UPDATE `inventory` SET `status` = (?) WHERE (expiration_date BETWEEN ? AND ?)";

        int ctr = 0, ctr1 = 0, ctr2 = 0;
        try{
            ps = conn.prepareStatement(deleteExpired);
            ps.setString(1,"EXPIRED");
            ps.setString(2,"0001-01-01");
            ps.setString(3,dateToday);
            ps.execute();
            ctr++;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        
        if(ctr >= 1){
            //String selectData = "SELECT p.product_id AS 'PRODUCT ID', p.product_desc AS 'PRODUCT NAME', p.selling_price AS 'PRICE', p.dosage AS 'DOSAGE', c.product_category_desc AS 'CATEGORY', i.quantity AS 'QUANTITY', p.expiration_date AS 'EXPIRATION DATE' FROM category c JOIN product p ON p.product_category_id = c.product_category_id JOIN inventory i ON p.prod_inventory_id = i.prod_inventory_id";
            /* String buttons[] = {"OK"};
                int ch = JOptionPane.showOptionDialog(null,"Expired Product/s Deleted","OVERDUE PRODUCTS",JOptionPane.INFORMATION_MESSAGE,0,null,buttons,buttons[0]);
                if(ch == 0){
                    this.dispose();
                }*/
            JOptionPane.showMessageDialog(null, "Expired Product/s Removed from Sales","OVERDUE PRODUCTS",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }    
       }
    }//GEN-LAST:event_delButtonActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void FrameDraggerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_FrameDraggerMouseDragged

    private void FrameDraggerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FrameDraggerMousePressed


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
            java.util.logging.Logger.getLogger(expiredToday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(expiredToday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(expiredToday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(expiredToday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new expiredToday().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JButton delButton;
    private javax.swing.JTable expiredProducts;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton minimize;
    // End of variables declaration//GEN-END:variables
}
