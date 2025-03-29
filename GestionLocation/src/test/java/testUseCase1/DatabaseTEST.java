package testUseCase1;

import dao.Database;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTEST {

    private static Database database;

    @BeforeAll
    static void setUp() {
        database = Database.getInstance();
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
