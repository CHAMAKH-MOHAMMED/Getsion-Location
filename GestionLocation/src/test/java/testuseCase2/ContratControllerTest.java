package testuseCase2;

import controler.ContratController;

import dao.VoitureDAO;
import entity.Contrat;
import entity.Voiture;
import org.junit.jupiter.api.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContratControllerTest {

    private static ContratController contratController;
    private static VoitureDAO voitureDAO;
    private static Contrat testContrat;
    private static final String TEST_NUM_CONTRAT = "CTRLTEST123";
    private static final String TEST_IMMATRICULATION = "TESTCTRL456";

    @BeforeAll
    static void setUp() {
        contratController = new ContratController();
        voitureDAO = new VoitureDAO();
        
        // Create test voiture first
        Voiture testVoiture = createTestVoiture();
        
        // Create test contrat
        testContrat = new Contrat();
        testContrat.setVoiture(testVoiture);
        testContrat.setNomC("TestController");
        testContrat.setPrenomC("Test");
        testContrat.setCin("TESTCTRL123");
        testContrat.setnContrat(TEST_NUM_CONTRAT);
        testContrat.setEtatOcation("En cours");
        testContrat.setLicenceConduit("TESTLIC123");
        testContrat.setDateDebut(new Date(System.currentTimeMillis()));
        testContrat.setDateFin(new Date(System.currentTimeMillis() + 86400000 * 7)); // 7 days later
        testContrat.setPrix("1500");
    }

    private static Voiture createTestVoiture() {
        Voiture voiture = new Voiture();
        voiture.setMarque("TestController");
        voiture.setModele("TestModel");
        voiture.setAnnee("2023");
        voiture.setImmatriculation(TEST_IMMATRICULATION);
        voiture.setTypeCarburant("Essence");
        voiture.setKilometrage("10000");
        voiture.setCouleur("Noir");
        voiture.setNombrePortes("4");
        voiture.setTypeTransmission("Auto");
        voiture.setNumeroChâssis("TESTCHASSISCTRL");
        voiture.setPrix("25000");
        voiture.setEtat("Disponible");
        
        try {
            int id = voitureDAO.create(voiture);
            voiture.setId(id);
        } catch (SQLException e) {
            fail("Failed to create test voiture");
        }
        return voiture;
    }

    @Test
    @Order(1)
    void testCreateContrat() {
        boolean result = contratController.createContrat(testContrat);
        assertTrue(result, "La création du contrat devrait réussir");
    }

    @Test
    @Order(2)
    void testGetContratByNum() {
        Contrat found = contratController.getContratByNum(TEST_NUM_CONTRAT);
        assertNotNull(found, "Le contrat devrait être trouvé");
        assertEquals("TestController", found.getNomC());
    }

    @Test
    @Order(3)
    void testGetAllContrats() {
        List<Contrat> contrats = contratController.getAllContrats();
        assertNotNull(contrats, "La liste ne devrait pas être null");
        assertFalse(contrats.isEmpty(), "La liste ne devrait pas être vide");
    }

    @Test
    @Order(4)
    void testGetContratSearch() {
        // Test search by contract number
        List<Contrat> results = contratController.getContratSearch(TEST_NUM_CONTRAT);
        assertNotNull(results, "La recherche ne devrait pas retourner null");
        assertEquals(1, results.size(), "La recherche devrait trouver exactement un contrat");
        
        // Test search by last name
        results = contratController.getContratSearch("TestController");
        assertFalse(results.isEmpty(), "La recherche par nom devrait trouver des résultats");
        
        // Test search by first name
        results = contratController.getContratSearch("Test");
        assertFalse(results.isEmpty(), "La recherche par prénom devrait trouver des résultats");
    }

    @Test
    @Order(5)
    void testUpdateContrat() {
        testContrat.setPrix("2000");
        boolean result = contratController.updateContrat(testContrat);
        assertTrue(result, "La mise à jour devrait réussir");
        
        Contrat updated = contratController.getContratByNum(TEST_NUM_CONTRAT);
        assertEquals("2000", updated.getPrix(), "Le prix devrait être mis à jour");
    }

    @Test
    @Order(6)
    void testDeleteContrat() {
        boolean result = contratController.deleteContrat(TEST_NUM_CONTRAT);
        assertTrue(result, "La suppression devrait réussir");
        
        Contrat deleted = contratController.getContratByNum(TEST_NUM_CONTRAT);
        assertNull(deleted, "Le contrat devrait être supprimé");
    }

    @Test
    @Order(7)
    void testCleanUpTestVoiture() {
        try {
            boolean deleted = voitureDAO.delete(TEST_IMMATRICULATION);
            assertTrue(deleted, "La suppression de la voiture test devrait réussir");
        } catch (SQLException e) {
            fail("Failed to clean up test voiture");
        }
    }

    @Test
    void testCreateContratWithNull() {
        boolean result = contratController.createContrat(null);
        assertFalse(result, "Devrait échouer avec un contrat null");
    }

    @Test
    void testUpdateContratWithNull() {
        boolean result = contratController.updateContrat(null);
        assertFalse(result, "Devrait échouer avec un contrat null");
    }

    @Test
    void testDeleteContratWithInvalidNum() {
        boolean result = contratController.deleteContrat("");
        assertFalse(result, "Devrait échouer avec un numéro de contrat vide");
        
        result = contratController.deleteContrat(null);
        assertFalse(result, "Devrait échouer avec un numéro de contrat null");
    }

    @Test
    void testGetContratByInvalidNum() {
        Contrat result = contratController.getContratByNum("");
        assertNull(result, "Devrait retourner null avec un numéro de contrat vide");
        
        result = contratController.getContratByNum(null);
        assertNull(result, "Devrait retourner null avec un numéro de contrat null");
    }
}