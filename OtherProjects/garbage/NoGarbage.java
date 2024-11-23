package lab002.OtherProjects.garbage;

import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filePath = "path_to_your_large_file.txt"; // Replace with your file path
        try {
            FileReader reader = new FileReader(filePath);
            int c;
            StringBuilder content = new StringBuilder(); // Using StringBuilder
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            reader.close();
            System.out.println("File content loaded successfully (NoGarbage).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
