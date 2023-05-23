import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;



public class InventoryJFrame extends javax.swing.JFrame {

    public InventoryJFrame() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
     
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ruthtsedkenu", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadProductNo(){
        try {
            pst = con.prepareStatement("SELECT id FROM equipment_tbl");
            rs = pst.executeQuery();
            txtpid.removeAllItems();
            while(rs.next()){
                txtpid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM equipment_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("ename"));
                    v2.add(rs.getString("qty"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("description"));
                    v2.add(rs.getString("location"));
                }
                df.addRow(v2);               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEname = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtpid = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Equipment Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Equipment Qty:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Equipment Status:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Description: ");

        txtEname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnameActionPerformed(evt);
            }
        });

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });

        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpidActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Equipment Id:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExport.setText("Export to CSV");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnPDF.setText("Export PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPDF)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnExport)
                    .addComponent(btnPDF))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Equipment ID", "Equipment Name", "Qty", "Status", "Description", "Location"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Robotics Equipment Inventory System");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Equipment Location:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStatus))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLocation))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel6)))
                .addGap(26, 42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        if(txtEname.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Name is required!!");
        } else if(txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Quantity is required!!");
        } else if(txtStatus.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Status is required!!");
        } else if(txtDescription.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Description is required!!");
        } else if(txtLocation.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Location is required!!");
        }else{
        try {
            String ename = txtEname.getText();
            String qty = txtQty.getText();
            String status = txtStatus.getText();
            String description = txtDescription.getText();
            String location = txtLocation.getText();
            
            pst = con.prepareStatement("INSERT INTO equipment_tbl(ename, qty, status, description, location) VALUES (?,?,?,?,?)");
            pst.setString(1,ename);
            pst.setString(2,qty);
            pst.setString(3,status);
            pst.setString(4,description);
            pst.setString(5,location);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record Added Successfully!!");
                txtEname.setText("");
                txtQty.setText("");
                txtStatus.setText("");
                txtDescription.setText("");
                txtLocation.setText("");
                Fetch();
                LoadProductNo();
                
            } else{
                JOptionPane.showMessageDialog(this, "Record failed to save!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        if(txtEname.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Name is required!!");
        } else if(txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Quantity is required!!");
        } else if(txtStatus.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Status is required!!");
        } else if(txtDescription.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Description is required!!");
        } else if(txtLocation.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Equipment Location is required!!");
        }else{
        try {
        String ename = txtEname.getText();
        String qty = txtQty.getText();
        String status = txtStatus.getText();
        String description = txtDescription.getText();
        String location = txtLocation.getText();
        String pid = txtpid.getSelectedItem().toString();
        
        pst = con.prepareStatement("UPDATE equipment_tbl SET ename=?,qty=?,status=?,description=?,location=? WHERE id=?");
        pst.setString(1,ename);
        pst.setString(2,qty);
        pst.setString(3,status);
        pst.setString(4,description);
        pst.setString(5,location);
        pst.setString(6,pid);
        
        int k = pst.executeUpdate();
        if(k==1){
            JOptionPane.showMessageDialog(this, "Record has been successfully updated!!");
            txtEname.setText("");
            txtQty.setText("");
            txtStatus.setText("");
            txtDescription.setText("");
            txtLocation.setText("");
            txtEname.requestFocus();
            Fetch();
            LoadProductNo();
        }
    }    catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        
        
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtEnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnameActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtpidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpidActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            // TODO add your handling code here:
            String pid = txtpid.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM equipment_tbl WHERE id=?");
            pst.setString(1,pid);
            rs = pst.executeQuery();
            
            if(rs.next()==true){
                txtEname.setText(rs.getString(2));
                txtQty.setText(rs.getString(3));
                txtStatus.setText(rs.getString(4));
                txtDescription.setText(rs.getString(5));
                txtLocation.setText(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(this, "No Record Found!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            String pid = txtpid.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM equipment_tbl WHERE id=?");
            pst.setString(1, pid);
            
            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record has been successfully deleted!!");
                txtEname.setText("");
                txtQty.setText("");
                txtStatus.setText("");
                txtDescription.setText("");
                txtLocation.setText("");
                txtEname.requestFocus();
                Fetch();
                LoadProductNo();
            } else {
                JOptionPane.showMessageDialog(this, "Record failed to delete!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        String filename = "E:\\ExporedFileJava.csv";
        try {
            FileWriter fw = new FileWriter(filename);
            pst = con.prepareStatement("SELECT * FROM equipment_tbl");
            rs = pst.executeQuery();
            
            while(rs.next()){
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append(',');
                fw.append(rs.getString(6));
                fw.append('\n');
                
            }
            JOptionPane.showMessageDialog(this, "CSW File is exported successfully!!");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        try {
            // TODO add your handling code here:
            pst = con.prepareStatement("SELECT * FROM equipment_tbl");
            rs = pst.executeQuery();
            
            Document PDFreport = new Document();
            PdfWriter.getInstance(PDFreport, new FileOutputStream("E:\\OutputReportJava.pdf"));
            
            PDFreport.open();
            
            PdfPTable PDFTable = new PdfPTable(6);
            PdfPCell table_cell;
            
            while(rs.next()){
                String pid = rs.getString("id");
                table_cell = new PdfPCell(new Phrase(pid));
                PDFTable.addCell(table_cell);
                
                String pename = rs.getString("ename");
                table_cell = new PdfPCell(new Phrase(pename));
                PDFTable.addCell(table_cell);
                
                String pqty = rs.getString("qty");
                table_cell = new PdfPCell(new Phrase(pqty));
                PDFTable.addCell(table_cell);
                
                String pstatus = rs.getString("status");
                table_cell = new PdfPCell(new Phrase(pstatus));
                PDFTable.addCell(table_cell);
                
                String pdescription = rs.getString("description");
                table_cell = new PdfPCell(new Phrase(pdescription));
                PDFTable.addCell(table_cell);
                
                String plocation = rs.getString("location");
                table_cell = new PdfPCell(new Phrase(plocation));
                PDFTable.addCell(table_cell);
                
            }
            JOptionPane.showMessageDialog(this, "PDF File is exported successfully!!");
            
            PDFreport.add(PDFTable);
            PDFreport.close();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(InventoryJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPDFActionPerformed

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
            java.util.logging.Logger.getLogger(InventoryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtEname;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JComboBox<String> txtpid;
    // End of variables declaration//GEN-END:variables
}
