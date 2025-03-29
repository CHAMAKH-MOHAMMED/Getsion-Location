/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testUseCase1;


import entity.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoitureTest {
    
    private Voiture voiture;
    
    @BeforeEach
    public void setUp() {
        // Initialize a Voiture object before each test
        voiture = new Voiture(
            "Toyota",
            "Corolla",
            "2020",
            "ABC-123-XY",
            "Essence",
            "50000",
            "Bleu",
            "4",
            "Automatique",
            "JTDBF123456789012",
            "20000",
            "Bon"
        );
    }
    
    @Test
    public void testDefaultConstructor() {
        Voiture voitureDefault = new Voiture();
        assertEquals(0, voitureDefault.getId());
        assertNull(voitureDefault.getMarque());
        assertNull(voitureDefault.getModele());
        assertNull(voitureDefault.getAnnee());
    }
    
    @Test
    public void testConstructorWithoutId() {
        assertEquals("Toyota", voiture.getMarque());
        assertEquals("Corolla", voiture.getModele());
        assertEquals("2020", voiture.getAnnee());
        assertEquals("ABC-123-XY", voiture.getImmatriculation());
        assertEquals("Essence", voiture.getTypeCarburant());
        assertEquals("50000", voiture.getKilometrage());
        assertEquals("Bleu", voiture.getCouleur());
        assertEquals("4", voiture.getNombrePortes());
        assertEquals("Automatique", voiture.getTypeTransmission());
        assertEquals("JTDBF123456789012", voiture.getNumeroChâssis());
        assertEquals("20000", voiture.getPrix());
        assertEquals("Bon", voiture.getEtat());
        assertEquals(0, voiture.getId()); // Default ID should be 0
    }
    
    @Test
    public void testConstructorWithId() {
        Voiture voitureWithId = new Voiture(
            1,
            "Honda",
            "Civic",
            "2019",
            "XYZ-789-AB",
            "Diesel",
            "75000",
            "Rouge",
            "2",
            "Manuelle",
            "JH4DB123456789012",
            "18000",
            "Excellent"
        );
        
        assertEquals(1, voitureWithId.getId());
        assertEquals("Honda", voitureWithId.getMarque());
        assertEquals("Civic", voitureWithId.getModele());
    }
    
    @Test
    public void testSettersAndGetters() {
        voiture.setId(2);
        voiture.setMarque("Renault");
        voiture.setModele("Clio");
        voiture.setAnnee("2021");
        
        assertEquals(2, voiture.getId());
        assertEquals("Renault", voiture.getMarque());
        assertEquals("Clio", voiture.getModele());
        assertEquals("2021", voiture.getAnnee());
    }
    
    @Test
    public void testToArray() {
        Object[] expectedArray = {
            "Toyota",
            "Corolla",
            "ABC-123-XY",
            "2020"
        };
        
        Object[] resultArray = voiture.toArray();
        
        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Test
    public void testToString() {
        String expectedString = "Voiture{id=0, marque='Toyota', modele='Corolla', annee='2020', " +
                "immatriculation='ABC-123-XY', typeCarburant='Essence', kilometrage='50000', " +
                "couleur='Bleu', nombrePortes='4', typeTransmission='Automatique', " +
                "numeroChâssis='JTDBF123456789012', prix='20000', etat='Bon'}";
                
        assertEquals(expectedString, voiture.toString());
    }
}