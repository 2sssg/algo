package barkingdog.x1B;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1774 {
    static class Planet implements Comparable<Planet>{
        int num;
        long x;
        long y;
        double distance;

        public Planet setDistance(Planet o) {
            Planet p = new Planet(this.num,this.x,this.y);
            p.distance = Math.sqrt(Math.pow(this.x-o.x,2)+Math.pow(this.y-o.y,2));
            return p;
        }

        public Planet(int num, long x, long y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        public Planet(Planet p) {
            this.num = p.num;
            this.x = p.x;
            this.y = p.y;
            this.distance = p.distance;
        }

        @Override
        public String toString() {
            return "Planet{" +
                    "num=" + num +
                    ", x=" + x +
                    ", y=" + y +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public int compareTo(Planet o) {
            if(this.distance>o.distance){
                return 1;
            }
            return -1;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Planet> adjList = new ArrayList<>();
    static PriorityQueue<Planet> q = new PriorityQueue<>();
    static HashMap<Integer,HashSet<Integer>> con = new HashMap<>();
    static boolean[] chk;


    static int V,E,v1,v2,cnt;
    public static void main(String[] args) throws IOException {

        





        cnt=0;
        adjList.clear();
        q.clear();
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for(int i=0; i<=V; ++i){
            con.put(i,new HashSet<>());
        }
        chk = new boolean[V+1];
        adjList.add(new Planet(0,-1,-1));
        for(int i=1; i<=V; ++i){
            st = new StringTokenizer(br.readLine());
            adjList.add(new Planet(i,Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken())));
        }
        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            con.get(v1).add(v2);
            con.get(v2).add(v1);
            if(!chk[v1]){
                chk[v1] = true;
                q.add(new Planet(adjList.get(v1)));
            }
            if(!chk[v2]){
                chk[v2] = true;
                q.add(new Planet(adjList.get(v2)));
            }
        }
        Arrays.fill(chk,false);
        double ans=0;
        int tmp =0;
        for(HashSet<Integer> temp : con.values()){
            tmp+= temp.size();
        }
        tmp /= 2;
        if(cnt==0){
            q.add(new Planet(adjList.get(1)));
        }
        chk[0] = true;
        while(cnt<V+tmp){
            Planet planet = q.poll();
            if(chk[planet.num]) continue;
//            if(con.get(planet.num).size()==0) cnt++;
            System.out.println(planet);
            chk[planet.num] = true;
            ans += planet.distance;
            cnt++;
            for(Planet next : adjList){
                if(next.num==0) continue;
                if(next.num==planet.num) continue;
                con.get(next.num).add(planet.num);
                con.get(planet.num).add(next.num);
                if(chk[next.num]) continue;
                q.add(next.setDistance(planet));
            }
        }
        System.out.println(ans);
        System.out.printf("%.2f",ans);


    }
}
