package study_03;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainC {
	static int row;
	static int col;
	static String arr[][];
	static int visied[][];
	static int px[] = { 1, 0, -1, 0 };
	static int py[] = { 0, 1, 0, -1 };
	static String value;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			row = sc.nextInt();
			value = sc.next();
			arr = new String[row][row];
			visied = new int[row][row];

			for (int i = 0; i < row; i++) {
				String next = sc.next();
				char[] charArray = next.toCharArray();
				for (int j = 0; j < row; j++) {
					arr[i][j] = String.valueOf(charArray[j]);
				}
			}
			int bfs = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < row; j++) {
					if (value.substring(0, 1).equals(arr[i][j])) {
						bfs = bfs(i, j, value.substring(0, 1));
						if (bfs == 1) {
							break;
						}
					}
				}
				if (bfs == 1) {
					break;
				}
			}

			System.out.println(String.format("#%d %d", t + 1, bfs));
		}
	}

	private static int bfs(int i, int j, String add) {
		if (value.equals(add)) {
			return 1;
		}

		visied[i][j] = 1;
		for (int n = 0; n < 4; n++) {
			int nr = i + py[n];
			int nc = j + px[n];
			if (nr >= 0 && nc >= 0 && nr < row && nc < row
					&& visied[nr][nc] == 0) {

				String string = arr[nr][nc];
				if (value.startsWith(add + string)) {
					if (bfs(nr, nc, add + string) == 1)
						return 1;
				}
			}
		}
		visied[i][j] = 0;
		return 0;
	}
}
