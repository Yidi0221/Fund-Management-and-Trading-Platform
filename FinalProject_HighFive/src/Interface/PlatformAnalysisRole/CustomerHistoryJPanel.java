/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.PlatformAnalysisRole;

import Business.Customer.Customer;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Platform;
import Business.FundProduct.FundProduct;
import Business.Organization.PlatformAnalysisOrganization;
import Business.TradeInformation.PurchaseTrade;
import Business.TradeInformation.Trade;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author yangyun
 */
public class CustomerHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerHistoryJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    PlatformAnalysisOrganization organization;
    Platform enter;
    EcoSystem business;
    
    public CustomerHistoryJPanel(JPanel userProcessContainer, UserAccount account, PlatformAnalysisOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enter = (Platform)enterprise;
        this.organization = organization;
        this.business = business;
        
        for(Customer c : enter.getCustomerdirectory()){
            cmbCustomer.addItem(c);
        }
        populateTable();
    }
    
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tabCusHis.getModel();
        model.setRowCount(0);
        
        Customer cus = (Customer)cmbCustomer.getSelectedItem();
        
        if(cus != null){
            for (Trade t : cus.getTradeList().getTradeList()) {
            if(t instanceof PurchaseTrade){
                PurchaseTrade trade = (PurchaseTrade)t;
                Object[] row = new Object[5];
                row[0] = trade;
                row[1] = trade.getFp();
                row[2] = trade.getQuantity();
                row[3] = trade.getFp().getPurchasePrice();
                row[4] = trade.getFp().getRedemptionPrice();
                model.addRow(row);
            }
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabCusHis = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox();
        btnBarChart = new javax.swing.JButton();
        btnPieChart = new javax.swing.JButton();
        btnRedemptionBarChart = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Customer Trade History");

        tabCusHis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trade ID", "Fund Name", "Quantity", "Purchase Price", "Redemption Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabCusHis);

        jLabel2.setText("Customer:");

        cmbCustomer.setBackground(new java.awt.Color(255, 255, 255));
        cmbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerActionPerformed(evt);
            }
        });

        btnBarChart.setBackground(new java.awt.Color(255, 255, 255));
        btnBarChart.setText("Purchase Price Comparison");
        btnBarChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarChartActionPerformed(evt);
            }
        });

        btnPieChart.setBackground(new java.awt.Color(255, 255, 255));
        btnPieChart.setText("Quantity Analysis");
        btnPieChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPieChartActionPerformed(evt);
            }
        });

        btnRedemptionBarChart.setBackground(new java.awt.Color(255, 255, 255));
        btnRedemptionBarChart.setText("Redemption Price Comparison");
        btnRedemptionBarChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedemptionBarChartActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton1.setText("Recommendation");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRedemptionBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBarChart)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(381, 381, 381)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(btnPieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPieChart)
                    .addComponent(btnBarChart)
                    .addComponent(btnRedemptionBarChart))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_cmbCustomerActionPerformed

    private void btnBarChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarChartActionPerformed
       
           DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        
          Customer cus = (Customer)cmbCustomer.getSelectedItem();
        for (Trade t : cus.getTradeList().getTradeList()) {
            if(t instanceof PurchaseTrade){
                PurchaseTrade trade = (PurchaseTrade)t;
                  barchartdata.setValue(trade.getFp().getPurchasePrice(), "Purchase Price",trade.getFp().toString()+"Purchase");
               
           
            }
        }
    
        JFreeChart barchart = ChartFactory.createBarChart("Comparison", "Fund Name", "Purchase Price", barchartdata,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot barchar = barchart.getCategoryPlot(); 
        barchar.setRangeGridlinePaint(Color.BLUE);
        ChartPanel barPanel = new ChartPanel(barchart);
      
         ChartFrame frame = new ChartFrame("Bar Chart", barchart);
        frame.setVisible(true);
        frame.setSize(450,500);
    }//GEN-LAST:event_btnBarChartActionPerformed

    private void btnPieChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPieChartActionPerformed
        // TODO add your handling code here:
        
             DefaultPieDataset pieDataset = new DefaultPieDataset();
             
                  Customer cus = (Customer)cmbCustomer.getSelectedItem();
        for (Trade t : cus.getTradeList().getTradeList()) {
            if(t instanceof PurchaseTrade){
                PurchaseTrade trade = (PurchaseTrade)t;
                
                  pieDataset.setValue(trade.getFp().toString()+"Quantity",trade.getQuantity());
                 
                 
           
            }
        }
             
             
//          pieDataset.setValue("One", new Integer(10));
//          pieDataset.setValue("Two", new Integer(20));
//          pieDataset.setValue("Three", new Integer(30));
//          pieDataset.setValue("Four", new Integer(40));
          
          JFreeChart chart= ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, false);
         // PiePlot p = (PiePlot)chart.getPlot();
         // p.setForegroundAlpha(TOP_ALIGNMENT);
         ChartFrame frame = new ChartFrame("Pie Chart", chart);
         frame.setVisible(true);
         frame.setSize(450,500);
       

        
        
    }//GEN-LAST:event_btnPieChartActionPerformed

    private void btnRedemptionBarChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedemptionBarChartActionPerformed
        // TODO add your handling code here:
         DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        
          Customer cus = (Customer)cmbCustomer.getSelectedItem();
        for (Trade t : cus.getTradeList().getTradeList()) {
            if(t instanceof PurchaseTrade){
                PurchaseTrade trade = (PurchaseTrade)t;
                
                  barchartdata.setValue(trade.getFp().getRedemptionPrice(), "Redemption Price",trade.getFp().toString()+"Redemption");
           
            }
        }
    
        JFreeChart barchart = ChartFactory.createBarChart("Comparison", "Fund Name", "Redemption Price", barchartdata,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot barchar = barchart.getCategoryPlot(); 
        barchar.setRangeGridlinePaint(Color.BLUE);
        ChartPanel barPanel = new ChartPanel(barchart);
      
         ChartFrame frame = new ChartFrame("Bar Chart", barchart);
        frame.setVisible(true);
        frame.setSize(450,500);
    }//GEN-LAST:event_btnRedemptionBarChartActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PurchaseTrade re = null;
        int mid = 0;
        Customer cus = (Customer)cmbCustomer.getSelectedItem();
        
        if(cus != null){
            for (Trade t : cus.getTradeList().getTradeList()) {
            if(t instanceof PurchaseTrade){
                PurchaseTrade trade = (PurchaseTrade)t;
                if(trade.getQuantity() > mid){
                    re = trade;
                    mid = trade.getQuantity();
                }
            }  
        }
        }
        RecmenJPanel cjp = new RecmenJPanel(userProcessContainer, re, business);
        userProcessContainer.add("RecmenJPanel", cjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarChart;
    private javax.swing.JButton btnPieChart;
    private javax.swing.JButton btnRedemptionBarChart;
    private javax.swing.JComboBox cmbCustomer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabCusHis;
    // End of variables declaration//GEN-END:variables
}
