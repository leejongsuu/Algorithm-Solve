import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] nInput = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nInput[i]);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        String[] mInput = br.readLine().split(" ");


        for (int i = 0; i < m; i++) {
            if (Arrays.binarySearch(arr, Integer.parseInt(mInput[i])) >= 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            } 
        }

        System.out.println(sb);
    }
}