/*
 This program implements a Binary Search Tree (BST) for strings, 
 tracking word frequency and supporting insertion, deletion,
 and in-order traversal to demonstrate recursion and 
 tree-based data structures.
  
 Author: Olivia Rueschhoff
 */

class BinarySearchTree{

   class Node{
      String data;
      Node left, right;
      int frequency;

      public Node (String item){
         data = item;
         left = right = null;
         frequency = 1;
      }
   }

   Node root;
   
   BinarySearchTree(){
      root = null;
   }

   // method to insert a string into the BST
   public Node insert(Node root, String key){
      if (root == null){
         return new Node(key);
      }
      
      // Compare the key with the current node's key
      if (key.compareTo(root.data) < 0){
         root.left = insert(root.left, key);
      } 
      else if (key.compareTo(root.data) > 0){
         root.right = insert(root.right, key);
      }
      else{
         // word already exists so increment frequency
         root.frequency++;
      }
      
      // Return the (unchanged) node pointer
      return root;
   }

   // In-order traversal to print (Left, Root, Right)
   public void printTree(Node root){
      if (root != null){
         printTree(root.left);  // traverse left subtree
         System.out.print(root.data + ", " + root.frequency + "; ");//visit the node
         printTree(root.right); // traverse right subtree
      }
   }

   public Node delete(Node root, String data){
      // return root if word not found
      if (root == null){
         System.out.println("The word is not found.");
         return root;
      }
      
      // compare strings to find the node to delete
      if (data.compareTo(root.data) < 0){
         //go to left subtree
         root.left = delete(root.left, data);
      } 
      else if (data.compareTo(root.data) > 0){
         //go to right subtree
         root.right = delete(root.right, data);
      } 
      else{
         // node is found
         if(root.frequency>1){
            root.frequency--;  
            System.out.println("The frequency of " + root.data + " is now " + root.frequency + ".");
         }
         else{ 
            System.out.println("The word " + root.data + " is removed from the BST.");
            
            // Case 1: Node has no children (leaf node)
            if (root.left == null && root.right == null)
               root = null;
          
            // Case 2: Node has only one child (right)
            else if (root.left == null)
               root = root.right;              
               
            // Case 2: Node has only one child (left)
            else if (root.right == null)
               root = root.left;
              
            // Case 3: Node has two children
            else{
               Node xsp = root;
               Node xsucc = root.right;
               
               // find the inorder successor
               while (xsucc.left != null){
                  xsp = xsucc;
                  xsucc = xsucc.left;
               }

               // replace the current node's data with the inorder successor's data
               root.data = xsucc.data;

               // remove the inorder successor
               if (xsp == root)
                  root.right = xsucc.right;
               
               else
                  xsp.left = xsucc.right;
                  
               }
            }
        }
        return root;
    }
}



