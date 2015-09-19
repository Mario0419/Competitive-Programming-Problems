import java.util.*;

public class seating{
	seating(){
		Scanner input = new Scanner(System.in);

		int  T = input.nextInt();

		for(int cse = 1; cse <= T; cse++){
			int N = input.nextInt();
			int D = input.nextInt();

			int comb = D;
			if(D == 0)
				comb = 1;
			int t = N - 1;
			for(int i = 0; i < N-1; i++){
				comb *= t;
				t--;
			}

			System.out.println("Data set #" + cse + ": " + comb + " combination(s) possible.");
		}
	}
	public static void main(String[] args){
		new seating();
	}
}

/*

3
4 2
5 2
2 2


*/