import java.util.*;

/*
completed
*/

public class isograms{
	isograms(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			String word = input.next();
			HashMap<String, Integer> map = new HashMap<>();
			for(int i = 0; i < word.length(); i++){
				if(map.containsKey(word.charAt(i)+"")){
					int curr = map.get(word.charAt(i)+"");
					curr++;
					map.put(word.charAt(i) +"", curr);
				}else{
					map.put(word.charAt(i) + "", 1);
				}
			}

			if(isIso(map)){
				System.out.println(word + " --- " + "pair iosgrams");
			}else{
				System.out.println(word + " --- " + "not pair iosgrams");
			}
			System.out.println();
		}
	}

	boolean isIso(HashMap<String, Integer> map){

		for(String key : map.keySet()){
			if(map.get(key) != 2)
				return false;
		}
		return true;

	}

	public static void main(String[] args){
		new isograms();
	}
}

/*
3
teammate
ali
dood

*/