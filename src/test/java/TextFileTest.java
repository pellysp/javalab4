import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFileTest {
    static TextFile file;
    @BeforeAll
    static void setUp() {
        file = new TextFile();
    }

    @Test
    void setPath() {
        Throwable t = assertThrows(TextFileWrongPathException.class, () -> file.setPath("not path"), "Expected setPath() to throw, but it didn't");
        assertTrue(t.getMessage().contains("Text Wrong Path Exception: Path should start wit / or ./"));
    }

    @Test
    void setDescription() {
        Throwable t = assertThrows(TextFileWrongDescriptionException.class, () -> file.setDescription("not"), "Expected setDescription() to throw, but it didn't");
        assertTrue(t.getMessage().contains("Text Wrong Path Exception: length of description should be more then 5"));
    }
}