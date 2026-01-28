/*
 This program simulates round-robin CPU scheduling using a CircularlyLinkedList
 to demonstrate practical use of custom data structures for 
 process queue management.
 
 Author: Olivia Rueschhoff
 */


import java.util.Scanner;

//this class uses a CircularlyLinkedList code I implemented, see attached CircularlyLinkedList.java file for reference
public class CPUProcessingOrder{
   
   //method to print the process queue
   public static void print(CircularlyLinkedList<String> a, CircularlyLinkedList<Integer> n){
      System.out.print("The process queue: ");
      for(int i = 0; i < a.size(); i++){
         System.out.print(a.first() + ", " + n.first() + "\t");
         a.addLast(a.removeFirst());
         n.addLast(n.removeFirst());
      }
      System.out.println();
      System.out.println();
   }
   
   public static void main(String[] args){
      //create 2 seperate circularly linked lists, one for names and one for corresponding time
      CircularlyLinkedList<String> names = new CircularlyLinkedList<>();
      CircularlyLinkedList<Integer> time = new CircularlyLinkedList<>();
      
      //starting information
      Scanner in1 = new Scanner(System.in);
      System.out.println("Enter the total number of processes:");
      int process = in1.nextInt();
      System.out.println("Enter the time quanta:");
      int timequanta = in1.nextInt();

      //input names and time into lists
      for(int i = 1; i <= process; i++){
         Scanner in2 = new Scanner(System.in);
         System.out.println("Enter the name of process " + i + ":");
         names.addLast(in2.nextLine());
         
         System.out.println("Enter its execution time:");
         time.addLast(in1.nextInt());
      }
   
      //begin execution phase
      print(names, time);
      System.out.println("Execution phase:");
      System.out.println();

      //execution phase to subtract timequanta from time and move process to the back until all are done
      while(time.isEmpty()==false){
         time.addFirst(time.removeFirst()-timequanta);         
         if(time.first()<=0){
            System.out.println("Process " + names.removeFirst() + " is executed.");
            time.removeFirst();
            if(time.isEmpty()==true){
               break;
            }
            System.out.println();
         }
         time.addLast(time.removeFirst());
         names.addLast(names.removeFirst());
         print(names, time);
      }
      //All processes have been complete
      System.out.println("The process queue is empty.");
      
   }

}
