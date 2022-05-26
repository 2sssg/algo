package barkingdog.x15;

import java.io.*;
import java.util.*;

public class P16165 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String,String> nameMap = new HashMap<>();
    static HashMap<String, List<String>> groupMap = new HashMap<>();
    static List<String> l = new ArrayList<>();
    static int N,M,groupcnt;
    static String group,name;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while(N-->0){
            l = new ArrayList<>();
            group = br.readLine();
            groupcnt = Integer.parseInt(br.readLine());
            for(int i=0; i<groupcnt; ++i){
                name = br.readLine();
                nameMap.put(name,group);
                l.add(name);
            }
            Collections.sort(l);
            groupMap.put(group,l);
        }

        while(M-->0){
            name = br.readLine();
            if(Integer.parseInt(br.readLine())==1){
                bw.write(nameMap.get(name));
                bw.write("\n");
            }else{
                for(String member : groupMap.get(name)){
                    bw.write(member);
                    bw.write("\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
