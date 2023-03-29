package src;

public class KeywordFinder implements IChangeObserver {
  
    public void notifyListener(Lines changedLine) {
        if(changedLine.name == "inputLines") {
            wordFinder(changedLine);
        }
    }

    public void wordFinder(Lines inputLines) {
        for (String word : MasterControl.keywordLines.lines) {
            for (String page : MasterControl.inputLines.lines) {
                if (inputLines.lines.contains(word)) {
                    int index = MasterControl.keywordLines.lines.indexOf(word);
                    int currentPage = MasterControl.inputLines.lines.indexOf(page);
                    String line = MasterControl.inputLines.lines.get(index);
                    line += ", " + currentPage;
                    MasterControl.outputLines.getLines().set(index, line);
                    System.out.println("La palabra " + word + " se encuentra en la línea " + line + " del archivo de entrada");
                }
            }
        }
    

      /*  for(int i = 0; i < inputLines.getLines().size(); i++) {
            String line = inputLines.getLines().get(i);
            String[] words = line.split(" ");
            String newLine;
            for(int j = 0; j < words.length; j++) {
                newLine = "";
                for(int k = j; k < words.length; k++) {
                    newLine += words[k] + " ";
                }
                for(int k = 0; k < j; k++) {
                    newLine += words[k] + " ";
                }
                MasterControl.shiftedLines.storageLines(newLine);
            }
        }
        MasterControl.inputLines.clearLines();
    }
    */
}
}