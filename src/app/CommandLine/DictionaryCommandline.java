package app.CommandLine;


import static app.CommandLine.Dictionary.dic;

public class DictionaryCommandline {


    private static int num = 1;

    public static void showAllWords() {
        System.out.println("No      |English            |Vietnamese");

        for (Word wr : dic.getWords()) {

            System.out.println( num++ + "       |" + wr.getWord_target() + "             |" +  wr.getWord_explain());
        }

    }

    public static void dictionaryBasic(){
        //DictionaryManagement.insertFromCommandline(showWord);
        DictionaryManagement.insertFromFile(dic);
        DictionaryCommandline.showAllWords();
    }

    public static void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile(dic);
        //DictionaryCommandline.showAllWords();
        //DictionaryManagement.dictionaryLookup(showWord);
        //DictionaryManagement.dictionaryRemove(showWord);
        //DictionaryCommandline.showAllWords();
    }

    public void dictionarySearcher() {

    }

}
