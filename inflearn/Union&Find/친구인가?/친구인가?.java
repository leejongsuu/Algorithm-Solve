//예시 입력
/*
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8
*/

//예시 출력 NO

import java.util.Scanner;

public class Main {
    static int[] unf;

    public static int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(Find(a)==Find(b)) System.out.println("YES");
        else System.out.println("NO");
    }
}
