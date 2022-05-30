package barkingdog.x17;

import java.io.*;
import java.util.PriorityQueue;

public class P1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int N,num;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while(N-->0){
            num = Integer.parseInt(br.readLine());
            if(num==0) {
                if (pq.isEmpty()) bw.write("0");
                else bw.write(String.valueOf(pq.poll()));
                bw.write("\n");
                continue;
            }
            pq.add(num);
        }
        bw.flush();
        bw.close();
    }
}
