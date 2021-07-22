package sample;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class BottomBarWithScroll extends Parent {
    public BottomBarWithScroll(String month, String day){
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

        lightPanel.getChildren().addAll(dayLabel,monthLabel,separationLine);

        botBarBack.getStylesheets().addAll("sample/BottomBarStyle.css");
        botBarBack.getChildren().addAll(lightPanel);

        getChildren().addAll(botBarBack);
    }
}
