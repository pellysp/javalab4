import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Task1 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static Plural plural;
    private static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public static void menu() throws IOException {
        System.out.println("Menu:\n1. Add\n2. Remove\n3. View\n4. Reverse sort\n5. Sort");
        System.out.print("Select: ");

        switch (reader.readLine()) {
            case "1" -> {
                System.out.print("Enter value to enter: ");
                try {
                    plural.add(Integer.parseInt(reader.readLine()));
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Invalid type passed, need integer" + ANSI_RESET);
                    menu();
                    return;
                }
                System.out.println("Successfully added");
            }
            case "2" -> {
                System.out.print("Enter value to remove: ");
                try {
                    plural.remove(Integer.parseInt(reader.readLine()));
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Invalid type passed, need integer" + ANSI_RESET);
                    menu();
                    return;
                }
                System.out.println("Successfully removed");
            }
            case "3" -> System.out.println(plural);
            case "4" -> {
                ArrayList<Integer> al = plural.toArrayList();
                al.sort(Comparator.comparingInt(o -> -o));
                System.out.println("Reverse sorted: " + al);
            }
            case "5" -> {
                ArrayList<Integer> al = plural.toArrayList();
                al.sort(Comparator.comparingInt(o -> o));
                System.out.println("Sorted: " + al);
            }
        }
        System.out.println();
        menu();
    }

    public static void main(String[] args)  {
        try {
            plural = new Plural(args);
        } catch (PluralInvalidTypeException e) {
            System.out.println(ANSI_RED + "Invalid arguments passed" + ANSI_RESET);
            return;
        } catch (PluralSizeException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            plural = new Plural();
        }

        System.out.println(plural);

        try {
            menu();
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Input exception" + ANSI_RESET);
        }
    }
}
