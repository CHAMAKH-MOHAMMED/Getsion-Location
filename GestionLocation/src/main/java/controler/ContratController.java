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
            return false;
        } catch (IllegalArgumentException e) {
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
            return false;
        } catch (IllegalArgumentException e) {
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
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

   

    // Récupérer tous les contrats
    public List<Contrat> getAllContrats() {
        try {
            return contratDAO.getAll();
        } catch (SQLException e) {
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
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
      
       public List<Contrat> getContratSearch(String nContratOrNomOrPrenom) {
    try {
        
        
        // Recherche parmi les contrats en filtrant sur nContrat, NomC ou PrenomC
        
        
      List<Contrat> l = contratDAO.searchContrats(nContratOrNomOrPrenom);
        
      return l;
   
    } catch (Exception e) {
        return null;
    }

}
}