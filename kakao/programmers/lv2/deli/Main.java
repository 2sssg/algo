package kakao.programmers.lv2.deli;

public class Main {

	public static void main(String[] args) {
		int cap = 2;
		int n = 7;
		int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
		int[] pickups = {0, 2, 0, 1, 0, 2, 0};
		Solution solution = new Solution();
		System.out.println(solution.solution(cap, n, deliveries, pickups));
	}
}
