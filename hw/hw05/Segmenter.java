import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Segmenter {

    private final Trie trie;

    public Segmenter(Trie trie) {
        this.trie = trie;
    }


    public ArrayList<String> segmentDP(String input) {
        
        int len = input.length();
        
        ArrayList<ArrayList><String>> dp = new ArrayList<>();

        for (int i =0; i <= n; i++) {
            dp.add(null);
        } 

        dp.set(0, new ArrayList<String>());

        for (int i = 0; i <= n; i++) {
            for (int j = 1; i > j; j++) {

                String word = input.substring(i,j);/** */ Segments input[j:i] */

                if (dp.get(i) != null && trie.contains(word)) { /** Checks if segment is present & checks if word exist in vocab*/
                    ArrayList<String> result =
                    new ArrayList<>(dp.get(i));

                result.add(word);
                dp.set(i, result);
                break;
                }
            }
        }

        return dp.get(n);
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

        Trie sample_trie2 = new Trie("test_vocab.txt");
        System.out.println(sample_trie2.contains("fastbreak"));
        System.out.println(sample_trie2.contains("block"));
        System.out.println(sample_trie2.contains("score"));

        Segmenter segmenter2 = new Segmenter(sample_trie);
        String input2 = "thedefenceplayergotablockontheoffenseplayerduringthefastbreakstoppingthescore";

        System.out.println("Get count after first segmentation: " + Trie.getCount());



    }
}