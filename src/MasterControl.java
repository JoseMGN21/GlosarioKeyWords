package src;

import java.util.Scanner;

public class MasterControl{
    public static Lines shiftedLines;
    public static Lines inputLines;
    public static Lines keywordLines;

    public static void main(String[] args) {
        inputLines = new Lines("inputLines");
        shiftedLines = new Lines("shiftedLines");
        keywordLines = new Lines("keywordLines");

        IChangeObserver shift = new KeywordFinder();
        IChangeObserver order = new Aphabetizer();

        inputLines.addChangeObservers(shift);
        shiftedLines.addChangeObservers(order);
        

        Input input = new Input();
        input.readText(keywordLines, "src/keywords.txt");
        chooseInputType(input);

        

        Output output = new Output();
        output.printLines(shiftedLines);
    }

    public static void chooseInputType(Input input) {
        System.out.println("¿Qué tipo de entrada desea utilizar?");
        System.out.println("1. Consola");
        System.out.println("2. Archivo de texto");
        System.out.println("3. Archivo PDF");
        Scanner scanner = new Scanner(System.in);
        int inputType = scanner.nextInt();
        switch(inputType) {
            case 1:
                input.readLines(inputLines);
                break;
            case 2:
                System.out.println("Ingrese el nombre del archivo de texto");
                String nombreTXT = scanner.next();
                input.readText(inputLines, "resources/" + nombreTXT + ".txt");
                break;
            case 3:
                System.out.println("Ingrese el nombre del archivo PDF");
                String nombrePDF = scanner.next();
                input.readPDF(inputLines, "resources/" + nombrePDF + ".pdf");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        scanner.close();
    }
}
