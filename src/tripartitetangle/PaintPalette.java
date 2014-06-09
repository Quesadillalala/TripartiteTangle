/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tripartitetangle;

import environment.Actor;
import environment.Velocity;
import images.ResourceTools;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author kevin.lawrence
 */
public class PaintPalette extends Actor {

    public PaintPalette(Point position, Velocity velocity) {
        super(position, velocity);
        setImage(ResourceTools.loadImageFromResource("resources/paint_palette.png").getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    }

    boolean getPosition(int i, int i0) {
        return false;
    }

    
}
