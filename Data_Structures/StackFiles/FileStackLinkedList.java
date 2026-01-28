/*
 This program implements a "stack of files" simulation to manage file access order.
 Two versions are provided: one using an array and one using a linked list.
 to demonstrate loop control, conditional logic, method decomposition,
 and different approaches to managing a dynamic collection.
 
 This version uses a Singly Linked List to demonstrate fixed-size stack operations.
 
 Author: Olivia Rueschhoff
 */

import java.util.Scanner;
import java.util.LinkedList;

public class FileStackLinkedList{
   
   //method to print SLL
   public static void print(LinkedList a){
      System.out.println("File stack: ");
      for(int i = 0; i < a.size(); i++){
         System.out.print(a.getFirst() + " ");
         a.addLast(a.removeFirst());
      }
   }
   
   //method to check if file is already in stack
   public static boolean inStack(LinkedList<Integer> a, int file){
      int temp = 1;
      while(temp<a.size()){
         if(file==a.getFirst()){
            System.out.println("true");
              return true;
         }   
         a.addLast(a.removeFirst());
         temp++;
      }
      System.out.println("false");
      return false;
   }
   
   //method to move files lower in stack and desired file on top
   public static LinkedList<Integer> shift(LinkedList<Integer> a, int file){
      //if file is already in stack
      if(a.indexOf(file)!=-1){
         int position = a.indexOf(file);
         a.remove(position);
         a.addFirst(file);
         return a;
      }
      //adding file from rack to on top and putting back bottom file
      else{
         a.addFirst(file);
         a.removeLast();
         return a;
      }
   }

   public static void main(String[] args){
   
      //create file stack
      LinkedList<Integer> stack = new LinkedList<Integer>();
      stack.addLast(0);
      stack.addLast(0);
      stack.addLast(0);
      stack.addLast(0);
      stack.addLast(0);
            
      //ask for first file
      Scanner input = new Scanner(System.in);
      System.out.println("Please enter the file you want to use (enter 0 to terminate):");
      int file = input.nextInt();
      
      while (file != 0){
         //check for valid file input
         if(file > 10 || file < 0){
            System.out.println("Invalid file, please try again \n");
         }
         
         else if(stack.getFirst()!=0){    
            
            //if file is already on top, do nothing
            if(file==stack.getFirst()){   }
            
            //rotate files to put desired file on top
            else{
               stack = shift(stack, file);
               }
            }
       
         
         //add first file   
         else{
            stack.addFirst(file);
            stack.removeLast();
         }
         //get input for next file
         print(stack);
         System.out.println("\n\nPlease enter the file you want to use (enter 0 to terminate):");
         file = input.nextInt();
      }
      System.out.println("Thank you!");
   }
}

