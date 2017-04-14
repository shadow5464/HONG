package study_05;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 1; t <= testCase; t++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			long arr[][] = new long[n + 1][n + 1];
			arr[0][0] = 1;
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					if (j == 0) {
						arr[i][j] = 1;
						continue;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
				}
			}

//			for (int i = 0; i <= n; i++) {
//				for (int j = 0; j <= n; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
			System.out.println(String.format("#%d %d", t, arr[n][n - x]));
		}

	}
}
