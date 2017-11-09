package maripas.drug.store;

import com.sun.glass.events.KeyEvent;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.util.logging.*;
import java.util.Date;
import javax.imageio.ImageIO;

public class addStock extends javax.swing.JFrame {
    DateFormat df = DateFormat.getDateInstance();
    Connection conn = new DBConnection().connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String name, date;
    java.util.Date d;
    SimpleDateFormat f;
    int xMouse, yMouse;
    public addStock() {
        initComponents();
        IDGeneration();
        
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/maripasIcon.png")));
}
        catch (IOException exc) {
            exc.printStackTrace();
        }
        
    }
    void showDate(){
        d = new java.util.Date();
        f = new SimpleDateFormat("E MM-dd-yyyy");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prodID = new javax.swing.JTextField();
        prodID.setEditable(false);
        prodID.setEnabled(false);
        prodNameLabel = new javax.swing.JLabel();
        prodName = new javax.swing.JTextField();
        categoryName = new javax.swing.JComboBox<>();
        quantity = new javax.swing.JSpinner();
        dosage = new javax.swing.JTextField();
        dosageUnit = new javax.swing.JComboBox<>();
        purchasingPrice = new javax.swing.JTextField();
        sellingPrice = new javax.swing.JTextField();
        expirationDate = new com.toedter.calendar.JDateChooser();
        saveButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        close = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        help = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maripas Drug Store [ADD STOCK]");
        setLocation(new java.awt.Point(209, 40));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(950, 645));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        prodID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        prodID.setToolTipText("");
        prodID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prodID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        prodID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        prodID.setNextFocusableComponent(prodName);
        prodID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodIDActionPerformed(evt);
            }
        });
        prodID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prodIDKeyTyped(evt);
            }
        });
        getContentPane().add(prodID);
        prodID.setBounds(30, 180, 430, 40);

        prodNameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        prodNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        prodNameLabel.setText("PRODUCT NAME");
        getContentPane().add(prodNameLabel);
        prodNameLabel.setBounds(40, 250, 190, 20);

        prodName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        prodName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prodName.setNextFocusableComponent(purchasingPrice);
        prodName.setLayout(null);
        prodName.add(prodNameLabel);
        prodNameLabel.setBounds(10, 10, 200, 20);
        prodName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prodNameKeyTyped(evt);
            }
        });
        getContentPane().add(prodName);
        prodName.setBounds(30, 240, 430, 40);

        categoryName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        categoryName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Capsule", "Tablet", "Syrup" }));
        categoryName.setNextFocusableComponent(quantity);
        categoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryNameActionPerformed(evt);
            }
        });
        getContentPane().add(categoryName);
        categoryName.setBounds(640, 190, 160, 40);

        quantity.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        quantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quantity.setEditor(new javax.swing.JSpinner.NumberEditor(quantity, "0"));
        quantity.setNextFocusableComponent(dosage);
        getContentPane().add(quantity);
        quantity.setBounds(640, 240, 80, 40);

        dosage.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        dosage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dosage.setNextFocusableComponent(dosageUnit);
        getContentPane().add(dosage);
        dosage.setBounds(640, 290, 90, 40);

        dosageUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Milligram", "Gram" }));
        dosageUnit.setNextFocusableComponent(saveButton);
        getContentPane().add(dosageUnit);
        dosageUnit.setBounds(740, 300, 110, 24);

        purchasingPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        purchasingPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        purchasingPrice.setNextFocusableComponent(sellingPrice);
        purchasingPrice.setSelectionStart(20);
        getContentPane().add(purchasingPrice);
        purchasingPrice.setBounds(290, 300, 170, 30);

        sellingPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sellingPrice.setNextFocusableComponent(expirationDate);
        getContentPane().add(sellingPrice);
        sellingPrice.setBounds(290, 350, 170, 30);

        expirationDate.setDateFormatString("yyyy-MM-dd");
        expirationDate.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        expirationDate.setName(""); // NOI18N
        expirationDate.setNextFocusableComponent(categoryName);
        expirationDate.setPreferredSize(new java.awt.Dimension(20, 20));
        getContentPane().add(expirationDate);
        expirationDate.setBounds(240, 400, 220, 30);

        saveButton.setBackground(new java.awt.Color(255, 255, 255));
        saveButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 0, 0));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/saveButton.jpg"))); // NOI18N
        saveButton.setAlignmentY(0.0F);
        saveButton.setBorder(null);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setNextFocusableComponent(clearButton);
        saveButton.setRolloverEnabled(true);
        saveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/saveButtonHover.jpg"))); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(390, 500, 150, 60);

        clearButton.setBackground(new java.awt.Color(255, 255, 255));
        clearButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        clearButton.setForeground(new java.awt.Color(0, 0, 0));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clearButton.jpg"))); // NOI18N
        clearButton.setAlignmentY(0.0F);
        clearButton.setBorder(null);
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.setNextFocusableComponent(backButton);
        clearButton.setRolloverEnabled(true);
        clearButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/clearButtonHover.jpg"))); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(550, 500, 150, 60);

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        backButton.setForeground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backButton.jpg"))); // NOI18N
        backButton.setBorder(null);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setRolloverEnabled(true);
        backButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/backButtonHover.jpg"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(710, 500, 150, 60);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addStockForm.jpg"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
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

    private void prodIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodIDActionPerformed

    private void prodIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodIDKeyTyped
    }//GEN-LAST:event_prodIDKeyTyped

    private void prodNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodNameKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            prodNameLabel.setVisible(false);
        }
        else{
            if(prodName.getText().equals("")){
                prodNameLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_prodNameKeyTyped

    private void categoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryNameActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if(evt.getSource() == backButton){
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
    }//GEN-LAST:event_backButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        if(evt.getSource() == clearButton){
            prodName.setText(""); prodNameLabel.setVisible(true);
            categoryName.setSelectedIndex(0);
            quantity.setValue(0);
            dosage.setText("");
            dosageUnit.setSelectedIndex(0);
            purchasingPrice.setText("");
            sellingPrice.setText("");
            prodID.requestFocus();
        }
    }//GEN-LAST:event_clearButtonActionPerformed

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
                   prodID.requestFocus();
               }
    }//GEN-LAST:event_closeActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

//----------Adding Stock Start----------//
    String count = "SELECT COUNT(*) AS 'Total Row' FROM `product`";
    String idGeneration = "SELECT product_id FROM product";
    String colCount = "";
    int id = 0;
    public void IDGeneration(){
        try{
           ps = conn.prepareStatement(count);
           rs = ps.executeQuery();
            while(rs.next()){
                colCount = rs.getString(1);
                System.out.println(colCount);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(colCount.equals("0")){
             prodID.setText("1");
        }
        else{
            try{
            ps = conn.prepareStatement(idGeneration);
            rs = ps.executeQuery();
                if(rs.last()){
                    id = rs.getInt(1)+1;
                    prodID.setText(Integer.toString(id));
                }
            }
        catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);        
            }
        }
    }
               
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(evt.getSource() == saveButton){ 
            String sql = "INSERT INTO `product`(`product_id`,`product_desc`, `purchase_price`, `selling_price`,`dosage`) VALUES (?,?,?,?,?)";
            String sql1 = "INSERT INTO `category`(`product_id`, `product_category_desc`) VALUES (?,?)";
            String sql3 = "INSERT INTO `inventory`(`product_id`, `quantity`, `expiration_date`, `status`) VALUES (?,?,?,?)";
            String prodExists = "SELECT p.product_id, p.product_desc, c.product_category_desc FROM product p JOIN category c ON p.product_id = c.product_id WHERE p.product_desc = ?";
            String productInfoExists = "SELECT p.product_id, p.product_desc, i.expiration_date, c.product_category_desc FROM product p JOIN category c ON p.product_id = c.product_id JOIN inventory i ON i.product_id = p.product_id WHERE p.product_desc = ? AND i.expiration_date = ?";
            String expDate = df.format(expirationDate.getDate());
            String expp = ((JTextField)expirationDate.getDateEditor().getUiComponent()).getText();
            System.out.println("jcal"+expp);
            int existsID = 0;
        if(prodName.getText().equals("") || purchasingPrice.getText().equals("") || sellingPrice.getText().equals("") || categoryName.getSelectedIndex() == 0 || dosage.getText().equals("")){
                prodName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED)); purchasingPrice.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                sellingPrice.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED)); categoryName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED)); dosage.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                expirationDate.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));quantity.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));dosageUnit.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                String buttons[] = {"OK"};
                int ch = JOptionPane.showOptionDialog(null,"Kindly fill out all the fields","ADD STOCK",JOptionPane.OK_OPTION,0,null,buttons,buttons[0]);
                    if(ch == 0){
                        prodName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); purchasingPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                        sellingPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); categoryName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); dosage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                        expirationDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); quantity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); dosageUnit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    }//if(ch == ..end
        }//if(prodID.getText..end
        else{
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String current = sdf.format(d);
            System.out.println(current);
            Date date1 = null, date2 = null;
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
                int count = 0, count1  = 0;
                int product_category_id = 0, prod_inventory_id = 0, ctr = 0, ctr1 = 0, ctr2 = 0, idExistsCtr = 0, prodExistsCtr = 0, productInfoExistsCtr = 0;
                int ID = Integer.parseInt(prodID.getText());       double pPrice = Double.parseDouble(purchasingPrice.getText());
                String name = prodName.getText();   double sPrice = Double.parseDouble(sellingPrice.getText());
         
                int category = categoryName.getSelectedIndex(); String categ = "";
                    if(category == 1){
                        categ = "Capsule";
                    }
                    if(category == 2){
                        categ = "Tablet";
                    }
                    if(category == 3){
                        categ = "Syrup";
                    }
                int quan = (Integer) quantity.getValue();
                int dos = Integer.parseInt(dosage.getText());
                    try{
                        ps = conn.prepareStatement(productInfoExists);
                        ps.setString(1,name);
                        ps.setObject(2, ((JTextField)expirationDate.getDateEditor().getUiComponent()).getText());
                        rs = ps.executeQuery();
                            if(rs.next()){
                                productInfoExistsCtr++;
                            }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                if(productInfoExistsCtr >= 1){
                    JOptionPane.showMessageDialog(null, "Product already exists\n*To update product kindly open the Monitor Stock window","ADD STOCK", JOptionPane.WARNING_MESSAGE);
                }
                
                else{
                   try{
                        ps = conn.prepareStatement(prodExists);
                        ps.setString(1,name);
                        rs = ps.executeQuery();
                            if(rs.next()){
                                existsID = rs.getInt(1);
                                prodExistsCtr++;
                            }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
                    }
                
                
                if(prodExistsCtr >= 1){
                    try{
                        ps = conn.prepareStatement(sql3);
                  
                        ps.setInt(1, existsID);
                        ps.setInt(2, quan);
                        ps.setObject(3, ((JTextField)expirationDate.getDateEditor().getUiComponent()).getText());
                        ps.setString(4, "VALID");
                        ps.execute();
                        count++;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if(count >= 1){
                        JOptionPane.showMessageDialog(null, "New batch of "+name+" has been added to the database","Add Stock", JOptionPane.INFORMATION_MESSAGE);
                    }
                }//if(idExists..end
                
                else{
                    try{
                        ps = conn.prepareStatement(sql);
                  
                        ps.setInt(1, ID);
                        ps.setString(2, name);
                        ps.setDouble(3, pPrice);
                        ps.setDouble(4, sPrice);
                        ps.setInt(5, dos);
                        ps.execute();
                        ctr++;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
                    }
                    try{
                        ps = conn.prepareStatement(sql1);
                     
                        ps.setInt(1, ID);
                        ps.setString(2, categ);
                        ps.execute();
                        ctr1++;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
                    }
                    try{
                        ps = conn.prepareStatement(sql3);
                    
                        ps.setInt(1,ID);
                        ps.setInt(2, quan);
                        ps.setObject(3, ((JTextField)expirationDate.getDateEditor().getUiComponent()).getText());
                        ps.setString(4, "VALID");
                        ps.execute();
                        ctr2++;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                if((ctr >= 1 && ctr1 >= 1) && ctr2 >= 1){
                    JOptionPane.showMessageDialog(null, "Stock saved\nProduct ID: "+ID+"\nProduct Name: "+name+"\nCategory: "+categ+"\nPurchasing Price: "+pPrice+"\nSelling Price: "+sPrice+"\nQuantity: "+quan, "Add Stock", JOptionPane.INFORMATION_MESSAGE);
                    prodName.setText(""); prodNameLabel.setVisible(true);
                    categoryName.setSelectedIndex(0);
                    quantity.setValue(0);
                    dosage.setText("");
                    dosageUnit.setSelectedIndex(0);
                    purchasingPrice.setText("");
                    sellingPrice.setText("");
                    IDGeneration();
                }//if((ctr >= 1..end
                else{
                    JOptionPane.showMessageDialog(null, "Stock not saved", "Add Stock", JOptionPane.ERROR_MESSAGE);
                   }//else..end                   
                }//else (id is unique)end    
               }//else(name and exp date exists)
            }//else exp date invalid
           }//else (no blank fields)end
        }//if(evt.getSource.. end
    }//GEN-LAST:event_saveButtonActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        if(evt.getSource() == help){
            JOptionPane.showMessageDialog(null, "This form is for Adding new Items/stock to the sales.", "ADD STOCK [HELP]", JOptionPane.INFORMATION_MESSAGE);
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
//----------Adding Stock End----------//

    public static void main(String args[]) throws ParseException{
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
            }
        });
    }
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> categoryName;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton close;
    private javax.swing.JTextField dosage;
    private javax.swing.JComboBox<String> dosageUnit;
    private com.toedter.calendar.JDateChooser expirationDate;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton minimize;
    private javax.swing.JTextField prodID;
    private javax.swing.JTextField prodName;
    private javax.swing.JLabel prodNameLabel;
    private javax.swing.JTextField purchasingPrice;
    private javax.swing.JSpinner quantity;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField sellingPrice;
    // End of variables declaration//GEN-END:variables
}