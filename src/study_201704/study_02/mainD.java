package study_02;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainD {

	static int v[] = null;
	static int nodeCount;
	static int grp[][];
	static String move = "";
	static int count;
	static int filnalNode;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			filnalNode = sc.nextInt();
			nodeCount = sc.nextInt();

			grp = new int[nodeCount][nodeCount];
			v = new int[nodeCount];
			for (int i = 0; i < nodeCount; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				grp[n1][n2] = 1;
			}
			move = "";
			count = 0;
			DFS(0);
			// System.out.println(move);
			// for (int i = 0; i < nodeCount; i++) {
			// for (int j = 0; j < nodeCount; j++) {
			// System.out.print(grp[i][j] + " ");
			// }
			//
			// System.out.println();
			// }

			System.out.println(String.format("#%d %s", t + 1, count));
		}
	}

	static void DFS(int n) {
		move += " " + n;
		v[n] = 1;
		if (filnalNode == n) {
			count++;
		}

		for (int i = 0; i < nodeCount; i++) {
			if (grp[n][i] == 1 && v[i] == 0) {
				DFS(i);
			}
		}
		v[n] = 0;
	}
}
