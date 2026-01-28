/*
 This program implements a generic circularly linked list supporting 
 the following abilities:
 addFirst, addLast, removeFirst, rotate, and accesse to values.
 This demonstrates modular linked list implementation and generic types.
 
 Author: Olivia Rueschhoff
 */


//Singly Circular Linked List Implementation
public class CircularlyLinkedList<E>{
   //Node class
   private static class Node<E>{
      private E element;    
      private Node<E> next;  
      public Node(E e, Node<E> n){
         element = e;
         next = n;
      }
      public E getElement(){ 
        return element; 
      }
      public Node<E> getNext(){ 
        return next; 
      }
      public void setNext(Node<E> n){ 
        next = n; 
      }
   } 

   private Node<E> head = null;            
   private Node<E> tail = null;            
   private int size = 0;     
   
   //constructs empty circularly linked list                    
   public CircularlyLinkedList(){   }  
   
   //get size of the list            
   public int size(){ 
      return size; 
   }
   
   //method to check if list is empty
   public boolean isEmpty(){ 
      return size == 0; 
   }

   //returns head node value
   public E first(){
      if(this.isEmpty()) 
         return null;
      return head.getElement();
   }
   //returns tail node value
   public E last(){              
      if (this.isEmpty()) 
         return null;
      return tail.getElement();
   }
   //rotate first item to end
   public void rotate(){     
      // the old head becomes the new tail    
      if(tail != null){                
         head = head.getNext();
         tail = tail.getNext();
      }   
   }
   //adds element to front
   public void addFirst(E e){                
      Node nst = new Node(e, head);
      if(isEmpty()){
         head = nst;
         tail = nst;
      }
      else{
         tail.setNext(nst);
         head = nst;
      }
      size++;
   }
   //adds element to tail
   public void addLast(E e){
      Node nst = new Node(e, head);
      if(isEmpty()){
         head = nst;
         tail = nst;
      }
      else{   
         tail.setNext(nst);
         tail = nst;
      }
      size++;
   }
   //remove first element
   public E removeFirst(){
      if(this.isEmpty()) 
         return null;
      
      E e = head.getElement();
      if(head == tail){
         // If there is only one node in the list
         head = head.getNext();
         tail = head;
      } 
      else{
         head = head.getNext();
         tail.setNext(head);
      }
      size--;
      return e;
  }   
}  


