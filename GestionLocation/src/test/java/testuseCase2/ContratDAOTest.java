package dao;

import entity.Contrat;
import entity.Voiture;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContratDAOTest {

    private static ContratDAO contratDAO;
    private static VoitureDAO voitureDAO;
    private static Contrat contratTest;
    private static Voiture voitureTest;
    private static String testNContrat = "C_TEST123";

    @BeforeAll
    static void setUp() {
        contratDAO = new ContratDAO();
        voitureDAO = new VoitureDAO();

        // Create test voiture first
        voitureTest = new Voiture();
        voitureTest.setMarque("TestMarque");
        voitureTest.setModele("TestModel");
        voitureTest.setAnnee("2023");
        voitureTest.setImmatriculation("TEST123");
        voitureTest.setTypeCarburant("Essence");
        voitureTest.setKilometrage("10000");
        voitureTest.setCouleur("Noir");
        voitureTest.setNombrePortes("4");
        voitureTest.setTypeTransmission("Auto");
        voitureTest.setNumeroChâssis("TESTCHASSIS123");
        voitureTest.setPrix("25000");
        voitureTest.setEtat("Disponible");

        // Create test contrat
        contratTest = new Contrat();
        contratTest.setVoiture(voitureTest);
        contratTest.setNomC("TestNom");
        contratTest.setPrenomC("TestPrenom");
        contratTest.setCin("TESTCIN123");
        contratTest.setnContrat(testNContrat);
        contratTest.setEtatOcation("En cours");
        contratTest.setLicenceConduit("TESTLIC123");
        contratTest.setDateDebut(new Date(System.currentTimeMillis()));
        contratTest.setDateFin(new Date(System.currentTimeMillis() + 86400000 * 7)); // 7 days later
        contratTest.setPrix("1500");
    }

    @Test
    @Order(1)
    void testCreateVoitureForContrat() throws SQLException {
        // First create the test voiture
        int voitureId = voitureDAO.create(voitureTest);
        assertTrue(voitureId > 0, "La création de la voiture test a échoué");
        voitureTest.setId(voitureId);
    }

    @Test
    @Order(2)
    void testCreateContrat() throws SQLException {
        boolean created = contratDAO.creat(contratTest);
        assertTrue(created, "La création du contrat a échoué");
    }

    @Test
    @Order(3)
    void testGetAllContrats() throws SQLException {
        List<Contrat> contrats = contratDAO.getAll();
        assertFalse(contrats.isEmpty(), "La liste des contrats ne devrait pas être vide");
        
        // Verify our test contrat is in the list
        boolean found = false;
        for (Contrat c : contrats) {
            if (testNContrat.equals(c.getnContrat())) {
                found = true;
                break;
            }
        }
        assertTrue(found, "Le contrat test devrait être dans la liste");
    }

    @Test
    @Order(4)
    void testSearchContrats() throws SQLException {
        List<Contrat> results = contratDAO.searchContrats("TestNom");
        assertFalse(results.isEmpty(), "La recherche devrait retourner des résultats");
        assertEquals("TestNom", results.get(0).getNomC());
        
        results = contratDAO.searchContrats(testNContrat);
        assertFalse(results.isEmpty(), "La recherche par numéro de contrat devrait retourner un résultat");
        assertEquals(testNContrat, results.get(0).getnContrat());
    }

    @Test
    @Order(5)
    void testUpdateContrat() throws SQLException {
        // Get the contrat first
        List<Contrat> contrats = contratDAO.searchContrats(testNContrat);
        assertFalse(contrats.isEmpty(), "Le contrat test devrait exister");
        
        Contrat toUpdate = contrats.get(0);
        toUpdate.setPrix("2000");
        
        boolean updated = contratDAO.update(toUpdate);
        assertTrue(updated, "La mise à jour du contrat a échoué");
        
        // Verify update
        Contrat updatedContrat = contratDAO.searchContrats(testNContrat).get(0);
        assertEquals("2000", updatedContrat.getPrix(), "Le prix n'a pas été mis à jour correctement");
    }

    @Test
    @Order(6)
    void testDeleteContrat() throws SQLException {
        boolean deleted = contratDAO.del(testNContrat);
        assertTrue(deleted, "La suppression du contrat a échoué");
        
        // Verify deletion
        List<Contrat> results = contratDAO.searchContrats(testNContrat);
        assertTrue(results.isEmpty(), "Le contrat devrait être supprimé");
    }

    @Test
    @Order(7)
    void testDeleteVoitureTest() throws SQLException {
        // Clean up by deleting the test voiture
        boolean deleted = voitureDAO.delete("TEST123");
        assertTrue(deleted, "La suppression de la voiture test a échoué");
    }
}