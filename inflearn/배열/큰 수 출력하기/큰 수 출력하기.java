import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<Integer> solution(int n, int[] arr){

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if(arr[i]>arr[i-1]) list.add(arr[i]);
        }

        return list;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt()+1;
        int[] arr = new int[n];

        arr[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) arr[i] = sc.nextInt();

        for (int x : T.solution(n, arr)) {
            System.out.print(x+" ");
        }
    }
}
