package extra;
import java.util.*;
import java.io.*;

public class P11014 {
	static int c, n, m, broken;
	static boolean [][] map;
	static int [] d = {-1,-1,0,-1,1,-1,-1,1,0,1,1,1};
	static ArrayList<ArrayList<Integer>> list;
	static int [] check;
	static boolean [] visit;

	static int change(int x, int y) {return (x-1)*m+y;}

	static boolean dfs(int x){
		if (x == 0) return true;

		for (int i = 0; i < list.get(x).size(); i++) {
			int next = list.get(x).get(i);
			if(visit[next]) continue;
			visit[next] = true;
			if (dfs(check[next])) {
				check[next] = x;
				return true;
			}
		}
		return false;
	}

	static int flow() {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j += 2) {
				Arrays.fill(visit, false);
				int tmp = change(i,j);
				if(dfs(tmp)) ans++;
			}
		}
		return ans;
	}

	static void addEdge(int x, int y) {
		for (int i = 0; i < 12; i += 2) {
			int tmpx = x + d[i];
			int tmpy = y + d[i + 1];
			if(tmpx < 1 || tmpx > n || tmpy < 1 || tmpy > m || map[tmpx][tmpy]) continue;
			list.get(change(x,y)).add(change(tmpx,tmpy));
		}
	}


	public static void main(String[] args) throws IOException {
		c = rn();
		while (c-- > 0){
			n = rstn(); m = rstn();
			map = new boolean [n + 1][m + 1];
			broken = 0;
			for(int i = 1; i <= n; i++){
				String temp = br.readLine();
				for(int j = 1; j <= m; j++){
					if(temp.charAt(j - 1) == 'x'){
						broken++;
						map[i][j]=true;
					}
				}
			}

			list = new ArrayList<>();
			for (int i=0; i<=n * m; i++) list.add(new ArrayList<>());

			for (int i = 1; i <= n; i++){
				for (int j = 1; j <= m; j += 2){
					if (map[i][j]) continue;
					addEdge(i,j);
				}
			}

			check = new int [n * m + 1];
			visit = new boolean [n * m + 1];
			sb.append(n * m - broken - flow()).append("\n");
		}
		System.out.println(sb);
	}



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
