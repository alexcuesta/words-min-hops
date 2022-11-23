import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordsGraphTest {

    @Test
    public void nonOneHopWordsShouldNotBeLinked() {
        Set<String> words = Set.of("bat", "dog");
        WordsGraph wordsGraph = new WordsGraph(words);

        Node bat = wordsGraph.get("bat");
        Node dog = wordsGraph.get("dog");

        assertEquals(Collections.emptySet(), bat.getOneHopWords());
        assertEquals(Collections.emptySet(), dog.getOneHopWords());
    }

    @Test
    public void oneHopWordsShouldNotBeLinked() {
        Set<String> words = Set.of("bat", "cat");
        WordsGraph wordsGraph = new WordsGraph(words);

        Node bat = wordsGraph.get("bat");
        Node cat = wordsGraph.get("cat");

        assertEquals(Set.of("cat"), bat.getOneHopWords());
        assertEquals(Set.of("bat"), cat.getOneHopWords());
    }

    @Test
    public void multipleOneHopWordsShouldBeLinked() {
        Set<String> words = Set.of("bat", "cat", "dat");
        WordsGraph wordsGraph = new WordsGraph(words);

        Node bat = wordsGraph.get("bat");
        Node cat = wordsGraph.get("cat");
        Node dat = wordsGraph.get("dat");

        assertEquals(Set.of("cat", "dat"), bat.getOneHopWords());
        assertEquals(Set.of("bat", "dat"), cat.getOneHopWords());
        assertEquals(Set.of("bat", "cat"), dat.getOneHopWords());
    }

}