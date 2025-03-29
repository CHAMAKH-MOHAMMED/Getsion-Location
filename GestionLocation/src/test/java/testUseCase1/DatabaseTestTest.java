package testUseCase1;

import dao.DatabaseTest;
import org.junit.jupiter.api.*;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTestTest {

    private static DatabaseTest database;

    @BeforeAll
    static void setUp() {
        database = DatabaseTest.getInstance();
    }

    @Test
    @DisplayName("Test de connexion à la base de données")
    void testGetConnection() {
        assertDoesNotThrow(() -> {
            Connection connection = database.getConnection();
            assertNotNull(connection, "La connexion ne doit pas être null");
            assertFalse(connection.isClosed(), "La connexion ne doit pas être fermée");
        });
    }

    @Test
    @DisplayName("Test de fermeture de la connexion")
    void testCloseConnection() {
        assertDoesNotThrow(() -> {
            database.closeConnection();
            Connection connection = database.getConnection();
            assertFalse(connection.isClosed(), "La connexion ne doit pas être fermée après réouverture");
        });
    }
}
