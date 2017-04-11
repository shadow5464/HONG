package study_02;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			int nodeCount = sc.nextInt();

			int last = 0;
			int c, p;
			int Q[] = new int[nodeCount + 2];

			for (int i = 0; i < nodeCount; i++) {
				c = ++last;
				p = c / 2;
				Q[c] = sc.nextInt();
				while (Q[p] > Q[c] && c > 1) {
					int temp = Q[p];
					Q[p] = Q[c];
					Q[c] = temp;
					c = p;
					p = p / 2;
				}
			}

			// for (int i = 0; i < nodeCount; i++) {
			// System.out.print(Q[i] + " ");
			// }
			// System.out.println();
			int sum = 0;
			int pIndex = nodeCount;
			while (true) {
				pIndex = pIndex / 2;
				if (pIndex == 0) {
					break;
				}
				sum += Q[pIndex];
			}
			System.out.println(String.format("#%d %d", t + 1, sum));
		}

	}
}
