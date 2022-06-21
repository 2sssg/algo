package extra;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018{
    public static void main(String[] args) throws IOException {
        BufferedReader br = Source.getBufferedReader(false);
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int mNum = Integer.parseInt(tk.nextToken());
        int nNum = Integer.parseInt(tk.nextToken());
        char[][] carr = new char[mNum][nNum];
        char[][] b_check = new char[8][8];
        char[][] w_check = new char[8][8];

        for(int i=0;i<mNum;i++) {
            String str = br.readLine();
            carr[i] = str.toCharArray();
        }

        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if(((i%2==0)&&(j%2==0))||((i%2!=0)&&(j%2!=0))) {
                    b_check[i][j]='B';
                    w_check[i][j]='W';
                }
                else   {
                    b_check[i][j]='W';
                    w_check[i][j]='B';
                }
            }
        }
        int start = 0;
        int min = -1;
        while((mNum-8)>=start) {
            int start_j = 0;
            while((nNum-8)>=start_j) {
                int w_count = 0;
                int b_count = 0;
                for(int i=start;i<(start+8);i++) {
                    for(int j=start_j;j<(start_j+8);j++) {
                        if(carr[i][j]!= w_check[i-start][j-(start_j)]) {
                            w_count++;
                        }
                        if(carr[i][j]!= b_check[i-start][j-(start_j)]){
                            b_count++;
                        }
                    }
                }
                if(((w_count<b_count) && (w_count<min))|| min==-1) {
                    min = w_count;
                }
                if(((b_count<w_count) && (b_count<min)) || min==-1) {
                    min = b_count;
                }
                start_j++;
            }
            start++;
        }
        System.out.println(min);
    }
}

