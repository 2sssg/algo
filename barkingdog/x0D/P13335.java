package barkingdog.x0D;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13335 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q = new ArrayDeque<>();

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static int n,w,L,weight,idx,ans;
    static int[] truck;
    public static void main(String[] args) throws IOException {
        est(); n = rstn(); w = rstn(); L = rstn();
        for(int i=0; i<w; ++i) q.add(0);
        truck = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        do{
            ans++;
            weight -= q.poll();
            if(idx == n) q.add(0);
            else if(weight+truck[idx]<=L) {
                weight += truck[idx];
                q.add(truck[idx++]);
            }
            else q.add(0);
        }while(weight!=0);
        System.out.println(ans);
    }
}
