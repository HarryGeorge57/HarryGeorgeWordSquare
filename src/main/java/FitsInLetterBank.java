public class FitsInLetterBank {

     static boolean goesInLetterBank(String word, int[] charFreq) {
        int[] charsUsed = new int[26];
        boolean diagonalUsed = false;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';

            int spaceLeft = charFreq[c] - charsUsed[c];
            if (spaceLeft > 1) { // try fitting letter in a non-diagonal slot
                charsUsed[c] += 2;
            } else if (spaceLeft == 1 && !diagonalUsed) { // else, try fitting it in the diagonal slot
                charsUsed[c] += 1;
                diagonalUsed = true;
            } else { // no space for letter
                return false;
            }
        }
        return true;
    }

}
