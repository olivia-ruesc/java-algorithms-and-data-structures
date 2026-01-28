/*
 This program converts an infix arithmetic expression into postfix notation
 and evaluates the result using stacks to demonstrates stack-based 
 algorithms, operator precedence handling,and expression parsing logic.
 
 Author: Olivia Rueschhoff
 */
 
import java.util.Scanner;
import java.util.Stack;

public class PostFix{

   //check if expression input is valid
   public static boolean isValid(String[] arr){
      Stack<String> valid = new Stack<>();
      for(int i = 0; i < arr.length; i++){
         if(arr[i].contains("("))
            valid.push("(");
         else if(arr[i].contains(")")){
            if(valid.empty())
               return false;
            else
               valid.pop();
         }
      }
      return valid.empty();   
   }
   
   //method to determine precidence
   public static int preci(String c){
      if(c.equals("*") || c.equals("/") || c.equals("%"))
         return 2;
      else if(c.equals("+") || c.equals("-"))
         return 1;
      else
         return -1;
   }
   
   //convert infix to postfix expression
   public static String[] convertPostFix(String[] arr){
      Stack<String> moving = new Stack<>();
      String[] post = new String[arr.length];
      
      for(int i = 0; i < arr.length; i++){
         //check if operator
         if(preci(arr[i])>0){
            if(moving.empty()){
               moving.push(arr[i]);
            }
            else{
               //check for higher, lower, or same precidence
               while(!moving.empty() && preci(arr[i])<=preci(moving.peek())){
                  post[available(post)] = moving.pop();
               }
               moving.push(arr[i]);
            }
          }
          //check for paranthesis
          else if(arr[i].equals("("))
            moving.push(arr[i]);

          else if(arr[i].equals(")")){
            while(!moving.peek().equals("(")){
               post[available(post)] = moving.pop();
            }
            moving.pop();
          }
         //operands get passed to string
         else{
            post[available(post)] = arr[i];
         }
      }
      //pop rest of stack
      while(!moving.empty()){
            post[available(post)] = moving.pop();
      }
      //print postfix
      System.out.println("The postfix expression: ");
      for(int i = 0; i < post.length; i++){
         if(post[i]!=null){
            System.out.print(post[i] + " ");
         }
      }
      System.out.println();
      return post;
   }
   
   //method to get next available spot on string
   public static int available(String[] post){
      int i = 0;
      while(i < post.length && post[i]!=null){
         i++;
      }
      return i;
   }
   
   //method that uses stack to evaluate a postfix expression
   public static int finalResult(String[] arr){
      Stack<Integer> result = new Stack<>();
      for(int i = 0; i < arr.length; i++){
         if(arr[i]==null)
            break;
         //determine the operator and use it to evaluate the proper opperands
         else if(arr[i].equals("*")){
            int n1 = result.pop();
            int n2 = result.pop();
            result.push(n2*n1);
         }
         else if(arr[i].equals("/")){
            int n1 = result.pop();
            int n2 = result.pop();
            result.push(n2/n1);
         }
         else if(arr[i].equals("%")){
            int n1 = result.pop();
            int n2 = result.pop();
            result.push(n2%n1);
         }
         else if(arr[i].equals("+")){
            int n1 = result.pop();
            int n2 = result.pop();
            result.push(n2+n1);
         }
         else if(arr[i].equals("-")){
            int n1 = result.pop();
            int n2 = result.pop();
            result.push(n2-n1);
         }
         //convert string to int so stack can properly evaluate integers
         else{
            int[] temp = new int[1];
            temp[0] = Integer.parseInt(arr[i]);
            result.push(temp[0]);
         }
      }
      return result.pop();
   }
   
   public static void main(String[] args){
      boolean x = true;
      Scanner input = new Scanner(System.in);
      
      while(x){
         //input expression
         System.out.println("Enter the expression (space-separated):");
         String in = input.nextLine();
         String[] ex = in.split(" ");
         
         //check if expression is valid
         if(isValid(ex)){
            //convert to PostFix
            ex = convertPostFix(ex);
            
            //calculate expression
            System.out.println("The final result: " + finalResult(ex));
         }
         else{
            System.out.println("The expression is invalid.");
         }
         
         //Continue with new expression?
         System.out.println("Do you want to continue (Y/N)?");
         String cont = input.nextLine();
         if(cont.equalsIgnoreCase("N")){
            x = false;
         }
      }  
      System.out.println("Thank you!");    
      input.close();
   }
}
