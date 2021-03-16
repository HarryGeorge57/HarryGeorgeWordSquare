import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WordStringFileReader wordStringFileReader = new WordStringFileReader();
        wordStringFileReader.WordSquareReader();
        String fourLetterSquare = wordStringFileReader.fourLetterSquare;
        FourSquareMaker fourSquareMaker = new FourSquareMaker();
        fourSquareMaker.fourLetterSquareSolution(fourLetterSquare);
    }
}
