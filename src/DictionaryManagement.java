import java.io.File;
import java.io.FileNotFoundException;
import  java.util.*;

public class DictionaryManagement {

    static Scanner reader = new Scanner(System.in);

    public static int numbers;

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

    }

    public static void insertFromFile(Dictionary dic) {

        String fileName = "/Users/bangdo/Documents/STUDY/OOP/Dictionary/src/dict.txt";

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

    public void dictionaryExportToFile() {

    }
}