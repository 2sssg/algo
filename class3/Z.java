package class3;

import java.io.*;
import java.util.StringTokenizer;

public class Z {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N,r,c;
        // r : 행
        // c : 열
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(findLocation((int) Math.pow(2,N), c, r, 0));
    }


    public static int findLocation(int flagNum,int r,int c, int location){
        // 2x2사각형이면 리턴
        if(flagNum/2 == 1){
            if(r == 0 && c == 0){
                return location;
            }else if(r == 0 && c == 1){
                return location +2;
            }else if(r == 1 && c == 0){
                return location +1;
            }else if(r == 1 && c == 1){
                return location +3;
            }
        }

        flagNum /= 2;
        // 1 2
        // 3 4
        // 방문이라고 칠때
        // 몇번째 사각형에 있는지

        //1
        if(r<flagNum && c<flagNum){
        }
        //2
        else if(r>= flagNum && c< flagNum){
            r -= flagNum;
            location += flagNum*flagNum;
        }
        //3
        else if(r<flagNum && c>= flagNum){
            c -= flagNum;
            location += 2*(flagNum*flagNum);
        }
        //4
        else if(r>=flagNum && c >= flagNum){
            r -= flagNum;
            c -= flagNum;
            location += 3*(flagNum*flagNum);
        }
        return findLocation(flagNum,r,c,location);

    }
}
