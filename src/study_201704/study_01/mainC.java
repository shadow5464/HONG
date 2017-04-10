package study_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//1,2,3 으로 3자리수 만들기
public class mainC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rowCount = sc.nextInt();

		for (int i = 0; i < rowCount; i++) {
			int colCount = sc.nextInt();
			String value = sc.next();
			System.out.print("#" + (i + 1) + " ");
			for (int j = 0; j < colCount; j++) {
				int extracted = extracted(value.substring(j, j + 1));
				String printValue = "";
				if (extracted >= 8) {
					printValue += "1";
					extracted -= 8;
				} else {
					printValue += "0";
				}

				if (extracted >= 4) {
					printValue += "1";
					extracted -= 4;
				} else {
					printValue += "0";
				}

				if (extracted >= 2) {
					printValue += "1";
					extracted -= 2;
				} else {
					printValue += "0";
				}

				printValue += extracted;
				System.out.print(printValue);
			}
			System.out.println();

		}
	}

	private static String extracted(String printValue, int extracted, int mode) {

		return printValue;
	}

	private static int extracted(String a) {
		int value = 0;

		switch (a) {
		case "A":
			value = 10;
			break;
		case "B":
			value = 11;
			break;
		case "C":
			value = 12;
			break;
		case "D":
			value = 13;
			break;
		case "E":
			value = 14;
			break;
		case "F":
			value = 15;
			break;
		default:
			value = Integer.parseInt(a);
			break;
		}

		return value;
	}

	private int getMok(int value, int n) {
		return value / n;
	}
}
