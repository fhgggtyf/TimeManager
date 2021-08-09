package sample;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.concurrent.atomic.AtomicBoolean;

public class ColorSelect extends Parent {
    Color color;
    Circle whiteCircle = new Circle();

    public Color getColor() {
        whiteCircle.setFill(Color.WHITE);
        return color;
    }

    public ColorSelect (Integer a, Integer b, Integer c, Double d){
        this.color = Color.rgb(a,b,c,d);
        Circle circle = new Circle();
        circle.setRadius(10);
        whiteCircle.setRadius(12);
        circle.setFill(Color.rgb(a,b,c,d));
        whiteCircle.setFill(Color.TRANSPARENT);
        getChildren().addAll(whiteCircle,circle);
    }
}
