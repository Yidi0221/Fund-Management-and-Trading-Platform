/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.PlatformAnalysisRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FundCompany;
import Business.Enterprise.Platform;
import Business.FundProduct.FundProduct;
import Business.FundProduct.FundProductDirectory;
import Business.Network.Network;
import Business.Organization.PlatformAnalysisOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author yangyun
 */
public class FCHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FCHistoryJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    PlatformAnalysisOrganization organization;
    Platform enter;
    EcoSystem business;
    
    public FCHistoryJPanel(JPanel userProcessContainer, UserAccount account, PlatformAnalysisOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enter = (Platform)enterprise;
        this.organization = organization;
        this.business = business;
        
        for(Network n : business.getNetworkList()){
            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof FundCompany){
                    FundCompany fc = (FundCompany) e;
                    cmbFC.addItem(fc);
                }
            }
        }
        cmbFC.setSelectedItem(null);
    }
    
    private void populateTable() {
       
        DefaultTableModel model = (DefaultTableModel) tabFCHis.getModel();

        model.setRowCount(0);
        FundCompany fc = (FundCompany)cmbFC.getSelectedItem();
        if(fc != null){
        FundProductDirectory fpd = fc.getFundProductDirectory();
        FundProductDirectory re = new FundProductDirectory();
        for (FundProduct fp : fpd.getFundProductDirectory()) {
            if(fp.getSales() != 0){
                re.plusFundProduct(fp);
            }
        }

        for (FundProduct fp : re.getFundProductDirectory()) {
            Object[] row = new Object[5];
            row[0] = fp.getName();
            row[1] = fp.getSales();
            row[2] = fp.getFundType();
            row[3] = fp.getPurchasePrice();
            row[4] = fp.getRedemptionPrice();
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbFC = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabFCHis = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Fund Company Trade History Analysis");

        jLabel2.setText("Fund Company:");

        cmbFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFCActionPerformed(evt);
            }
        });

        tabFCHis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fund Name", "Sales", "Type", "Purchase Price", "Redemption Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabFCHis);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Analysis");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(362, 362, 362)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(107, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFCActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_cmbFCActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset pieDataset = new DefaultPieDataset();
         FundCompany fc = (FundCompany)cmbFC.getSelectedItem();
         FundProductDirectory fpd = fc.getFundProductDirectory();
          for (FundProduct fp : fpd.getFundProductDirectory()) {
           pieDataset.setValue(fp.getName(),fp.getSales());
          }
          JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, false);
        // PiePlot p = (PiePlot)chart.getPlot();
        // p.setForegroundAlpha(TOP_ALIGNMENT);
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(450, 500);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbFC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabFCHis;
    // End of variables declaration//GEN-END:variables
}
