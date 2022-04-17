package barkingdog.x05;

import java.io.*;
import java.util.Stack;

public class P3015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,cnt,h;
    static long ans;
    static Stack<Pair> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while(N-->0){
            h = Integer.parseInt(br.readLine());
            cnt = 1;
            while (!s.isEmpty() && s.peek().X <= h) {
                ans += s.peek().Y;
                if (s.peek().X == h) cnt += s.peek().Y;
                s.pop();
            }
            if (!s.isEmpty()) ans++;
            s.push(new Pair(h,cnt));
        }
        System.out.println(ans);
    }
    static public class Pair{
        int X;
        int Y;

        public Pair(int x, int y) {
            X = x;
            Y = y;
        }
    }
}
