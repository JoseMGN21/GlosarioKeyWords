package src;

import java.util.ArrayList;

public class Lines extends TElement {

    String name;
    ArrayList<String> lines = new ArrayList<String>();
    int page = 0;

    public Lines(String name) {
        this.name = name;
    }

    public void storageLines(String line) {
        lines.add(line);
        announceChangeEvent(this);
    }

    public void clearLines(){
        lines.clear();
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }
    
}