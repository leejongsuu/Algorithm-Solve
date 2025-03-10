// 예시입력
/*
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1
*/

//예시 출력 8

import java.util.Scanner;

class Main {
	
	public int solution(int n, int m, int[] arr){
		
		int answer=0, cnt=0, lt=0;
		for(int rt=0; rt<n; rt++) {
			if(arr[rt]==0) {
				cnt++;
				while(cnt>m) {
					if(arr[lt]==0) cnt--;
					lt++;
			}
		}
		answer=Math.max(answer, rt-lt+1);
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
			
		System.out.println(T.solution(n,m,arr));
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, k, arr);
        System.out.println(result);
    }

    public static int solution(int n, int k, int[] arr) {

        int result = Integer.MIN_VALUE;

        for (int lt = 0, rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                k--;
                while (k < 0) {
                    if (arr[lt] == 0) {
                        k++;
                    }
                    lt++;
                }
            }
            result = Math.max(result, rt - lt + 1);
        }

        return result;
    }
}
