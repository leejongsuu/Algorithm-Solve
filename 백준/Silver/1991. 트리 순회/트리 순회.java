import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        char data;
        Node lt, rt;

        public Node(char data) {
            this.data = data;
            lt = rt = null;
        }
    }

    static StringBuilder sb = new StringBuilder();

    static class BinaryTree {
        Node root;

        void printPreorder(Node node) {
            if (node == null) {
                return;
            }
            sb.append(node.data);
            printPreorder(node.lt);
            printPreorder(node.rt);
        }

        void printInorder(Node node) {
            if (node == null) {
                return;
            }

            printInorder(node.lt);
            sb.append(node.data);
            printInorder(node.rt);
        }

        void printPostOrder(Node node) {
            if (node == null) {
                return;
            }
            printPostOrder(node.lt);
            printPostOrder(node.rt);
            sb.append(node.data);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BinaryTree tree = new BinaryTree();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char nodeValue = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if (i == 0) {
                tree.root = new Node(nodeValue);
            }

            Node currentNode = findNode(tree.root, nodeValue);
            if (leftChild != '.') {
                currentNode.lt = new Node(leftChild);
            }
            if (rightChild != '.') {
                currentNode.rt = new Node(rightChild);
            }
        }

        tree.printPreorder(tree.root);
        sb.append('\n');
        tree.printInorder(tree.root);
        sb.append('\n');
        tree.printPostOrder(tree.root);
        sb.append('\n');

        System.out.println(sb);
    }

    static Node findNode(Node root, char value) {

        if (root == null || root.data == value) {
            return root;
        }

        Node left = findNode(root.lt, value);
        if (left == null) {
            return findNode(root.rt, value);
        }
        return left;
    }
}