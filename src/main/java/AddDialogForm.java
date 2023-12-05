/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

import javax.swing.*;
import finalproject_yupeichen.DatabaseConnector;

/**
 *
 * @author isabe
 */
public class AddDialogForm extends javax.swing.JDialog {

    /**
     * Creates new form AddDialogForm
     */
    public AddDialogForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddNameLabel = new javax.swing.JLabel();
        AddPriceLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AddNameTextField = new javax.swing.JTextField();
        AddPriceTextField = new javax.swing.JTextField();
        AddQuantityTextField = new javax.swing.JTextField();
        AddSubmitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        AddNameLabel.setText("Name");

        AddPriceLabel.setText("Price");

        jLabel3.setText("Quantity");

        AddNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNameTextFieldActionPerformed(evt);
            }
        });

        AddQuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddQuantityTextFieldActionPerformed(evt);
            }
        });

        AddSubmitButton.setText("Submit");
        AddSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AddNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddPriceTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddQuantityTextField)
                    .addComponent(AddNameTextField))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(AddSubmitButton)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddNameLabel)
                    .addComponent(AddNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddPriceLabel)
                    .addComponent(AddPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(AddQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(AddSubmitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNameTextFieldActionPerformed

    private void AddQuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddQuantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddQuantityTextFieldActionPerformed

    private void AddSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSubmitButtonActionPerformed
        // Retrieve text from the text fields
    String name = AddNameTextField.getText();
    String priceStr = AddPriceTextField.getText();
    String quantityStr = AddQuantityTextField.getText();
    
    // Check if any of the fields are empty
    if (name.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Try to parse the price and quantity
    try {
        double price = Double.parseDouble(priceStr);
        int quantity = Integer.parseInt(quantityStr);
        
        // Here you would call your method to add the product to the database
        DatabaseConnector.addProductToDatabase(name, price, quantity);

        // If the product was added successfully, you can dispose the dialog
        this.dispose();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Price and Quantity must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AddSubmitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddDialogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDialogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDialogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDialogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddDialogForm dialog = new AddDialogForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddNameLabel;
    private javax.swing.JTextField AddNameTextField;
    private javax.swing.JLabel AddPriceLabel;
    private javax.swing.JTextField AddPriceTextField;
    private javax.swing.JTextField AddQuantityTextField;
    private javax.swing.JButton AddSubmitButton;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
