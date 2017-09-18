/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes;

import controllers.LoginController;

/**
 *
 * @author Slaush
 */
public class Viajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginController.getInstance().putLoginView();
    }
    
}
