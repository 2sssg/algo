package koala.preparation.week2.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P19949 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] answer;
	static int[] myAnswer = new int[10];
	static int Panswer = 0;

	static int score(){
		int score = 0;
		for(int i=0; i<10; ++i)
			if(answer[i]==myAnswer[i])
				score++;
		return score;
	}

	static void f(int depth){
		if(depth==10){
			if(score()>=5){
				Panswer++;
			}
			return;
		}
		for(int i=1; i<6; ++i){
			if(depth>1 && !(myAnswer[depth-1]==i && myAnswer[depth-2]==i)){
				myAnswer[depth] = i;
				f(depth+1);
			}
			else if(depth<=1){
				myAnswer[depth] = i;
				f(depth+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		f(0);
		System.out.println(Panswer);
	}
}
