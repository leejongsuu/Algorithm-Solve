import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.y==o.y) return this.x - o.x;
        else return this.y - o.y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Point> list = new ArrayList<>();
        String[] input;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            list.add(new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for (Point p : list) {
            sb.append(p.x).append(" "+ p.y).append('\n');
        }

        System.out.println(sb);
    }
}