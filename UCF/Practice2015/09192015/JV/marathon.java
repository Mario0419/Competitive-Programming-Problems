import java.util.*;

public class marathon{
	marathon(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int N = input.nextInt();

			int[][] xy = new int[N][2];
			for(int i = 0; i < N; i++){
				xy[i][0] = input.nextInt();
				xy[i][1] = input.nextInt();

			}

			int totalDistance = 0;

			for(int i = 0; i < N - 1; i++){
				totalDistance += Math.abs(xy[i+1][0] - xy[i][0]) + Math.abs(xy[i+1][1] - xy[i][1]);
			}

			int min = totalDistance;
			for(int i = 1; i < N -1; i++){
				int distLeft = Math.abs(xy[i][0]-xy[i-1][0]) + Math.abs(xy[i][1]-xy[i-1][1]);
				int distRight = Math.abs(xy[i+1][0] - xy[i][0]) + Math.abs(xy[i+1][1] - xy[i][1]);

				int newDist = Math.abs(xy[i+1][0] - xy[i-1][0]) + Math.abs(xy[i+1][1] - xy[i-1][1]);

				if(totalDistance - distRight- distLeft + newDist < min){
					min = totalDistance - distLeft - distRight + newDist;
				}

			}

			System.out.println(min);
		}
	}


	public static void main(String[] args){
		new marathon();
	}
}
/*


2
4
0 0
8 3
11 -1
10 0
3
2 5
1000 1000
2 6


*/