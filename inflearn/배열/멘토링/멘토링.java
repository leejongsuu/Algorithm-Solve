//예시 입력
/*
4 3
3 4 1 2
4 3 2 1
3 1 4 2
*/

//예시 출력 3

//풀이 1
import java.util.Scanner;

class Main {
	
	public int solution(int n, int m, int[][] arr){
		
		int answer =0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int cnt =0;
				for(int k=0; k<m; k++) {
					int pi=0, pj=0;
					for(int s=0; s<n; s++) {
						if(arr[k][s]==i) pi=s;
						if(arr[k][s]==j) pj=s;
					}
					if(pi<pj) cnt++;
				}
				if(cnt==m)
					answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				arr[i][j]=sc.nextInt();
		
		System.out.println(T.solution(n, m ,arr));
	}
}

//풀이 2
import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[][] arr) {

        int answer = n * n - n;
        int[][] number = new int[n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    if (number[arr[i][j] - 1][arr[i][k] - 1] == 0) {
                        number[arr[i][j] - 1][arr[i][k] - 1] = 1;
                        answer--;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

        System.out.println(T.solution(n, m, arr));
    }
}


// 풀이 3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = N * (N - 1);
        boolean[][] flag = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (!flag[arr[i][k]][arr[i][j]]) {
                        flag[arr[i][k]][arr[i][j]] = true;
                        answer--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

