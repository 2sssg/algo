package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1550 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int ans;
    static char[] arr;

    static int change(char c){
        if(c<='9' && c>='0') return c-'0';
        else return c-'A'+10;
    }

    public static void main(String[] args) throws IOException {
        arr = br.readLine().toCharArray();
        int temp = 1;
        for(int i=arr.length-1; i>=0; --i){
            ans += temp*change(arr[i]);
            temp = temp<<4;
        }
//            ans += change(c);

        System.out.println(ans);
    }
}
