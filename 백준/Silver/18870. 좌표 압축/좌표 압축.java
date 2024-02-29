import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        //좌표를 복사하고 정렬
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // 좌표와 압축 결과를 저장할 HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int compressIdx = 0;

        // 정렬된 좌표를 순회하며 압축 결과를 계산
        map.put(sortedArr[0], compressIdx++);
        for (int i = 1; i < N; i++) {
            if (sortedArr[i] != sortedArr[i - 1]) {
                map.put(sortedArr[i], compressIdx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Integer value = map.get(arr[i]);
            sb.append(value).append(' ');
        }

        System.out.println(sb);
    }

}



