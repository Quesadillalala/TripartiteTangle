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
import java.awt.image.BufferedImage;

/**
 *
 * @author kevin.lawrence
 */
public class Student extends Actor {

    public Student(Point position, Velocity velocity) {
        super(position, velocity);
        
        this.setImage(ResourceTools.loadImageFromResource("resources/student_books.jpg").getScaledInstance(50, 100, Image.SCALE_SMOOTH));
    }



//    public Student(Point position, Velocity velocity) {
//        BufferedImage image = (BufferedImage) ResourceTools.loadImageFromResource("resources/student_books.jpg");
//        
//        super(image, position, velocity);
//        
//        
//    }
    
}
