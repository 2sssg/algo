package class3;

import java.io.*;
import java.util.Arrays;

public class RemoteController {
    static int targetChannel, breakButtonCount,minus,plus,nowChannel,overNum,underNum,originindex,underindex,overindex;
    static int[] breakButtonArr,buttonArr,valueArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        valueArr = new int[4];
        nowChannel = 100;
        overNum = 1;
        underNum = 1;
        sb.append("1");
        targetChannel = Integer.parseInt(br.readLine());
        for(int i=0; i<String.valueOf(targetChannel).length(); i++){
            sb.append("0");
        }
        overNum = Integer.parseInt(sb.toString());
        sb.setLength(0);
        for(int i=0; i<String.valueOf(targetChannel).length()-1; i++){
            sb.append("9");
        }
        if(sb.length()==0){
            underNum = 0;
        }else{
            underNum = Integer.parseInt(sb.toString());
        }
        sb.setLength(0);
        breakButtonCount = Integer.parseInt(br.readLine());
        if(breakButtonCount == 0) bw.write(String.valueOf(String.valueOf(targetChannel).length()));
        else if(breakButtonCount == 10) bw.write(String.valueOf(Math.abs(targetChannel-100)));
        else{
            breakButtonArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            buttonArr = new int[10];
            Arrays.fill(buttonArr,1);

            for(int bt: breakButtonArr){
                buttonArr[bt] = 0;
            }
            sb.setLength(0);
            for(String num: String.valueOf(targetChannel).split("")){
                sb.append(f(Integer.parseInt(num)));
            }
            originindex = Integer.parseInt(sb.toString());
            sb.setLength(0);
            for(String num: String.valueOf(overNum).split("")){
                sb.append(f(Integer.parseInt(num)));
            }
            overindex = Integer.parseInt(sb.toString());
            sb.setLength(0);
            for(String num: String.valueOf(underNum).split("")){
                sb.append(f(Integer.parseInt(num)));
            }
            underindex = Integer.parseInt(sb.toString());
            sb.setLength(0);

            //100에서 바로 이동값
            valueArr[0] = Math.abs(targetChannel-nowChannel);
            //under에서 이동값
            valueArr[1] = String.valueOf(underindex).length() +targetChannel-underindex;
            //over에서 이동값
            valueArr[2] = String.valueOf(overindex).length() +overindex-targetChannel;
            //origin에서 이동값
            valueArr[3] = String.valueOf(originindex).length() +Math.abs(originindex-targetChannel);
            int min = valueArr[0];
            int minIndex = 0;

            for (int i = 0; i < 4; i++) {
                if (valueArr[i] < min) {
                    min = valueArr[i];
                    minIndex = i;
                }
            }
            System.out.println(originindex);
            bw.write(String.valueOf(valueArr[minIndex]));
        }

        bw.flush();
        bw.close();
    }

    public static int f(int num){
        if(buttonArr[num]==1){
            return num;
        }else{
            minus = mf(num-1);
            plus = pf(num+1);
            if(minus<0) return plus;
            else if(plus>9) return minus;
            return num-minus > plus - num?plus:minus;
        }
    }
    public static int mf(int num){
        if(num<0) return -99999;
        if(buttonArr[num]==1) return num;
        return mf(num-1);
    }
    public static int pf(int num){
        if(num>9) return 99999;
        if(buttonArr[num]==1) return num;
        return pf(num+1);

    }
}
