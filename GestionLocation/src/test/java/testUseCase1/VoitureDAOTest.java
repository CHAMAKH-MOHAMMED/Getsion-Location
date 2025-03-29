package testUseCase1;

import dao.VoitureDAO;
import entity.Voiture;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Permet d'exécuter les tests dans un ordre précis
public class VoitureDAOTest {

    private static VoitureDAO voitureDAO;
    private static Voiture voitureTest;

    @BeforeAll
    static void setUp() {
        voitureDAO = new VoitureDAO();

        // Création d'une voiture test
        voitureTest = new Voiture();
        voitureTest.setMarque("Toyota");
        voitureTest.setModele("Corolla");
        voitureTest.setAnnee("2020");
        voitureTest.setImmatriculation("ABC123");
        voitureTest.setTypeCarburant("Essence");
        voitureTest.setKilometrage("25000");
        voitureTest.setCouleur("Rouge");
        voitureTest.setNombrePortes("4");
        voitureTest.setTypeTransmission("Auto");
        voitureTest.setNumeroChâssis("XYZ987654321");
        voitureTest.setPrix("20000");
        voitureTest.setEtat("Disponible");
    }

    @Test
    @Order(1)
    void testCreate() throws SQLException {
        int id = voitureDAO.create(voitureTest);
        assertTrue(id > 0, "L'insertion de la voiture a échoué");
    }

    @Test
    @Order(2)
    void testGetOne() throws SQLException {
        Voiture voiture = voitureDAO.getOne("ABC123");
        assertNotNull(voiture, "La voiture avec l'immatriculation 'ABC123' devrait exister");
        assertEquals("Toyota", voiture.getMarque());
    }

    @Test
    @Order(3)
    void testUpdate() throws SQLException {
        voitureTest.setPrix("18000"); // Mise à jour du prix
        int rowsUpdated = voitureDAO.update(voitureTest);
        assertTrue(rowsUpdated > 0, "La mise à jour de la voiture a échoué");

        Voiture updatedCar = voitureDAO.getOne("ABC123");
        assertEquals("18000", updatedCar.getPrix(), "Le prix n'a pas été mis à jour correctement");
    }

    @Test
    @Order(4)
    void testGetAll() throws SQLException {
        List<Voiture> voitures = voitureDAO.getAll();
        assertFalse(voitures.isEmpty(), "La liste des voitures ne devrait pas être vide");
    }

    @Test
    @Order(5)
    void testDelete() throws SQLException {
        boolean deleted = voitureDAO.delete("ABC123");
        assertTrue(deleted, "La suppression de la voiture a échoué");

        Voiture voiture = voitureDAO.getOne("ABC123");
        assertNull(voiture, "La voiture ne devrait plus exister après la suppression");
    }
}
