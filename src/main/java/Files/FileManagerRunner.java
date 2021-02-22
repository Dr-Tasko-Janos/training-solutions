package Files;

import java.nio.file.Path;

public class FileManagerRunner {

    public static void main(String[] args) {

        Path file = Path.of("FileManagerNames.txt");

        FileManager manager = new FileManager(file);
        System.out.println(manager.getHumans());
    }
}
