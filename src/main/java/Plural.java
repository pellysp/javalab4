import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class PluralSizeException extends Exception {
    PluralSizeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Plural Exception: " + super.getMessage();
    }
}

class PluralInvalidTypeException extends Exception {
    PluralInvalidTypeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Plural Exception: " + super.getMessage();
    }
}

public class Plural {
    HashSet<Integer> hash;

    Plural(String[] args) throws PluralInvalidTypeException, PluralSizeException {
        try {
            hash = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));
        } catch (NumberFormatException e) {
            throw new PluralInvalidTypeException("Invalid type of data passed");
        }

        if (hash.size() > 10) {
            throw new PluralSizeException("Too big, Limit: 10 unique elements");
        }
    }

    Plural() {
        hash = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Plural: " + hash.toString() + ";";
    }

    public void add(Integer e) {
        hash.add(e);
    }

    public boolean remove(Integer e) {
        return hash.remove(e);
    }

    public ArrayList<Integer> toArrayList() {
        return new ArrayList<>(hash);
    }
}
