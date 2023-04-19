package mdigius.uno;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class UnoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UnoApplication.class.getResource("Uno-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Uno!");
        stage.getIcons().add(new Image("file:src/main/resources/mdigius/uno/imgs/icons/UnoIcon.jpg"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        UnoDeck deck = new UnoDeck();
    }

    public static void main(String[] args) {
        launch();
    }
}