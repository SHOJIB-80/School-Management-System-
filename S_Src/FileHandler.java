import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Write list of objects to a file
    public static <T> void writeToFile(String fileName, List<T> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T item : list) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read list of objects from a file
    public static List<String> readFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return list;
    }
}
