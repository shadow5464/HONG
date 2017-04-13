package study_03;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {

			int nodeCount = sc.nextInt();

			int MSTMAP[] = new int[nodeCount+1];

			int nodeMap[][] = new int[nodeCount + 1][nodeCount + 1];

			int ganCount = sc.nextInt();

			for (int i = 0; i < ganCount; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int cost = sc.nextInt();
				nodeMap[n1][n2] = cost;
				nodeMap[n2][n1] = cost;
			}

			int inputCount = 0;
			int sum = 0;
			MSTMAP[0] = 1;
			while (inputCount < nodeCount) {

				int minValue = Integer.MAX_VALUE;
				int minIndex = 99;
				for (int i = 0; i <= nodeCount; i++) {
					if (MSTMAP[i] == 1) {
						for (int j = 0; j <= nodeCount; j++) {
							if (nodeMap[i][j] != 0 && MSTMAP[j] == 0) {
								if (minValue > nodeMap[i][j]) {
									minValue = nodeMap[i][j];
									minIndex = j;
								}
							}
						}
					}
				}
				if (Integer.MAX_VALUE != minValue) {
					MSTMAP[minIndex] = 1;
					sum += minValue;
					inputCount++;
				}
			}

			System.out.println(String.format("#%d %d", t + 1, sum));

		}
	}

}
