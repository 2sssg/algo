package kakao.programmers.lv2.tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

	List<Set<Integer>> l = new ArrayList<>();

	public int[] solution(String s) {


		Arrays.stream(s.replace("{{", "").replace("}}", "").split("\\},\\{"))
				.forEach(r->l.add(
						Arrays.stream(r.split(","))
								.mapToInt(Integer::parseInt)
								.boxed()
								.collect(Collectors.toSet())
				));

		l.sort(Comparator.comparingInt(Set::size));

		int[] last = l.get(l.size() - 1).stream().mapToInt(Integer::intValue).toArray();

		int[] answer = new int[last.length];

		for (int i : last) {
			int low = -1, high = l.size() - 1;
			while (low + 1 < high) {
				int mid = (low + high) / 2;
				if (l.get(mid).contains(i)) high = mid;
				else low = mid;
			}
			answer[high] = i;
		}

		return answer;

	}
}