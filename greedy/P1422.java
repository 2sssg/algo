package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1422 {
	static int k, n;
	static List<String> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		k = rstn(); n = rstn();
		for (int i = 0; i < k; ++i) arr.add(br.readLine());
		arr.sort((o1, o2) -> o2.length() - o1.length() == 0 ? o2.compareTo(o1) : o2.length() - o1.length());
		for (int i = 0; i < n - k; ++i) arr.add(arr.get(0));
		arr.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
		arr.forEach(s -> sb.append(s));
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}

