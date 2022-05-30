package barkingdog.x16;

import java.io.*;
import java.util.*;

public class P21939 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<Integer,Integer> nAd = new HashMap<>();
    static TreeMap<Integer, TreeSet<Integer>> dAn = new TreeMap<>();
    static int N,M;
    static int behavnum1,behavnum2;
    static String behavior;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            behavnum1 = Integer.parseInt(st.nextToken());
            behavnum2 = Integer.parseInt(st.nextToken());
            nAd.put(
                    behavnum1,
                    behavnum2
            );
            TreeSet<Integer> tempTreeSet;
            tempTreeSet = dAn.getOrDefault(behavnum2,new TreeSet<>());
            tempTreeSet.add(behavnum1);
            dAn.put(behavnum2,tempTreeSet);
        }

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            behavior = st.nextToken();

            if(behavior.equals("add")){
                behavnum1 = Integer.parseInt(st.nextToken());
                behavnum2 = Integer.parseInt(st.nextToken());
                //해당 문제가 이미 있던거면
                if(nAd.containsKey(behavnum1)){
                    //원래 난이도에서 문제를 지우고
                    dAn.get(nAd.get(behavnum1)).remove(behavnum1);
                    //문제에대한 난이도 갱신하고
                    nAd.put(behavnum1,behavnum2);
                    //난이도에 문제 넣기
                    dAn.get(behavnum2).add(behavnum1);
                }
                //해당 문제가 없던거라면
                else{
                    // 문제에 난이도 넣고
                    nAd.put(behavnum1,behavnum2);
                    //해당 난이도가 있으면
                    if(dAn.containsKey(behavnum2)){
                        dAn.get(behavnum2).add(behavnum1);
                    }
                    //해당 난이도가 없으면
                    else{
                        TreeSet<Integer> tempTreeSet = new TreeSet<>();
                        tempTreeSet.add(behavnum1);
                        dAn.put(behavnum2,tempTreeSet);
                    }
                }
                continue;
            }

            if(behavior.equals("recommend")){
                behavnum1 = Integer.parseInt(st.nextToken());
                //어려운 문제 + 가장 문제번호 높은거
                if(behavnum1==1){
                    //int형임
                    bw.write(String.valueOf(dAn.lastEntry().getValue().last()));
                    bw.write("\n");
                }
                //쉬운문제 + 문제번호 가장 낮은거
                else{
                    //int형임
                    bw.write(String.valueOf(dAn.firstEntry().getValue().first()));
                    bw.write("\n");
                }
                continue;
            }

            // solved
            //문제 번호
            behavnum1 = Integer.parseInt(st.nextToken());

            //문제에 대한 난이도를 구해서 그 난이도로 검색을 한 후 문제번호 삭제
            dAn.get(nAd.get(behavnum1)).remove(behavnum1);
            if(dAn.get(nAd.get(behavnum1)).size()==0){
                dAn.remove(nAd.get(behavnum1));
            }
            //문제번호 삭제
            nAd.remove(behavnum1);

        }
        bw.flush();
        bw.close();
    }
}
