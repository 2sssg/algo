package extra;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gagyeboo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N,Q;
        int[] moneyChange;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());


        moneyChange = new int[N+1];
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "1":
                    moneyChange[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
                    break;
                case "2":
//                    bw.write(String.valueOf(Arrays.stream(Arrays.copyOfRange(moneyChange,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())+1)).sum()));
//                    bw.write(Arrays.toString(Arrays.copyOfRange(moneyChange,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())+1)));
                    bw.write(st.nextToken());
                    bw.write("\n");
                    bw.write(st.nextToken());
                    bw.write("\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
