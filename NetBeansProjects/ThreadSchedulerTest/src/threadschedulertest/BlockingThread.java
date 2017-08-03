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
public class BlockingThread extends Thread {
   private boolean finished = false;
   public void run ()
   {
      while (!finished)
      {
         try
         {
            int i;
            do
            {
               i = System.in.read ();
               System.out.print (i + " ");
            }
            while (i != 'o');
            System.out.print ('\n');
         }
         catch (java.io.IOException e)
         {
         }
      }
   }
   public void setFinished (boolean f)
   {
      finished = f;
   }
}
