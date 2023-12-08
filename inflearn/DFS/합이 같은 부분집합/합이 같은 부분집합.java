//예시 입력
/*
6
1 3 5 6 7 10  
*/

//예시 출력 YES
import java.util.Scanner;

public class Main {
    static String answer = "NO";
    static int n, total=0;
    static int[] arr;

    public void DFS(int L, int sum){
        if(answer.equals("YES")) return;
        if(sum>total/2) return;
        if(L==n){
            if((total-sum)==sum){
                answer = "YES";
            }
        } else{
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
