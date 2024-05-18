import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int val;
        Node lt, rt;

        public Node(int val) {
            this.val = val;
        }

        public void insert(int n) {
            if (n < this.val) {
                if (this.lt == null) this.lt = new Node(n);
                else this.lt.insert(n);
            } else {
                if (this.rt == null) this.rt = new Node(n);
                else this.rt.insert(n);
            }
        }
    }

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
        System.out.println(sb);
    }

    private static void postOrder(Node curr) {
        if (curr == null) return;
        postOrder(curr.lt);
        postOrder(curr.rt);
        sb.append(curr.val).append('\n');
    }
}
