import java.util.*;

public class WordsGraph {

    private final Map<String, Node> graph = new HashMap<>();

    public WordsGraph(Set<String> words) {
        addWordsToGraph(words);
        addChildren(words);
    }

    private void addChildren(Set<String> words) {
        words.forEach(word1 ->
            words.forEach(word2 -> {
                WordHopsCalculator wc = new WordHopsCalculator(word1, word2);
                if (wc.isDistanceOne()) {
                    Node word1Node = graph.get(word1);
                    Node word2Node = graph.get(word2);
                    word1Node.addChild(word2Node);
                }
            })
        );
    }

    private void addWordsToGraph(Set<String> words) {
        words.forEach(this::putNode);
    }

    private void putNode(String word) {
        graph.put(word, new Node(word));
    }

    public Node get(String word) {
        return graph.get(word);
    }

    public int minNumberOfHops(String source, String dest) {
        Node sourceNode = graph.get(source);
        Set<String> visited = new LinkedHashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(sourceNode);

        int hops = 0;
        int nodesInLevel = 1;
        int processNodesInLevel = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            processNodesInLevel++;

            if (node.value().equals(dest)) {
                return hops;
            }

            if (visited.contains(node.value()))
                continue;
            visited.add(node.value());

            queue.addAll(node.children());

            if (processNodesInLevel == nodesInLevel) {
                nodesInLevel = queue.size();
                processNodesInLevel = 0;
                hops++;
            }
        }

        return 0;
    }
}
