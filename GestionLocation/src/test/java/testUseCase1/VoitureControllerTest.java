package testUseCase1;

import controler.VoitureController;
import dao.VoitureDAO;
import entity.Voiture;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VoitureControllerTest {

    private static VoitureController voitureController;
    private static Voiture testVoiture;
    private static final String TEST_IMMATRICULATION = "PQR456";

    @BeforeAll
    static void setUp() {
        voitureController = new VoitureController();
        
        // Create test voiture object
        testVoiture = new Voiture();
        testVoiture.setMarque("TestController");
        testVoiture.setModele("TestModel");
        testVoiture.setAnnee("2023");
        testVoiture.setImmatriculation(TEST_IMMATRICULATION);
        testVoiture.setTypeCarburant("Essence");
        testVoiture.setKilometrage("10000");
        testVoiture.setCouleur("Noir");
        testVoiture.setNombrePortes("4");
        testVoiture.setTypeTransmission("Auto");
        testVoiture.setNumeroChâssis("TESTCHASSISCTRL");
        testVoiture.setPrix("25000");
        testVoiture.setEtat("Disponible");
    }

    @Test
    @Order(1)
    void testAjouterVoiture() {
        int id = voitureController.ajouterVoiture(testVoiture);
        assertTrue(id > 0, "L'ajout de la voiture devrait retourner un ID positif");
    }

    @Test
    @Order(2)
    void testRechercherVoiture() {
        Voiture found = voitureController.rechercherVoiture(TEST_IMMATRICULATION);
        assertNotNull(found, "La voiture devrait être trouvée");
        assertEquals("TestController", found.getMarque());
    }

    @Test
    @Order(3)
    void testListerVoitures() {
        List<Voiture> voitures = voitureController.listerVoitures();
        assertNotNull(voitures, "La liste ne devrait pas être null");
        assertFalse(voitures.isEmpty(), "La liste ne devrait pas être vide");
    }

    @Test
    @Order(4)
    void testListerVoituresDisponible() {
        List<Voiture> voitures = voitureController.listerVoituresDisponible();
        assertNotNull(voitures, "La liste ne devrait pas être null");
        assertFalse(voitures.isEmpty(), "La liste ne devrait pas être vide");
    }

    @Test
    @Order(5)
    void testRechercherParMarqueOuModele() {
        List<Voiture> resultats = voitureController.rechercherParMarqueOuModele("TestController");
        assertNotNull(resultats, "La recherche ne devrait pas retourner null");
        assertFalse(resultats.isEmpty(), "La recherche devrait trouver des résultats");
    }

    @Test
    @Order(6)
    void testRechercherParMarqueOuModeleDisponible() {
        List<Voiture> resultats = voitureController.rechercherParMarqueOuModeleDisponible("TestController");
        assertNotNull(resultats, "La recherche ne devrait pas retourner null");
        assertFalse(resultats.isEmpty(), "La recherche devrait trouver des résultats");
    }

    @Test
    @Order(7)
    void testRechercherParImmatriculation() {
        List<Voiture> resultats = voitureController.rechercherParImmatriculation(TEST_IMMATRICULATION);
        assertNotNull(resultats, "La recherche ne devrait pas retourner null");
        assertNotNull(resultats, "La recherche devrait trouver exactement une voiture");
    }

    @Test
    @Order(8)
    void testSetEtatLocation() {
        boolean result = voitureController.setEtatLocation(TEST_IMMATRICULATION, "Indisponible");
        assertTrue(result, "La modification de l'état devrait réussir");
        
        Voiture updated = voitureController.rechercherVoiture(TEST_IMMATRICULATION);
        assertEquals("Indisponible", updated.getEtat(), "L'état devrait être mis à jour");
    }

    @Test
    @Order(9)
    void testModifierVoiture() {
        testVoiture.setPrix("26000");
        String result = voitureController.modifierVoiture(testVoiture);
        assertEquals("success", result, "La modification devrait réussir");
        
        Voiture updated = voitureController.rechercherVoiture(TEST_IMMATRICULATION);
        assertEquals("26000", updated.getPrix(), "Le prix devrait être mis à jour");
    }

    @Test
    @Order(10)
    void testSupprimerVoiture() {
        boolean result = voitureController.supprimerVoiture(TEST_IMMATRICULATION);
        assertTrue(result, "La suppression devrait réussir");
        
        Voiture deleted = voitureController.rechercherVoiture(TEST_IMMATRICULATION);
        assertNull(deleted, "La voiture devrait être supprimée");
    }

   

    @Test
    void testModifierVoitureEchec() {
        Voiture nonExistent = new Voiture();
        nonExistent.setImmatriculation("NONEXISTENT123");
        String result = voitureController.modifierVoiture(nonExistent);
        assertEquals("failed", result, "Devrait échouer pour une voiture inexistante");
    }

  
}