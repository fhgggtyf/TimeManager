package sample;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class CircleButton extends Parent {

    Image image;

    public CircleButton(Image image) {
        this.image = image;
        refreshFill();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        refreshFill();
    }

    public void refreshFill(){
        Circle circle = new Circle(26);
        circle.setFill(new ImagePattern(image));
        getChildren().add(circle);
    }

}