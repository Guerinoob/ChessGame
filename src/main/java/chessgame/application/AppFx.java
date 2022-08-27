package chessgame.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class AppFx extends Application {

    private static Scene scene;
    
    public static void start(final String[] args) {
		Application.launch(args);
	}

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("game"), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppFx.class.getClassLoader().getResource("fxml/"+fxml + ".fxml"));
        fxmlLoader.getController();
        return fxmlLoader.load();
    }

}