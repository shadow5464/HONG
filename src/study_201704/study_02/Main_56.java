package study_02;

import java.util.Scanner;


/***
 * 
 * @author 트리 연습.
 *
 */
/*
 * input value
1 5 4
1 2 1 3 3 4 3 5
 * */
public class Main_56 {

	static int V;
	static int E;
	static int chr1[];
	static int chr2[];
	static int par[];

	public static void main(String[] args) {
		int T;
		int test_case;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			V = sc.nextInt();
			E = sc.nextInt();
			chr1 = new int[V + 1];
			chr2 = new int[V + 1];
			par = new int[V + 1];
			for (int i = 0; i < E; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				if (chr1[n1] == 0) {
					chr1[n1] = n2;
				} else {
					chr2[n1] = n2;
				}
				par[n2] = n1;
			}
			int c = 5;
			while (par[c] != 0) {
				c = par[c];
				System.out.print(String.format(" %d", c));
			}
			System.out.println();
			vLr(1);
			System.out.println();
			Lvr(1);
			System.out.println();
			Lrv(1);
			System.out.println();
		}
	}

	private static void vLr(int n) {
		if (n != 0) {

			System.out.print(String.format("%d ", n));
			vLr(chr1[n]);
			vLr(chr2[n]);
		}
	}

	private static void Lvr(int n) {
		if (n != 0) {
			Lvr(chr1[n]);
			System.out.print(String.format("%d ", n));
			Lvr(chr2[n]);
		}
	}

	private static void Lrv(int n) {
		if (n != 0) {

			Lrv(chr1[n]);
			Lrv(chr2[n]);
			System.out.print(String.format("%d ", n));
		}
	}

}
