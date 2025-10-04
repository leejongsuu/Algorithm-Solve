import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int result = checkPalindrome(input);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static int checkPalindrome(String str) {
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) {
                boolean leftSkip = isPseudoPalindrome(lt + 1, rt, str);
                boolean rightSkip = isPseudoPalindrome(lt, rt - 1, str);
                if (leftSkip || rightSkip) {
                    return 1;
                } else {
                    return 2;
                }
            }
            lt++;
            rt--;
        }
        return 0;
    }

    public static boolean isPseudoPalindrome(int lt, int rt, String str) {
        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) {
                return false;
            }
            lt++;
            rt--;
        }
        return true;
    }
}