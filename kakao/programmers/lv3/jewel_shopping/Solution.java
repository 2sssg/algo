package kakao.programmers.lv3.jewel_shopping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public int[] solution(String[] gems) {
		HashMap<String, Integer> hm = new HashMap<>();
		Arrays.stream(gems).forEach(r -> hm.put(r, 0));
		HashSet<String> hs = new HashSet<>();
		int len = Integer.MAX_VALUE;
		int s = -1, e = -1;
		int j = 0;
		for (int i = 0; i < gems.length; ++i) {
			while (j < gems.length && hs.size() != hm.size()) {
				hs.add(gems[j]);
				hm.compute(gems[j], (k,v)->v+1);
				j++;
			}
			if (hs.size() == hm.size() && len > j - i + 1) {
				len = j - i + 1;
				s = i; e = j;
			}
			if (hm.get(gems[i]) == 1) {
				hs.remove(gems[i]);
			}
			hm.compute(gems[i], (k,v)->v-1);
		}
		System.out.println("s : " + (s + 1) + "e : " + e);
		return new int[]{1,2};
	}
}