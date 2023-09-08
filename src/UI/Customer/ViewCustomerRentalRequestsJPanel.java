/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Customer;

import Business.Customer.Customer;
import Business.EcoSystem;
import Business.Network;
import Business.Services.RentalRequest;
import Business.User.User;
import Business.User.UserDirectory;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ViewCustomerRentalRequestsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewRentalRequestsJPanel
     */
    private EcoSystem ecosystem;
    private Network network;
    private User user;
    private UserDirectory userDirectory;
    DefaultTableModel tableModel; 
    RentalRequest selectedRequest ;
    
    
    public ViewCustomerRentalRequestsJPanel() {
        initComponents();
        
        this.ecosystem = this.ecosystem.getInstance();
        this.network = this.ecosystem.getNetwork();
        this.userDirectory = this.network.getUserDirectory();
        
    }
    
    public ViewCustomerRentalRequestsJPanel(EcoSystem ecosystem, User user) {
        initComponents();
        this.setVisible(true);

        this.user = user;
        this.ecosystem = ecosystem;
        this.userDirectory = this.ecosystem.getNetwork().getUserDirectory();
        this.network = this.ecosystem.getNetwork();
        this.tableModel = (DefaultTableModel) jTable1.getModel();
        
        populate();
        formatRows();
        
    }
    
        
    public void populate() {
        
        Customer c = this.network.getCustomerDirectory().findCustomer(user.getUserId());

        tableModel.setRowCount(0);
        
        for(RentalRequest r : c.getCustomerRentalList()){
//            System.out.println("getCustomerRentalList " + c.getCustomerRentalList().size());
                
                Object[] row = new Object[10];

                row[0] = r;
                row[1] = r.getProperty().getID();
                row[2] = r.getProperty().getFull_address();
                row[3] = r.getLease().getType();  
                row[4] = String.valueOf(r.getProperty().getIsAvailable());
                
                if(r.getApplication_status() == null){
                    row[5] = "Application in progress";                   
                }else{
                    row[5] = r.getApplication_status();
                }

                
                tableModel.addRow(row);                

        }
    }
    
    private void formatRows() {

        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String status = String.valueOf(tableModel.getValueAt(row, 5));
                c.setBackground(status.equals("Application in Progress") ? Color.GRAY : status.equals("Accepted") ? Color.GREEN : Color.RED);
                return c;
            }
        });

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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rental Request ID", "Property ID", "Apartment Address", "Lease Type", "Availability Status", "Application Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 870, 140));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 67, 138));
        jLabel1.setText("Customer Rental Request");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/custrental.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 630, 400));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
