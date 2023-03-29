package src;

public class MasterControl{
    public static Lines outputLines;
    public static Lines inputLines;
    public static Lines organizedLines;
    public static Lines keywordLines;

    public static void main(String[] args) {
        inputLines = new Lines("inputLines");
        outputLines = new Lines("outputLines");
        keywordLines = new Lines("keywordLines");
        organizedLines = new Lines("organizedLines");

        IChangeObserver finder = new KeywordFinder();
        IChangeObserver order = new Aphabetizer();

        inputLines.addChangeObservers(order);
        keywordLines.addChangeObservers(finder);
        
        Input input = new Input();
        
        input.readDirectory(inputLines);
        input.readLines(keywordLines);
        
        Output output = new Output();
        output.printLines(outputLines);
    }
}
