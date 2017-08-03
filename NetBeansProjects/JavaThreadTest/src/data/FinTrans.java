/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author wasu
 */
public class FinTrans {
    public static String transactionName;
    public static double amount;
    
    synchronized public void update(String name, double value) {
        transactionName = name;
        amount = value;
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return transactionName + " " + amount;
    }
}
