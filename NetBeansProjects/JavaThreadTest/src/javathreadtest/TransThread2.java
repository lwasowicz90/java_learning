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
public class TransThread2 extends Thread {
    private FinTrans ft;
    final private static String DEPOSIT_THREAD_NAME = "Deposit Thread";
    final private static String WITHDRAW_THREAD_NAME = "Withdraw Thread";
    
    TransThread2(FinTrans ft, String name){
        super(name);
        this.ft = ft;
    }
    
    public void run(){
        for(int i = 0; i < 100; i++) {
            if (this.getName().equals(DEPOSIT_THREAD_NAME)) {                
                ft.update("Deposit", 2000);
            } else {
                ft.update("Withdraw", 250);
            }
        }
    }    
}
