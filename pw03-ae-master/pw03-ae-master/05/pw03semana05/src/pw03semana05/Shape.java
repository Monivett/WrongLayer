/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana05;

/**
 *
 * @author magoc
 */
public abstract class Shape {

    public double width;
    public double height;

    public abstract float getPerimeter();

    public abstract float getArea();

    public double getWidth() {
        return width;
    }

}
