package coursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Класс Stage зависит от платформы, на котором запускается приложение
    @Override
    public void start(Stage stage) throws IOException {
        // Устанавливаем размеры окна
        stage.setWidth(300);
        stage.setHeight(300);

        // Устанавливаем сцену с FXML-разметкой
        URL url = new File("src/main/java/coursework/Scene.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
        stage.setScene(scene);

        // Устанавливаем название окна
        stage.setTitle("FXML Example");

        // Показываем окно
        stage.show();
    }
}
