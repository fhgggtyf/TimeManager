package sample;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.concurrent.atomic.AtomicBoolean;

public class CircleButton extends Parent {

    public CircleButton(Image image1,Image image2){

        Circle circle = new Circle(26);
        circle.setFill(new ImagePattern(image1));
        AtomicBoolean circleFillStatusProgressing = new AtomicBoolean(true);
        getChildren().add(circle);

        circle.setOnMouseClicked(e->{
            if(circleFillStatusProgressing.get()){
                circle.setFill(new ImagePattern(image2));
                circleFillStatusProgressing.set(false);
            }else{
                circle.setFill(new ImagePattern(image1));
                circleFillStatusProgressing.set(true);
            }
        });
    }
}