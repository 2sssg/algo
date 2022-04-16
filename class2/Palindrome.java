package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] pal = br.readLine().split("");
            if(String.join("",pal).equals("0")){
                break;
            }else if(pal.length==1){
                System.out.println("yes");
                continue;
            }
            int len = pal.length;
            String[] leftpal = Arrays.copyOfRange(pal,0,len/2);
            String[] rightpal;
            if(len%2 == 1){
                rightpal = Arrays.copyOfRange(pal,len/2+1,pal.length);
            }else{
                rightpal = Arrays.copyOfRange(pal,len/2,pal.length);
            }
            List<String> list = Arrays.asList(rightpal);
            Collections.reverse(list);
            String tmp = String.join("",list);
            String temp = String.join("",leftpal);
            System.out.println(tmp.equals(temp)?"yes":"no");
        }

    }
}
