package If;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ThreeDice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dicevalue;
        int value;
        String diceNum;
        StringTokenizer st;
        HashMap<String,Integer> dicemap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            diceNum = st.nextToken();
            if(dicemap.containsKey(diceNum)){
                dicemap.put(diceNum, dicemap.get(diceNum)+1);
            }else if(!dicemap.containsKey(diceNum)){
                dicemap.put(diceNum, 1);
            }
        }
        dicevalue = dicemap.keySet().stream().mapToInt(Integer::parseInt).toArray();
        value = 0;
        if(dicemap.size() == 1){
            value = dicevalue[0]*1000 + 10000;
        }else if(dicemap.size() == 2){
            for(int i = 0; i<2; i++){
                if(dicemap.get(String.valueOf(dicevalue[i]))!=1){
                    value = dicevalue[i]*100 + 1000;
                }
            }
        }else {
            value = Arrays.stream(dicevalue).max().getAsInt() * 100;
        }

        bw.write(String.valueOf(value));
        bw.flush();
        bw.close();

    }

}
