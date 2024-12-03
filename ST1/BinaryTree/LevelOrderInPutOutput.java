import java.util.*;

public class LevelOrderInPutOutput {
    //node structure
    public static class Node {
        int data; //by defaul 0 in java
        Node left, right; //by default null in java

        Node(int d) {
            this.data = d;
        }
    }
    
    //build tree using levelorder input
    public static Node inputLevelWise() {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        int data = sc.nextInt(); // TAKE INPUT FOR DATA OF ROOT NODE
        root = new Node(data); // initialise root node with data
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node currentEle = q.poll();
            int leftData = sc.nextInt();
            int rightData = sc.nextInt();
            if (leftData != -1) {
                currentEle.left = new Node(leftData);
                q.add(currentEle.left);
            }
            if (rightData != -1) {
                currentEle.right = new Node(rightData);
                q.add(currentEle.right);
            }
        }
        sc.close();
        return root;
    }

    //print tree level wise
    public static void printLevelWise(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currentEle = q.poll();
            if (currentEle == null) {
                System.out.println();
                if (q.isEmpty())
                    return;
                else
                    q.add(null);
            }
            else {
                if (q.peek() == null) {
                    System.out.print(currentEle.data);
                }
                else {
                    System.out.print(currentEle.data + " ");
                }

                if (currentEle.left != null) 
                    q.add(currentEle.left);
                if(currentEle.right != null)
                    q.add(currentEle.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = inputLevelWise();
        printLevelWise(root);
    }
}