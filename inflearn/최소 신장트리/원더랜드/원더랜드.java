//예시 입력
/*
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
*/

//예시 출력 196

//크루스칼
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int v1, v2, cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static int[] unf;
    static ArrayList<Edge> list = new ArrayList<>();;

    public static int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static int solution() {

        int answer = 0;
        Collections.sort(list);

        for (Edge ob : list) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if (fv1 != fv2) {
                answer += ob.cost;
                Union(ob.v1, ob.v2);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge(a, b, c));
        }

        System.out.println(solution());
    }
}

//프림
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int vex, cost;

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

    static int[] ch;
    static ArrayList<ArrayList<Edge>> list = new ArrayList<>();

    public int dijk(int v) {

        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();

        pQ.offer(new Edge(v, 0));
        while (!pQ.isEmpty()) {

            Edge o = pQ.poll();
            int now = o.vex;
            if (ch[now] == 0) {
                ch[now] = 1;
                answer += o.cost;
                for (Edge ob : list.get(now)) {
                    if(ch[ob.vex]==0) pQ.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ch = new int[v + 1];
        for (int i = 0; i <= v; i++) list.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }

        System.out.println(T.dijk(1));
    }
}

// 프림
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int vex, cost;

        public Node(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, w));
            graph.get(e).add(new Node(s, w));
        }

        boolean[] ch = new boolean[V + 1];

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(1, 0));

        int answer = 0;
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int ev = current.vex;
            if (!ch[ev]) {
                ch[ev] = true;
                answer += current.cost;
                for (Node node : graph.get(ev)) {
                    if (!ch[node.vex]) priorityQueue.offer(node);
                }
            }
        }

        System.out.println(answer);
    }
}

// 크루스칼
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int v1, v2, cost;

        public Node(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        unf = new int[V + 1];
        for (int i = 1; i <= V; i++) unf[i] = i;

        List<Node> graph = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Node(v1, v2, cost));
        }

        int answer = 0;
        Collections.sort(graph);

        for (Node node : graph) {
            int fv1 = Find(node.v1);
            int fv2 = Find(node.v2);
            if (fv1 != fv2) {
                answer += node.cost;
                Union(node.v1, node.v2);
            }
        }

        System.out.println(answer);
    }

    private static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    private static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }
}
