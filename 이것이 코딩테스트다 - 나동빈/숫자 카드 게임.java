public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] cards = new int[n][m];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
                if (cards[i][j] < min) { // 현재 행에서 '가장 작은 수' 찾기
                    min = cards[i][j];
                }
            }
            max = Math.max(max, min); // '가장 작은 수'들 중에서 가장 큰 수 찾기
        } 

        System.out.println(max);
    }
}
