package study_03;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainA {
	static int min = Integer.MAX_VALUE;
	static int row;
	static int col;
	static int arr[][];
	static int qr[];
	static int qc[];
	static int from, to;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			row = sc.nextInt();
			col = sc.nextInt();
			arr = new int[row][col];
			qr = new int[1000];
			qc = new int[1000];
			from = -1;
			to = -1;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// for (int i = 0; i < row; i++) {
			// for (int j = 0; j < col; j++) {
			// System.out.print(arr[i][j] + " ");
			// }
			// System.out.println();
			// }
			min = Integer.MAX_VALUE;
			qr[++to] = 0;
			qr[to] = 0;
			bfs(0, 0, arr[0][0]);
			if (min == Integer.MAX_VALUE) {
				min = 0;
			}
			System.out.println(String.format("#%d %d", t + 1, min));
		}
	}

	private static void bfs(int i, int j, int k) {
		if (i + 1 == row && j + 1 == col) {
			if (min > k) {
				min = k;
			}
		}

		if (i + 1 < row && arr[i + 1][j] != 0) {
			bfs(i + 1, j, k + arr[i + 1][j]);
		}

		if (j + 1 < col && arr[i][j + 1] != 0) {
			bfs(i, j + 1, k + arr[i][j + 1]);
		}
	}
}
