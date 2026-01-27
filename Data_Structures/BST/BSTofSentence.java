/**
 * This demonstrates usage of BinarySearchTree to process a sentence by
 * building a BST, printsing word frequencies, and deleteing a word.
 *
 * Author: Olivia Rueschhoff
 */

import java.util.Scanner;

public class BSTofSentence{

   public static void main(String[] args){
   
      // Create the BST
      BinarySearchTree tree = new BinarySearchTree();  
          
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a sentence:");
      String sentence = input.nextLine();
      
      // split sentence into words at white space
      String[] words = sentence.split("\\s+");
      
      for(int i = 0; i < words.length; i++){
         tree.root = tree.insert(tree.root, words[i]);
      }
      
      tree.printTree(tree.root);
      
      System.out.println();
      System.out.println("Enter the word to be deleted:");
      String deleteWord = input.nextLine();
      tree.root = tree.delete(tree.root, deleteWord);
      
      System.out.println("\nThe BST after removing the word:");
      tree.printTree(tree.root);
   }
}