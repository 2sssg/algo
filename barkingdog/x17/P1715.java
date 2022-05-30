package barkingdog.x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int N,temp,temp2;
    static long ans;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while(N-->0)
            pq.add(Integer.parseInt(br.readLine()));

        while(true){
            temp = pq.poll();
            if (pq.isEmpty()) break;
            temp2= pq.poll();
            pq.add(temp+temp2);
            ans+=temp+temp2;
        }
        System.out.println(ans);

    }
}
