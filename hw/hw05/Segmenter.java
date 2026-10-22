import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Segmenter {

    private final Trie trie;

    public Segmenter(Trie trie) {
        this.trie = trie;
    }


    public ArrayList<String> segmentDP(String input) {
        // Implement this
        return null;
    }


    public static void main(String[] args) throws IOException {
        Trie sample_trie = new Trie("sample_vocab.txt");
        System.out.println(sample_trie.contains("the"));
        System.out.println(sample_trie.contains("ant"));
        System.out.println(sample_trie.contains("ants"));



        Segmenter segmenter = new Segmenter(sample_trie);



        String input = "theantbitthepanda";
        System.out.println(segmenter.segmentDP(input));

        System.out.println("Get count after first segmentation: " + Trie.getCount());

    }
}