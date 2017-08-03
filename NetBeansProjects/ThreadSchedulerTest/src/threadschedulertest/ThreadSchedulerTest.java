/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadschedulertest;

/**
 *
 * @author wasu
 */
public class ThreadSchedulerTest {
    public static void priority_test() {
        BlockingThread bt = new BlockingThread();
        bt.setPriority(Thread.NORM_PRIORITY + 1);
        CalculatingThread ct = new CalculatingThread();
        bt.start();
        ct.start();
        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) {
            
        }
        bt.setFinished(true);
        ct.setFinished(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        priority_test();
    }
    
}
