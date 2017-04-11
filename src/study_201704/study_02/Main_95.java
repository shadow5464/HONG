package study_02;

/***
 * @author 연습 문제 95
 */
public class Main_95 {
	static int que[] = new int[1000];
	static int from = -1;
	static int to = -1;
	static int nodeMap[][];
	static int nodeCount = 9;
	static int visieted[] = new int[nodeCount + 1];

	public static void main(String[] args) {
		int nodes[] = { 1, 2, 1, 3, 3, 2, 3, 4, 2, 5, 5, 4, 1, 6, 6, 7, 7, 8,
				4, 7, 4, 9, 5, 9 };

		nodeMap = new int[nodeCount + 1][nodeCount + 1];

		int n = nodes.length;
		for (int i = 0; i < n; i++) {
			int n1 = nodes[i];
			int n2 = nodes[++i];
			nodeMap[n1][n2] = 1;
		}

		for (int i = 1; i <= nodeCount; i++) {
			for (int j = 1; j <= nodeCount; j++) {
				System.out.print(nodeMap[i][j] + " ");
			}
			System.out.println();
		}

		BFS(1);
		System.out.println(visieted);
		for (int i = 1; i <= nodeCount; i++) {
			System.out.print((visieted[i] - 1) + " ");
		}
	}

	static void BFS(int s) {
		que[++to] = s;
		visieted[s] = 1;
		while (from != to) {
			int n = que[++from];
			for (int i = 1; i <= nodeCount; i++) {
				if (nodeMap[n][i] == 1 && visieted[i] == 0) {
					que[++to] = i;
					visieted[i] = visieted[n] + 1;
				}
			}
		}
	}
}
