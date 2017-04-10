package study_01;

import java.util.Scanner;

//1,2,3 으로 3자리수 만들기
public class mainF {
	static int min = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputCount = sc.nextInt();
		for (int c = 0; c < inputCount; c++) {
			int itemCount = sc.nextInt();
			int arr[] = new int[itemCount - 1];
			for (int i = 0; i < itemCount - 1; i++) {
				arr[i] = i + 1;
			}
			int values[][] = new int[itemCount][itemCount];
			for (int i = 0; i < itemCount; i++) {
				for (int j = 0; j < itemCount; j++) {
					values[i][j] = sc.nextInt();
				}
			}
			min = 9999;
			perm(values, arr, 0);

			System.out.println(min);
		}

	}

	public static void perm(int values[][], int[] arr, int pivot) {
		if (pivot == arr.length) {
			print(values, arr);
			return;
		}
		for (int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			perm(values, arr, pivot + 1);
			swap(arr, i, pivot);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int values[][], int[] arr) {
		int x1 = 0;
		int x2 = arr[0];
		int temp = values[x1][x2];
		for (int i = 0; i < arr.length - 1; i++) {
			temp += values[arr[i]][arr[i + 1]];
			x2 = arr[i + 1];
		}
		temp += values[x2][0];
		if (temp < min) {
			min = temp;
		}
	}

}
