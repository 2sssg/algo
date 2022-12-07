package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1063 {
	static Pair queen, rock;
	static int n;
	static HashMap<String, Integer> move = new HashMap<>();
	static int[] dx;
	static int[] dy;

	static void init() {
		move.put("R", 0);
		move.put("L", 1);
		move.put("B", 2);
		move.put("T", 3);

		move.put("RT", 4);
		move.put("LT", 5);
		move.put("RB", 6);
		move.put("LB", 7);

		dx = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
		dy = new int[]{0, 0, -1, 1, 1, 1, -1, -1};
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est();
		String queenLoc = st.nextToken();
		queen = new Pair(queenLoc.toCharArray()[0] - 'A', queenLoc.toCharArray()[1] - '1');
		String rockLoc = st.nextToken();
		rock = new Pair(rockLoc.toCharArray()[0] - 'A', rockLoc.toCharArray()[1] - '1');
		n = rstn();
		init();
		while (n-- > 0) {
			String m = br.readLine();
			int nx = queen.x + dx[move.get(m)];
			int ny = queen.y + dy[move.get(m)];
			if (chk(nx, ny, 8, 8)) continue;
			if (nx == rock.x && ny == rock.y) {
				int rnx = rock.x + dx[move.get(m)];
				int rny = rock.y + dy[move.get(m)];
				if (chk(rnx, rny, 8, 8)) continue;
				rock = new Pair(rnx, rny);
			}
			queen = new Pair(nx, ny);
		}
		System.out.println("" + (char)(queen.x + 'A') + (char)(queen.y + '1'));
		System.out.println("" + (char)(rock.x + 'A') + (char)(rock.y + '1'));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}

		@Override
		public String toString() {
			return "Pair{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
