/*
 This program represents a six-sided die with roll and comparison ability.
 This demonstrates constructors, method overriding,and controlled randomness.
 
 Author: Olivia Rueschhoff
 */

import java.util.Random;

public class Die{
   private int currentValue;
   private static Random rand = new Random();
   
   public Die(){
      this.roll();
   }
   
   public Die(int val){
      if(val < 1 || val > 6)
         throw new IllegalArgumentException("Can't make die with value: " + val);
      currentValue = val;
   }  

   
   public int getValue(){
      return currentValue;
   }
   
   public void roll(){
      currentValue = rand.nextInt(6)+1;
   }
   
   @Override
   public String toString(){
      return "Die: " + currentValue;
   }
   
   @Override
   public boolean equals(Object o){
      if(o == null){
         return false;
      }
      if(! (o instanceof Die)){
         return false;
      }
      Die d = (Die)o;
      return this.currentValue == d.currentValue; 
   }

}
