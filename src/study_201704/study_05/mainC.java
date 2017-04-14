package study_05;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainC {
	static int map[];
	static int value[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {

			int n = sc.nextInt();
			value = new int[n + 1][n + 1];
			map = new int[n * 2];
			int addIndex = 0;
			boolean isValidation = true;
			for (int i = 0; i < n; i++) {

				int from = sc.nextInt();
				int to = sc.nextInt();

				if (i == 0) {
					map[addIndex++] = from;
				} else if (map[addIndex - 1] != from) {
					System.out.println(String.format("#%d %d", t + 1, 0));
					isValidation = false;
					break;
				}
				map[addIndex++] = to;

			}
			if (!isValidation) {
				continue;
			}
//			for (int j = 0; j < addIndex; j++) {
//				System.out.print(map[j]);
//			}

			int j = 0;
			for (int L = 1; L < n; L++) {
				for (int i = 1; i <= n + L; i++) {
					if (i + L <= n) {
						j = i + L;
						if (i == j) {
							value[i][j] = 0;
						} else if (i > j) {
							value[i][j] = -1;
						} else {
							int min = Integer.MAX_VALUE;
							for (int k = i; k < j; k++) {
								int temp = value[i][k] + value[k + 1][j]
										+ map[i - 1] * map[k] * map[j];
								if (min > temp) {
									min = temp;
								}
							}
							value[i][j] = min;
						}
					}
				}
			}

			System.out.println(String.format("#%d %d", t + 1, value[1][n]));
		}
	}
}
