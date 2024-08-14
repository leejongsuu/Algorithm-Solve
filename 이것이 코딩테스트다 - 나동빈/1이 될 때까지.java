public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (n != 1) {
            if (n % k == 0) { // n을 k로 나눌 수 있는 경우
                n /= k;
            } else {
                n -= 1; // 그렇지 못한 경우 선택지는 -1 밖에 없음.
            }
            cnt++;
        }

        System.out.println(cnt);

    }
}
