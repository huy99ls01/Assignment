package app.CommandLine;

import java.util.TreeSet;

public class Dictionary {

    public static Dictionary dic = new Dictionary();

    private TreeSet<Word> words = new TreeSet<Word>();

    public TreeSet<Word> getWords() {
        return words;
    }
}
