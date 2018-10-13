package app.GUI.ControlFactory;

import app.CommandLine.Dictionary;
import app.CommandLine.DictionaryManagement;
import com.voicerss.tts.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class Controller implements Initializable {


    @FXML private ListView<String> listWords = new ListView<>();

    @FXML private TextField searchedWord;

    @FXML private TextArea textArea;

    @FXML private Label labelSound;

    @FXML private Label labelTargetWord;


    /**
     * wwhen this method call, it'll print all en_words int txt file
     * @param
     */
    @FXML
    public void ShowAllWordsButton(ActionEvent event)  {

        //ArrayList<String> listWordsInViewList = new ArrayList<String>();

        ArrayList<String> listWordsInViewList = new ArrayList<>();
        listWordsInViewList = DictionaryManagement.dictionaryManagement.ass();

        ObservableList<String> listWord = FXCollections.observableArrayList(listWordsInViewList);
        listWords.setItems(listWord);
    }

    /**
     * when this method call, it'll change to AddScreen
     * @param event
     * @throws Exception
     */
    @FXML
    public void SwitchToAddScreen(ActionEvent event) throws Exception{
        Parent addViewScreen = FXMLLoader.load(getClass().getResource("AddScreen.fxml"));
        Scene addViewScene = new Scene(addViewScreen);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addViewScene);
        window.show();
    }

    @FXML
    public void SwitchToTranslateScreen(ActionEvent event) throws Exception {
        Parent addViewScreen = FXMLLoader.load(getClass().getResource("TranslateAPI.fxml"));
        Scene addViewScene = new Scene(addViewScreen);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addViewScene);
        window.show();
    }

    /**
     * this method use to suggest the word you want to find
     */
    public void SuggestionList () {
        TreeSet<String> listSuggestWord;
        String inputWord = searchedWord.getText();
        listSuggestWord = DictionaryManagement.dictionaryManagement.searchWord(Dictionary.dic.getWords(),inputWord);
        ObservableList<String> result = FXCollections.observableArrayList(listSuggestWord);
        listWords.setItems(result);
    }

    /**
     *
     * this method use to collect word_explain and sound to text area
     *
     */
    public void ClickToListView() {
        String textAreaString = "";
        ObservableList listOfItems = listWords.getSelectionModel().getSelectedItems();
        for (Object item : listOfItems) {
            //textAreaString += String.format("%s%n", (String) item);
            textAreaString += item;
        }

        String wordExplain = "";
        String soundWord = "";

        soundWord += DictionaryManagement.getWordSoundForTextArea(textAreaString);
        wordExplain += DictionaryManagement.getWordExplainForTextArea(textAreaString);

        this.labelTargetWord.setText(textAreaString);
        this.labelSound.setText(soundWord);
        this.textArea.setText(wordExplain);
    }

    /**
     *
     * this method use to remove a word from dictionary
     * @param event
     * @throws Exception
     *
     */
    public void RemoveWord(ActionEvent event) throws  Exception{
        DictionaryManagement.dictionaryRemove(this.labelTargetWord.getText());
        DictionaryManagement.dictionaryExportToFile();
    }


    /*public void PlaySound(ActionEvent event) {
        String music = "/home/dean/IdeaProjects/Dictionary/src/app/GUI/Sound/block.mp3";
        Media sound = new Media(new File(music).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }*/


    /**
     *
     * this method call and it'll push a new word in dictionary
     * @param event
     * @throws Exception
     *
     */
    public void AddFavoriteButton(ActionEvent event) throws Exception{
        DictionaryManagement.dictionaryExportToFile(labelTargetWord.getText(), textArea.getText(), labelSound.getText());
    }

    /**
     *
     * this method will show all the favortire word
     * @param event
     */
    public void ShowFavoriteWord(ActionEvent event) {
        DictionaryManagement.insertFromFileFavorite();

        TreeSet<String> listSuggestWord;
        listSuggestWord = DictionaryManagement.dictionaryManagement.searchWord(Dictionary.dic.getFavoriteWords());
        ObservableList<String> result = FXCollections.observableArrayList(listSuggestWord);
        listWords.setItems(result);

    }

    /**
     *
     * this method will play sound mapping to the word you click in list view,
     * and you have to connect to internet so that this function could run
     * @param event
     * @throws Exception
     *
     */
    public void ClickForSound(ActionEvent event) throws Exception{

        //API gọi tới nhà cung cấp để lấy file phát âm theo từ khóa word
        VoiceProvider tts = new VoiceProvider("1d7d26040c284a6ba91ecb53977ee3f0");
        String word = listWords.getSelectionModel().getSelectedItem();
        VoiceParameters params = new VoiceParameters(word, Languages.English_UnitedStates);
        params.setCodec(AudioCodec.WAV);
        params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setSSML(false);
        params.setRate(0);
        byte[] voice = tts.speech(params);

        // Lưu file âm thanh tải về vào file voice.mp3
        FileOutputStream fos = new FileOutputStream("src/app/GUI/Sound/voice.mp3");
        fos.write(voice, 0, voice.length);
        fos.flush();
        fos.close();

        // Mở file mp3 bằng FileInputStream
        String gongFile = "src/app/GUI/Sound/voice.mp3";
        InputStream in = new FileInputStream(gongFile);

        // Tạo audiostream từ FileInputStream
        AudioStream audioStream = new AudioStream(in);

        // Mở file âm thanh vừa tải về
        AudioPlayer.player.start(audioStream);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        DictionaryManagement.insertFromFileFavorite();
        listWords.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

}
