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
public class TransThread4 extends Thread {
    private FinTrans ft;
    final private static String DEPOSIT_THREAD_NAME = "Deposit Thread";
    final private static String WITHDRAW_THREAD_NAME = "Withdraw Thread";
    private static String AnotherSharedLock = "";
    
    TransThread4(FinTrans ft, String name){
        super(name);
        this.ft = ft;
    }
    
    public void run(){
        final String tName = getName();
        if (this.getName().equals(DEPOSIT_THREAD_NAME)) {
            System.out.println(tName + " waits for ft lock");
            synchronized(ft){
                System.out.println(tName + " acquired ft lock");
                System.out.println(tName + " waits for AnotherSharedLock lock");
                synchronized(AnotherSharedLock) {
                    System.out.println(tName + " acquired ft AnotherSharedLock");
                    ft.transactionName = "Deposit";
                    try {
                        Thread.sleep((int)Math.random() * 1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    ft.amount = 2000;
                    System.out.println(this.getName() + "\t\t" + ft.transactionName + " " + ft.amount);
                }
            }
        } else {
            System.out.println(tName + " waits for AnotherSharedLock lock");            
            synchronized(AnotherSharedLock) {
                System.out.println(tName + " acquired ft AnotherSharedLock");
                System.out.println(tName + " waits for ft lock");
                synchronized(ft){
                    System.out.println(tName + " acquired ft lock");

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
}
