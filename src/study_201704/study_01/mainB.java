package study_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rowCount = sc.nextInt();

		for (int i = 0; i < rowCount; i++) {
			int valueCount[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int colCount = sc.nextInt();
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			String value = sc.next();
			value = value.trim();
			char[] charArray = value.toCharArray();

			for (int j = 0; j < colCount; j++) {
				int integer = Integer.parseInt(String.valueOf(charArray[j]));

				valueCount[integer] = valueCount[integer] + 1;
			}
			int maxValue = 0;
			int mexCount = valueCount[0];
			for (int j = 1; j < 10; j++) {
				if (mexCount <= valueCount[j]) {
					mexCount = valueCount[j];
					if (j > maxValue) {
						maxValue = j;
					}

				}
			}
			System.out.println(String.format("#%d %d %d", i + 1, maxValue,
					mexCount));
		}

	}
}
