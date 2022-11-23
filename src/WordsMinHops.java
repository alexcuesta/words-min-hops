import java.util.Set;

public class WordsMinHops {

    private final WordsGraph wordsGraph ;

    public WordsMinHops(Set<String> words) {
        this.wordsGraph = new WordsGraph(words);
    }

    public int minNumberOfHops(String bat, String cat) {
        return wordsGraph.minNumberOfHops(bat, cat);
    }
}
