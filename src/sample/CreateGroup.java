package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreateGroup extends Parent{

    String tempName;
    Paint colorSelected;

    public CreateGroup(){
        CircleButton arrow = new CircleButton(new Image("img/arrow.PNG"));
        CircleButton confirm = new CircleButton(new Image("img/confirm.PNG"));
        confirm.setOnMouseClicked(e->{
            Group group = new Group(tempName,colorSelected);
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
        tempName = nameTextField.getText();

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

    public static class ColorSelect extends Parent {
        Color color;
        AtomicBoolean isClicked = new AtomicBoolean(false);
        public ColorSelect (Integer a, Integer b, Integer c, Double d){
            this.color = Color.rgb(a,b,c,d);
            Circle circle = new Circle();
            circle.setRadius(10);
            circle.setFill(Color.rgb(a,b,c,d));
            getChildren().add(circle);

            circle.setOnMouseClicked(e->{
                isClicked.set(true);
            });
        }
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
