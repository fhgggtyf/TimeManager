/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Maggie
 */
public class Group {
    private String name; //组别名称
    private Paint color; //组别代表色

    public Group(String name, Paint color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Paint getColor() { return color; }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
