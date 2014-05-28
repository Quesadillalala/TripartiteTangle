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
 * @author doughill
 */
public class ReportCardFail extends Actor {

    public ReportCardFail(Point position, Velocity velocity) {
        super(position, velocity);
        setImage(ResourceTools.loadImageFromResource("resources/report_card_fail.png").getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    }  
}

