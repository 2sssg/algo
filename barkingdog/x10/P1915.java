package barkingdog.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1915 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static String s;
    static int[][] board = new int[1010][1010];
    static int[][]d = new int[1010][1010];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; ++i){
            s = br.readLine();
            for(int j = 1; j <= m; ++j)
                board[i][j] = s.charAt(j-1) - '0';
        }
        int ans = 0;
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j){
                if(board[i][j]==1){
                    d[i][j] = Math.min(d[i-1][j-1],Math.min(d[i-1][j], d[i][j-1])) + 1;
                    ans = Math.max(ans, d[i][j]);
                }
            }
        }
        System.out.println(ans*ans);
    }
}
