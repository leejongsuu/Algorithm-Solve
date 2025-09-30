import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            sb.append(checkPalindrome(0, str.length() - 1, str)).append('\n');
        }
        System.out.println(sb);
    }

    private static int checkPalindrome(int left, int right, String str) {
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                boolean isSkipLeft = isPalindrome(left + 1, right, str);
                boolean isSkipRight = isPalindrome(left, right - 1, str);
                if (isSkipLeft || isSkipRight) return 1;
                else return 2;
            }
        }

        return 0;
    }

    private static boolean isPalindrome(int left, int right, String str) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}