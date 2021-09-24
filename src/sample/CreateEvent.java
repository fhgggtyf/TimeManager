package sample;

import javafx.animation.*;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// 可以在找层次的时候 手动画一幅图 会能更好理解定位和分层过程
public class CreateEvent extends Parent {

    String tempEventName;
    String tempEventNote;
    Calendar tempEventStart = Calendar.getInstance();
    Calendar tempEventEnd = Calendar.getInstance();
    String fromHalfDay;
    String fromHour;
    String fromMin;
    String untilHalfDay;
    String untilHour;
    String untilMin;
    boolean tempEventAlarm;
    Group tempEventGroup;
    String groupName;

    // 浅色框之间的空隙
    private Parent spacing(int height){
        Pane root = new Pane();
        root.setPrefSize(375,height);
        return root;
    }

    // 俩圆形按钮
    private Parent top(int back){
        HBox root = new HBox();
        root.setPrefSize(375,105);

        Pane buttonFix = new Pane();
        buttonFix.setPrefSize(344,80);

        CircleButton backButton = new CircleButton(new Image("img/back_button.png"));
        CircleButton saveButton = new CircleButton(new Image("img/save_button.png"));
        backButton.setLayoutX(26);
        backButton.setLayoutY(53);
        saveButton.setLayoutX(100);
        saveButton.setLayoutY(53);

        String[] months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        Calendar cal=Calendar.getInstance();
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DATE);
        String monthNow=months[month];

        backButton.setOnMouseClicked(event -> {
            if(back==1){
                Scene newScene = null;// ... commands which define the new scene.
                try {
                    newScene = new Scene(new EventManagement1(),375,667);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.getStage().setScene(newScene);
            }
            else if(back==2){
                Scene newScene = new Scene(new DailyToDo(monthNow,day+""),375,667);// ... commands which define the new scene.
                Main.getStage().setScene(newScene);
            }
            else{
                Scene newScene = null;// ... commands which define the new scene.
                try {
                    newScene = new Scene(new MonthBlock(monthNow,day+""),375,667);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.getStage().setScene(newScene);
            }

        });

        saveButton.setOnMouseClicked(e ->{
            File eventDataFile = new File(".\\out\\data\\EventData.txt");
            try {
                File file = new File(".\\out\\data\\GroupData.txt");
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file));//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while((lineTxt = bufferedReader.readLine()) != null){
                    String str=lineTxt+"\r\n";
                    String[] dictionary =  str.split(" ");
                    if(dictionary[0].equals(groupName)){
                        tempEventGroup = new Group(groupName,Color.web(dictionary[1].substring(0,8)));
                        break;
                    }
                }
                //string转date转calendar
                if(fromHalfDay.equals("PM")){
                    fromHour = Integer.toString(Integer.parseInt(fromHour)+12);
                }
                String tempFromHour = fromHour;
                String tempFromMin = fromMin;
                Calendar nowTime = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH-mm");
                Date tempFrom = new Date();
                try {
                    tempFrom = simpleDateFormat1.parse(tempFromHour + "-" + tempFromMin);
                } catch (ParseException event) {
                    event.printStackTrace();
                }
                if(back == 1){
                    //set time according to window they are on
                }
                else if(back == 2){
                    //set time according to window they are on
                }
                else{
                    //set date today
                    tempEventStart.set(nowTime.get(Calendar.YEAR),nowTime.get(Calendar.MONTH),nowTime.get(Calendar.DATE),tempFrom.getHours(),tempFrom.getMinutes(),0);
                }
                if(untilHalfDay == "PM"){
                    untilHour=Integer.toString(Integer.parseInt(untilHour)+12);
                }
                String tempUntilHour = untilHour;
                String tempUntilMin = untilMin;
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH-mm");
                Date tempUntil = new Date();
                try {
                    tempUntil = simpleDateFormat2.parse(tempUntilHour + "-" + tempUntilMin);
                } catch (ParseException event) {
                    event.printStackTrace();
                }
                tempEventEnd.setTime(tempUntil);
                if(back == 1){
                    //set time according to window they are on
                }
                else if(back == 2){
                    //set time according to window they are on
                }
                else{
                    //set date today
                    tempEventEnd.set(nowTime.get(Calendar.YEAR),nowTime.get(Calendar.MONTH),nowTime.get(Calendar.DATE));
                }
                FileWriter eventDataOutput = new FileWriter(eventDataFile,true){};
                if(tempEventName == null){
                    tempEventName = "No name";
                }
                if(tempEventNote == null){
                    tempEventNote = "No description";
                }
                Event event = new Event(tempEventName,tempEventNote,tempEventStart,tempEventEnd,tempEventAlarm,tempEventGroup);
                String msg = tempEventName+";"+tempEventNote+";"+tempEventStart.getTimeInMillis()+";"+tempEventEnd.getTimeInMillis()+";"+tempEventAlarm+";"+groupName+"\n";
                eventDataOutput.write(msg);
                eventDataOutput.close();
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            Scene newScene = null;
            if(back==1){
                try {
                    newScene = new Scene(new EventManagement1(),375,667);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else if(back==2){
                newScene = new Scene(new DailyToDo(monthNow,day+""), 375, 667);
            }
            else{
                try {
                    newScene = new Scene(new MonthBlock("June", "23"), 375, 667);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            Main.getStage().setScene(newScene);
        });

        buttonFix.getChildren().addAll(backButton,saveButton);
        root.getChildren().addAll(buttonFix);
        root.setAlignment(Pos.CENTER);
        return root;
    }

    // Name Note
    private Parent mid1(){
        HBox root = new HBox();

        VBox backBoard = new VBox(); // 浅色背景板
        backBoard.getStyleClass().addAll("light-background");

        Pane nameGetter = new Pane();
        Label nameLabel = new Label("Name");
        nameLabel.getStyleClass().add("instructor-label");
        TextField nameTextField = new TextField();
        nameTextField.textProperty().addListener((observableValue, oddValue, newValue) -> tempEventName = nameTextField.getText());
        nameTextField.setLayoutX(66);
        nameTextField.setMinWidth(253);
        nameTextField.setPromptText("(5 words maximum)");
        nameGetter.getChildren().addAll(nameLabel,nameTextField);
        VBox.setMargin(nameGetter, new Insets(12,12,12,12)); // 两边margin12 上下一样

        Pane noteGetter = new Pane();
        Label noteLabel = new Label("Note");
        noteLabel.getStyleClass().add("instructor-label");
        TextArea noteTextArea = new TextArea();
        noteTextArea.textProperty().addListener((observableValue, oddValue, newValue) -> tempEventNote = noteTextArea.getText());
        noteTextArea.setPrefRowCount(2);
        noteTextArea.setLayoutX(66); // 默认以下所有除label外第一个元素左端均为66
        noteTextArea.setPrefWidth(253);
        noteTextArea.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= 80 ? change : null)); // 字符限制80
        noteTextArea.setWrapText(true); //自动换行
        noteTextArea.setPromptText("(20 words maximum)");
        noteGetter.getChildren().addAll(noteLabel,noteTextArea);
        VBox.setMargin(noteGetter, new Insets(0,12,12,12)); //上无margin 中间只需要12px的距离

        backBoard.getChildren().addAll(nameGetter,noteGetter);
        root.getChildren().addAll(backBoard);
        root.setAlignment(Pos.CENTER);

        return root;
    }

    // From Until
    private Parent mid2(){
        HBox root = new HBox();

        Label indent1 = new Label(":");
        indent1.getStyleClass().add("instructor-label");
        Label indent2 = new Label(":");
        indent2.getStyleClass().add("instructor-label");

        VBox mid2 = new VBox();
        mid2.setPrefSize(344,158);
        mid2.getStyleClass().addAll("light-background");

        Pane fromGetter = new Pane();
        Label fromLabel = new Label("From");
        fromLabel.getStyleClass().add("instructor-label");
        ChoiceBox<String> fromHalfDayCBox = new ChoiceBox<>();
        fromHalfDayCBox.getItems().addAll("AM","PM");
        fromHalfDayCBox.setValue("AM");
        fromHalfDay="AM";
        fromHalfDayCBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, oddValue, newValue) -> fromHalfDay=fromHalfDayCBox.getValue());
        fromHalfDayCBox.setLayoutX(66);
        fromHalfDayCBox.setPrefSize(98,27);

        ChoiceBox<String> fromHourCBox = new ChoiceBox<>();
        fromHourCBox.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
        fromHourCBox.setValue("01");
        fromHour="01";
        fromHourCBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, oddValue, newValue) -> fromHour=fromHourCBox.getValue());
        fromHourCBox.setLayoutX(190);
        fromHourCBox.setPrefSize(54,27);

        ChoiceBox<String> fromMinCBox = new ChoiceBox<>();
        fromMinCBox.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59");
        fromMinCBox.setValue("00");
        fromMin="00";
        fromMinCBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, oddValue, newValue) -> fromMin=fromMinCBox.getValue());
        fromMinCBox.setLayoutX(268);
        fromMinCBox.setPrefSize(54,27);
        VBox.setMargin(fromGetter, new Insets(12,12,12,12));
        indent1.setLayoutX(250);
        //string转date转calendar
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
//        Date tempFrom = new Date();
//        try {
//            tempFrom = simpleDateFormat.parse(tempFromHour+"-"+tempFromMin);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        tempEventStart.setTime(tempFrom);
        fromGetter.getChildren().addAll(fromLabel,fromHalfDayCBox,fromHourCBox,indent1,fromMinCBox);

        Pane untilGetter = new Pane();
        Label untilLabel = new Label("Until");
        untilLabel.getStyleClass().add("instructor-label");

        ChoiceBox<String> untilHalfDayCBox = new ChoiceBox();
        untilHalfDayCBox.getItems().addAll("AM","PM");
        untilHalfDayCBox.setValue("AM");
        untilHalfDay="AM";
        untilHalfDayCBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, oddValue, newValue) -> untilHalfDay=untilHalfDayCBox.getValue());
        untilHalfDayCBox.setLayoutX(66);
        untilHalfDayCBox.setPrefSize(98,27);

        ChoiceBox<String> untilHourCBox = new ChoiceBox();
        untilHourCBox.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
        untilHourCBox.setValue("01");
        untilHour="01";
        untilHourCBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, oddValue, newValue) -> untilHour=untilHourCBox.getValue());
        untilHourCBox.setLayoutX(190);
        untilHourCBox.setPrefSize(54,27);

        ChoiceBox<String> untilMinCBox = new ChoiceBox();
        untilMinCBox.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59");
        untilMinCBox.setValue("00");
        untilMin="00";
        untilMinCBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, oddValue, newValue) -> untilMin=untilMinCBox.getValue());
        untilMinCBox.setLayoutX(268);
        untilMinCBox.setPrefSize(54,27);

        VBox.setMargin(untilGetter, new Insets(00,12,12,12));
        indent2.setLayoutX(250);
        untilGetter.getChildren().addAll(untilLabel,untilHalfDayCBox,untilHourCBox,indent2,untilMinCBox);

        Pane alarmSwitch = new Pane();
        ToggleSwitch toggle = new ToggleSwitch(54,27);
        toggle.setLayoutX(268);
        Label alarmLabel = new Label("Alarm");
        alarmLabel.getStyleClass().add("instructor-label");
        alarmSwitch.getChildren().addAll(alarmLabel,toggle);
        VBox.setMargin(alarmSwitch, new Insets(15,12,27,12));
        mid2.getChildren().addAll(fromGetter,untilGetter,alarmSwitch);
        toggle.setOnMouseClicked(e->{
            toggle.switchedOn.set(!toggle.switchedOn.get());
            tempEventAlarm = toggle.switchedOn.get();
        });
        root.getChildren().addAll(mid2);
        root.setAlignment(Pos.CENTER);
        return root;
    }

    // Group
    private Parent bot() throws IOException {
        HBox root = new HBox();

        VBox bot = new VBox();
        bot.setPrefSize(344,50);
        bot.getStyleClass().addAll("light-background");

        Pane groupGetter = new Pane();
        Label groupLabel = new Label("Group");
        groupLabel.getStyleClass().add("instructor-label");
        ChoiceBox<String> groups = new ChoiceBox();

        ArrayList<String> groupArrayList = new ArrayList<>();
        File file = new File(".\\out\\data\\GroupData.txt");
        InputStreamReader read = new InputStreamReader(
                new FileInputStream(file));//考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        while((lineTxt = bufferedReader.readLine()) != null){
            String str=lineTxt+"\r\n";
            String[] dictionary =  str.split(" ");
            groupArrayList.add(dictionary[0]);
        }

        for(int i = 0; i < groupArrayList.size(); i++){
            groups.getItems().add(groupArrayList.get(i));
            if(i==0){
                groups.setValue(groupArrayList.get(0));
            }
        }
        groups.getSelectionModel().selectedIndexProperty().addListener((observableValue, oddValue, newValue) -> groupName=groups.getValue());
        groupName=groups.getValue();
        groups.setLayoutX(66);
        groups.setPrefSize(254,27);
        groupGetter.getChildren().addAll(groupLabel,groups);
        VBox.setMargin(groupGetter, new Insets(12,12,12,12));

        bot.getChildren().addAll(groupGetter);

        root.getChildren().addAll(bot);
        root.setAlignment(Pos.CENTER);

        return root;
    }

    public CreateEvent(int dailyOrEvent) throws IOException {

        // Show scene
        VBox back = new VBox();
        back.setPrefSize(375,667);

        javafx.scene.text.Font.getFamilies();
        back.getChildren().addAll(top(dailyOrEvent),mid1(),spacing(38),mid2(),spacing(38),bot());
        back.getStylesheets().add("sample/CreateEventStyle.css");
        back.getStyleClass().addAll("background");
        getChildren().addAll(back);
    }

    private static class ToggleSwitch extends Parent {

        private BooleanProperty switchedOn = new SimpleBooleanProperty(false);

        private TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(0.1));
        private FillTransition fillAnimation = new FillTransition(Duration.seconds(0.1));

        private ParallelTransition animation = new ParallelTransition(translateAnimation,fillAnimation);

        public  BooleanProperty switchedOnProperty(){
            return switchedOn;
        } // 连接后端

        // 这里做了一个 可以由声明改变参数的ToggleSwitch 其实没有必要 毕竟只需要一个 但我就是做了
        public ToggleSwitch(int x, int y){
            Rectangle background = new Rectangle(x,y);
            background.setFill(Color.rgb(0,0,0,0.3));
            background.setStroke(Color.TRANSPARENT);
            background.setArcWidth(10);
            background.setArcHeight(10);

            Rectangle trigger = new Rectangle(y,y);
            trigger.setArcWidth(10);
            trigger.setArcHeight(10);
            trigger.setFill(Color.WHITE);
            trigger.setStroke(Color.LIGHTGRAY);

            translateAnimation.setNode(trigger);
            fillAnimation.setShape(background);

            getChildren().addAll(background,trigger);

            switchedOn.addListener((obs,oldState,newState)->{
                boolean isOn = newState.booleanValue();
                translateAnimation.setToX(isOn ? x - y : 0);
                fillAnimation.setFromValue(isOn ? Color.rgb(0,0,0,0.3) : Color.rgb(255,255,255,0.3));
                fillAnimation.setToValue(isOn ? Color.rgb(255,255,255,0.3) : Color.rgb(0,0,0,0.3));
                animation.play();
            });
        }
    }
}
