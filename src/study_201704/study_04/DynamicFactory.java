package study_04;

import java.util.ArrayList;
import java.util.List;

//1,2,3 으로 3자리수 만들기
public class DynamicFactory {
	public static void main(String[] args) {
		List<Integer> fac = new ArrayList<Integer>();
		fac.add(1); // 0!

		for (int i = 1; i < 10; i++) {
			fac.add(i * fac.get(i - 1));
			System.out.println(fac.get(i));
		}
	}
}
