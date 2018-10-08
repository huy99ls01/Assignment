package app.GUI;

import app.CommandLine.Dictionary;
import app.CommandLine.DictionaryManagement;
import app.CommandLine.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class Controller implements Initializable {


    @FXML private ListView<String> listView = new ListView<>();


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    @FXML
    public void ShowAllWordsButton(ActionEvent event)  {

        //ArrayList<String> listWordsInViewList = new ArrayList<String>();

        ArrayList<String> listWordsInViewList = new ArrayList<>();
        listWordsInViewList = DictionaryManagement.dictionaryManagement.ass();

        ObservableList<String> listWord = FXCollections.observableArrayList(listWordsInViewList);
        listView.setItems(listWord);
    }
}
