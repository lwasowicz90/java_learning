/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathreadtest;

import data.FinTrans;
/**
 *
 * @author wasu
 */
public class JavaThreadTest {
    private static Thread tt1;
    private static Thread tt2;
    private static FinTrans ft = new FinTrans();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        deadlock();
    }
    
    public static void test3() {
        //wrong usage of syncchronization - this
        tt1 = new TransThread3(ft, "Deposit Thread");
        tt2 = new TransThread3(ft, "Withdraw Thread");
        tt1.start();
        tt2.start();
    }
    
    public static void deadlock() {
        tt1 = new TransThread4(ft, "Deposit Thread");
        tt2 = new TransThread4(ft, "Withdraw Thread");
        tt1.start();
        tt2.start();
    }
}
