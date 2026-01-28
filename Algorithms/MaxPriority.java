/**
 * This program implements a max-priority queue using a binary heap.
 * THis demonstrates heap-based insertion and deletion operations,
 * parent-child index relationships, and priority-based ordering.
 *
 * Author: Olivia Rueschhoff
 */
 
import java.util.Scanner;

public class MaxPriority{
   
   // public elements so size and heap are accessable in every method
   public static int size = 0;
   public static int[] maxHeap = new int[5];
   
   // method to insert element into proper location in maxHeap
   public static void insertion(int a){
      maxHeap[size] = a;
      // c is child index
      int c = size;
      size++;
      // start re-heap
      while(c > 0){
         // p is parent index
         int p = (c -1)/2;
         if(maxHeap[c]>maxHeap[p]){
            int temp = maxHeap[c];
            maxHeap[c] = maxHeap[p];
            maxHeap[p] = temp;
            c = p;
         } 
         else
            break;              
      }
   }
   
   // method to remove max (top) element in heap and then reheap so next max is on top
   public static int deletion(){
      int element = maxHeap[0];
      maxHeap[0] = maxHeap[size-1];
      size--;
      // parent index
      int p = 0;
      // left child index
      int lc = p*2+1;
      while(lc<size){
         int big = lc;
         // right child index
         int rc = lc+1;
         // check if parent has a right child
         if(rc<size){
            if(maxHeap[rc]>maxHeap[lc])
               big = rc;
         }
         if(maxHeap[p]<maxHeap[big]){
            int temp = maxHeap[p];
            maxHeap[p] = maxHeap[big];
            maxHeap[big] = temp;
            p = big;
            lc = 2*p+1;

         }
      } 
      return element;     
   }
   
   public static void main(String[] args){
      //input values from user and insert into heap accordingly
      System.out.println("Enter 5 Values:");
      Scanner input = new Scanner(System.in);
      int val = 0;
      while(size < 5){
         val = input.nextInt();
         insertion(val);
      }
      
      // print heap once all 5 elements have been inserted
      System.out.println("The elements of the max-priority queue: ");
      for(int i = 0; i < maxHeap.length; i++){
         System.out.print(maxHeap[i] + " ");
      }
      
      System.out.println("The element removed after the first deletion: " + deletion());
      System.out.println("The element removed after the second deletion: " + deletion());
   }   
}