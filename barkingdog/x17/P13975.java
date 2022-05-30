package barkingdog.x17;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13975 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static StringTokenizer st;


    static long T,num,num2;
    static long ans;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            pq.clear();
            br.readLine();
            Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).forEach(p->pq.add(p));
            ans = 0;
            while(true){
                num = pq.poll();
                if(pq.isEmpty()) break;
                num2 = pq.poll();
                ans += num + num2;
                pq.add(num+num2);
            }
            bw.write(String.valueOf(ans));
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
}
