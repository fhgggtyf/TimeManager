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

import java.util.ArrayList;

public class GroupManagement extends Parent{
    public GroupManagement(){
        HBox topMenu = new HBox();
        topMenu.setPrefSize(375,97);
        topMenu.setAlignment(Pos.CENTER_LEFT);
        topMenu.setPadding(new Insets(28,23,23,15));
        CircleButton arrow = new CircleButton(new Image("img/arrow.PNG"));
        Pane upSpace1 = new Pane();
        upSpace1.setPrefSize(21,51);
        CircleButton spaceHolder = new CircleButton(new Image("img/folder.PNG"));
        spaceHolder.setVisible(false);
        Pane upSpace2 = new Pane();
        upSpace2.setPrefSize(161,97);

        BooleanProperty trash = new SimpleBooleanProperty(true);
        CircleButton trashBin = new CircleButton(new Image("img/trashBin.PNG"));

        topMenu.getChildren().addAll(arrow,upSpace1,spaceHolder,upSpace2,trashBin);

        VBox centerBack = new VBox();
        centerBack.setPrefSize(344,543);
        centerBack.setPadding(new Insets(10));
        centerBack.setSpacing(9);
        centerBack.getStyleClass().add("light-background");
        //这里之后要用eventList代替
        ArrayList<GroupSquare> groupSquareArrayList = new ArrayList<GroupSquare>();
        GroupSquare group1 = new GroupSquare("A","blue");
        GroupSquare group2 = new GroupSquare("A","blue");
        GroupSquare group3 = new GroupSquare("B","yellow");
        groupSquareArrayList.add(group1);
        groupSquareArrayList.add(group2);
        groupSquareArrayList.add(group3);
        for(int i = 0; i < groupSquareArrayList.size(); i++){
            centerBack.getChildren().addAll(groupSquareArrayList.get(i));
        }

        HBox centerAll = new HBox();
        centerAll.setAlignment(Pos.CENTER);
        centerAll.setPrefSize(375,543);

        trashBin.setOnMouseClicked(e ->{
            trash.set(!trash.get());
        });

        centerAll.getChildren().add(centerBack);

        Pane placeholder = new Pane();
        placeholder.setPrefSize(375,27);

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(375,667);
        borderPane.setTop(topMenu);
        borderPane.setCenter(centerAll);
        borderPane.setBottom(placeholder);
        borderPane.getStylesheets().add("sample/GroupManagementStyle.css");
        borderPane.getStyleClass().add("dark-background");
        Font.getFamilies();
        getChildren().add(borderPane);
    }

    public static class GroupSquare extends Parent {

        public String tag;
        public String color;

        public GroupSquare(String tag, String color) {
            this.tag = tag;
            this.color = color;

            refreshDisplay();
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void refreshDisplay(){
            Rectangle groupRectangle = new Rectangle(325,63);
            groupRectangle.setArcHeight(10);
            groupRectangle.setArcWidth(10);
            if(color.equals("blue")) {
                groupRectangle.setFill(Color.rgb(94, 137, 162, 0.3));
            }else if(color.equals("yellow")){
                groupRectangle.setFill(Color.rgb(243,164,25,0.3));
            }

            Label tag = new Label(this.tag);
            tag.getStyleClass().addAll("tag-label");
            tag.setLayoutY(8);
            tag.setLayoutX(19);
            Rectangle tagRectangle = new Rectangle(63,63);
            tagRectangle.setArcHeight(10);
            tagRectangle.setArcWidth(10);
            if(color.equals("blue")) {
                tagRectangle.setFill(Color.rgb(94, 137, 162, 0.5));
            }else if(color.equals("yellow")){
                tagRectangle.setFill(Color.rgb(243,164,25,0.5));
            }

            Pane back = new Pane();
            back.setPrefSize(325,63);
            back.getChildren().addAll(groupRectangle,tagRectangle,tag);

            getChildren().addAll(back);
        }
    }
}

