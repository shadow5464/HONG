package study_03;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainB {
	static int min = Integer.MAX_VALUE;
	static int row;
	static int col;
	static int arr[][];
	static int visied[][];
	static int qr[];
	static int qc[];
	static int from, to;
	static int py[] = { 0, 1, 0, -1 };
	static int px[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			row = sc.nextInt();
			// col = sc.nextInt();
			arr = new int[row][row];
			visied = new int[row][row];
			qr = new int[100000];
			qc = new int[100000];
			from = -1;
			to = -1;
			min = 0;
			for (int i = 0; i < row; i++) {
				String next = sc.next();
				char[] charArray = next.toCharArray();
				for (int j = 0; j < row; j++) {
					arr[i][j] = Integer.valueOf(next.substring(j, j + 1));
				}
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < row; j++) {
					if (arr[i][j] == 2) {
						qr[++to] = i;
						qc[to] = j;
						bfs(i, j);
						break;
					}
				}
				// System.out.println();
			}

			System.out.println(String.format("#%d %d", t + 1, min));
		}
	}

	private static void bfs(int i, int j) {
		if (arr[i][j] == 3) {
			min = 1;
			return;
		}
		if (min == 1) {
			return;
		}
		visied[i][j] = 1;
		for (int n = 0; n < 4; n++) {
			int nr = i + py[n];
			int nc = j + px[n];
			int b = arr[nr][nc];

			if (b != 1 && visied[nr][nc] == 0) {
				bfs(nr, nc);
			}
		}

	}
}
