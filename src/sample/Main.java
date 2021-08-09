package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class Main extends Application {
    private static Stage guiStage;

    public static Stage getStage() {
        return guiStage;
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Hello World");
        Parent root = new MonthBlock("June","23");
        guiStage = primaryStage;
        Scene scene = new Scene(root,375 , 667);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
//        File userDataFile = new File(".\\out\\data\\UserData.txt");
//        OutputStream output = new FileOutputStream(userDataFile);
//        if(!userDataFile.getParentFile().exists()){ //如果文件的目录不存在
//            userDataFile.getParentFile().mkdirs(); //创建目录
//            Calendar initDay = Calendar.getInstance();
//            initDay.set(2021, 6, 1, 0, 0, 0);
//            for (int i = 0; i < 3652; i++) {
//                initDay.add(Calendar.DATE, 1);
//                String msg = "date: " + initDay + " eventList: \n\n";
//                byte data[] = msg.getBytes();
//                output.write(data);
//            }
//            output.close();
//        }

//        File groupDataFile = new File(".\\out\\data\\GroupData.txt");
//        OutputStream groupDataOutput = new FileOutputStream(groupDataFile);
//        if(!groupDataFile.getParentFile().exists()){ //如果文件的目录不存在
//            groupDataFile.getParentFile().mkdirs(); //创建目录
//            groupDataOutput.close();
//        }

        launch(args);
    }
}
