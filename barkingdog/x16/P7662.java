package barkingdog.x16;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Queue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
    static Queue<Integer> minpq = new PriorityQueue<>();

    static int T,N,num,temp;
    static String move;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; ++i){
                st = new StringTokenizer(br.readLine());
                move = st.nextToken();
                num = Integer.parseInt(st.nextToken());

                if(move.equals("D") && maxpq.isEmpty()) continue;

                if(move.equals("I")){
                    maxpq.offer(num);
                    minpq.offer(num);
                    continue;
                }

                temp = maxpq.poll();

                if(num==1){
                    minpq.remove(temp);
                    continue;
                }

                maxpq.remove(temp);

            }

            if(minpq.isEmpty()){
                bw.write("EMPTY\n");
            }else{
                bw.write(String.valueOf(maxpq.poll()));
                bw.write(" ");
                bw.write(String.valueOf(minpq.poll()));
                bw.write("\n");
            }

        }
        bw.flush();
        bw.close();

    }
}
