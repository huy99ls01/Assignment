package app.CommandLine;


import app.GUI.ControlFactory.Main;

/**
 *
 * Dictionary software
 * @author TranQuangHuy and DoVanBang
 * @version java 1.8
 *
 */
public class DictionaryApplication {

    /**
     * this method use to run javafx
     */
    public static void runApplication() {

        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(Main.class);
            }
        }.start();

    }
}
