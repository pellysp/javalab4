import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Task3 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static final HashMap<Integer, Article> products = new HashMap<>();
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public static void addProduct(int code, Article article) throws Exception {
        if (products.containsKey(code)) {
            throw new Exception("Product with this code already exists");
        }
        products.put(code, article);
    }

    public static void removeProduct(int code) throws Exception {
        if (!products.containsKey(code)) {
            throw new Exception("Product with this code didn't exists");
        }
        products.remove(code);
    }

    public static void menu() throws IOException {
        System.out.println("Menu:\n1. Add\n2. Remove\n3. View\n4. Check unique");
        System.out.print("Select: ");

        switch (reader.readLine()) {
            case "1" -> {
                System.out.print("Enter code for product: ");
                int code;
                try {
                    code = (Integer.parseInt(reader.readLine()));
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Invalid type passed, need integer" + ANSI_RESET);
                    menu();
                    return;
                }
                Article tmpArticle = new Article();
                System.out.print("Enter name of product: ");
                tmpArticle.setName(reader.readLine());
                System.out.print("Enter price of product: ");
                float price = 0;
                try {
                    price = (Float.parseFloat(reader.readLine()));
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Invalid type passed, need float" + ANSI_RESET);
                    menu();
                    return;
                }
                try {
                    tmpArticle.setPrice(price);
                } catch (ArticleWrongPriceException e) {
                    System.out.println(ANSI_RED + "Price shoud be higher or equals 0" + ANSI_RESET);
                    menu();
                    return;
                }
                try {
                    addProduct(code, tmpArticle);
                } catch (Exception e) {
                    System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                }
                System.out.println("Successfully added");
            }
            case "2" -> {
                System.out.print("Enter value to remove: ");
                try {
                    removeProduct(Integer.parseInt(reader.readLine()));
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Invalid type passed, need integer" + ANSI_RESET);
                    menu();
                    return;
                } catch (Exception e) {
                    System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                    menu();
                    return;
                }
                System.out.println("Successfully removed");
            }
            case "3" -> System.out.println(products);
        }
        System.out.println();
        menu();
    }

    public static void main(String[] args) {
        try {
            menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
