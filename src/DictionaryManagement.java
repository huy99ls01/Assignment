import java.io.*;
import java.util.*;

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

        File dictionaryFile = new File("/Users/bangdo/Documents/STUDY/OOP/Dictionary/src/Dictionary.txt");
        try {
            Scanner sc = new Scanner(dictionaryFile);

            while (sc.hasNextLine()) {
                Word putInWord = new Word();
                String i = sc.next();
                //System.out.println(i + "-");
                String t = sc.nextLine();

                t = t.trim();
                putInWord.setWord_target(i);
                putInWord.setWord_explain(t);

                dic.getWords().add(putInWord);

                System.out.println(i + " --- "+t);

            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void dictionaryLookup() {

    }

    public void dictionaryExportToFile() {

    }


}