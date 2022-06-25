import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    private static final HashMap<Integer, Article> files = new HashMap<>();

    @Test
    void addFile() {
        assertDoesNotThrow(() -> Task4.addFile("text.txt", new TextFile()));
        assertThrows(Exception.class, () -> Task4.addFile("text.txt", new TextFile()));
    }

    @Test
    void removeFile() {
        assertThrows(Exception.class, () -> Task4.removeFile("test.txt"));
        assertDoesNotThrow(() -> Task4.addFile("test.txt", new TextFile()));
        assertDoesNotThrow(() -> Task4.removeFile("test.txt"));
    }
}