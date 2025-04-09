package testuseCase2;

import dao.ContratDAO;
import dao.VoitureDAO;
import entity.Contrat;
import entity.Voiture;
import java.sql.SQLException;
import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContratDAOTest {

    private static ContratDAO contratDAO;
    private static VoitureDAO voitureDAO;
    private static Contrat contratTest;

    @BeforeAll
    public static void setup() throws Exception {
        contratDAO = new ContratDAO();
        voitureDAO = new VoitureDAO();

        // Préparer une voiture existante
        Voiture voiture = voitureDAO.getOne("LMN789"); 

        assertNotNull(voiture, "La voiture doit exister pour les tests.");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = sdf.parse("2025-04-01");
        Date dateFin = sdf.parse("2025-04-10");

        contratTest = new Contrat(0, "TestNom", "TestPrenom", "TESTCIN123", "CNT-JUNIT", "En cours",
                "LC-TEST", dateDebut, dateFin, "500", voiture);
    }

    @Test
    @Order(1)
    public void testCreateContrat() throws SQLException {
        boolean result = contratDAO.creat(contratTest);
        assertTrue(result, "Le contrat doit être créé.");
    }

  

    @Test
    @Order(3)
    public void testUpdateContrat() throws SQLException {
        // On suppose ici que la voiture avec immatriculation "" existe
        contratTest.getVoiture().setImmatriculation("LMN789"); // cette voiture doit exister
        contratTest.setEtatOcation("Terminée");
        boolean result = contratDAO.update(contratTest);
        assertTrue(result, "Le contrat doit être mis à jour.");
    }

    @Test
    @Order(4)
    public void testDeleteContrat() throws SQLException {
        boolean result = contratDAO.del("CNT-JUNIT");
        assertTrue(result, "Le contrat doit être supprimé.");
    }
}
