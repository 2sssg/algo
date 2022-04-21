package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014 {
    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> q = new LinkedList<>();
    static StringTokenizer st;

    static int F,S,G,U,D,cur;
    static int[] building,dist;
    public static void main(String[] args) throws IOException {
        est();
        F = rstn(); S = rstn(); G = rstn(); U = rstn(); D = rstn();
        building = new int[F];
        for(int i=0; i<F; i++) building[i] = i+1;

        dist = new int[F];
        Arrays.fill(dist,-1);

        q.add(S);
        dist[S-1] = 0;

        while(!q.isEmpty()){
            cur = q.poll();
            if(cur == G){
                System.out.println(dist[cur-1]);
                System.exit(0);
            }
            if(cur+U<=F && dist[cur+U-1]<0){
                q.add(cur+U);
                dist[cur+U-1] = dist[cur-1]+1;
            }
            if(cur-D>0 && dist[cur-D-1]<0){
                q.add(cur-D);
                dist[cur-D-1] = dist[cur-1]+1;
            }
        }
        System.out.println("use the stairs");
    }
}
