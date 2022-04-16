package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileFind {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(br.readLine());
        }else{
            String[] line = new String[n];
            char[][] arr = new char[n][51];
            int length = 0;
            for(int i=0;i<n;i++) {
                line[i] = br.readLine();
                length=line[i].length();
                for(int j=0;j<line[i].length();j++) {
                    arr[i][j] = line[i].charAt(j);
                }
            }
            //1. i번째 단어의 j번째 char가 모두 같은가? 판별
            //2. 모두 같으면 result[i]에 넣는다.
            char[] result = new char[length];

            for(int i=0;i<length;i++) {
                for(int j=1;j<n;j++) {
                    if(arr[j][i]==arr[j-1][i]) {
                        if(j==n-1) {
                            result[i]=arr[j][i];
                        }
                    }else
                        break;
                }
            }

            for(int i=0;i<length;i++) {
                if(result[i]!=0) {
                    System.out.print(result[i]);
                }else if(result[i]==0) {
                    System.out.print('?');
                }
            }
        }


    }

}
