package maripas.drug.store;

import com.sun.glass.events.KeyEvent;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.table.*;

public class pointOfSale extends javax.swing.JFrame implements Printable, ActionListener{
    Connection conn = DBConnection.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int xMouse, yMouse;
    public pointOfSale() {
        initComponents();
        items();
        IDGeneration();
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

        discount = new javax.swing.ButtonGroup();
        customerID = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        name.setLayout(null);
        name.add(nameLabel);
        nameLabel.setBounds(5, 20, 100, 20);
        productName = new javax.swing.JComboBox<>();
        quantity = new javax.swing.JSpinner();
        undoButton = new javax.swing.JButton();
        addItemButton = new javax.swing.JButton();
        nDis = new javax.swing.JRadioButton();
        wDis = new javax.swing.JRadioButton();
        subtotal = new javax.swing.JTextField();
        subtotal.setEditable(false);
        grossTotal = new javax.swing.JTextField();
        amtReceived = new javax.swing.JTextField();
        change = new javax.swing.JTextField();
        change.setEditable(false);
        calcButton = new javax.swing.JButton();
        proceed = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        help = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsSelected = new JList(itemList);
        jScrollPane1 = new javax.swing.JScrollPane();
        subTotalList = new JList(subList);
        jScrollPane3 = new javax.swing.JScrollPane();
        quantityList = new JList(quanList);
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        discount.add(nDis);
        discount.add(wDis);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maripas Drug Store [POINT OF SALE]");
        setLocation(new java.awt.Point(209, 40));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(950, 645));
        setResizable(false);
        getContentPane().setLayout(null);

        customerID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        customerID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        customerID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        customerID.setNextFocusableComponent(name);
        customerID.setEditable(false);
        customerID.setEnabled(false);
        customerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customerIDKeyTyped(evt);
            }
        });
        getContentPane().add(customerID);
        customerID.setBounds(40, 220, 400, 40);

        nameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(102, 102, 102));
        nameLabel.setText("NAME");
        getContentPane().add(nameLabel);
        nameLabel.setBounds(50, 280, 140, 20);

        name.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        name.setNextFocusableComponent(productName);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(40, 270, 400, 40);

        productName.setNextFocusableComponent(quantity);
        productName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameActionPerformed(evt);
            }
        });
        getContentPane().add(productName);
        productName.setBounds(140, 320, 150, 24);

        quantity.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        quantity.setBorder(null);
        quantity.setNextFocusableComponent(undoButton);
        getContentPane().add(quantity);
        quantity.setBounds(370, 320, 50, 30);

        undoButton.setBackground(new java.awt.Color(255, 255, 255));
        undoButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        undoButton.setForeground(new java.awt.Color(0, 0, 0));
        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/undoButton.jpg"))); // NOI18N
        undoButton.setAlignmentY(0.0F);
        undoButton.setBorder(null);
        undoButton.setNextFocusableComponent(subtotal);
        undoButton.setRolloverEnabled(true);
        undoButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/undoButtonHover.jpg"))); // NOI18N
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(undoButton);
        undoButton.setBounds(250, 385, 130, 50);

        addItemButton.setBackground(new java.awt.Color(255, 255, 255));
        addItemButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        addItemButton.setForeground(new java.awt.Color(0, 0, 0));
        addItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addItemButton.jpg"))); // NOI18N
        addItemButton.setToolTipText("");
        addItemButton.setAlignmentY(0.0F);
        addItemButton.setBorder(null);
        addItemButton.setNextFocusableComponent(addItemButton);
        addItemButton.setRolloverEnabled(true);
        addItemButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/addItemButtonHover.jpg"))); // NOI18N
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addItemButton);
        addItemButton.setBounds(80, 385, 130, 50);

        nDis.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nDis.setForeground(new java.awt.Color(255, 255, 255));
        nDis.setText("No Discount");
        nDis.setToolTipText("");
        nDis.setNextFocusableComponent(grossTotal);
        nDis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nDisItemStateChanged(evt);
            }
        });
        nDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nDisActionPerformed(evt);
            }
        });
        getContentPane().add(nDis);
        nDis.setBounds(750, 296, 130, 30);

        wDis.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        wDis.setForeground(new java.awt.Color(255, 255, 255));
        wDis.setText("With Discount");
        wDis.setToolTipText("");
        wDis.setNextFocusableComponent(nDis);
        wDis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wDisItemStateChanged(evt);
            }
        });
        wDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wDisActionPerformed(evt);
            }
        });
        getContentPane().add(wDis);
        wDis.setBounds(550, 296, 130, 30);

        subtotal.setBackground(new java.awt.Color(0, 0, 0));
        subtotal.setFont(new java.awt.Font("Dialog", 0, 34)); // NOI18N
        subtotal.setForeground(new java.awt.Color(51, 204, 0));
        subtotal.setText("0");
        subtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        subtotal.setNextFocusableComponent(wDis);
        subtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                subtotalKeyTyped(evt);
            }
        });
        getContentPane().add(subtotal);
        subtotal.setBounds(580, 210, 350, 40);

        grossTotal.setEditable(false);
        grossTotal.setBackground(new java.awt.Color(0, 0, 0));
        grossTotal.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        grossTotal.setForeground(new java.awt.Color(51, 204, 0));
        grossTotal.setText("0");
        grossTotal.setToolTipText("");
        grossTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        grossTotal.setNextFocusableComponent(amtReceived);
        grossTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grossTotalActionPerformed(evt);
            }
        });
        grossTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                grossTotalKeyTyped(evt);
            }
        });
        getContentPane().add(grossTotal);
        grossTotal.setBounds(680, 355, 250, 30);

        amtReceived.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        amtReceived.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        amtReceived.setNextFocusableComponent(calcButton);
        amtReceived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amtReceivedKeyTyped(evt);
            }
        });
        getContentPane().add(amtReceived);
        amtReceived.setBounds(680, 400, 250, 30);

        change.setBackground(new java.awt.Color(0, 0, 0));
        change.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        change.setForeground(new java.awt.Color(51, 204, 0));
        change.setText("0");
        change.setToolTipText("");
        change.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        change.setNextFocusableComponent(proceed);
        getContentPane().add(change);
        change.setBounds(680, 497, 250, 30);

        calcButton.setBackground(new java.awt.Color(255, 255, 255));
        calcButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        calcButton.setForeground(new java.awt.Color(0, 0, 0));
        calcButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calcButton.jpg"))); // NOI18N
        calcButton.setAlignmentY(0.0F);
        calcButton.setBorder(null);
        calcButton.setNextFocusableComponent(change);
        calcButton.setRolloverEnabled(true);
        calcButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/calcButtonHover.jpg"))); // NOI18N
        calcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonActionPerformed(evt);
            }
        });
        getContentPane().add(calcButton);
        calcButton.setBounds(717, 442, 180, 40);

        proceed.setBackground(new java.awt.Color(255, 255, 255));
        proceed.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        proceed.setForeground(new java.awt.Color(0, 0, 0));
        proceed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proceedButton.jpg"))); // NOI18N
        proceed.setAlignmentY(0.0F);
        proceed.setBorder(null);
        proceed.setNextFocusableComponent(backButton);
        proceed.setRolloverEnabled(true);
        proceed.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/proceedButtonHover.jpg"))); // NOI18N
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        getContentPane().add(proceed);
        proceed.setBounds(520, 560, 180, 60);

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        backButton.setForeground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backButton2.jpg"))); // NOI18N
        backButton.setAlignmentY(0.0F);
        backButton.setBorder(null);
        backButton.setRolloverEnabled(true);
        backButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/backButtonHover2.jpg"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(725, 560, 180, 60);

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

        itemsSelected.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(itemsSelected);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 470, 160, 131);

        subTotalList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(subTotalList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 470, 130, 130);

        quantityList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(quantityList);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(220, 470, 70, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salesFormFLAT.jpg"))); // NOI18N
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

    public void items(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = (f.format(d));
        String addItems = "SELECT DISTINCT p.product_desc FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE (i.quantity > 0 AND (i.expiration_date NOT BETWEEN ? AND ?)) AND i.status = ?";
        try{
            ps = conn.prepareStatement(addItems);
            ps.setString(1,"0001-01-01");
            ps.setString(2, dateToday);
            ps.setString(3, "VALID");
            rs = ps.executeQuery();
           while(rs.next()){
               productName.addItem(rs.getString(1));
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    String count = "SELECT COUNT(*) AS 'Total Row' FROM `customer`";
    String idGeneration = "SELECT customer_id FROM customer";
    String colCount = "";
    int id = 0;
    public void IDGeneration(){
        try{
           ps = conn.prepareStatement(count);
           rs = ps.executeQuery();
            while(rs.next()){
                colCount = rs.getString(1);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(colCount.equals("0")){
             customerID.setText("1");
        }
        else{
            try{
            ps = conn.prepareStatement(idGeneration);
            rs = ps.executeQuery();
                if(rs.last()){
                    id = rs.getInt(1)+1;
                    customerID.setText(Integer.toString(id));
                }
            }
        catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);        
            }
        }
    }


    
    private void customerIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerIDKeyTyped

    }//GEN-LAST:event_customerIDKeyTyped

    private void grossTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grossTotalKeyTyped
    }//GEN-LAST:event_grossTotalKeyTyped

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
            if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            nameLabel.setVisible(false);
        }
        else{
            if(name.getText().equals("")){
            nameLabel.setVisible(true);
         }
        }
    }//GEN-LAST:event_nameKeyTyped

    private void nDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nDisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nDisActionPerformed

    private void wDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wDisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wDisActionPerformed

    private void subtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalKeyTyped

    private void amtReceivedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amtReceivedKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_amtReceivedKeyTyped

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

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void grossTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grossTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grossTotalActionPerformed

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
            customerID.requestFocus();
        }
    }//GEN-LAST:event_closeActionPerformed

    private void productNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameActionPerformed
            double newAmount = 0, amount = 0, temp = 0;
            int ctr = 0, ctr1 = 0, ctr2 = 0, ctr3 = 0, prod_ID = 0, newQuan = 0;
            String item = "", prod_IDString = "", prodInvIDString = "", stringQuan = "";
            String updateQuantity = "UPDATE `inventory` SET `quantity`= (?) WHERE `prod_inventory_id` = (?)";
            String getID = "SELECT p.product_id FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE product_desc = ?";
            String getPrice = "SELECT p.selling_price, i.quantity FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE product_desc = ?";
            String getInvID = "SELECT prod_inventory_id, quantity FROM inventory WHERE (product_id = ? AND quantity > 0) AND status = ? ORDER BY expiration_date ASC";
            
            
    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        if(evt.getSource() == addItemButton){        
            item = (String)productName.getSelectedItem();
            String sell_price = "", remainingQuantity = "";
            
                try{
                    ps = conn.prepareStatement(getPrice);
                    ps.setString(1,item);
                    rs = ps.executeQuery();
                        while(rs.next()){
                            sell_price = rs.getString(1);
                        }//while(rs..end
                    }//try..end
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
                }//catch(..end
            
                
            int quantityValue = (Integer) quantity.getValue();
            double price = Double.parseDouble(sell_price);
            
            amount = price * quantityValue;
            temp = price * quantityValue;
            String amnSt = Double.toString(temp);
            //int nQuan = remQuan - quantityValue;
            
                    try{
                        ps = conn.prepareStatement(getID);
                        ps.setString(1,item);
                        rs = ps.executeQuery();
                            if(rs.next()){
                                prod_IDString = rs.getString(1);
                            }//if(rs..end
                    }//try..end
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
                    }//catch(..end
                        prod_ID = Integer.parseInt(prod_IDString);
                    
                        
                    try{
                        ps = conn.prepareStatement(getInvID);
                        ps.setInt(1,prod_ID);
                        ps.setString(2, "VALID");
                        rs = ps.executeQuery();
                            if(rs.next()){
                                prodInvIDString = rs.getString(1);
                                remainingQuantity = rs.getString(2);
                                System.out.println(prodInvIDString+"\n"+remainingQuantity);
                            }//if(rs..end
                    }//try..end
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
                    }//catch(..end
                    
                    int remQuan = Integer.parseInt(remainingQuantity);
                    
                    if((remQuan - quantityValue) < 0){
                        JOptionPane.showMessageDialog(null, "Excessive quantity for this batch of medicine\nRemaining Quantity: "+remQuan,"Excessive Quantity",JOptionPane.WARNING_MESSAGE);
                    }//if(remQuan - quantity < 0..end
                    
                    else if((remQuan - quantityValue) == 0){
                        newQuan = remQuan - quantityValue;
                        double num = Double.parseDouble(subtotal.getText());
                        newAmount = num + amount;
                        subtotal.setText(Double.toString(newAmount));
                        itemList.addElement(productName.getSelectedItem());
                        ctr++;
                        stringQuan = Integer.toString(quantityValue);
                        quanList.addElement(stringQuan);
                        ctr2++;
                        subList.addElement(amnSt);
                        ctr1++;
                        ctr3++;
                        JOptionPane.showMessageDialog(null, "Selected batch of medicine is now out of stock","Out of Stock",JOptionPane.INFORMATION_MESSAGE);
                    }//if(remQuan - quantity == 0..end
                    
                    else{
                        newQuan = remQuan - quantityValue;
                        double num = Double.parseDouble(subtotal.getText());
                        newAmount = num + amount;
                        subtotal.setText(Double.toString(newAmount));
                        itemList.addElement(productName.getSelectedItem());
                        ctr++;
                        stringQuan = Integer.toString(quantityValue);
                        quanList.addElement(stringQuan);
                        ctr2++;
                        subList.addElement(amnSt);
                        ctr1++;
                        ctr3++;
                    }//else..end
                    
                if(ctr3 >= 1){
                    try{
                        ps = conn.prepareStatement(updateQuantity);
                        ps.setInt(1, newQuan);
                        ps.setString(2, prodInvIDString);
                        ps.execute();
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
                    } 
                }
                
                if(Double.parseDouble(subtotal.getText()) <= 0){
                subtotal.setForeground(Color.RED);
                }
                else{
                subtotal.setForeground(Color.GREEN);
                }
                    
              }//if(evt.getSource()..end
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        if(evt.getSource() == undoButton){
            //String undoQuantity = "UPDATE `inventory` SET `quantity`= (?) WHERE `prod_inventory_id` = (?)";
            ctr--;
            ctr2--;
            ctr1--;
            String prevDesc = (String) itemList.getElementAt(ctr);
            String prevQuan = (String) quanList.getElementAt(ctr2);
            String prevSub = (String) subList.getElementAt(ctr1);
            String sell_price = "", remainingQuantity = "";
            
            try{
                    ps = conn.prepareStatement(getPrice);
                    ps.setString(1,prevDesc);
                    rs = ps.executeQuery();
                        while(rs.next()){
                            sell_price = rs.getString(1);
                        }//while(rs..end
            }//try..end
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "1Exception Error",JOptionPane.ERROR_MESSAGE);
            }//catch(..end
            
            try{
                    ps = conn.prepareStatement(getID);
                    ps.setString(1,prevDesc);
                    rs = ps.executeQuery();
                        if(rs.next()){
                            prod_IDString = rs.getString(1);
                        }//if(rs..end
            }//try..end
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "2Exception Error",JOptionPane.ERROR_MESSAGE);
            }//catch(..end
                    prod_ID = Integer.parseInt(prod_IDString);
            
                    
            try{
                        ps = conn.prepareStatement(getInvID);
                        ps.setInt(1,prod_ID);
                        ps.setString(2, "VALID");
                        rs = ps.executeQuery();
                            if(rs.next()){
                                prodInvIDString = rs.getString(1);
                                remainingQuantity = rs.getString(2);
                                System.out.println(prodInvIDString+"\n"+remainingQuantity);
                            }//if(rs..end
                    }//try..end
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "3Exception Error",JOptionPane.ERROR_MESSAGE);
                    }//catch(..end
            
            
            int delQuan = Integer.parseInt(prevQuan);
            int backQuan = Integer.parseInt(remainingQuantity) + delQuan;
            
            try{
                    ps = conn.prepareStatement(updateQuantity);
                    ps.setInt(1, backQuan);
                    ps.setString(2, prodInvIDString);
                    ps.execute();
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "4Exception Error",JOptionPane.ERROR_MESSAGE);
            } 
 
            double delSub = Double.parseDouble(prevSub);
            
            itemList.remove(ctr);
            quanList.remove(ctr2);
            subList.remove(ctr1);
            double currentAmount = Double.parseDouble(subtotal.getText());
            double delAmount = currentAmount - delSub;
            subtotal.setText(Double.toString(delAmount));
            
            if(Double.parseDouble(subtotal.getText()) <= 0){
                subtotal.setForeground(Color.RED);
            }
            else{
                subtotal.setForeground(Color.GREEN);
            }
        }
    }//GEN-LAST:event_undoButtonActionPerformed

    double sTotal = 0, vatExemptSales = 0, discountAmount = 0, grossTotalAmount = 0, vatAmount = 0, wVat = 0;
    private void wDisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wDisItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            String sTotalString = subtotal.getText();
            sTotal = Double.parseDouble(sTotalString);
            discountAmount = (sTotal * 0.20);
            grossTotalAmount = Math.round(sTotal - discountAmount);
            grossTotal.setText(Double.toString(grossTotalAmount));
        }
    }//GEN-LAST:event_wDisItemStateChanged

    private void nDisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nDisItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            String sTotalString = subtotal.getText();
            grossTotal.setText(sTotalString);
        }
    }//GEN-LAST:event_nDisItemStateChanged
    double gTotal = 0, amtRec = 0, changeAmt = 0; 
    private void calcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonActionPerformed
        if(evt.getSource() == calcButton){
            String gTotalString = grossTotal.getText();
            gTotal = Double.parseDouble(gTotalString);
            String amtRecString = amtReceived.getText();
            
            if(amtRecString.equals("")){
                JOptionPane.showMessageDialog(null, "Kindly input the tendered amount", "Amount Received", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                amtRec = Double.parseDouble(amtRecString);
                changeAmt = (amtRec - gTotal);
                 if(changeAmt < 0){
                     JOptionPane.showMessageDialog(null, "Insufficient tendered amount", "Amount Received", JOptionPane.WARNING_MESSAGE);
                     amtReceived.setText("");
                     amtReceived.requestFocus();
                 }
                 else{
                     change.setText(Double.toString(changeAmt));
                 }
            }
            addItemButton.setEnabled(false);
            undoButton.setEnabled(false);
        }
    }//GEN-LAST:event_calcButtonActionPerformed
        double vatExempt = 0, discountAm = 0, vat = 0;
    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        if(evt.getSource() == proceed){
            
            String insCust = "INSERT INTO `customer`(`customer_id`, `trans_id`, `name`) VALUES (?,?,?)";
            String insTrans = "INSERT INTO `transaction`(`trans_id`,`items_bought`, `subtotal`, `discount`, `gross_total`, `received`, `change_amount`, `date_of_purchase`) VALUES (?,?,?,?,?,?,?,?)";
            String items = (itemList.toString()+" "+quanList.toString()); 
            System.out.println(items);
            java.util.Date d = new java.util.Date();
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String date = (f.format(d));
            int ctr = 0, ctr1 = 0;
            
            if(wDis.isSelected()){
                String sTotalString = subtotal.getText();
                sTotal = Double.parseDouble(sTotalString);
                discountAm = (sTotal * 0.20);
            }
            else{
            }
            
            try{
                ps = conn.prepareStatement(insTrans);
                ps.setString(1, customerID.getText());
                ps.setString(2, items);
                ps.setDouble(3, sTotal);
                ps.setDouble(4, discountAm);
                ps.setDouble(5, Double.parseDouble(grossTotal.getText()));
                ps.setDouble(6, Double.parseDouble(amtReceived.getText()));
                ps.setDouble(7, Double.parseDouble(change.getText()));
                ps.setString(8, date);
                ps.execute();
                ctr++;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
            }
            
            try{
                ps = conn.prepareStatement(insCust);
                ps.setString(1, customerID.getText());
                ps.setString(2, customerID.getText());
                ps.setString(3, name.getText());
                ps.execute();
                ctr1++;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(ctr >= 1 && ctr1 >= 1){
                receipt();
                IDGeneration();
            }
       }    
    }//GEN-LAST:event_proceedActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        if(evt.getSource() == help){
            JOptionPane.showMessageDialog(null, "This form is used if you want to purchase medicine \nor if you want to see the subtotal of the medicine \nthat you’re to purchase.", "POINT OF SALE [HELP]", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(pointOfSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pointOfSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pointOfSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pointOfSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pointOfSale().setVisible(true);
            }
        });
        
        
    }
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JButton addItemButton;
    private javax.swing.JTextField amtReceived;
    private javax.swing.JButton backButton;
    private javax.swing.JButton calcButton;
    private javax.swing.JTextField change;
    private javax.swing.JButton close;
    private javax.swing.JTextField customerID;
    private javax.swing.ButtonGroup discount;
    private javax.swing.JTextField grossTotal;
    private javax.swing.JButton help;
    private javax.swing.JList<String> itemsSelected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton minimize;
    private javax.swing.JRadioButton nDis;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton proceed;
    private javax.swing.JComboBox<String> productName;
    private javax.swing.JSpinner quantity;
    private javax.swing.JList<String> quantityList;
    private javax.swing.JList<String> subTotalList;
    private javax.swing.JTextField subtotal;
    private javax.swing.JButton undoButton;
    private javax.swing.JRadioButton wDis;
    // End of variables declaration//GEN-END:variables
    DefaultListModel itemList = new DefaultListModel();
    DefaultListModel subList = new DefaultListModel();
    DefaultListModel quanList = new DefaultListModel();

    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception Error", JOptionPane.ERROR_MESSAGE);
             }
         }
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Now print the window and its visible contents */
        frameToPrint.printAll(g);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
    
    public pointOfSale(JFrame receipt) {
        frameToPrint = receipt;
    }
    
    JFrame receipt;
    JFrame frameToPrint;
    void receipt(){
        receipt = new JFrame();
        receipt.setSize(400,600);
        receipt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        receipt.setLayout(null);
        receipt.setLocation(496, 70);
        receipt.setUndecorated(true);
        receipt.setVisible(true);
        
        JLabel date = new JLabel("date");
        receipt.add(date);
        date.setBounds(75, 112, 150, 30);
        
        java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("E MM-dd-yyyy");
        date.setText(f.format(d));
        
        JLabel time = new JLabel("time");
        receipt.add(time);
        time.setBounds(285, 112, 150, 30);
        
        java.util.Date t = new java.util.Date();
        SimpleDateFormat h = new SimpleDateFormat("hh:mm:ss a");
        time.setText(h.format(t));
        
        JLabel cashName = new JLabel("name");
        receipt.add(cashName);
        cashName.setBounds(147, 135, 150, 30);
        
        String selTemp = "SELECT `tempUser` FROM `tempadmin`";
        String adminName = "SELECT * FROM `admin` WHERE `username` = ?";
        
            String loggedAdmin = "";
            String fName = "", lName = "";
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
                        cashName.setText(fName+" "+lName);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
                }
                
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsSelected = new JList(itemList);
        jScrollPane1 = new javax.swing.JScrollPane();
        subTotalList = new JList(subList);
        jScrollPane3 = new javax.swing.JScrollPane();
        quantityList = new JList(quanList);
        
        itemsSelected.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(itemsSelected);

        receipt.add(jScrollPane2);
        jScrollPane2.setBounds(10, 170, 180, 207);

        subTotalList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(subTotalList);

        receipt.add(jScrollPane1);
        jScrollPane1.setBounds(280, 170, 108, 207);

        quantityList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(quantityList);

        receipt.add(jScrollPane3);
        jScrollPane3.setBounds(200, 170, 70, 207);
        
        JLabel subTotal = new JLabel();
        receipt.add(subTotal);
        subTotal.setFont(new java.awt.Font("Dialog", 0, 15));
        subTotal.setBounds(290, 383, 150, 30);
        subTotal.setText(Double.toString(sTotal));
        
        JLabel gross = new JLabel();
        receipt.add(gross);
        gross.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        gross.setBounds(290, 400, 150, 30);
        gross.setText(grossTotal.getText());
        
        JLabel amt = new JLabel();
        receipt.add(amt);
        amt.setFont(new java.awt.Font("Dialog", 0, 15));
        amt.setBounds(290, 420, 150, 30);
        amt.setText(amtReceived.getText());
        
        JLabel chnge = new JLabel();
        receipt.add(chnge);
        chnge.setFont(new java.awt.Font("Dialog", 0, 15));
        chnge.setBounds(290, 438, 150, 30);
        chnge.setText(change.getText());
      
        JLabel disc = new JLabel();
        receipt.add(disc);
        disc.setFont(new java.awt.Font("Dialog", 0, 15));
        disc.setBounds(290, 468, 150, 30);
        
        if(wDis.isSelected()){
            disc.setText(Double.toString(Math.round(discountAm)));
        }
        else{
            disc.setText("0.00");
        }
        
        JLabel soldTo = new JLabel();
        receipt.add(soldTo);
        soldTo.setFont(new java.awt.Font("Dialog", 0, 15));
        soldTo.setBounds(100, 485, 150, 30);
        soldTo.setText(name.getText());
        
        JButton printBut = new JButton("PRINT RECEIPT");
        receipt.add(printBut);
        printBut.setBounds(50, 560, 150, 30);
        
        printBut.addActionListener(new pointOfSale(receipt));
        
        JButton nextTrac = new JButton("NEXT TRANSACTION");
        receipt.add(nextTrac);
        nextTrac.setBounds(205, 560, 150, 30);
        
        nextTrac.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                receipt.dispose();
                IDGeneration();
                name.setText("");
                subtotal.setText("0");
                grossTotal.setText("0");
                amtReceived.setText("");
                change.setText("0");
                itemList.clear();
                subList.clear();
                quanList.clear();
                addItemButton.setEnabled(true);
                undoButton.setEnabled(true);
                name.requestFocus();
            }
	});
        
        JLabel bg = new JLabel();
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/receiptFORM.jpg"))); // NOI18N
        bg.setAlignmentY(0.0F);
        receipt.add(bg);
        bg.setBounds(0, 0, 400, 543);
        
    }
}
