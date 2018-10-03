import java.util.*;
public class DictionaryCommandline {
    static Scanner wordRead = new Scanner(System.in);
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

    public static void dictionarySearcher(Dictionary dict) {
        String searchWord;
        System.out.print("Search: ");
        searchWord = wordRead.nextLine();
        String searchWord1 = searchWord + "@";
        String searchWord2 = searchWord + "~";
        for (Word wr : dict.getWords()) {
            if (searchWord1.compareTo(wr.getWord_target()) < 0 && searchWord2.compareTo(wr.getWord_target()) > 0) {
                System.out.println(wr.getWord_target());
            }
        }
    }

    public static void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile(showWord);
        DictionaryCommandline.showAllWords();
        //DictionaryManagement.dictionaryLookup(showWord);
        DictionaryCommandline.dictionarySearcher(showWord);
    }



}