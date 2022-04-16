package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BitonicSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,curNum,left,right,leftArrLen, rightArrLen,max;
        int[] sequence,leftarr, rightarr,leftanswer, rightanswer;

        //////////////////////////////////

        N = Integer.parseInt(br.readLine());
        sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        max = -1;
        for(int i=0; i<N; i++){
            curNum = sequence[i];
            int finalCurNum = curNum;
            leftarr = Arrays.stream(Arrays.copyOfRange(sequence,0,i)).filter(p-> p< finalCurNum).toArray();
            rightarr = Arrays.stream(Arrays.copyOfRange(sequence,i+1,N)).filter(p -> p<finalCurNum).toArray();
            if(leftarr.length == 0){
                left = 0;
            }else{
                leftArrLen = leftarr.length;
                leftanswer = new int[leftArrLen];
                leftanswer[0] = 1;
                for(int j=1; j<leftArrLen; j++){
                    left = 1;
                    for(int k=j; k>=0; k--){
                        if(leftarr[j]>leftarr[k]){
                            left = Math.max(left,leftanswer[k]+1);
                        }
                    }
                    leftanswer[j] = left;
                }
                left = Arrays.stream(leftanswer).max().getAsInt();
            }

            if(rightarr.length == 0){
                right = 0;
            }else{
                rightArrLen = rightarr.length;
                rightanswer = new int[rightArrLen];
                rightanswer[0] = 1;
                for(int j=rightArrLen-1; j>=0; j--){
                    right = 1;
                    for(int k=j; k<rightArrLen; k++){
                        if(rightarr[k]<rightarr[j]){
                            right = Math.max(right,rightanswer[k]+1);
                        }
                    }
                    rightanswer[j] = right;
                }
                right = Arrays.stream(rightanswer).max().getAsInt();
            }

            max = Math.max(max,left+right+1);
        }

        System.out.println(max);
    }
}
