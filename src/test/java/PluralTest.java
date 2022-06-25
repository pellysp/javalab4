import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PluralTest {
    static Plural plural;

    @org.junit.jupiter.api.Test
    @Order(4)
    void testToString() {
        assertTrue(plural.toString().startsWith("Plural"));
    }


    @org.junit.jupiter.api.Test
    @Order(1)
    void add() {
        plural.add(2);
        assertTrue(plural.remove(2));
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void remove() {
        plural.add(3);
        assertTrue(plural.remove(3));
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    void toArrayList() {
        assertNotNull(plural.toArrayList());
    }

    @BeforeAll
    static void setUp() {
        plural = new Plural();
        plural.add(5);
        plural.add(6);
        plural.add(7);
        plural.add(21);
        plural.add(13);
        plural.add(1);
    }
}