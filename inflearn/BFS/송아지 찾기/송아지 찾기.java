//예시 입력 5 14
//예시 출력 3

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public int BFS(int s, int e) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        int[] dis = new int[]{1, -1, 5};
        int level = 0;
        Q.offer(s);
        list.add(s);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int tmp = Q.poll();
                if(tmp==e) return level;
                else
                    for (int x : dis) {
                        if (!list.contains(tmp + x)) {
                            list.add(tmp + x);
                            Q.offer(tmp + x);
                        }
                    }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(T.BFS(s, e));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(BFS(S, E));
    }

    public static int BFS(int s, int e) {
        final int INF = 10001;
        boolean[] visited = new boolean[INF];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        int cnt = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                int[] nexts = {current + 1, current + 5, current - 1};
                for (int next : nexts) {
                    if (next > 0 && next < INF && !visited[next]) {
                        if (next == e) return cnt;

                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            cnt++;
        }

        return cnt;
    }
}
