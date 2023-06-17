import java.util.*;

public class BinaryTreeQ {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Univalue or not
    public static boolean uniValue(Node root){
        if(root.left == null || root.right == null){
            return true;
        }

        boolean leftvalue = uniValue(root.left);
        boolean rightvalue = uniValue(root.right);

        if(root.data == root.left.data && leftvalue && root.data == root.right.data && rightvalue){
            return true;
        }

        return false;
    }


    // Invert Binary Tree
    public static Node invertTree(Node root){
        if(root == null){
            return null;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    // Delete leaf nodes with values as x
    public static Node deleteLeafNode(Node root, int x){
        if(root == null){
            return null;
        }

        root.left = deleteLeafNode(root.left, x);
        root.right = deleteLeafNode(root.right, x);

        if(root.left == null && root.right == null && root.data == x){
            return null;
        }

        return root;
    }


    // Find duplicate subtree
    static HashMap<String, Integer> m;

    static String inorder(Node node){
        if (node == null)
            return "";
        
        String str = "";
        str += inorder(node.left);
        str += Integer.toString(node.data);
        str += inorder(node.right);
        
        if (m.get(str) != null && m.get(str)==1 ){
            System.out.print( node.data + " ");
        }

        if (m.containsKey(str)){
            m.put(str, m.get(str) + 1);
        }else{
            m.put(str, 1);
        }
        return str;
    }

    static void printAllDups(Node root){
        m = new HashMap<>();
        inorder(root);
    }


    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(Node root){
        if(root == null){
            return 0;
        }

        int leftsum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);

        max = Math.max(max, leftsum + rightSum + root.data);
        
        return (Math.max(leftsum, rightSum) + root.data);
    }

    public static void main(String args[]){
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        // root.left.left = new Node(3);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        // root.right.left.left = new Node(3);


        // System.out.println(uniValue(root));

        // preOrder(root);
        // System.out.println();
        // invertTree(root);
        // preOrder(root);

        // deleteLeafNode(root, 3);
        // preOrder(root);

        // printAllDups(root);

        maxPathSum(root);
        System.out.println(max);
    }
}
