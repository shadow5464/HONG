package study_04;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainA {
	static int arrNum[];
	static int count;
	static int findNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			int numCount = sc.nextInt();
			findNum = sc.nextInt();
			count = 0;

			int nam = ((numCount + 1) * numCount) / 2;
			f(1, numCount, 0, nam);
			System.out.println(String.format("#%d %d", t + 1, count));
		}
	}

	private static void f(int i, int numCount, int sum, int nam) {
		if (sum == findNum) {
			count++;
			return;
		} else if (i > numCount) {
			return;
		} else if ((sum + nam) < findNum) {
			return;
		} 
		else if (sum > findNum) {
			return;
		}

		f(i + 1, numCount, sum, nam - i);
		f(i + 1, numCount, sum + i, nam - i);
	}
}
