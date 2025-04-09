package testuseCase2;

import entity.Contrat;
import entity.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ContratTest {

    private Contrat contrat;
    private Voiture voiture;
    private Date dateDebut;
    private Date dateFin;

    @BeforeEach
    void setUp() {
        voiture = new Voiture(); // Assuming default constructor
        dateDebut = new Date(2024, 4, 1);
        dateFin = new Date(2024, 4, 10);

        contrat = new Contrat(1, "John", "Doe", "CIN123", "NC123",
                "En cours", "LC456", dateDebut, dateFin, "1000", voiture);
    }

    @Test
    void testGetters() {
        assertEquals(1, contrat.getID());
        assertEquals("John", contrat.getNomC());
        assertEquals("Doe", contrat.getPrenomC());
        assertEquals("CIN123", contrat.getCin());
        assertEquals("NC123", contrat.getnContrat());
        assertEquals("En cours", contrat.getEtatOcation());
        assertEquals("LC456", contrat.getLicenceConduit());
        assertEquals(dateDebut, contrat.getDateDebut());
        assertEquals(dateFin, contrat.getDateFin());
        assertEquals("1000", contrat.getPrix());
        assertEquals(voiture, contrat.getVoiture());
    }

    @Test
    void testSetters() {
        contrat.setID(2);
        contrat.setNomC("Jane");
        contrat.setPrenomC("Smith");
        contrat.setCin("CIN456");
        contrat.setnContrat("NC789");
        contrat.setEtatOcation("Terminé");
        contrat.setLicenceConduit("LC789");
        contrat.setDateDebut(new Date(2024, 5, 1));
        contrat.setDateFin(new Date(2024, 5, 10));
        contrat.setPrix("1500");
        Voiture newVoiture = new Voiture();
        contrat.setVoiture(newVoiture);

        assertEquals(2, contrat.getID());
        assertEquals("Jane", contrat.getNomC());
        assertEquals("Smith", contrat.getPrenomC());
        assertEquals("CIN456", contrat.getCin());
        assertEquals("NC789", contrat.getnContrat());
        assertEquals("Terminé", contrat.getEtatOcation());
        assertEquals("LC789", contrat.getLicenceConduit());
        assertEquals(new Date(2024, 5, 1), contrat.getDateDebut());
        assertEquals(new Date(2024, 5, 10), contrat.getDateFin());
        assertEquals("1500", contrat.getPrix());
        assertEquals(newVoiture, contrat.getVoiture());
    }

    @Test
    void testToArray() {
        Object[] array = contrat.toArray();
        assertEquals("John Doe", array[0]);
        assertEquals("En cours", array[1]);
        assertEquals("1000", array[2]);
        assertEquals("NC123", array[3]);
    }
}
