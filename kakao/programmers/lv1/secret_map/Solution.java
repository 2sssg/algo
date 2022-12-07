package kakao.programmers.lv1.secret_map;

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for(int i = 0; i < n; ++i) {

//			String replace = String.format("%" + n + "s",Integer.toBinaryString(arr1[i] | arr2[i]).replace("1", "#").replace("0", " "));
			answer[i] = String.format("%" + n + "s",Integer.toBinaryString(arr1[i] | arr2[i]).replace("1", "#").replace("0", " "));
		}
		return answer;
	}
//	"#####","##  #","#  ##","#### ","#####","## # "
//	"######","###  #","##  ##"," #### "," #####","### # "
}
