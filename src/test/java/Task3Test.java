import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    private static final HashMap<Integer, Article> products = new HashMap<>();

    @Test
    void addProduct() {
        assertDoesNotThrow(() -> Task3.addProduct(1, new Article()));
        assertThrows(Exception.class, () -> Task3.addProduct(1, new Article()));
    }

    @Test
    void removeProduct() {
        assertThrows(Exception.class, () -> Task3.removeProduct(1));
        assertDoesNotThrow(() -> Task3.addProduct(1, new Article()));
        assertDoesNotThrow(() -> Task3.removeProduct(1));
    }
}