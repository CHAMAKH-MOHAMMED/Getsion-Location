package controler;

import dao.ContratDAO;
import entity.Contrat;
import java.sql.SQLException;
import java.util.List;

public class ContratController {

    private final ContratDAO contratDAO;

    public ContratController() {
        this.contratDAO = new ContratDAO();
    }

    // Créer un contrat
    public boolean createContrat(Contrat contrat) {
        try {
            if (contrat == null) {
                throw new IllegalArgumentException("Le contrat ne peut pas être null.");
            }
            return contratDAO.creat(contrat);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création du contrat : " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation : " + e.getMessage());
            return false;
        }
    }

    // Mettre à jour un contrat
    public boolean updateContrat(Contrat contrat) {
        try {
            if (contrat == null ) {
                throw new IllegalArgumentException("Le contrat ou son ID est invalide.");
            }
            return contratDAO.update(contrat);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du contrat : " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation : " + e.getMessage());
            return false;
        }
    }

    // Mettre à jour l'état du contrat (par son numéro de contrat)
    public boolean updateContratEtat(String nContrat, String etat) {
        try {
            if (nContrat == null || nContrat.isEmpty()) {
                throw new IllegalArgumentException("Le numéro du contrat est invalide.");
            }
            return contratDAO.update(nContrat);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'état du contrat : " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation : " + e.getMessage());
            return false;
        }
    }

    // Supprimer un contrat
    public boolean deleteContrat(String nContrat) {
        try {
            if (nContrat == null || nContrat.isEmpty()) {
                throw new IllegalArgumentException("Le numéro du contrat est invalide.");
            }
            return contratDAO.del(nContrat);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du contrat : " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation : " + e.getMessage());
            return false;
        }
    }

    // Récupérer un contrat par son ID
    public Contrat getContratById(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("L'ID du contrat est invalide.");
            }
            return contratDAO.getOne(id);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du contrat par ID : " + e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation : " + e.getMessage());
            return null;
        }
    }

    // Récupérer tous les contrats
    public List<Contrat> getAllContrats() {
        try {
            return contratDAO.getAll();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de tous les contrats : " + e.getMessage());
            return null;
        }
    }

    // Récupérer un contrat par le numéro de contrat
    public Contrat getContratByNum(String nContrat) {
        try {
            if (nContrat == null || nContrat.isEmpty()) {
                throw new IllegalArgumentException("Le numéro du contrat est invalide.");
            }
            return contratDAO.getAll().stream()
                    .filter(contrat -> contrat.getnContrat().equals(nContrat))
                    .findFirst()
                    .orElse(null);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du contrat par numéro : " + e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation : " + e.getMessage());
            return null;
        }
    }
      public Contrat getContratBySearch(String nContratOrNomOrPrenom) {
    try {
        // Vérification si l'argument de recherche est valide
        if (nContratOrNomOrPrenom == null || nContratOrNomOrPrenom.isEmpty()) {
            throw new IllegalArgumentException("La recherche ne peut pas être vide.");
        }
        
        // Recherche parmi les contrats en filtrant sur nContrat, NomC ou PrenomC
        return contratDAO.searchContrats(nContratOrNomOrPrenom).stream()
                .filter(contrat -> 
                    contrat.getnContrat().equalsIgnoreCase(nContratOrNomOrPrenom) ||
                    contrat.getNomC().equalsIgnoreCase(nContratOrNomOrPrenom) ||
                    contrat.getPrenomC().equalsIgnoreCase(nContratOrNomOrPrenom)
                )
                .findFirst()
                .orElse(null);
    } catch (SQLException e) {
        System.err.println("Erreur lors de la récupération du contrat : " + e.getMessage());
        return null;
    } catch (IllegalArgumentException e) {
        System.err.println("Erreur de validation : " + e.getMessage());
        return null;
    }

}
       public List<Contrat> getContratSearch(String nContratOrNomOrPrenom) {
    try {
        
        
        // Recherche parmi les contrats en filtrant sur nContrat, NomC ou PrenomC
        
        
      List<Contrat> l = contratDAO.searchContrats(nContratOrNomOrPrenom);
        System.out.println(l);
      return l;
   
    } catch (Exception e) {
        System.err.println("Erreur de validation : " + e.getMessage());
        return null;
    }

}
}