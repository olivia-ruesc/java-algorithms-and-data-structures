/*
 This program simulates repeated rolls of a Die to analyze outcome frequency
 and convergence behavior. It demonstrates simulation logic,
 loops, array-based counting, and basic statistical reasoning.
 
 Author: Olivia Rueschhoff
 */

public class DieSimulation{
   public static void main(String[] args){
      Die d1 = new Die();
      Die d2 = new Die();
      int rollCount =1;
      while(!d1.equals(d2)){
         d1.roll();
         d2.roll();
         rollCount++;
      }
      System.out.println("Same value took " + rollCount + " rolls");
      int[] valueCounts = new int[6];
      for(int count = 0; count < 1000000; count++){
         d1.roll();
         valueCounts[d1.getValue()-1]++;
      }
      System.out.println(java.util.Arrays.toString(valueCounts));
   }


}
