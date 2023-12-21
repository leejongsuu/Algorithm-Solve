// 예시 입력 it is time to study
// 예시 출력 study

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] strArr = str.split(" ");

        int len = 0, location = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length() > len) {
                len = strArr[i].length();
                location = i;
            }
        }

        System.out.println(strArr[location]);
    }
}
