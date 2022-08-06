package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P2754 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<Character, HashMap<Character,Float>> grade = new HashMap<>();

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		grade.put('A',new HashMap<>());
		grade.put('B',new HashMap<>());
		grade.put('C',new HashMap<>());
		grade.put('D',new HashMap<>());
		grade.get('A').put('+',4.3f);
		grade.get('A').put('0',4.0f);
		grade.get('A').put('-',3.7f);
		grade.get('B').put('+',3.3f);
		grade.get('B').put('0',3.0f);
		grade.get('B').put('-',2.7f);
		grade.get('C').put('+',2.3f);
		grade.get('C').put('0',2.0f);
		grade.get('C').put('-',1.7f);
		grade.get('D').put('+',1.3f);
		grade.get('D').put('0',1.0f);
		grade.get('D').put('-',0.7f);
		String gd = br.readLine();
		if(gd.length()==1){
			System.out.println("0.0");
			System.exit(0);
		}
		System.out.println(grade.get(gd.charAt(0)).get(gd.charAt(1)));


	}
}
