package XD.XDDOS.gui;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable {

    FileChooser proxyFileChooser = new FileChooser();

    private String[] versions = {
        "1.18.2",
        "1.18.1",
        "1.18", 
        "1.17.1",
        "1.17",   
        "1.16.5",
        "1.16.4",
        "1.16.3",
        "1.16.2",
        "1.16.1",
        "1.16",
        "1.15.2",
        "1.15.1",
        "1.15", 
        "1.14.4",
        "1.14.3",
        "1.14.2",
        "1.14.1",
        "1.14",
        "1.13.2",
        "1.13.1",
        "1.13" ,
        "1.12.2",
        "1.12.1",
        "1.12",
        "1.11.2",
        "1.11.1",
        "1.11",
        "1.10.2",
        "1.10.1",
        "1.10",
        "1.9.4",
        "1.9.3",
        "1.9.2",
        "1.9.1",
        "1.9",
        "1.8.x",
        "1.7.6 - 1.7.10",
        "1.7.2 - 1.7.5"
    };

    @FXML private TextArea consoleArea;
    @FXML private TextField ipField;
    @FXML private TextField portField;
    @FXML private Label experimentalWarning;
    @FXML private ComboBox<String> methodBox;
    @FXML private ComboBox<String> versionBox;

    public static HashMap<String, Integer> VERSION_ID = new HashMap();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        experimentalWarning.setVisible(false);
        initializeVersions();
        versionBox.getItems().addAll(versions);
        versionBox.setVisibleRowCount(5);
    }

    public void chooseProxyFile() {
        File file = proxyFileChooser.showOpenDialog(new Stage());
    }

    public void initializeVersions() {
        VERSION_ID.put("1.18.2", 758);
        VERSION_ID.put("1.18.1", 757);
        VERSION_ID.put("1.18",   757);
        VERSION_ID.put("1.17.1", 756);
        VERSION_ID.put("1.17",   755);
        VERSION_ID.put("1.16.5", 754);
        VERSION_ID.put("1.16.4", 754);
        VERSION_ID.put("1.16.3", 753);
        VERSION_ID.put("1.16.2", 751);
        VERSION_ID.put("1.16.1", 736);
        VERSION_ID.put("1.16", 735);
        VERSION_ID.put("1.15.2", 578);
        VERSION_ID.put("1.15.1", 575);
        VERSION_ID.put("1.15", 573);
        VERSION_ID.put("1.14.4", 498);
        VERSION_ID.put("1.14.3", 490);
        VERSION_ID.put("1.14.2", 485);
        VERSION_ID.put("1.14.1", 480);
        VERSION_ID.put("1.14", 477);
        VERSION_ID.put("1.13.2", 404);
        VERSION_ID.put("1.13.1", 401);
        VERSION_ID.put("1.13", 393);
        VERSION_ID.put("1.12.2", 340);
        VERSION_ID.put("1.12.1", 338);
        VERSION_ID.put("1.12", 335);
        VERSION_ID.put("1.11.2", 316);
        VERSION_ID.put("1.11.1", 316);
        VERSION_ID.put("1.11", 315);
        VERSION_ID.put("1.10.2", 210);
        VERSION_ID.put("1.10.1", 210);
        VERSION_ID.put("1.10", 210);
        VERSION_ID.put("1.9.4", 110);
        VERSION_ID.put("1.9.3", 110);
        VERSION_ID.put("1.9.2", 109);
        VERSION_ID.put("1.9.1", 108);
        VERSION_ID.put("1.9", 107);
        VERSION_ID.put("1.8.x", 47);
        VERSION_ID.put("1.7.6 - 1.7.10", 5);
        VERSION_ID.put("1.7.2 - 1.7.5", 4);
    }

    public void onComboBoxFocused() {
        versionBox.setStyle("-fx-border-radius: 7 7 0 0");
    }
    
}
