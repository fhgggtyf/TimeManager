package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class LeftRightButton extends Parent{

        private BooleanProperty leftSwitchedOn = new SimpleBooleanProperty(false);
        public  BooleanProperty leftSwitchedOnProperty(){
            return leftSwitchedOn;
        } // 连接后端

        private BooleanProperty rightSwitchedOn = new SimpleBooleanProperty(false);
        public  BooleanProperty rightSwitchedOnProperty(){
            return rightSwitchedOn;
        } // 连接后端



        // 这里做了一个 可以由声明改变参数的ToggleSwitch 其实没有必要 毕竟只需要一个 但我就是做了
        public LeftRightButton(String month, String day){
            String[] months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
            //找到当月月数（Jan-0）
            int monthNum=0;
            for(int i=0;i<months.length;i++){
                if(months[i].equals(month)){
                    monthNum=i;
                }
            }
            int[] daysForMonths={31,28,31,30,31,30,31,31,30,31,30,31};
            int daysInThisMonth=daysForMonths[monthNum];

            Rectangle background = new Rectangle(90,50);
            background.setFill(new ImagePattern(new Image("img/LeftRightButton.png")));
            background.setStroke(Color.TRANSPARENT);
            background.setArcWidth(50);
            background.setArcHeight(50);
            int dayPassed=Integer.parseInt(day);

            Rectangle leftButton = new Rectangle(45,50);
            leftButton.setLayoutX(0);
            leftButton.setFill(Color.TRANSPARENT);
            leftButton.setOnMouseClicked(e -> {
                if(dayPassed-1>=1){
                    Scene newScene = new Scene(new DailyToDo(month,dayPassed-1+""),375,667);
                    newScene.getStylesheets().addAll("sample/MonthCalendarStyle.css");
                    Main.getStage().setScene(newScene);
                }
            });

            Rectangle rightButton = new Rectangle(45,50);
            rightButton.setLayoutX(45);
            rightButton.setFill(Color.TRANSPARENT);
            rightButton.setOnMouseClicked(e -> {
                if(dayPassed+1<=daysInThisMonth){
                    Scene newScene = new Scene(new DailyToDo(month,dayPassed+1+""),375,667);
                    newScene.getStylesheets().addAll("sample/MonthCalendarStyle.css");
                    Main.getStage().setScene(newScene);
                }
            });

            getChildren().addAll(background,leftButton,rightButton);
        }
}
