/*
 This program implements a simple hash table using linear probing for collision 
 to demonstrate method decomposition, collision handling, and basic 
 algorithmic thinking.
 
 Uses the hash function h(x) = (3*x + 5) mod 11.
 
 Author: Olivia Rueschhoff
 */

import java.util.Scanner;
import java.lang.Math;

public class HashTable{

   // public elements so size and hash table are accessable in every method
   public static int size = 0;
   public static int[] hashTable = new int[11];
   
   // method to print hash table
   public static void print(int[] a){
      System.out.println("File stack: ");
      for(int i = 0; i < a.length; i++){
         System.out.print(hashTable[i] + " ");
      }
   }
   
   // method to insert element correctly into hash table
   public static void insertion(int x){
   
      // applies function to get index
      int function = Math.abs((3*x+5)%11);
      
      // check if index is available
      if(hashTable[function] == 0){
         hashTable[function] = x;
         size++;
         print(hashTable);
      }
      
      // if not available that means a collision has occured
      else{
         System.out.println("Collision detected for " + x);
         
         // linear probing
         while(hashTable[function]!=0){
            if(function == 10)
               function = 0;
            else
               function++;
         }
         hashTable[function] = x;
         size ++;
         print(hashTable);
      }
   }
      
   public static void main(String[] args){
   
      // read in user input for values to insert into Hash Table
      System.out.println("Enter value to insert:");
      Scanner input = new Scanner(System.in);
      int val = input.nextInt();
      
      while(val != 0 && size != 11){
         insertion(val);
         System.out.println("\n To continue, enter next value, otherwise, enter 0 to end.");
         val = input.nextInt();
      }
      
      System.out.println("Hash Table is complete");
   }   

}
