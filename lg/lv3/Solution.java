package lg.lv3;

class Solution {

	String ref, tck;

	public int compare(int i) {
		int ret = 0;

		for (int j = 0; j < tck.length(); ++j) {
			int tempret = 0;
			for (int k = 0; k + j < tck.length(); ++k) {
				if (i + k == ref.length()) break;
				if (ref.charAt(i + k) == tck.charAt(j + k))
					tempret++;
				else break;
			}
			ret = Math.max(tempret, ret);
		}
		return ret;
	}

	public int solution(String reference, String track) {
		int answer = Integer.MAX_VALUE;
		ref = reference;
		tck = track;
		int rlength = reference.length();
		for (int i = 0; i < rlength; ) {
			int com = compare(i);
			answer = Math.min(com, answer);
			i += com;
			System.out.println(i);
		}
		System.out.println(answer);

		return answer;
	}

}
