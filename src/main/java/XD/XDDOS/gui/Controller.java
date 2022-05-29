package XD.XDDOS.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import io.github.palexdev.materialfx.controls.MFXSlider;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable {

    private FileChooser proxyFileChooser = new FileChooser();

    @FXML private AnchorPane mainPane;

    @FXML private Button attackButton;

    @FXML private TextArea consoleArea;
    @FXML private TextField ipField;
    @FXML private Label experimentalWarning;
    @FXML private Label ipPromptLabel;
    @FXML private DialogPane wavesInfoDialog;
    @FXML private ComboBox<String> methodBox;
    @FXML private ComboBox<String> versionBox;
    @FXML private ImageView infoIcon;

    @FXML private MFXSlider cpsSlider;
    @FXML private MFXSlider timeSlider;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        attackButton.hoverProperty().addListener((observableValue, oldValue, newValue) -> {
            hoverZoomAnimation(attackButton, 250, 1.025, newValue);
        });

        infoIcon.hoverProperty().addListener((observableValue, oldValue, newValue) -> {
            FadeTransition ft = new FadeTransition(Duration.millis(250), wavesInfoDialog);
            if(newValue) {
                wavesInfoDialog.setVisible(true);
                ft.setFromValue(0);
                ft.setToValue(0.83);
            }
            else {
                ft.setFromValue(0.83);
                ft.setToValue(0);
                ft.setOnFinished((e) -> {
                    wavesInfoDialog.setVisible(false);
                });
            }
            ft.play();
        });

        ipField.focusedProperty().addListener((observableValue, oldValue, newValue) -> {

            Timeline timeline = new Timeline();
            if(ipField.getText().trim().equalsIgnoreCase("")) {
                if((newValue || !ipField.getText().trim().equalsIgnoreCase(""))) {
                    timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO,
                        new KeyValue(ipPromptLabel.translateXProperty(), 0),
                        new KeyValue(ipPromptLabel.translateYProperty(), 0)
                    ),
                        new KeyFrame(new Duration(269),
                        new KeyValue(ipPromptLabel.translateXProperty(), -190),
                        new KeyValue(ipPromptLabel.translateYProperty(), -12)
                    ));
                }
                else {
                    timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO,
                        new KeyValue(ipPromptLabel.translateXProperty(), -190),
                        new KeyValue(ipPromptLabel.translateYProperty(), -12)
                    ),
                        new KeyFrame(new Duration(369),
                        new KeyValue(ipPromptLabel.translateXProperty(), 0),
                        new KeyValue(ipPromptLabel.translateYProperty(), 0)
                    ));
                }
            
                timeline.play();
                
                hoverZoomAnimation(ipPromptLabel, 269, 0.8, (newValue || !ipField.getText().trim().equalsIgnoreCase("")));
            }
        });


        experimentalWarning.setVisible(false);
        wavesInfoDialog.setVisible(false);

        Utilities.initializeVersions();
        Utilities.listMethods();

        versionBox.getItems().addAll(Utilities.versions);
        methodBox.getItems().addAll(Utilities.methodsList);

        versionBox.setVisibleRowCount(12);
        methodBox.setVisibleRowCount(12);

        cpsSlider.setMax(100);
        cpsSlider.popupPaddingProperty().set(10000);

        timeSlider.setMax(100);
        timeSlider.popupPaddingProperty().set(10000);
        
        
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

    public void chooseProxyFile() {
        File file = proxyFileChooser.showOpenDialog(new Stage());
        file.getAbsolutePath(); // just to remove the warning
    }

    public void hoverZoomAnimation(Node node, int duration, double scale, boolean hovering) {
        
        Timeline timeline = new Timeline();
        if(hovering) {
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,
                new KeyValue(node.scaleXProperty(), 1),
                new KeyValue(node.scaleYProperty(), 1)
            ),
                new KeyFrame(new Duration(duration),
                new KeyValue(node.scaleXProperty(), scale),
                new KeyValue(node.scaleYProperty(), scale)
            ));
        }
        else {
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,
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

    public void focusOnIPField() {
        ipField.requestFocus();
    }

}
