package testUseCase1;

import controler.VoitureController;
import entity.Voiture;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Exécute les tests dans l'ordre défini
class VoitureControllerTest {
    private static VoitureController controller;
    private static Voiture voitureTest;

    @BeforeAll
    static void setUp() {
        controller = new VoitureController();
        voitureTest = new Voiture(); 

        voitureTest.setImmatriculation("123ABC"); // Ajout les champs
        voitureTest.setAnnee("2020");
        voitureTest.setMarque("Toyota");
        voitureTest.setModele("Corolla");
        voitureTest.setKilometrage("25000"); 
        voitureTest.setPrix("23000"); 
        voitureTest.setCouleur("Rouge");
        voitureTest.setTypeCarburant("Essence");
        voitureTest.setNombrePortes("4");
        voitureTest.setTypeTransmission("Automatique");
        voitureTest.setNumeroChâssis("CH123456");
        voitureTest.setEtat("Neuf");
    }

    @Test
    @Order(1)
    void testAjouterVoiture() {
        int id = controller.ajouterVoiture(voitureTest);
        assertNotEquals(-1, id, "L'ajout de la voiture a échoué");
    }

    @Test
    @Order(2)
    void testModifierVoiture() {
        voitureTest.setPrix("23000"); // Modification du prix
        String result = controller.modifierVoiture(voitureTest);
        assertEquals("success", result, "La modification a échoué");
    }

    @Test
    @Order(3)
    void testRechercherVoiture() {
        Voiture voitureTrouvee = controller.rechercherVoiture("123ABC");
        assertNotNull(voitureTrouvee, "Voiture non trouvée");
        assertEquals("Toyota", voitureTrouvee.getMarque(), "Marque incorrecte");
        assertEquals("Corolla", voitureTrouvee.getModele(), "Modèle incorrect");
    }

    @Test
    @Order(4)
    void testListerVoitures() {
        List<Voiture> voitures = controller.listerVoitures();
        assertNotNull(voitures, "La liste de voitures est null");
        assertFalse(voitures.isEmpty(), "Aucune voiture trouvée dans la base");
    }

    @Test
    @Order(5)
    void testSupprimerVoiture() {
        boolean deleted = controller.supprimerVoiture("123ABC");
        assertTrue(deleted, "Suppression de la voiture échouée");

        Voiture voitureSupprimee = controller.rechercherVoiture("123ABC");
        assertNull(voitureSupprimee, "La voiture devrait être supprimée");
    }
     @Test
    @Order(6)
    void rechercherParMarqueOuModeleTest() {
          List<Voiture> voitures =controller.rechercherParMarqueOuModele("Renault");
         assertNotNull(voitures);

    }
    
     @Test
    @Order(7)
    void rechercherParImmatriculationTest() {
          List<Voiture> voitures =controller.rechercherParImmatriculation("VWX012");
         assertNotNull(voitures);

    }
}
