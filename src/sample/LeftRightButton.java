package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class LeftRightButton extends Parent{

        private BooleanProperty leftSwitchedOn = new SimpleBooleanProperty(false);
        public  BooleanProperty leftSwitchedOnProperty(){
            return leftSwitchedOn;
        } // 连接后端

        private BooleanProperty rightSwitchedOn = new SimpleBooleanProperty(false);
        public  BooleanProperty rightSwitchedOnProperty(){
            return rightSwitchedOn;
        } // 连接后端

        // 这里做了一个 可以由声明改变参数的ToggleSwitch 其实没有必要 毕竟只需要一个 但我就是做了
        public LeftRightButton(){
            Rectangle background = new Rectangle(90,50);
            background.setFill(new ImagePattern(new Image("img/LeftRightButton.png")));
            background.setStroke(Color.TRANSPARENT);
            background.setArcWidth(50);
            background.setArcHeight(50);

            Rectangle leftButton = new Rectangle(45,50);
            leftButton.setLayoutX(0);
            leftButton.setFill(Color.TRANSPARENT);
            leftButton.setOnMouseClicked(e -> {
                System.out.println("leftclicked");
            });

            Rectangle rightButton = new Rectangle(45,50);
            rightButton.setLayoutX(45);
            rightButton.setFill(Color.TRANSPARENT);
            rightButton.setOnMouseClicked(e -> {
                System.out.println("rightclicked");
            });

            getChildren().addAll(background,leftButton,rightButton);
        }
}
