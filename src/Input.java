package src;

import java.io.File;
import java.util.Scanner;

public class Input {

    public Input() {
    }


    public void readLines(Lines linesToChange) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese las palabras a buscar: ");
        String line = scanner.nextLine();
        linesToChange.storageLines(line);
        scanner.close();
    }

    public void readDirectory(Lines linesToChange){
        File[] listOfFiles = null;
        listFiles("resources", listOfFiles, linesToChange);
    }

    public void listFiles(String directoryName, File[] files, Lines linesToChange){
        File directory = new File(directoryName);
        files = directory.listFiles();
        for (File file : files){
            if (file.isFile()){
                String fileName = file.getName();
                linesToChange.storageLines(fileName);
            } else if (file.isDirectory()){
                listFiles(file.getAbsolutePath(), files, linesToChange);
            }
        }
    }
}
