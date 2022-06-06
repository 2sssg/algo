package barkingdog.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1043 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<Integer>[] adjList;
    static Set<Integer> truthmember = new HashSet<>();
    static HashSet<Integer>[] party;

    static boolean[] visit;
    static int N,M,ans;
//    static int[] partymember;

    static void dfs(int cur){
        if(visit[cur]) return;
        visit[cur] = true;
        for(int m : adjList[cur]){
            dfs(m);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        adjList = new HashSet[N+1];
        for(int i=1; i<=N; ++i)
            adjList[i] = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        while(st.hasMoreTokens())
            truthmember.add(Integer.parseInt(st.nextToken()));

        party = new HashSet[M];
        for(int i=0; i<M; ++i){
            party[i] = new HashSet<>();
        }

        for(int i=0; i<M; ++i){
            int[] partymember = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j=1; j<partymember[0]+1; ++j){
                party[i].add(partymember[j]);
            }

            int loopcnt = partymember[0];
            for(int j=1; j<loopcnt; ++j){
                for(int k=j+1; k<loopcnt+1; ++k){
                    adjList[partymember[j]].add(partymember[k]);
                    adjList[partymember[k]].add(partymember[j]);
                }
            }
        }


        for(int t: truthmember){
            dfs(t);
        }

        for(int i=1; i<visit.length; ++i){
            if(visit[i]){
                truthmember.add(i);
            }
        }


        l: for(HashSet<Integer> p : party){
            for(int tm : truthmember){
                if(p.contains(tm)){
                    continue l;
                }
            }
            ans++;
        }
//        System.out.println(Arrays.toString(party));


        System.out.println(ans);

    }
}
