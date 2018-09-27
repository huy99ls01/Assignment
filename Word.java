public class Word implements Comparable<Word>{

    private static String word_target, word_explain;

    public static void setWord_target(String word_target) {
        Word.word_target = word_target;
    }

    public static void setWord_explain(String word_explain) {
        Word.word_explain = word_explain;
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
}
