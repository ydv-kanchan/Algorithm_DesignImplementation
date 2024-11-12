package BinaryTrees;
import java.util.*;
/*
1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
1
2 3
4 5 6
 */

public class ImplementPrintLevelOrder {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }
    
    public static Node buildTreeLevelWise() {
        Node root = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        root = new Node(data);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int leftchild = sc.nextInt();
            int rightchild = sc.nextInt();
            if (leftchild != -1) {
                Node newNode = new Node(leftchild);
                curr.left = newNode;
                q.add(curr.left);
            }
            if (rightchild != -1) {
                Node newNode = new Node(rightchild);
                curr.right = newNode;
                q.add(curr.right);
            }
        }
        sc.close();
        return root;
    }
    
    public static void printlevelwise(Node root) {
        if (root == null)
            return; //tree is empty
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                if (!q.isEmpty())
                    q.add(null);
            }
            else {
                if (q.peek() == null)
                    System.out.print(curr.data);
                else {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }
    public static void main(String[] args) {
        // Node root = new Node(30);
        // System.out.println(root.data);
        // System.out.println(root.left);
        // System.out.println(root.right);
        // Node root = buildTreeLevelWise();
        // Node root2 = buildTree2();
        // printlevelwise(root2);
    }
}