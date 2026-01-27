/**
 * This program implements a "stack of files" simulation to manage file access order.
 * Two versions are provided: one using an array and one using a linked list.
 * to demonstrate loop control, conditional logic, method decomposition,
 * and different approaches to managing a dynamic collection.
 *
 * This version uses an array to demonstrate fixed-size stack operations.
 *
 * Author: Olivia Rueschhoff
 */


import java.util.Scanner;

public class FileStackArray{

   public static int numFiles = 1;
   
   //method to print array
   public static void print(int[] a){
      System.out.println("File stack: ");
      for(int i = 0; i < a.length; i++){
         System.out.print(a[i] + " ");
      }
   }
   
   //method to see if file is already in stack
   public static boolean inStack(int[] arr, int file){
      for(int i = 0; i < 5; i++){
         if(arr[i]==file)
            return true;
      }
      return false;
   }
   
   //method to shift files over
   public static int[] shift(int[] arr, int file, int pos){
      while(pos > 0){ 
         arr[pos] = arr[pos-1];
         pos--;
      }
      arr[0]=file;
      return arr;
   
   }
   
   public static void main(String[] args){
   
      //create file stack
      int[] fileStack = new int[5];
      
      //ask for first file
      Scanner input = new Scanner(System.in);
      System.out.println("Please enter the file you want to use (enter 0 to terminate):");
      int file = input.nextInt();
      
      while(file != 0){
         //check for valid file
         if(file > 10 || file < 0){
            System.out.println("Invalid file, please try again \n");
         }
         
         //if file is already on top, do nothing
         else if(file==fileStack[0]){  }
            
         else{
            //check if aleady in stack
            if(inStack(fileStack, file)){
            
               //find position of file
               int position = 0;
               while(file!=fileStack[position])
                  position++;
                  
               //shift and remove from previous spot
               fileStack = shift(fileStack, file, position);
               if(numFiles!=5)
                  numFiles++;
            }
            else{
               fileStack = shift(fileStack, file, numFiles-1);
               if(numFiles!=5){
                  numFiles++; 
               }
            }
         }
         print(fileStack);
         System.out.println("\n\nPlease enter the file you want to use (enter 0 to terminate):");
         file = input.nextInt();
      }
      System.out.println("Thank you!");
   }
}