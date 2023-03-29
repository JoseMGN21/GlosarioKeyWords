package src;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

public class Input {

    public Input() {
    }

    public void readPDF (Lines inputLines, String rutaArchivo){
        File file = new File(rutaArchivo);
        try {
        PDDocument doc1 = Loader.loadPDF(file);
        inputLines.storageLines(textStripper(doc1));
        //String texto = textStripper(doc1);
        //System.out.println(texto);
        }
        catch (IOException e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
   }

    public void readText(Lines inputLines, String rutaArchivo) {
        try{
        Scanner scanner = new Scanner(new File(rutaArchivo));
        
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            inputLines.storageLines(line);
        }
        scanner.close();
    }
    catch (IOException e) {
        System.out.println("Archivo no encontrado");
        e.printStackTrace();
    }
    }

    public void readLines(Lines inputLines) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            inputLines.storageLines(line);
        }
        scanner.close();
    }

    public String textStripper(PDDocument doc) throws IOException {
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(true);
        stripper.setStartPage(1);
        stripper.setEndPage(1);
        return stripper.getText(doc);
    }
}
