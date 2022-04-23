package XD.XDDOS.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable {

    FileChooser proxyFileChooser = new FileChooser();

    @FXML TextArea consoleArea;
    @FXML TextField ipField;
    @FXML TextField portField;
    @FXML Label experimentalWarning;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        experimentalWarning.setVisible(false);
    }

    public void chooseProxyFile() {
        File file = proxyFileChooser.showOpenDialog(new Stage());
    }

    
}
