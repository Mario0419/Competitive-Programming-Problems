import java.util.*;

public class paths{
	paths(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 1; cse <= T; cse++){
			int N = input.nextInt();

			int[][] avoid = new int[N][2];
			System.out.println("Data Set " + cse + ":");
			System.out.println();

			
			int[][] adj = new int[10][10];

			


			for(int i = 0; i < N; i++){
				avoid[i][0] = input.nextInt();
				avoid[i][1] = input.nextInt();

			}

			N = input.nextInt();

			for(int i = 0; i < avoid.length; i++){
				adj[avoid[i][0]][avoid[i][1]] = -1;
			}

			for(int i = 0; i < N; i++){
				int sx = input.nextInt();
				int sy = input.nextInt();

				int fx = input.nextInt();
				int fy  = input.nextInt();

				int dx = (fx-sx);

				int dy = (fy-sy);

				if(dx < 0)
					dx = -1;
				else if(dx > 0)
					dx = 1;
				if(dy < 0)
					dy = -1;
				else if(dy > 0)
					dy = 1;
				int numPaths = path(adj, sx, sy, fx, fy, dx, dy);
				if(numPaths != 1)
				System.out.println("  Test Case " + (i + 1) + ": Nick can take " + numPaths + " perfect paths.");
				else
					System.out.println("  Test Case " + (i + 1) + ": Nick can take " + numPaths + " perfect path.");

			}
			System.out.println();



		}
	}

	int path(int[][] adj, int x, int y, int fx, int fy, int dx, int dy){

		if(!inBounds(adj, x, y))
			return 0;
		if(adj[x][y] == -1)
			return 0;
		if(x == fx && y == fy)
			return 1;


		int count = 0;
		if(dx != 0)
		count += path(adj, x + dx, y, fx, fy, dx, dy);
		if(dy != 0)
		count += path(adj, x, y + dy, fx, fy, dx, dy);
		return count;

	}

	boolean inBounds(int[][] adj, int x, int y){
		if(x < 0 || x >= 10 || y < 0 || y >= 10)
			return false;
		return true;
	}

	public static void main(String[] args){
		new paths();
	}
}


/*

2
4
2 2
3 5
1 0
4 4
5
0 0 1 9
0 1 2 3
2 1 0 5
0 1 4 5
0 0 0 0
3
1 1
2 2
3 3
1
4 4 9 7





*/