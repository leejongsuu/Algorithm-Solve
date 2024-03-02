import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Schedule implements Comparable<Schedule> {
    int s, e;

    public Schedule(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Schedule o) {
        if (o.s == this.s) return o.e - this.e;
        return o.s - this.s;
    }
}

public class Main {

    static ArrayList<Schedule> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Schedule(s, e));
        }

        System.out.println(solution(N));
    }

    private static int solution(int n) {

        Collections.sort(list);

        int cnt = 1;
        int max = list.get(0).s;

        for (int i = 1; i < n; i++) {
            if (list.get(i).e <= max) {
                cnt++;
                max = list.get(i).s;
            }
        }

        return cnt;
    }

}
