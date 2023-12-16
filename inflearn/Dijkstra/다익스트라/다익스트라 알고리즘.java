//예시 입력
/*
6 9
1 2 12 // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
*/

//예시 출력 
/*
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static int n, m;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    public void dijk(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        dis[v] = 0;
        pQ.offer(new Edge(1, dis[v]));
        while (!pQ.isEmpty()) {
            Edge o = pQ.poll();
            int now = o.vex;
            int nowCost = o.cost;
            if(dis[now]<nowCost) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        T.dijk(1);
        for (int i = 2; i <= n; i++) {
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i+" : impossible");
        }
    }
}
