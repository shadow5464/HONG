package study_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//1,2,3 으로 3자리수 만들기
public class mainD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int inputCount = sc.nextInt();

		for (int c = 0; c < inputCount; c++) {
			int rowCount = sc.nextInt();

			int array[][] = new int[rowCount][rowCount];

			int inputValue = 1;

			for (int i = 1; i < rowCount; i++) {
				for (int j = 0; j < rowCount - i; j++) {
					array[j][j + i] = inputValue++;
				}
			}

			int row = sc.nextInt();
			int col = sc.nextInt();

			System.out.println(String.format("#%d %d", c + 1, array[row][col]));

			// for (int i = 0; i < rowCount; i++) {
			// for (int j = 0; j < rowCount; j++) {
			// System.out.print(array[i][j]);
			// }
			// System.out.println();
			// }
		}
	}

}
