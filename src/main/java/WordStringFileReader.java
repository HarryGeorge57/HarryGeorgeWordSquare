import java.io.BufferedReader;
import java.io.IOException;

public class WordStringFileReader {
    String wordSquares = "src/main/resources/WordSquares";
    String fourLetterSquare;
    String fiveLetterSquareA;
    String fiveLetterSquareB;
    String sevenLetterSquare;

    void WordSquareReader() throws IOException {
        BufferedReader br = new BufferedReader(new java.io.FileReader(wordSquares));
        fourLetterSquare = br.readLine();
        fiveLetterSquareA = br.readLine();
        fiveLetterSquareB = br.readLine();
        sevenLetterSquare = br.readLine();
    }

}
