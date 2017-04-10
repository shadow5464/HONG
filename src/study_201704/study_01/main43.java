package study_01;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class main43 {
	public static int c[];
	public static int a[] = { 1, 2, 3};

	public static void main(String[] args) {
		c = new int[3];
		aaa(3,3,3);
	}

	public static void aaa(int n, int k, int m) {

		if (k == 0) {
			for (int i = 0; i < m; i++) {
				System.out.print(c[i]);
			}
			System.out.println();
		} else if (n < k) {
			return;
		} else {
			c[k - 1] = a[n - 1];
			aaa(n - 1, k - 1, m);
			aaa(n - 1, k, m);
		}
	}
}
