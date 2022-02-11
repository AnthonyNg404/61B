public class Boggle1 {

}
/**import java.util.ArrayList;
 import java.util.List;
 import java.io.File;

 public class Boggle {

 // File path of dictionary file
 static String dictPath = "words.txt";

 /**
 * Solves a Boggle puzzle.
 *
 * @param k The maximum number of words to return.
 * @param boardFilePath The file path to Boggle board file.
 * @return a list of words found in given Boggle board.
 *         The Strings are sorted in descending order of length.
 *         If multiple words have the same length,
 *         have them in ascending alphabetical order.
 *//*
    public static List<String> solve(int k, String boardFilePath) {
        // YOUR CODE HERE
        if (k <= 0) {
            throw new IllegalArgumentException();
        }
        File dir = new File(boardFilePath);
        if (!dir.exists()) {
            throw new IllegalArgumentException();
        }
        In readBoard = new In(boardFilePath);
        int y = 0;
        int x = readBoard.readLine().length();
        for (String s : readBoard.readAllLines()) {
            if (x != s.length()) {
                throw new IllegalArgumentException();
            }
            y += 1;
        }

        Trie words = new Trie();
        In readWords = new In(dictPath);
        for (String s : readWords.readAllStrings()) {
            words.insert(s);
        }

        Character[] grid = grid(x, y, readBoard);
        ArrayList<String> toReturn = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            ArrayList<Integer> index = new ArrayList<>();
            index.add(i);
            toReturn = findWord(i, words, index, grid[i].toString(), toReturn, grid, x, y);
        }


        return null;
    }

    private static Character[] grid(int x, int y, In in) {
        Character[] g = new Character[x * y];
        for (int i = 0; i < x * y; i++) {
            g[i] = in.readChar();
        }
        return g;
    }

    private int toIndex(int x, int y, int width) {
        return x + y * width;
    }

    private static ArrayList<String> findWord(int index, Trie words, ArrayList<Integer> checked, String s, ArrayList<String> list, Character[] grid, int width, int height) {
        if (words.contains(s)) {
            list.add(s);
            checked.add(index);
            for (int i : neighbor(index, checked, width, height)) {
                list = findWord(i, words, checked, s + grid[index].toString(), list, grid, width, height);
            }
        } else if (words.prefix(s)) {
            checked.add(index);
            for (int i : neighbor(index, checked, width, height)) {
                list = findWord(i, words, checked, s + grid[index].toString(), list, grid, width, height);
            }
        }
        return list;
    }

    private static ArrayList<Integer> neighbor(int index, ArrayList<Integer> checked, int width, int height) {
        ArrayList<Integer> a = new ArrayList<>();
        if (index % width == 0) {
            if (index / height == 0) {
                if (!checked.contains(index + 1)) {
                    a.add(index + 1);
                }
                if (!checked.contains(index + width)) {
                    a.add(index + width);
                }
                if (!checked.contains(index + width + 1)) {
                    a.add(index + width + 1);
                }
            } else if (index / height == height - 1) {
                if (!checked.contains(index + 1)) {
                    a.add(index + 1);
                }
                if (!checked.contains(index - width)) {
                    a.add(index - width);
                }
                if (!checked.contains(index - width + 1)) {
                    a.add(index - width + 1);
                }
            } else {
                if (!checked.contains(index + 1)) {
                    a.add(index + 1);
                }
                if (!checked.contains(index + width)) {
                    a.add(index + width);
                }
                if (!checked.contains(index - width)) {
                    a.add(index - width);
                }
                if (!checked.contains(index + width + 1)) {
                    a.add(index + width + 1);
                }
                if (!checked.contains(index - width + 1)) {
                    a.add(index - width + 1);
                }
            }
        } else if (index % width == width - 1) {
            if (index / height == 0) {
                if (!checked.contains(index - 1)) {
                    a.add(index - 1);
                }
                if (!checked.contains(index + width)) {
                    a.add(index + width);
                }
                if (!checked.contains(index + width - 1)) {
                    a.add(index + width - 1);
                }
            } else if (index / height == height - 1) {
                if (!checked.contains(index - 1)) {
                    a.add(index - 1);
                }
                if (!checked.contains(index - width)) {
                    a.add(index - width);
                }
                if (!checked.contains(index - width - 1)) {
                    a.add(index - width - 1);
                }
            } else {
                if (!checked.contains(index - 1)) {
                    a.add(index - 1);
                }
                if (!checked.contains(index + width)) {
                    a.add(index + width);
                }
                if (!checked.contains(index - width)) {
                    a.add(index - width);
                }
                if (!checked.contains(index + width - 1)) {
                    a.add(index + width - 1);
                }
                if (!checked.contains(index - width - 1)) {
                    a.add(index - width - 1);
                }
            }
        } else {
            if (index / height == 0) {

            } else if (index / height == height - 1) {

            } else {

            }
        }
    }

}*/