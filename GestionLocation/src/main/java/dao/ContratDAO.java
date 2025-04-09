package dao;

import entity.Contrat;
import entity.Voiture;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContratDAO {

    VoitureDAO vDAO = new VoitureDAO();
    private final Database bd;

    public ContratDAO() {
        this.bd = Database.getInstance();
    }

    // Créer un contrat
    public boolean creat(Contrat c) throws SQLException {
        String sql = "INSERT INTO Contrat (VoitureID, NomC, PrenomC, Cin, NContrat, EtatOcation, LicenceConduit, DateDebut, DateFin, Prix) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = bd.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, c.getVoiture().getId());
            stmt.setString(2, c.getNomC());
            stmt.setString(3, c.getPrenomC());
            stmt.setString(4, c.getCin());
            stmt.setString(5, c.getnContrat());
            stmt.setString(6, c.getEtatOcation());
            stmt.setString(7, c.getLicenceConduit());
            stmt.setDate(8, new java.sql.Date(c.getDateDebut().getTime()));
            stmt.setDate(9, new java.sql.Date(c.getDateFin().getTime()));
            stmt.setString(10, c.getPrix());

            return stmt.executeUpdate() > 0;
        }
    }

  

    // Mettre à jour tout le contrat à partir de l’objet Contrat (avec matricule voiture)
    public boolean update(Contrat c) throws SQLException {
        String sqlVoiture = "SELECT ID FROM Voiture WHERE Immatriculation = ?";
        String sqlUpdate = "UPDATE Contrat SET VoitureID = ?, NomC = ?, PrenomC = ?, Cin = ?, NContrat = ?, EtatOcation = ?, LicenceConduit = ?, DateDebut = ?, DateFin = ?, Prix = ? WHERE NContrat = ?";

        try (
                PreparedStatement stmtVoiture = bd.getConnection().prepareStatement(sqlVoiture); 
                PreparedStatement stmtUpdate = bd.getConnection().prepareStatement(sqlUpdate)) {
            // Obtenir l'ID de la voiture
            stmtVoiture.setString(1, c.getVoiture().getImmatriculation());
            ResultSet rs = stmtVoiture.executeQuery();
            if (!rs.next()) {
                return false; // voiture non trouvée
            }
            int voitureID = rs.getInt("ID");

            // Mise à jour du contrat
            stmtUpdate.setInt(1, voitureID);
            stmtUpdate.setString(2, c.getNomC());
            stmtUpdate.setString(3, c.getPrenomC());
            stmtUpdate.setString(4, c.getCin());
            stmtUpdate.setString(5, c.getnContrat());
            stmtUpdate.setString(6, c.getEtatOcation());
            stmtUpdate.setString(7, c.getLicenceConduit());
            stmtUpdate.setDate(8, new java.sql.Date(c.getDateDebut().getTime()));
            stmtUpdate.setDate(9, new java.sql.Date(c.getDateFin().getTime()));
            stmtUpdate.setString(10, c.getPrix());
            stmtUpdate.setString(11, c.getnContrat());

            return stmtUpdate.executeUpdate() > 0;
        }
    }

    // Supprimer un contrat
    public boolean del(String nContrat) throws SQLException {
        String sql = "DELETE FROM Contrat WHERE NContrat = ?";
        try (PreparedStatement stmt = bd.getConnection().prepareStatement(sql)) {
            stmt.setString(1, nContrat);

            return stmt.executeUpdate() > 0;
        }
    }

    public List<Contrat> getAll() throws SQLException {
        List<Contrat> contrats = new ArrayList<>();
        String sqlContrats = "SELECT * FROM Contrat";
        String sqlVoitures = "SELECT * FROM Voiture";  // Requête pour récupérer toutes les voitures

        try (
                Statement stmtContrats = bd.getConnection().createStatement(); ResultSet rsContrats = stmtContrats.executeQuery(sqlContrats); Statement stmtVoitures = bd.getConnection().createStatement(); ResultSet rsVoitures = stmtVoitures.executeQuery(sqlVoitures)) {
            // Créer un Map pour stocker les voitures par ID
            Map<Integer, Voiture> voituresMap = new HashMap<>();
            while (rsVoitures.next()) {
                Voiture voiture = vDAO.mapResultSetToVoiture(rsVoitures);  // Assurez-vous que cette méthode existe pour mapper les résultats
                voituresMap.put(voiture.getId(), voiture);
            }

            // Parcours des contrats et ajout des voitures associées
            while (rsContrats.next()) {
                int voitureId = rsContrats.getInt("VoitureID");
                Voiture voiture = voituresMap.get(voitureId);  // Récupérer la voiture associée au contrat

                Contrat contrat = new Contrat(
                        rsContrats.getInt("ID"),
                        rsContrats.getString("NomC"),
                        rsContrats.getString("PrenomC"),
                        rsContrats.getString("Cin"),
                        rsContrats.getString("NContrat"),
                        rsContrats.getString("EtatOcation"),
                        rsContrats.getString("LicenceConduit"),
                        rsContrats.getDate("DateDebut"),
                        rsContrats.getDate("DateFin"),
                        rsContrats.getString("Prix"),
                        voiture
                );
                contrats.add(contrat);
               
            }
        }
        return contrats;
    }

    

    public List<Contrat> searchContrats(String searchTerm) throws SQLException {
        List<Contrat> contrats = new ArrayList<>();

        String sql = "SELECT "
                + "c.ID AS ContratID, c.NomC, c.PrenomC, c.Cin, c.NContrat, c.EtatOcation, c.LicenceConduit, "
                + "c.DateDebut, c.DateFin, c.Prix, "
                + "v.ID AS VoitureID, v.Marque, v.Modèle, v.Année, v.Immatriculation, "
                + "v.TypeCarburant, v.Kilométrage, v.Couleur, v.NombrePortes, "
                + "v.TypeTransmission, v.NuméroChâssis, v.Prix AS VoiturePrix, v.Etat AS VoitureEtat "
                + "FROM Contrat c "
                + "JOIN Voiture v ON c.VoitureID = v.ID "
                + "WHERE c.NContrat LIKE ? OR c.NomC LIKE ? OR c.PrenomC LIKE ?";

        try (PreparedStatement stmt = bd.getConnection().prepareStatement(sql)) {
            String searchPattern = "%" + searchTerm + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Voiture voiture = new Voiture();
                    voiture.setId(rs.getInt("VoitureID"));
                    voiture.setMarque(rs.getString("Marque"));
                    voiture.setModele(rs.getString("Modèle"));
                    voiture.setAnnee(rs.getString("Année"));
                    voiture.setImmatriculation(rs.getString("Immatriculation"));
                    voiture.setTypeCarburant(rs.getString("TypeCarburant"));
                    voiture.setKilometrage(rs.getString("Kilométrage"));
                    voiture.setCouleur(rs.getString("Couleur"));
                    voiture.setNombrePortes(rs.getString("NombrePortes"));
                    voiture.setTypeTransmission(rs.getString("TypeTransmission"));
                    voiture.setNumeroChâssis(rs.getString("NuméroChâssis"));
                    voiture.setPrix(rs.getString("VoiturePrix"));
                    voiture.setEtat(rs.getString("VoitureEtat"));

                    Contrat contrat = new Contrat(
                            rs.getInt("ContratID"),
                            rs.getString("NomC"),
                            rs.getString("PrenomC"),
                            rs.getString("Cin"),
                            rs.getString("NContrat"),
                            rs.getString("EtatOcation"),
                            rs.getString("LicenceConduit"),
                            rs.getDate("DateDebut"),
                            rs.getDate("DateFin"),
                            rs.getString("Prix"),
                            voiture
                    );

                    contrats.add(contrat);
                }
            }
        }

        return contrats;
    }

    

}
