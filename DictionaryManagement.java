import  java.util.Scanner;

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

    public static void insertFromFile() {

    }

    public static void dictionaryLookup() {

    }

    public void dictionaryExportToFile() {

    }
}
