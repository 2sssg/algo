package extra;

import Constant.Source;

import java.io.*;
import java.util.StringTokenizer;

public class P4101 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int num1,num2;
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        while(true){
            st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            if(num1 ==0 && num2==0){
                break;
            }
            bw.write(num1>num2?"Yes\n":"No\n");
        }
        bw.flush();
        bw.close();
    }
}
