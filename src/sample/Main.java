package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        Pane background = new Pane();
        background.getChildren().addAll(new CreateEvent());
        primaryStage.setScene(new Scene(background,375 , 667));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
