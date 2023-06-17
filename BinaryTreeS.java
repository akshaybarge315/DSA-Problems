import java.util.*;
import java.util.LinkedList;

public class BinaryTreeS {
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

    // Height
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        int height = Math.max(lh, rh) + 1;
        return height;
    }

    // Count
    public static int count(Node root){
        if(root == null){
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    // Sum
    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int sum = leftSum + rightSum + root.data;
        return sum;
    }

    // Diameter : Approach 1 O(n^2)
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int leftDiam = diameter(root.left);
        int leftHeight = height(root.left);
        int rightDiam = diameter(root.right);
        int rightHeight = height(root.right);

        int selfDiam = leftHeight + rightHeight + 1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    // Diameter : Approach 2 O(n)
    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root){
        if(root == null){
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);

        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }
        

    // Subtree of Another Tree
    public static boolean isIdentical(Node node, Node SubRoot){
        if(node == null && SubRoot == null){
            return true;
        }else if(node == null || SubRoot == null || node.data != SubRoot.data){
            return false;
        } 
        
        // Non identical for left subtree
        if(!isIdentical(node.left, SubRoot.left)){
            return false;
        }

        // Non identical for right subtree
        if(!isIdentical(node.right, SubRoot.right)){
            return false;
        }
        return true;
    }

    public static boolean isTree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return isTree(root.left, subRoot) || isTree(root.right, subRoot);
    }


    
    // Top View of Tree
    static class Infoo{
        Node node;
        int hd;

        public Infoo(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        // Level order traversal
        Queue<Infoo> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>(); 

        int min=0, max=0;
        q.add(new Infoo(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Infoo curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                // First time hd is Occuring
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Infoo(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Infoo(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for(int i = min; i<= max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // System.out.println(height(root));

        // System.out.println(count(root));

        // System.out.println(sum(root));

        // System.out.println(diameter(root));
        
        // System.out.println(diameter2(root).diam);

        // System.out.println(isTree(root, subRoot));

        topView(root);

    }
}
