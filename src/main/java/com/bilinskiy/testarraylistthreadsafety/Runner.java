/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilinskiy.testarraylistthreadsafety;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leksa
 */
public class Runner implements Runnable {
    
    final static Random random = new Random();
    String number;

    public Runner(int number) {
        this.number = Integer.toString(number);
    }
    
    @Override
    public void run() {
        int cnt=0;
        while (true){
        Mainer.add(number.concat("_").concat(Integer.toString(++cnt)));
            try {
                Thread.sleep(random.nextInt(2));
            } catch (InterruptedException ex) {
                Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
