import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main {

    Node root;

    public int BFS(Node root) {

        Queue<Node> Q = new LinkedList<>();

        int level = 0;
        Q.offer(root);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node tmp = Q.poll();
                if (tmp.lt == null && tmp.rt == null) return level;
                else if(tmp.rt ==null) Q.offer(tmp.lt);
                else Q.offer(tmp.rt);
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args){

        Main T = new Main();

        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);

        System.out.println(T.BFS(T.root));
    }
}
