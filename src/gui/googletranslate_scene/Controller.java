package gui.googletranslate_scene;

import dictionary.Operate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private  TextArea input = new TextArea();

    @FXML
    private  TextArea output = new TextArea();

//    @FXML
//    private Button trans = new Button();
//
//    @FXML
//    private Button Speakinput = new Button();
//
//    @FXML
//    private Button Speakoutput = new Button();

    @FXML
    private ToggleGroup group = new ToggleGroup();

    @FXML
    private RadioButton EV = new RadioButton();

    @FXML
    private RadioButton VE = new RadioButton();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EV.setToggleGroup(group);
        VE.setToggleGroup(group);
    }

    public void translate(MouseEvent mouseEvent) throws IOException{
        if (input.getText().isBlank()){
            return;
        }
        else {
            if (EV.isSelected()) {
                output.clear();
                String meaning = Operate.Translate.translate("en", "vi", input.getText());
                output.appendText(meaning);
            }else{
                output.clear();
                String meaning = Operate.Translate.translate("vi","en",input.getText());
                output.appendText(meaning);
            }
        }
    }
    public void Speak_input (ActionEvent event){
        Operate.TextToSpeech.Speak(input.getText());
    }

    public void Speak_output (ActionEvent event){
        Operate.TextToSpeech.Speak(output.getText());
    }


}
