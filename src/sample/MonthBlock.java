package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.util.Calendar;

public class MonthBlock extends Parent {

    public MonthBlock(String month, String day) throws IOException {

        String[] months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        //找到当月月数（Jan-0）
        int monthNum=0;
        for(int i=0;i<months.length;i++){
            if(months[i].equals(month)){
                monthNum=i;
            }
        }
        int[] daysForMonths={31,28,31,30,31,30,31,31,30,31,30,31};

        Pane backGround = new Pane();
        backGround.setPrefSize(345,509);

        Pane monthCa = new Pane();
        monthCa.setPrefSize(344,371);
        monthCa.setLayoutY(10);


        //读取内置每月起始星期数
        File file = new File(".\\out\\data\\CalendarData.txt");
        InputStreamReader read = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = bufferedReader.readLine();
        read.close();
        int starter=1;
        String[] dic=lineTxt.split(",");
        for(int i=0;i<months.length;i++){
            if(months[i].equals(month)){
                starter=Integer.parseInt(dic[i])-1;
            }
        }

        //月历格子
        for(int j=0;j<6;j++){
            for(int i=0;i<7;i++){
                Pane block=new Pane();
                block.setPrefSize(44,60);
                Rectangle block1=new Rectangle(44,60);
                block1.setFill(Color.rgb(165,165,165,0.3));
                block1.setLayoutX(50*i);
                block1.setLayoutY(115+66*j);
                block1.setOnMouseClicked(e->{
                    Scene newScene = new Scene(new DailyToDo(month,"1"),375,667);
                    Main.getStage().setScene(newScene);
                });
                block.getChildren().addAll(block1);
                monthCa.getChildren().addAll(block);
            }
        }


        //设置可点击的月历格子并给予日期label
        int count=1;
        boolean[]calendarBool=new boolean[42];
        for(int i=0;i<42;i++){
            if(i>=starter+1){
                calendarBool[i]=true;
                int r=i/7;
                if(count<=31) {
                    if (count < 10) {
                        Label date1 = new Label("0" + count);
                        date1.setPrefSize(24, 26);
                        date1.setAlignment(Pos.CENTER);
                        date1.setLayoutX(50 * (i % 7));
                        date1.setLayoutY(115 + 66 * r);
                        date1.getStyleClass().add("time-name-label");
                        monthCa.getChildren().addAll(date1);
                    } else {
                        Label date1 = new Label("" + count);
                        date1.setPrefSize(24, 26);
                        date1.setAlignment(Pos.CENTER);
                        date1.setLayoutX(50 * (i % 7));
                        date1.setLayoutY(115 + 66 * r);
                        date1.getStyleClass().add("time-name-label");
                        monthCa.getChildren().addAll(date1);
                    }
                }
                count++;
            }
            if(count>daysForMonths[monthNum]){
                break;
            }
        }

        count=1;
        String dayNow0=count+"";
        if(calendarBool[0]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(0%7));
            clickable.setLayoutY(115+66*(0/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow0),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
        }

        String dayNow1=count+"";
        if(calendarBool[1]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(1%7));
            clickable.setLayoutY(115+66*(1/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow1),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow2=count+"";
        if(calendarBool[2]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(2%7));
            clickable.setLayoutY(115+66*(2/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow2),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow3=count+"";
        if(calendarBool[3]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(3%7));
            clickable.setLayoutY(115+66*(3/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow3),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow4=count+"";
        if(calendarBool[4]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(4%7));
            clickable.setLayoutY(115+66*(4/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow4),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow5=count+"";
        if(calendarBool[5]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(5%7));
            clickable.setLayoutY(115+66*(5/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow5),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow6=count+"";
        if(calendarBool[6]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(6%7));
            clickable.setLayoutY(115+66*(6/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow6),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow7=count+"";
        if(calendarBool[7]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(7%7));
            clickable.setLayoutY(115+66*(7/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow7),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow8=count+"";
        if(calendarBool[8]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(8%7));
            clickable.setLayoutY(115+66*(8/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow8),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow9=count+"";
        if(calendarBool[9]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(9%7));
            clickable.setLayoutY(115+66*(9/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow9),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow10=count+"";
        if(calendarBool[10]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(10%7));
            clickable.setLayoutY(115+66*(10/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow10),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow11=count+"";
        if(calendarBool[11]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(11%7));
            clickable.setLayoutY(115+66*(11/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow11),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow12=count+"";
        if(calendarBool[12]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(12%7));
            clickable.setLayoutY(115+66*(12/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow12),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow13=count+"";
        if(calendarBool[13]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(13%7));
            clickable.setLayoutY(115+66*(13/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow13),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow14=count+"";
        if(calendarBool[14]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(14%7));
            clickable.setLayoutY(115+66*(14/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow14),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow15=count+"";
        if(calendarBool[15]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(15%7));
            clickable.setLayoutY(115+66*(15/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow15),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow16=count+"";
        if(calendarBool[16]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(16%7));
            clickable.setLayoutY(115+66*(16/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow16),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow17=count+"";
        if(calendarBool[17]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(17%7));
            clickable.setLayoutY(115+66*(17/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow17),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow18=count+"";
        if(calendarBool[18]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(18%7));
            clickable.setLayoutY(115+66*(18/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow18),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow19=count+"";
        if(calendarBool[19]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(19%7));
            clickable.setLayoutY(115+66*(19/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow19),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow20=count+"";
        if(calendarBool[20]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(20%7));
            clickable.setLayoutY(115+66*(20/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow20),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow21=count+"";
        if(calendarBool[21]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(21%7));
            clickable.setLayoutY(115+66*(21/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow21),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow22=count+"";
        if(calendarBool[22]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(22%7));
            clickable.setLayoutY(115+66*(22/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow22),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow23=count+"";
        if(calendarBool[23]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(23%7));
            clickable.setLayoutY(115+66*(23/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow23),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow24=count+"";
        if(calendarBool[24]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(24%7));
            clickable.setLayoutY(115+66*(24/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow24),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow25=count+"";
        if(calendarBool[25]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(25%7));
            clickable.setLayoutY(115+66*(25/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow25),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow26=count+"";
        if(calendarBool[26]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(26%7));
            clickable.setLayoutY(115+66*(26/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow26),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow27=count+"";
        if(calendarBool[27]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(27%7));
            clickable.setLayoutY(115+66*(27/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow27),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow28=count+"";
        if(calendarBool[28]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(28%7));
            clickable.setLayoutY(115+66*(28/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow28),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow29=count+"";
        if(calendarBool[29]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(29%7));
            clickable.setLayoutY(115+66*(29/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow29),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow30=count+"";
        if(calendarBool[30]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(30%7));
            clickable.setLayoutY(115+66*(30/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow30),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow31=count+"";
        if(calendarBool[31]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(31%7));
            clickable.setLayoutY(115+66*(31/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow31),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow32=count+"";
        if(calendarBool[32]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(32%7));
            clickable.setLayoutY(115+66*(32/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow32),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow33=count+"";
        if(calendarBool[33]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(33%7));
            clickable.setLayoutY(115+66*(33/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow33),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow34=count+"";
        if(calendarBool[34]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(34%7));
            clickable.setLayoutY(115+66*(34/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow34),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow35=count+"";
        if(calendarBool[35]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(35%7));
            clickable.setLayoutY(115+66*(35/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow35),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow36=count+"";
        if(calendarBool[36]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(36%7));
            clickable.setLayoutY(115+66*(36/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow36),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }

        String dayNow37=count+"";
        if(calendarBool[37]==true){
            Pane clickable=new Pane();
            clickable.setPrefSize(44,60);
            clickable.setLayoutX(50*(37%7));
            clickable.setLayoutY(115+66*(37/7));
            clickable.setOnMouseClicked(e->{
                Scene newScene=new Scene(new DailyToDo(month,dayNow37),375,667);
                Main.getStage().setScene(newScene);
            });
            count++;
            monthCa.getChildren().addAll(clickable);
        }




        //星期表示条
        Pane weekBar=new Pane();
        weekBar.setPrefSize(345,45);
        weekBar.setLayoutX(0);
        weekBar.setLayoutY(70);
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


        //上方按钮
        Pane buttons=new Pane();
        buttons.setPrefSize(123,50);
        CircleButton add = new CircleButton(new Image("img/add.PNG"));
        add.setOnMouseClicked(e->{
            Scene newScene = null;
            try {
                newScene = new Scene(new CreateEvent(3),375,667);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Main.getStage().setScene(newScene);
        });
        CircleButton list = new CircleButton(new Image("img/list.PNG"));
        list.setOnMouseClicked(e->{
            Scene newScene = null;
            try {
                newScene = new Scene(new EventManagement1(),375,667);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Main.getStage().setScene(newScene);
        });
        CircleButton addGroup = new CircleButton(new Image("img/add_group.PNG"));
        addGroup.setOnMouseClicked(e->{
            Scene newScene = new Scene(new CreateGroup(false),375,667);
            Main.getStage().setScene(newScene);
        });
        add.setLayoutX(25);
        add.setLayoutY(25);
        addGroup.setLayoutX(97);
        addGroup.setLayoutY(25);
        list.setLayoutX(169);
        list.setLayoutY(25);
        buttons.getChildren().addAll(add,addGroup,list);

        BottomBarWithScroll botBar = new BottomBarWithScroll(month,day);
        botBar.setLayoutX(0);
        botBar.setLayoutY(528);


        backGround.getChildren().addAll(monthCa,weekBar,buttons,botBar);



        //整合
        HBox root=new HBox();
        root.setPrefSize(375,667);


        Pane backBoard = new Pane();
        backBoard.setPrefSize(344,371);
        backGround.setLayoutX(1);
        backGround.setLayoutY(2);

        backBoard.getChildren().addAll(backGround);
        HBox.setMargin(backBoard,new Insets(15,15,28,15));

        root.getChildren().addAll(backBoard);
        root.getStylesheets().add("sample/MonthCalendarStyle.css");
        root.getStyleClass().addAll("light-background");

        getChildren().addAll(root);
    }
}
