package barkingdog.x16;


import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class P21944 {
    static class Pair{
        int L; int G;

        public Pair(int l, int g) {
            L = l;
            G = g;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "L=" + L +
                    ", G=" + G +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    // 난이도, 분류, 문제번호
    static HashMap<Integer, TreeMap<Integer,TreeSet<Integer>>> GLP = new HashMap<>();
    //난이도 , 문제번호
    static TreeMap<Integer,TreeSet<Integer>> LP = new TreeMap<>();
    //문제번호, 난이도, 알고리즘
    static HashMap<Integer,Pair> PLG = new HashMap<>();

    static int N,P,L,G,M,num;
    static String doing;

    static void pushProb(){
        if(!GLP.containsKey(G)){
            TreeMap<Integer,TreeSet<Integer>> temp = new TreeMap<>();
            TreeSet<Integer> temp2 = new TreeSet<>();
            temp2.add(P);
            temp.put(L,temp2);
            GLP.put(G,temp);
        }else if(!GLP.get(G).containsKey(L)){
            TreeSet<Integer> temp2 = new TreeSet<>();
            temp2.add(P);
            GLP.get(G).put(L,temp2);
        }else{
            GLP.get(G).get(L).add(P);
        }

        if(LP.containsKey(L)){
            LP.get(L).add(P);
        }else{
            TreeSet<Integer> temp = new TreeSet<>();
            temp.add(P);
            LP.put(L,temp);
        }

        PLG.put(P,new Pair(L,G));
    }

    static void deleteProb(){
        if(GLP.get(G).get(L).size()==1){
            if(GLP.get(G).size() == 1){
                GLP.remove(G);
            }else{
                GLP.get(G).remove(L);
            }
        }else{
            GLP.get(G).get(L).remove(P);
        }

        if(LP.get(L).size()==1){
            LP.remove(L);
        }else{
            LP.get(L).remove(P);
        }

        PLG.remove(P);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            pushProb();
        }

//        System.out.println("GLP : " + GLP);
//        System.out.println("LP : " + LP);
//        System.out.println("PLG : " + PLG);
//        System.out.println();
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; ++i){

            st = new StringTokenizer(br.readLine());
            doing = st.nextToken();

            if(doing.equals("recommend")){
                G = Integer.parseInt(st.nextToken());
                num = Integer.parseInt(st.nextToken());
                if(num==1){
                    bw.write(String.valueOf(GLP.get(G).lastEntry().getValue().last()));
                }else{
                    bw.write(String.valueOf(GLP.get(G).firstEntry().getValue().first()));
                }
                bw.write("\n");
                continue;
            }

            if(doing.equals("recommend2")){
                num = Integer.parseInt(st.nextToken());
                if(num==1){
                    bw.write(String.valueOf(LP.lastEntry().getValue().last()));
                }else{
                    bw.write(String.valueOf(LP.firstEntry().getValue().first()));
                }
                bw.write("\n");
                continue;
            }

            if(doing.equals("recommend3")){
                num = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                if(num==1){
                    if(LP.ceilingEntry(L)!=null){
                        bw.write(String.valueOf(LP.ceilingEntry(L).getValue().first()));
                        bw.write("\n");
                    }else{
                        bw.write("-1\n");
                    }
                }else{
                    if(LP.floorEntry(L)!= null){
                        bw.write(String.valueOf(LP.floorEntry(L).getValue().last()));
                        bw.write("\n");
                    }else{
                        bw.write("-1\n");
                    }
                }
                continue;
            }

            if(doing.equals("add")){
                P = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                G = Integer.parseInt(st.nextToken());
                if (PLG.containsKey(P)) {
                    int templ  = L;
                    int tempg = G;
                    L = PLG.get(P).L;
                    G = PLG.get(P).G;
                    deleteProb();
                    L = templ;
                    G = tempg;
                }
//                System.out.println("GLP : " + GLP);
//                System.out.println("LP : " + LP);
//                System.out.println("PLG : " + PLG);
//                System.out.println();
                pushProb();
//                System.out.println("GLP : " + GLP);
//                System.out.println("LP : " + LP);
//                System.out.println("PLG : " + PLG);
//                System.out.println();
                continue;
            }

            //solved
            P = Integer.parseInt(st.nextToken());
            L = PLG.get(P).L;
            G = PLG.get(P).G;
            deleteProb();
        }


        bw.flush();
        bw.close();





    }
}


//5
//1000 1 1
//1001 2 1
//19998 78 2
//2667 37 3
//2042 55 3
//10
//add 10 1 1
//add 123 55 3
//recommend 1 1
//recommend 1 -1
//recommend 3 1
//recommend 3 -1
//recommend2 1
//recommend2 -1
//recommend3 1 54
//recommend3 -1 54
