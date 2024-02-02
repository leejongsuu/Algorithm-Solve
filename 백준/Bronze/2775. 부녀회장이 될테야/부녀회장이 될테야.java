import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int floor, roomNum;
    static int[][] dy = new int[15][15];

    public int DFS(int f, int r) {

        if (dy[f][r] != 0) {
            return dy[f][r];
        } else {
            return dy[f][r] = DFS(f, r - 1) + DFS(f - 1, r);
        }
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 14; i++){
            dy[0][i] = i;
            dy[i][1] = 1;
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            floor = Integer.parseInt(br.readLine());
            roomNum = Integer.parseInt(br.readLine());

            System.out.println(T.DFS(floor, roomNum));
        }
    }
}