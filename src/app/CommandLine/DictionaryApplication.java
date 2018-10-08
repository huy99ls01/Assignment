package app.CommandLine;


import app.GUI.Controller;
import app.GUI.Main;
import javafx.application.Application;

public class DictionaryApplication {

    public static void runApplication() {

        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(Main.class);
            }
        }.start();

    }
}
