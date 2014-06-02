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
import java.awt.Font;
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
    private int sportscore = 0;
    private int artscore = 0;
    private int academicscore = 0;

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

        lastRain = System.currentTimeMillis();
    }
    private int FLOOR = 402;

    @Override
    public void timerTaskHandler() {
        makeItRain();

        checkCollection();



        if (student != null) {
            if (student.getPosition().y >= FLOOR) {
                student.getPosition().y = FLOOR - 2;
                student.getVelocity().y = 0;
            }
        }
    }
    private long lastRain;
    private int rainDelayMS = 3000;

    private void makeItRain() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastRain >= rainDelayMS) {
            lastRain = currentTime;
            System.out.println("tb");
            TennisBall tb = new TennisBall(new Point((int) (Math.random() * 600), -20), new Velocity(0, 3));
            PaintPalette pp = new PaintPalette(new Point((int) (Math.random() * 600), -20), new Velocity(0, 2));

            tennisBalls.add(tb);
            getActors().add(tb);
            paintPalettes.add(pp);
            getActors().add(pp);
        }
    
    }

    private void checkCollection() {
        for (PaintPalette pp : paintPalettes) {
            if (pp.intersects(student)) {
                pp.setPosition(-100, -100);
                this.setArtscore(this.getArtscore() + 10);
            }

            for (TennisBall tb : tennisBalls) {
                if (tb.intersects(student)) {
                    tb.setPosition(-100, -100);
                    this.setSportscore(this.getSportscore() + 10);
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
        
        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("Space Age", Font.BOLD, 40));
        graphics.drawString("Art Score: " + this.getArtscore(), 630, 35);
        
        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("Space Age", Font.BOLD, 40));
        graphics.drawString("Sport Score: " + this.getSportscore(), 630, 70);
        
        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("Space Age", Font.BOLD, 40));
        graphics.drawString("Academic Score: " + this.getAcademicscore(), 630, 105);
    }

    /**
     * @return the sportscore
     */
    public int getSportscore() {
        return sportscore;
    }

    /**
     * @param sportscore the sportscore to set
     */
    public void setSportscore(int sportscore) {
        this.sportscore = sportscore;
    }

    /**
     * @return the artscore
     */
    public int getArtscore() {
        return artscore;
    }

    /**
     * @param artscore the artscore to set
     */
    public void setArtscore(int artscore) {
        this.artscore = artscore;
    }

    /**
     * @return the academicscore
     */
    public int getAcademicscore() {
        return academicscore;
    }

    /**
     * @param academicscore the academicscore to set
     */
    public void setAcademicscore(int academicscore) {
        this.academicscore = academicscore;
    }

    /**
     * @return the score
     */
    

    
}
