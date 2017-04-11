package study_02;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainA {

	static int par[];
	static int ch1[];
	static int ch2[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			int nodeCount = sc.nextInt();
			int nodeIndex = sc.nextInt();

			par = new int[nodeCount + 2];
			ch1 = new int[nodeCount + 2];
			ch2 = new int[nodeCount + 2];

			for (int i = 0; i < nodeCount; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();

				if (ch1[parent] == 0) {
					ch1[parent] = child;
				} else {
					ch2[parent] = child;
				}

				par[child] = parent;
			}

			int childCount = 0;
			int parentCount = 0;
			int c = nodeIndex;

			while (par[c] != 0) {
				c = par[c];
				parentCount++;
			}
			int from = -1;
			int to = -1;
			c = nodeIndex;
			int que[] = new int[nodeCount + 1];
			if (ch1[c] != 0) {
				childCount++;
				que[++to] = ch1[c];
			}
			if (ch2[c] != 0) {
				childCount++;
				que[++to] = ch2[c];
			}

			while (from != to) {
				c = que[++from];

				if (ch1[c] != 0) {
					childCount++;
					que[++to] = ch1[c];
				}
				if (ch2[c] != 0) {
					childCount++;
					que[++to] = ch2[c];
				}

			}
			System.out.println(String.format("#%d %d %d", t + 1, parentCount,
					childCount));
		}

	}
}
