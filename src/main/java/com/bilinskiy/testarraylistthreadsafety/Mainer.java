/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilinskiy.testarraylistthreadsafety;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leksa
 */
public class Mainer implements Runnable {

//    private static List al;
    private static ArrayList al = new ArrayList();
    private static Mainer instance = null;
//    private final static Object lockal = new Object();

    public static Mainer getInstance() {
        if (instance == null) {
            instance = new Mainer();
        }
        return instance;
    }

    @Override
    public void run() {    
//        al = Collections.synchronizedList(new ArrayList());
        long interval = System.currentTimeMillis();
        while (true) {
            int cnt = 0;
            if (!al.isEmpty()) {
                cnt = 0;
                String s = (String) al.get(0);
                if (s == null) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.print(System.currentTimeMillis() - interval);
                    System.out.println("ms");
                    interval = System.currentTimeMillis();
                }
//                synchronized (lockal) {
                    al.remove(0);
//                }
            } else {
                try {
                    Thread.sleep(++cnt * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mainer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void add(String msg) {
//        synchronized (lockal) {
            al.add(msg);
//        }
    }

}
