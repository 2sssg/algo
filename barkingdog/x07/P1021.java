package barkingdog.x07;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1021 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M,dest,cnt,ans;
    static Deque<Integer> deq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) deq.addLast(i);

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            dest = Integer.parseInt(st.nextToken());
            cnt = 0;

            for(int i=0; i<deq.size(); i++){
                if(deq.peekFirst()==dest) cnt = i;
                deq.addLast(deq.pollFirst());
            }
            for(int i=0; i<deq.size(); i++){
                if(deq.peekFirst()==dest) {
                    cnt = Math.min(cnt,i);
                    deq.removeFirst();
                    break;
                }
                deq.addFirst(deq.pollLast());
            }
            ans += cnt;
        }


        System.out.println(ans);



    }
}
