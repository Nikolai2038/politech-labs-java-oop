package coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainWindowController {
    @FXML
    private Label text;

    public void changeText(ActionEvent actionEvent) {
        text.setText("New text");
    }
}
