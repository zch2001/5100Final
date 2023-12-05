/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CustomerRole;

import javax.swing.JOptionPane;
/**
 *
 * @author bahatizhuliduosi
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public Register() {
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

        jPanel1 = new javax.swing.JPanel();
        SignUpLabel1 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        NameLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        EmailText = new javax.swing.JTextField();
        PhoneLabel = new javax.swing.JLabel();
        AddressLabel = new javax.swing.JLabel();
        CityLabel = new javax.swing.JLabel();
        State = new javax.swing.JLabel();
        PhoneText = new javax.swing.JTextField();
        AddressText = new javax.swing.JTextField();
        CityText = new javax.swing.JTextField();
        StateText = new javax.swing.JTextField();
        ZipCode = new javax.swing.JLabel();
        ZipCodeText = new javax.swing.JTextField();
        CountryLabel = new javax.swing.JLabel();
        CountryText = new javax.swing.JTextField();
        SaveButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        SignUpLabel1.setFont(SignUpLabel1.getFont().deriveFont(SignUpLabel1.getFont().getStyle() | java.awt.Font.BOLD, SignUpLabel1.getFont().getSize()+17));
        SignUpLabel1.setForeground(new java.awt.Color(255, 255, 255));
        SignUpLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignUpLabel1.setText("Register");

        NameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextActionPerformed(evt);
            }
        });
        NameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameTextKeyReleased(evt);
            }
        });

        NameLabel.setForeground(new java.awt.Color(255, 255, 255));
        NameLabel.setText("Name");

        EmailLabel.setBackground(new java.awt.Color(255, 255, 255));
        EmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        EmailLabel.setText("Email");
        EmailLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailLabelKeyReleased(evt);
            }
        });

        EmailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTextActionPerformed(evt);
            }
        });
        EmailText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailTextKeyReleased(evt);
            }
        });

        PhoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        PhoneLabel.setText("Phone");

        AddressLabel.setBackground(new java.awt.Color(255, 255, 255));
        AddressLabel.setForeground(new java.awt.Color(255, 255, 255));
        AddressLabel.setText("Address");

        CityLabel.setForeground(new java.awt.Color(255, 255, 255));
        CityLabel.setText("City");

        State.setForeground(new java.awt.Color(255, 255, 255));
        State.setText("State");

        PhoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextActionPerformed(evt);
            }
        });
        PhoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PhoneTextKeyReleased(evt);
            }
        });

        AddressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressTextActionPerformed(evt);
            }
        });
        AddressText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddressTextKeyReleased(evt);
            }
        });

        CityText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CityTextKeyReleased(evt);
            }
        });

        StateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StateTextActionPerformed(evt);
            }
        });
        StateText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StateTextKeyReleased(evt);
            }
        });

        ZipCode.setForeground(new java.awt.Color(255, 255, 255));
        ZipCode.setText("ZipCode");

        ZipCodeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipCodeTextActionPerformed(evt);
            }
        });
        ZipCodeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ZipCodeTextKeyReleased(evt);
            }
        });

        CountryLabel.setForeground(new java.awt.Color(255, 255, 255));
        CountryLabel.setText("Country");

        CountryText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountryTextActionPerformed(evt);
            }
        });
        CountryText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CountryTextKeyReleased(evt);
            }
        });

        SaveButton1.setBackground(new java.awt.Color(204, 204, 255));
        SaveButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        SaveButton1.setText("Save");
        SaveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(SignUpLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddressLabel)
                                    .addComponent(PhoneLabel)
                                    .addComponent(ZipCode)
                                    .addComponent(NameLabel)
                                    .addComponent(State)
                                    .addComponent(CountryLabel)
                                    .addComponent(EmailLabel)
                                    .addComponent(CityLabel))
                                .addGap(100, 100, 100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PhoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddressText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CityText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StateText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ZipCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CountryText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(SaveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(SignUpLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLabel))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EmailLabel)
                    .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneLabel)
                    .addComponent(PhoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddressLabel)
                    .addComponent(AddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CityLabel)
                    .addComponent(CityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(State)
                    .addComponent(StateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ZipCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZipCode))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CountryLabel)
                    .addComponent(CountryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(SaveButton1)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextActionPerformed

    private void EmailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTextActionPerformed

    private void PhoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextActionPerformed

    private void StateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StateTextActionPerformed

    private void ZipCodeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipCodeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeTextActionPerformed

    private void AddressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressTextActionPerformed

    private void CountryTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CountryTextActionPerformed

    private void NameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameTextKeyReleased
        // TODO add your handling code here:
        
        if(NameText.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Name ", "Blank Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (NameText.getText().matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(this,"Names must contain only alphabetical characters.","Validation Error",JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_NameTextKeyReleased

    private void EmailLabelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailLabelKeyReleased
        // TODO add your handling code here:
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    }//GEN-LAST:event_EmailLabelKeyReleased

    private void EmailTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTextKeyReleased

    private void PhoneTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhoneTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextKeyReleased

    private void AddressTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddressTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressTextKeyReleased

    private void CityTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CityTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CityTextKeyReleased

    private void StateTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StateTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_StateTextKeyReleased

    private void ZipCodeTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZipCodeTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeTextKeyReleased

    private void CountryTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CountryTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CountryTextKeyReleased

    private void SaveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButton1ActionPerformed
        // TODO add your handling code here:
        if (validateInputs()) {
        // Validation successful, proceed with saving or processing
        // Save or process the user's input here
        JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
       
    }
        

        
    }//GEN-LAST:event_SaveButton1ActionPerformed
    
    
    private boolean validateInputs() {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (NameText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Name is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        if (!NameText.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, " Name should only contain letters!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (EmailText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        if (!EmailText.getText().matches(emailRegex)) {
            JOptionPane.showMessageDialog(this, "Enter a valid email address.", "Validation Error", JOptionPane.ERROR_MESSAGE);
 
        }
        
        if (PhoneText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "PhoneNumber is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        if (PhoneText.getText().length() > 15||PhoneText.getText().length() <10 ){

            JOptionPane.showMessageDialog(this,"PhoneNumber cannot be too long or too short.","Validation Error",JOptionPane.ERROR_MESSAGE);
        }
        
        if (AddressText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Address is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        
        if (CityText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "City is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        
        if (!CityText.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "City should only contain letters!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (StateText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "State is  required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        
        if (!StateText.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "State should only contain letters!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (ZipCode.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ZipCode is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        if (CountryText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Country is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        
        if (!CountryText.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Country should only contain letters!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        


        return true;
    }
    
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JTextField AddressText;
    private javax.swing.JLabel CityLabel;
    private javax.swing.JTextField CityText;
    private javax.swing.JLabel CountryLabel;
    private javax.swing.JTextField CountryText;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailText;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameText;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JButton SaveButton1;
    private javax.swing.JLabel SignUpLabel1;
    private javax.swing.JLabel State;
    private javax.swing.JTextField StateText;
    private javax.swing.JLabel ZipCode;
    private javax.swing.JTextField ZipCodeText;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
