package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20410 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m,s,x1,x2;

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); m = rstn(); s = rstn(); x1 = rstn(); x2=rstn();
		outer :for(int a=0; a<m; ++a){
			for(int c=0; c<m; ++c){
				if(x1==(a*s+c)%m && x2==(a*x1+c)%m){
					System.out.printf("%d %d",a,c);
					break outer;
				}
			}
		}

	}
}
