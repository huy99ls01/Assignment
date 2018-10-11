package app.GUI.ControlFactory;

import app.CommandLine.Dictionary;
import app.CommandLine.DictionaryManagement;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class Controller implements Initializable {


    @FXML private ListView<String> listView = new ListView<>();

    @FXML private ListView<String> listWords = new ListView<>();

    @FXML private TextField searchedWord;

    //@FXML private ListView listView;

    @FXML private TextArea textArea;

    @FXML private Label labelSound;

    @FXML private Label labelTargetWord;


    /**
     * wwhen this method call, it'll print all en_words int txt file
     * @param
     */
    /*@FXML
    public void ShowAllWordsButton(ActionEvent event)  {

        //ArrayList<String> listWordsInViewList = new ArrayList<String>();

        ArrayList<String> listWordsInViewList = new ArrayList<>();
        listWordsInViewList = DictionaryManagement.dictionaryManagement.ass();

        ObservableList<String> listWord = FXCollections.observableArrayList(listWordsInViewList);
        listView.setItems(listWord);
    }*/

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

    public void RemoveWord(ActionEvent event) throws  Exception{
        DictionaryManagement.dictionaryRemove(this.labelTargetWord.getText());
        DictionaryManagement.dictionaryExportToFile();
    }


    public void PlaySound(ActionEvent event) {
        String music = "/home/dean/IdeaProjects/Dictionary/src/app/GUI/Sound/block.mp3";
        Media sound = new Media(new File(music).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void AddFavoriteButton(ActionEvent event) throws Exception{
        DictionaryManagement.dictionaryExportToFile(labelTargetWord.getText(), textArea.getText(), labelSound.getText());
    }

    public void ShowFavoriteWord(ActionEvent event) {
        DictionaryManagement.insertFromFileFavorite();

        TreeSet<String> listSuggestWord;
        listSuggestWord = DictionaryManagement.dictionaryManagement.searchWord(Dictionary.dic.getFavoriteWords());
        ObservableList<String> result = FXCollections.observableArrayList(listSuggestWord);
        listWords.setItems(result);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        listWords.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
