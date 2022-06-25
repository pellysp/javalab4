class TextFileWrongPathException extends Exception {
    TextFileWrongPathException() {
        super("Text Wrong Path Exception: Path should start wit / or ./");
    }
}

class TextFileWrongDescriptionException extends Exception {
    TextFileWrongDescriptionException() {
        super("Text Wrong Path Exception: length of description should be more then 5");
    }
}

public class TextFile {
    public void setPath(String path) throws TextFileWrongPathException {
        if (path.startsWith("/") || path.startsWith(".")) {
            this.path = path;
        } else {
            throw new TextFileWrongPathException();
        }
    }

    public void setDescription(String description) throws TextFileWrongDescriptionException {
        if (description.length() > 5) {
            this.description = description;
        } else {
            throw new TextFileWrongDescriptionException();
        }
    }

    private String path = "";
    private String description = "";

    public TextFile() {
        this.path = "./test.txt";
        this.description = "Some text file";
    }

    public TextFile(String path, String description) throws TextFileWrongPathException, TextFileWrongDescriptionException {
        setPath(path);
        setDescription(description);
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "{path: " + path + ",\ndescription: " + description + "}\n";
    }
}

//    Select what to do: 1
//        Enter name for file: test.txt
//        Enter path of file: ./file/test.txt
//        Enter price of product: Opa, opa new file!
//        Successfully added

//    Select what to do: 1
//        Enter name for file: data.txt
//        Enter path of file: ./file/data.txt
//        Enter price of product: Pop up! Pop up!