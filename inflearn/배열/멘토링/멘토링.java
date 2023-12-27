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
