package kakao.programmers.lv3.crossing_the_stepping_stone;

public class Main {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		int result = 3;
		System.out.println("result\t: " + result);
		System.out.println("my\t\t\t: " + new Solution().solution(stones, k));
	}
}
