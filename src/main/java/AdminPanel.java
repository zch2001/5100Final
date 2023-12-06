/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

import Dao.Customer;
import admin.DatabaseConnector_ADMIN;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hanqi
 */
public class AdminPanel extends javax.swing.JPanel {
    private MainFrame mainFrame;
    /**
     * Creates new form AdminPanel
     */
    private List<Customer> customers = new ArrayList<Customer>();
    private Customer selectedCustomer = null;

    public AdminPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        populateTable();
        adminTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && adminTable.getSelectedRow() != -1) {
                updateTextFieldsWithSelectedCustomer();
            }
        });
    }

    // Method to populate the table
    private void populateTable() {

            selectedCustomer = null;
            DefaultTableModel customerModel = DatabaseConnector.getCustomerData();
        try {
            this.customers = DatabaseConnector_ADMIN.getAllCustomer();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//            DefaultTableModel model = (DefaultTableModel) adminTable.getModel();
//            for (Customer customer : customers) {
//                model.addRow(new Object[]{
//                        customer.getID(),
//                        customer.getName(),
//                        customer.getEmail(),
//                        customer.getPhone(),
//                        customer.getAddress(),
//                        customer.getCity(),
//                        customer.getState(),
//                        customer.getZipCode(),
//                        customer.getCountry()
//                });
//            }
            adminTable.setModel(customerModel);
        adminTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && adminTable.getSelectedRow() != -1) {
                updateTextFieldsWithSelectedCustomer();
            }
        });
//            clearFields();


    }

    // Clean the text-fields
    private void clearFields() {
        nameTextField.setText("");
        emailTextField.setText("");
        phoneTextField.setText("");
        addressTextField.setText("");
        cityTextField.setText("");
        stateTextField.setText("");
        zipCodeTextField.setText("");
        countryTextField.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        zipCodeLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        createDateLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        cityTextField = new javax.swing.JTextField();
        stateTextField = new javax.swing.JTextField();
        zipCodeTextField = new javax.swing.JTextField();
        countryTextField = new javax.swing.JTextField();
        createDateTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

//        adminTable.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null, null, null}
//            },
//            new String [] {
//                "ID", "Name", "Email", "Phone", "Address", "City", "State", "ZipCode", "Country", "CreateDate"
//            }
//        ) {
//            Class[] types = new Class [] {
//                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
        jScrollPane1.setViewportView(adminTable);

        titleLabel.setFont(new java.awt.Font("Cochin", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Admin Form");

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setText("Back");
        editButton.addActionListener(e -> {
            mainFrame.switchToCard("LoginUI");
        });

        nameLabel.setText("Name");

        emailLabel.setText("Email");

        phoneLabel.setText("Phone");

        addressLabel.setText("Address");

        cityLabel.setText("City");

        stateLabel.setText("State");

        zipCodeLabel.setText("ZipCode");

        countryLabel.setText("Country");

        createDateLabel.setText("CreateDate");

        zipCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipCodeTextFieldActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(emailLabel)
                            .addComponent(phoneLabel)
                            .addComponent(addressLabel)
                            .addComponent(cityLabel)
                            .addComponent(stateLabel)
                            .addComponent(zipCodeLabel)
                            .addComponent(countryLabel)
                            .addComponent(createDateLabel))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTextField)
                            .addComponent(phoneTextField)
                            .addComponent(addressTextField)
                            .addComponent(cityTextField)
                            .addComponent(stateTextField)
                            .addComponent(zipCodeTextField)
                            .addComponent(countryTextField)
                            .addComponent(createDateTextField)
                            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(396, 396, 396))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titleLabel)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(editButton))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityLabel)
                            .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(zipCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryLabel)
                            .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createDateLabel)
                            .addComponent(createDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void zipCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipCodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zipCodeTextFieldActionPerformed

    private void updateTextFieldsWithSelectedCustomer() {
        int selectedRow = adminTable.getSelectedRow();
        if (selectedRow != -1) {
            // 直接从 adminTable 获取数据
            nameTextField.setText(adminTable.getValueAt(selectedRow, 1).toString()); // 假设 Name 在第二列
            emailTextField.setText(adminTable.getValueAt(selectedRow, 2).toString()); // 假设 Email 在第三列
            phoneTextField.setText(adminTable.getValueAt(selectedRow, 3).toString()); // 假设 Phone 在第四列
            addressTextField.setText(adminTable.getValueAt(selectedRow, 4).toString()); // 假设 Address 在第五列
            cityTextField.setText(adminTable.getValueAt(selectedRow, 5).toString()); // 假设 City 在第六列
            stateTextField.setText(adminTable.getValueAt(selectedRow, 6).toString()); // 假设 State 在第七列
            zipCodeTextField.setText(adminTable.getValueAt(selectedRow, 7).toString()); // 假设 ZipCode 在第八列
            countryTextField.setText(adminTable.getValueAt(selectedRow, 8).toString()); // 假设 Country 在第九列
            // createDateTextField.setText(adminTable.getValueAt(selectedRow, 9).toString()); // 假设 CreateDate 在第十列
        }
    }



    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
//        // TODO add your handling code here:
//        int selectedRow = adminTable.getSelectedRow();
//        if(selectedRow == -1){
//            JOptionPane.showMessageDialog(this, "Please select a customer and edit to save","NO SELECTION",HEIGHT);
//            return;
//        }
//        int customerId = (Integer) adminTable.getValueAt(selectedRow, 0);
//        selectedCustomer.setName(nameTextField.getText());
//        selectedCustomer.setEmail(emailTextField.getText());
//        selectedCustomer.setPhone(phoneTextField.getText());
//        selectedCustomer.setAddress(addressTextField.getText());
//        selectedCustomer.setCity(cityTextField.getText());
//        selectedCustomer.setState(stateTextField.getText());
//        selectedCustomer.setZipCode(zipCodeTextField.getText());
//        selectedCustomer.setCountry(countryTextField.getText());
//
//        boolean flag = DatabaseConnector_ADMIN.updateCustomer(customerId);
//        if (flag) {
//            JOptionPane.showMessageDialog(this, "Update Successfully!","Success",HEIGHT);
//        }
//        else {
//            JOptionPane.showMessageDialog(this, "Update Failed","Fail",HEIGHT);
//        }
//        populateTable();
        int selectedRow = adminTable.getSelectedRow();
        if (selectedRow != -1) {
            int customerID = (Integer) adminTable.getValueAt(selectedRow, 0); // 获取 ID
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String zipCode = zipCodeTextField.getText();
            String country = countryTextField.getText();

            boolean flag = DatabaseConnector.updateCustomer(customerID, name, email, phone, address, city, state, zipCode, country);
            if (flag) {
                JOptionPane.showMessageDialog(this, "Customer updated successfully.");
                populateTable(); // 刷新表格数据
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update customer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = adminTable.getSelectedRow();
        if (selectedRow != -1) {
            // 假设客户 ID 在表格的第一列
            int customerId = (Integer) adminTable.getValueAt(selectedRow, 0);

            // 调用 DatabaseConnector 中的删除方法
            boolean flag = DatabaseConnector.deleteCustomer(customerId);
            if (flag) {
                JOptionPane.showMessageDialog(this, "Customer deleted successfully.");
                populateTable(); // 重新加载表格数据
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete customer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed


    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        int selected = adminTable.getSelectedRow();
        if (selected == -1){
            JOptionPane.showMessageDialog(this, "Please select a customer to edit","NO SELECTION",HEIGHT);
            return;
        }
        selectedCustomer = customers.get(selected);
        nameTextField.setText(selectedCustomer.getName());
        emailTextField.setText(selectedCustomer.getEmail());
        phoneTextField.setText(selectedCustomer.getPhone());
        addressTextField.setText(selectedCustomer.getAddress());
        cityTextField.setText(selectedCustomer.getCity());
        stateTextField.setText(selectedCustomer.getState());
        zipCodeTextField.setText(selectedCustomer.getZipCode());
        countryTextField.setText(selectedCustomer.getCountry());

    }//GEN-LAST:event_editButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTable adminTable;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JLabel createDateLabel;
    private javax.swing.JTextField createDateTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel zipCodeLabel;
    private javax.swing.JTextField zipCodeTextField;
    // End of variables declaration//GEN-END:variables
}
