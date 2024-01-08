// 예시 입력 
/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
*/

//예시 출력
/*
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
*/


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] ch;
    static int[][] graph;

    public void BFS(int v) {

        Queue<Integer> Q = new LinkedList<>();
        int level = 1;
        Q.offer(v);

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int nv = Q.poll();
                for (int j = 2; j <= n; j++) {
                    if (graph[nv][j] == 1 && ch[j] == 0) {
                        Q.offer(j);
                        ch[j] = level;
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n + 1];
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        T.BFS(1);
        for (int i = 2; i <= n; i++) System.out.println(i + " : " + ch[i]);
    }
}
