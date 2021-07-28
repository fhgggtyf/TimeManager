package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventManagement extends Parent {
    public EventManagement(){
        HBox topMenu = new HBox();
        topMenu.setPrefSize(375,97);
        topMenu.setAlignment(Pos.CENTER_LEFT);
        topMenu.setPadding(new Insets(28,23,23,15));
        CircleButton arrow = new CircleButton(new Image("img/arrow.PNG"));
        Pane upSpace1 = new Pane();
        upSpace1.setPrefSize(21,51);
        CircleButton folder = new CircleButton(new Image("img/folder.PNG"));
        Pane upSpace2 = new Pane();
        upSpace2.setPrefSize(161,97);
        CircleButton trashBin = new CircleButton(new Image("img/trashBin.PNG"));

        topMenu.getChildren().addAll(arrow,upSpace1,folder,upSpace2,trashBin);

        VBox centerBack = new VBox();
        centerBack.setPrefSize(344,433);
        centerBack.setPadding(new Insets(10));
        centerBack.setSpacing(9);
        centerBack.getStyleClass().add("light-background");
        //这里之后要用eventList代替
        ArrayList<EventSquare> eventSquareArrayList = new ArrayList<EventSquare>();
        EventSquare event1 = new EventSquare("TOK","03:40","06:40","note","blue");
        EventSquare event2 = new EventSquare("Econ","08:52","11:52","","blue");
        EventSquare event3 = new EventSquare("Do Chores","16:09","17:28","","yellow");
        eventSquareArrayList.add(event1);
        eventSquareArrayList.add(event2);
        eventSquareArrayList.add(event3);
        for(int i = 0; i < eventSquareArrayList.size(); i++){
            centerBack.getChildren().addAll(eventSquareArrayList.get(i));
        }

        HBox centerAll = new HBox();
        centerAll.setAlignment(Pos.CENTER);
        centerAll.setPrefSize(375,433);

        centerAll.getChildren().add(centerBack);

        BottomBar bottomBar = new BottomBar("Feb","6",false);
        bottomBar.setLayoutY(18);
        Pane bottomAll = new Pane();
        bottomAll.setPrefSize(375,137);
        bottomAll.getChildren().addAll(bottomBar);

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(375,667);
        borderPane.setTop(topMenu);
        borderPane.setCenter(centerAll);
        borderPane.setBottom(bottomAll);
        borderPane.getStylesheets().add("sample/EventManagementStyle.css");
        borderPane.getStyleClass().add("dark-background");
        Font.getFamilies();
        getChildren().add(borderPane);
    }

    public static class EventSquare extends Parent{

        public String name;
        public String startTime;
        public String endTime;
        public String note;
        public String color;

        public EventSquare(String name, String startTime, String endTime, String note, String color) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
            this.note = note;
            this.color = color;
            Display();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void Display(){
            Label eventName = new Label(name);
            eventName.getStyleClass().add("name-label");
            eventName.setPrefSize(120,20);

            Rectangle eventNameRec = new Rectangle(120,20);
            eventNameRec.setArcHeight(10);
            eventNameRec.setArcWidth(10);
            if(color.equals("blue")) {
                eventNameRec.setFill(Color.rgb(94, 137, 162, 0.5));
            }else if(color.equals("yellow")){
                eventNameRec.setFill(Color.rgb(243,164,25,0.5));
            }

            Pane eventNameBack = new Pane();
            eventNameBack.setPrefSize(120,20);
            eventNameBack.getChildren().addAll(eventNameRec,eventName);

            Label eventTime = new Label(startTime+" - "+endTime);
            eventTime.getStyleClass().add("time-label");

            Pane eventTimeBack = new Pane();
            eventNameBack.setPrefSize(125,13);
            eventTimeBack.getChildren().add(eventTime);

            VBox eventSquareLeft = new VBox();
            eventSquareLeft.setSpacing(9);
            eventSquareLeft.setAlignment(Pos.CENTER);
            eventSquareLeft.getChildren().addAll(eventNameBack,eventTimeBack);

            Rectangle separationLine = new Rectangle(2,50);
            separationLine.setFill(Color.rgb(167,167,167,1));

            Boolean noteStatus = Boolean.TRUE;
            if(note.equals("")){
                note = "No description";
                noteStatus = Boolean.FALSE;
            }
            Label description = new Label(note);
            description.setPrefSize(150,50);
            if(noteStatus){
                description.getStyleClass().add("descriptionActivated-label");
            }else{
                description.getStyleClass().add("descriptionNull-label");
            }

            Pane middleSpace = new Pane();
            middleSpace.setPrefSize(111,35);

            Rectangle cancelImage = new Rectangle(20.42,20.42);
            cancelImage.setFill(new ImagePattern(new Image("img/cancel.PNG")));
            HBox cancelButton = new HBox();
            cancelButton.setPrefSize(35,35);
            cancelButton.setAlignment(Pos.CENTER);
            cancelButton.getChildren().add(cancelImage);

            HBox backSquareContainer = new HBox();
            backSquareContainer.setPrefSize(306,50);
            backSquareContainer.setSpacing(12.5);
            backSquareContainer.setLayoutX(13);
            backSquareContainer.setLayoutY(7);
            backSquareContainer.getChildren().addAll(eventSquareLeft,separationLine,description);


            Rectangle backSquareBackground = new Rectangle(325,63,Color.rgb(196,196,196,0.3));
            backSquareBackground.setArcWidth(10);
            backSquareBackground.setArcHeight(10);

            getChildren().addAll(backSquareContainer,backSquareBackground);
        }
    }
}
