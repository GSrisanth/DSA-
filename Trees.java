
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




//Avl Tree

class Trees {
    
    class Node {
        int key, height;
        Node left, right;
        
        Node(int d) {
            key = d;
            height = 1;
        }
    }
    
    private Node root;
    
    // Get height of node
    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }
    
    // Get balance factor
    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }
    
    // Right rotate
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        
        // Perform rotation
        x.right = y;
        y.left = T2;
        
        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    // Left rotate
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        
        // Perform rotation
        y.left = x;
        x.right = T2;
        
        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    // Insert a key
    public void insert(int key) {
        root = insert(root, key);
    }
    
    private Node insert(Node node, int key) {
        // 1. Perform normal BST insertion
        if (node == null) return new Node(key);
        
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; // Duplicate keys not allowed
        }
        
        // 2. Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        // 3. Get balance factor
        int balance = getBalance(node);
        
        // 4. Check if unbalanced and perform rotations
        
        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        
        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        
        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    // Delete a key
    public void delete(int key) {
        root = delete(root, key);
    }
    
    private Node delete(Node root, int key) {
        // 1. Perform standard BST delete
        if (root == null) return root;
        
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                Node temp = (root.left != null) ? root.left : root.right;
                
                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                // Node with two children
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }
        
        if (root == null) return root;
        
        // 2. Update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        
        // 3. Get balance factor
        int balance = getBalance(root);
        
        // 4. Rebalance if needed
        
        // Left Left
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        
        // Left Right
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        // Right Right
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        
        // Right Left
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        
        return root;
    }
    
    // Find node with minimum value
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    // Search for a key
    public boolean search(int key) {
        return search(root, key);
    }
    
    private boolean search(Node node, int key) {
        if (node == null) return false;
        
        if (key == node.key) return true;
        else if (key < node.key) return search(node.left, key);
        else return search(node.right, key);
    }
    
    // Traversals
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }
    
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }
    
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }
    
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }
    
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }
    
    // Utility method to print tree (for debugging)
    public void printTree() {
        printTree(root, "", true);
    }
    
    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.key + 
                             "(h:" + node.height + ", b:" + getBalance(node) + ")");
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
    
    // MAIN METHOD 
    public static void main(String[] args) {
        Trees tree = new Trees();
        
        System.out.println("=== AVL Tree Demonstration ===");
        
        // Test insertion
        System.out.println("\n1. Inserting values: 10, 20, 30, 40, 50, 25");
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
        
        System.out.println("\nTree structure after insertion:");
        tree.printTree();
        
        System.out.println("\nTraversals:");
        System.out.print("Inorder: ");
        tree.inOrder();
        
        System.out.print("Preorder: ");
        tree.preOrder();
        
        System.out.print("Postorder: ");
        tree.postOrder();
        
        // Test search
        System.out.println("\n2. Search operations:");
        System.out.println("Search 30: " + tree.search(30));
        System.out.println("Search 100: " + tree.search(100));
        System.out.println("Search 25: " + tree.search(25));
        
        // Test deletion
        System.out.println("\n3. Deleting 10 and 40:");
        tree.delete(10);
        tree.delete(40);
        
        System.out.println("Tree structure after deletion:");
        tree.printTree();
        
        System.out.print("Inorder after deletion: ");
        tree.inOrder();
        
        // Test with more operations
        System.out.println("\n4. Inserting more values: 5, 15, 35");
        tree.insert(5);
        tree.insert(15);
        tree.insert(35);
        
        System.out.println("Final tree structure:");
        tree.printTree();
        
        System.out.print("Final inorder: ");
        tree.inOrder();
    }
}