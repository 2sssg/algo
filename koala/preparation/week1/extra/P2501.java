package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P2501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer> l = new ArrayList<>();
	static int n,k;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		l.clear();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for(int i=1; i*i<=n; ++i){
			if(n%i==0) {
				if(i*i!=n) l.add(n/i);
				l.add(i);
			}
		}
		l.sort(Comparator.naturalOrder());
		if (l.size() <= k - 1) {
			System.out.println("0");
		}else{
			System.out.println(l.get(k-1));
		}
	}
}
