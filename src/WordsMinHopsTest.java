import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsMinHopsTest {

    @Test
    public void oneHop() {
        Set<String> words = Set.of("bat", "cat");
        WordsMinHops wordsMinHops = new WordsMinHops(words);

        int hops = wordsMinHops.minNumberOfHops("bat", "cat");

        assertEquals(1, hops);
    }

    @Test
    public void twoHops() {
        Set<String> words = Set.of("dog", "bat", "cat", "rag", "mat", "cag", "dat", "dag");
        WordsMinHops wordsMinHops = new WordsMinHops(words);

        int hops = wordsMinHops.minNumberOfHops("cat", "dog");

        assertEquals(2, hops); // cat -> dat -> dog
    }

    @Test
    public void threeHops() {
        Set<String> words = Set.of("aaa", "aae", "aai", "aei", "aii", "eii", "iii", "uuu");
        WordsMinHops wordsMinHops = new WordsMinHops(words);

        int hops = wordsMinHops.minNumberOfHops("aaa", "iii");

        assertEquals(3, hops); // aaa -> aai -> aii -> iii
    }

    @Test
    public void noHops() {
        Set<String> words = Set.of("aaa", "eee", "iii", "ooo", "uuu");
        WordsMinHops wordsMinHops = new WordsMinHops(words);

        int hops = wordsMinHops.minNumberOfHops("aaa", "uuu");

        assertEquals(0, hops);
    }
}