package kakao.programmers.lv3.crossing_the_stepping_stone;

class Solution {

	int max_dist(int[] stones, int mid) {
		int res = 0;
		int tempres = 0;
		for (int i = 0; i < stones.length; ++i) {
			if (stones[i] > mid) {
				res = Math.max(res, tempres);
				tempres = 0;
				continue;
			}
			tempres++;
		}
		res = Math.max(res, tempres);
		System.out.println("res : " +res);
		return res;
	}

	public int solution(int[] stones, int k) {
		int low = 0, high = 200_000_001;
		while (low + 1 < high) {
			int mid = (low + high) / 2;
			System.out.println("low :" + low);
			System.out.println("mid :" + mid);
			System.out.println("high :" + high);
			System.out.println();
			if (max_dist(stones, mid) >= k) high = mid;
			else low = mid;
		}
		System.out.println("low :" + low);
		System.out.println("high :" + high);
		return high;
	}
}