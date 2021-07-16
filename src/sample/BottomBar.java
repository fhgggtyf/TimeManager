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

        CircleButton addButton = new CircleButton(new Image("img/AddButton.png"),new Image("img/AddButton.png"));
        addButton.setLayoutX(236);
        addButton.setLayoutY(50);

        CircleButton backButton = new CircleButton(new Image("img/BackButton.png"),new Image("img/BackButton.png"));
        backButton.setLayoutX(301);
        backButton.setLayoutY(50);
        backButton.setManaged(visibility);
        backButton.setVisible(visibility);


        LeftRightButton leftRightButton = new LeftRightButton();
        leftRightButton.setLayoutX(102);
        leftRightButton.setLayoutY(25);

        lightPanel.getChildren().addAll(dayLabel,monthLabel,separationLine,leftRightButton,addButton,backButton);

        botBarBack.getStylesheets().addAll("sample/BottomBarStyle.css");
        botBarBack.getChildren().addAll(lightPanel);

        getChildren().addAll(botBarBack);
    }

}
