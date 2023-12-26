// 예시입력
/* 5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2 */

//예시 출력  4

//틀린 풀이
public int solution(int n, int[][] arr){
		
		int[] st = new int [n];
		
		for(int i=0; i<5; i++)
			for(int j=0; j<n; j++)
				for(int k=j+1; k<n; k++)
					if(arr[j][i]==arr[k][i]) {
						st[j]++;
						st[k]++;
					}
		
		int max=st[0];
		int location = 0;
		
		for(int i=1; i<n; i++)
			if(st[i]>max) {
				max=st[i];
				location=i;
			}
			
		return location+1;
	}

// 맞은 풀이
import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {

        int answer = 0;
        int max = Integer.MIN_VALUE;
        int[] st = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        st[i]++;
                        st[j]++;
                        break;
                    }
                }
            }
            if (st[i] > max) {
                max = st[i];
                answer = i + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}
