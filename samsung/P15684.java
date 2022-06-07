package samsung;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P15684 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static TreeMap<Integer,Integer>[] adjList;


    static int N,M,H,v1,v2,temph,hmax;

    static void func(int depth,int sero, int garo){
        if(depth == temph){
//            System.out.println(depth);
//            if(adjList[2].containsKey(4) && adjList[3].containsKey(1) && adjList[4].containsKey(3)){
//                System.out.println(Arrays.toString(adjList));
//                System.out.println("saddasdasadsadsdas");
//            }
            if(ladder()){
//                System.out.println(Arrays.toString(adjList));
//                System.out.println();
//                System.out.println();
                System.out.println(depth);
                System.exit(0);
            }
            return;
        }
        for(int i=sero; i<N; ++i){
            for(int j=garo; j<=H; ++j){
                if(adjList[i].containsKey(j) || adjList[i+1].containsKey(j) ){
                    continue;
                }
//                int count =0;
//                for(int temp: adjList[i].values()){
//                    if(temp==i+1)
//                        count++;
//                }
//                if(count >= H){
//                    continue;
//                }
                adjList[i].put(j,i+1);
                adjList[i+1].put(j,i);
//                System.out.println(i+" 와 "+(i+1)+" 사이에 높이 "+j+" 에다가 선그음");
//                System.out.println(Arrays.toString(adjList));
//                System.out.println();
//                System.out.println();
                func(depth+1,i,j);
                adjList[i].remove(j);
                adjList[i+1].remove(j);
//                System.out.println(i+" 와 "+(i+1)+" 사이에 높이 "+j+" 에다가 선지움");
//                System.out.println(Arrays.toString(adjList));
//                System.out.println();
//                System.out.println();
            }
            garo = 1;
        }

    }

    static boolean ladder(){
        l: for(int i=1; i<=N; ++i){
            int height = 0;
            int cur=i;
            while (true) {
                if(adjList[cur].higherKey(height)==null){
                    if(cur==i){
                        continue l;
                    }else{
//                        System.out.println(i+"번 출발해서 도착지가 "+ cur+"임 ㅇㅇ");
                        return false;
                    }
                }
                Map.Entry<Integer,Integer> en = adjList[cur].higherEntry(height);
                cur = en.getValue();
                height = en.getKey();
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        temph=0;
        adjList = new TreeMap[N+1];
        for(int i=1; i<=N; ++i)
            adjList[i] = new TreeMap<>();

        for(int i=0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            hmax = Math.max(hmax,v1);
            adjList[v2].put(v1,v2+1);
            adjList[v2+1].put(v1,v2);
        }
//        System.out.println(Arrays.toString(adjList));
//        System.out.println();
//        System.out.println();
        for(int i=0; i<=3; ++i){
            temph = i;
            func(0,1,1);
        }
        System.out.println("-1");

    }
}
