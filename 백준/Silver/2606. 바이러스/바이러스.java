import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    static int Find(int v) {
        if (v == arr[v]) return v;
        else return arr[v] = Find(arr[v]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            arr[fa] = fb;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) arr[i] = i;

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            Union(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (Find(1) == Find(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}