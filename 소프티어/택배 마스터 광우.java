import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int minValue = Integer.MAX_VALUE;
    static int[] rail, arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rail = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            rail[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);

        System.out.println(minValue);
    }

    private static void DFS(int L) {
        if(L == N) {
            int result = BFS(arr);
            minValue = Math.min(minValue, result);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[L] = rail[i];
                DFS(L+1);
                visited[i] = false;
            }
        }
    }

    private static int BFS(int[] arr) {

        Queue<Integer> queue = new LinkedList<>();
        for(int i : arr) {
            queue.add(i);
        }

        int acc, sum, cnt;
        acc = sum = cnt = 0;
        while(cnt < K) {
            int now = queue.peek();
            if(sum + now <= M) {
                queue.add(queue.poll());
                sum += now;
            } else {
                acc += sum;
                sum = 0;
                cnt++;
            }
        }

        return acc;
    }
}
