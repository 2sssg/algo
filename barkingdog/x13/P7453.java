package barkingdog.x13;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class P7453 {
    static class Pair implements Comparable<Pair>{
        int num;
        int index1;
        int index2;

        public Pair(int num, int index1, int index2) {
            this.num = num;
            this.index1 = index1;
            this.index2 = index2;
        }

        public Pair(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            return this.num-o.num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return num == pair.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static long ans;
    static int[] arr1, arr2, arr3, arr4;
    static Pair[] arr5;
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        arr2 = new int[N];
        arr3 = new int[N];
        arr4 = new int[N];
        arr5 = new Pair[N*(N-1)];
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
            arr3[i] = Integer.parseInt(st.nextToken());
            arr4[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if (i != j) {
                    arr5[idx] = new Pair(arr3[i]+arr4[j],i,j);
                    idx++;
                }
            }
        }
        Arrays.sort(arr5);
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(i!=j){
                    int idxx =Arrays.binarySearch(arr5,new Pair(-arr1[i]-arr2[j]));
                    if(idxx>=0){
                        int index1,index2;
                        index1 = arr5[idxx].index1;
                        index2 = arr5[idxx].index2;
                        System.out.println("찾을 수 : "+(-arr1[i]-arr2[j]));
                        System.out.println("찾아진 수 : "+arr5[idxx].num);
                        System.out.println("index1 : "+index1);
                        System.out.println("index2 : "+index2);
                        System.out.println("i : "+i);
                        System.out.println("j : "+j);
                        if(index1 != i && index1 != j && index2 != i && index2 !=j){
//                            System.out.println("찾을 수 : "+(-arr1[i]-arr2[j]));
//                            System.out.println("찾아진 수 : "+arr5[idxx].num);
//                            System.out.println("index1 : "+index1);
//                            System.out.println("index2 : "+index2);
//                            System.out.println("i : "+i);
//                            System.out.println("j : "+j);
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
