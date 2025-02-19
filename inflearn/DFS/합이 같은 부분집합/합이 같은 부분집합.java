//예시 입력
/*
6
1 3 5 6 7 10  
*/

//예시 출력 YES
import java.util.Scanner;

public class Main {

    static String answer = "NO";
    static int n, total = 0;
    static int[] arr;

    public void DFS(int L, int sum) {
        if (sum> (total-sum) || answer.equals("YES") ) return;
        if (L == n) {
            if(sum == (total-sum)) answer = "YES";
        }
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        T.DFS(0,0);
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean flag = false;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = Arrays.stream(arr).sum();

        DFS(0, 0, total);

        System.out.println(flag ? "YES" : "NO");
    }

    private static void DFS(int depth, int sum, int total) {
        if (flag || sum > (total - sum)) return;

        if (depth == N) {
            if (sum == (total - sum)) {
                flag = true;
            }
            return;
        }

        DFS(depth + 1, sum + arr[depth], total);
        DFS(depth + 1, sum, total);
    }
}
