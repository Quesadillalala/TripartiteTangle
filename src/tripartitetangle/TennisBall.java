package tripartitetangle;


import environment.Actor;
import environment.Velocity;
import images.ResourceTools;
import java.awt.Image;
import java.awt.Point;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class TennisBall extends Actor {
    
    public TennisBall(Point position, Velocity velocity) {
        super(position, velocity);
        setImage(ResourceTools.loadImageFromResource("resources/tennisball.png").getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    }
    
}
