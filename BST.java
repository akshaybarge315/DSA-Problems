import java.util.*;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    // Build Tree
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    // Search in BST
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    // Delete a Node
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{ // Voila
            // Case I : No child (leaf node)
            if(root.left == null && root.right == null){
                return null;
            }

            // Case II : One Child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            // Case III : Two or both Children 
            Node IS = findInorderSucessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSucessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    

    // Print in range
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(k1 <= root.data && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(k1 > root.data){
            printInRange(root.right, k1, k2);
        }
        else{ // if( k2 < root.data)
            printInRange(root.left, k1, k2);
        }
    }


    // Root to leaf Path
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);  // Backtrack
    }

    // Validate BST
    public static boolean isValidateBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }

        else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidateBST(root.left, min, root) && isValidateBST(root.right, root, max);
    }

    // Mirror a BST
    public static Node createMirror(Node root){
        if(root == null){
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void main(String args[]){
        int[] values = {8, 5, 3, 1, 4, 6, 12, 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();

        // if(search(root, 5)){
        //     System.out.println("Found");
        // }else{
        //     System.out.println("Not found");
        // }

        // root = delete(root, 6);
        // inOrder(root);

        // printInRange(root, 5, 12);

        // printRoot2Leaf(root, new ArrayList<>());

        // if(isValidateBST(root, null, null)){
        //     System.out.println("Valid");
        // }else{
        //     System.out.println("Not valid");
        // }

        root = createMirror(root);
        inOrder(root);
    }
}
