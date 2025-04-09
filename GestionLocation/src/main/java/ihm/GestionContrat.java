/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ihm;

// Ajoutez cette ligne en haut de GestionContrat.java
import com.toedter.calendar.JDateChooser;
import controler.ContratController;
import controler.VoitureController;
import entity.Contrat;
import entity.Voiture;
import java.awt.BorderLayout;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionContrat extends javax.swing.JFrame {

    private JDateChooser dateChooserDebut;
    private JDateChooser dateChooserFin;
    VoitureController voitureControleur = new VoitureController();
    ContratController contratControler = new ContratController();

    DefaultTableModel modelTv;
    DefaultTableModel modelTc;

    public GestionContrat() {
        initComponents();

        // Configuration pour DateDebut
        dateChooserDebut = new JDateChooser();
        dateChooserDebut.setDateFormatString("dd/MM/yyyy"); // Format de date
        PanelDateDebut.setLayout(new BorderLayout()); // Définir le layout
        PanelDateDebut.add(dateChooserDebut); // Ajouter au panel

        // Configuration pour DateFin
        dateChooserFin = new JDateChooser();
        dateChooserFin.setDateFormatString("dd/MM/yyyy");
        PaneldateFin.setLayout(new BorderLayout()); // Nom correct du panel (attention aux majuscules)
        PaneldateFin.add(dateChooserFin); // Ajouter dateChooserFin, pas le panel
        //les table des contrat table voiture
        modelTv = (DefaultTableModel) tableVoitures.getModel();
        modelTc = (DefaultTableModel) tableContrat.getModel();
    }

    public void listerV() {
        List<Voiture> voitures = voitureControleur.listerVoituresDisponible();
        modelTv.setRowCount(0); // Vider la table avant de la remplir
        for (Voiture voiture : voitures) {
            modelTv.addRow(voiture.toArrayContrat());
        }
    }

    public void listerC() {
        List<Contrat> contraes = contratControler.getAllContrats();
        modelTc.setRowCount(0); // Vider la table avant de la remplir
        for (Contrat c : contraes) {
            modelTc.addRow(c.toArray());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupeEtat = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomClient = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCINClient = new javax.swing.JTextField();
        txtContratId = new javax.swing.JTextField();
        txtPrenomClient = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrix = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        licenceConduit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        optEnCours = new javax.swing.JRadioButton();
        optTerminer = new javax.swing.JRadioButton();
        PaneldateFin = new javax.swing.JPanel();
        PanelDateDebut = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cmdDetails = new javax.swing.JButton();
        cmdSupprimer = new javax.swing.JButton();
        cmdAjouter = new javax.swing.JButton();
        cmdModifier = new javax.swing.JButton();
        txtSearchContrat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVoitures = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableContrat = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtSearchVoitures = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtContrat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des Contrat");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Adminstration des Contrat");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nom");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Contrat ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Prenom");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("CIN");

        txtContratId.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Date Fin");

        txtPrix.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrix.setEnabled(false);
        txtPrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrixActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Date Debut");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Prix");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Licence Conduit");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Etat de L'ocations ");

        GroupeEtat.add(optEnCours);
        optEnCours.setSelected(true);
        optEnCours.setText("Au Cours");

        GroupeEtat.add(optTerminer);
        optTerminer.setText("Terminer");

        PaneldateFin.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PaneldateFinLayout = new javax.swing.GroupLayout(PaneldateFin);
        PaneldateFin.setLayout(PaneldateFinLayout);
        PaneldateFinLayout.setHorizontalGroup(
            PaneldateFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );
        PaneldateFinLayout.setVerticalGroup(
            PaneldateFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        PanelDateDebut.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelDateDebutLayout = new javax.swing.GroupLayout(PanelDateDebut);
        PanelDateDebut.setLayout(PanelDateDebutLayout);
        PanelDateDebutLayout.setHorizontalGroup(
            PanelDateDebutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        PanelDateDebutLayout.setVerticalGroup(
            PanelDateDebutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(PanelDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContratId, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrenomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(PaneldateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtPrix, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241)))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(licenceConduit, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCINClient, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optEnCours, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optTerminer)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrenomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContratId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCINClient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(licenceConduit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optEnCours)
                    .addComponent(optTerminer))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PaneldateFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(PanelDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrix, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Actions");

        cmdDetails.setBackground(new java.awt.Color(153, 153, 153));
        cmdDetails.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdDetails.setForeground(new java.awt.Color(0, 255, 204));
        cmdDetails.setText("Details");
        cmdDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDetailsActionPerformed(evt);
            }
        });

        cmdSupprimer.setBackground(new java.awt.Color(153, 153, 153));
        cmdSupprimer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdSupprimer.setForeground(new java.awt.Color(0, 255, 204));
        cmdSupprimer.setText("Supprimer");
        cmdSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSupprimerActionPerformed(evt);
            }
        });

        cmdAjouter.setBackground(new java.awt.Color(153, 153, 153));
        cmdAjouter.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdAjouter.setForeground(new java.awt.Color(0, 255, 204));
        cmdAjouter.setText("Ajouter");
        cmdAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAjouterActionPerformed(evt);
            }
        });

        cmdModifier.setBackground(new java.awt.Color(153, 153, 153));
        cmdModifier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdModifier.setForeground(new java.awt.Color(0, 255, 204));
        cmdModifier.setText("Modifier");
        cmdModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmdModifier, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(cmdAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmdSupprimer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        txtSearchContrat.setBackground(new java.awt.Color(255, 255, 255));

        tableVoitures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Marque", "module", "prix/jaur", "matricule"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableVoitures);

        tableContrat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "client", "etat", "prix", "nContrat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableContrat);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Rechercher Contrat");

        txtSearchVoitures.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchVoituresKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Rechercher Voitures");

        txtContrat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContratKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout txtSearchContratLayout = new javax.swing.GroupLayout(txtSearchContrat);
        txtSearchContrat.setLayout(txtSearchContratLayout);
        txtSearchContratLayout.setHorizontalGroup(
            txtSearchContratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(txtSearchContratLayout.createSequentialGroup()
                .addGroup(txtSearchContratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtSearchContratLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(txtContrat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtSearchVoitures, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txtSearchContratLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txtSearchContratLayout.setVerticalGroup(
            txtSearchContratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSearchContratLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(txtSearchContratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchVoitures, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(txtContrat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtSearchContratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(txtSearchContrat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearchContrat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrixActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        listerV();

        listerC();
    }//GEN-LAST:event_formWindowOpened

    private void cmdAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAjouterActionPerformed
        // Récupération des valeurs depuis les champs
        String nom = txtNomClient.getText().trim();
        String prenom = txtPrenomClient.getText().trim();
        String cin = txtCINClient.getText().trim();
        String licence = licenceConduit.getText().trim();
        Date dateDebut = dateChooserDebut.getDate();
        Date dateFin = dateChooserFin.getDate();
        String etat = (optEnCours.isSelected()) ? "Au Cours" : "Terminé";

// Vérification des champs obligatoires
        if (nom.isEmpty() || prenom.isEmpty() || cin.isEmpty() || licence.isEmpty()
                || dateDebut == null || dateFin == null || tableVoitures.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires et sélectionner une voiture.");
            return;
        }

// Vérification que la date de début est avant la date de fin
        if (!dateFin.after(dateDebut)) {
            JOptionPane.showMessageDialog(null, "La date de fin doit être après la date de début.");
            return;
        }

// Générer un numéro de contrat unique
        String nContrat = "C" + System.currentTimeMillis();
        //  VERFIER CHOISER UNE DATE 
        int selectedRow = tableVoitures.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une voiture dans la liste.");
            return;
        }
// Récupérer l'immatriculation sélectionnée dans le tableau
        String immatriculation = modelTv.getValueAt(tableVoitures.getSelectedRow(), 3).toString();

// Rechercher la voiture par son immatriculation
        Voiture voiture = voitureControleur.rechercherVoiture(immatriculation);
        if (voiture == null) {
            JOptionPane.showMessageDialog(null, "Voiture introuvable !");
            return;
        }

// Récupérer le prix (supposé être une chaîne représentant un nombre) et convertir en double
        double prixJour = 0;
        try {
            prixJour = Double.parseDouble(voiture.getPrix());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Le prix de la voiture est invalide.");
            return;
        }

// Calcul du nombre de jours entre les deux dates
        long diffMillis = dateFin.getTime() - dateDebut.getTime();
        long nbJours = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
        if (nbJours <= 0) {
            nbJours = 1; // Minimum 1 jour
        }
// Calcul du prix total
        String prixTotal = String.valueOf(prixJour * nbJours);

// Création du contrat
        Contrat contrat = new Contrat(
                nom,
                prenom,
                cin,
                nContrat,
                etat,
                licence,
                dateDebut,
                dateFin,
                prixTotal,
                voiture
        );

// Création du contrat via le contrôleur
        boolean isCreated = contratControler.createContrat(contrat);

        if (isCreated) {
            // Mettre à jour l'état de la voiture
            boolean isEtatUpdated = voitureControleur.setEtatLocation(immatriculation, "Indisponible");

            if (isEtatUpdated) {
                JOptionPane.showMessageDialog(null, "Le contrat a été créé avec succès.\nLa voiture est maintenant marquée comme 'Indisponible'.");
            } else {
                JOptionPane.showMessageDialog(null, "Le contrat a été créé, mais l'état de la voiture n'a pas pu être mis à jour.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erreur lors de la création du contrat.");
        }

// Vider les champs du f après création
        txtNomClient.setText("");
        txtPrenomClient.setText("");
        txtCINClient.setText("");
        licenceConduit.setText("");
        dateChooserDebut.setDate(null);
        dateChooserFin.setDate(null);
        GroupeEtat.clearSelection();
        tableVoitures.clearSelection();
        listerC();
        listerV();

    }//GEN-LAST:event_cmdAjouterActionPerformed

    private void txtSearchVoituresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchVoituresKeyReleased
        List<Voiture> voitures = voitureControleur.rechercherParMarqueOuModeleDisponible(txtSearchVoitures.getText());
        modelTv.setRowCount(0);
        for (Voiture voiture : voitures) {
            modelTv.addRow(voiture.toArray());
        }
    }//GEN-LAST:event_txtSearchVoituresKeyReleased

    private void txtContratKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContratKeyReleased
        List<Contrat> contrates = contratControler.getContratSearch(txtContrat.getText());
        modelTc.setRowCount(0); // Vider la table avant de la remplir
        for (Contrat c : contrates) {
            modelTc.addRow(c.toArray());
        }

    }//GEN-LAST:event_txtContratKeyReleased

    private void cmdModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModifierActionPerformed

        // Récupération des valeurs depuis les champs
        String nom = txtNomClient.getText().trim();
        String prenom = txtPrenomClient.getText().trim();
        String cin = txtCINClient.getText().trim();
        String licence = licenceConduit.getText().trim();
        Date dateDebut = dateChooserDebut.getDate();
        Date dateFin = dateChooserFin.getDate();
        String etat = (optEnCours.isSelected()) ? "Au Cours" : "Terminé";
        

// Vérification des champs obligatoires
        if (nom.isEmpty() || prenom.isEmpty() || cin.isEmpty() || licence.isEmpty()
                || dateDebut == null || dateFin == null || tableVoitures.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires et sélectionner une voiture.");
            return;
        }

// Vérification que la date de début est avant la date de fin
        if (!dateFin.after(dateDebut)) {
            JOptionPane.showMessageDialog(null, "La date de fin doit être après la date de début.");
            return;
        }

// Générer un numéro de contrat unique
        String nContrat = txtContratId.getText().trim();
        //  VERFIER CHOISER UNE DATE 
        int selectedRow = tableVoitures.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une voiture dans la liste.");
            return;
        }
// Récupérer l'immatriculation sélectionnée dans le tableau
        String immatriculation = modelTv.getValueAt(tableVoitures.getSelectedRow(), 3).toString();

// Rechercher la voiture par son immatriculation
        Voiture voiture = voitureControleur.rechercherVoiture(immatriculation);
        if (voiture == null) {
            JOptionPane.showMessageDialog(null, "Voiture introuvable !");
            return;
        }

// Récupérer le prix (supposé être une chaîne représentant un nombre) et convertir en double
        double prixJour = 0;
        try {
            prixJour = Double.parseDouble(voiture.getPrix());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Le prix de la voiture est invalide.");
            return;
        }

// Calcul du nombre de jours entre les deux dates
        long diffMillis = dateFin.getTime() - dateDebut.getTime();
        long nbJours = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
        if (nbJours <= 0) {
            nbJours = 1; // Minimum 1 jour
        }
// Calcul du prix total
        String prixTotal = String.valueOf(prixJour * nbJours);

// Création du contrat
        Contrat contrat = new Contrat(
                nom,
                prenom,
                cin,
                nContrat,
                etat,
                licence,
                dateDebut,
                dateFin,
                prixTotal,
                voiture
        );

// Création du contrat via le contrôleur
        boolean isModfier = contratControler.updateContrat(contrat);

        if (isModfier) {
            JOptionPane.showMessageDialog(null, "Le contrat a été modfier avec succès.\nLa voiture est maintenant marquée comme 'Indisponible'.");

        } else {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modifications du contrat.");
        }

// Vider les champs du f après création
        txtNomClient.setText("");
        txtPrenomClient.setText("");
        txtCINClient.setText("");
        licenceConduit.setText("");
        dateChooserDebut.setDate(null);
        dateChooserFin.setDate(null);
        GroupeEtat.clearSelection();
        tableVoitures.clearSelection();
        txtContratId.setText("");
        txtPrix.setText("");
        listerC();
        listerV();

    }//GEN-LAST:event_cmdModifierActionPerformed

    private void cmdDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDetailsActionPerformed
        String nContrat = tableContrat.getValueAt(tableContrat.getSelectedRow(), 3).toString();
        if (nContrat == null) {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un contrat.");
            return;
        }

        Contrat contrat = contratControler.getContratByNum(nContrat);
        if (contrat == null) {
            JOptionPane.showMessageDialog(null, "Contrat introuvable.");
            return;
        }

// Remplir les champs avec les infos du contrat
        txtNomClient.setText(contrat.getNomC());
        txtPrenomClient.setText(contrat.getPrenomC());
        txtCINClient.setText(contrat.getCin());
        licenceConduit.setText(contrat.getLicenceConduit());
        dateChooserDebut.setDate(contrat.getDateDebut());
        dateChooserFin.setDate(contrat.getDateFin());
        txtPrix.setText(contrat.getPrix());
        txtContratId.setText(contrat.getnContrat());

        if ("Au Cours".equalsIgnoreCase(contrat.getEtatOcation())) {
            optEnCours.setSelected(true);
        } else {
            optTerminer.setSelected(true);
        }

// Trouver la voiture dans le tableau des voitures
        modelTv.setRowCount(0);

        modelTv.addRow(contrat.getVoiture().toArrayContrat());
        tableVoitures.setRowSelectionInterval(0, 0);


    }//GEN-LAST:event_cmdDetailsActionPerformed

    private void cmdSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSupprimerActionPerformed
      
         String nContrat = tableContrat.getValueAt(tableContrat.getSelectedRow(), 3).toString();
           if (nContrat == null) {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un contrat.");
            return;
        }
         contratControler.deleteContrat(nContrat);
         listerC();
         listerV();
    }//GEN-LAST:event_cmdSupprimerActionPerformed

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
            java.util.logging.Logger.getLogger(GestionContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionContrat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupeEtat;
    private javax.swing.JPanel PanelDateDebut;
    private javax.swing.JPanel PaneldateFin;
    private javax.swing.JButton cmdAjouter;
    private javax.swing.JButton cmdDetails;
    private javax.swing.JButton cmdModifier;
    private javax.swing.JButton cmdSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField licenceConduit;
    private javax.swing.JRadioButton optEnCours;
    private javax.swing.JRadioButton optTerminer;
    private javax.swing.JTable tableContrat;
    private javax.swing.JTable tableVoitures;
    private javax.swing.JTextField txtCINClient;
    private javax.swing.JTextField txtContrat;
    private javax.swing.JTextField txtContratId;
    private javax.swing.JTextField txtNomClient;
    private javax.swing.JTextField txtPrenomClient;
    private javax.swing.JTextField txtPrix;
    private javax.swing.JPanel txtSearchContrat;
    private javax.swing.JTextField txtSearchVoitures;
    // End of variables declaration//GEN-END:variables
}
