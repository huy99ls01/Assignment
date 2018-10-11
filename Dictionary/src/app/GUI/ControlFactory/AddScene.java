package app.GUI.ControlFactory;

import app.CommandLine.Dictionary;
import app.CommandLine.DictionaryManagement;
import app.CommandLine.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class AddScene implements Initializable {


    @FXML private TextField addTargetWord;

    @FXML private TextField addExplainWord;

    @FXML private TextField addSoundWord;

    /**
     * this method use to switch to dictionary2.fxml
     * @param event
     * @throws Exception
     */
    @FXML
    public void SwitchToAddScreen(ActionEvent event) throws Exception{
        //switch to dictionary scene
        Parent addViewScreen = FXMLLoader.load(getClass().getResource("dictionary.fxml"));

        String targetWord = addTargetWord.getText();
        String explainWord = addExplainWord.getText();
        String soundWord = addSoundWord.getText();

        Dictionary.dic.getWords().add(new Word(targetWord, explainWord, soundWord));
        DictionaryManagement.dictionaryExportToFile();


        Scene addViewScene = new Scene(addViewScreen);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addViewScene);
        window.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
