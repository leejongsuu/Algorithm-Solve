//예시 입력
/*
8
5 3 7 8 6 2 9 4
*/

//예시 출력 4

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr, dy;

    public int solution(int n) {

        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
        }
        return Arrays.stream(dy).max().getAsInt();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n));
    }
}

//풀이 2
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public int solution(int[] arr) {

        int[] lis = new int[arr.length];
        int len = 0;  // LIS의 길이

        for (int num : arr) {
            int index = Arrays.binarySearch(lis, 0, len, num);

            // binarySearch 반환 값이 음수일 때는 적절한 위치를 찾지 못한 경우
            if (index < 0) {
                index = -(index + 1);
            }

            // LIS를 갱신
            lis[index] = num;

            // 현재 원소가 LIS의 끝에 추가될 경우 길이 증가
            if (index == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(arr));
    }
}
