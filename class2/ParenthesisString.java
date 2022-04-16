package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesisString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        String[] parenthesis;
        Stack<String> parStack;
        N = Integer.parseInt(br.readLine());
        l:for(int i=0; i<N; i++){
            parStack = new Stack<>();
            parenthesis = br.readLine().split("");
            for(String pa: parenthesis){
                if(pa.equals("(")){
                    parStack.push("(");
                }else{
                    if(parStack.isEmpty()){
                        System.out.println("NO");
                        continue l;
                    }else{
                        parStack.pop();
                    }
                }
            }
            if(parStack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
