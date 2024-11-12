import java.util.*;

public class TestPad1 {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node() {
            data = 0;
        }
        public Node(int d) {
            data = d;
        }
    }
    
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    static Node buildTree(int arr[], int n) {
        Node root = null;
        if (n <= 0)
            return null; //no elements in array
        root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < n && !q.isEmpty()) {
            Node currentEle = q.poll();
            if (i < n) {
                currentEle.left = new Node(arr[i]);
                q.add(currentEle.left);
            }
            i++;
            if (i < n) {
                currentEle.right = new Node(arr[i]);
                q.add(currentEle.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        //by taking n and each element of array as string
        int n1, i1;
        Scanner s = new Scanner(System.in);
        n1 = Integer.parseInt(s.nextLine().trim());
        int[] arr1 = new int[n1];
        for (i1 = 0; i1 < n1; i1++) {
            arr1[i1] = Integer.parseInt(s.nextLine().trim());
            // arr1[i1] = s.nextInt();
        }
        Node root1 = buildTree(arr1, n1);
        inOrder(root1);
        s.close();
        
        //by taking n and each element of array as int
        int n, i;
        n = s.nextInt();
        int[] arr = new int[n];
        for (i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        Node root = buildTree(arr, n);
        inOrder(root);
        s.close();
    }
}
