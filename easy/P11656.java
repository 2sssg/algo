package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11656 {
	static String s;
	static List<String> l = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		s = br.readLine();
		for (int i = s.length() - 1; i >= 0; --i) l.add(s.substring(i));
		l.sort(String::compareTo);
		l.forEach(r->sb.append(r).append("\n"));
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
}
