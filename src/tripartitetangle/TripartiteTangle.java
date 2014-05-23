/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tripartitetangle;

import environment.ApplicationStarter;

/**
 *
 * @author kevin.lawrence
 */
public class TripartiteTangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        ApplicationStarter.run("Tripartite Tangle!", new GameEnvironment());
    }
    
}
