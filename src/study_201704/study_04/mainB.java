package study_04;

import java.util.PriorityQueue;
import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainB {
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

			int used[][] = new int[N][N];
			int d[][] = new int[N][N];

			PriorityQueue<Point2> que = new PriorityQueue<Point2>();
			{
				int gap = map[0][1] - map[0][0];
				if (gap < 0) {
					gap = 0;
				}
				que.add(new Point2(0, 0, 0));
			}

			while (!que.isEmpty()) {
				Point2 start = que.poll();

				int row = start.y;
				int col = start.x;
				used[row][col] = 1;
				for (int i = 0; i < 4; i++) {
					int nr = row + yp[i];
					int nc = col + xp[i];

					if (nc >= 0 && nr >= 0 && nc < N && nr < N
							&& used[nr][nc] == 0) {

						int oldValue = value[nr][nc];
						int gap = map[nr][nc] - map[row][col];
						if (gap < 0) {
							gap = 0;
						}

						que.add(new Point2(nr, nc, gap + 1));
						int newValue = value[row][col] + gap + 1;
						if (oldValue > newValue || oldValue == 0) {
							value[nr][nc] = newValue;
						}
					}

				}

			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(value[i][j] + " ");
//
//				}
//				System.out.println();
//			}

			System.out.println(String.format("#%d %d", t + 1,
					value[N - 1][N - 1]));
		}
	}
}

class Point2 implements Comparable<Point2> {

	int x;
	int y;
	int value; // 형량

	public Point2(int y, int x, int value) {
		super();
		this.y = y;
		this.x = x;
		this.value = value;
	}

	@Override
	public int compareTo(Point2 target) {
		if (this.value > target.value) {
			return 1;
		} else if (this.value < target.value) {
			return -1;
		}
		return 0;
	}
}
