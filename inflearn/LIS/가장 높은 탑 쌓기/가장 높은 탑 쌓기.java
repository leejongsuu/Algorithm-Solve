//예시 입력
/*
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2
*/
// 예시 출력 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class brick implements Comparable<brick> {
    int st, ht, wt;

    public brick(int st, int ht, int wt) {
        this.st = st;
        this.ht = ht;
        this.wt = wt;
    }

    @Override
    public int compareTo(brick o) {
        return o.st - this.st;
    }
}

public class Main {

    static int n;
    static int[] di;
    static ArrayList<brick> list = new ArrayList<>();

    public int solution() {

        Collections.sort(list);
        di[0] = list.get(0).ht;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).wt>list.get(i).wt && di[j]>max) max = di[j];
            }
            di[i] = max + list.get(i).ht;
        }

        return Arrays.stream(di).max().getAsInt();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        di = new int[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new brick(s, h, w));
        }

        System.out.println(T.solution());
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Brick implements Comparable<Brick> {
        int extent, height, weight;

        public Brick(int extent, int height, int weight) {
            this.extent = extent;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.extent - this.extent;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Brick[] bricks = new Brick[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bricks[i] = new Brick(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(bricks);

        int maxHeight = 0;

        int[] dp = new int[N];
        dp[0] = bricks[0].height;

        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks[j].extent > bricks[i].extent && bricks[j].weight > bricks[i].weight && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + bricks[i].height;
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        System.out.println(maxHeight);
    }
}
