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
                if(page.toLowerCase().contains(word.toLowerCase())) {
                    int indexOutput = getIndex(word);
                    String line = MasterControl.outputLines.lines.get(indexOutput);
                    line += ", " + inputLines.page;
                    MasterControl.outputLines.getLines().set(indexOutput, line);
                    //System.out.println("La palabra " + word + " se encuentra en la línea " + line + " del archivo de entrada");
                }
            }
        }
    
}

    public int getIndex(String word) {
        for (int i = 0; i < MasterControl.outputLines.lines.size(); i++) {
            if(MasterControl.outputLines.lines.get(i).contains(word))
                return i;
        }
        return -1;
    }
}