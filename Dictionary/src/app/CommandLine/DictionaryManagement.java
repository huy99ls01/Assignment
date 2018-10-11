package app.CommandLine;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


/**
 *
 * Dictionary software
 * @author TranQuangHuy and DoVanBang
 * @version java 1.8
 *
 */
public class DictionaryManagement {

    static Scanner reader = new Scanner(System.in);

    public static DictionaryManagement dictionaryManagement = new DictionaryManagement();

    //public static int numbers;

    /**
     *
     * this method use to input from keyboard
     *
     */
    /*
    public static void insertFromCommandline(Dictionary dic) {

        numbers = reader.nextInt();

        reader.nextLine();
        for (int i = 0; i < numbers; i++) {

            Word putInWord = new Word();
            String en_word, vn_word;

            System.out.print("English Word: ");
            en_word = reader.nextLine();
            putInWord.setWord_target(en_word);



            System.out.print("VietNameses Word: ");
            vn_word = reader.nextLine();
            putInWord.setWord_explain(vn_word);


            dic.getWords().add(putInWord);

        }

    }*/

    /**
     *
     * this method will read from txt file
     * @param dic
     *
     */
    public static void insertFromFile(Dictionary dic) {

        String fileName = "//home/dean/IdeaProjects/Assignment1/src/dictionary.txt";

        File file = new File(fileName);


        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                Word putInWord = new Word();
                // to save the english word
                String i = sc.next();
                // to save the vietnamese word
                String t = sc.nextLine();
                // remove white space not necessary
                t = t.trim();

                putInWord.setWord_target(i);
                putInWord.setWord_explain(t);

                dic.getWords().add(putInWord);
            }

            sc.close();
        }
        catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

    /**
     *
     * this method use to find the word you want to find
     * @param dic
     *
     */
    public static void dictionaryLookup(Dictionary dic) {
        String lookup;
        System.out.print("Word need to look: ");
        lookup = reader.nextLine();

        for (Word wr : dic.getWords()) {
            if (lookup.equals(wr.getWord_target())) {
                System.out.println(wr.getWord_explain());
            }
        }
    }

    /**
     *
     * this method return word_Explain to show in textArea
     * @param text
     * @return
     *
     */
    public static String getWordExplainForTextArea(String text) {

        String word = "";

        for (Word wr : Dictionary.dic.getWords()) {

            if (wr.getWord_target().equals(text)) {
                word = wr.getWord_explain();
            }
        }
        return word;
    }

    /**
     *
     * this method return word_sound to show in label
     * @param text
     * @return
     *
     */
    public static String getWordSoundForTextArea(String text) {
        String word = "";
        for (Word wr : Dictionary.dic.getWords()) {
            if (wr.getWord_target().equals(text)) {
                word = wr.getWord_sound();
            }
        }
        return word;
    }

    /**
     *
     * this method use to remove word
     * @param dic is an object of dictionary class
     *
     */
    public static void dictionaryRemove(String lookup) {
        //String lookup;
        //System.out.print("Word need to remove: ");
        //lookup = reader.nextLine();
        Dictionary.dic.getWords().remove(new Word(lookup, null, null));
    }

    /**
     *
     * this method return a word you want  to find and all others word that related
     * ex:
     * input: hel
     * output: hello, hell, ...
     * @param words is an object of Word class
     * @param input is a word you input from keyboard
     * @return
     *
     */
    public TreeSet<String> searchWord(TreeSet<Word> words, String input){
        TreeSet<String> arr = new TreeSet<>();
        for(Word w :words) {
            if (w.getWord_target().startsWith(input)) {
                arr.add(w.getWord_target());
            }

        }
        return arr;
    }

    /**
     *
     * return words that in favorite file
     * @param words
     * @return
     */
    public TreeSet<String> searchWord(TreeSet<Word> words){
        TreeSet<String> arr = new TreeSet<>();
        for(Word w :words) {
            arr.add(w.getWord_target());
        }
        return arr;
    }

    /**
     *
     * this method use to read from file and it contain more element that is sound what i mean is how that word speak.
     *
     */
    public static void insertFromFiletest() {
        try {
            String content= dictionaryManagement.readFile("/home/dean/IdeaProjects/Dictionary/src/app/CommandLine/dictionary2.txt", Charset.defaultCharset());
            String[] words = content.split("@");
            for (String word: words) {
                String result[] = word.split("\r?\n", 2);
                if (result.length >1) {
                    String wordExplain1 = new String();
                    String wordTarget1 = new String();
                    String wordSound1 = new String();
                    if(result[0].contains("/")) {
                        String firstmeaning = result[0].substring(0, result[0].indexOf("/"));
                        String lastSoundMeaning = result[0].substring(result[0].indexOf("/"), result[0].length());
                        wordTarget1 = firstmeaning;
                        wordSound1 = lastSoundMeaning;
                    }
                    else
                    {
                        wordTarget1 = result[0];
                        wordSound1 = "";
                    }
                    wordExplain1 = result[1];

                    wordTarget1 = wordTarget1.trim();
                    wordExplain1 = wordExplain1.trim();
                    wordSound1 = wordSound1.trim();

                    Dictionary.dic.getWords().add( new Word(wordTarget1, wordExplain1, wordSound1));
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * Read favorite file that contain favorite words
     *
     */
    public static void insertFromFileFavorite() {
        try {
            String content= dictionaryManagement.readFile("/home/dean/IdeaProjects/Dictionary/src/app/CommandLine/dictionaryFavoriteWord.txt", Charset.defaultCharset());
            String[] words = content.split("@");
            for (String word: words) {
                String result[] = word.split("\r?\n", 2);
                if (result.length >1) {
                    String wordExplain1 = new String();
                    String wordTarget1 = new String();
                    String wordSound1 = new String();
                    if(result[0].contains("/")) {
                        String firstmeaning = result[0].substring(0, result[0].indexOf("/"));
                        String lastSoundMeaning = result[0].substring(result[0].indexOf("/"), result[0].length());
                        wordTarget1 = firstmeaning;
                        wordSound1 = lastSoundMeaning;
                    }
                    else
                    {
                        wordTarget1 = result[0];
                        wordSound1 = "";
                    }
                    wordExplain1 = result[1];

                    wordTarget1 = wordTarget1.trim();
                    wordExplain1 = wordExplain1.trim();
                    wordSound1 = wordSound1.trim();

                    Dictionary.dic.getFavoriteWords().add( new Word(wordTarget1, wordExplain1, wordSound1));
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public String readFile(String path, Charset encoding) throws IOException {

        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


    public ArrayList<String> abc(ArrayList<Word> words){
        ArrayList<String> arr = new ArrayList<>();
        for(Word w :words) {
            arr.add(w.getWord_target());
        }
        return arr;
    }

    public ArrayList<String> ass() {
        ArrayList<String> newtree = new ArrayList<>();

        for (Word word : Dictionary.dic.getWords()) {
            newtree.add(word.getWord_target());
        }

        return newtree;
    }


    public static void dictionaryExportToFile() throws Exception{

        PrintWriter printWriter = new PrintWriter("src/app/CommandLine/dictionary2.txt");

        for(Word wr : Dictionary.dic.getWords()) {
            String eachWord = "@" + wr.getWord_target() + " " + wr.getWord_sound() + "\n" + wr.getWord_explain();
            printWriter.println(eachWord);
        }
        printWriter.close();
    }

    public static void dictionaryExportToFile(String word_target, String word_explain, String word_sound) throws Exception {
        PrintWriter printWriter = new PrintWriter("src/app/CommandLine/dictionaryFavoriteWord.txt");

        Dictionary.dic.getFavoriteWords().add(new Word(word_target, word_explain, word_sound));

        for(Word wr : Dictionary.dic.getFavoriteWords()) {
            String eachWord = "@" + wr.getWord_target() + " " + wr.getWord_sound() + "\n" + wr.getWord_explain();
            printWriter.println(eachWord);
        }

        printWriter.close();
    }

    public TreeSet<String> find(TreeSet<Word> arrs, String tra) {
        TreeSet<String> arr = new TreeSet<>();
        for(Word w : arrs) {
            if(w.getWord_target().equals(tra)) {
                arr.add(w.getWord_explain());
            }
        }
        return arr;
    }
}
