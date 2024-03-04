import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    int key, abs;

    public Point(int key, int abs) {
        this.key = key;
        this.abs = abs;
    }

    @Override
    public int compareTo(Point o) {
        if (this.abs==o.abs) return this.key - o.key;
        return this.abs - o.abs;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Point> pQ = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (pQ.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pQ.poll().key).append('\n');
                }
            } else {
                pQ.offer(new Point(value, Math.abs(value)));
            }
        }

        System.out.println(sb);
    }


}
