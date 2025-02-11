//예시 입력
/*
7 4
20 12 20 10 23 17 10
*/

//예시 출력 3 4 4 3

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public ArrayList<Integer> solution(int n, int m, int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        int rt;
        for (rt = 0; rt < m - 1; rt++) map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

        for (int lt = 0; rt < n; rt++, lt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if(map.get(arr[lt])==0) map.remove(arr[lt]);
        }

        return answer;
    }

    public static void main(String[] args){

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for(int x : T.solution(n, m, arr)) System.out.print(x+" ");
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        int rt = 0;
        for (; rt < K; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
        }
        sb.append(map.size()).append(' ');

        for (int lt = 0; rt < N; lt++, rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            int value = map.get(arr[lt]);
            if (value > 1) {
                map.put(arr[lt], --value);
            } else {
                map.remove(arr[lt]);
            }
            sb.append(map.size()).append(' ');
        }

        System.out.println(sb);
    }
}
