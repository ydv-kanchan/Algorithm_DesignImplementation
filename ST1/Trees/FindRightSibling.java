package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindRightSibling {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    //no parameters while building a tree
    public static Node buildTreeLevelWise() {
        //create empty root;
        Node root = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        root = new Node(data);//calling constructor of Node class
        Queue<Node> q = new LinkedList<>(); // q for nodes of tree
        q.add(root); //first node root 

        // while tree have any node in it ask for left and right of the node
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int leftData = sc.nextInt();
            int rightData = sc.nextInt();
            if (leftData != -1) {
                //make leftNode and add that leftNode to the 
                Node newNode = new Node(leftData);
                q.add(curr.left = newNode);
            }
            if (rightData != -1) {
                Node newNode = new Node(rightData);
                q.add(curr.right = newNode);
            }
        }
        sc.close();
        return root;
    }

    // public static void printlevelwise(Node root) {
    //     if (root == null)
    //         return;
    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);
    //     q.add(null);
    //     while (!q.isEmpty()) {
    //         Node curr = q.poll();
    //         if (curr == null) {
    //             System.out.println();
    //             if (!q.isEmpty())
    //                 q.add(null);
    //         }
    //         else {
    //             if (q.peek() == null) {
    //                 System.out.print(curr.data);
    //             }
    //             else {
    //                 System.out.print(curr.data + " ");
    //             }
    //             if (curr.left != null)
    //                 q.add(curr.left);
    //             if (curr.right != null)
    //                 q.add(curr.right);
    //         }
    //     }
    // }
    public static int rightsibling(Node root, int key) {
        return -1;
    }
    public static void main(String[] args) {
        Node root = null;
        root = buildTreeLevelWise();
        // printlevelwise(root);
        System.out.println(rightsibling(root, 5));
    }
}
