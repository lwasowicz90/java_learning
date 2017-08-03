/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstjavaprogram;

/**
 *
 * @author wasu
 */
public class NumberPrinter {
    public Integer number;
    
    public NumberPrinter(Integer number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return "Number is ";
    }
    
    public void print() {
        System.out.println( toString() + number );
    }   
}
