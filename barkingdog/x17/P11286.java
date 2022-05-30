package barkingdog.x17;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1)==Math.abs(o2)){
                return o1-o2;
            }
            return Math.abs(o1)-Math.abs(o2);
        }
    });
    static int N,doing;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while(N-->0){
            doing = Integer.parseInt(br.readLine());
            if(doing == 0){
                if(pq.isEmpty()){
                    bw.write("0\n");
                    continue;
                }
                bw.write(String.valueOf(pq.poll()));
                bw.write("\n");
                continue;
            }
            pq.add(doing);
        }
        bw.flush();
        bw.close();
    }
}
