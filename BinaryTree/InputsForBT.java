import java.util.*;

public class InputsForBT {

    //Node structure
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            // left = right = null;/
        }
    }

    //buildtree Level-wise
    public static Node buildTreeLevelWise() {
        Node root = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        root = new Node(data);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (l != -1) {
                Node newNode = new Node(l);
                curr.left = newNode;
                q.add(newNode);
            }

            if (r != -1) {
                Node newNode = new Node(r);
                curr.right = newNode;
                q.add(newNode);
            }
        }
        sc.close();
        return root;
    }

    public static void levelWisePrint(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                System.out.println();
                if (q.isEmpty())
                    return;
                else
                    q.add(null);
            }
            else {
                if (q.peek() == null) {
                    System.out.print(curr.data);
                }
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
        Node root = buildTreeLevelWise();
        levelWisePrint(root);
    }
}
