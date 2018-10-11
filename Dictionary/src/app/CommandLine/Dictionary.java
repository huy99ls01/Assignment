package app.CommandLine;

import java.util.TreeSet;

/**
 *
 * Dictionary software
 * @author TranQuangHuy and DoVanBang
 * @version java 1.8
 *
 */
public class Dictionary {

    public static Dictionary dic = new Dictionary();

    private TreeSet<Word> words = new TreeSet<Word>();

    private TreeSet<Word> favoriteWords = new TreeSet<>();

    /**
     * return an object of class Word
     * @return
     */
    public TreeSet<Word> getWords() {
        return words;
    }

    public TreeSet<Word> getFavoriteWords() {
        return favoriteWords;
    }
}
