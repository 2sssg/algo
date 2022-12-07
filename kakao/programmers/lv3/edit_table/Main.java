package kakao.programmers.lv3.edit_table;

public class Main {

	public static void main(String[] args) {
		int n,k;
		String[] cmd;

		n = 8;
		k = 2;
		cmd = new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		cmd = new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(new Solution().solution(n,k,cmd));
	}
}
