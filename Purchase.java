/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CustomerRole;


import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bahatizhuliduosi
 */
    Connection conn = CustomerRole.DatabaseConnector.getConnect();
    ResultSet rs;
    Statement st;
    PreparedStatement ps


public class Purchase extends javax.swing.JFrame {

    /**
     * Creates new form Purchase
     */
    public Purchase() {
        initComponents();
        showPL();
        txtCart.setEditable(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ProductIDText = new javax.swing.JTextField();
        ProductNameText = new javax.swing.JTextField();
        PriceText = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        PurchaseButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        ProductIDLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        Quantity = new javax.swing.JLabel();
        QuantityText = new javax.swing.JTextField();
        ProductNameLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCart = new javax.swing.JTextArea();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 485));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Price", "Quantity"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        ProductIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductIDTextActionPerformed(evt);
            }
        });

        ProductNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameTextActionPerformed(evt);
            }
        });

        AddButton.setBackground(new java.awt.Color(204, 204, 255));
        AddButton.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        PurchaseButton.setBackground(new java.awt.Color(204, 204, 255));
        PurchaseButton.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        PurchaseButton.setText("Purchase");
        PurchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseButtonActionPerformed(evt);
            }
        });

        ClearButton.setBackground(new java.awt.Color(204, 204, 255));
        ClearButton.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        ProductIDLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        ProductIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        ProductIDLabel.setText("Product ID");

        PriceLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        PriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        PriceLabel.setText("Price");

        Quantity.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        Quantity.setForeground(new java.awt.Color(255, 255, 255));
        Quantity.setText("Quantity");

        QuantityText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityTextActionPerformed(evt);
            }
        });

        ProductNameLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        ProductNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        ProductNameLabel.setText("Product Name");

        txtCart.setColumns(20);
        txtCart.setRows(5);
        jScrollPane3.setViewportView(txtCart);

        ExitButton.setBackground(new java.awt.Color(204, 204, 255));
        ExitButton.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addGap(30, 30, 30)
                        .addComponent(PurchaseButton))
                    .addComponent(Quantity)
                    .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductIDLabel)
                    .addComponent(ProductNameLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(QuantityText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(PriceText, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ProductNameText, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ProductIDText, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProductIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ProductIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProductNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProductNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Quantity))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(QuantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PurchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void showPL() {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM product");

            DefaultTableModel model = new DefaultTableModel();
           
            model.addColumn("ProductID");
            model.addColumn("Name");
            model.addColumn("Price");
            model.addColumn("Quantity");
          
            int no = 1;

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] data = {
                    no++,
                    rs.getString("ProductID"),
                    rs.getString("Name"),
                    rs.getString("Price"),
                    rs.getString("Quantity"),
                    
                };
                model.addRow(data);
            }
            jTable1.setModel(model);

        } catch (Exception e) {

        }
    }

    private void ProductIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductIDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductIDTextActionPerformed

    private void ProductNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductNameTextActionPerformed

    private void QuantityTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityTextActionPerformed

    private void PurchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseButtonActionPerformed
        // TODO add your handling code here:
        if (txtCart.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please add to cart first", "Information", JOptionPane.INFORMATION_MESSAGE);
    } else {
        double subtotal = 0;
        String[] items = txtCart.getText().split("\n");
        for (int i = 0; i < items.length; i++) {
            String[] item = items[i].split("\t");
            String[] itemTotal = item[3].split(": \\$. ");
            subtotal += Double.parseDouble(itemTotal[1]);
        }
    }//GEN-LAST:event_PurchaseButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
  
        ProductIDText.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        PriceText.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        ProductNameText.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        QuantityText.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        PriceText.setEditable(false);
        ProductIDText.setEditable(false);
        ProductIDText.setBackground(Color.gray);
        PriceText.setBackground(Color.gray);
        ProductNameText.setBackground(Color.gray);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        txtCart.setText(null);        // TODO add your handling code here:
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
         try {
            int qty = Integer.parseInt(QuantityText.getText());
            if (PriceText.getText().isEmpty() || ProductNameText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Select a Product", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else if (QuantityText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please give the quantity", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else if (qty == 0) {
                JOptionPane.showMessageDialog(this, "Please increase the product quantity", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String ProductID = ProductIDText.getText();
                String product = ProductNameText.getText();
                double price = Double.parseDouble(PriceText.getText());
                double total = price * qty;

                String item = product + "\t$. " + price + "\t x " + qty + " pcs" + "\t Total : $. " + total;

                txtCart.append(item + "\n");
                ProductNameText.setText("");
                QuantityText.setText("");
                PriceText.setText("");

                String sql = "INSERT INTO Order (CustomerID, Product, Sold, Time) VALUES (?, ?, ?, NOW())";
                ps = conn.prepareStatement(sql);
                ps = conn.prepareStatement(sql);
                ps.setString(1, CustomerID); // assuming customerID is a String
                ps.setString(2, Product);    // assuming product is a String
                ps.setInt(3, Quantity);  // assuming soldQuantity is an int
                ps.executeUpdate();

                
                
  

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to add Order to database!");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_AddButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
        System.out.println(a);
        if (a == 0) {
            LoginInterface exit = new LoginInterface();
            exit.show();
            exit.setVisible(true);
            this.dispose();
            
        
    }//GEN-LAST:event_ExitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTextField PriceText;
    private javax.swing.JLabel ProductIDLabel;
    private javax.swing.JTextField ProductIDText;
    private javax.swing.JLabel ProductNameLabel;
    private javax.swing.JTextField ProductNameText;
    private javax.swing.JButton PurchaseButton;
    private javax.swing.JLabel Quantity;
    private javax.swing.JTextField QuantityText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtCart;
    // End of variables declaration//GEN-END:variables
}
