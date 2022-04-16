package class2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LanCut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int flag=0;
        int N,K,centi,tempcenti,lancount;
        int[] lanArr;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lanArr = new int[K];
        centi = 0;
        for(int i=0; i<K; i++){
            tempcenti = Integer.parseInt(br.readLine());
            centi += tempcenti/N;
            lanArr[i] = tempcenti;
        }

        while(true){
            lancount=0;
            for(int i=0; i<K; i++){
                lancount += lanArr[i]/centi;
            }
            if (lancount >= N) {
                if(flag==2){
                    System.out.println(centi);
                    break;
                }
                flag = 1;
                centi++;
            }else{
                if(flag==1){
                    System.out.println(--centi);
                    break;
                }
                flag = 2;
                centi--;
            }
        }




    }
}
