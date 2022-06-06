package barkingdog.x1A;


import java.io.*;
import java.util.*;

public class P21276 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String, Set<String>> adjList = new HashMap<>();
    static HashMap<String,Integer> indegree = new HashMap<>();
    static TreeMap<String,TreeSet<String>> result = new TreeMap<>();
    static Set<String> parent = new TreeSet<>();
    static Queue<String> q = new ArrayDeque<>();

    static int V,E;
    static String name1,name2;
    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            name1 = st.nextToken();
            adjList.put(name1,new TreeSet<>());
            indegree.put(name1,0);
            result.put(name1, new TreeSet<>());
        }

        E = Integer.parseInt(br.readLine());
        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            name1= st.nextToken();
            name2= st.nextToken();
            adjList.get(name2).add(name1);
            indegree.put(name1, indegree.get(name1)+1);
        }

        for(Map.Entry<String,Integer> en : indegree.entrySet()){
            if(en.getValue()==0){
                parent.add(en.getKey());
            }
        }
        bw.write(String.valueOf(parent.size()));
        bw.write("\n");
        bw.write(parent.toString().replaceAll("[\\[\\],]",""));
        bw.write("\n");
        for(String par : parent){
            q.add(par);
            while(!q.isEmpty()){
                name1 = q.poll();
                for(String next : adjList.get(name1)){
                    if(indegree.get(next)==1){
                        q.add(next);
                        result.get(name1).add(next);
                    }else{
                        indegree.put(next,indegree.get(next)-1);
                    }
                }
            }
        }

        for(Map.Entry<String,TreeSet<String>> en : result.entrySet()){
            bw.write(en.getKey());
            bw.write(" ");
            bw.write(String.valueOf(en.getValue().size()));
            bw.write(" ");
            bw.write(en.getValue().toString().replaceAll("[\\[\\],]",""));
            bw.write("\n");
        }

        bw.flush();
        bw.close();



    }
}
