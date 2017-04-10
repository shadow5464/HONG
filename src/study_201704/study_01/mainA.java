package study_01;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rowCount = sc.nextInt();

		for (int i = 0; i < rowCount; i++) {
			int minValue = 0;
			int maxValue = 0;
			int colCount = sc.nextInt();
			for (int j = 0; j < colCount; j++) {
				int value = sc.nextInt();

				if (j == 0) {
					minValue = value;
					maxValue = value;
					continue;
				}
				if (minValue > value) {
					minValue = value;
				}

				if (maxValue < value) {
					maxValue = value;
				}
			}
			System.out.println(String.format("#%d %d", i + 1, maxValue
					- minValue));
		}
	}
}
