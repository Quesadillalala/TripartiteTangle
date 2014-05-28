/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripartitetangle;

import environment.Environment;
import environment.Velocity;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author kevin.lawrence
 */
class GameEnvironment extends Environment {

    Student student;
    ArrayList<PaintPalette> paintPalettes;
    ArrayList<TennisBall> tennisBalls;

    @Override
    public void initializeEnvironment() {
        this.setBackground(ResourceTools.loadImageFromResource("resources/school_field.jpg"));

        student = new Student(new Point(100, 400), new Velocity(0, 0));
        getActors().add(student);

        paintPalettes = new ArrayList<PaintPalette>();
        for (int i = 0; i < 10; i++) {
            PaintPalette pp = new PaintPalette(new Point(150 + (i * 50), 450 - (i * 10)), new Velocity(0, 0));
            paintPalettes.add(pp);
            getActors().add(pp);
        }
        tennisBalls = new ArrayList<TennisBall>();
        for (int i = 0; i < 10; i++) {
            TennisBall tb = new TennisBall(new Point(250 + (i * 50), 450 - (i * 10)), new Velocity(0, 0));
            tennisBalls.add(tb);
            getActors().add(tb);
        }


    }

    @Override
    public void timerTaskHandler() {
        checkCollection();
      //  if (student != null) {
        //    if (student.getPosition().y == KeyEvent.VK_UP) {
          //      student.getVelocity().y = 0;
            //}   
        //}
    }

    private void checkCollection() {
        for (PaintPalette pp : paintPalettes) {
            if (pp.intersects(student)) {
                pp.setPosition(-100, -100);
            }
            for (TennisBall tb : tennisBalls) {
                if (tb.intersects(student)) {
                    tb.setPosition(-100, -100);
                    //add to the score?  make a sound?
                }
            }
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            student.getVelocity().x = -2;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            student.getVelocity().x = +2;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            student.getVelocity().y = -2;
        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            student.stop();
        }
         if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            student.stop();
         }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            student.getVelocity().y = +2;
        }

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(630, 35, 250, 120);
    }
}
