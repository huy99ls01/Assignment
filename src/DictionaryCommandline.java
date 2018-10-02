
public class DictionaryCommandline {

    private static int num = 1;

    public static Dictionary showWord = new Dictionary();

    public static void showAllWords() {
        System.out.println("No      |English            |Vietnamese");

        for (Word wr : showWord.getWords()) {

            System.out.println( num++ + "       |" + wr.getWord_target() + "             |" +  wr.getWord_explain());
        }

    }

    public static void dictionaryBasic(){
        //DictionaryManagement.insertFromCommandline(showWord);
        DictionaryManagement.insertFromFile(showWord);
        DictionaryCommandline.showAllWords();
    }

    public void dictionaryAdvanced() {

    }

    public void dictionarySearcher() {

    }

}