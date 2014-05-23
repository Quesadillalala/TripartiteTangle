/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tripartitetangle;

import environment.Environment;
import environment.Velocity;
import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author kevin.lawrence
 */
class GameEnvironment extends Environment {

    Student student;
    
    @Override
    public void initializeEnvironment() {
        this.setBackground(ResourceTools.loadImageFromResource("resources/school_field.jpg"));
        
        student = new Student(new Point(100, 400), new Velocity(0,0));
        getActors().add(student);
    }

    @Override
    public void timerTaskHandler() {

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            student.getVelocity().y = -2;
//        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            student.getVelocity().x = -2;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            student.getVelocity().x = +2;
        } //else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            student.getVelocity().x = +2;
//        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            student.stop();
        }
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    @Override
    public void paintEnvironment(Graphics graphics) {

    }


    
}
