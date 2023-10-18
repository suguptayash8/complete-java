package interview.coding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayToScreen {
    public static void main(String[] args) {
        try {
            // Replace with the path to your file
            String filePath = "path/to/your/file.txt";

            // Open and read the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                // Replace vowels with 'X'
                String replacedLine = replaceVowelsWithX(line);
                System.out.println(replacedLine);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String replaceVowelsWithX(String input) {
        return input.replaceAll("[aeiouAEIOU]", "X");
    }
}
