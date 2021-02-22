package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private List<Human> humans = new ArrayList<>();

    public FileManager(Path file) {
        readFromFile(file);
    }

    public void readFromFile(Path file) {
        try {
            List<String> names = Files.readAllLines(file);
            for (String name : names) {
                humans.add(new Human(name.substring(0, name.indexOf(" ")),name.substring(name.indexOf(' ') + 1)));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public List<Human> getHumans() {
        return humans;
    }
}
