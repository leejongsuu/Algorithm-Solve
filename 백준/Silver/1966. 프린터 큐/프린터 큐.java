import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Note {
    int id, pt;

    public Note(int id, int pt) {
        this.id = id;
        this.pt = pt;
    }
}

public class Main {

    public static int solution(int n, int m, String[] priority) {

        Queue<Note> Q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Q.offer(new Note(i, Integer.parseInt(priority[i])));
        }

        int cnt = 1;
        while (!Q.isEmpty()) {
            Note temp = Q.poll();
            boolean check = true;

            for (Note nQ : Q) {
                if (nQ.pt > temp.pt) {
                    Q.offer(temp);
                    check = false;
                    break;
                }
            }

            if (check) {
                if (temp.id == m) {
                    return cnt;
                } else {
                    cnt++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String[] input;
        String[] priority;

        for (int i = 0; i < T; i++) {
            input = br.readLine().split(" ");
            priority = br.readLine().split(" ");

            sb.append(solution(Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]), priority)).append('\n');
        }

        System.out.println(sb);
    }
}