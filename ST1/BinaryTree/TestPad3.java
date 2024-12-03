import java.util.*;

public class TestPad3 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            left = right = null;
        }
    }
    public static Node buildtree(int[] arr, int n) {
        Node root = null;
        root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (i<n) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;
            if (i<n) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void oddlevelprint(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                level++;
                if (!q.isEmpty())
                    q.add(null);
            } else {
                if (level % 2 != 0) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim()); // no of nodes
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = buildtree(arr, n);
        oddlevelprint(root);
        sc.close();
    }
}
