import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    public int BFS(int s, int e){
        int level = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        int[] dis = new int[]{1, -1, 5};
        list.add(s);
        Q.offer(s);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i =0; i<len; i++){
                int p = Q.poll();
                if(p==e) return level;
                else
                    for(int x : dis){
                        if(!list.contains(p + x)){
                            list.add(p + x);
                            Q.offer(p + x);
                        }
                    }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s,e));
    }
}
