package study;

public class main {

	public static void main(String[] args) {
		System.out.println(factorial(8));

	}

	public int factorial(int n) {
		if (n < 2) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
