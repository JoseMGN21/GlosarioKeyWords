package src;

public class KeywordFinder implements IChangeObserver {
  
    public void notifyListener(Lines changedLine) {
        if(changedLine.name == "keywordLines") {
            wordFinder(changedLine);
        }
    }

    public void wordFinder(Lines inputLines) {
        for (String word : MasterControl.keywordLines.lines) {
            for (String directory : MasterControl.inputLines.lines) {
                if(directory.toLowerCase().contains(word.toLowerCase())) {
                    MasterControl.outputLines.storageLines(directory);
                    //System.out.println("La palabra " + word + " se encuentra en la línea " + line + " del archivo de entrada");
                }
            }
        }
    
}

}