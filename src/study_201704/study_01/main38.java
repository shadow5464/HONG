package study_01;

//1,2,3 으로 3자리수 만들기
public class main38 {
	public static int used[] = { 0, 0, 0, 0, 0 };
	public static int a[] = { 1, 2, 3, 4 };
	public static int p[] = { 1, 2, 3, 4 };

	public static void main(String[] args) {
		aaa(0, 4);
	}

	public static void aaa(int dep, int n) {
		if (dep == n) {
			for (int i = 0; i < n; i++) {
				System.out.print(p[i]);
			}
			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			if (used[i] == 0) {
				used[i] = 1;
				p[dep] = a[i];
				aaa(dep + 1, n);
				used[i] = 0;
			}
		}
	}
}
