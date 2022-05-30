package barkingdog.x17;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class P1655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PriorityQueue<Integer> overPQ = new PriorityQueue<>();
    static PriorityQueue<Integer> underPQ = new PriorityQueue<>(Collections.reverseOrder());


    static int N, mid,temp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        mid = Integer.parseInt(br.readLine());
//        System.out.println(underPQ.toString() + " "+ mid + " " +overPQ);

        bw.write(String.valueOf(mid));
        bw.write("\n");
        for(int i=1; i<N; ++i){
            temp = Integer.parseInt(br.readLine());
            if(temp == mid){
                if(underPQ.size() == overPQ.size()){
                    overPQ.add(temp);
                }else{
                    underPQ.add(temp);
                }
            }else if(temp>mid){
                if(underPQ.size()==overPQ.size()){
                    overPQ.add(temp);
                }else{
                    underPQ.add(mid);
                    if(overPQ.peek()>=temp){
                        mid = temp;
                    }else{
                        mid = overPQ.poll();
                        overPQ.add(temp);
                    }
                }
            }else{
                if(underPQ.size()==overPQ.size()){
                    overPQ.add(mid);
                    if(underPQ.isEmpty()||underPQ.peek()<=temp){
                        mid = temp;
                    }else{
                        mid = underPQ.poll();
                        underPQ.add(temp);
                    }
                }else{
                    underPQ.add(temp);
                }
            }
//            System.out.println(underPQ.toString() + " "+ mid + " " +overPQ);
            bw.write(String.valueOf(mid));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
