import java.util.*;

public class cowroute{
	cowroute(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int A= input.nextInt();
			int B = input.nextInt();
			int N = input.nextInt();
			int minCost = Integer.MAX_VALUE;
			int goTo = 2*N;
			for(int i = 0; i < N; i++){
				int C = input.nextInt();
				int number = input.nextInt();

				int[] arr = new int[number];
				for(int j = 0; j < arr.length; j++)
					arr[j] = input.nextInt();

				if(canDo(arr, A, B)){
					if(minCost > C)
						minCost = C;
				}else{
					// minCost = -1;
				}
			}

			if(minCost != Integer.MAX_VALUE)
			System.out.println(minCost);
			else
				System.out.println("-1");
		}
	}

	boolean canDo(int[] arr, int A, int B){

		boolean ans = false;

		for(int i = 0; i < arr.length; i++){
			if(arr[i] == A){
				for(int j = i + 1; j < arr.length; j++){
					if(arr[j] == B)
						return true;
				}
				return false;
			}
		}

		return false;
	}
	public static void main(String[] args){
		new cowroute();
	}
}

/*

1
1 2 3
3 3
3 2 1
4 4
2 1 4 3
8 5
4 1 7 8 2

*/