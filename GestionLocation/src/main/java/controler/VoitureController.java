package controler;

import dao.VoitureDAO;
import entity.Voiture;
import java.sql.SQLException;
import java.util.List;

public class VoitureController {

    private VoitureDAO voitureDAO;

    public VoitureController() {
        this.voitureDAO = new VoitureDAO();
    }

    /**
     * Ajoute une nouvelle voiture.
     *
     * @param voiture La voiture à ajouter
     * @return L'ID de la voiture créée, ou -1 en cas d'erreur
     */
    public int ajouterVoiture(Voiture voiture) {
        try {
            return voitureDAO.create(voiture);  // Returns the ID or -1 if an error occurs
        } catch (SQLException e) {
            // Log the error properly
            e.printStackTrace(); // Replace with proper logging
            return -1;  // Return -1 to indicate an error
        }
    }

    /**
     * Modifie une voiture existante.
     *
     * @param voiture La voiture modifiée
     * @return "success" si la mise à jour a réussi, "failed" sinon, ou un
     * message d'erreur détaillé
     */
    public String modifierVoiture(Voiture voiture) {
        try {
            int rowsAffected = voitureDAO.update(voiture);  // Updates the car in the database and returns rows affected

            if (rowsAffected > 0) {
                return "success";  // Return success if the update was successful
            } else {
                return "failed";  // Return failed if no rows were updated
            }
        } catch (SQLException e) {
            return "error: " + e.getMessage();  // Return a detailed error message if an exception occurs
        }
    }

    /**
     * Supprime une voiture par son immatriculation.
     *
     * @param mat L'immatriculation de la voiture à supprimer
     * @return true si la suppression a réussi, false sinon
     */
    public boolean supprimerVoiture(String mat) {
        try {
            return voitureDAO.delete(mat);  // Returns true if deletion is successful, false otherwise
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper logging
            return false;  // Return false if an error occurs
        }
    }

    /**
     * Récupère toutes les voitures.
     *
     * @return Une liste de toutes les voitures
     * @throws SQLException Si une erreur se produit lors de la récupération des
     * voitures
     */
    
    
             public List<Voiture> listerVoituresDisponible()   {
        try {
            List<Voiture> voitures = voitureDAO.getAllDisponible();  // Fetch all cars
            if (voitures.isEmpty()) {
                throw new SQLException("No cars found in the database.");  // If no cars found, throw an exception
            }
            return voitures;
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper logging
            return null;
        }
    }
    public List<Voiture> listerVoitures()   {
        try {
            List<Voiture> voitures = voitureDAO.getAll();  // Fetch all cars
            if (voitures.isEmpty()) {
                throw new SQLException("No cars found in the database.");  // If no cars found, throw an exception
            }
            return voitures;
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper logging
            return null;
        }
    }

    /**
     * Recherche une voiture par son immatriculation.
     *
     * @param immatriculation L'immatriculation de la voiture recherchée
     * @return La voiture correspondante si elle existe, sinon un Optional vide
     */
    public List<Voiture> rechercherParImmatriculation(String immatriculation) {
        try {
            // Return an Optional containing the car or an empty Optional if not found
            return (voitureDAO.getAllByMarqueOrModele(immatriculation));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Recherche des voitures par marque ou modèle.
     *
     * @param marqueOuModele La marque ou le modèle recherché
     * @return Une liste des voitures correspondantes
    
     */
    
             public List<Voiture> rechercherParMarqueOuModeleDisponible(String marqueOuModele) {
        try {
            List<Voiture> voitures = voitureDAO.getAllByMarqueOrModeleD(marqueOuModele);
            if (voitures.isEmpty()) {
                String m="NoTfound";
                throw new SQLException(m);
            }
            return voitures;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public List<Voiture> rechercherParMarqueOuModele(String marqueOuModele) {
        try {
            List<Voiture> voitures = voitureDAO.getAllByMarqueOrModele(marqueOuModele);
            if (voitures.isEmpty()) {
                throw new SQLException("No cars found");
            }
            return voitures;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public boolean setEtatLocation(String immatriculation, String etat) {
    try {
        return voitureDAO.setEtatLocation(immatriculation, etat);
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public Voiture rechercherVoiture(String imat) {
        try {
           
          Voiture  voiture = voitureDAO.getOne(imat);
            if (voiture==null) {
                throw new SQLException("No cars found");
            }
            return voiture;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
