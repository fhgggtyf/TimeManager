package sample;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class BottomBarWithScroll extends Parent {

    public BottomBarWithScroll(String month, String day){
        Pane botBarBack = new Pane();
        botBarBack.setPrefSize(344,100);

        Pane lightPanel = new Pane();
        lightPanel.setPrefSize(345,100);
        lightPanel.setLayoutX(0);
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

        Pane scr = new Pane();
        scr.setPrefSize(226,150);
        Circle group = new Circle(10);
        group.setLayoutX(21);
        group.setLayoutY(12);
        group.setFill(Color.rgb(243,164,19,0.3));
        Label groupA = new Label("A");
        groupA.getStyleClass().addAll("event-name-label");
        groupA.setLayoutX(13);
        groupA.setLayoutY(2);
        groupA.setPrefSize(16,16);
        groupA.setAlignment(Pos.CENTER);
        Rectangle eventARec = new Rectangle(166,20);
        eventARec.setArcHeight(25);
        eventARec.setArcWidth(25);
        eventARec.setFill(Color.rgb(196,196,196,0.3));
        eventARec.setLayoutX(39);
        eventARec.setLayoutY(2);
        Label eventA = new Label("Event A");
        eventA.getStyleClass().addAll("event-name-label");
        eventA.setPrefSize(166,20);
        eventA.setAlignment(Pos.CENTER);
        eventA.setLayoutX(39);
        eventA.setLayoutY(2);

        scr.getChildren().addAll(group,groupA,eventARec,eventA);
        scr.getStyleClass().addAll("null-background");

        ScrollPane scroll = new ScrollPane();
        scroll.setContent(scr);
        scroll.setLayoutX(88);
        scroll.setPrefSize(256,75);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.getStyleClass().addAll("scroll-null-background",
                "scroll-bar:vertical ",
                "scroll-bar:vertical .increment-button,  .scroll-bar:vertical .decrement-button",
                "scroll-bar .increment-arrow, .scroll-bar .decrement-arrow",
                "scroll-bar:vertical .thumb");
        scroll.setLayoutY(12.5);

        lightPanel.getChildren().addAll(dayLabel,monthLabel,separationLine,scroll);

        botBarBack.getStylesheets().addAll("sample/BottomBarStyle.css");
        botBarBack.getChildren().addAll(lightPanel);

        getChildren().addAll(botBarBack);
    }
}
