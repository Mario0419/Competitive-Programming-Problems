import java.util.*;

public class hotel{

	hotel(){
		Scanner input = new Scanner(System.in);

		while(true){
			int N = input.nextInt();

			if(N == 0) break;

			int h = input.nextInt();
			HashSet<Integer> hotels = new HashSet<Integer>();
			for(int i = 0; i < h; i++){
				int temp = input.nextInt();
				hotels.add(temp - 1);
			}

			int m = input.nextInt();

			int[][] grid = new int[N][N];
			for(int i = 0; i < N; i++)
				for(int j =0; j < N; j++)
					grid[i][j] = 0;
			for(int i = 0; i < m; i++){
				int s = input.nextInt();
				int f = input.nextInt();
				int min = input.nextInt();

				grid[s-1][f-1] = min;
			}
			boolean[] visited = new boolean[N];
			Arrays.fill(visited, false);
			int ans = solve(grid, 0, 0, 600, hotels, visited, hotels.contains(0));
			if(ans == Integer.MAX_VALUE){
				System.out.println("-1");
			}else{
				System.out.println(ans);
			}
		}
	}

	int solve(int[][] grid, int pos, int numStops, int timeLeft, HashSet<Integer> set, boolean[] visited, boolean pastHotel){

		if(pos == grid.length -1){
			return numStops;
		}
		visited[pos] = true;
		int min = Integer.MAX_VALUE;

		for(int i = 0; i < grid.length; i++){

			if(grid[pos][i] != 0 && timeLeft >= grid[pos][i] && !visited[i]){
				if(set.contains(pos))
					pastHotel = true;
				min = Math.min(solve(grid, i, numStops, timeLeft - grid[pos][i], set, visited, pastHotel), min);
				min = Math.min(solve(grid, i, numStops + 1, 600 - grid[pos][i], set, visited, pastHotel), min);

			}else if(grid[pos][i] != 0 && timeLeft < grid[pos][i]){
				if(set.contains(pos) && !visited[i]){
					pastHotel = true;
					min = Math.min(solve(grid, i, numStops + 1, 600 - grid[pos][i], set, visited, pastHotel), min);
					pastHotel = false;
				}
			}
		}


		return min;
	}

	public static void main(String[] args){
		new hotel();
	}
}

/*

6
3 2 5 3
8
1 2 400
3 2 80
3 4 301
4 5 290
5 6 139
1 3 375
2 5 462
4 6 300
3
0
2
1 2 371
2 3 230
2
0
1
1 2 400
3
0
3
1 2 200
2 1 300
2 3 100
3
1 2
2
1 2 400
2 3 400
3
1 1
2
1 2 200
2 3 200
6
1 5
6
1 5 400
5 6 400
1 2 1
2 3 1
3 4 1
4 5 1
4
0
4
1 2 300
2 3 400
3 4 2
2 4 100
4
0
4
1 3 400
3 4 400
1 2 2
2 3 600
0





*/