
# Amazon coding challenge 

Interviewer:  [Nemanja Boric](https://www.linkedin.com/in/nemanja-boric-5560b816b/) 


## Problem
Given a set of words

```
{ dog, bat, cat, rag, dat, mat, cag, dag }
```

Find the mininum number of hops to go from one word to another by changing one letter at a time having that new word in the set.

Example: Go from cat to dog 

    source: cat
    target: dog

There are multiple routes:

    cat -> cag -> dag -> dog
    cat -> bat -> dat -> dag -> dog
    cat -> dat -> dag -> dog

## Approach

This problem can be modeled with Graphs.


    dog - dag - rag - cag
          |  \
          |    \
    bat - cat - dat - mat

So we can do the following:
1. Turn the Set into a Graph
2. Find the shortest route from one word to another using DSF/BSF.



## My partial solution

```java
public int findShortestPath(Set<String> words, String source, String target) {

    // turn the set of words into a Graph (islands)
    
    
    // BSF

}

private Set<Node> createGraph(Set<String> words) {

    if (words.isEmpty()) return new Set();
    
    Set<Node> output = new HashSet<>();
    
    for (String word: words) {
        
        Node node = new Node()
        node.word = word;
        
        // find egdes (words with only one letter diff)
        Set<String> oneLetterDiffWords = findWordsWithOneLetterDiff(words, word);
        for (String w : oneLetterDiffWords) {
            node.edges.add(w);
        }
        
        output.add(node);
        
    }
    
    return output;

}

class Node {
    String word;
    Set<String> edges;
}
```