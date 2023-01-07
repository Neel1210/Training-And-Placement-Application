/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Neel_Esh
 */
public class CounterQuiz {
    
    
        public static void main(String[] args) {
        
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            int time=10;
            
            public void run()
            {
                if(time>0)
                {
                    System.out.println("sec is - "+time);
                    time=time-1;
                }
                else
                {
                    System.out.println("Time over");
                    timer.cancel();
                }
                
            }
        };
        
        timer.scheduleAtFixedRate(task, 0, 1000);
            System.out.println("over");
        
    }
}
