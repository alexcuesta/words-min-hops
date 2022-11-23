import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record Node(
        String value,
        List<Node> children
) {
    Node(String value) {
        this(value, new LinkedList<>());
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public Set<String> getOneHopWords() {
        return children.stream()
                .map(node -> node.value)
                .collect(Collectors.toSet());
    }
}
