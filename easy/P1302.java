package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class P1302 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String book = br.readLine();
			if (map.containsKey(book)) map.put(book, map.get(book) + 1);
			else map.put(book, 1);
		}

		int max = 0;
		String ans = "";
		for (Entry<String, Integer> en : map.entrySet()) {
			if (max < en.getValue()) {
				max = en.getValue();
				ans  = en.getKey();
			} else if (max == en.getValue()) {
				if (ans.compareTo(en.getKey()) > 0) {
					max = en.getValue();
					ans = en.getKey();
				}
			}
		}
		System.out.println(ans);
	}
}
