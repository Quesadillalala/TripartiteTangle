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
import java.util.ArrayList;

/**
 *
 * @author kevin.lawrence
 */
class GameEnvironment extends Environment {

    Student student;
    ArrayList<PaintPalette> paintPalettes;
    ArrayList<ReportCardFail> reportCardFail;
    private ReportCardFail RF;

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

        PaintPalette pp = new PaintPalette(new Point(150 + (int) (Math.random() * 400), -200), new Velocity(0, 3));
        paintPalettes.add(pp);
        getActors().add(pp);

        pp = new PaintPalette(new Point(150 + (int) (Math.random() * 400), -400), new Velocity(0, 1));
        paintPalettes.add(pp);
        getActors().add(pp);

        pp = new PaintPalette(new Point(150 + (int) (Math.random() * 400), -100), new Velocity(0, 5));
        paintPalettes.add(pp);
        getActors().add(pp);

        reportCardFail = new ArrayList<ReportCardFail>();
        for (int i = 0; i < 1; i++) {
            ReportCardFail RF = new ReportCardFail(new Point((int) (Math.random() * 999), 500), new Velocity(-1, 0));
            reportCardFail.add(RF);
            getActors().add(RF);
        }
       // RF = new ReportCardFail(new Point(300, 100 +(int) (Math.random() * 500)), new Velocity(-4, 0));
        //reportCardFail.add(RF);
        //getActors().add(RF);

        //RF = new ReportCardFail(new Point(300, 150 + (int) (Math.random() * 500)), new Velocity(-3, 0));
       // reportCardFail.add(RF);
        //getActors().add(RF);

       // RF = new ReportCardFail(new Point(300, 150 + (int) (Math.random() * 500)), new Velocity(-2, 0));
       // reportCardFail.add(RF);
        //getActors().add(RF);

    }

    @Override
    public void timerTaskHandler() {
        checkCollection();

    }

    public void checkCollection() {
        for (PaintPalette pp : paintPalettes) {
            if (pp.intersects(student)) {
                pp.setPosition(new Point(150 + (int) (Math.random() * 900), 100));
                //add to the score?  make a sound?
            }
            for (ReportCardFail RF : reportCardFail) {
                if (RF.intersects(student)) {
                    RF.setPosition(new Point(150 + (int) (Math.random() * 900), 100));
                }
            }
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            student.getVelocity().x = -5;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            student.getVelocity().x = +5;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            student.getVelocity().y = -5;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            student.getVelocity().y = +5;

        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_LEFT)) {
            student.stop();
        }
        if ((e.getKeyCode() == KeyEvent.VK_DOWN)) {
            student.getVelocity().y = +5;
        }
        student.stop();

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    @Override
    public void paintEnvironment(Graphics graphics) {

    }

}
