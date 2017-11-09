package maripas.drug.store;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class salesHistory extends javax.swing.JFrame {
    Connection conn = DBConnection.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    DefaultTableModel dm;
    int xMouse, yMouse;
    public salesHistory() {
        initComponents();
        fetch();
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

        lbl = new javax.swing.JLabel();
        help = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        search.requestFocus(true);
        search.setLayout(null);
        search.add(lbl);
        search.setBounds(5, 2, 100, 20);
        minimize = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesHistoTable = new javax.swing.JTable();
        viewButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        backButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(209, 40));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(950, 645));
        getContentPane().setLayout(null);

        lbl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl.setForeground(new java.awt.Color(102, 102, 102));
        lbl.setText("CUSTOMER NAME");
        getContentPane().add(lbl);
        lbl.setBounds(360, 180, 170, 20);

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButton.jpg"))); // NOI18N
        help.setToolTipText("Help");
        help.setRolloverEnabled(true);
        help.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButtonHover.jpg"))); // NOI18N
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        getContentPane().add(help);
        help.setBounds(800, 0, 50, 42);

        search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(350, 170, 260, 40);

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
        minimize.setBounds(850, 0, 50, 42);

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xButton.jpg"))); // NOI18N
        close.setToolTipText("Close");
        close.setRolloverEnabled(true);
        close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/xButtonHover.jpg"))); // NOI18N
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(900, 0, 50, 42);

        salesHistoTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        salesHistoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Date", "Product Name", "Quantity", "Gross Total", "Change"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesHistoTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesHistoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesHistoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(salesHistoTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 220, 890, 260);

        viewButton.setBackground(new java.awt.Color(255, 255, 255));
        viewButton.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        viewButton.setForeground(new java.awt.Color(0, 0, 0));
        viewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewButton.jpg"))); // NOI18N
        viewButton.setAlignmentY(0.0F);
        viewButton.setBorder(null);
        viewButton.setRolloverEnabled(true);
        viewButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/viewButtonHover.jpg"))); // NOI18N
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewButton);
        viewButton.setBounds(390, 540, 150, 60);

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deleteButton.jpg"))); // NOI18N
        deleteButton.setBorder(null);
        deleteButton.setRolloverEnabled(true);
        deleteButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/deleteButtonHover.jpg"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(550, 540, 150, 60);

        backButton3.setBackground(new java.awt.Color(255, 255, 255));
        backButton3.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        backButton3.setForeground(new java.awt.Color(0, 0, 0));
        backButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backButton.jpg"))); // NOI18N
        backButton3.setAlignmentY(0.0F);
        backButton3.setBorder(null);
        backButton3.setRolloverEnabled(true);
        backButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/backButtonHover.jpg"))); // NOI18N
        backButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(backButton3);
        backButton3.setBounds(710, 540, 150, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transactionHistoryFormFLAT.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 950, 645);

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
        FrameDragger.setBounds(0, 0, 800, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fetch(){
        String selectData = "SELECT c.customer_id AS 'ID', c.name AS 'NAME', t.items_bought AS 'ITEM X QUANTITY',t.subtotal AS 'SUBTOTAL',t.discount AS 'DISCOUNT',t.gross_total AS 'GROSS TOTAL',t.date_of_purchase AS 'DATE OF PURCHASE' FROM customer c JOIN transaction t ON c.trans_id = t.trans_id";
        try{
            ps = conn.prepareStatement(selectData);
            rs = ps.executeQuery();
            salesHistoTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Maripas Drug Store",JOptionPane.YES_NO_OPTION);
        if(choice == 0){
            close();
            
            String delTempUser = "DELETE FROM tempadmin";
                            
                                try{
                                    ps = conn.prepareStatement(delTempUser);
                                    ps.execute();
                                }
                                catch(Exception e){
                                    JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
                                }
        }
        else{
            search.requestFocus();
        }
    }//GEN-LAST:event_closeActionPerformed

    private void backButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton3ActionPerformed
        if(evt.getSource() == backButton3){
            this.dispose();
            LogIn log = new LogIn();
            log.Menu();
            String getID = "SELECT tempID FROM tempadmin";
            String admin = "";
        
            try{
                ps = conn.prepareStatement(getID);
                rs = ps.executeQuery();
                if(rs.next()){
                    admin = rs.getString(1);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
            }
            log.adminInfo(admin);
        }
    }//GEN-LAST:event_backButton3ActionPerformed
    String ID, name, items, sub, vatEx, vat, disc, gross, date;
    private void salesHistoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesHistoTableMouseClicked
        int i = salesHistoTable.getSelectedRow();
        TableModel model = salesHistoTable.getModel();
        ID = (model.getValueAt(i, 0).toString());
        name = (model.getValueAt(i, 1).toString());
        items = (model.getValueAt(i, 2).toString());
        sub = (model.getValueAt(i, 3).toString());
        disc = (model.getValueAt(i, 4).toString());
        gross = (model.getValueAt(i, 5).toString());
        date = (model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_salesHistoTableMouseClicked

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        JOptionPane.showMessageDialog(null, "ID: "+ID+"\nName: "+name+"\nItems: "+items+"\nSubtotal: "+sub+"\nDiscount: "+disc+"\nGross Total: "+gross+"\nDate of Purchase: "+date,"Transaction History",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_viewButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
               if(evt.getSource() == deleteButton){
          String deleteTrans = "DELETE FROM `transaction` WHERE `trans_id` = ?";
       String deleteCust = "DELETE FROM `customer` WHERE `trans_id` = ?";
       
        int  i = salesHistoTable.getSelectedRow();
        TableModel model = salesHistoTable.getModel();
        String idDelete = (model.getValueAt(i, 0).toString());
        int ctr = 0, ctr1 = 0;
        String options[] = {"Yes", "No"};
        int choice = JOptionPane.showOptionDialog(null,"Are you sure you want to delete this history?", "Transaction History", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
        if(choice == 0){
           

        try{
            ps = conn.prepareStatement(deleteCust);
            ps.setString(1,idDelete);
            ps.execute();
            ctr1++;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"2Exception Error", JOptionPane.ERROR_MESSAGE);
        }
        try{
            ps = conn.prepareStatement(deleteTrans);
            ps.setString(1,idDelete);
            ps.execute();
            ctr++;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"1Exception Error", JOptionPane.ERROR_MESSAGE);
        }
        
                if(ctr >= 1 && ctr1 >= 1){
            
            JOptionPane.showMessageDialog(null, "Transaction History Deleted","Transaction History", JOptionPane.INFORMATION_MESSAGE);
            String selectData = "SELECT c.customer_id AS 'ID', c.name AS 'NAME', t.items_bought AS 'ITEM X QUANTITY',t.subtotal AS 'SUBTOTAL',t.discount AS 'DISCOUNT',t.gross_total AS 'GROSS TOTAL',t.date_of_purchase AS 'DATE OF PURCHASE' FROM customer c JOIN transaction t ON c.trans_id = t.trans_id";
                try{
            ps = conn.prepareStatement(selectData);
            rs = ps.executeQuery();
            salesHistoTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"3Exception Error", JOptionPane.ERROR_MESSAGE);
        }  
       }
    }
        else{
            
        } 
       }  
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        if(evt.getSource() == help){
            JOptionPane.showMessageDialog(null, "You can view your Sales History by accessing this form. \nIt can help you see when someone is returning\nsome medicine if he/she really bought it here\nyou can even see the date of purchase\nto know whether the returned medicine is\nwithin the allotted time available for return.", "SALES HISTORY [HELP]", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_helpActionPerformed

    private void filter(String query){
        dm = (DefaultTableModel) salesHistoTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (dm);
        salesHistoTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACK_SPACE){
            lbl.setVisible(false);
        }
        else{
            if(search.getText().equals("")){
            lbl.setVisible(true);
            } 
        }
        String query = search.getText();
        filter(query);
    }//GEN-LAST:event_searchKeyTyped

    private void FrameDraggerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_FrameDraggerMouseDragged

    private void FrameDraggerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FrameDraggerMousePressed

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
            java.util.logging.Logger.getLogger(salesHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salesHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salesHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salesHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new salesHistory().setVisible(true);
            }
        });
    }
    
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JButton backButton3;
    private javax.swing.JButton close;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JButton minimize;
    private javax.swing.JTable salesHistoTable;
    private javax.swing.JTextField search;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
