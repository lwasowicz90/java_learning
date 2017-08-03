/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathreadtest;

import data.FinTrans;
/**
 *
 * @author wasu - race condition example
 */
public class TransThread extends Thread {
    private FinTrans ft;
    final private static String DEPOSIT_THREAD_NAME = "Deposit Thread";
    final private static String WITHDRAW_THREAD_NAME = "Withdraw Thread";
    
    TransThread(FinTrans ft, String name){
        super(name);
        this.ft = ft;
    }
    
    public void run(){
        if (this.getName().equals(DEPOSIT_THREAD_NAME)) {
            synchronized(ft){
                System.out.println(this.getName() + "\t\t" + "keeps lock: " + Thread.holdsLock(ft));
                
                ft.transactionName = "Deposit";
                try {
                    Thread.sleep((int)Math.random() * 1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                ft.amount = 2000;
                System.out.println(this.getName() + "\t\t" + ft.transactionName + " " + ft.amount);

            }
        } else {
            synchronized(ft){
                System.out.println(this.getName() + "\t\t" + "keeps lock: " + Thread.holdsLock(ft));
                
                ft.transactionName = "Withdraw";
                try {
                    Thread.sleep((int)Math.random() * 1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                ft.amount = 250.0;
                System.out.println(this.getName() + "\t\t" + ft.transactionName + " " + ft.amount);
            }
        }
    }    
}
