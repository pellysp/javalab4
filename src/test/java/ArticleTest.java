import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {
    static Article article;
    @BeforeAll
    static void setUp() {
        article = new Article();
    }

    @Test
    void setPrice() {
        Throwable t = assertThrows(ArticleWrongPriceException.class, () -> article.setPrice(-1), "Expected setPrice() to throw, but it didn't");
        assertTrue(t.getMessage().contains("Price should be higher than or equals 0"));
    }

    @Test
    void setName() {
        article.setName("");
        assertEquals(article.getName(), "Untitled product");
    }
}