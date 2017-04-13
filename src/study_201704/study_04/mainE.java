package study_04;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainE {
	static int R;
	static int C;
	static int map[][];
	static int value[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new int[R + 1][C + 1];
			value = new int[R + 1][C + 1];

			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			value[1][1] = map[1][1];

			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (i == 1 && j == 1) {
						continue;
					}

					if (map[i][j] == 0) {
						value[i][j] = -1;
						continue;
					}
					// int min = value[i - 1][j];
					// int l2 = value[i][j - 1];
					int min = i == 1 ? 9999 : value[i - 1][j];
					int l2 = j == 1 ? 9999 : value[i][j - 1];

					if (min == -1 && l2 == -1) {
						value[i][j] = -1;
						continue;
					}
					if (min > l2 && l2 != -1) {
						min = l2;
					} else if (min == -1) {
						min = l2;
					}

					value[i][j] = min + map[i][j];
				}
			}
//			for (int i = 1; i <= R; i++) {
//				for (int j = 1; j <= C; j++) {
//					System.out.print(value[i][j] + " ");
//
//				}
//				System.out.println();
//			}

			System.out.println(String.format("#%d %d", t + 1,
					value[R][C] == -1 ? 0 : value[R][C]));
		}
	}
}
