import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //median과 mode는 ~4000 ~4000을 제외한 수로 초기화하면 됨.
        int median = 10000;
        int mode = 10000;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value + 4000]++;

            if (value > max) {
                max = value;
            }
            
            if (value < min) {
                min = value;
            }
        }

        //순회
        int count = 0; // 중앙값 빈도 누적 수
        int mode_max = 0; //최빈 값의 최댓값

        //이전의 동일한 최빈 값이 1번만 등장 했을 경우 true, 아닐 경우 false
        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {

            if (arr[i] > 0) {
                /*
                 * <중앙값 찾기>
                 *  누적 횟수가 전체 길이의 절반에 못 미친다면
                 */
                if (count < (n + 1) / 2) {
                    count += arr[i]; //i값의 빈도수를 count에 누적
                    median = i - 4000;
                }


                /*
                 *  <최빈값 찾기>
                 * 이전 최빈 값보다 현재 값의 빈도 수가 높을 경우
                 */
                if (mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true; //첫 등장이므로 true로 변경
                } else if (mode_max == arr[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }

            }
        }

        sb.append((int) Math.round((double) sum / n)).append('\n');
        sb.append(median).append('\n');
        sb.append(mode).append('\n');
        sb.append(max - min);
        System.out.println(sb);
    }
}