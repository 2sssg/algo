package barkingdog.x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15686 {
    static class Pair{
        int x; int y; boolean pick;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void func(int depth,int cur){
        if(depth == M){
            int tempdistance = 0;
            for(Pair p : houseList){
                int tempdistance2 = 2100000000;
                for(Pair cp: chickenList){
                    if(cp.pick){
                        tempdistance2 = Math.min(tempdistance2,Math.abs(p.x-cp.x) + Math.abs(p.y-cp.y));
                    }
                }
                tempdistance+= tempdistance2;
            }
            ans = Math.min(ans,tempdistance);
            return;
        }
        for(int i=cur; i<chickenCount; ++i){
            chickenList.get(i).pick = true;
            func(depth + 1, i+1);
            chickenList.get(i).pick = false;
        }
    }

    static int N,M,chickenCount,ans;
    static int[][] arr;
    static List<Pair> chickenList = new ArrayList<>();
    static List<Pair> houseList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ans = 2100000000;
        est(); N = rstn(); M = rstn();
        arr = new int[N][N];
        for(int i=0; i<N; ++i){
            est();
            for(int j=0; j<N; ++j){
                arr[i][j] = rstn();
                if(arr[i][j] == 1) houseList.add(new Pair(i,j));
                else if(arr[i][j] == 2) chickenList.add(new Pair(i,j));
            }
        }
        chickenCount = chickenList.size();
        func(0,0);
        System.out.println(ans);
    }
}
