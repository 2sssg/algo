package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9466_unsolved {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> q = new LinkedList<>();
    static StringTokenizer st;

    static int T,t,tmp;
    static int[] arr,visit1,visit2;
    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void copy(boolean i){
        if(i) for(int j=0; j<tmp; j++) visit1[j] = visit2[j];
        else for(int j=0; j<tmp; j++) visit2[j] = visit1[j];
    }

    public static void main(String[] args) throws IOException {
        T = rn();
        while(T-->0){
            tmp =rn()+1;
            int temp = -1;
            arr = new int[tmp];
            visit1 = new int[tmp];
            visit2 = new int[tmp];
            est();
            for(int i=1; i<tmp; i++) arr[i] = rstn();

            l:for(int i=1; i<tmp; i++){ // 100,000
                if(visit1[i] == 0){
                    temp = i;
                    q.add(i);
                    visit2[i] = 1;
                }
                while(!q.isEmpty()){// 100,000
                    t = q.poll();
                    if(temp == arr[t]) {
                        copy(true);
                        continue l;
                    }
                    if(visit2[arr[t]] == 0){
                        q.add(arr[t]);
                        visit2[arr[t]] = 1;
                    }
                }
                copy(false);
            }
            int cnt=0;
            for(int i=0; i<visit1.length; i++){
                if(visit1[i]==0){
                    cnt++;
                }
            }

            bw.write(String.valueOf(cnt-1));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
