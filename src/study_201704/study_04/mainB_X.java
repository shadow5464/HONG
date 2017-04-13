package study_04;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainB_X {
	static int N;
	static int map[][];
	static int value[][];
	static int xp[] = { 0, 0, 1, -1 };
	static int yp[] = { 1, -1, 0, 0 };
	static Point que[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			value = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			bfs();
			System.out.println(String.format("#%d %d", t + 1,
					value[N - 1][N - 1]));
		}
	}

	private static void bfs() {
		que = new Point[10000000];

		int from = -1;
		int to = -1;
		que[++to] = new Point(0, 0);
		while (to != from) {
			Point point = que[++from];
			for (int i = 0; i < 4; i++) {
				int nc = point.c + xp[i];
				int nr = point.r + yp[i];

				if (nc >= 0 && nr >= 0 && nc < N && nr < N) {
					int hightGap = map[nr][nc] - map[point.r][point.c];
					if (hightGap < 0) {
						hightGap = 0;
					}
					int v = value[point.r][point.c] + hightGap + 1;
					if (value[nr][nc] > v || value[nr][nc] == 0) {
						value[nr][nc] = v;
						que[++to] = new Point(nc, nr);
					}
				}
			}
		}
	}
}

class Point {
	public int c;
	public int r;

	public Point(int c, int r) {
		super();
		this.c = c;
		this.r = r;
	}

}

