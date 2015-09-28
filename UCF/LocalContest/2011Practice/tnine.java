import java.util.*;


public class tnine{

	tnine(){
		HashMap<String, String> t9 = new HashMap<String, String>();
		t9.put("a", "2");
		t9.put("b", "22");
		t9.put("c", "222");
		t9.put("d", "3");
		t9.put("e", "33")
		t9.put("f", "333");
		t9.put("g", "4");
		t9.put("h", "44");
		t9.put("i", "444");
		t9.put("j", "5");
		t9.put("k", "55");
		t9.put("l", "555");
		t9.put("m", "6");
		t9.put("n", "66");
		t9.put("o", "666");
		t9.put("p", "7");
		t9.put("q", "77");
		t9.put("r", "777");
		t9.put("s", "7777");
		t9.put("t", "8");
		t9.put("u", "88");
		t9.put("v", "888");
		t9.put("w", "9");
		t9.put("x", "99");
		t9.put("y", "999");
		t9.put("z", "9999");

		Scanner input = new Scanner(System.in);

		int N = Integer.parseInt(input.nextLine());

		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for(int i = 0; i < N; i++){
			String word = input.nextLine();
			String num = calc(word, t9);
			System.out.println(num);
			if(!map.containsKey(num)){
				ArrayList<String> lst = new ArrayList<String>();
				lst.add(word);
				map.put(num, lst);
			}else{
				ArrayList<String> t = map.get(num);
				t.add(word);
				map.remove(num);
				map.put(num, t);
			}
			
		}

		int T = Integer.parseInt(input.nextLine());

		for(int cse = 1; cse <= T; cse++){
			String[] message = input.nextLine().split(" ");

			String mess = "";
			int numMessages = 1;

			for(int i = 0; i < message.length; i++){
				if(map.containsKey(message[i])){
					if(map.get(message[i]).size() > 1)
						numMessages *= map.get(message[i]).size();
					else{
						mess += map.get(message[i]).get(0) + " ";
					}
				}else{
					numMessages = 0;
				}
			}

			if(numMessages == 0){
				System.out.println("Message #" + cse + ": not a valid text");
			}else if(numMessages == 1){
				System.out.println("Message #" + cse + ": " + mess);
			}else{
				System.out.println("Message #" + cse + ": there are " + numMessages + " possible messages");
			}
			System.out.println();
		}



	}

	String calc(String word, HashMap<String,String> t9){
		String num = "";
		for(int i = 0; i < word.length(); i++){
			num += t9.get(word.charAt(i) + "");
		}
		return num;
	}


	public static void main(String[] args){
		new tnine();
	}
}
/*

11
hello
good
i
a
went
to
the
beach
cool
read
book
3
4 9368 86 843 23224
4 7323 2 2665 2665
8447 47 843 5278 8378 2273



*/