import java.util.*;

public class minion{
	minion(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int N = input.nextInt();

			HashSet<String> set = new HashSet<>();
			for(int i = 0; i < N; i++)
				set.add(input.next());

			N = input.nextInt();
			int M = input.nextInt();

			int[][] arr = new int[N][N];

			for(int i = 0; i < M; i++){
				int s = input.nextInt();
				int f = input.nextInt();
				String conn = input.next();

				if(set.contains(conn))
					continue;

				arr[s][f] = 1;
			}

			if(solve(arr, 0)){
				System.out.println("1");
			}else{
				System.out.println("0");
			}
		}
	}

	boolean solve(int[][] arr, int pos){

		if(pos == arr.length-1)
			return true;


		for(int i = 0; i < arr.length; i++){
			if(arr[pos][i] == 1){
				boolean solved = solve(arr, i);
				if(solved)
					return true;
			}
		}

		return false;
	}
	public static void main(String[] args){
		new minion();
	}
}

/*

2
3
stairs
talking
staring
4 5
0 3 talking
0 1 abc
0 2 xyz
1 3 stairs
2 3 staring
3
fire
water
people
4 5
0 1 abc
0 2 water
1 2 fire
1 3 xyz
2 3 abc

*/