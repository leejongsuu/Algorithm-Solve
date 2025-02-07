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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        int before = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num > before) {
                sb.append(num).append(' ');
            }
            before = num;
        }

        System.out.println(sb);
    }
}
