import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        Collections.sort(list);

        int sum = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + list.get(i);
            answer += sum;
        }

        System.out.println(answer);
    }
}