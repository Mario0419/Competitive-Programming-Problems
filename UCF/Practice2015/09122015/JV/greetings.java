import java.util.*;

public class greetings{

	greetings(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int B = input.nextInt();
			int E = input.nextInt();

			int[] b = new int[B];
			int[] e = new int[E];
			int sumB = 0;
			int sumE = 0;
			for(int i = 0; i < b.length; i++){
				int temp = input.nextInt();
				String d = input.next();

				if(d.equals("L"))
					temp *= -1;
				b[i] = temp;
				sumB += Math.abs(b[i]);
			}

			for(int i = 0; i < e.length; i++){
				int temp = input.nextInt();
				String d = input.next();
				if(d.equals("L"))
					temp *= -1;
				e[i] = temp;
				sumE += Math.abs(e[i]);
			}

			int max = Math.max(sumB, sumE);
			b = getTime(b, max);
			e = getTime(e, max);

			int ans = 0;

			for(int i = 1; i < e.length && i < b.length; i++){
				if(b[i] == e[i] && b[i-1] != e[i-1])
					ans++;
			}
			System.out.println(ans);
		}
	}

	int[] getTime(int[] array, int value){

		int[] arr = new int[value + 1];
		int index = 1;

		for(int i = 0; i < array.length; i++){
			int step = array[i] > 0 ? 1 : -1;
			for(int j = 0; j < Math.abs(array[i]); j++, index++)
				arr[index] = arr[index-1] + step;
		}

		while(index < arr.length){
			arr[index] = arr[index-1];
			index++;
		}
		return arr;


	}

	public static void main(String[] args){
		new greetings();
	}
}