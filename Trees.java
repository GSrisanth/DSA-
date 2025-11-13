
// // Representation of trees in java


// class Node {
//     int data;
//     Node left;
//     Node right;
//     public Node(int key){
//         data = key;
//     }
//     public static void main(String[] args) {
//     Node root = new Node(1);
//     root.left = new Node(2);
//     root.right = new Node(3);
//     root.right.left = new Node(4);

//     System.out.println("Binary tree created");
//     System.out.println("Root data: " + root.data);
//     System.out.println("Left child of root: " + root.left.data);
//     System.out.println("Right child of root: " + root.right.data);
//     System.out.println("Left child of right child of root: " + root.right.left.data);

//     }
// }    

// Binary tree traversals BFS/DFs

// Pre order traversal

// class Node{
//     int data;
//     Node left, right;
//     public Node(int key){
//         data = key;
//         left = right = null;
//     } 
// }
// class BinaryTree{
//     Node root;
    
//     void preorder(Node node){
//         if(node == null){
//             return;
//         }
//         System.out.println(node.data + " ");
//         preorder(node.left);
//         preorder(node.right);
//     }
//     public static void main(String[] args) {
//         BinaryTree tree = new BinaryTree();
//         tree.root = new Node(1);
//         tree.root.left = new Node(2);
//         tree.root.right = new Node(3);
//         tree.root.left.left = new Node(4);
//         tree.root.left.right = new Node(5);
//         System.out.println("preorder Traversal :");
//         tree.preorder(tree.root);
//     }
    
// }


//Inorder Traversal

// class BinaryTreeNode {
//     int data;
//     BinaryTreeNode left, right;
    
//     public BinaryTreeNode(int key) {
//         data = key;
//         left = right = null;
//     } 
// }

// public class BinaryTree {
//     BinaryTreeNode root;
    
//     void inorder(BinaryTreeNode node) {
//         if(node == null) {
//             return;
//         }
//         inorder(node.left);
//         System.out.print(node.data + " ");
//         inorder(node.right);
//     }
    
//     public static void main(String[] args) {
//         BinaryTree tree = new BinaryTree();
        
//         // Build tree: 
//         //       1
//         //      / \
//         //     2   3
//         //    / \
//         //   4   5
//         tree.root = new BinaryTreeNode(1);
//         tree.root.left = new BinaryTreeNode(2);
//         tree.root.right = new BinaryTreeNode(3);
//         tree.root.left.left = new BinaryTreeNode(4);
//         tree.root.left.right = new BinaryTreeNode(5);
        
//         System.out.print("Inorder Traversal: ");
//         tree.inorder(tree.root);
//         System.out.println();
//     }
// }



//postorder Traversal

// class BinaryTreeNode {
//     int data;
//     BinaryTreeNode left, right;
    
//     public BinaryTreeNode(int key) {
//         data = key;
//         left = right = null;
//     } 
// }

// class BinaryTree {
//     BinaryTreeNode root;
    
//     void postorder(BinaryTreeNode node) {
//         if(node == null) {
//             return;
//         }
//         postorder(node.left);
//         postorder(node.right);
//         System.out.print(node.data + " ");
        
//     }
    
//     public static void main(String[] args) {
//         BinaryTree tree = new BinaryTree();
        
//         // Build tree: 
//         //       1
//         //      / \
//         //     2   3
//         //    / \
//         //   4   5
//         tree.root = new BinaryTreeNode(1);
//         tree.root.left = new BinaryTreeNode(2);
//         tree.root.right = new BinaryTreeNode(3);
//         tree.root.left.left = new BinaryTreeNode(4);
//         tree.root.left.right = new BinaryTreeNode(5);
        
//         System.out.print("Postorder Traversal: ");
//         tree.postorder(tree.root);
//         System.out.println();
//     }
// }

