package barkingdog.x0F;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2910 {
    static class Cl implements Comparable<Cl>{
        int num; int count; int idx;

        public Cl(int num, int idx) {
            this.num = num;
            this.count = 1;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Cl{" +
                    "num=" + num +
                    ", count=" + count +
                    ", idx=" + idx +
                    '}';
        }

        @Override
        public int compareTo(Cl o) {
            if(this.count!=o.count){
                return o.count-this.count;
            }else{
                return this.idx-o.idx;
            }

        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,C;
    static int[] nawat = new int[1000000001];
    static Cl[] cl,rcl;
    public static void main(String[] args) throws IOException {
       st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       C = Integer.parseInt(st.nextToken());
       cl = new Cl[N];
       int cur = 0;
       int temp;
       st = new StringTokenizer(br.readLine());
       Arrays.fill(nawat,-1);
       for(int i=0; i<N; ++i){
           temp = Integer.parseInt(st.nextToken());
           if(nawat[temp] >=0){
               cl[nawat[temp]].count++;
           }else{
               nawat[temp] = cur;
               cl[cur++] = new Cl(temp,i);
           }
       }
       rcl = new Cl[cur];
       for(int i=0; i<cur;++i){
           rcl[i] = cl[i];
       }
       Arrays.sort(rcl);
       for(Cl t : rcl){
           for(int i=0; i<t.count; ++i){
               bw.write(String.valueOf(t.num));
               bw.write(" ");
           }
       }
       bw.flush();
       bw.close();
    }
}
