/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formulaire;

import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ActionEnregLivre extends javax.swing.JFrame {
    
    String url = "jdbc:mysql://localhost:3306/bibliotheque";
    String userId = "root";
    String pwd = "";
    Connection c = null;
    ResultSet rs;
    DefaultTableModel model;
    
    /**
     * Creates new form ActionEnregLecteur
     */
    public ActionEnregLivre() {
        initComponents();
        table();
    }
    
    public void recherche(String str){
        model = (DefaultTableModel) tableLivre.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tableLivre.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    
    public void table(){
        String enteteTable[] = {"CodeLivre", "TitreLivre", "NomAuteur", "NomCategorie", "DatePub"};
        String affiche[] = new String[6];
        model = new DefaultTableModel(null, enteteTable);
        try {
            c = DriverManager.getConnection(url, userId, pwd);
            String req = "SELECT * FROM livre";
            Statement st = c.createStatement();

            rs = st.executeQuery(req);
            
            while (rs.next()) {
                affiche[0] = rs.getString("codeLivre");
                affiche[1] = rs.getString("titreLivre");
                affiche[2] = rs.getString("nomAuteur");
                affiche[3] = rs.getString("nomCategorie");
                affiche[4] = rs.getString("datePub");
                model.addRow(affiche);
            }
            tableLivre.setModel(model);
            c.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
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
        datePubGL = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nomCategorieGL = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        codeLivreGL = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        titreLivreGL = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLivre = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        nomAuteurGL = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_recherche = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(991, 613));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel33.setText("GESTION DES LIVRES");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setText("Date Pub");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 99, 33));

        datePubGL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(datePubGL, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 169, 33));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Nom Categorie");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, 33));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Code Livre");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 99, 33));

        nomCategorieGL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(nomCategorieGL, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 160, 33));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setText("Titre Livre");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 99, 33));

        codeLivreGL.setEditable(false);
        codeLivreGL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(codeLivreGL, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 130, 35));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setText("Nom Auteur");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 33));

        titreLivreGL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(titreLivreGL, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 320, 33));

        tableLivre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableLivre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableLivreMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableLivre);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 990, 350));

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
        jButton3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jButton4.setText("Categorie");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        nomAuteurGL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(nomAuteurGL, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 200, 35));

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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

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
            Logger.getLogger(ActionEnregLivre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        FormCategorie fc = new FormCategorie();
        fc.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tableLivreMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLivreMouseReleased
        // TODO add your handling code here:
        int i = tableLivre.getSelectedRow();
        model = (DefaultTableModel) tableLivre.getModel();
        codeLivreGL.setText(model.getValueAt(i, 0).toString());
        titreLivreGL.setText(model.getValueAt(i, 1).toString());
        nomAuteurGL.setText(model.getValueAt(i, 2).toString());
        nomCategorieGL.setText(model.getValueAt(i, 3).toString());
        datePubGL.setText(model.getValueAt(i, 4).toString());
        
    }//GEN-LAST:event_tableLivreMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if ("".equals(codeLivreGL.getText()) || "".equals(titreLivreGL.getText()) || "".equals(nomAuteurGL.getText())
                    || "".equals(nomCategorieGL.getText()) || "".equals(datePubGL.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                c = DriverManager.getConnection(url, userId, pwd);
                String req = "UPDATE livre SET titreLivre=?, nomAuteur=?, nomCategorie=?, datePub=? WHERE codeLivre=?";

                PreparedStatement ps = c.prepareStatement(req);
                
                ps.setString(1, titreLivreGL.getText().toUpperCase());
                ps.setString(2, nomAuteurGL.getText().toUpperCase());
                ps.setString(3, nomCategorieGL.getText().toUpperCase());
                ps.setString(4, datePubGL.getText().toUpperCase());
                ps.setString(5, codeLivreGL.getText().toUpperCase());
                
                int executeUpdate = ps.executeUpdate();
                if (executeUpdate != 0) {
                    JOptionPane.showMessageDialog(this, "Livre modifié avec succès");
                    codeLivreGL.setText(null);
                    titreLivreGL.setText(null);
                    nomAuteurGL.setText(null);
                    nomCategorieGL.setText(null);
                    datePubGL.setText(null);
                    
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
            if ("".equals(codeLivreGL.getText()) || "".equals(titreLivreGL.getText()) || "".equals(nomAuteurGL.getText())
                    || "".equals(nomCategorieGL.getText()) || "".equals(datePubGL.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                c = DriverManager.getConnection(url, userId, pwd);
                String req = "DELETE FROM livre WHERE codeLivre='"+codeLivreGL.getText()+"'";
                int option = JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer le livre ?");
                if(option == JOptionPane.YES_OPTION){
                    Statement st = c.createStatement();
                
                    int executeUpdate = st.executeUpdate(req);
                    if (executeUpdate != 0) {
                        JOptionPane.showMessageDialog(this, "Livre supprimer avec succès");
                        codeLivreGL.setText(null);
                        titreLivreGL.setText(null);
                        nomAuteurGL.setText(null);
                        nomCategorieGL.setText(null);
                        datePubGL.setText(null);
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
            java.util.logging.Logger.getLogger(ActionEnregLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActionEnregLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActionEnregLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActionEnregLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                new Connexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeLivreGL;
    private javax.swing.JTextField datePubGL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomAuteurGL;
    private javax.swing.JTextField nomCategorieGL;
    private javax.swing.JTable tableLivre;
    private javax.swing.JTextField titreLivreGL;
    private javax.swing.JTextField txt_recherche;
    // End of variables declaration//GEN-END:variables
}