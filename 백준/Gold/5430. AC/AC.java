import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            // [,],"," 제거해줌.
            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            ACFunction(p, deque);
        }

        System.out.println(sb);
    }

    private static void ACFunction(String p, ArrayDeque<Integer> deque) {

        //방향 상태 변수
        boolean isRight = true;

        for (char c : p.toCharArray()) {

            if (c == 'R') {
                isRight = !isRight; //방향을 바꿔줌
                continue;
            }

            //D의 경우
            if (deque.isEmpty()) { // D인데 덱이 비어있으면 error을 출력하도록 하고 함수 종료
                sb.append("error\n");
                return;
            }
            if (isRight) {
                deque.pollFirst();
            } else {
                deque.pollLast();
            }
        }

        //모든 함수들이 정상적으로 작동했다면 덱의 남은 요소들을 출력 형식에 맞춰줌
        formmated(deque, isRight);
    }

    private static void formmated(ArrayDeque<Integer> deque, boolean isRight) {

        sb.append("[");

        if (!deque.isEmpty()) {

            if (isRight) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append("]").append('\n');
    }
}

