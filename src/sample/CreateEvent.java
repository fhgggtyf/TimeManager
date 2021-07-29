package sample;

import javafx.animation.*;
import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.*;

import java.util.*;

// 可以在找层次的时候 手动画一幅图 会能更好理解定位和分层过程
public class CreateEvent extends Parent {

    String tempEventName;
    String tempEventNote;
    Calendar tempEventStart;
    Calendar tempEventEnd;
    boolean tempEventAlarm;
    Group tempEventGroup;

    // 浅色框之间的空隙
    private Parent spacing(int height){
        Pane root = new Pane();
        root.setPrefSize(375,height);

        return root;
    }

    // 俩圆形按钮
    private Parent top(){
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

        backButton.setOnMouseClicked(event -> {
            Scene newScene = new Scene(new DailyToDo(),375,667);// ... commands which define the new scene.
            Main.getStage().setScene(newScene);
        });

        saveButton.setOnMouseClicked(event ->{
            //Event tempEvent = new Event(tempEventName,tempEventNote,tempEventStart,tempEventEnd,tempEventAlarm,tempEventGroup);
            //day.addToEventList(tempEvent);
            Scene newScene = new Scene(new DailyToDo(),375,667);// ... commands which define the new scene.
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
//        tempEventName=nameTextField.getText();
        nameTextField.setLayoutX(66);
        nameTextField.setMinWidth(253);
        nameTextField.setPromptText("(5 words maximum)");
        nameGetter.getChildren().addAll(nameLabel,nameTextField);
        VBox.setMargin(nameGetter, new Insets(12,12,12,12)); // 两边margin12 上下一样

        Pane noteGetter = new Pane();
        Label noteLabel = new Label("Note");
        noteLabel.getStyleClass().add("instructor-label");
        TextArea noteTextArea = new TextArea();
//        tempEventNote=noteTextArea.getText();
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
        ChoiceBox fromYear = new ChoiceBox();
        fromYear.setLayoutX(66);
        fromYear.setPrefSize(98,27);
        ChoiceBox fromHour = new ChoiceBox();
        fromHour.setLayoutX(190);
        fromHour.setPrefSize(54,27);
        ChoiceBox fromMin = new ChoiceBox();
        fromMin.setLayoutX(268);
        fromMin.setPrefSize(54,27);
        VBox.setMargin(fromGetter, new Insets(12,12,12,12));
        indent1.setLayoutX(250);

        Pane untilGetter = new Pane();
        Label untilLabel = new Label("Until");
        untilLabel.getStyleClass().add("instructor-label");
        ChoiceBox untilYear = new ChoiceBox();
        untilYear.setLayoutX(66);
        untilYear.setPrefSize(98,27);
        ChoiceBox untilHour = new ChoiceBox();
        untilHour.setLayoutX(190);
        untilHour.setPrefSize(54,27);
        ChoiceBox untilMin = new ChoiceBox();
        untilMin.setLayoutX(268);
        untilMin.setPrefSize(54,27);
        VBox.setMargin(untilGetter, new Insets(00,12,12,12));
        indent2.setLayoutX(250);

        fromGetter.getChildren().addAll(fromLabel,fromYear,fromHour,indent1,fromMin);
        untilGetter.getChildren().addAll(untilLabel,untilYear,untilHour,indent2,untilMin);

        Pane alarmSwitch = new Pane();
        ToggleSwitch toggle = new ToggleSwitch(54,27);
        toggle.setLayoutX(268);
        Label alarmLabel = new Label("Alarm");
        alarmLabel.getStyleClass().add("instructor-label");
        alarmSwitch.getChildren().addAll(alarmLabel,toggle);
        VBox.setMargin(alarmSwitch, new Insets(15,12,27,12));

        mid2.getChildren().addAll(fromGetter,untilGetter,alarmSwitch);

        root.getChildren().addAll(mid2);
        root.setAlignment(Pos.CENTER);
        return root;
    }

    // Group
    private Parent bot(){
        HBox root = new HBox();

        VBox bot = new VBox();
        bot.setPrefSize(344,50);
        bot.getStyleClass().addAll("light-background");

        Pane groupGetter = new Pane();
        Label groupLabel = new Label("Group");
        groupLabel.getStyleClass().add("instructor-label");
        ChoiceBox groups = new ChoiceBox();
        groups.setLayoutX(66);
        groups.setPrefSize(254,27);
        groupGetter.getChildren().addAll(groupLabel,groups);
        VBox.setMargin(groupGetter, new Insets(12,12,12,12));

        bot.getChildren().addAll(groupGetter);

        root.getChildren().addAll(bot);
        root.setAlignment(Pos.CENTER);

        return root;
    }

    public CreateEvent(){

        // Show scene
        VBox back = new VBox();
        back.setPrefSize(375,667);

        javafx.scene.text.Font.getFamilies();
        back.getChildren().addAll(top(),mid1(),spacing(38),mid2(),spacing(38),bot());
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

            setOnMouseClicked(e -> {
                switchedOn.set(!switchedOn.get());
            });
        }
    }
}
