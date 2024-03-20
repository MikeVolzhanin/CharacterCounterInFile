import java.io.*;
import java.util.HashMap;

public class CharacterFileCounter {
    public void count(String inputFile, String outputFile){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            HashMap<Character, Integer> upperCaseCh = new HashMap<>();
            HashMap<Character, Integer> lowerCaseCh = new HashMap<>();

            int ch;
            while ((ch = reader.read()) != -1) {
                if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                    char charKey = (char) ch;
                    if (Character.isUpperCase(charKey)) {
                        upperCaseCh.put(charKey, upperCaseCh.getOrDefault(charKey, 0) + 1);
                    } else {
                        lowerCaseCh.put(charKey, lowerCaseCh.getOrDefault(charKey, 0) + 1);
                    }
                }
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            for (char c = 'A'; c <= 'Z'; c++) {
                if (upperCaseCh.containsKey(c)) {
                    writer.write(c + ": " + upperCaseCh.get(c) + "\n");
                }
            }

            for (char c = 'a'; c <= 'z'; c++) {
                if (lowerCaseCh.containsKey(c)) {
                    writer.write(c + ": " + lowerCaseCh.get(c) + "\n");
                }
            }

            writer.close();

            System.out.println("The results of the character count are recorded in a file" + outputFile);
        } catch (IOException e) {
            System.out.println("Error reading/writing the file: " + e.getMessage());
        }
    }
}
