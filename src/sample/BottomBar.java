package sample;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class BottomBar extends Parent {

    public BottomBar(String month, String day, Boolean visibility){
        Pane botBarBack = new Pane();
        botBarBack.setPrefSize(375,120);

        Pane lightPanel = new Pane();
        lightPanel.setPrefSize(345,100);
        lightPanel.setLayoutX(15);
        lightPanel.getStyleClass().add("light-background");

        Label dayLabel = new Label(day);
        dayLabel.getStyleClass().addAll("day-label");
        dayLabel.setPrefSize(60,60);
        dayLabel.setAlignment(Pos.CENTER);
        dayLabel.setLayoutX(12);
        dayLabel.setLayoutY(13);

        Label monthLabel = new Label(month);
        monthLabel.getStyleClass().addAll("month-label");
        monthLabel.setPrefSize(60,20);
        monthLabel.setAlignment(Pos.CENTER);
        monthLabel.setLayoutX(12);
        monthLabel.setLayoutY(66);

        Line separationLine = new Line();
        separationLine.setStartX(87);
        separationLine.setStartY(10);
        separationLine.setEndX(87);
        separationLine.setEndY(90);
        separationLine.setStrokeWidth(2);
        separationLine.setStroke(Color.rgb(167, 167, 167, 1));

        CircleButton addButton = new CircleButton(new Image("img/AddButton.png"));
        addButton.setLayoutX(236);
        addButton.setLayoutY(50);

        addButton.setOnMouseClicked(event -> {
            if(visibility){
                Scene newScene = new Scene(new CreateEvent(2),375,667);// ... commands which define the new scene.
                Main.getStage().setScene(newScene);
            }
            else{
                Scene newScene = new Scene(new CreateEvent(1),375,667);// ... commands which define the new scene.
                Main.getStage().setScene(newScene);
            }

        });

        CircleButton backButton = new CircleButton(new Image("img/BackButton.png"));
        CircleButton add_groupButton = new CircleButton(new Image("img/add_group.png"));
        backButton.setLayoutX(301);
        backButton.setLayoutY(50);
        add_groupButton.setLayoutX(301);
        add_groupButton.setLayoutY(50);

        backButton.setOnMouseClicked(event -> {
            Scene newScene = new Scene(new MonthBlock("July","29"),375,667);// ... commands which define the new scene.
            newScene.getStylesheets().addAll("sample/MonthCalendarStyle.css");
            Main.getStage().setScene(newScene);
        });

        add_groupButton.setOnMouseClicked(e->{
            Scene newScene = new Scene(new CreateGroup(true),375,667);// ... commands which define the new scene.
            newScene.getStylesheets().addAll("sample/MonthCalendarStyle.css");
            Main.getStage().setScene(newScene);
        });

        LeftRightButton leftRightButton = new LeftRightButton();
        leftRightButton.setLayoutX(102);
        leftRightButton.setLayoutY(25);

        if(visibility){
            lightPanel.getChildren().addAll(dayLabel,monthLabel,separationLine,leftRightButton,addButton,backButton);
        }else{
            lightPanel.getChildren().addAll(dayLabel,monthLabel,separationLine,leftRightButton,addButton,add_groupButton);
        }

        botBarBack.getStylesheets().addAll("sample/BottomBarStyle.css");
        botBarBack.getChildren().addAll(lightPanel);

        getChildren().addAll(botBarBack);
    }

}
