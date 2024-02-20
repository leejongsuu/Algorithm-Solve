import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] arr = new boolean[21];

    static void add(int x) {
        if (!arr[x]) arr[x] = true;
    }

    static void remove(int x) {
        if (arr[x]) arr[x] = false;
    }

    static int check(int x) {
        if (arr[x]) return 1;
        else return 0;
    }

    static void toggle(int x) {
        arr[x] = !arr[x];
    }

    static void all() {
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) arr[i] = true;
        }
    }

    static void empty() {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]) arr[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "add":
                    add(Integer.parseInt(input[1]));
                    break;
                case "remove":
                    remove(Integer.parseInt(input[1]));
                    break;
                case "check":
                    sb.append(check(Integer.parseInt(input[1]))).append('\n');
                    break;
                case "toggle":
                    toggle(Integer.parseInt(input[1]));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}