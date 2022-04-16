package extra;

import java.io.*;

public class Me {
    static int devideNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T,num;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            num = Integer.parseInt(br.readLine());
            makeDevideNum(String.valueOf(num).length());
            bw.write(num*num%devideNum == num?"YES\n":"NO\n");
        }
        bw.flush();
        bw.close();

    }

    public static void makeDevideNum(int len){
        devideNum = 1;
        for(int i=0; i<len; i++){
            devideNum *= 10;
        }
    }
}
