import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharacterFileCounter characterFileCounter = new CharacterFileCounter();

        System.out.println("Enter the name of the input file: ");
        String inputFile = scanner.next();

        System.out.println("Enter the name of the output file ");
        String outputFile = scanner.next();

        if(inputFile == null || outputFile == null){
            System.out.println("There is no name for the input/output file");
            return;
        }

        characterFileCounter.count(inputFile, outputFile);
    }
}