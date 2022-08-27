package chessgame.controller;

import java.io.IOException;

import chessgame.application.AppFx;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        AppFx.setRoot("primary");
    }
}