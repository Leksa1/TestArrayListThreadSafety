/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilinskiy.testarraylistthreadsafety;


import java.util.Random;

/**
 *
 * @author leksa
 */
public class Starter {

    final static int LIMIT = 4;
    final static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        new Thread(Mainer.getInstance()).start();
        for (int i = 0; i < LIMIT; i++) {
            new Thread(new Runner(i)).start();
            Thread.sleep(random.nextInt(LIMIT));
        }
    }
}
