package homework16_parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WorkWithFiles {
    public static String readToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            System.err.println("Error reading from file.");
        }
        return contentBuilder.toString();
    }

    public static void writeResults(File oldFilePath, File newFilePath, Boolean state, float conversionTime) {
        File resultsPath = new File("E:\\! Gallery\\Documents\\Hillel IT School\\Java Elementary\\maven\\src\\main\\java\\homework16_parser\\converted\\result.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(resultsPath));
            if (state == null) {
                writer.write("Error. Cannot convert the file.");
            } else {
                writer.write(oldFilePath.getName() + " (" + oldFilePath.length() + " bytes)" +
                        " -> " + newFilePath.getName() + " (" + newFilePath.length() + " bytes)" +
                        "\nConversion duration: " + conversionTime + " seconds");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("File write error.");
        }
    }
}
