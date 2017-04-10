package study_01;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainE {

	public static int used[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	public static int p[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	static int min = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int inputCount = sc.nextInt();
		for (int c = 0; c < inputCount; c++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 10; i++) {
				used[i] = 0;
				a[i] = i;
				p[i] = i;
			}

			min = 99999;
			aaa(arr, 0, N);
			System.out.println("#" + (c + 1) + " " + min);

			// for (int i = 0; i < N; i++) {
			// for (int j = 0; j < N; j++) {
			// System.out.print(arr[i][j]);
			// }
			// System.out.println();
			// }
		}
	}

	public static void aaa(int arr[][], int dep, int n) {

		if (dep == n) {
			int v = 0;
			for (int i = 0; i < n; i++) {
				v += arr[i][p[i]];
				// System.out.print(p[i]);
			}
			// System.out.println(v);
			if (min > v) {
				min = v;
			}
		}

		for (int i = 0; i < n; i++) {
			if (used[i] == 0) {
				used[i] = 1;
				p[dep] = a[i];
				aaa(arr, dep + 1, n);
				used[i] = 0;
			}
		}
	}
}
