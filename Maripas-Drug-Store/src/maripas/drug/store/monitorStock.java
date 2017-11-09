package maripas.drug.store;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;
import java.text.*;
import java.util.logging.*;
import javax.imageio.*;

public class monitorStock extends javax.swing.JFrame {
    DateFormat df = DateFormat.getDateInstance();
    Connection conn = DBConnection.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    DefaultTableModel dm;
    int xMouse, yMouse;
    public monitorStock() {
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
        search = new javax.swing.JTextField();
        search.requestFocus(true);
        search.setLayout(null);
        search.add(lbl);
        search.setBounds(5, 2, 100, 20);
        jScrollPane1 = new javax.swing.JScrollPane();
        productInfo = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        backButton3 = new javax.swing.JButton();
        help = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        close = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        descLabel = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        dosageLabel = new javax.swing.JLabel();
        dosage = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        categoryLabel = new javax.swing.JLabel();
        quantity = new javax.swing.JSpinner();
        quantityLabel = new javax.swing.JLabel();
        expirationdate = new com.toedter.calendar.JDateChooser();
        expirationdateLabel = new javax.swing.JLabel();
        expirationdateLabel1 = new javax.swing.JLabel();
        invID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maripas Drug Store [MONITOR STOCK]");
        setLocation(new java.awt.Point(209, 40));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(950, 645));
        setSize(new java.awt.Dimension(950, 645));
        getContentPane().setLayout(null);

        lbl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl.setForeground(new java.awt.Color(102, 102, 102));
        lbl.setText("PRODUCT NAME");
        getContentPane().add(lbl);
        lbl.setBounds(345, 335, 120, 20);

        search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search.setNextFocusableComponent(search);
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(340, 330, 270, 30);

        productInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        productInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Title 2", "Product Name", "Price", "Dosage", "Category", "Quantity", "Expiration Date", "Title 9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productInfo.setNextFocusableComponent(updateButton);
        productInfo.getTableHeader().setReorderingAllowed(false);
        productInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productInfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 370, 890, 180);

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 0, 0));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updateButton.jpg"))); // NOI18N
        updateButton.setAlignmentY(0.0F);
        updateButton.setBorder(null);
        updateButton.setNextFocusableComponent(deleteButton);
        updateButton.setRolloverEnabled(true);
        updateButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/updateButtonHover.jpg"))); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(220, 581, 150, 60);

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deleteButton.jpg"))); // NOI18N
        deleteButton.setBorder(null);
        deleteButton.setNextFocusableComponent(backButton3);
        deleteButton.setRolloverEnabled(true);
        deleteButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/deleteButtonHover.jpg"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(396, 581, 150, 60);

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
        backButton3.setBounds(570, 581, 150, 60);

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

        id.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(id);
        id.setBounds(130, 173, 190, 30);

        idLabel.setBackground(new java.awt.Color(255, 255, 255));
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("PRODUCT ID");
        getContentPane().add(idLabel);
        idLabel.setBounds(24, 180, 90, 15);
        getContentPane().add(desc);
        desc.setBounds(130, 224, 190, 30);

        descLabel.setBackground(new java.awt.Color(255, 255, 255));
        descLabel.setForeground(new java.awt.Color(255, 255, 255));
        descLabel.setText("PRODUCT NAME");
        getContentPane().add(descLabel);
        descLabel.setBounds(24, 230, 140, 15);
        getContentPane().add(price);
        price.setBounds(130, 274, 190, 30);

        priceLabel.setBackground(new java.awt.Color(255, 255, 255));
        priceLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel.setText("PRICE");
        getContentPane().add(priceLabel);
        priceLabel.setBounds(24, 280, 90, 15);

        dosageLabel.setBackground(new java.awt.Color(255, 255, 255));
        dosageLabel.setForeground(new java.awt.Color(255, 255, 255));
        dosageLabel.setText("DOSAGE");
        getContentPane().add(dosageLabel);
        dosageLabel.setBounds(364, 180, 50, 15);
        getContentPane().add(dosage);
        dosage.setBounds(460, 173, 170, 30);

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capsule", "Tablet", "Syrup" }));
        getContentPane().add(category);
        category.setBounds(460, 224, 170, 30);

        categoryLabel.setBackground(new java.awt.Color(255, 255, 255));
        categoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        categoryLabel.setText("CATEGORY");
        getContentPane().add(categoryLabel);
        categoryLabel.setBounds(364, 230, 120, 15);

        quantity.setModel(new javax.swing.SpinnerNumberModel());
        getContentPane().add(quantity);
        quantity.setBounds(460, 274, 60, 30);

        quantityLabel.setBackground(new java.awt.Color(255, 255, 255));
        quantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        quantityLabel.setText("QUANTITY");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(364, 280, 60, 15);

        expirationdate.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(expirationdate);
        expirationdate.setBounds(780, 173, 140, 30);

        expirationdateLabel.setBackground(new java.awt.Color(255, 255, 255));
        expirationdateLabel.setForeground(new java.awt.Color(255, 255, 255));
        expirationdateLabel.setText("INVENTORY ID");
        getContentPane().add(expirationdateLabel);
        expirationdateLabel.setBounds(710, 280, 100, 15);

        expirationdateLabel1.setBackground(new java.awt.Color(255, 255, 255));
        expirationdateLabel1.setForeground(new java.awt.Color(255, 255, 255));
        expirationdateLabel1.setText("EXPIRATION DATE");
        getContentPane().add(expirationdateLabel1);
        expirationdateLabel1.setBounds(660, 180, 110, 15);
        getContentPane().add(invID);
        invID.setBounds(820, 270, 40, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitorStockFormFLAT.jpg"))); // NOI18N
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
        String selectData = "SELECT p.product_id AS 'PRODUCT ID', i.prod_inventory_id AS 'INVENTORY ID', p.product_desc AS 'PRODUCT NAME', p.selling_price AS 'PRICE', p.dosage AS 'DOSAGE', c.product_category_desc AS 'CATEGORY', i.quantity AS 'QUANTITY', i.expiration_date AS 'EXPIRATION DATE' , i.status AS 'VALIDITY STATUS' FROM category c JOIN product p ON p.product_id = c.product_id JOIN inventory i ON p.product_id = i.product_id ORDER BY p.product_id ASC";
        try{
            ps = conn.prepareStatement(selectData);
            rs = ps.executeQuery();
            productInfo.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
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

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void miniActionPerformed(java.awt.event.ActionEvent evt) {                                         
        update.setState(ICONIFIED);
    }
    
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

    private void closActionPerformed(java.awt.event.ActionEvent evt) {                                      
        update.dispose();
    }
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(evt.getSource() == updateButton){
           String productInfoExists = "SELECT product_id, expiration_date FROM inventory WHERE (product_id = ? AND expiration_date = ?) AND prod_inventory_id <> ?"; 
           String getID = "SELECT prod_inventory_id FROM inventory WHERE product_id = ? AND expiration_date = ?";
           String updateProduct = "UPDATE `product` SET `product_desc`=(?),`selling_price`=(?),`dosage`=(?) WHERE `product_id` = (?)";
           String updateInventory = "UPDATE `inventory` SET `quantity`=(?), `expiration_date`=(?), `status`=(?) WHERE `prod_inventory_id` = (?)";
           String updateCategory = "UPDATE `category` SET `product_category_desc`=(?) WHERE `product_category_id` = (?)";
           int prodInfoExistsCtr = 0;
        if(desc.getText().equals("") || price.getText().equals("") || dosage.getText().equals("")){
                desc.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED)); price.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                category.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED)); dosage.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                expirationdate.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));quantity.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                String buttons[] = {"OK"};
                int ch = JOptionPane.showOptionDialog(null,"Kindly fill out all the fields","ADD STOCK",JOptionPane.OK_OPTION,0,null,buttons,buttons[0]);
                    if(ch == 0){
                        desc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); price.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                        category.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));quantity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                        dosage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));expirationdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));     
                    }//if(ch == ..end
        }//if(prodID.getText..end
        else{
            String expp = ((JTextField)expirationdate.getDateEditor().getUiComponent()).getText();
            java.util.Date d = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String current = sdf.format(d);
            java.util.Date date1 = null, date2 = null;
                int  i = productInfo.getSelectedRow();
                TableModel model = productInfo.getModel();
                double newPrice = Double.parseDouble(price.getText()); String newDesc = desc.getText();
                String iddd = id.getText(); Double dos = Double.parseDouble(dosage.getText()); 
                String date = (model.getValueAt(i, 7).toString()); String prodInvID = invID.getText(); 
                int quan = (Integer) quantity.getValue();
                int ctr = 0, ctr1 = 0, ctr2 = 0, prodCtr = 0;
                int categoryIndex = category.getSelectedIndex(); String categ = "";
                    if(categoryIndex == 0){
                        categ = "Capsule";
                    }
                    if(categoryIndex == 1){
                        categ = "Tablet";
                    }
                    if(categoryIndex == 2){
                        categ = "Syrup";
                    }
                try {
                    date1 = sdf.parse(current);
                } catch (ParseException ex) {
                    Logger.getLogger(addStock.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    date2 = sdf.parse(expp);
                } catch (ParseException ex) {
                    Logger.getLogger(addStock.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(current);
            if(date1.after(date2) || date1.equals(date2)){
                JOptionPane.showMessageDialog(null, "Invalid date input","ADD STOCK", JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                try{
                    ps = conn.prepareStatement(productInfoExists);
                    ps.setString(1, iddd);
                    ps.setObject(2, ((JTextField)expirationdate.getDateEditor().getUiComponent()).getText());
                    ps.setString(3, prodInvID);
                    System.out.println(iddd);
                    System.out.println(date);
                    System.out.println(prodInvID);
                    rs = ps.executeQuery();
                     if(rs.next()){
                         prodCtr++;
                     }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                if(prodCtr >= 1){
                    JOptionPane.showMessageDialog(null, "Product Exists", "hashhd", JOptionPane.WARNING_MESSAGE);
                }
                else{
                   
                    try{ 
                        ps = conn.prepareStatement(updateProduct);
                        ps.setString(1, newDesc);
                        ps.setDouble(2, newPrice);
                        ps.setDouble(3, dos);
                        ps.setString(4, iddd);
                        ps.execute();
                        ctr++;
          
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
        
                    try{
                        ps = conn.prepareStatement(updateInventory);
                        ps.setInt(1, quan);
                        ps.setObject(2, ((JTextField)expirationdate.getDateEditor().getUiComponent()).getText());
                        ps.setString(3, "VALID");
                        
                        ps.setString(4, prodInvID);
                        ps.execute();
                        ctr1++;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    try{
                        ps = conn.prepareStatement(updateCategory);
                        ps.setString(1, categ);
                        ps.setString(2, iddd);
                        ps.execute();
                        ctr2++;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                        if(ctr >= 1 && ctr1 >= 1 && ctr2 >= 1){
                            String selectData = "SELECT p.product_id AS 'PRODUCT ID', i.prod_inventory_id AS 'INVENTORY ID', p.product_desc AS 'PRODUCT NAME', p.selling_price AS 'PRICE', p.dosage AS 'DOSAGE', c.product_category_desc AS 'CATEGORY', i.quantity AS 'QUANTITY', i.expiration_date AS 'EXPIRATION DATE' , i.status AS 'VALIDITY STATUS' FROM category c JOIN product p ON p.product_id = c.product_id JOIN inventory i ON p.product_id = i.product_id ORDER BY p.product_id ASC";
                            JOptionPane.showMessageDialog(null, "Product Updated","Update Product", JOptionPane.INFORMATION_MESSAGE);
                                try{
                                    ps = conn.prepareStatement(selectData);
                                    rs = ps.executeQuery();
                                    productInfo.setModel(DbUtils.resultSetToTableModel(rs));
                                }
                                catch(Exception e){
                                    JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
                                }
                        }  
                }
                
            //if prod exists...end
          }//if(invalid date...end
        }//else end.. 
      }//if(evt...end
    }//GEN-LAST:event_updateButtonActionPerformed

    private void productInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productInfoMouseClicked
        int  i = productInfo.getSelectedRow();
        id.setEditable(false);
        id.setEnabled(false);
        invID.setEditable(false);
        invID.setEnabled(false);
        TableModel model = productInfo.getModel();
        id.setText(model.getValueAt(i, 0).toString());
        invID.setText(model.getValueAt(i, 1).toString());
        desc.setText(model.getValueAt(i, 2).toString());
        price.setText(model.getValueAt(i, 3).toString());
        dosage.setText(model.getValueAt(i, 4).toString());
        String cate = (model.getValueAt(i, 5).toString());
        if(cate.equals("Capsule")){
            category.setSelectedIndex(0);
        }
        if(cate.equals("Tablet")){
            category.setSelectedIndex(1);
        }
        if(cate.equals("Syrup")){
            category.setSelectedIndex(2);
        }
        int quant = Integer.parseInt(model.getValueAt(i, 6).toString());
        quantity.setValue(quant);
        String date = (model.getValueAt(i, 7).toString());
        java.util.Date dateVal = null;
        try {
            dateVal = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(monitorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        expirationdate.setDate(dateVal);
        
    }//GEN-LAST:event_productInfoMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
       if(evt.getSource() == deleteButton){
          String deleteProduct = "DELETE FROM `product` WHERE `product_id` = ?";
       String deleteCategory = "DELETE FROM `category` WHERE `product_id` = ?";
       String deleteInventory = "DELETE FROM `inventory` WHERE `prod_inventory_id` = ?";
        int  i = productInfo.getSelectedRow();
        TableModel model = productInfo.getModel();
        String idDelete = (model.getValueAt(i, 0).toString());
        String name = (model.getValueAt(i, 2).toString());
        int ctr = 0, ctr1 = 0, ctr2 = 0;
        String options[] = {"Yes", "No"};
        int choice = JOptionPane.showOptionDialog(null,"Are you sure you want to delete "+name+" ?", "Delete Product", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
        if(choice == 0){
        /*try{
            ps = conn.prepareStatement(deleteProduct);
            ps.setString(1,idDelete);
            ps.execute();
            ctr++;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
        try{
            ps = conn.prepareStatement(deleteInventory);
            ps.setString(1,invID.getText());
            ps.execute();
            ctr2++;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        /*try{
            ps = conn.prepareStatement(deleteCategory);
            ps.setString(1,idDelete);
            ps.execute();
            ctr1++;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
        
        
                if(ctr2 >= 1){
            String selectData = "SELECT p.product_id AS 'PRODUCT ID', i.prod_inventory_id AS 'INVENTORY ID', p.product_desc AS 'PRODUCT NAME', p.selling_price AS 'PRICE', p.dosage AS 'DOSAGE', c.product_category_desc AS 'CATEGORY', i.quantity AS 'QUANTITY', i.expiration_date AS 'EXPIRATION DATE' , i.status AS 'VALIDITY STATUS' FROM category c JOIN product p ON p.product_id = c.product_id JOIN inventory i ON p.product_id = i.product_id ORDER BY p.product_id ASC";
            JOptionPane.showMessageDialog(null, "Product Deleted","Delete Product", JOptionPane.INFORMATION_MESSAGE);
            try{
            ps = conn.prepareStatement(selectData);
            rs = ps.executeQuery();
            productInfo.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }
       }
    }
        else{
            
        } 
       }  
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void filter(String query){
        dm = (DefaultTableModel) productInfo.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (dm);
        productInfo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
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
    }//GEN-LAST:event_searchKeyReleased

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        if(evt.getSource() == help){
            JOptionPane.showMessageDialog(null, "Use this form to see the remaining stock \nand expiration dates of the medicines.\nInside the Monitor Stock is the update button \nwhere you can update the medicine name, \nprice, etc and the delete button to \ndelete unwanted stocks", "MONITOR STOCK [HELP]", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_helpActionPerformed

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
    public static void main(String args[]) throws ParseException{
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
            java.util.logging.Logger.getLogger(monitorStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(monitorStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(monitorStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(monitorStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new monitorStock().setVisible(true);
            }
        });
    }

    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    JFrame update = new JFrame("Update");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JButton backButton3;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton close;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField desc;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextField dosage;
    private javax.swing.JLabel dosageLabel;
    private com.toedter.calendar.JDateChooser expirationdate;
    private javax.swing.JLabel expirationdateLabel;
    private javax.swing.JLabel expirationdateLabel1;
    private javax.swing.JButton help;
    private javax.swing.JTextField id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField invID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JButton minimize;
    private javax.swing.JTextField price;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTable productInfo;
    private javax.swing.JSpinner quantity;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField search;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
