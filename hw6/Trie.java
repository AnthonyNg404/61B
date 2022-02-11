public class Trie {

    private static final int R = 256; // ASCII
    private Node root;	// root of trie

    private static class Node {
        private boolean isKey;
        private int words;
        private int prefixes;
        private DataIndexedCharMap next;
        private Node(boolean b, int R) {
            isKey = b;
            words = 0;
            prefixes = 0;
            next = new DataIndexedCharMap<Node>(R);
        }
    }

    public Trie() {
        root = new Node(false, R);
    }

    private static class DataIndexedCharMap<V> {
        private V[] items;
        public DataIndexedCharMap(int R) {
            items = (V[]) new Object[R];
        }
    }

    public void insert(String s) {
        addWord(root, s);
    }



    private void addWord(Node node, String word) {
        if (word.length() == 0) { // if all characters of the word has been
            // added
            node.words++;
            node.isKey = true;
        } else {
            node.words++;
            node.prefixes++;
            char c = word.charAt(0);
            if (node.next.items[c] == null) { // if the edge does NOT exist
                node.next.items[c] = new Node(false, R);
            }
            addWord((Node) node.next.items[c], word.substring(1)); // go the the next
            // character
        }
    }


    public boolean contains(String s) {
        return isContains(root, s);
    }

    private boolean isContains(Node node, String word) {
        if (node.isKey && word.length() == 0) {
            return true;
        }
        char c = word.charAt(0);
        if (node.next.items[c] == null) { // if the edge does NOT exist
            return false;
        }
        return isContains((Node) node.next.items[c], word.substring(1));
    }

    public boolean prefix(String s) {
        return isPrefix(root, s);
    }

    private boolean isPrefix(Node node, String word) {
        if (word.length() == 0 && !node.isKey) {
            return true;
        } else if (word.length() == 0) {
            return false;
        }
        char c = word.charAt(0);
        if (node.next.items[c] == null) { // if the edge does NOT exist
            return false;
        }
        return isPrefix((Node) node.next.items[c], word.substring(1));
    }

    public static void main(String[] args) {
        Trie a = new Trie();
        /**a.insert("china");
        a.insert("chin");
        a.insert("China");
        System.out.println(a.root.words);
        System.out.println(a.contains("chin"));
        System.out.println(a.contains("china"));
        System.out.println(a.contains("bbb"));
        System.out.println(a.contains("China"));
        System.out.println(a.prefix("Chi"));
        System.out.println(a.prefix("chi"));
        System.out.println(a.prefix("ch"));
        System.out.println(a.prefix("hi"));*/
        Trie words = new Trie();
        In readWords = new In(Boggle.dictPath);
        for (String s : readWords.readAllStrings()) {
            words.insert(s);
        }
        System.out.println(words.contains("British's"));
        System.out.println(words.contains("Britxish's"));
        System.out.println(words.contains("éclair's"));
        System.out.println(words.prefix("éclair's"));
        System.out.println(words.prefix("éclai"));
        System.out.println(words.prefix("éclaix"));

    }

}
