package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P13424_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static HashSet<Integer> hs = new HashSet<>();
	static int t, n, answer;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			answer = 0;
			hs = new HashSet<>();
			n = Integer.parseInt(br.readLine());
			arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();
			hs.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));

			for(int i=0; i<n-2; ++i)
				for(int j=i+1; j<n-1; ++j)
					if(hs.contains(Math.abs(arr[i]-arr[j])+arr[j]))
						answer++;

			bw.write(String.valueOf(answer));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
