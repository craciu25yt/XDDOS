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
import javafx.scene.Node;
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

    

    @FXML private TextArea consoleArea;
    @FXML private TextField ipField;
    @FXML private TextField portField;
    @FXML private Label experimentalWarning;
    @FXML private ComboBox<String> methodBox;
    @FXML private ComboBox<String> versionBox;

    private double comboBoxWidth;
    private double comboBoxHeight;

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxWidth = methodBox.getWidth(); // DEFAULT 270
        comboBoxHeight = methodBox.getHeight(); // DEFAULT 35

        experimentalWarning.setVisible(false);

        Utilities.initializeVersions();
        Utilities.listMethods();

        versionBox.getItems().addAll(Utilities.versions);
        methodBox.getItems().addAll(Utilities.methodsList);

        versionBox.setVisibleRowCount(12);
        methodBox.setVisibleRowCount(12);

        versionBox.setCellFactory(lv -> { // makes components from combobox items
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };
            cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> { // checks if it is hovered
                hoverZoomAnimation(cell, 369, 1.35, isNowHovered);
            });
            return cell;
        });

        methodBox.setCellFactory(lv -> { // makes components from combobox items
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };
            cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> { // checks if it is hovered
                hoverZoomAnimation(cell, 369, 1.35, isNowHovered);
            });
            return cell;
        });
    }

    public void hoverZoomAnimation(Node node, int duration, double scale, boolean hovering) {
        
        Timeline timeline = new Timeline();
        if(hovering) {
            timeline.stop();
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, // set start position at 0
                new KeyValue(node.scaleXProperty(), 1),
                new KeyValue(node.scaleYProperty(), 1)
            ),
                new KeyFrame(new Duration(duration),
                new KeyValue(node.scaleXProperty(), scale),
                new KeyValue(node.scaleYProperty(), scale)
            ));
        }
        else {
            timeline.stop();
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, // set start position at 0
                new KeyValue(node.scaleXProperty(), scale),
                new KeyValue(node.scaleYProperty(), scale)
            ),
                new KeyFrame(new Duration(duration),
                new KeyValue(node.scaleXProperty(), 1),
                new KeyValue(node.scaleYProperty(), 1)
            ));
        }
    timeline.play();

    }

    public void chooseProxyFile() {
        File file = proxyFileChooser.showOpenDialog(new Stage());
    }

    
}


                // else {
                //     timeline.stop();
                //     timeline.getKeyFrames().addAll(
                //         new KeyFrame(Duration.ZERO, // set end position at 40s
                //         new KeyValue(cell.scaleXProperty(), 1),
                //         new KeyValue(cell.scaleYProperty(), 1)
                //     ));
                // }
