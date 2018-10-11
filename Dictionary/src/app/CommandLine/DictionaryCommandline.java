package app.CommandLine;


import static app.CommandLine.Dictionary.dic;

/**
 *
 * Dictionary software
 * @author TranQuangHuy and DoVanBang
 * @version java 1.8
 *
 */
public class DictionaryCommandline {


    private static int num = 1;

    /**
     * this method will show all the word to console
     */
    public static void showAllWords() {
        //System.out.println("No      |English            |Vietnamese");

        for (Word wr : dic.getWords()) {

            System.out.println("-" + wr.getWord_explain());
        }

    }

    /**
     * this method use for command line call 3 method insertfromcommandline, showallwords and insertfromfile
     */
    public static void dictionaryBasic(){
        //DictionaryManagement.insertFromCommandline(showWord);
        //DictionaryManagement.insertFromFile(dic);
        //DictionaryCommandline.showAllWords();
    }

    /**
     * this me thod just like dictionary but it contain Application for dictionary
     */
    public static void dictionaryAdvanced() {
        DictionaryManagement.insertFromFiletest();
        //DictionaryManagement.insertFromFile(dic);
        //DictionaryManagement.dictionaryLookup(showWord);
        //DictionaryManagement.dictionaryRemove(showWord);
        //DictionaryCommandline.showAllWords();

    }

    public void dictionarySearcher() {

    }

}
