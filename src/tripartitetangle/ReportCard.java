/*
 * To change this template, choose Tools | Templates
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
 * @author Owner
 */
public class ReportCard extends Actor {
    
    public ReportCard(Point position, Velocity velocity) {
        super(position, velocity);
        setImage(ResourceTools.loadImageFromResource("resources/report_card_awesome.png").getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    }
    
}
