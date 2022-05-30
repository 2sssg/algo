package barkingdog.x16;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class P23326 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static TreeSet<Integer> goodplace = new TreeSet<>();

    static int N,Q , firstnum, secondnum;
    static long cur;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; ++i){
            if(Integer.parseInt(st.nextToken()) == 1){
                goodplace.add(i);
            }
        }
//        System.out.println(goodplace);
        for(int i=0; i<Q; ++i){
//            bw.write(goodplace.toString()+"\n");
            st = new StringTokenizer(br.readLine());
            firstnum = Integer.parseInt(st.nextToken());
            if(firstnum == 3){
                if(goodplace.size()>0){
                    if(goodplace.ceiling((int)cur+1)!=null){
                        bw.write(String.valueOf(goodplace.ceiling((int)cur+1)-cur-1));
                        bw.write("\n");
                        continue;
                    }
                    bw.write(String.valueOf(goodplace.first()+(N-cur-1)));
                    // 1 + (5-1-1)
                    //
                    bw.write("\n");
                    continue;
                }
                bw.write("-1\n");
                continue;
            }

            if(firstnum == 2){
                cur = (cur+Integer.parseInt(st.nextToken()))%N;
                continue;
            }

            if(firstnum == 1){
                secondnum = Integer.parseInt(st.nextToken());
                if(goodplace.contains(secondnum)){
                    goodplace.remove(secondnum);
                    continue;
                }
                goodplace.add(secondnum);
            }
        }

        bw.flush();
        bw.close();

    }
}
