package homework15_game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

public class DataWriting {

    public void writeToFile(String log) throws IOException {
        String appDirectory = FileSystems.getDefault()
                .getPath("D:\\! Gallery\\Documents\\Hillel IT School\\Java Elementary\\hillel\\src\\main\\java\\homework15_game\\game_log.txt")
                .toAbsolutePath()
                .toString();
        File file = new File(appDirectory);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(log);
        writer.close();
    }
}
