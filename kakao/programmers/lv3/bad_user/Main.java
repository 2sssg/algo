package kakao.programmers.lv3.bad_user;

public class Main {

	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		int result = 2;

		System.out.println("result\t: " + result);
		System.out.println("My\t\t\t: "+new Solution().solution(user_id, banned_id));
	}
}
