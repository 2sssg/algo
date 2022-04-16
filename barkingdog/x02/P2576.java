package barkingdog.x02;

import java.io.*;

public class P2576 {
    static int min,cnt,sum,current;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        min = 101;
        for(int i=0; i<7; i++){
            current = Integer.parseInt(br.readLine());
//            if(current%2 != 1) continue;
//            min = Math.min(min,current);
//            cnt++;
//            sum += current;
            //비트연산자 활용
            if((current & 1) == 1){
                min = Math.min(min,current);
                cnt++;
                sum += current;
            }
        }
        bw.write(cnt>0?String.valueOf(sum):"-1");
        bw.write("\n");
        bw.write(cnt>0?String.valueOf(min):"");
        bw.flush();
        bw.close();
    }
}
