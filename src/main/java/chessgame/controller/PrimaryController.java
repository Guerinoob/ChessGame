package chessgame.controller;

import java.io.IOException;

import chessgame.application.AppFx;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        AppFx.setRoot("secondary");
    }
}
