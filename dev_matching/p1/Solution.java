package dev_matching.p1;

class Solution {

	String[] img;
	int n, m;

	boolean chkEdge(int x, int y, int len) {
		for (int i = 0; i < len; ++i) {
			if (img[x].charAt(y + i) != '#')  {
//				System.out.println(x + " , " + (y + i));
				return false;
			}
			if (img[x + len - 1].charAt(y + i) != '#'){
//				System.out.println((x + len - 1) + " , " + (y + i));
				return false;
			}
			if (img[x + i].charAt(y) != '#') {
//				System.out.println((x + i) + " , " + (y));
				return false;
			}
			if (img[x + i].charAt(y + len - 1) != '#') {
//				System.out.println((x + i) + " , " + (y + len - 1));
				return false;
			}
		}
		return true;
	}

	int getCnt(int x, int y, int len) {
		int cnt = 0;
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len; ++j) {
				if (img[x + i].charAt(y + j) == '#')
					cnt++;
			}
		}

		return cnt - (4 * len - 4);
	}

	boolean chkPercent(int low, int high, int k, int n) {
		double percent = ((double) k / ((n - 2) * (n - 2))) * 100;
		return low <= percent && percent < high;
	}

	public int solution(int low, int high, String[] s) {
		img = s;
		n = img.length;
		m = img[0].length();
		for (String t : s) {
			System.out.println(t);
		}
		int result = 0;
		for (int i = 3; i <= n; ++i) {
			System.out.println("i : " + i);
			for (int x = 0; x + i <= n; ++x) {
				for (int y = 0; y + i <= m; ++y) {
//					System.out.println(x + " , " + y + " , " + i);
					if (!chkEdge(x, y, i)) {
						System.out.println("continue");
						continue;
					}
					int cnt = getCnt(x, y, i);
					System.out.println("cnt : " + cnt);
					if (chkPercent(low, high, cnt, i)) {
						System.out.println(x + " , " + y + " , " + i);
						result++;
					}
				}
			}
		}
		System.out.println(result);
		return result;
	}
}