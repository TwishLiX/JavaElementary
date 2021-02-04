package homework19_logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

public class DataWriting {

    public void writeToFile(String log) throws IOException {
        String appDirectory = FileSystems.getDefault()
                .getPath("D:\\! Gallery\\Documents\\Hillel IT School\\Java Elementary\\maven\\src\\main\\java\\homework19_logger\\game_log.txt")
                .toAbsolutePath()
                .toString();
        File file = new File(appDirectory);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(log);
        writer.close();
    }
}
