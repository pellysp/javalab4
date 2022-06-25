import java.util.Objects;

class ArticleWrongPriceException extends Exception {
    ArticleWrongPriceException() {
        super("Article Wrong Price Exception: Price should be higher than or equals 0");
    }
}

public class Article implements Comparable<Article> {
    private float price = 0;

    public void setPrice(float price) throws ArticleWrongPriceException {
        if (price < 0) {
            throw new ArticleWrongPriceException();
        }
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    private String name;

    public void setName(String name) {
        if (name.length() == 0) {
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Article() {
        this.price = 0;
        this.name = "Untitled product";
    }

    public Article(float price, String name) throws ArticleWrongPriceException {
        this.setPrice(price);
        this.setName(name);
    }

    @Override
    public int compareTo(Article o) {
        if (Objects.equals(this.name, o.name)) {
            return 0;
        }
        return (int)(this.price - o.price);
    }

    @Override
    public String toString() {
        return "{name: " + name + ", price: " + price + "}";
    }
}
