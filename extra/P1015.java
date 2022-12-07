package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P1015 {
	static class Triple {int x,y,z;public Triple(int x, int y, int z) {this.x = x;this.y = y;this.z = z;}}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static List<Triple> l = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) l.add(new Triple(Integer.parseInt(st.nextToken()), i, 0));
		l.sort(Comparator.comparingInt(o -> o.x));
		for (int i = 0; i < n; ++i) l.get(i).z = i;
		l.sort(Comparator.comparingInt(o -> o.y));
		for (Triple t : l) bw.append(Integer.toString(t.z)).append(" ");
		bw.flush();
		bw.close();
	}
}
