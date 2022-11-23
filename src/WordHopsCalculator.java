import java.nio.charset.StandardCharsets;

public class WordHopsCalculator {

    private final byte[] w1 ;
    private final byte[] w2 ;

    public WordHopsCalculator(String word1, String word2) {
        if (word1.length() != word2.length()) throw new IllegalArgumentException();
        this.w1 = word1.getBytes(StandardCharsets.UTF_8);
        this.w2 = word2.getBytes(StandardCharsets.UTF_8);
    }

    public boolean isDistanceOne() {
        return getDistance() == 1;
    }

    private int getDistance() {
        int diff = 0;

        for (int i=0; i< w1.length; i++) {
            if (w1[i] != w2[i])
                diff++;
        }

        return diff;
    }
}
