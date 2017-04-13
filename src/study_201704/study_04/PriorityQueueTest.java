package study_04;

import java.util.PriorityQueue;

//1,2,3 으로 3자리수 만들기
public class PriorityQueueTest {
	public static void main(String[] args) {

		PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();

		priorityQueue.add(new Prisoner("HJH", 59));

		priorityQueue.add(new Prisoner("HJH3", 259));

		priorityQueue.add(new Prisoner("HJH4", 529));

		priorityQueue.add(new Prisoner("HJH2", 159));

		while (!priorityQueue.isEmpty()) {
			Prisoner prisoner = priorityQueue.poll();
			System.out.println(prisoner.name + "   " + prisoner.weight);
		}
	}
}

class Prisoner implements Comparable<Prisoner> {

	String name;
	int weight; // 형량

	public Prisoner(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	@Override
	public int compareTo(Prisoner target) {
		if (this.weight > target.weight) {
			return 1;
		} else if (this.weight < target.weight) {
			return -1;
		}
		return 0;
	}
}