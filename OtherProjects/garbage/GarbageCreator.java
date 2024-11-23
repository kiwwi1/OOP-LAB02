package lab002.OtherProjects.garbage;

import java.io.FileReader;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        String filePath = "path_to_your_large_file.txt"; // Replace with your file path
        try {
            FileReader reader = new FileReader(filePath);
            int c;
            String content = "";
            while ((c = reader.read()) != -1) {
                content += (char) c; // Inefficient concatenation
            }
            reader.close();
            System.out.println("File content loaded successfully (GarbageCreator).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
