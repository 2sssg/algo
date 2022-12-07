package kakao.programmers.lv2.formula_maximization;

import java.util.ArrayDeque;

class Solution {

	String operate(long f, long s, char op) {
		switch (op) {
			case '+':
				return Long.toString(f + s);
			case '-':
				return Long.toString(f - s);
			default :
				return Long.toString(f * s);
		}
	}

	public long solution(String expression) {
		String[] priority = {"*+-", "*-+", "+-*", "+*-", "-+*", "-*+"};
		String[] nums = expression.split("[*\\-+]");
		String[] op = expression.replaceAll("[\\d]","").split("");
		long answer = 0;
		for (int i = 0; i < 6; ++i) {
			ArrayDeque<String> dq = new ArrayDeque<>();
			dq.push(nums[0]);
			for (int j = 0; j < op.length; ++j) {
				dq.push(op[j]);
				dq.push(nums[j + 1]);
			}
			for (int j = 0; j < 3; ++j) {
				dq.addFirst(dq.pollLast());
				while (dq.peekLast().equals("*") || dq.peekLast().equals("-") || dq.peekLast().equals("+")) {
					if (dq.peekLast().charAt(0) == priority[i].charAt(j)) {
						dq.pollLast();
						long first = Long.parseLong(dq.pollFirst());
						long second = Long.parseLong(dq.pollLast());
						dq.addFirst(operate(first, second, priority[i].charAt(j)));
					} else {
						dq.addFirst(dq.pollLast());
						dq.addFirst(dq.pollLast());
					}
				}
			}
			answer = Math.max(answer,Math.abs(Long.parseLong(dq.pollFirst())));
		}
		return answer;
	}
}