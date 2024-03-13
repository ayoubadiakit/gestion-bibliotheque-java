/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formulaire;

import java.sql.*;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import main.MenuGeneral;

/**
 *
 * @author DIAK
 */
public class ActionEnregEmprunt extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost:3306/bibliotheque";
    String userId = "root";
    String pwd = "";
    Connection c = null;
    ResultSet rs;
    DefaultTableModel model;
       
    /**
     * Creates new form ActionEnregLecteur
     */
    public ActionEnregEmprunt() {
        initComponents();
        table();
    }
    
    public void recherche(String str){
        model = (DefaultTableModel) tableEmprunt.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tableEmprunt.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    
    public void table(){
        String enteteTable[] = {"idEmprunt", "codeLecteur", "codeLivre", "dateEmprunt", "dateDepot"};
        String affiche[] = new String[6];
        model = new DefaultTableModel(null, enteteTable);
        try {
            c = DriverManager.getConnection(url, userId, pwd);
            String req = "SELECT * FROM empruntlivre";
            Statement st = c.createStatement();

            rs = st.executeQuery(req);
            
            while (rs.next()) {
                affiche[0] = rs.getString("id");
                affiche[1] = rs.getString("codeLecteur");
                affiche[2] = rs.getString("codeLivre");
                affiche[3] = rs.getString("dateEmprunt");
                affiche[4] = rs.getString("dateRetour");
                model.addRow(affiche);
            }
            tableEmprunt.setModel(model);
            c.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion " + e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        idEmprunt = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        dateDepot = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmprunt = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        codeLivreGE = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_recherche = new javax.swing.JTextField();
        codeLecteurGE = new javax.swing.JTextField();
        dateEmprunt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(991, 613));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel33.setText("GESTION DES emprunts effectues par des lecteurs");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setText("Date Depot");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 110, 33));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Id Emprunt");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 120, 33));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setText("Code Lecteur");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 130, 33));

        idEmprunt.setEditable(false);
        idEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(idEmprunt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, 35));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setText("Date Emprunt");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 130, 33));

        dateDepot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(dateDepot, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 140, 33));

        tableEmprunt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableEmprunt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableEmpruntMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmprunt);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 990, 330));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ios7-compose.png"))); // NOI18N
        jButton1.setText("MODIFIER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash-a.png"))); // NOI18N
        jButton2.setText("SUPPRIMER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton3.setText("MENU GENERAL");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 200, 230));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setText("Code Livre");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 140, 33));

        codeLivreGE.setEditable(false);
        codeLivreGE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(codeLivreGE, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 150, 33));

        jPanel5.setBackground(new java.awt.Color(255, 204, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jLabel3.setText("Rechercher ici");

        txt_recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_rechercheKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_recherche, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        codeLecteurGE.setEditable(false);
        codeLecteurGE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(codeLecteurGE, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 140, 33));

        dateEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateEmprunt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateEmpruntActionPerformed(evt);
            }
        });
        jPanel1.add(dateEmprunt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MenuGeneral mg;
        try {
            mg = new MenuGeneral();
            mg.setVisible(true);
            super.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ActionEnregEmprunt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dateEmpruntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateEmpruntActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dateEmpruntActionPerformed

    private void tableEmpruntMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpruntMouseReleased
        // TODO add your handling code here:
        int i = tableEmprunt.getSelectedRow();
        model = (DefaultTableModel) tableEmprunt.getModel();
        idEmprunt.setText(model.getValueAt(i, 0).toString());
        codeLecteurGE.setText(model.getValueAt(i, 1).toString());
        codeLivreGE.setText(model.getValueAt(i, 2).toString());
        dateEmprunt.setText(model.getValueAt(i, 3).toString());
        dateDepot.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_tableEmpruntMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if ("".equals(idEmprunt.getText()) || "".equals(codeLecteurGE.getText()) || "".equals(codeLivreGE.getText())
                    || "".equals(dateEmprunt.getText()) || "".equals(dateDepot.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                c = DriverManager.getConnection(url, userId, pwd);
                String req = "UPDATE empruntlivre SET dateEmprunt=?, dateRetour=? WHERE id=?";

                PreparedStatement ps = c.prepareStatement(req);
                
                ps.setString(1, dateEmprunt.getText());
                ps.setString(2, dateDepot.getText());
                ps.setString(3, idEmprunt.getText());
                
                int executeUpdate = ps.executeUpdate();
                if (executeUpdate != 0) {
                    JOptionPane.showMessageDialog(this, "Emprunt modifié avec succès");
                    idEmprunt.setText(null);
                    codeLecteurGE.setText(null);
                    codeLivreGE.setText(null);
                    dateEmprunt.setText(null);
                    dateDepot.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de la modification", "Domage", JOptionPane.WARNING_MESSAGE);
                }
                table();
                c.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if ("".equals(idEmprunt.getText()) || "".equals(codeLecteurGE.getText()) || "".equals(codeLivreGE.getText())
                    || "".equals(dateEmprunt.getText()) || "".equals(dateDepot.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                c = DriverManager.getConnection(url, userId, pwd);
                String req = "DELETE FROM empruntlivre WHERE idEmprunt='"+idEmprunt.getText()+"'";
                int option = JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer l'emprunt ?");
                if(option == JOptionPane.YES_OPTION){
                    Statement st = c.createStatement();
                
                    int executeUpdate = st.executeUpdate(req);
                    if (executeUpdate != 0) {
                        JOptionPane.showMessageDialog(this, "Emprunt supprimer avec succès");
                        idEmprunt.setText(null);
                        codeLecteurGE.setText(null);
                        codeLivreGE.setText(null);
                        dateEmprunt.setText(null);
                        dateDepot.setText(null);
                    } else {
                        JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de la suppression", "Domage", JOptionPane.WARNING_MESSAGE);
                    }
                    table();
                    c.close();
                }else{
                    JOptionPane.showMessageDialog(this, "Suppression annulé");
                }
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rechercheKeyReleased
        // TODO add your handling code here:
        recherche(txt_recherche.getText().toUpperCase());
    }//GEN-LAST:event_txt_rechercheKeyReleased

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
            java.util.logging.Logger.getLogger(ActionEnregEmprunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActionEnregEmprunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActionEnregEmprunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActionEnregEmprunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeLecteurGE;
    private javax.swing.JTextField codeLivreGE;
    private javax.swing.JTextField dateDepot;
    private javax.swing.JTextField dateEmprunt;
    private javax.swing.JTextField idEmprunt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEmprunt;
    private javax.swing.JTextField txt_recherche;
    // End of variables declaration//GEN-END:variables
}