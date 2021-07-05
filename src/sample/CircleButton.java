package sample;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class CircleButton extends Parent {

    public CircleButton(Image image){

        Circle circle = new Circle(26);
        circle.setFill(new ImagePattern(image));
        getChildren().add(circle);
    }
}