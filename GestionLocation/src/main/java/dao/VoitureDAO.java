package dao;

import entity.Voiture;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoitureDAO {

    private final Database database;

    public VoitureDAO() {
        this.database = Database.getInstance();
    }

    public int create(Voiture voiture) throws SQLException {
        String query = "INSERT INTO Voiture (Marque, Modèle, Année, Immatriculation, "
                + "TypeCarburant, Kilométrage, Couleur, NombrePortes, "
                + "TypeTransmission, NuméroChâssis, Prix, Etat) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, voiture.getMarque());
            ps.setString(2, voiture.getModele());
            ps.setString(3, voiture.getAnnee());
            ps.setString(4, voiture.getImmatriculation());
            ps.setString(5, voiture.getTypeCarburant());
            ps.setString(6, voiture.getKilometrage());
            ps.setString(7, voiture.getCouleur());
            ps.setString(8, voiture.getNombrePortes());
            ps.setString(9, voiture.getTypeTransmission());
            ps.setString(10, voiture.getNumeroChâssis());
            ps.setString(11, voiture.getPrix());
            ps.setString(12, voiture.getEtat());

            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int newId = rs.getInt(1);
                    voiture.setId(newId);
                    return newId;
                }
            }
        }
        return -1;
    }

    public int update(Voiture voiture) throws SQLException {
        String query = "UPDATE Voiture SET Marque = ?, Modèle = ?, Année = ?, "
                + "Immatriculation = ?, TypeCarburant = ?, Kilométrage = ?, "
                + "Couleur = ?, NombrePortes = ?, TypeTransmission = ?, "
                + "NuméroChâssis = ?, Prix = ?, Etat = ? "
                + "WHERE Immatriculation = ?";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, voiture.getMarque());
            ps.setString(2, voiture.getModele());
            ps.setString(3, voiture.getAnnee());
            ps.setString(4, voiture.getImmatriculation());
            ps.setString(5, voiture.getTypeCarburant());
            ps.setString(6, voiture.getKilometrage());
            ps.setString(7, voiture.getCouleur());
            ps.setString(8, voiture.getNombrePortes());
            ps.setString(9, voiture.getTypeTransmission());
            ps.setString(10, voiture.getNumeroChâssis());
            ps.setString(11, voiture.getPrix());
            ps.setString(12, voiture.getEtat());
            ps.setString(13, voiture.getImmatriculation());

            return ps.executeUpdate();
        }
    }

    public boolean delete(String mat) throws SQLException {
        String query = "DELETE FROM Voiture WHERE Immatriculation = ?";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, mat);
            ps.executeUpdate();
            return true;
        }
    }
    public List<Voiture> getAllDisponible() throws SQLException {
        List<Voiture> voitures = new ArrayList<>();
        String query = "SELECT * FROM Voiture where etat='disponible'";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                voitures.add(mapResultSetToVoiture(rs));
            }
        }
        return voitures;
    }
        
    public List<Voiture> getAll() throws SQLException {
        List<Voiture> voitures = new ArrayList<>();
        String query = "SELECT * FROM Voiture";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                voitures.add(mapResultSetToVoiture(rs));
            }
        }
        return voitures;
    }

        
         public List<Voiture> getAllByMarqueOrModeleD(String marqueOuModele) throws SQLException {
        List<Voiture> voitures = new ArrayList<>();
        String query = "SELECT * FROM Voiture WHERE Marque LIKE ? OR Modèle LIKE ? AND etat like 'disponible'";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, "%" + marqueOuModele + "%");
            ps.setString(2, "%" + marqueOuModele + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    voitures.add(mapResultSetToVoiture(rs));
                }
            }
        }
        return voitures;
    }
    public List<Voiture> getAllByMarqueOrModele(String marqueOuModele) throws SQLException {
        List<Voiture> voitures = new ArrayList<>();
        String query = "SELECT * FROM Voiture WHERE Marque LIKE ? OR Modèle LIKE ?";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, "%" + marqueOuModele + "%");
            ps.setString(2, "%" + marqueOuModele + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    voitures.add(mapResultSetToVoiture(rs));
                }
            }
        }
        return voitures;
    }
        
    public Voiture getOne(String matr) throws SQLException {
        Voiture voiture = null;
        String query = "SELECT * FROM Voiture WHERE Immatriculation = ?";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, matr);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    voiture = mapResultSetToVoiture(rs);
                }
            }
        }
        return voiture;
    }

    public Voiture getOne(int id) throws SQLException {
        Voiture voiture = null;
        String query = "SELECT * FROM Voiture WHERE ID = ?";

        try (Connection connection = database.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            try (ResultSet rst = ps.executeQuery()) {
                if (rst.next()) {
                    voiture = mapResultSetToVoiture(rst);
                }
            }
        }
        return voiture;
    }

    public Voiture mapResultSetToVoiture(ResultSet rs) throws SQLException {
        Voiture voiture = new Voiture();
        voiture.setId(rs.getInt("ID"));

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
        voiture.setPrix(rs.getString("Prix"));
        voiture.setEtat(rs.getString("Etat"));
        return voiture;
    }
    public boolean setEtatLocation(String immatriculation, String nouvelEtat) throws SQLException {
    String sql = "UPDATE Voiture SET Etat = ? WHERE Immatriculation = ?";

    try (Connection connection = database.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setString(1, nouvelEtat);
        ps.setString(2, immatriculation);

        return ps.executeUpdate() > 0;
    }
}

}
