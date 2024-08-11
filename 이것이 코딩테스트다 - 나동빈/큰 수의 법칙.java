public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums); // 입력 받은 수들 정렬하기
        int first = nums[n - 1]; // 첫 번째로 가장 큰 수
        int second = nums[n - 2]; // 두 번째로 가장 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k;
        cnt += (m % (k + 1));

        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second;

        System.out.println(result);
    }
}
