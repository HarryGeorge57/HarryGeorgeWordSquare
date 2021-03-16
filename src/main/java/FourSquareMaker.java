import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FourSquareMaker {
    static int n;
    WordStringFileReader wordStringFileReader = new WordStringFileReader();
    String fourLetterWordSquare = wordStringFileReader.fourLetterSquare;
    String dictionary = "src/main/resources/Dictionary.txt";
    FitsInLetterBank fitsInLetterBank = new FitsInLetterBank();
    GetWordSquare getWordSquare = new GetWordSquare();

   public void fourLetterSquareSolution(String fourLetterWordSquare) throws IOException {
       long startTime = System.nanoTime();
       String[] fourLetterArg = fourLetterWordSquare.split(" ");
       n = Integer.parseInt(fourLetterArg[0]);
       char[] charset = fourLetterArg[1].toCharArray();

       Node wordTrie = new Node();
       int[] charFreq = new int[26];
       for (char c : charset)
            charFreq[c - 'a']++;

       BufferedReader dictionaryReader = new BufferedReader(new FileReader(dictionary));
       String dictWord;
       while ((dictWord = dictionaryReader.readLine()) != null) {
           if (dictWord.length() == n && FitsInLetterBank.goesInLetterBank(dictWord,charFreq)) {
               Node curNode = wordTrie;
               for (int i = 0; i< dictWord.length(); i++) {
                   int c = dictWord.charAt(i) - 'a';
                   if (curNode.children[c] == null)
                       curNode.children[c] = new Node(c);
                   curNode= curNode.children[c];
               }
           }

       }
       char[][] result = GetWordSquare.getFourWordSquare(wordTrie, charFreq);
       long endTime = System.nanoTime();

       if (result != null)
           for (int i=0; i<result.length; i++)
               System.out.print("No valid word square could be created");
           System.out.print("\n Time to execute was: " + Double.toString((endTime-startTime) / 1000000000.0)+"s");
   }



    static class Node {
        int val;
        Node[] children;

        Node() {
            children = new Node[26];
        }
        Node(int val){
            this();
            this.val = val;
        }
    }
}
