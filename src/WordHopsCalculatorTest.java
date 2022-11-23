import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordHopsCalculatorTest {

    @Test
    public void failIfWordsNotSameLength() {
        assertThrows(IllegalArgumentException.class, () -> new WordHopsCalculator("o", "oo"));
    }

    @Test
    public void trueIfDistanceOfWordsIs1() {
        WordHopsCalculator wordHopsCalculator = new WordHopsCalculator("dog", "dag");
        boolean distance = wordHopsCalculator.isDistanceOne();
        assertTrue(distance);
    }

    @Test
    public void falseIfDistanceOfWordsIs2() {
        WordHopsCalculator wordHopsCalculator = new WordHopsCalculator("aaa", "aii");
        boolean distance = wordHopsCalculator.isDistanceOne();
        assertFalse(distance);
    }

}