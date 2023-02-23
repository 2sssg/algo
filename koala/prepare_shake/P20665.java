package koala.prepare_shake;

import Constant.Source;
import java.io.*;
import java.util.*;

public class P20665 {
	static final int timeOffset = 9 * 60;
	static int n, t, p;
	static boolean[][] seat;
	static List<Pair> reserv;

	static void init() throws IOException {
		n = rstn(); t = rstn(); p = rstn();
		seat = new boolean[n + 1][60 * 12 + 5];
		reserv = new ArrayList<>();
		for (int i = 0; i < t; ++i) {
			int s = rstn();
			int e = rstn();
			s = (s / 100 * 60 + s % 100) - timeOffset;
			e = (e / 100 * 60 + e % 100) - timeOffset;
			reserv.add(new Pair(s, e));
		}
		reserv.sort((o1, o2) -> {
			if (o1.x == o2.x) return (o1.y - o1.x) - (o2.y - o2.x);
			return o1.x - o2.x;
		});
	}

	static int getAvailableSeat(int s, int e) {
		int dist = 0;
		int ret = -1;
		o: for (int i = 1; i <= n; ++i) {
			for (int time = s; time < e; ++time) if (seat[i][time]) continue o;
			for (int d = 1; i + d <= n || i - d >= 1; ++d) {
				if (i + d <= n && seat[i + d][s]) {
					if (dist < d) {
						dist = d;
						ret = i;
					}
					continue o;
				}
				if (i - d >= 1 && seat[i - d][s]) {
					if (dist < d) {
						dist = d;
						ret = i;
					}
					continue o;
				}
			}
		}
		return ret == -1 ? 1 : ret;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for (int i = 0; i < t; ++i) {
			int seatNum = getAvailableSeat(reserv.get(i).x, reserv.get(i).y);
			for (int time = reserv.get(i).x; time < reserv.get(i).y; ++time) seat[seatNum][time] = true;
		}

		int ans = 0;
		for (int i = 0; i < 60 * 12; ++i) ans += seat[p][i] ? 0 : 1;
		System.out.println(ans);
	}



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
}
