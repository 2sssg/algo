package barkingdog.x0C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static boolean chk(int idx){
        return arr[idx] == 'a' || arr[idx] == 'e' || arr[idx] == 'i' || arr[idx] == 'o' || arr[idx] == 'u';
    }
    static void func(int depth,int cur) throws IOException {
        if(depth==L){
            if(isAvailable>0 && isAvailable2>1){
                for(int i=0; i<C; ++i){
                    if(isUsed[i]==1){
                        bw.write(String.valueOf((char)arr[i]));
                    }
                }
                bw.write("\n");
            }
            return;
        }
        for(int i=cur; i<C; ++i){
            if(isUsed[i] == 0){
                isUsed[i]=1;
                if(chk(i)){
                    isAvailable++;
                    func(depth+1, i+1);
                    isAvailable--;
                }else{
                    isAvailable2++;
                    func(depth+1,i+1);
                    isAvailable2--;
                }
                isUsed[i]=0;
            }
        }
    }

    static int L,C,isAvailable,isAvailable2;
    static int[] arr,isUsed;

    public static void main(String[] args) throws IOException {
        est(); L=rstn(); C=rstn();
        arr = new int[C];
        isUsed = new int[C];
        est();
        for(int i=0; i<C; ++i) arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);
        func(0,0);
        bw.flush();
        bw.close();

    }
}
