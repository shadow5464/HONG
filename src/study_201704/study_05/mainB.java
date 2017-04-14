package study_05;

import java.util.PriorityQueue;
import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainB {
	static int N;
	static int gan;
	static int hip[];
	static int use[];
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			N = sc.nextInt() + 1;
			gan = sc.nextInt();

			hip = new int[N];
			use = new int[N];

			map = new int[N][N];
			for (int i = 0; i < gan; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int v = sc.nextInt();
				map[y][x] = v;
			}


//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}

			PriorityQueue<Point2> que = new PriorityQueue<Point2>();
				que.add(new Point2(0, 0));
			while (!que.isEmpty()) {
				Point2 poll = que.poll();
				int col = poll.x;
				use[col] = 1;
				for (int j = 0; j < N; j++) {
					if (map[col][j] != 0) {
						if (hip[j] < hip[col] + map[col][j]) {
							hip[j] = hip[col] + map[col][j];
							que.add(new Point2(j, 0));
						}
					}
				}
			}
			System.out.println(String.format("#%d %d", t + 1, hip[N - 1]));
		}
	}
}

class Point2 implements Comparable<Point2> {

	int x;
	int value; // 형량

	public Point2(int x, int value) {
		super();
		this.x = x;
		this.value = value;
	}

	@Override
	public int compareTo(Point2 target) {
		if (this.value > target.value) {
			return -1;
		} else if (this.value < target.value) {
			return 1;
		}
		return 0;
	}

}