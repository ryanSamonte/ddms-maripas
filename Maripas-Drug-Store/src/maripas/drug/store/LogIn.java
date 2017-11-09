package maripas.drug.store;

import java.awt.*;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import static javax.swing.SwingUtilities.getRootPane;
import net.proteanit.sql.DbUtils;

public class LogIn extends javax.swing.JFrame {
    
    Connection conn = new DBConnection().connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    JButton helpMain, minimizeMain, addStockButton, salesHistoButton, moniStockButton, salesButton,powerMain,adminSettings, viewProfile, accountSettings;
    JLabel date,time,jLabel2, nameLabel, picLabel;
    JScrollPane jScrollPane1;
    JTable expDateTable;
    JFrame mainMenu;
    int xMouse, yMouse;
    
    String user = "";
    String un = "";
    public LogIn() {
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

        jSeparator1 = new javax.swing.JSeparator();
        lbl2 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        userName.requestFocus(true);
        userName.setLayout(null);
        userName.add(lbl);
        lbl.setBounds(5, 2, 100, 20);
        jPanel1 = new javax.swing.JPanel();
        showButton = new javax.swing.JButton();
        showButton.setVisible(false);
        hideButton = new javax.swing.JButton();
        hideButton.setVisible(false);
        password = new javax.swing.JPasswordField();
        password.setLayout(null);
        password.add(lbl);
        password.setBounds(5, 2, 100, 20);
        okButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        close = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FrameDragger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Maripas Drug Store");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(340, 160));
        setMaximizedBounds(new java.awt.Rectangle(400, 350, 700, 400));
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 445));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 400));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                frame(evt);
            }
        });
        getContentPane().setLayout(null);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jSeparator1.setMinimumSize(new java.awt.Dimension(240, 100));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 100));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(410, 130, 240, 30);

        lbl2.setForeground(new java.awt.Color(102, 102, 102));
        lbl2.setText("Password");
        getContentPane().add(lbl2);
        lbl2.setBounds(430, 238, 100, 15);

        lbl.setForeground(new java.awt.Color(102, 102, 102));
        lbl.setText("Username");
        getContentPane().add(lbl);
        lbl.setBounds(430, 170, 100, 15);

        userName.setToolTipText("Enter your username");
        userName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        userName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userNameKeyTyped(evt);
            }
        });
        getContentPane().add(userName);
        userName.setBounds(420, 160, 220, 33);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/showButton.jpg"))); // NOI18N
        showButton.setBorder(null);
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });
        jPanel1.add(showButton);
        showButton.setBounds(5, 5, 28, 19);

        hideButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hideButton.jpg"))); // NOI18N
        hideButton.setBorder(null);
        hideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideButtonActionPerformed(evt);
            }
        });
        jPanel1.add(hideButton);
        hideButton.setBounds(5, 5, 28, 19);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(600, 230, 40, 30);

        password.setToolTipText("Enter your password");
        password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(420, 230, 185, 30);

        okButton.setText("OK");
        okButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton);
        okButton.setBounds(430, 300, 90, 30);

        clearButton.setText("CLEAR");
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.setDefaultCapable(false);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(540, 300, 90, 30);

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xButton.jpg"))); // NOI18N
        close.setRolloverEnabled(true);
        close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/xButtonHover.jpg"))); // NOI18N
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(650, 0, 50, 42);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButton.jpg"))); // NOI18N
        minimize.setAlignmentY(0.0F);
        minimize.setRolloverEnabled(true);
        minimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButtonHover.jpg"))); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        getContentPane().add(minimize);
        minimize.setBounds(600, 0, 50, 42);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogIn Form.jpg"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setMinimumSize(new java.awt.Dimension(700, 410));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 445);

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

    void Menu() {
        mainMenu = new JFrame();
        try {
            mainMenu.setIconImage(ImageIO.read(getClass().getResource("/maripasIcon.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        helpMain = new javax.swing.JButton();
        minimizeMain = new javax.swing.JButton();
        addStockButton = new javax.swing.JButton();
        salesHistoButton = new javax.swing.JButton();
        moniStockButton = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();
        powerMain = new javax.swing.JButton();
        adminSettings = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        expDateTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        picLabel = new javax.swing.JLabel();
        viewProfile = new javax.swing.JButton();
        accountSettings = new javax.swing.JButton();

        mainMenu.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        mainMenu.setTitle("Maripas Drug Store");
        mainMenu.setLocation(new java.awt.Point(209, 40));
        mainMenu.setUndecorated(true);
        //mainMenu.setPreferredSize(new java.awt.Dimension(950, 645));
        mainMenu.setResizable(false);
        mainMenu.setSize(new java.awt.Dimension(950, 645));
        mainMenu.setLayout(null);
        mainMenu.setVisible(true);
      
        JLabel adL = new JLabel("ADMIN");
        adL.setFont(new java.awt.Font("Dialog", Font.BOLD, 15)); // NOI18N
        adL.setForeground(new java.awt.Color(255, 255, 255));
        //nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mainMenu.add(adL);
        adL.setBounds(150, 50, 100, 40);
        
        nameLabel.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        //nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mainMenu.add(nameLabel);
        nameLabel.setBounds(150, 70, 600, 50);
        
        picLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainMenu.add(picLabel);
        picLabel.setBounds(20, 60, 100, 100);
        
        viewProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewProfileButton.jpg"))); // NOI18N
        viewProfile.setToolTipText("This button will display the profile of the signed-in account");
        viewProfile.setAlignmentY(0.0F);
        viewProfile.setBorder(null);
        viewProfile.setRequestFocusEnabled(false);
        viewProfile.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/viewProfileButtonHOVER.jpg"))); // NOI18N
        viewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource() == viewProfile){
                      viewAdminProfile view = new viewAdminProfile();
                      view.setVisible(true);
                }
            }
        });
        mainMenu.add(viewProfile);
        viewProfile.setBounds(150, 130, 150, 30);

        helpMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButton.jpg"))); // NOI18N
        helpMain.setToolTipText("Help");
        helpMain.setRolloverEnabled(true);
        helpMain.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/helpButtonHover.jpg"))); // NOI18N
        helpMain.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource() == helpMain){
                      JOptionPane.showMessageDialog(null, "You can choose what kind of transaction should be done\nit also shows the current Date & Time and \nthe status of all medicines in stock.", "MAIN MENU [HELP]", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        mainMenu.add(helpMain);
        helpMain.setBounds(850, 0, 50, 42);

        minimizeMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButton.jpg"))); // NOI18N
        minimizeMain.setToolTipText("Minimize");
        minimizeMain.setRolloverEnabled(true);
        minimizeMain.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizeButtonHover.jpg"))); // NOI18N
        minimizeMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               if(evt.getSource() == minimizeMain){
                   mainMenu.setExtendedState(JFrame.ICONIFIED);
               } 
            }
        });
        mainMenu.add(minimizeMain);
        minimizeMain.setBounds(900, 0, 50, 42);

        addStockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addStock.jpg"))); // NOI18N
        addStockButton.setToolTipText("This button is for Adding new Items/stock to the sales.");
        addStockButton.setAlignmentY(0.0F);
        addStockButton.setBorder(null);
        addStockButton.setRequestFocusEnabled(false);
        addStockButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/addStock1.jpg"))); // NOI18N
        addStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource() == addStockButton){
                    addStock add = new addStock();
                    mainMenu.setVisible(false);
                    add.setVisible(true);  
                }
            }
        });
        mainMenu.add(addStockButton);
        addStockButton.setBounds(30, 210, 260, 190);

        salesHistoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesHistory.jpg"))); // NOI18N
        salesHistoButton.setToolTipText("You can view your Sales History by clicking this button.");
        salesHistoButton.setAlignmentY(0.0F);
        salesHistoButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesHistory1.jpg"))); // NOI18N
        salesHistoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource() == salesHistoButton){
                    mainMenu.setVisible(false);
                    salesHistory histo = new salesHistory();
                    histo.setVisible(true);
                }
            }
        });
        mainMenu.add(salesHistoButton);
        salesHistoButton.setBounds(310, 420, 260, 190);

        moniStockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitorStock.jpg"))); // NOI18N
        moniStockButton.setToolTipText("Use this button to see the remaining stock and expiration dates of the products.");
        moniStockButton.setAlignmentY(0.0F);
        moniStockButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/monitorStock1.jpg"))); // NOI18N
        moniStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 if(evt.getSource() == moniStockButton){
                    mainMenu.setVisible(false);
                    monitorStock monitor = new monitorStock();
                    monitor.setVisible(true);
                }
            }
        });
        mainMenu.add(moniStockButton);
        moniStockButton.setBounds(310, 210, 260, 190);

        salesButton.setBackground(new java.awt.Color(255, 255, 255));
        salesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sales.jpg"))); // NOI18N
        salesButton.setToolTipText("Click this button if you want to purchase medicine.");
        salesButton.setAlignmentY(0.0F);
        salesButton.setBorder(null);
        salesButton.setOpaque(false);
        salesButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sales1.jpg"))); // NOI18N
        salesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource() == salesButton){
                    mainMenu.setVisible(false);
                    pointOfSale pos = new pointOfSale();
                    pos.setVisible(true);
                }
            }
        });
        mainMenu.add(salesButton);
        salesButton.setBounds(30, 420, 260, 190);

        powerMain.setBackground(new java.awt.Color(255, 255, 255));
        powerMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/powerButton.jpg"))); // NOI18N
        powerMain.setToolTipText("Close the system");
        powerMain.setBorder(null);
        powerMain.setOpaque(false);
        powerMain.setRolloverEnabled(true);
        powerMain.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/powerButtonHover.jpg"))); // NOI18N
        powerMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource() == powerMain){
                    int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Maripas Drug Store",JOptionPane.YES_NO_OPTION);
                        if(choice == 0){
                            WindowEvent winClosingEvent = new WindowEvent(mainMenu,WindowEvent.WINDOW_CLOSING);
                            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
                            
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
                        }
                }
                 
            }
        });
        mainMenu.add(powerMain);
        powerMain.setBounds(840, 65, 90, 90);

        adminSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addAdminAccount.jpg"))); // NOI18N
        adminSettings.setToolTipText("Add Administrator Account");
        adminSettings.setBorder(null);
        adminSettings.setRolloverEnabled(true);
        adminSettings.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/addAdminAccountHover.jpg"))); // NOI18N
        adminSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource() == adminSettings){
                   adminRegi newAdmin = new adminRegi();
                   newAdmin.setVisible(true); 
                }     
            }
        });
        mainMenu.add(adminSettings);
        adminSettings.setBounds(740, 65, 90, 90);
        
        accountSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acctSettings.jpg"))); // NOI18N
        accountSettings.setToolTipText("Account Settings");
        accountSettings.setBorder(null);
        accountSettings.setRolloverEnabled(true);
        accountSettings.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/acctSettingsHover.jpg"))); // NOI18N
        accountSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource() == accountSettings){
                    mainMenu.setVisible(false);
                    accountSettings acctSet = new accountSettings();
                    acctSet.setVisible(true);
                }     
            }
        });
        mainMenu.add(accountSettings);
        accountSettings.setBounds(305, 130, 30, 30);

        jPanel1.setBackground(new java.awt.Color(63, 62, 62));
        jPanel1.setLayout(null);

        date.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(date);
        date.setBounds(50, 20, 270, 50);

        time.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(time);
        time.setBounds(60, 100, 260, 50);

        mainMenu.add(jPanel1);
        jPanel1.setBounds(600, 210, 320, 190);

        expDateTable.setBackground(new java.awt.Color(63, 62, 62));
        expDateTable.setForeground(new java.awt.Color(255, 255, 255));
        expDateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        expDateTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(expDateTable);

        mainMenu.add(jScrollPane1);
        jScrollPane1.setBounds(600, 420, 320, 190);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainMenuFormFLAT.jpg"))); // NOI18N
        jLabel2.setAlignmentY(0.0F);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainMenu.add(jLabel2);
        jLabel2.setBounds(0, 0, 950, 645);
        
        JLabel FrameDragger1 = new JLabel();
        
        FrameDragger1.setText("jLabel3");
        FrameDragger1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FrameDragger1MouseDragged(evt);
            }
        });
        FrameDragger1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FrameDragger1MousePressed(evt);
            }
        });
        mainMenu.add(FrameDragger1);
        FrameDragger1.setBounds(0, 0, 850, 40);

        //pack();
		
        showDate();
        showTime();
        fetch();
    }                                
    void showDate(){
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("E MM-dd-yyyy");
        date.setText(f.format(d));
    }
    
    void showTime(){
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Date d = new Date();
                SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss a");
                time.setText(f.format(d));
            }
        }).start();
    }
    
    private void fetch(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = (f.format(d));
        String selectData = "SELECT p.product_desc AS 'PRODUCT NAME', SUM(i.quantity) AS 'QUANTITY' FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE i.quantity > 0 AND (i.expiration_date NOT BETWEEN ? AND ?) GROUP BY product_desc  ORDER BY expiration_date DESC";
        try{
            ps = conn.prepareStatement(selectData);
            ps.setString(1,"0001-01-01");
            ps.setString(2, dateToday);
            rs = ps.executeQuery();
            expDateTable.setModel(DbUtils.resultSetToTableModel(rs));
            expDateTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    String firstN, middleN, lastN, name;
    void adminInfo(String admin){
        String selectadminInfo = "SELECT * FROM admin WHERE adminID = ?";
        
        try{
            ps = conn.prepareStatement(selectadminInfo);
            ps.setString(1, admin);
            rs = ps.executeQuery();
            if(rs.next()){
                firstN = rs.getString(5);
                middleN = rs.getString(6);
                lastN = rs.getString(4);
                byte[] img = rs.getBytes("Image");



                    //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(picLabel.getWidth(), picLabel.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    picLabel.setIcon(newImage);
                name = firstN+" "+middleN+" "+lastN;
                nameLabel.setText(name);
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }
      
    }
    private void userNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameKeyTyped
        if(evt.getKeyChar() != KeyEvent.VK_BACK_SPACE){
            lbl.setVisible(false);
        }
        else{
            if(userName.getText().equals("")){
            lbl.setVisible(true);
            }
        }
    }//GEN-LAST:event_userNameKeyTyped
    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed
    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
       if(evt.getKeyChar() != KeyEvent.VK_BACK_SPACE){
            lbl2.setVisible(false);
            showButton.setVisible(true);
        }
        else{
            if(password.getText().equals("")){
            lbl2.setVisible(true);
            showButton.setVisible(false);
            }
        }                                  
    }//GEN-LAST:event_passwordKeyTyped
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        if(evt.getSource() == clearButton){
            userName.setText("");
            lbl.setVisible(true);
            password.setText("");
            lbl2.setVisible(true);
            userName.requestFocus();
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    int ctr = 0;
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if(evt.getSource() == okButton){
            String sql = "SELECT username, password FROM admin WHERE username = ? AND password = ?";
                try{
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, userName.getText());
                    ps.setString(2, password.getText());
                    rs = ps.executeQuery();
                        if(rs.next()){
                            ctr++;
                            }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrect username/password","Maripas Drug Store", JOptionPane.ERROR_MESSAGE);
                            userName.setText("");
                            lbl.setVisible(true);
                            password.setText("");
                            lbl2.setVisible(true);
                            userName.requestFocus();
                            }
                    }
                catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Xception Error", JOptionPane.ERROR_MESSAGE);
            }
        if(ctr >= 1){
            this.dispose();
            java.util.Date d = new java.util.Date();
                        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                        String dateToday = (f.format(d));
                        String expiredToday = "SELECT * FROM `inventory` WHERE ((expiration_date BETWEEN ? AND ?) AND quantity > 0) AND status = ?"; 
                            try{
                                ps = conn.prepareStatement(expiredToday);
                                ps.setString(1,"0001-01-01");
                                ps.setString(2, dateToday);
                                ps.setString(3, "VALID");
                                rs = ps.executeQuery();
                                    if(rs.next()){
                                        expiredToday exp = new expiredToday();
                                        exp.setVisible(true);           
                                    }
                                }
                            catch(Exception e){
                                  JOptionPane.showMessageDialog(null, e.getMessage(),"Maliuna",JOptionPane.ERROR_MESSAGE);
                                }  
            Menu();
            String getUserID = "SELECT adminID FROM admin WHERE username = ?";
            String id = "";
            try{
                ps = conn.prepareStatement(getUserID);
                ps.setString(1, userName.getText());
                rs = ps.executeQuery();
                    while(rs.next()){
                        id = rs.getString(1);
                    }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE); 
            }
            String insTempUser = "INSERT INTO `tempadmin`(`tempUser`,`tempID`) VALUES (?, ?)";
        
        try{
            ps = conn.prepareStatement(insTempUser);
            ps.setString(1, userName.getText());
            ps.setString(2, id);
            ps.execute(); 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Error", JOptionPane.ERROR_MESSAGE);
        }
        
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
        adminInfo(admin);
        System.out.println(id);
            
        }     
      }
    }//GEN-LAST:event_okButtonActionPerformed
                
    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure want to exit?", "Maripas Drug Store", JOptionPane.YES_NO_OPTION);
        if(choice == 0){
            close();
        }
        else{
            userName.setText("");
            lbl.setVisible(true);
            password.setText("");
            lbl2.setVisible(true);
            userName.requestFocus();
        }
    }//GEN-LAST:event_closeActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        if(evt.getSource() == showButton){
            password.setEchoChar((char)0);
            showButton.setVisible(false);
            hideButton.setVisible(true);
        }
    }//GEN-LAST:event_showButtonActionPerformed

    private void hideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideButtonActionPerformed
        if(evt.getSource() == hideButton){
            password.setEchoChar((char)'*');
            showButton.setVisible(true);
            hideButton.setVisible(false);
        }
    }//GEN-LAST:event_hideButtonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void frame(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frame
        
    }//GEN-LAST:event_frame

    private void FrameDraggerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_FrameDraggerMouseDragged

    private void FrameDraggerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDraggerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FrameDraggerMousePressed
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    private void FrameDragger1MouseDragged(java.awt.event.MouseEvent evt) {                                          
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        mainMenu.setLocation(x - xMouse, y - yMouse);
    }                                         

    private void FrameDragger1MousePressed(java.awt.event.MouseEvent evt) {                                          
        xMouse = evt.getX();
        yMouse = evt.getY();
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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LogIn().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrameDragger;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton close;
    private javax.swing.JButton hideButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl2;
    private javax.swing.JButton minimize;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton showButton;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables

    
}
