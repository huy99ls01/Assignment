package app.CommandLine;


/**
 *
 * Dictionary software
 * @author TranQuangHuy and DoVanBang
 * @version java 1.8
 *
 */
public class Word implements Comparable<Word>{


    private String word_target, word_explain, word_sound;;

    /**
     *  Constructor set word_target and word_explain
     */
    public Word() {
        word_explain = word_target = word_sound = "";
    }

    /**
     * also a Constructor to set word_target and word_explain
     * @param word_target
     * @param word_explain
     */
    public Word(String word_target, String word_explain, String word_sound) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.word_sound = word_sound;
    }

    public void setWord_sound(String word_sound) {
        this.word_sound = word_sound;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_sound() {
        return word_sound;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    @Override
    public int compareTo(Word word) {
        return this.getWord_target().compareTo(word.getWord_target());
    }

    @Override
    public String toString() {
        return word_target;
    }
}
