package homework16_parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import homework16_parser.dto.Person;

import java.io.File;
import java.io.IOException;

public class Converter {
    private static String oldFilePath;
    private static File newFilePath;

    public static void convert(String initialDir, String initialExt) {
        Boolean state = checkExtension(initialDir, initialExt);
        long conversionStart = System.currentTimeMillis();
        long conversionStop;
        if (state == null) System.err.println("\nWrong format of the file.");
        else if (state) convertToJson(oldFilePath);
        else convertToYaml(oldFilePath);
        conversionStop = System.currentTimeMillis();
        WorkWithFiles.writeResults(new File(oldFilePath), newFilePath, state, (conversionStop - conversionStart) / 1000f);
    }

    private static void convertToJson(String oldFilePath) {
        String yamlString = WorkWithFiles.readToString(oldFilePath);
        ObjectMapper jsonWriter = new ObjectMapper();
        Person person;
        try {
            person = new ObjectMapper(new YAMLFactory()).readValue(yamlString, Person.class);
            jsonWriter.writeValue(newFilePath, person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertToYaml(String oldFilePath) {
        String jsonString = WorkWithFiles.readToString(oldFilePath);
        ObjectMapper yamlWriter = new ObjectMapper(new YAMLFactory());
        Person person;
        try {
            person = new Gson().fromJson(jsonString, Person.class);
            yamlWriter.writeValue(newFilePath, person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Boolean checkExtension(String initialDir, String initialExt) {
        File[] listFiles = new File(initialDir).listFiles();
        String filename;
        for (File listFile : listFiles) {
            filename = listFile.getName();
            if (filename.substring(filename.lastIndexOf(".") + 1).equals(initialExt)) {
                oldFilePath = listFile.getPath();
                filename = listFile.getName().replace(initialExt, "");
                if (initialExt.equals("yaml")) {
                    newFilePath = new File("E:\\! Gallery\\Documents\\Hillel IT School\\Java Elementary\\maven\\src\\main\\java\\homework16_parser\\converted\\" + filename + "json");
                    return true;
                }
                if (initialExt.equals("json")) {
                    newFilePath = new File("E:\\! Gallery\\Documents\\Hillel IT School\\Java Elementary\\maven\\src\\main\\java\\homework16_parser\\converted\\" + filename + "yaml");
                    return false;
                }
            }
        }
        return null;
    }
}
