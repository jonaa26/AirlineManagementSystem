/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProjectFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class AdminFlightPage extends javax.swing.JFrame{

    private int t=0;

    /**
     * Creates new form AddFlight
     */
    public AdminFlightPage() {
        initComponents();
    }
        
    public class addFlight{  
        
        public void searchByID(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userdb", "root", "");
        
                Statement st = con.createStatement();
           
                ResultSet rst = st.executeQuery("SELECT * FROM flight WHERE FlightID = "+"\"" + jTextField1.getText() +"\"");
            
                DefaultTableModel tblModel1 = (DefaultTableModel)jTable1.getModel();
                tblModel1.setRowCount(0);
                while(rst.next()){
                    String f = rst.getString("FlightID");
                    String s = rst.getString("Source");
                    String d = rst.getString("Destination");
                    String sf = rst.getString("Set_Flight");
                    String dep = rst.getString("Departure_Time");
                    String arrv = rst.getString("Arrival_Time");
                    String fch = rst.getString("Flight_Charge");
                    String no = rst.getString("No.Of_Seats");
                   
                    String[] arr = {f, s, d, sf, dep, arrv, fch, no};
                    tblModel1.addRow(arr);           
                }
            }
            catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
                           
        public void showFlights(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userdb", "root", "");
        
                Statement st = con.createStatement();
           
                ResultSet rst = st.executeQuery("SELECT * FROM flight");
            
                DefaultTableModel tblModel1 = (DefaultTableModel)jTable1.getModel();
                tblModel1.setRowCount(0);
                while(rst.next()){
                    String f = rst.getString("FlightID");
                    String s = rst.getString("Source");
                    String d = rst.getString("Destination");
                    String sf = rst.getString("Set_Flight");
                    String dep = rst.getString("Departure_Time");
                    String arrv = rst.getString("Arrival_Time");
                    String fch = rst.getString("Flight_Charge");
                    String no = rst.getString("No.Of_Seats");
                   
                    String[] arr = {f, s, d, sf, dep, arrv, fch, no};
                    tblModel1.addRow(arr);           
                }
            }
            catch (ClassNotFoundException | SQLException ex) {
                //JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        public void addflight(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userdb", "root", "");
                PreparedStatement statement = con.prepareStatement("INSERT INTO flight VALUES (?,?,?,?,?,?,?,?)");
            
                statement.setString(1, jTextField1.getText());
                statement.setString(2, jComboBox1.getSelectedItem().toString());
                statement.setString(3, jComboBox2.getSelectedItem().toString());
                statement.setString(4, jFormattedTextField1.getText());
                statement.setString(5, jFormattedTextField2.getText());
                statement.setString(6, jFormattedTextField3.getText());
                statement.setString(7, jTextField2.getText());
                statement.setString(8, jTextField3.getText());
                
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Flight Created Successfully! ");
                statement.close();
                con.close();
            }
            catch(SQLException | ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, e);
            }     
        }
           /*
                        Statement st = con.createStatement();
                        st.executeUpdate("INSERT INTO flight VALUES ("+"\"" + jTextField1.getText() + "\""+
                        ""+"\"" + jComboBox1.getSelectedItem().toString() + "\"" +
                        ""+"\"" + jComboBox2.getSelectedItem().toString() + "\"" +
                        ""+"\"" + jFormattedTextField1.getText()+ "\"" +
                        ""+"\"" + jFormattedTextField2.getText()+ "\"" +
                        ""+"\"" + jFormattedTextField3.getText()+ "\"" +
                        ""+"\"" + jTextField2.getText() + "\")");
            
            */
       

        public void updateDate(){
            jMenuItem1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    jMenuItem1ActionPerformed(ev);    
                    searchByID();
                }
            });
        }
        
        public void updateCharge(){
            jMenuItem2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem2ActionPerformed(evt);
                    searchByID();
                }
            });
        }
        
        public void deleteFlight(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userdb", "root", "");
                Statement statement = con.createStatement();
                statement.executeUpdate("DELETE FROM flight WHERE FlightID = "+"\"" + jTextField1.getText() + "\""+"");
                showFlights();
                JOptionPane.showMessageDialog(null, "Flight Deleted Successfully! ");
            }
            catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Flight Page");

        jPanel1.setBackground(new java.awt.Color(0, 50, 85));
        jPanel1.setForeground(jLabel1.getForeground());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Flight ID: ");

        jLabel4.setForeground(jLabel1.getForeground());
        jLabel4.setText("Source: ");

        jLabel5.setForeground(jLabel1.getForeground());
        jLabel5.setText("Destination: ");

        jLabel6.setForeground(jLabel1.getForeground());
        jLabel6.setText("Set Flight:");

        jLabel7.setForeground(jLabel1.getForeground());
        jLabel7.setText("Departure Time: ");

        jLabel8.setForeground(jLabel1.getForeground());
        jLabel8.setText("Arrival Time: ");

        jFormattedTextField1.setText("yyyy-MM-dd");

        jTextField1.setText("1001");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nene Tereza, Tirana", "Pristina, Kosovo", "Leonardo da Vinci, Rome", "Bergamo-rio Al Serio, Italy ", "Athens, Greece", "Skopje, North Macedonia", "Heathrow, Londra", "Munich, Germany", "Frankfurt, Germany", "Paris Orly, France", "Lyon Saint-Exupery, France", "Amsterdam Schiphol, NetherLands" }));
        jComboBox1.setSelectedIndex(4);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nene Tereza, Tirana", "Pristina, Kosovo", "Leonardo da Vinci, Rome", "Bergamo-rio Al Serio, Italy ", "Athens, Greece", "Skopje, North Macedonia", "Heathrow, Londra", "Munich, Germany", "Frankfurt, Germany", "Paris Orly, France", "Lyon Saint-Exupery, France", "Amsterdam Schiphol, NetherLands" }));

        jFormattedTextField2.setText("hh:mm");

        jTextField2.setText("value");

        jLabel3.setForeground(jLabel1.getForeground());
        jLabel3.setText("Flight Charge ($): ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FlightID", "Source", "Destination", "Set_Flight", "Departure_Time", "Arrival_Time", "Flight_Charge", "No.Of_Seats"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jFormattedTextField3.setText("hh:mm");
        jFormattedTextField3.setToolTipText("");

        jButton1.setText("Search By");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reload");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Number Of Seats: ");

        jTextField3.setText("No");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FLIGHT TABLE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jTextField3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1))))
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(60, 60, 60)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel10)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        jMenuBar1.setForeground(jLabel1.getForeground());
        jMenuBar1.setToolTipText("Flight Page");

        jMenu5.setText("Show Flights");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu5MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu1.setText("Add Flight");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Update Flight");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Update Flight Date");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Update Flight Price");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Delete Flight");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Go Home");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu4MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
        addFlight add = new addFlight();
        setVisible(true);
        add.updateDate();
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        // TODO add your handling code here:
        addFlight adm = new addFlight();
        adm.addflight();
        setVisible(true);
    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MousePressed
        // TODO add your handling code here:
        addFlight add = new addFlight();
        add.showFlights();
        setVisible(true);
    }//GEN-LAST:event_jMenu5MousePressed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
        addFlight add = new addFlight();
        setVisible(true);
        add.updateCharge();
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        // TODO add your handling code here:
        addFlight add = new addFlight();
        add.deleteFlight();
        setVisible(true);
    }//GEN-LAST:event_jMenu3MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addFlight add = new addFlight();
        add.searchByID();
        setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userdb", "root", "");
                    
            Statement st = con2.createStatement();
                    
                    
            ResultSet rs = st.executeQuery("SELECT * FROM flight WHERE FlightID = "+"\"" + jTextField1.getText() +"\""+"");
                    
            if(rs.next()){
                t = rs.getInt("Flight_Charge");
            }
            else{
                t = 0;
            }
                    
            st.close();
            con2.close();
            }
            catch(SQLException | ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, e);
            }
            if(t>0){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userdb", "root", "");
                    Statement statement = con.createStatement();
                    statement.executeUpdate("UPDATE flight SET Flight_Charge ="+"\"" + jTextField2.getText() + "\""
                        +" WHERE FlightID = "+"\"" + jTextField1.getText()+ "\"");
                    JOptionPane.showMessageDialog(null, "Flight Price Updated Successfully! ");
                        
                    statement.close();
                    con.close();
                }
                catch(SQLException | ClassNotFoundException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userdb", "root", "");
        
            Statement st = con2.createStatement();
            

            ResultSet rs = st.executeQuery("SELECT * FROM flight WHERE FlightID = "+"\"" + jTextField1.getText() +"\""+"");
            
            if(rs.next()){
                t = rs.getInt("Set_Flight");
            }
            else{
                t = 0;
            }
            st.close();
            con2.close();
        }
         catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
        if(t > 0){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userdb", "root", "");
                Statement statement = con.createStatement();
                statement.executeUpdate("UPDATE flight SET Set_Flight = "+"\""+ jFormattedTextField1.getText() +"\""
                    +" WHERE FlightID = "+"\"" + jTextField1.getText()+ "\"");
                JOptionPane.showMessageDialog(null, "Flight Date Updated Successfully! ");
               
                statement.close();
                con.close();
            }
            catch(SQLException | ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jMenu4MousePressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        addFlight add = new addFlight();
        add.showFlights();
        setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel Df=(DefaultTableModel)jTable1.getModel();
            int selectIndex=jTable1.getSelectedRow();
            jTextField1.setText(Df.getValueAt(selectIndex,0).toString());
            jComboBox1.setSelectedItem(Df.getValueAt(selectIndex,1).toString());
            jComboBox2.setSelectedItem(Df.getValueAt(selectIndex,2).toString());
            jFormattedTextField1.setText(Df.getValueAt(selectIndex,3).toString());
            jFormattedTextField2.setText(Df.getValueAt(selectIndex,4).toString());
            jFormattedTextField3.setText(Df.getValueAt(selectIndex,5).toString());
            jTextField2.setText(Df.getValueAt(selectIndex,6).toString());
            jTextField3.setText(Df.getValueAt(selectIndex,7).toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(AdminFlightPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFlightPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFlightPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFlightPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFlightPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
