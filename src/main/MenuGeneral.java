/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import formulaire.*;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIAK
 */
public class MenuGeneral extends JFrame {

    /**
     * Creates new form MenuGeneral
     *
     * @throws java.sql.SQLException
     */
    String url = "jdbc:mysql://localhost:3306/bibliotheque";
    String userId = "root";
    String pwd = "";
    String req;
    Connection c = null;
    ResultSet rs, rs2, rs3;
    Statement stm, stm2, stm3;
    PreparedStatement ps, ps2 = null;
    DefaultTableModel model;

    private String user;

    public MenuGeneral() throws SQLException {
        initComponents();
        recupererCategorie();
        recupererCodeLecteur();
        recupererCodeLivre();
        recupererCodeEmprunt();
        table();
    }

    public MenuGeneral(String nomUtilisateur) {
        initComponents();
        this.user = nomUtilisateur;
        nomUser.setText(this.user);
        
        recupererCategorie();
        recupererCodeLecteur();
        recupererCodeLivre();
        recupererCodeEmprunt();
        table();
    }

    //Recuperation du nom de toutes les categorie inserer dans la BD
    private void recupererCategorie() {
        try {
            c = DriverManager.getConnection(url, userId, pwd);
            req = "SELECT * FROM categorieLivre";
            stm = c.createStatement();

            rs = stm.executeQuery(req);

            while (rs.next()) {
                String Categories = rs.getString("nomCategorie");
                nomCategorie.addItem(Categories);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion " + ex);
        }

    }

    //Recuperation du code de tous les livres inserer dans la BD
    private void recupererCodeLivre() {
        try {
            c = DriverManager.getConnection(url, userId, pwd);
            req = "SELECT * FROM enregtemporaire";
            stm = c.createStatement();

            rs = stm.executeQuery(req);

            while (rs.next()) {
                codeLivreEmprunt.addItem(rs.getString("codeLivre"));
                codeLivreVente.addItem(rs.getString("codeLivre"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion " + ex);
        }
    }

    //Recuperation du code de tous les codes des lecteurs inserer dans la BD
    private void recupererCodeLecteur() {
        try {
            c = DriverManager.getConnection(url, userId, pwd);
            req = "SELECT * FROM lecteur";
            stm = c.createStatement();
            rs = stm.executeQuery(req);

            while (rs.next()) {
                String code = rs.getString("codeLecteur");
                codeLecteurEmprunt.addItem(code);
                //codeLecteurDepot.addItem(code);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion " + ex);
        }
    }

    //Recuperation du code de tous les code des emprunts effectués dans la BD
    private void recupererCodeEmprunt() {
        try {
            c = DriverManager.getConnection(url, userId, pwd);
            req = "SELECT * FROM empruntLivre";
            stm = c.createStatement();

            rs = stm.executeQuery(req);

            while (rs.next()) {
                String codeEmprunteLecteur = rs.getString("codeLecteur");
                codeLecteurDepot.addItem(codeEmprunteLecteur);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion" + ex);
        }
    }

    //Methode dedié a JTable pour l'affichage des information des ventes effectuées
    public void table() {
        String enteteTable[] = {"idVente", "codeLivreVendu", "titreLivreVendu", "nomAuteurLivreVendu", "DateVente"};
        String affiche[] = new String[5];
        model = new DefaultTableModel(null, enteteTable);
        try {
            c = DriverManager.getConnection(url, userId, pwd);
            req = "SELECT * FROM vente";
            Statement st = c.createStatement();

            rs = st.executeQuery(req);

            while (rs.next()) {
                affiche[0] = rs.getString("idVente");
                affiche[1] = rs.getString("codeLivreVente");
                affiche[2] = rs.getString("titreLivreVente");
                affiche[3] = rs.getString("nomAuteurVente");
                affiche[4] = rs.getString("dateVente");
                model.addRow(affiche);
            }
            tableVente.setModel(model);
            //c.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion" + ex);
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

        jPanel8 = new javax.swing.JPanel();
        PanelChange = new javax.swing.JPanel();
        PanelAccueil = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        nomUser = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        PanelLecteur = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        codeLecteur = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        nomLecteur = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        prenomLecteur = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        emailLecteur = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        telephoneLecteur = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        genreLecteur = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        PanelLivre = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        codeLivre = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        titreLivre = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        nomAuteur = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        nomCategorie = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        datePub = new com.toedter.calendar.JDateChooser();
        PanelEmprunt = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        nomLecteurEmprunt = new javax.swing.JTextField();
        prenomLecteurEmprunt = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        genreLecteurEmprunt = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        telephoneLecteurEmprunt = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        codeLecteurEmprunt = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        codeLivreEmprunt = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        titreLivreEmprunt = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        nomCategorieEmprunt = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        nomAuteurEmprunt = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        dateDepotEmprunt = new com.toedter.calendar.JDateChooser();
        jPanel14 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        PanelDepot = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        telephoneLecteurDepot = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        codeLecteurDepot = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        prenomLecteurDeopt = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        genreLecteurDepot = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        nomLecteurDepot = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        titreLivreDepot = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        nomCategorieDepot = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        nomAuteurDepot = new javax.swing.JTextField();
        codeLivreDepot = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        datePublication = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        PanelVendre = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        titreLivreVente = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        nomAuteurVente = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        codeLivreVente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVente = new javax.swing.JTable();
        jLabel66 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelChange.setLayout(new java.awt.CardLayout());

        PanelAccueil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/original - Copie.jpg"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel18.setText("Dans le but d'un projet");

        jLabel23.setFont(new java.awt.Font("Brush Script MT", 2, 36)); // NOI18N
        jLabel23.setText("Tout Droit reservé");

        jLabel60.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel60.setText("Bienvenu M/Me");

        nomUser.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nomUser.setText("Default");

        jLabel57.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel57.setText("DANS LA BIBLIOTHEQUE ALBERT EINSTEIN");

        javax.swing.GroupLayout PanelAccueilLayout = new javax.swing.GroupLayout(PanelAccueil);
        PanelAccueil.setLayout(PanelAccueilLayout);
        PanelAccueilLayout.setHorizontalGroup(
            PanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccueilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAccueilLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(71, 71, 71))
                    .addGroup(PanelAccueilLayout.createSequentialGroup()
                        .addGroup(PanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelAccueilLayout.createSequentialGroup()
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nomUser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelAccueilLayout.setVerticalGroup(
            PanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccueilLayout.createSequentialGroup()
                .addGroup(PanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(nomUser)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        PanelChange.add(PanelAccueil, "card2");

        jLabel22.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel22.setText("Enregistrement des lecteurs");

        jLabel25.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel25.setText("Code Lecteur");

        codeLecteur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codeLecteur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codeLecteurKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel28.setText("Nom");

        nomLecteur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel29.setText("Prenom");

        prenomLecteur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel30.setText("Email");

        emailLecteur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel31.setText("Telephone");

        telephoneLecteur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel32.setText("Genre");

        genreLecteur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genreLecteur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        genreLecteur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("Vider");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/android-checkmark_1.png"))); // NOI18N
        jButton3.setText("Valider");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelLecteurLayout = new javax.swing.GroupLayout(PanelLecteur);
        PanelLecteur.setLayout(PanelLecteurLayout);
        PanelLecteurLayout.setHorizontalGroup(
            PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLecteurLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLecteurLayout.createSequentialGroup()
                        .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telephoneLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(prenomLecteur, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomLecteur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                            .addComponent(genreLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel22))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        PanelLecteurLayout.setVerticalGroup(
            PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLecteurLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel22)
                .addGap(37, 37, 37)
                .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prenomLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelLecteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genreLecteur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        PanelChange.add(PanelLecteur, "card3");

        jLabel33.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel33.setText("Enregistrement des livres");

        jLabel16.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel16.setText("Code Livre");

        codeLivre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codeLivre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codeLivreKeyReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel34.setText("Titre Livre");

        titreLivre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel35.setText("Nom Auteur");

        nomAuteur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel36.setText("Date Pub");

        jLabel37.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel37.setText("Nom Categorie");

        nomCategorie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton4.setText("Vider");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/android-checkmark_1.png"))); // NOI18N
        jButton5.setText("Valider");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        datePub.setDateFormatString("d/MM/y");
        datePub.setMaxSelectableDate(new java.util.Date(253370764869000L));
        datePub.setMinSelectableDate(new java.util.Date(-62135769531000L));

        javax.swing.GroupLayout PanelLivreLayout = new javax.swing.GroupLayout(PanelLivre);
        PanelLivre.setLayout(PanelLivreLayout);
        PanelLivreLayout.setHorizontalGroup(
            PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLivreLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33)
                    .addGroup(PanelLivreLayout.createSequentialGroup()
                        .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel37))
                        .addGap(56, 56, 56)
                        .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomAuteur, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePub, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLivreLayout.createSequentialGroup()
                        .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titreLivre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        PanelLivreLayout.setVerticalGroup(
            PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLivreLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel33)
                .addGap(40, 40, 40)
                .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titreLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomAuteur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datePub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(PanelLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        PanelChange.add(PanelLivre, "card4");

        jLabel38.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel38.setText("emprunt d'un livre");

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Information Lecteur"));

        jLabel17.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel17.setText("Code Lecteur");

        nomLecteurEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        prenomLecteurEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel40.setText("Prenom");

        jLabel41.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel41.setText("Genre");

        genreLecteurEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel42.setText("Telephone");

        telephoneLecteurEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton6.setText("Afficher Lecteur");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel39.setText("Nom");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(prenomLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(genreLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(telephoneLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel17)
                .addGap(38, 38, 38)
                .addComponent(codeLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codeLecteurEmprunt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telephoneLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prenomLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genreLecteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Information Livre"));

        jLabel43.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel43.setText("Code Livre");

        jButton7.setText("Afficher Livre");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel44.setText("Titre Livre");

        titreLivreEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel45.setText("Categorie Livre");

        nomCategorieEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel46.setText("Nom Auteur");

        nomAuteurEmprunt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel47.setText("Date de depot du livre");

        dateDepotEmprunt.setDateFormatString("d/MM/y");
        dateDepotEmprunt.setMaxSelectableDate(new java.util.Date(253370764903000L));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomAuteurEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateDepotEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(titreLivreEmprunt, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomCategorieEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codeLivreEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateDepotEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(codeLivreEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titreLivreEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomCategorieEmprunt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomAuteurEmprunt)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton8.setText("Vider");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/android-checkmark_1.png"))); // NOI18N
        jButton9.setText("Valider");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelEmpruntLayout = new javax.swing.GroupLayout(PanelEmprunt);
        PanelEmprunt.setLayout(PanelEmpruntLayout);
        PanelEmpruntLayout.setHorizontalGroup(
            PanelEmpruntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelEmpruntLayout.createSequentialGroup()
                .addGroup(PanelEmpruntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEmpruntLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel38))
                    .addGroup(PanelEmpruntLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEmpruntLayout.setVerticalGroup(
            PanelEmpruntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpruntLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        PanelChange.add(PanelEmprunt, "card5");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Information Lecteur"));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel48.setText("Code Lecteur");
        jPanel15.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 130, 33));

        telephoneLecteurDepot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel15.add(telephoneLecteurDepot, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 200, 33));

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton10.setText("Afficher Lecteur");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, 36));

        jPanel15.add(codeLecteurDepot, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 103, 33));

        jLabel52.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel52.setText("Nom");
        jPanel15.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 50, 33));

        jLabel49.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel49.setText("Prenom");
        jPanel15.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, 33));

        prenomLecteurDeopt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel15.add(prenomLecteurDeopt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 190, 33));

        jLabel50.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel50.setText("Genre");
        jPanel15.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, 33));

        genreLecteurDepot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel15.add(genreLecteurDepot, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 70, 33));

        jLabel51.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel51.setText("Telephone");
        jPanel15.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, 33));

        nomLecteurDepot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel15.add(nomLecteurDepot, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 180, 33));

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton12.setText("Vider");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/android-checkmark_1.png"))); // NOI18N
        jButton13.setText("Valider");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Information Livre"));

        jLabel53.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel53.setText("Code Livre");

        jLabel54.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel54.setText("Titre Livre");

        titreLivreDepot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel55.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel55.setText("Nom Categorie");

        nomCategorieDepot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel56.setText("Nom Auteur");

        nomAuteurDepot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        codeLivreDepot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel67.setText("Date Publication");

        datePublication.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeLivreDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomCategorieDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(titreLivreDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(nomAuteurDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePublication, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codeLivreDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomCategorieDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titreLivreDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(datePublication, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomAuteurDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        jLabel58.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel58.setText("depot d'un livre");

        javax.swing.GroupLayout PanelDepotLayout = new javax.swing.GroupLayout(PanelDepot);
        PanelDepot.setLayout(PanelDepotLayout);
        PanelDepotLayout.setHorizontalGroup(
            PanelDepotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDepotLayout.createSequentialGroup()
                .addGroup(PanelDepotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDepotLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelDepotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelDepotLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PanelDepotLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel58)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDepotLayout.setVerticalGroup(
            PanelDepotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDepotLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelChange.add(PanelDepot, "card6");

        jLabel62.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel62.setText("vendre un livre");

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Information du livre"));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel61.setText("Code Livre");
        jPanel19.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 120, 37));

        jButton11.setFont(new java.awt.Font("Ravie", 0, 26)); // NOI18N
        jButton11.setText("VENDRE");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 170, 90));

        jLabel63.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel63.setText("Titre Livre");
        jPanel19.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 105, -1));

        titreLivreVente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel19.add(titreLivreVente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 340, 33));

        jLabel65.setFont(new java.awt.Font("Curlz MT", 1, 24)); // NOI18N
        jLabel65.setText("Nom Auteur");
        jPanel19.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 126, -1));

        nomAuteurVente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel19.add(nomAuteurVente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 320, -1));

        jButton14.setText("Afficher Livre");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, 36));

        jPanel19.add(codeLivreVente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 140, 40));

        tableVente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableVente);

        jLabel66.setFont(new java.awt.Font("Ravie", 0, 30)); // NOI18N
        jLabel66.setText("Historique de la vente");

        javax.swing.GroupLayout PanelVendreLayout = new javax.swing.GroupLayout(PanelVendre);
        PanelVendre.setLayout(PanelVendreLayout);
        PanelVendreLayout.setHorizontalGroup(
            PanelVendreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVendreLayout.createSequentialGroup()
                .addGroup(PanelVendreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVendreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelVendreLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel62)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelVendreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(PanelVendreLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel66)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelVendreLayout.setVerticalGroup(
            PanelVendreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVendreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelChange.add(PanelVendre, "card7");

        jPanel8.add(PanelChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 780, 540));

        jPanel1.setBackground(new java.awt.Color(23, 101, 125));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(23, 101, 125));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel1.setText("Acceuil");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, -1));

        jPanel3.setBackground(new java.awt.Color(23, 101, 125));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel3.setText("Lecteur");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/android-friends.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, -1));

        jPanel4.setBackground(new java.awt.Color(23, 101, 125));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel5.setText("Livre");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pexels-photo-768125_1.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, -1));

        jPanel5.setBackground(new java.awt.Color(23, 101, 125));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel7.setText("Emprunt");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ios7-undo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(79, 79, 79))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, -1));

        jPanel6.setBackground(new java.awt.Color(23, 101, 125));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel9.setText("Depot");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/forward.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, -1));

        jPanel7.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/istockphoto-913972638-612x612.jpg"))); // NOI18N
        jLabel11.setText("Bibliotheque");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 80));

        jPanel16.setBackground(new java.awt.Color(23, 101, 125));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(255, 51, 51));
        jLabel26.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("Deconnexion");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ios7-close.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel27)))
                .addContainerGap())
        );

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 200, -1));

        jPanel9.setBackground(new java.awt.Color(23, 101, 125));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel9MousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel15.setText("Vendre");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ios7-cart.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21)))
                .addContainerGap())
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 200, -1));

        jPanel8.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        jLabel14.setBackground(new java.awt.Color(102, 0, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Livre");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 60, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setText("Lecteur");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 60, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setText("Emprunt");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 70, 30));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel59.setText("Depot");
        jLabel59.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(980, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        //Suppression de tous les panels de la JFrame
        PanelChange.removeAll();
        PanelChange.repaint();
        PanelChange.revalidate();

        //Ajout du panel Acceuil dans le Frame
        PanelChange.add(PanelAccueil);
        PanelChange.repaint();
        PanelChange.revalidate();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        jPanel2.setBackground(new Color(142, 162, 198));
        jPanel3.setBackground(new Color(23, 101, 125));
        jPanel4.setBackground(new Color(23, 101, 125));
        jPanel5.setBackground(new Color(23, 101, 125));
        jPanel6.setBackground(new Color(23, 101, 125));
        jPanel9.setBackground(new Color(23, 101, 125));
        //JOptionPane.showMessageDialog(this, this.user);
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        //Suppression de tous les panels de la JFrame
        PanelChange.removeAll();
        PanelChange.repaint();
        PanelChange.revalidate();

        //Ajout du panel Lecteur dans le Frame
        PanelChange.add(PanelLecteur);
        PanelChange.repaint();
        PanelChange.revalidate();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        jPanel3.setBackground(new Color(142, 162, 198));
        jPanel2.setBackground(new Color(23, 101, 125));
        jPanel4.setBackground(new Color(23, 101, 125));
        jPanel5.setBackground(new Color(23, 101, 125));
        jPanel6.setBackground(new Color(23, 101, 125));
        jPanel9.setBackground(new Color(23, 101, 125));
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        //Suppression de tous les panels de la JFrame
        PanelChange.removeAll();
        PanelChange.repaint();
        PanelChange.revalidate();

        //Ajout du panel Livre dans le Frame
        PanelChange.add(PanelLivre);
        PanelChange.repaint();
        PanelChange.revalidate();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        jPanel4.setBackground(new Color(142, 162, 198));
        jPanel3.setBackground(new Color(23, 101, 125));
        jPanel2.setBackground(new Color(23, 101, 125));
        jPanel5.setBackground(new Color(23, 101, 125));
        jPanel6.setBackground(new Color(23, 101, 125));
        jPanel9.setBackground(new Color(23, 101, 125));
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        PanelChange.removeAll();
        PanelChange.repaint();
        PanelChange.revalidate();

        PanelChange.add(PanelEmprunt);
        PanelChange.repaint();
        PanelChange.revalidate();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        jPanel5.setBackground(new Color(142, 162, 198));
        jPanel3.setBackground(new Color(23, 101, 125));
        jPanel4.setBackground(new Color(23, 101, 125));
        jPanel2.setBackground(new Color(23, 101, 125));
        jPanel6.setBackground(new Color(23, 101, 125));
        jPanel9.setBackground(new Color(23, 101, 125));
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        PanelChange.removeAll();
        PanelChange.repaint();
        PanelChange.revalidate();

        PanelChange.add(PanelDepot);
        PanelChange.repaint();
        PanelChange.revalidate();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        jPanel6.setBackground(new Color(142, 162, 198));
        jPanel3.setBackground(new Color(23, 101, 125));
        jPanel4.setBackground(new Color(23, 101, 125));
        jPanel5.setBackground(new Color(23, 101, 125));
        jPanel2.setBackground(new Color(23, 101, 125));
        jPanel9.setBackground(new Color(23, 101, 125));
    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        // TODO add your handling code here:
        Connexion cntx = new Connexion();
        cntx.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_jPanel16MousePressed

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        //
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // Ouverture du formulaire ActionEnregLivre
        ActionEnregLivre ael = new ActionEnregLivre();
        ael.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        ActionEnregLecteur ael = new ActionEnregLecteur();
        ael.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        ActionEnregEmprunt aee = new ActionEnregEmprunt();
        aee.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
        // TODO add your handling code here:
        ActionEnregDepot aee = new ActionEnregDepot();
        aee.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_jLabel59MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            if ("".equals(codeLecteur.getText()) || "".equals(nomLecteur.getText())
                    || "".equals(prenomLecteur.getText()) || "".equals(emailLecteur.getText())
                    || "".equals(telephoneLecteur.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                
                String requete = "INSERT INTO lecteur(codeLecteur, nom, prenom, email, telephone, genre) VALUES(?,?,?,?,?,?)";

                ps = c.prepareStatement(requete);
                ps.setString(1, codeLecteur.getText().toUpperCase());
                ps.setString(2, nomLecteur.getText().toUpperCase());
                ps.setString(3, prenomLecteur.getText().toUpperCase());
                ps.setString(4, emailLecteur.getText());
                ps.setString(5, telephoneLecteur.getText().toUpperCase());
                ps.setString(6, genreLecteur.getSelectedItem().toString());

                int executeUpdate = ps.executeUpdate();
                if (executeUpdate != 0) {
                    JOptionPane.showMessageDialog(this, "Lecteur inseré avec succès");
                    codeLecteur.setText(null);
                    nomLecteur.setText(null);
                    prenomLecteur.setText(null);
                    emailLecteur.setText(null);
                    telephoneLecteur.setText(null);
                    genreLecteur.setSelectedItem(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de l'insertion", "Domage", JOptionPane.WARNING_MESSAGE);
                }
                
            }
            //c.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            if ("".equals(codeLivre.getText()) || "".equals(titreLivre.getText())
                    || "".equals(nomAuteur.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {

                String categorieName = nomCategorie.getSelectedItem().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(datePub.getDate());

                //String requete = "";
                ps = c.prepareStatement("INSERT INTO livre(codeLivre, titreLivre, nomAuteur, nomCategorie, datePub) VALUES(?,?,?,?,?)");
                ps.setString(1, codeLivre.getText().toUpperCase());
                ps.setString(2, titreLivre.getText().toUpperCase());
                ps.setString(3, nomAuteur.getText().toUpperCase());
                ps.setString(4, categorieName);
                ps.setString(5, date);
                int executeUpdate = ps.executeUpdate();

                //String requete2 = ;
                ps2 = c.prepareStatement("INSERT INTO enregtemporaire(codeLivre, titreLivre, nomAuteur, nomCategorie, datePub) VALUES(?,?,?,?,?)");
                ps2.setString(1, codeLivre.getText().toUpperCase());
                ps2.setString(2, titreLivre.getText().toUpperCase());
                ps2.setString(3, nomAuteur.getText().toUpperCase());
                ps2.setString(4, categorieName);
                ps2.setString(5, date);
                int executeUpdate2 = ps2.executeUpdate();

                if (executeUpdate != 0 && executeUpdate2 != 0) {
                    JOptionPane.showMessageDialog(this, "Livre inseré avec succès");
                    codeLivre.setText(null);
                    titreLivre.setText(null);
                    nomAuteur.setText(null);
                    nomCategorie.setSelectedItem(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de l'insertion", "Domage", JOptionPane.WARNING_MESSAGE);
                }
                //c.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            c = DriverManager.getConnection(url, userId, pwd);

            req = "SELECT * FROM lecteur WHERE codeLecteur='" + codeLecteurEmprunt.getSelectedItem() + "'";

            stm = c.createStatement();
            rs = stm.executeQuery(req);
            if (rs.next()) {
                nomLecteurEmprunt.setText(rs.getString("nom"));
                prenomLecteurEmprunt.setText(rs.getString("prenom"));
                genreLecteurEmprunt.setText(rs.getString("genre"));
                telephoneLecteurEmprunt.setText(rs.getString("telephone"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            // TODO add your handling code here:
            c = DriverManager.getConnection(url, userId, pwd);

            stm = c.createStatement();
            stm2 = c.createStatement();
            stm3 = c.createStatement();
            
            rs = stm.executeQuery("SELECT * FROM empruntLivre WHERE codeLecteur='" + codeLecteurDepot.getSelectedItem() + "'");
            if (rs.next()) {
                String codeLecteurTrouver = rs.getString("codeLecteur");
                String codeLivreTrouver = rs.getString("codeLivre");

                rs2 = stm2.executeQuery("SELECT * FROM lecteur WHERE codeLecteur='" + codeLecteurTrouver + "'");
                rs3 = stm3.executeQuery("SELECT * FROM livre WHERE codeLivre='" + codeLivreTrouver + "'");
                if (rs2.next()) {
                    nomLecteurDepot.setText(rs2.getString("nom"));
                    prenomLecteurDeopt.setText(rs2.getString("prenom"));
                    genreLecteurDepot.setText(rs2.getString("genre"));
                    telephoneLecteurDepot.setText(rs2.getString("telephone"));
                }
                if (rs3.next()) {
                    codeLivreDepot.setText(rs3.getString("codeLivre"));
                    nomCategorieDepot.setText(rs3.getString("nomCategorie"));
                    titreLivreDepot.setText(rs3.getString("titreLivre"));
                    nomAuteurDepot.setText(rs3.getString("nomAuteur"));
                    datePublication.setText(rs3.getString("datePub"));
                }

                
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            c = DriverManager.getConnection(url, userId, pwd);

            req = "SELECT * FROM enregtemporaire WHERE codeLivre='" + codeLivreEmprunt.getSelectedItem() + "'";

            stm = c.createStatement();
            rs = stm.executeQuery(req);
            if (rs.next()) {
                titreLivreEmprunt.setText(rs.getString("titreLivre"));
                nomCategorieEmprunt.setText(rs.getString("nomCategorie"));
                nomAuteurEmprunt.setText(rs.getString("nomAuteur"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:   
        try {
            // TODO add your handling code here:

            if ("".equals(codeLivreEmprunt.getSelectedItem()) || "".equals(nomLecteurEmprunt.getText())
                    || "".equals(prenomLecteurEmprunt.getText()) || "".equals(genreLecteurEmprunt.getText())
                    || "".equals(telephoneLecteurEmprunt.getText()) || "".equals(codeLivreEmprunt.getSelectedItem())
                    || "".equals(titreLivreEmprunt.getText()) || "".equals(nomCategorieEmprunt.getText())
                    || "".equals(nomAuteurEmprunt.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                stm = c.createStatement();
                rs2 = stm.executeQuery("SELECT * FROM empruntLivre WHERE codeLecteur='" + codeLecteurEmprunt.getSelectedItem() + "'");
                if (rs2.next()) {
                    JOptionPane.showMessageDialog(this, "Vous ne pouvez pas emprunter car vous n'avez pas deposé ce que vous avez emprunté", "Desolé", JOptionPane.WARNING_MESSAGE);
                } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format(dateDepotEmprunt.getDate());

                    ps = c.prepareStatement("INSERT INTO empruntLivre(codeLecteur, codeLivre, dateEmprunt, dateRetour) VALUES(?,?,date(now()),?)");
                    ps.setString(1, (String) codeLecteurEmprunt.getSelectedItem());
                    ps.setString(2, (String) codeLivreEmprunt.getSelectedItem());
                    ps.setString(3, date);

                    int executeUpdate = ps.executeUpdate();
                    if (executeUpdate != 0) {
                        JOptionPane.showMessageDialog(this, "Livre emprunté avec succès");

                        stm2 = c.createStatement();
                        stm2.executeUpdate("DELETE FROM enregtemporaire WHERE codeLivre='" + codeLivreEmprunt.getSelectedItem() + "'");

                        codeLecteurEmprunt.setSelectedItem(null);
                        nomLecteurEmprunt.setText(null);
                        prenomLecteurEmprunt.setText(null);
                        genreLecteurEmprunt.setText(null);
                        telephoneLecteurEmprunt.setText(null);
                        codeLivreEmprunt.setSelectedItem(null);
                        titreLivreEmprunt.setText(null);
                        nomCategorieEmprunt.setText(null);
                        nomAuteurEmprunt.setText(null);
                                                
                    } else {
                        JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de l'insertion", "Domage", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            //c.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            if ("".equals(codeLecteurDepot.getSelectedItem()) || "".equals(codeLivreDepot.getText())
                    || "".equals(nomLecteurDepot.getText())
                    || "".equals(prenomLecteurDeopt.getText()) || "".equals(telephoneLecteurDepot.getText())
                    || "".equals(genreLecteurDepot.getText())
                    || "".equals(titreLivreDepot.getText()) || "".equals(nomCategorieDepot.getText())
                    || "".equals(nomAuteurDepot.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {

                ps = c.prepareStatement("INSERT INTO retourLivre(codeLecteur, codeLivre, dateRetour) VALUES(?,?,date(now()))");
                ps.setString(1, (String) codeLecteurDepot.getSelectedItem());
                ps.setString(2, codeLivreDepot.getText());
                int executeUpdate = ps.executeUpdate();

                ps2 = c.prepareStatement("INSERT INTO enregtemporaire(codeLivre, titreLivre, nomAuteur, nomCategorie, datePub) VALUES(?,?,?,?,?)");
                ps2.setString(1, codeLivreDepot.getText());
                ps2.setString(2, titreLivreDepot.getText());
                ps2.setString(3, nomAuteurDepot.getText());
                ps2.setString(4, nomCategorieDepot.getText());
                ps2.setString(5, datePublication.getText());
                int executeUpdate2 = ps2.executeUpdate();

                if (executeUpdate != 0) {
                    if (executeUpdate2 != 0) {
                        JOptionPane.showMessageDialog(this, "Depot enregistrer avec succès");

                        stm2 = c.createStatement();
                        stm2.executeUpdate("DELETE FROM empruntLivre WHERE codeLecteur='" + codeLecteurDepot.getSelectedItem() + "'");

                        codeLecteurDepot.setSelectedItem(null);
                        nomLecteurDepot.setText(null);
                        prenomLecteurDeopt.setText(null);
                        genreLecteurDepot.setText(null);
                        telephoneLecteurDepot.setText(null);
                        codeLivreDepot.setText(null);
                        titreLivreDepot.setText(null);
                        nomCategorieDepot.setText(null);
                        nomAuteurDepot.setText(null);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de l'insertion", "Domage", JOptionPane.WARNING_MESSAGE);
                }
            }
            //c.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        codeLecteurDepot.setSelectedItem(null);
        nomLecteurDepot.setText(null);
        prenomLecteurDeopt.setText(null);
        genreLecteurDepot.setText(null);
        telephoneLecteurDepot.setText(null);
        codeLivreDepot.setText(null);
        titreLivreDepot.setText(null);
        nomCategorieDepot.setText(null);
        nomAuteurDepot.setText(null);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        codeLecteurEmprunt.setSelectedItem(null);
        nomLecteurEmprunt.setText(null);
        prenomLecteurEmprunt.setText(null);
        genreLecteurEmprunt.setText(null);
        telephoneLecteurEmprunt.setText(null);
        codeLivreEmprunt.setSelectedItem(null);
        titreLivreEmprunt.setText(null);
        nomCategorieEmprunt.setText(null);
        nomAuteurEmprunt.setText(null);


    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        codeLivre.setText(null);
        titreLivre.setText(null);
        nomAuteur.setText(null);
        nomCategorie.setSelectedItem(null);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        codeLecteur.setText(null);
        nomLecteur.setText(null);
        prenomLecteur.setText(null);
        emailLecteur.setText(null);
        genreLecteur.setSelectedItem(null);
        telephoneLecteur.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void codeLecteurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeLecteurKeyReleased
        try {
            // TODO add your handling code here:
            c = DriverManager.getConnection(url, userId, pwd);

            req = "SELECT * FROM lecteur WHERE codeLecteur='" + codeLecteur.getText() + "'";

            stm = c.createStatement();
            rs = stm.executeQuery(req);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Un lecteur detient déjà ce code veillez le changer", "DESOLE", JOptionPane.WARNING_MESSAGE);
                codeLecteur.setText(null);
            }
            //c.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion" + ex);
        }
    }//GEN-LAST:event_codeLecteurKeyReleased

    private void codeLivreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeLivreKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            c = DriverManager.getConnection(url, userId, pwd);

            req = "SELECT * FROM livre WHERE codeLivre='" + codeLivre.getText() + "'";

            stm = c.createStatement();
            rs = stm.executeQuery(req);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Un livre detient déjà ce code veillez le changer", "Domage", JOptionPane.WARNING_MESSAGE);
                codeLivre.setText(null);
            }
            //c.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion" + ex);
        }
    }//GEN-LAST:event_codeLivreKeyReleased

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        PanelChange.removeAll();
        PanelChange.repaint();
        PanelChange.revalidate();

        PanelChange.add(PanelVendre);
        PanelChange.repaint();
        PanelChange.revalidate();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MousePressed
        // TODO add your handling code here:
        jPanel6.setBackground(new Color(23, 101, 125));
        jPanel3.setBackground(new Color(23, 101, 125));
        jPanel4.setBackground(new Color(23, 101, 125));
        jPanel5.setBackground(new Color(23, 101, 125));
        jPanel2.setBackground(new Color(23, 101, 125));
        jPanel9.setBackground(new Color(142, 162, 198));
    }//GEN-LAST:event_jPanel9MousePressed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            if ("".equals(codeLivreVente.getSelectedItem()) || "".equals(titreLivreVente.getText())
                    || "".equals(nomAuteurVente.getText())) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(PanelEmprunt, "Voulez vous vendre le livre ?");
                if(option == JOptionPane.YES_OPTION){
                    String requete = "INSERT INTO vente(codeLivreVente, titreLivreVente, nomAuteurVente, dateVente) VALUES(?,?,?,date(now()))";

                    ps = c.prepareStatement(requete);
                    ps.setString(1, codeLivreVente.getSelectedItem().toString().toUpperCase());
                    ps.setString(2, titreLivreVente.getText().toUpperCase());
                    ps.setString(3, nomAuteurVente.getText().toUpperCase());

                    int executeUpdate = ps.executeUpdate();
                    if (executeUpdate != 0) {
                        JOptionPane.showMessageDialog(this, "vente effectué avec succès");

                        stm = c.createStatement();
                        stm.executeUpdate("DELETE FROM livre WHERE codeLivre='" + codeLivreVente.getSelectedItem() + "'");

                        stm2 = c.createStatement();
                        stm2.executeUpdate("DELETE FROM enregtemporaire WHERE codeLivre='" + codeLivreVente.getSelectedItem() + "'");

                        codeLivreVente.setSelectedItem(null);
                        titreLivreVente.setText(null);
                        nomAuteurVente.setText(null);
                    } else {
                        JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de l'insertion", "Domage", JOptionPane.WARNING_MESSAGE);
                    }
                    table();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Vente annulée");
                }
            }
            //c.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur de Connexion" + ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        try {
            if ("".equals(codeLivreVente.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "Le champs doit etre rempli", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            // TODO add your handling code here:
            c = DriverManager.getConnection(url, userId, pwd);

            req = "SELECT * FROM livre WHERE codeLivre='" + codeLivreVente.getSelectedItem() + "'";

            stm = c.createStatement();
            rs = stm.executeQuery(req);
            if (rs.next()) {
                titreLivreVente.setText(rs.getString("titreLivre"));
                nomAuteurVente.setText(rs.getString("nomAuteur"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion echoué " + ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JPanel PanelAccueil;
    private javax.swing.JPanel PanelChange;
    private javax.swing.JPanel PanelDepot;
    private javax.swing.JPanel PanelEmprunt;
    private javax.swing.JPanel PanelLecteur;
    private javax.swing.JPanel PanelLivre;
    private javax.swing.JPanel PanelVendre;
    private javax.swing.JTextField codeLecteur;
    private javax.swing.JComboBox<String> codeLecteurDepot;
    private javax.swing.JComboBox<String> codeLecteurEmprunt;
    private javax.swing.JTextField codeLivre;
    private javax.swing.JTextField codeLivreDepot;
    private javax.swing.JComboBox<String> codeLivreEmprunt;
    private javax.swing.JComboBox<String> codeLivreVente;
    private com.toedter.calendar.JDateChooser dateDepotEmprunt;
    private com.toedter.calendar.JDateChooser datePub;
    private javax.swing.JTextField datePublication;
    private javax.swing.JTextField emailLecteur;
    private javax.swing.JComboBox<String> genreLecteur;
    private javax.swing.JTextField genreLecteurDepot;
    private javax.swing.JTextField genreLecteurEmprunt;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomAuteur;
    private javax.swing.JTextField nomAuteurDepot;
    private javax.swing.JTextField nomAuteurEmprunt;
    private javax.swing.JTextField nomAuteurVente;
    private javax.swing.JComboBox<String> nomCategorie;
    private javax.swing.JTextField nomCategorieDepot;
    private javax.swing.JTextField nomCategorieEmprunt;
    private javax.swing.JTextField nomLecteur;
    private javax.swing.JTextField nomLecteurDepot;
    private javax.swing.JTextField nomLecteurEmprunt;
    private javax.swing.JLabel nomUser;
    private javax.swing.JTextField prenomLecteur;
    private javax.swing.JTextField prenomLecteurDeopt;
    private javax.swing.JTextField prenomLecteurEmprunt;
    private javax.swing.JTable tableVente;
    private javax.swing.JTextField telephoneLecteur;
    private javax.swing.JTextField telephoneLecteurDepot;
    private javax.swing.JTextField telephoneLecteurEmprunt;
    private javax.swing.JTextField titreLivre;
    private javax.swing.JTextField titreLivreDepot;
    private javax.swing.JTextField titreLivreEmprunt;
    private javax.swing.JTextField titreLivreVente;
    // End of variables declaration//GEN-END:variables
}
