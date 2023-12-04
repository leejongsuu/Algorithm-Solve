import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}

public class Main {
    Node root;
    public int DFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++){
                Node temp = Q.poll();
                if(temp.lt==null & temp.rt == null) return level;
                if(temp.lt !=null) Q.offer(temp.lt);
                if(temp.rt !=null) Q.offer(temp.rt);
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(tree.root));
    }
}
