import java.util.*;

public class cowjog{
	cowjog(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int N = input.nextInt();

			int[][] arr = new int[N][2];

			for(int i = 0; i < N; i++){
				arr[i][0] = input.nextInt();
				arr[i][1] = input.nextInt();
			}

			int numGroups = 0;

			numGroups = 1;
			int min = arr[N-1][1];
			for(int i = N-2; i >= 0; i--){
				if(arr[i][1] <= min)
					numGroups++;
				if(arr[i][1] < min)
					min = arr[i][1];
			}
			System.out.println(numGroups);
		}
	}

	public static void main(String[] args){
		new cowjog();
	}
}
/*

2
5
0 1
1 2
2 3
3 2
6 1
4
2 1
10 2
20 3
30 3



*/