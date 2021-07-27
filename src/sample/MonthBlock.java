package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class MonthBlock extends Parent {

    public static Parent calendar(String month, String day){
        HBox root=new HBox();
        root.setPrefSize(375,548);

        Pane backBoard = new Pane();
        backBoard.setPrefSize(344,371);
        MonthBlock monthSquare = new MonthBlock(month, day);
        monthSquare.setLayoutX(1);
        monthSquare.setLayoutY(2);

        backBoard.getChildren().addAll(monthSquare);
        HBox.setMargin(backBoard,new Insets(15,15,28,15));

        root.getChildren().addAll(backBoard);
        return root;
    }

    public MonthBlock(String month, String day){

        Pane backGround = new Pane();
        backGround.setPrefSize(345,509);

        Pane monthCa = new Pane();
        monthCa.setPrefSize(344,371);
        monthCa.setLayoutY(10);
        for(int j=0;j<5;j++){
            for(int i=0;i<7;i++){
                Pane block=new Pane();
                block.setPrefSize(44,69);
                Rectangle block1=new Rectangle(44,69);
                block1.setFill(Color.rgb(165,165,165,0.3));
                block1.setLayoutX(50*i);
                block1.setLayoutY(126+75*j);
                block.getChildren().addAll(block1);
                if(i+j*7+1<31){
                    if(i+j*7+1<10){
                        Label date1 = new Label("0"+(i+j*7+1));
                        date1.setPrefSize(24,26);
                        date1.setAlignment(Pos.CENTER);
                        date1.setLayoutX(50*i);
                        date1.setLayoutY(126+75*j);
                        date1.getStyleClass().add("time-name-label");
                        block.getChildren().addAll(date1);
                    }else{
                        Label date1 = new Label(""+(i+j*7+1));
                        date1.setPrefSize(24,26);
                        date1.setAlignment(Pos.CENTER);
                        date1.setLayoutX(50*i);
                        date1.setLayoutY(126+75*j);
                        date1.getStyleClass().add("time-name-label");
                        block.getChildren().addAll(date1);
                    }

                }

                monthCa.getChildren().addAll(block);
            }
        }



        Pane weekBar=new Pane();
        weekBar.setPrefSize(345,45);
        weekBar.setLayoutX(0);
        weekBar.setLayoutY(79);
        Rectangle block=new Rectangle(345,45);
        block.setFill(Color.rgb(165,165,165,0.3));

        Label sun=new Label("SUN");
        sun.setPrefSize(45,20);
        sun.setLayoutX(0);
        sun.setLayoutY(10);
        sun.getStyleClass().add("time-name-label");

        Label mon=new Label("MON");
        mon.setPrefSize(45,20);
        mon.setLayoutX(52.5);
        mon.setLayoutY(10);
        mon.getStyleClass().add("time-name-label");

        Label tue=new Label("TUE");
        tue.setPrefSize(45,20);
        tue.setLayoutX(100);
        tue.setLayoutY(10);
        tue.getStyleClass().add("time-name-label");

        Label wed=new Label("WED");
        wed.setPrefSize(45,20);
        wed.setLayoutX(150);
        wed.setLayoutY(10);
        wed.getStyleClass().add("time-name-label");

        Label thu=new Label("THU");
        thu.setPrefSize(45,20);
        thu.setLayoutX(200);
        thu.setLayoutY(10);
        thu.getStyleClass().add("time-name-label");

        Label fri=new Label("FRI");
        fri.setPrefSize(45,20);
        fri.setLayoutX(250);
        fri.setLayoutY(10);
        fri.getStyleClass().add("time-name-label");

        Label sat=new Label("SAT");
        sat.setPrefSize(45,20);
        sat.setLayoutX(300);
        sat.setLayoutY(10);
        sat.getStyleClass().add("time-name-label");

        weekBar.getChildren().addAll(block,sun,mon,tue,wed,thu,fri,sat);

        Pane buttons=new Pane();
        buttons.setPrefSize(123,50);
        Circle add=new Circle(25);
        Circle list=new Circle(25);
        add.setFill(Color.rgb(165,165,165,0.3));
        //add.setFill(new ImagePattern(new Image("src/add.png")));
        add.setLayoutX(25);
        add.setLayoutY(25);
        list.setFill(Color.rgb(165,165,165,0.3));
        list.setLayoutX(97);
        list.setLayoutY(25);
        buttons.getChildren().addAll(add,list);

        BottomBarWithScroll botBar = new BottomBarWithScroll(month,day);
        botBar.setLayoutX(0);
        botBar.setLayoutY(528);


        backGround.getChildren().addAll(monthCa,weekBar,buttons,botBar);
        getChildren().addAll(backGround);
    }
}
