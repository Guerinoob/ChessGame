package chessgame.chessgame;

import java.io.IOException;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        AppFx.setRoot("secondary");
    }
}
