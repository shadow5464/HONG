package study_01;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainF {

	static int min = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int inputCount = sc.nextInt();
		for (int c = 0; c < inputCount; c++) {
			int jCount = sc.nextInt();
			int bC[] = new int[jCount];

			for (int i = 0; i < jCount - 1; i++) {
				bC[i] = sc.nextInt();
			}

			int startPoint = 0;
			int gage = bC[0];

			int newGate = bC[0];
			int newPoint = 0;
			int chgCount = 0;

			while (true) {
				// System.out.print(startPoint + "  ");
				if ((startPoint + gage) >= jCount - 1) {
					break;
				}

				newGate = 0;
				for (int i = startPoint + 1; i <= startPoint + gage
						&& i < jCount; i++) {
					if (newGate < bC[i]) {
						newGate = bC[i];
						newPoint = i;
					}
				}
				startPoint = newPoint;
				gage = newGate;
				chgCount++;
				// startPoint++;
			}
			System.out.println(String.format("#%d %d", c + 1, chgCount));
		}
	}
}

/**************************************************************
 * Problem: 1029 User: shadow5464 Language: Java Result: Accepted Time:310 ms
 * Memory:7212 kb
 ****************************************************************/

