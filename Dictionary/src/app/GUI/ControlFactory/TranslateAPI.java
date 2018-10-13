package app.GUI.ControlFactory;

import com.voicerss.tts.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import java.net.URL;
import java.util.ResourceBundle;

public class TranslateAPI implements Initializable {

    @FXML private  TextArea textAreaEn;

    @FXML private  TextArea textAreaVi;
    /**
     *
     * when this method call it'll turn back to dictionary scene
     * @param event
     * @throws Exception
     *
     */
    @FXML
    public void SwitchToTranslateScreen(ActionEvent event) throws Exception{
        //switch to dictionary scene
        Parent addViewScreen = FXMLLoader.load(getClass().getResource("dictionary.fxml"));
        Scene addViewScene = new Scene(addViewScreen);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addViewScene);
        window.show();
    }


    /**
     *
     * take the text just translate to textAreaVi
     * @param event
     * @throws Exception
     *
     */
    public void TranslateButton(ActionEvent event) throws Exception{
        String text = "";
        text = textAreaEn.getText();
        text = Translate("en", "vi", text);
        textAreaVi.setText(text);
    }

    public void PlaySoundOfText(ActionEvent event) throws Exception {
        //API gọi tới nhà cung cấp để lấy file phát âm theo từ khóa word
        VoiceProvider tts = new VoiceProvider("1d7d26040c284a6ba91ecb53977ee3f0");
        String word = textAreaEn.getText();
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

    /**
     *
     * Access to Google API and Translate text in textAreaEn
     * @param langFrom
     * @param langTo
     * @param text
     * @return
     * @throws IOException
     *
     */
    public String Translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbxZ0ZFfaj6-Yx3gFET33QRYONUWJ4bCRsZK9A4-Id9C17Flboo/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
