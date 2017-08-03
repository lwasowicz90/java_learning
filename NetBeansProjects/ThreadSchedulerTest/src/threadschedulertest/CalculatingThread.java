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
public class CalculatingThread extends Thread{
   private boolean finished = false;
   public void run ()
   {
      int sum = 0;
      while (!finished)
         sum++;
   }
   public void setFinished (boolean f)
   {
      finished = f;
   }
}
