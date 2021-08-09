package sample;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.*;

public class CreateGroup extends Parent{

    String tempName;
    Paint colorSelected;

    public CreateGroup(Boolean calendarOrEvent){
        CircleButton arrow = new CircleButton(new Image("img/arrow.png"));
        CircleButton confirm = new CircleButton(new Image("img/confirm.png"));
        arrow.setOnMouseClicked(e->{
            Scene newScene;
            if(calendarOrEvent){
                newScene = new Scene(new EventManagement1(), 375, 667);
            }
            else{
                newScene = new Scene(new MonthBlock("Feb", "6"), 375, 667);
            }
            Main.getStage().setScene(newScene);
        });

        HBox topAll = new HBox();
        topAll.setPrefSize(375,105);
        topAll.setPadding(new Insets(28,17,26,17));
        topAll.setSpacing(22);
        topAll.getChildren().addAll(arrow,confirm);

        Label name = new Label("Name");
        name.getStyleClass().add("title-label");
        name.setPrefSize(58,27);

        TextField nameTextField = new TextField();
        nameTextField.setPrefSize(257,27);
        nameTextField.setTextFormatter(new TextFormatter<String>(change ->
            change.getControlNewText().length() <= 20 ? change : null));
        nameTextField.setPromptText("(20 words maximum)");
        nameTextField.getStyleClass().add("text-field");

        HBox nameAll = new HBox();
        nameAll.setPrefSize(323,27);
        nameAll.setSpacing(18);
        nameAll.getChildren().addAll(name,nameTextField);
        nameAll.setPadding(new Insets(0,0,0,0));

        Label color = new Label("Color");
        color.getStyleClass().add("title-label");

        VBox colorPlate = new VBox();
        colorPlate.setSpacing(10);
        colorPlate.setPrefSize(156,140);
        colorPlate.setPadding(new Insets(6,0,0,0));
        ColorSelect red1 = new ColorSelect(166, 24, 4, 0.5);
        ColorSelect red2 = new ColorSelect(252, 0, 0, 0.5);
        ColorSelect red3 = new ColorSelect(255, 70, 70, 0.5);
        ColorSelect red4 = new ColorSelect(255, 122, 122, 0.5);
        ColorSelect red5 = new ColorSelect(245, 158, 145, 0.5);
        ColorSelect yellow1 = new ColorSelect(233,115,17,0.5);
        ColorSelect yellow2 = new ColorSelect(242,143,20,0.5);
        ColorSelect yellow3 = new ColorSelect(243,164,25,0.5);
        ColorSelect yellow4 = new ColorSelect(237,200,20,0.5);
        ColorSelect yellow5 = new ColorSelect(232,220,12,0.5);
        ColorSelect green1 = new ColorSelect(35,93,58,0.5);
        ColorSelect green2 = new ColorSelect(57,125,84,0.5);
        ColorSelect green3 = new ColorSelect(115,192,13,0.5);
        ColorSelect green4 = new ColorSelect(168,224,135,0.5);
        ColorSelect green5 = new ColorSelect(200,234,209,0.5);
        ColorSelect blue1 = new ColorSelect(1,92,146,0.5);
        ColorSelect blue2 = new ColorSelect(45,130,213,0.5);
        ColorSelect blue3 = new ColorSelect(2,161,251,0.27);
        ColorSelect blue4 = new ColorSelect(136,205,246,0.5);
        ColorSelect blue5 = new ColorSelect(188,230,255,0.5);
        ColorSelect purple1 = new ColorSelect(82,33,87,0.5);
        ColorSelect purple2 = new ColorSelect(100,96,144,0.5);
        ColorSelect purple3 = new ColorSelect(153,134,194,0.65);
        ColorSelect purple4 = new ColorSelect(199,159,211,0.5);
        ColorSelect purple5 = new ColorSelect(189,172,219,0.5);
        colorPlate.getChildren().addAll(new row(red1, red2, red3, red4, red5),
                new row(yellow1,yellow2,yellow3,yellow4,yellow5),
                new row(green1,green2,green3,green4,green5),
                new row(blue1,blue2,blue3,blue4,blue5),
                new row(purple1,purple2,purple3,purple4,purple5));

        red1.setOnMouseClicked(e -> colorSelected=red1.getColor());
        red2.setOnMouseClicked(e -> colorSelected=red2.getColor());
        red3.setOnMouseClicked(e -> colorSelected=red3.getColor());
        red4.setOnMouseClicked(e -> colorSelected=red4.getColor());
        red5.setOnMouseClicked(e -> colorSelected=red5.getColor());
        yellow1.setOnMouseClicked(e -> colorSelected=yellow1.getColor());
        yellow2.setOnMouseClicked(e -> colorSelected=yellow2.getColor());
        yellow3.setOnMouseClicked(e -> colorSelected=yellow3.getColor());
        yellow4.setOnMouseClicked(e -> colorSelected=yellow4.getColor());
        yellow5.setOnMouseClicked(e -> colorSelected=yellow5.getColor());
        green1.setOnMouseClicked(e -> colorSelected=green1.getColor());
        green2.setOnMouseClicked(e -> colorSelected=green2.getColor());
        green3.setOnMouseClicked(e -> colorSelected=green3.getColor());
        green4.setOnMouseClicked(e -> colorSelected=green4.getColor());
        green5.setOnMouseClicked(e -> colorSelected=green5.getColor());
        blue1.setOnMouseClicked(e -> colorSelected=blue1.getColor());
        blue2.setOnMouseClicked(e -> colorSelected=blue2.getColor());
        blue3.setOnMouseClicked(e -> colorSelected=blue3.getColor());
        blue4.setOnMouseClicked(e -> colorSelected=blue4.getColor());
        blue5.setOnMouseClicked(e -> colorSelected=blue5.getColor());
        purple1.setOnMouseClicked(e -> colorSelected=purple1.getColor());
        purple2.setOnMouseClicked(e -> colorSelected=purple2.getColor());
        purple3.setOnMouseClicked(e -> colorSelected=purple3.getColor());
        purple4.setOnMouseClicked(e -> colorSelected=purple4.getColor());
        purple5.setOnMouseClicked(e -> colorSelected=purple5.getColor());

        confirm.setOnMouseClicked(e->{
            if(color==null){
                System.out.println("not yet implemented");
            }
            else{
                File groupDataFile = new File(".\\out\\data\\GroupData.txt");
                try {
                    tempName = nameTextField.getText();
                    FileWriter groupDataOutput = new FileWriter(groupDataFile,true) {
                    };
                    Group group = new Group(tempName,colorSelected);
                    String msg = tempName+" "+colorSelected+"\n";
                    groupDataOutput.write(msg);
                    groupDataOutput.close();
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                Scene newScene;
                if(calendarOrEvent){
                    newScene = new Scene(new EventManagement1(), 375, 667);
                }
                else{
                    newScene = new Scene(new MonthBlock("Feb", "6"), 375, 667);
                }
                Main.getStage().setScene(newScene);
            }

        });

        HBox colorAll = new HBox();
        colorAll.setPrefSize(225,146);
        colorAll.setSpacing(25);
        colorAll.getChildren().addAll(color,colorPlate);

        Rectangle centerSpacing = new Rectangle(344,345);
        centerSpacing.setFill(Color.rgb(0,0,0,0.5));

        VBox centerBack = new VBox();
        centerBack.setPrefSize(344,217);
        centerBack.setSpacing(13);
        centerBack.setPadding(new Insets(10, 8, 21, 13));
        centerBack.getStyleClass().add("light-background");
        centerBack.getChildren().addAll(nameAll,colorAll);



        HBox centerAll = new HBox();
        centerAll.setPrefSize(375,562);
        centerAll.setPadding(new Insets(0,17,0,17));
        centerAll.getChildren().add(centerBack);


        VBox vBox = new VBox();
        vBox.setPrefSize(375,667);
        vBox.getChildren().addAll(topAll,centerAll);
        vBox.setPadding(new Insets(0,0,345,0));
        vBox.getStylesheets().add("sample/CreateGroupStyle.css");
        vBox.getStyleClass().add("dark-background");
        Font.getFamilies();
        getChildren().add(vBox);
    }

    public static class row extends Parent{
        public row (ColorSelect a, ColorSelect b, ColorSelect c, ColorSelect d, ColorSelect e){
            HBox row = new HBox();
            row.setPrefSize(156,20);
            row.setSpacing(14);
            row.getChildren().addAll(a,b,c,d,e);
            getChildren().add(row);
        }
    }
}
