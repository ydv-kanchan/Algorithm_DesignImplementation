import java.util.*;
public class TreefromarrayBySir {

    class Node {
        int data;
        Node left;
        Node right;
    }

    private Node root;

    Scanner sc = new Scanner(System.in);

    TreefromarrayBySir() {
        this.root = CreateTree();
    }

    public Node CreateTree() {
        int item = sc.nextInt(); //node's data
        Node newNode = new Node(); //data node
        newNode.data = item;
        boolean hasleft = sc.nextBoolean();
        if (hasleft == true) {
            newNode.left = CreateTree();
        }
        boolean hasright = sc.nextBoolean();
        if (hasright == true) {
            newNode.right = CreateTree();
        }
        return newNode;

    }
    
    public void Display() {
        Display(root);
    }

    public void Display(Node root) {
        if (root == null) {
            return;
        }

        String s = "";
        s= "<--"+ root.data+"-->";
        if(root.left != null){
            s = root.left.data+s;
        }
        else{
            s="."+s;
        }
        if(root.right!=null){
            s=s+root.right.data;
        }
        else{
            s=s+".";
        }
        System.out.println(s);
        Display(root.left);
        Display(root.right);
    }

    //preorder node left right
    //inorder: left node right
    //postorder left right node
    //levelorder level1, level2....

    public static void main(String[] args) {
        TreefromarrayBySir tree = new TreefromarrayBySir();
        //10 true 20 false false 40 true 40 true false false false false
        //output: print each node with left right 
        tree.Display();
        
    }
}
