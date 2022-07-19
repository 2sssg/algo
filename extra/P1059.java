package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class P1059 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static TreeSet<Integer> ts = new TreeSet<>();
	static int l,n;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		ts.clear();
		l = Integer.parseInt(br.readLine());
		ts.addAll(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
		n = Integer.parseInt(br.readLine());
		if(ts.contains(n)){
			System.out.println(0);
			return;
		}
		int min = 0;
		int max = ts.higher(n);
		if(ts.lower(n)!=null)
			min = ts.lower(n);

		System.out.println((n-min)*(max-n)-1);
	}

}
