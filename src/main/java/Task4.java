import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Task4 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static final HashMap<String, TextFile> files = new HashMap<>();
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public static void addFile(String name, TextFile file) throws Exception {
        if (files.containsKey(name)) {
            throw new Exception("File with this name already exists");
        }
        files.put(name, file);
    }

    public static void removeFile(String name) throws Exception {
        if (!files.containsKey(name)) {
            throw new Exception("File with this name didn't exists");
        }
        files.remove(name);
    }

    public static void menu() throws IOException {
        System.out.println("Menu:\n1. Add\n2. Remove\n3. View");
        System.out.print("Select what to do: ");

        switch (reader.readLine()) {
            case "1" -> {
                System.out.print("Enter name for file: ");
                String fileName = "";
                try {
                    fileName = reader.readLine();
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Invalid type passed, need integer" + ANSI_RESET);
                    menu();
                    return;
                }
                TextFile tmpTextFile = new TextFile();
                System.out.print("Enter path of file: ");
                try {
                    tmpTextFile.setPath(reader.readLine());
                } catch (TextFileWrongPathException e) {
                    System.out.println(ANSI_RED + "Invalid path passed: " + e.getMessage() + ANSI_RESET);
                    menu();
                    return;
                }
                System.out.print("Enter price of product: ");
                String description = "";
                try {
                    description = reader.readLine();
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Invalid type passed, need float" + ANSI_RESET);
                    menu();
                    return;
                }
                try {
                    tmpTextFile.setDescription(description);
                } catch (TextFileWrongDescriptionException e) {
                    System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                    menu();
                    return;
                }
                try {
                    addFile(fileName, tmpTextFile);
                } catch (Exception e) {
                    System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                }
                System.out.println("Successfully added");
            }
            case "2" -> {
                System.out.print("Enter value to remove: ");
                try {
                    removeFile(reader.readLine());
                } catch (Exception e) {
                    System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                    menu();
                    return;
                }
                System.out.println("Successfully removed");
            }
            case "3" -> System.out.println(files);
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
