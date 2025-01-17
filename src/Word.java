public class Word implements Comparable<Word>{

    private String word_target, word_explain;

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
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