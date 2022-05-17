package barkingdog.x11;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T,N;
    static int[] idx = new int[1000005];
    static int[] visit = new int[1000005];
    static int[] arr;
    static long ans;

    public static void makeans(int _idx) throws IOException {
        visit[_idx] = 1;
        int max = arr[_idx--];
        while(_idx>=0 && visit[_idx] == 0){
            ans += max - arr[_idx];
            visit[_idx--] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            ans = 0;
            Arrays.fill(idx,0);
            Arrays.fill(visit,0);
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; ++i){
                arr[i] = Integer.parseInt(st.nextToken());
                idx[arr[i]] = i+1;
            }
            for(int i=10000; i>=0; --i){
                if(idx[i] == 0) continue;
                if(visit[idx[i]-1] == 0) makeans(idx[i]-1);

            }
            bw.write(String.valueOf(ans));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
