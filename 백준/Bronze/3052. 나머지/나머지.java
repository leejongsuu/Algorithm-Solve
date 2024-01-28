import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a = new int[10];
		int num = 0;
		for (int i = 0; i < 10; i++)
			a[i] = s.nextInt() % 42;
		for (int i = 0; i < 10; i++) {
			for (int j = 9; j > i; j--)
				if (a[i] == a[j]) {
					num++;
					break;
				}
		}
		System.out.println(10 - num);
	}
}