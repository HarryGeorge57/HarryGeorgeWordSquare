public class GetWordSquare {

    static int n = FourSquareMaker.n;

    static char[][] getFourWordSquare(FourSquareMaker.Node wordTrie, int[] charFreq) {
        FourSquareMaker.Node trieRoot = wordTrie;
        FourSquareMaker.Node[][] mat = new FourSquareMaker.Node[n][n + 1];
        for (int i = 0; i < mat.length; i++)
            mat[i][0] = trieRoot;
        int[] bank = charFreq.clone();
        if (rec(0, 1, mat, bank)) {
            char[][] result = new char[n][n];
            for (int r = 0; r < n; r++)
                for (int c = 0; c < n; c++)
            result[r][c] = (char) (mat[r][c + 1].val + 'a');
            return result;
        } else {
            return null;
        }
    }

    static boolean rec(int r, int c, FourSquareMaker.Node[][] mat, int[] bank) {
        int incrAmt = r==c-1 ? 1 : 2;

        for (int l = 0; l<26; l++) {
            FourSquareMaker.Node node = mat[r][c-1].children[l];
            FourSquareMaker.Node nodeMirrorSide = mat[c-1][r].children[l];
            if(node != null && nodeMirrorSide != null && bank[l] >=incrAmt) {
                mat[r][c] = node;
                mat[c - 1][r + 1] = nodeMirrorSide;
                bank[l] -= incrAmt;

                if (c == n){
                    if (r == n -1 || rec(r + 1, r + 2, mat, bank)){
                        return true;
                    }
                }else if (rec(r, c + 1, mat, bank)) {
                    return true;
                }
                bank[l] += incrAmt;
            }
        }
        return false;
    }
}
