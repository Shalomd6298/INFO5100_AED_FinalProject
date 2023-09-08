/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Customer;

import Business.Customer.CustomerBilling;
import Business.EcoSystem;
import Business.Network;
import Business.User.User;
import Business.User.UserDirectory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BillingJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BillingJPanel
     */
    private EcoSystem ecosystem;
    private Network network;
    private User user;
    private UserDirectory userDirectory;
    float totalAmount;
    
    public BillingJPanel() {
        initComponents();
        
        this.ecosystem = this.ecosystem.getInstance();
        this.network = this.ecosystem.getNetwork();
        this.userDirectory = this.network.getUserDirectory();
    }
    
    public BillingJPanel(EcoSystem ecosystem, User user) {
        initComponents();
        this.setVisible(true);
        
        this.ecosystem = this.ecosystem.getInstance();
        this.network = this.ecosystem.getNetwork();
        this.user = user;
        this.userDirectory = this.network.getUserDirectory();
        
        totalAmountTxt.setEditable(false);
        totalAmount = 0;
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void populateTable() {

        DefaultTableModel model = (DefaultTableModel) checkoutTable.getModel();
        model.setRowCount(0);
        int index = 1;

        for (CustomerBilling transaction : network.getCustomerbillingdirectory().getCustomerBillingList()) {

            if (transaction.getUserId().equals(user.getUserId())) {
                totalAmount += transaction.getPrice();

                Object[] row = new Object[3];

                row[0] = index;
                row[1] = transaction.getFacilityUsed();
                row[2] = transaction.getPrice();

                model.addRow(row);
                index++;
            }
        }

        totalAmountTxt.setText(String.valueOf(totalAmount));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkoutTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalAmountTxt = new javax.swing.JTextField();
        checkoutBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkoutTable.setForeground(new java.awt.Color(41, 67, 138));
        checkoutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No.", "Billing Title / Subject", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(checkoutTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 923, 130));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 67, 138));
        jLabel1.setText("Total Billing");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(41, 67, 138));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 67, 138));
        jLabel2.setText("Total Amount:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));
        add(totalAmountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 185, -1));

        checkoutBtn.setBackground(new java.awt.Color(41, 67, 138));
        checkoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        checkoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money.png"))); // NOI18N
        checkoutBtn.setText("Click to see Total Billing");
        checkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnActionPerformed(evt);
            }
        });
        add(checkoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 210, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money.jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 550, 390));
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnActionPerformed
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(this, "Your total bill is: " + totalAmount);
    }//GEN-LAST:event_checkoutBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkoutBtn;
    private javax.swing.JTable checkoutTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField totalAmountTxt;
    // End of variables declaration//GEN-END:variables
}
