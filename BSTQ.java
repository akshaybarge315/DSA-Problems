import java.util.*;
public class BSTQ {
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

    // Range Sum of BST
    public static int rangeSum(Node root, int l, int h){
        if(root == null){
            return 0;
        }

        if(l <= root.data && root.data <= h){
            return root.data + rangeSum(root.left, l, h) + rangeSum(root.right, l, h);
        }
        else if(l > root.data){
            return rangeSum(root.right, l, h);
        }else{
            return rangeSum(root.left, l, h);
        }
    }


    // Find the cloest element in BST
    // Return Difference
    public static int cloestElement(Node root, int target){
        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(target == root.data){
            return 0;
        }
        else if(target > root.data){
            return Math.min(Math.abs(root.data - target), cloestElement(root.right, target));
        }
        else{
            return Math.min(Math.abs(root.data - target), cloestElement(root.left, target));
        }
    }

    // Return value
    static int min_diff;
    static int min_Diff_key;
    public static void cloestEle(Node root, int target){
        if(root == null){
            return; 
        }

        if(root.data == target){
            min_Diff_key = root.data;
            return;
        }

        if(min_diff > Math.abs(root.data - target)){
            min_diff = Math.abs(root.data - target);
            min_Diff_key = root.data;
        }

        if(target < root.data){
            cloestEle(root.left, target);
        }else{
            cloestEle(root.right, target);
        }
    }

    public static int minDifference(Node root, int target){
        min_diff = Integer.MAX_VALUE;
        min_Diff_key = -1;

        cloestEle(root, target);
        return min_Diff_key;
    }


    // find Kth smallest element in Tree
    static int val;
    static int count;
    public static int kthSmallest(Node root, int k){
        val = 0;
        count = -1;
        getInorder(root, k);
        return val;
    }

    public static void getInorder(Node root, int k){
        if(root == null){
            return;
        }

        getInorder(root.left, k);
        count++;
        if(count == k){
            val = root.data;
            return;
        }
        getInorder(root.right, k); 
    }


    // Two sum BSTs
    static int countPairs(Node root1, Node root2, int x){
        if (root1 == null || root2 == null){
            return 0;
        }
        
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        
        Node top1, top2;
        int count = 0;
        
        while (true) {
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }
            
            while (root2 != null) {
                st2.push(root2);
                root2 = root2.right;
            }
            
            if (st1.empty() || st2.empty()){
                break;
            }
            top1 = st1.peek();
            top2 = st2.peek();
            
            if ((top1.data + top2.data) == x) {
                count++;
                st1.pop();
                st2.pop();
                root1 = top1.right;
                root2 = top2.left;
            }
            else if ((top1.data + top2.data) < x) {
                st1.pop();
                root1 = top1.right;
            }else {
                st2.pop();
                root2 = top2.left;
            }
        }
        return count;
    }


    // Maximium sum BST in Binary Tree
    static class Info{
        boolean isBST;
        int min;
        int max;
        int sum;
        public Info(boolean isBST, int min, int max, int sum){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public static Info maximumSumBST(Node root){
        if(root == null){
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        if(root.left == null && root.right == null){
            return new Info(true, root.data, root.data, Math.max(0, root.data));
        }

        Info leftp = maximumSumBST(root.left);
        Info rightp = maximumSumBST(root.right);

        if(!leftp.isBST || !rightp.isBST || root.left != null && leftp.max >= root.data || root.right != null && rightp.min <= root.data){
            return new Info(false, Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(leftp.sum, rightp.sum));
        }

        int currSum = leftp.sum + root.data + rightp.sum;

        int min = root.left == null ? root.data : leftp.min;
        int max = root.right == null ? root.data : rightp.max;

        return new Info(true, min, max, Math.max(currSum, Math.max(leftp.sum, rightp.sum)));
    }

    public static void main(String args[]){
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.right = new Node(20);

        // System.out.println(rangeSum(root, 5, 6));

        // System.out.println(cloestElement(root, 22));
        
        // System.out.println(minDifference(root, 22));

        // System.out.println(kthSmallest(root, 3));

        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);
        
        // System.out.println(countPairs(root1, root2, 16));

        Node root3 = new Node(5);
        root3.left = new Node(9);
        root3.right = new Node(2);
        root3.left.left = new Node(6);
        root3.left.left.left = new Node(8);
        root3.left.left.right = new Node(7);
        root3.right.right = new Node(3);

        Info result = maximumSumBST(root3);
        System.out.println(result.sum);
        
    }
}
