package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Hello World");
        Pane background = new Pane();
        background.getChildren().addAll(new EventManagement());
//        background.getStylesheets().addAll("sample/MonthCalendarStyle.css");
        primaryStage.setScene(new Scene(background,375 , 667));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        File file = new File(".\\out\\data\\out.out");
        OutputStream output = new FileOutputStream(file);
        if(!file.getParentFile().exists()){ //如果文件的目录不存在
            file.getParentFile().mkdirs(); //创建目录
        }

        Calendar initDay = Calendar.getInstance();
        initDay.set(2021, 6, 1, 0, 0, 0);
        for (int i = 0; i < 3652; i++) {
            initDay.add(Calendar.DATE, 1);
            String msg = "date: " + initDay + ";\teventList: \n\n";
            byte data[] = msg.getBytes();
            output.write(data);
        }
        output.close();
        launch(args);
    }
}
