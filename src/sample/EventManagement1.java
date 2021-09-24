package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class EventManagement1 extends Parent {
    public EventManagement1() throws IOException{
        HBox topMenu = new HBox();
        topMenu.setPrefSize(375,97);
        topMenu.setAlignment(Pos.CENTER_LEFT);
        topMenu.setPadding(new Insets(28,23,23,15));
        CircleButton arrow = new CircleButton(new Image("img/arrow.png"));
        arrow.setOnMouseClicked(e->{
            Scene newScene = null;
            try {
                newScene = new Scene(new MonthBlock("Feb","6"),375,667);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Main.getStage().setScene(newScene);
        });
        Pane upSpace1 = new Pane();
        upSpace1.setPrefSize(21,51);
        CircleButton folder = new CircleButton(new Image("img/folder.png"));
        folder.setOnMouseClicked(e->{
            Scene newScene = null;
            try {
                newScene = new Scene(new GroupManagement1(),375,667);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Main.getStage().setScene(newScene);
        });
        Pane upSpace2 = new Pane();
        upSpace2.setPrefSize(161,97);
        CircleButton trashBin = new CircleButton(new Image("img/trashBin.png"));
        trashBin.setOnMouseClicked(e->{
            Scene newScene = null;
            try {
                newScene = new Scene(new EventManagement2(),375,667);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Main.getStage().setScene(newScene);
        });

        topMenu.getChildren().addAll(arrow,upSpace1,folder,upSpace2,trashBin);

        VBox centerBack = new VBox();
        centerBack.setPrefSize(314,403);
        centerBack.setSpacing(9);
        //这里之后要用eventList代替
        ArrayList<EventSquare> eventSquareArrayList = new ArrayList<>();
        File file = new File(".\\out\\data\\EventData.txt");
        InputStreamReader read = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt;
        while ((lineTxt = bufferedReader.readLine()) != null){
            String str = lineTxt;
            String[] dictionary = str.split(";");

            String color = null;
            File file2 = new File(".\\out\\data\\GroupData.txt");
            InputStreamReader read2 = new InputStreamReader(
                    new FileInputStream(file2));//考虑到编码格式
            BufferedReader bufferedReader2 = new BufferedReader(read2);
            String lineTxt2;
            while((lineTxt2 = bufferedReader2.readLine()) != null){
                String str2=lineTxt2;
                String[] dictionary2 =  str2.split(" ");
                if(dictionary2[0].equals(dictionary[5])){
                    color = dictionary2[1];
                }
            }
            read2.close();

            Calendar startTime = Calendar.getInstance();
            startTime.setTime(new Date(Long.parseLong(dictionary[2])));
            Calendar endTime = Calendar.getInstance();
            endTime.setTime(new Date(Long.parseLong(dictionary[3])));
            EventSquare event = new EventSquare(dictionary[0],startTime,endTime,dictionary[1],color);
            eventSquareArrayList.add(event);
        }
        read.close();
        for(int i = 0; i < eventSquareArrayList.size(); i++){
            centerBack.getChildren().addAll(eventSquareArrayList.get(i));
        }

        ScrollPane centerBackWithScroll = new ScrollPane();
        centerBackWithScroll.setContent(centerBack);
        centerBackWithScroll.setPrefSize(314,403);
        centerBackWithScroll.getStyleClass().addAll("scroll-null-background",
                "scroll-bar:vertical ",
                "scroll-bar:vertical .increment-button,  .scroll-bar:vertical .decrement-button",
                "scroll-bar .increment-arrow, .scroll-bar .decrement-arrow",
                "scroll-bar:vertical .thumb");
        centerBackWithScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        centerBackWithScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        VBox centerBackAdd = new VBox();
        centerBackAdd.setPrefSize(344,433);
        centerBackAdd.setPadding(new Insets(15));
        centerBackAdd.getChildren().add(centerBackWithScroll);
        centerBackAdd.getStyleClass().add("light-background");

        HBox centerAll = new HBox();
        centerAll.setAlignment(Pos.CENTER);
        centerAll.setPrefSize(375,433);
        centerAll.getChildren().add(centerBackAdd);

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
        public Calendar startTime;
        public Calendar endTime;
        public String note;
        public String color;

        public EventSquare(String name, Calendar startTime, Calendar endTime, String note, String color) {
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

        public Calendar getStartTime() {
            return startTime;
        }

        public void setStartTime(Calendar startTime) {
            this.startTime = startTime;
        }

        public Calendar getEndTime() {
            return endTime;
        }

        public void setEndTime(Calendar endTime) {
            this.endTime = endTime;
        }

        public String getNote() { return note; }

        public void setNote(String note) {
            this.note = note;
        }

        public String getColor() { return color; }

        public void setColor(String color) { this.color = color; }

        public String isOneDigit(String time){
            if (time.length() == 1){
                time = "0" + time;
            }
            return time;
        }

        public void Display(){
            Label eventName = new Label(this.name);
            eventName.getStyleClass().add("name-label");
            eventName.setPrefSize(120,20);

            Rectangle eventNameRec = new Rectangle(120,20);
            eventNameRec.setArcHeight(10);
            eventNameRec.setArcWidth(10);
            eventNameRec.setFill(Color.web(color,0.5));

            Pane eventNameBack = new Pane();
            eventNameBack.setPrefSize(120,20);
            eventNameBack.getChildren().addAll(eventNameRec,eventName);

            String tempStartTime;
            String startTimeHour;
            String startTimeMinute;
            startTimeHour = String.valueOf(startTime.get(Calendar.HOUR_OF_DAY));
            startTimeMinute = String.valueOf(startTime.get(Calendar.MINUTE));
            startTimeHour = isOneDigit(startTimeHour);
            startTimeMinute = isOneDigit(startTimeMinute);
            tempStartTime = startTimeHour + ":" +startTimeMinute;
            String tempEndTime;
            String endTimeHour;
            String endTimeMinute;
            endTimeHour = String.valueOf(endTime.get(Calendar.HOUR_OF_DAY));
            endTimeMinute = String.valueOf(endTime.get(Calendar.MINUTE));
            endTimeHour = isOneDigit(endTimeHour);
            endTimeMinute = isOneDigit(endTimeMinute);
            tempEndTime = endTimeHour+":"+endTimeMinute;
            Label eventTime = new Label(tempStartTime+" - "+tempEndTime);
            eventTime.getStyleClass().add("time-label");

            Pane eventTimeBack = new Pane();
            eventNameBack.setPrefSize(125,13);
            eventTimeBack.getChildren().add(eventTime);

            VBox eventSquareLeft = new VBox();
            eventSquareLeft.setPadding(new Insets(5,0,0,0));
            eventSquareLeft.setSpacing(9);
            eventSquareLeft.getChildren().addAll(eventNameBack,eventTimeBack);

            Rectangle separationLine = new Rectangle(2,50);
            separationLine.setFill(Color.rgb(167,167,167,1));

            Label description = new Label(this.note);
            description.setPrefSize(120,50);
            if(note.equals("No description")){
                description.getStyleClass().add("descriptionNull-label");
            }else{
                description.getStyleClass().add("descriptionActivated-label");
            }

            HBox backSquareContainer = new HBox();
            backSquareContainer.setPrefSize(265,50);
            backSquareContainer.setSpacing(12.5);
            backSquareContainer.setLayoutX(13);
            backSquareContainer.setLayoutY(7);
            backSquareContainer.getChildren().addAll(eventSquareLeft,separationLine,description);

            Rectangle backSquareBackground = new Rectangle(290,63,Color.rgb(196,196,196,0.3));
            backSquareBackground.setArcWidth(10);
            backSquareBackground.setArcHeight(10);

            getChildren().addAll(backSquareContainer,backSquareBackground);
        }
    }
}
