package kakao.programmers.lv3.bad_user;


import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {

	int[] candidate;
	int candidateLen, answer = 0;
	boolean[] use;
	String[] ban;
	String[] user;
	HashSet<String> hs ;
	void init(int len, String[] user_id, String[] banned_id) {
		hs = new HashSet<>();
		candidate = new int[len];
		candidateLen = len;
		ban = banned_id;
		for (int i = 0; i < banned_id.length; ++i) {
			ban[i] = ban[i].replace("*", ".");
		}
		user = user_id;
		use = new boolean[user.length];
	}

	boolean chk() {
		String tos = Arrays.toString(Arrays.stream(candidate).sorted().toArray());
		if (hs.contains(tos)) return false;
		for (int i = 0; i < candidateLen; ++i) {
			if (!Pattern.matches(ban[i], user[candidate[i]])) return false;
		}
		hs.add(tos);
		System.out.println(Arrays.toString(candidate));
		return true;
	}

	void f(int depth) {
		if (depth == candidateLen) {
			if (chk()) answer++;
			return ;
		}
		for (int i = 0; i < user.length; ++i) {
			if (use[i]) continue;
			use[i] = true;
			candidate[depth] = i;
			f(depth+1);
			use[i] = false;
		}
	}

	public int solution(String[] user_id, String[] banned_id) {
		System.out.println();
		init(banned_id.length, user_id, banned_id);
		f(0);
		return answer;
	}
}