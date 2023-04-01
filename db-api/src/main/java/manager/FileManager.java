package manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    private static final String resultPath = "result.txt";

    public static void writeResult(String data) {
        try {
            Files.writeString(Path.of(resultPath), data);
        } catch (IOException e) {
            System.out.println("Unable to write to file" + resultPath);
        }
    }

}
