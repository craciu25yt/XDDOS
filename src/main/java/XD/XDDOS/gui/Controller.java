package XD.XDDOS.gui;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

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

    private double comboBoxWidth;
    private double comboBoxHeight;

    public static HashMap<String, Integer> VERSION_ID = new HashMap();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxWidth = methodBox.getWidth(); // DEFAULT 270
        comboBoxHeight = methodBox.getHeight(); // DEFAULT 35

        experimentalWarning.setVisible(false);
        initializeVersions();
        versionBox.getItems().addAll(versions);
        versionBox.setVisibleRowCount(9);

        versionBox.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };
            cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                cell.setStyle("-fx-font-size: 14px");

                Timeline timeline = new Timeline();
                if(isNowHovered) {
                    timeline.stop();
                    timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, // set start position at 0
                        new KeyValue(cell.scaleXProperty(), 1),
                        new KeyValue(cell.scaleYProperty(), 1)
                    ),
                        new KeyFrame(new Duration(369), // set end position at 40s
                        new KeyValue(cell.scaleXProperty(), 1.35),
                        new KeyValue(cell.scaleYProperty(), 1.35)
                    ));
                }
                else if(wasHovered ){
                    timeline.stop();
                    timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, // set start position at 0
                        new KeyValue(cell.scaleXProperty(), 1.35),
                        new KeyValue(cell.scaleYProperty(), 1.35)
                    ),
                        new KeyFrame(new Duration(369), // set end position at 40s
                        new KeyValue(cell.scaleXProperty(), 1),
                        new KeyValue(cell.scaleYProperty(), 1)
                    ));
                }
                else if(!isNowHovered) {
                    timeline.stop();
                    timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, // set end position at 40s
                        new KeyValue(cell.scaleXProperty(), 1),
                        new KeyValue(cell.scaleYProperty(), 1)
                    ));
                }
            timeline.play();

            });
            return cell;
        });
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
}
