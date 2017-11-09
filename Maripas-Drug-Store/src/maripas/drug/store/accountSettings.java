package maripas.drug.store;

import java.awt.*;
import com.sun.glass.events.KeyEvent;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.filechooser.*;
import java.io.*;
import javax.imageio.*;

public class accountSettings extends javax.swing.JFrame {
    Connection conn = DBConnection.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int xMouse, yMouse;
    String id = "";
    JFrame restartFrame;
    public accountSettings() {
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

        gender = new javax.swing.ButtonGroup();
        help = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        fNameLabel = new javax.swing.JLabel();
        mNameLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        contactLabel = new javax.swing.JLabel();
        streetNumLabel = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        brgyLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        uNameLabel = new javax.swing.JLabel();
        pWordLabel = new javax.swing.JLabel();
        lNameLabel = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        lastName.setLayout(null);
        lastName.add(lNameLabel);
        lNameLabel.setBounds(5,5,100,30);
        firstName = new javax.swing.JTextField();
        firstName.setLayout(null);
        firstName.add(lNameLabel);
        fNameLabel.setBounds(5,5,100,30);
        middleName = new javax.swing.JTextField();
        middleName.setLayout(null);
        middleName.add(mNameLabel);
        mNameLabel.setBounds(5,5,100,30);
        age = new javax.swing.JTextField();
        age.setLayout(null);
        age.add(ageLabel);
        ageLabel.setBounds(5,5,100,30);
        contactNum = new javax.swing.JTextField();
        contactNum.setLayout(null);
        contactNum.add(contactLabel);
        contactLabel.setBounds(5,5,100,30);
        uName = new javax.swing.JTextField();
        uName.setLayout(null);
        uName.add(uNameLabel);
        uNameLabel.setBounds(5,5,100,30);
        jPanel2 = new javax.swing.JPanel();
        showButton = new javax.swing.JButton();
        showButton.setVisible(false);
        hideButton = new javax.swing.JButton();
        hideButton.setVisible(false);
        pWord = new javax.swing.JPasswordField();
        pWord.setLayout(null);
        pWord.add(pWordLabel);
        pWordLabel.setBounds(5,5,100,30);
        streetNum = new javax.swing.JTextField();
        streetNum.setLayout(null);
        streetNum.add(streetNumLabel);
        streetNumLabel.setBounds(5,5,100,30);
        street = new javax.swing.JTextField();
        street.setLayout(null);
        street.add(streetLabel);
        streetLabel.setBounds(5,5,100,30);
        barangay = new javax.swing.JTextField();
        barangay.setLayout(null);
        barangay.add(brgyLabel);
        brgyLabel.setBounds(5,5,100,30);
        city = new javax.swing.JTextField();
        city.setLayout(null);
        city.add(cityLabel);
        cityLabel.setBounds(5,5,100,30);
        jPanel1 = new javax.swing.JPanel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        back = new javax.swing.JButton();
        create = new javax.swing.JButton();
        attachImg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        gender.add(male);
        gender.add(female);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Maripas Drug Store [ACCOUNT SETTINGS]");
        setLocation(new java.awt.Point(310, 150));
        setName("acctFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(750, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButton.jpg"))); // NOI18N
        help.setRolloverEnabled(true);
        help.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButtonHover.jpg"))); // NOI18N
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        getContentPane().add(help);
        help.setBounds(650, 0, 50, 42);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButton.jpg"))); // NOI18N
        minimize.setRolloverEnabled(true);
        minimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButtonHover.jpg"))); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        getContentPane().add(minimize);
        minimize.setBounds(700, 0, 50, 42);

        fNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        fNameLabel.setText("First Name");
        getContentPane().add(fNameLabel);
        fNameLabel.setBounds(220, 190, 70, 30);

        mNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        mNameLabel.setText("Middle Name");
        getContentPane().add(mNameLabel);
        mNameLabel.setBounds(400, 190, 130, 30);

        ageLabel.setForeground(new java.awt.Color(102, 102, 102));
        ageLabel.setText("Age");
        getContentPane().add(ageLabel);
        ageLabel.setBounds(220, 250, 70, 20);

        contactLabel.setForeground(new java.awt.Color(102, 102, 102));
        contactLabel.setText("Contact #");
        getContentPane().add(contactLabel);
        contactLabel.setBounds(400, 250, 70, 20);

        streetNumLabel.setForeground(new java.awt.Color(102, 102, 102));
        streetNumLabel.setText("St. #");
        getContentPane().add(streetNumLabel);
        streetNumLabel.setBounds(40, 300, 30, 30);

        streetLabel.setForeground(new java.awt.Color(102, 102, 102));
        streetLabel.setText("Street");
        getContentPane().add(streetLabel);
        streetLabel.setBounds(100, 300, 70, 30);

        brgyLabel.setForeground(new java.awt.Color(102, 102, 102));
        brgyLabel.setText("Barangay");
        getContentPane().add(brgyLabel);
        brgyLabel.setBounds(220, 300, 70, 30);

        cityLabel.setForeground(new java.awt.Color(102, 102, 102));
        cityLabel.setText("City/Province");
        getContentPane().add(cityLabel);
        cityLabel.setBounds(400, 300, 70, 30);

        uNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        uNameLabel.setText("Username");
        getContentPane().add(uNameLabel);
        uNameLabel.setBounds(40, 350, 70, 30);

        pWordLabel.setForeground(new java.awt.Color(102, 102, 102));
        pWordLabel.setText("Password");
        getContentPane().add(pWordLabel);
        pWordLabel.setBounds(300, 350, 70, 30);

        lNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        lNameLabel.setText("Last Name");
        getContentPane().add(lNameLabel);
        lNameLabel.setBounds(40, 195, 70, 20);

        lastName.setToolTipText("Last Name");
        lastName.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });
        lastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastNameKeyTyped(evt);
            }
        });
        getContentPane().add(lastName);
        lastName.setBounds(30, 190, 170, 30);

        firstName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        firstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstNameKeyTyped(evt);
            }
        });
        getContentPane().add(firstName);
        firstName.setBounds(210, 190, 170, 30);

        middleName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        middleName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                middleNameKeyTyped(evt);
            }
        });
        getContentPane().add(middleName);
        middleName.setBounds(390, 190, 150, 30);

        age.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageKeyTyped(evt);
            }
        });
        getContentPane().add(age);
        age.setBounds(210, 245, 170, 30);

        contactNum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contactNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactNumKeyTyped(evt);
            }
        });
        getContentPane().add(contactNum);
        contactNum.setBounds(390, 245, 160, 30);

        uName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        uName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uNameKeyTyped(evt);
            }
        });
        getContentPane().add(uName);
        uName.setBounds(30, 350, 210, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/showButton.jpg"))); // NOI18N
        showButton.setBorder(null);
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });
        jPanel2.add(showButton);
        showButton.setBounds(5, 5, 28, 19);

        hideButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hideButton.jpg"))); // NOI18N
        hideButton.setBorder(null);
        hideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideButtonActionPerformed(evt);
            }
        });
        jPanel2.add(hideButton);
        hideButton.setBounds(5, 5, 28, 19);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(460, 350, 40, 30);

        pWord.setToolTipText("");
        pWord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pWordKeyTyped(evt);
            }
        });
        getContentPane().add(pWord);
        pWord.setBounds(290, 350, 180, 30);

        streetNum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        streetNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                streetNumKeyTyped(evt);
            }
        });
        getContentPane().add(streetNum);
        streetNum.setBounds(30, 300, 50, 30);

        street.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        street.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetActionPerformed(evt);
            }
        });
        street.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                streetKeyTyped(evt);
            }
        });
        getContentPane().add(street);
        street.setBounds(90, 300, 110, 30);

        barangay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        barangay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                barangayKeyTyped(evt);
            }
        });
        getContentPane().add(barangay);
        barangay.setBounds(210, 300, 170, 30);

        city.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        city.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cityKeyTyped(evt);
            }
        });
        getContentPane().add(city);
        city.setBounds(390, 300, 160, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gender"));
        jPanel1.setLayout(null);

        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel1.add(male);
        male.setBounds(10, 20, 60, 30);

        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel1.add(female);
        female.setBounds(80, 20, 80, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 230, 170, 60);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backAccount.jpg"))); // NOI18N
        back.setBorder(null);
        back.setRolloverEnabled(true);
        back.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/backAccountHover.jpg"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(465, 420, 180, 40);

        create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updateAccount.jpg"))); // NOI18N
        create.setBorder(null);
        create.setRolloverEnabled(true);
        create.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/updateAccountHover.jpg"))); // NOI18N
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        getContentPane().add(create);
        create.setBounds(280, 420, 180, 40);

        attachImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updateImg.jpg"))); // NOI18N
        attachImg.setBorder(null);
        attachImg.setRolloverEnabled(true);
        attachImg.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/updateImgHover.jpg"))); // NOI18N
        attachImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachImgActionPerformed(evt);
            }
        });
        getContentPane().add(attachImg);
        attachImg.setBounds(590, 190, 130, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminRegiFormFLAT.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 750, 470);

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
        FrameDragger.setBounds(0, 0, 600, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        if(evt.getSource() == help){
            JOptionPane.showMessageDialog(null, "This form is for updating admin accessed account.", "UPDATE ADMIN INFO [HELP]", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_helpActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed

    }//GEN-LAST:event_lastNameActionPerformed

    private void lastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            lNameLabel.setVisible(false);
        }
        else{
            if(!(lastName.getText().equals(""))){
                lNameLabel.setVisible(false);
            }
            if(lastName.getText().equals("")){
                lNameLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_lastNameKeyTyped

    private void firstNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            fNameLabel.setVisible(false);
        }
        else{
            if(firstName.getText().equals("")){
                fNameLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_firstNameKeyTyped

    private void middleNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_middleNameKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            mNameLabel.setVisible(false);
        }
        else{
            if(middleName.getText().equals("")){
                mNameLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_middleNameKeyTyped

    private void ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            ageLabel.setVisible(false);
        }
        else{
            if(age.getText().equals("")){
                ageLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_ageKeyTyped

    private void contactNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactNumKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            contactLabel.setVisible(false);
        }
        else{
            if(contactNum.getText().equals("")){
                contactLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_contactNumKeyTyped

    private void uNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uNameKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            uNameLabel.setVisible(false);
        }
        else{
            if(uName.getText().equals("")){
                uNameLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_uNameKeyTyped

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        if(evt.getSource() == showButton){
            pWord.setEchoChar((char)0);
            showButton.setVisible(false);
            hideButton.setVisible(true);
        }
    }//GEN-LAST:event_showButtonActionPerformed

    private void hideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideButtonActionPerformed
        if(evt.getSource() == hideButton){
            pWord.setEchoChar((char)'*');
            showButton.setVisible(true);
            hideButton.setVisible(false);
        }
    }//GEN-LAST:event_hideButtonActionPerformed

    private void pWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pWordKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            pWordLabel.setVisible(false);
            showButton.setVisible(true);
        }
        else{
            if(pWord.getText().equals("")){
                pWordLabel.setVisible(true);
                showButton.setVisible(false);
            }
        }
    }//GEN-LAST:event_pWordKeyTyped

    private void streetNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_streetNumKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            streetNumLabel.setVisible(false);
        }
        else{
            if(streetNum.getText().equals("")){
                streetNumLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_streetNumKeyTyped

    private void streetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_streetKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            streetLabel.setVisible(false);
        }
        else{
            if(street.getText().equals("")){
                streetLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_streetKeyTyped

    private void barangayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barangayKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            brgyLabel.setVisible(false);
        }
        else{
            if(barangay.getText().equals("")){
                brgyLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_barangayKeyTyped

    private void cityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACKSPACE){
            cityLabel.setVisible(false);
        }
        else{
            if(city.getText().equals("")){
                cityLabel.setVisible(true);
            }
        }
    }//GEN-LAST:event_cityKeyTyped

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        String addAdmin = "UPDATE `admin` SET `username` = (?), `password` = (?), `lastname` = (?), `firstname` = (?), `middlename` = (?), `gender` = (?), `age` = (?), `contact` = (?), `streetnum` = (?), `streetname` = (?), `barangay` = (?), `city` = (?) WHERE adminID = (?)";
        String updatePicture = "UPDATE `admin` SET `image` = (?) WHERE adminID = (?)";
        String userNameExists = "SELECT username FROM admin WHERE username = ? AND username != ?";
        String gender = "";
        String acctLog = "SELECT `tempID` FROM `tempadmin`";
        String logged = "";
        String uNameLog = "SELECT `tempUser` FROM `tempadmin`";
        String userrr = "";
        int id;
       
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
                    ps = conn.prepareStatement(uNameLog);
                    rs = ps.executeQuery();
                    while(rs.next()){
                        userrr = rs.getString(1);
                    }
        }
        
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        int ctr = 0;

        if(lastName.getText().equals("")||firstName.getText().equals("")||age.getText().equals("")||contactNum.getText().equals("")||uName.getText().equals("")||pWord.getText().equals("")||streetNum.getText().equals("")||street.getText().equals("")||barangay.getText().equals("")||city.getText().equals("")){
            lastName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED)); firstName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            age.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED)); contactNum.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED)); uName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            pWord.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));streetNum.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));street.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            barangay.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));city.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            String buttons[] = {"OK"};
            int ch = JOptionPane.showOptionDialog(null,"Kindly fill out all the fields","ADD STOCK",JOptionPane.OK_OPTION,0,null,buttons,buttons[0]);
            if(ch == 0){
                lastName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); firstName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                age.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); contactNum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); uName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                pWord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); streetNum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); street.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                barangay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)); city.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            }//if(ch == ..end
            }
            else{
                try{
                    ps = conn.prepareStatement(userNameExists);
                    ps.setString(1, uName.getText());
                    ps.setString(2, userrr);
                    rs = ps.executeQuery();
                    if(rs.next()){
                        ctr++;
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "1Exception Error", JOptionPane.ERROR_MESSAGE);
                }

                if(ctr >= 1){
                    JOptionPane.showMessageDialog(null, "Username already exists","Administrator Account", JOptionPane.ERROR_MESSAGE);
                    uName.setText("");
                    uName.requestFocus();
                }

                else{
                    if(male.isSelected()){
                        gender = "Male";
                    }
                    else{
                        gender = "Female";
                    }
                    try{
                        ps = conn.prepareStatement(addAdmin);
                        ps.setString(1, uName.getText());
                        ps.setString(2, pWord.getText());
                        ps.setString(3, lastName.getText());
                        ps.setString(4, firstName.getText());
                        ps.setString(5, middleName.getText());
                        ps.setString(6, gender);
                        ps.setInt(7, Integer.parseInt(age.getText()));
                        ps.setString(8, contactNum.getText());
                        ps.setInt(9, Integer.parseInt(streetNum.getText()));
                        ps.setString(10, street.getText());
                        ps.setString(11, barangay.getText());
                        ps.setString(12, city.getText());
                        ps.setString(13, logged);
                        ps.execute();
                        JOptionPane.showMessageDialog(null, "Account Successfully Updated!","Administrator Account", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "2Exception Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
    }//GEN-LAST:event_createActionPerformed
        
    private void attachImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachImgActionPerformed
        updateImage upImg = new updateImage();
        upImg.setVisible(true);
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

    private void streetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        if(evt.getSource() == back){
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
    }//GEN-LAST:event_backActionPerformed
    
    
    void inputs(){
        lNameLabel.setVisible(false);
        fNameLabel.setVisible(false);
        mNameLabel.setVisible(false);
        ageLabel.setVisible(false);
        contactLabel.setVisible(false);
        streetNumLabel.setVisible(false);
        streetLabel.setVisible(false);
        brgyLabel.setVisible(false);
        cityLabel.setVisible(false);
        uNameLabel.setVisible(false);
        pWordLabel.setVisible(false);
        showButton.setVisible(true);
        String selTemp = "SELECT `tempID` FROM `tempadmin`";
        String adminName = "SELECT * FROM `admin` WHERE `adminID` = ?";
        
            String loggedAdmin = "";
            String fName = "", lName = "", mName = "", gend = "", edad = "", cont = "", num = "", sName = "", brgy = "", cityName = "", uname =  "", pass = "";
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
                        cityName = rs.getString(13);
                        uname = rs.getString(2);
                        pass = rs.getString(3);

                    lastName.setText(lName);
                    firstName.setText(fName);
                    middleName.setText(mName);
                    if(gend.equals("Male")){
                        male.setSelected(true);
                    }
                    else{
                        female.setSelected(true);
                    }
                    age.setText(edad);
                    contactNum.setText(cont);
                    streetNum.setText(num);
                    street.setText(sName);
                    barangay.setText(brgy);
                    city.setText(cityName);
                    uName.setText(uname);
                    pWord.setText(pass);
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
            java.util.logging.Logger.getLogger(accountSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accountSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accountSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accountSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accountSettings().setVisible(true);
            }
        });
    }

    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JTextField age;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton attachImg;
    private javax.swing.JButton back;
    private javax.swing.JTextField barangay;
    private javax.swing.JLabel brgyLabel;
    private javax.swing.JTextField city;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JTextField contactNum;
    private javax.swing.JButton create;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField firstName;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JButton help;
    private javax.swing.JButton hideButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel mNameLabel;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField middleName;
    private javax.swing.JButton minimize;
    private javax.swing.JPasswordField pWord;
    private javax.swing.JLabel pWordLabel;
    private javax.swing.JButton showButton;
    private javax.swing.JTextField street;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetNum;
    private javax.swing.JLabel streetNumLabel;
    private javax.swing.JTextField uName;
    private javax.swing.JLabel uNameLabel;
    // End of variables declaration//GEN-END:variables
}
