package sample;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.*;

public class DailyToDo extends Parent {

    private Parent dayBar(){

        HBox root = new HBox();
        root.setPrefSize(375,548);

        Pane backBoard = new Pane();
        backBoard.setPrefSize(345,510);
        DayBar dayBar = new DayBar();
        dayBar.setLayoutX(88);
        dayBar.setLayoutY(12);
        Label empty = new Label("There are no events this day"); // Designing
        empty.getStyleClass().add("instructor-label");
        empty.setAlignment(Pos.CENTER);
        ArrayList<EventBar> eventList = new ArrayList<>();// 目前没有Day类的实例 所以就用个暂时的来代替Day里面的eventList
        eventList.add(new EventBar(0.5,"1212","A","Null",Color.rgb(243, 164, 25, 0.5)));
        eventList.add(new EventBar(0.33,"1112","B","Null",Color.rgb(248, 188, 225, 0.5)));
        backBoard.getChildren().addAll(dayBar);
        if(false){
            backBoard.getChildren().add(empty);
        }
        else {
            for(int i = 0; i < eventList.size(); i++){
                EventBar temp = eventList.get(i);
                temp.setLayoutX(24);
                backBoard.getChildren().addAll(temp);
            }
        }
        HBox.setMargin(backBoard,new Insets(15,15,23,15));
        backBoard.getStyleClass().addAll("light-background");


        root.getChildren().addAll(backBoard);
        return root;
    }

    public DailyToDo(String month, String day){
        // Show scene
        VBox back = new VBox();

        BottomBar bottomBar = new BottomBar(month,day,true);
        bottomBar.setLayoutY(547);

        back.getChildren().addAll(dayBar(),bottomBar);

        javafx.scene.text.Font.getFamilies();
        back.getStylesheets().add("sample/DailyToDoStyle.css");
        back.getStyleClass().addAll("background");
        getChildren().addAll(back);
    }

    public static class DayBar extends Parent{

        public DayBar(){
            Pane backGround = new Pane();
            backGround.setPrefSize(6,486);

            Circle topCircle = new Circle(6);
            topCircle.setFill(Color.rgb(167,167,167,1));
            topCircle.setCenterX(3);
            topCircle.setCenterY(3);

            Circle quarterCircle = new Circle(6);
            quarterCircle.setFill(Color.rgb(167,167,167,1));
            quarterCircle.setCenterX(3);
            quarterCircle.setCenterY(123);

            Circle midCircle = new Circle(6);
            midCircle.setFill(Color.rgb(167,167,167,1));
            midCircle.setCenterX(3);
            midCircle.setCenterY(243);

            Circle thirdQuarterCircle = new Circle(6);
            thirdQuarterCircle.setFill(Color.rgb(167,167,167,1));
            thirdQuarterCircle.setCenterX(3);
            thirdQuarterCircle.setCenterY(363);

            Circle botCircle = new Circle(6);
            botCircle.setFill(Color.rgb(167,167,167,1));
            botCircle.setCenterX(3);
            botCircle.setCenterY(483);

            Rectangle rect = new Rectangle(4,480);
            rect.setFill(Color.rgb(167,167,167,1));
            rect.setLayoutX(1);
            rect.setLayoutY(3);

            backGround.getChildren().addAll(rect,topCircle,quarterCircle,midCircle,thirdQuarterCircle,botCircle);
            getChildren().addAll(backGround);
        }
    }

    public static class EventBar extends Parent{

        public EventBar(double fraction, String time, String group, String name, Color color){
            Pane backPane = new Pane();
            backPane.setPrefSize(302,480);

            Pane backBar = new Pane();
            backBar.setPrefSize(302,20);

            Pane timeBackground = new Pane();
            timeBackground.setPrefSize(72,20);
            Rectangle timeRectangle = new Rectangle(52,20);
            timeRectangle.setFill(Color.rgb(196, 196, 196, 1));
            timeRectangle.setArcHeight(10);
            timeRectangle.setArcWidth(10);
            Label timeLabel = new Label(time);
            timeLabel.setAlignment(Pos.CENTER);
            timeLabel.setPrefSize(50,13);
            timeLabel.getStyleClass().add("time-name-label");
            Rectangle connectionLine = new Rectangle(15,4);
            connectionLine.setLayoutX(52);
            connectionLine.setLayoutY(8);
            connectionLine.setFill(Color.rgb(167, 167, 167, 1));
            Circle locationCircle = new Circle(5);
            locationCircle.setCenterX(67);
            locationCircle.setCenterY(10);
            locationCircle.setFill(Color.rgb(167, 167, 167, 1));
            timeBackground.getChildren().addAll(timeRectangle,timeLabel,connectionLine,locationCircle);

            Pane groupBackground = new Pane();
            groupBackground.setPrefSize(20,20);
            Circle groupCircle = new Circle(10);
            groupCircle.setFill(color);
            groupCircle.setCenterX(10);
            groupCircle.setCenterY(10);
            Label groupLabel = new Label(group);
            groupLabel.setPrefSize(16,16);
            groupLabel.getStyleClass().add("group-label");
            groupLabel.setLayoutY(2);
            groupLabel.setLayoutX(2);
            groupBackground.getChildren().addAll(groupCircle,groupLabel);
            groupBackground.setLayoutX(83);

            Pane nameBackground = new Pane();
            nameBackground.setPrefSize(191,20);
            Rectangle nameRectangle = new Rectangle(191,20);
            nameRectangle.setArcHeight(10);
            nameRectangle.setArcWidth(10);
            nameRectangle.setFill(Color.rgb(196,196,196,0.3));
            Label nameLabel = new Label(name);
            nameLabel.getStyleClass().addAll("time-name-label");
            nameLabel.setLayoutX(12);
            nameBackground.getChildren().addAll(nameRectangle,nameLabel);
            nameBackground.setLayoutX(111);

            backBar.getChildren().addAll(timeBackground,groupBackground,nameBackground);
            backBar.setLayoutY(480*fraction);
            backPane.getChildren().addAll(backBar);
            getChildren().addAll(backPane);
        }

    }
}
