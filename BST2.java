import java.util.ArrayList;

public class BST2 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Sorted Array to balanced BST
    public static Node createBST(int arr[], int st, int end){
        if(st > end){
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    // Convert BST to Balanced BST
    public static void inOrder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        inOrder(root.left, inorder);
        inorder.add(root.data);
        inOrder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end){  //Sorted Array to balanced BST
        if(st > end){
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);

        return root;
    }

    public static Node balancedBST(Node root){
        // InOrder Sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);

        // Sorted AL -> Balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }


    // Size of largest BST in BT
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    static int maxBST = 0;

    public static Info largestBST(Node root1){
        if(root1 == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root1.left);
        Info rightInfo = largestBST(root1.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root1.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root1.data, Math.max(leftInfo.max, rightInfo.max));

        if(leftInfo.max >= root1.data || rightInfo.min <= root1.data){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }


    // Merge 2 BSTs
    public static void getInorderSeq(Node root, ArrayList<Integer> arr){ // get Inorder Suquence
        if(root == null){
            return;
        }

        getInorderSeq(root.left, arr);
        arr.add(root.data);
        getInorderSeq(root.right, arr);
    }

    public static Node createMBST(ArrayList<Integer> arr, int s, int e){  // create BST
        if(s > e){
            return null;
        }

        int mid = (s + e)/2;
        Node root = new Node(arr.get(mid));
        root.left = createMBST(arr, s, mid-1);
        root.right = createMBST(arr, mid+1, e);
        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2){
        // step 1 : Getting Inorder seq
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorderSeq(root1, arr1);

        // step 2 : Getting Inorder seq
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorderSeq(root2, arr2);

        // Step 3 : Merge Arr1 and Arr2
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i =0;
        int j =0;
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) < arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i < arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        // Step 4 : create merge BST
        Node root = createMBST(finalArr, 0, finalArr.size()-1);
        return root;
    }

    public static void main(String args[]){
        // int arr[] = {3, 5, 6, 8, 10, 11, 12};
    /*
                          8
                       /    \
                      5     11
                     / \   /  \
                    3   6 10    12
    */

    // Node root = createBST(arr, 0, arr.length-1);
    // preOrder(root);

    Node root = new Node(8);
    root.left = new Node(6);
    root.left.left = new Node(5);
    root.left.left.left = new Node(3);

    root.right = new Node(10);
    root.right.right = new Node(11);
    root.right.right.right = new Node(12);

    // root = balancedBST(root);
    // preOrder(root);

    
    Node root1 = new Node(50);
    root1.left = new Node(30);
    root1.left.left = new Node(5);
    root1.left.right = new Node(20);

    root1.right = new Node(60);
    root1.right.left = new Node(45);
    root1.right.right = new Node(70);
    root1.right.right.left = new Node(65);
    root1.right.right.right = new Node(80);

    // Info info = largestBST(root1);
    // System.out.println("Size of largest BST is " + maxBST);

    Node root2 = new Node(2);
    root2.left = new Node(1);
    root2.right = new Node(4);

    Node root3 = new Node(9);
    root3.left = new Node(3);
    root3.right = new Node(12);

    Node root4 = mergeBSTs(root2, root3);
    preOrder(root4);
    }
}
