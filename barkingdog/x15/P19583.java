package barkingdog.x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P19583 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashSet<String> hs1 = new HashSet<>();
    static HashSet<String> hs2 = new HashSet<>();
    static String S,E,Q,timetemp,name;
    static int intS,intE,intQ,curtime;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        E = st.nextToken();
        Q = st.nextToken();
        intS = Integer.parseInt(S.split(":")[0])*60+Integer.parseInt(S.split(":")[1]);
        intE = Integer.parseInt(E.split(":")[0])*60+Integer.parseInt(E.split(":")[1]);
        intQ = Integer.parseInt(Q.split(":")[0])*60+Integer.parseInt(Q.split(":")[1]);
        while(true){
            try{
                st = new StringTokenizer(br.readLine());
                timetemp = st.nextToken();
            }catch(Exception e){
                break;
            }
            curtime = Integer.parseInt(timetemp.split(":")[0])*60+Integer.parseInt(timetemp.split(":")[1]);
            name = st.nextToken();
            if(curtime<=intS){
                hs1.add(name);
            }else if(intE<=curtime&&curtime<=intQ){
                if(hs1.contains(name)){
                    hs2.add(name);
                }
            }
        }
        System.out.println(hs2.size());

    }
}
